param([string]$ToolPath)
$ErrorActionPreference = "Stop"

function Assert-SuccessExitCode($errorMessage) {
    if ($LASTEXITCODE -ne 0) {
        throw $errorMessage
    }
}

try {

	if ([String]::IsNullOrEmpty($ToolPath)) {
		Write-Host ("Syntax: {0} [-ToolPath] <swagger-codegen path>" -f $MyInvocation.MyCommand.Name)
		exit 1
	}

	Write-Host ">>> Initializing ..."

	$toolJarPath = Resolve-Path ($ToolPath + "\modules\swagger-codegen-cli\target\swagger-codegen-cli.jar")
	$tempDir = ("{0}\{1}" -f $env:TEMP, [Guid]::NewGuid())

	Write-Host ">>> Generating code ..."

	&java -jar $toolJarPath generate -i https://homolog.core.pki.rest/swagger/api/swagger.json -l java -c swagger-codegen-config.json -o $tempDir
	Assert-SuccessExitCode "Swagger codegen failed"
	
	Write-Host ">>> Customizing classes ..."

	$encoding = New-Object System.Text.UTF8Encoding $false
	ls $tempDir -filter *.java -recurse | foreach {
		$content = [System.IO.File]::ReadAllText($_.Fullname, $encoding)
		$content = $content.Replace("public class", "@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)`npublic class")
		[System.IO.File]::WriteAllText($_.Fullname, $content, $encoding)
	}
	
	Write-Host ">>> Copying classes to project ..."

	Copy-Item ("{0}\*" -f $tempDir) . -Recurse -Force
	
	Write-Host ">>> Doing some housekeeping ..."

	Remove-Item $tempDir -Recurse -Force
	
	Write-Host ">>> Done."

} catch {

	Write-Error ("Error: " + $_)
	exit 2
	
}
