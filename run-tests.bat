@echo off
REM ============================================
REM OrangeHRM BDD Automation Test Runner
REM ============================================
echo.
echo ========== BDD CUCUMBER TEST EXECUTION ==========
echo.
echo Setting environment variables...
set JAVA_HOME=C:\Program Files\Java\jdk-21.0.10
set M2_HOME=C:\tools\apache-maven-3.9.6
set PATH=%PATH%;%M2_HOME%\bin

echo Navigating to project directory...
cd /d C:\Users\nikkale\Test

echo.
echo ========== RUNNING TESTS ==========
echo.

call mvn clean test -Dtest=CucumberTestRunner

echo.
if %ERRORLEVEL% EQU 0 (
    echo.
    echo ========== TESTS PASSED! ==========
    echo.
    echo Opening HTML Report...
    timeout /t 2 /nobreak
    start target\cucumber-reports\report.html
) else (
    echo.
    echo ========== TESTS FAILED! ==========
    echo Check console output above for errors.
)

echo.
pause
