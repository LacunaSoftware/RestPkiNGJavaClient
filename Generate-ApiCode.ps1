param([string]$ToolPath)
$ErrorActionPreference = "Stop"

try {

	if ([String]::IsNullOrEmpty($ToolPath)) {
		Write-Host ("Syntax: {0} [-ToolPath] <swagger-codegen path>" -f $MyInvocation.MyCommand.Name)
		exit 1
	}

	Write-Host ">>> Initializing ..."

	$toolJarPath = Resolve-Path ($ToolPath + "\modules\swagger-codegen-cli\target\swagger-codegen-cli.jar")
	$tempDir = ("{0}\{1}" -f $env:TEMP, [Guid]::NewGuid())

	Write-Host ">>> Generating code ..."

	&java -jar $toolJarPath generate -i https://core.pki.rest/swagger/api/swagger.json -l java -c swagger-codegen-config.json -o $tempDir
	
	Write-Host ">>> Customizing classes ..."

	$encoding = New-Object System.Text.UTF8Encoding $false
	# $regex = New-Object System.Text.RegularExpressions.Regex "public enum (\w+) {.*?};?", "Singleline"
	ls $tempDir -filter *.java -recurse | foreach {
		$content = [System.IO.File]::ReadAllText($_.Fullname, $encoding)
		$content = $content.Replace("public class", "@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)`nclass")
		# $matches = $regex.Matches($content)
		# $content = $regex.Replace($content, "")
		[System.IO.File]::WriteAllText($_.Fullname, $content, $encoding)
		# $matches | foreach {
			# $enumName = $_.Groups[1].Value
			# Write-Host (">>> Extracting enum: " + $enumName)
			# $enumDefinition = $_.Value
			# $code = New-Object System.Text.StringBuilder
			# $code.AppendLine("package com.lacunasoftware.restpki;");
			# $code.AppendLine($enumDefinition)
			# $enumFilePath = ("{0}\src\main\java\com\lacunasoftware\restpki\{1}.java" -f $tempDir, $enumName)
			# [System.IO.File]::WriteAllText($enumFilePath, $code.ToString(), $encoding)
		# }
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
