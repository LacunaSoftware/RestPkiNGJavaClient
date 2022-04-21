param([string]$ToolPath)
$ErrorActionPreference = "Stop"

function Assert-SuccessExitCode($errorMessage) {
    if ($LASTEXITCODE -ne 0) {
        throw $errorMessage
    }
}

try {

	Write-Host ">>> Initializing ..."

	if (-not $ToolPath) {
		$ToolPath = $env:SWAGGER_CODEGEN_HOME
		if (-not $ToolPath) {
			$ToolPath = "."
		}
	}
	if (-not (Test-Path $ToolPath)) {
		throw "Path not found: $ToolPath"
	}
	$toolJar = Get-ChildItem $ToolPath -Filter "swagger-codegen-cli*.jar" | Select-Object -First 1
	if (-not $toolJar) {
		$toolJar = Get-ChildItem $ToolPath -Filter "swagger-codegen-cli*.jar" -Recurse | Select-Object -First 1
		if (-not $toolJar) {
			throw "Swagger codegen JAR not found in $ToolPath"
		}
	}
	Write-Host "Found swagger codegen JAR: $($toolJar.Fullname)"

	$tempDir = ("{0}\{1}" -f $env:TEMP, [Guid]::NewGuid())

	Write-Host ">>> Generating code ..."

	# Argument `--add-opens=java.base/java.util=ALL-UNNAMED` below is a workaround suggested
	# on https://github.com/swagger-api/swagger-codegen/issues/10966#issuecomment-934455905
	# to fix error below:
	# > com.github.jknack.handlebars.HandlebarsException:
	# >   /handlebars/Java/licenseInfo.mustache:2:6: java.lang.reflect.InaccessibleObjectException:
	# >   Unable to make public boolean java.util.Collections$EmptyMap.isEmpty() accessible: module java.base does not "opens java.util" to unnamed module @2b91004a
	java --add-opens=java.base/java.util=ALL-UNNAMED -jar $toolJar.Fullname generate -i https://homolog.core.pki.rest/swagger/api/swagger.json -l java -c swagger-codegen-config.json -o $tempDir
	Assert-SuccessExitCode "Swagger codegen failed"
	
	Write-Host ">>> Pruning ..."
	
	Remove-Item "$tempDir\src\test" -Recurse
	Remove-Item "$tempDir\src\main\java\io" -Recurse
	Remove-Item "$tempDir\src\main\java\com\lacunasoftware\auth" -Recurse
	Remove-Item "$tempDir\src\main\AndroidManifest.xml"
	Get-ChildItem "$tempDir\src\main\java\com\lacunasoftware" | Where-Object { !$_.PSIsContainer } | Remove-Item
	
	Write-Host ">>> Customizing classes ..."

	$encoding = New-Object System.Text.UTF8Encoding $false
	Get-ChildItem $tempDir -filter *.java -recurse | ForEach-Object {
		$content = [System.IO.File]::ReadAllText($_.Fullname, $encoding)
		$content = $content.Replace("public class", "`n@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)`npublic class")
		[System.IO.File]::WriteAllText($_.Fullname, $content, $encoding)
	}
	
	Write-Host ">>> Copying classes to project ..."

	Copy-Item "$tempDir\src\*" .\src -Recurse -Force
	
	Write-Host ">>> Doing some housekeeping ..."

	Remove-Item $tempDir -Recurse -Force
	
	Write-Host ">>> Done."

} catch {

	Write-Error ("Error: " + $_)
	exit 2
	
}
