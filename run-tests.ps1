#!/usr/bin/env powershell

# ============================================
# OrangeHRM BDD Automation Test Runner
# ============================================

Write-Host ""
Write-Host "========== BDD CUCUMBER TEST EXECUTION ==========" -ForegroundColor Green
Write-Host ""

Write-Host "Setting environment variables..." -ForegroundColor Yellow
$env:JAVA_HOME = "C:\Program Files\Java\jdk-21.0.10"
$env:M2_HOME = "C:\tools\apache-maven-3.9.6"
$env:Path = "$env:Path;$env:M2_HOME\bin"

Write-Host "Navigating to project directory..." -ForegroundColor Yellow
Set-Location "C:\Users\nikkale\Test"

Write-Host ""
Write-Host "========== RUNNING TESTS ==========" -ForegroundColor Green
Write-Host ""

mvn clean test -Dtest=CucumberTestRunner

Write-Host ""
if ($LASTEXITCODE -eq 0) {
    Write-Host "========== TESTS PASSED! ==========" -ForegroundColor Green
    Write-Host ""
    Write-Host "Opening HTML Report..." -ForegroundColor Yellow
    Start-Sleep -Seconds 1
    Start-Process "target\cucumber-reports\report.html"
} else {
    Write-Host "========== TESTS FAILED! ==========" -ForegroundColor Red
    Write-Host "Check console output above for errors." -ForegroundColor Red
}

Write-Host ""
Read-Host "Press Enter to exit"
