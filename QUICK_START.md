# OrangeHRM BDD Cucumber Automation - Quick Command Reference

## One-Time Setup (First Time Only)

### Set Environment Variables (PowerShell)
```powershell
[Environment]::SetEnvironmentVariable("JAVA_HOME", "C:\Program Files\Java\jdk-21.0.10", "User")
[Environment]::SetEnvironmentVariable("M2_HOME", "C:\tools\apache-maven-3.9.6", "User")
$env:Path = "$env:Path;C:\tools\apache-maven-3.9.6\bin"
```

### Verify Installation
```powershell
mvn --version
java -version
```

---

## Run Tests - Quick Commands

### 1. Run All Tests (Simplest)
```powershell
cd C:\Users\nikkale\Test
mvn clean test -Dtest=CucumberTestRunner
```

### 2. Run Tests + Generate Reports
```powershell
cd C:\Users\nikkale\Test
mvn clean test -Dtest=CucumberTestRunner -X
```

### 3. Run Specific Scenario (by line number)
```powershell
cd C:\Users\nikkale\Test
mvn clean test -Dtest=CucumberTestRunner -Dcucumber.filter.name="Successful login"
```

### 4. Run Only Feature File Compilation (No Execution)
```powershell
cd C:\Users\nikkale\Test
mvn clean compile
```

### 5. Run All Tests + View Reports
```powershell
cd C:\Users\nikkale\Test
mvn clean test -Dtest=CucumberTestRunner
# Then open: target\cucumber-reports\report.html
```

---

## Batch Commands (Use These!)

### For Windows Batch File (Create run.bat)
```batch
@echo off
cd C:\Users\nikkale\Test
set JAVA_HOME=C:\Program Files\Java\jdk-21.0.10
set M2_HOME=C:\tools\apache-maven-3.9.6
set PATH=%PATH%;%M2_HOME%\bin
mvn clean test -Dtest=CucumberTestRunner
pause
```

### For PowerShell Script (Create run.ps1)
```powershell
$env:JAVA_HOME = "C:\Program Files\Java\jdk-21.0.10"
$env:M2_HOME = "C:\tools\apache-maven-3.9.6"
$env:Path = "$env:Path;C:\tools\apache-maven-3.9.6\bin"
cd C:\Users\nikkale\Test
mvn clean test -Dtest=CucumberTestRunner
```

---

## Most Common Commands

### Run All Tests
```
mvn clean test -Dtest=CucumberTestRunner
```

### Run + Skip Tests (Just Compile)
```
mvn clean compile
```

### Run + Open HTML Report
```
mvn clean test -Dtest=CucumberTestRunner
start target\cucumber-reports\report.html
```

### Run Single Test Class
```
mvn test -Dtest=SampleWebTest
```

### Clean Project
```
mvn clean
```

### Install Dependencies
```
mvn dependency:resolve
```

---

## Tips for Terminal Usage

1. **Navigate to project first:**
   ```
   cd C:\Users\nikkale\Test
   ```

2. **Set environment if needed:**
   ```
   $env:JAVA_HOME = "C:\Program Files\Java\jdk-21.0.10"
   $env:Path = "$env:Path;C:\tools\apache-maven-3.9.6\bin"
   ```

3. **Run command:**
   ```
   mvn clean test -Dtest=CucumberTestRunner
   ```

4. **View results:**
   - **Console**: Shows test results
   - **HTML Report**: `target\cucumber-reports\report.html`
   - **JSON Report**: `target\cucumber-reports\report.json`

---

## Useful Maven Commands

| Command | Purpose |
|---------|---------|
| `mvn clean` | Delete target folder |
| `mvn compile` | Compile source code |
| `mvn test` | Run tests |
| `mvn package` | Create JAR file |
| `mvn install` | Install to local repository |
| `mvn clean test` | Clean + Run tests |
| `mvn clean compile test` | Clean + Compile + Test |

---

## Shortcut: Create Batch File to Run Tests

Create file: `C:\Users\nikkale\Test\run-tests.bat`

```batch
@echo off
echo Starting BDD Cucumber Tests...
cd C:\Users\nikkale\Test
set JAVA_HOME=C:\Program Files\Java\jdk-21.0.10
set M2_HOME=C:\tools\apache-maven-3.9.6
set PATH=%PATH%;%M2_HOME%\bin
echo.
echo Running: mvn clean test -Dtest=CucumberTestRunner
echo.
mvn clean test -Dtest=CucumberTestRunner
echo.
echo Tests Complete! Opening Report...
timeout /t 3
start target\cucumber-reports\report.html
pause
```

**Then just double-click** `run-tests.bat` to run tests!

---

## Create PowerShell Script to Run Tests

Create file: `C:\Users\nikkale\Test\run-tests.ps1`

```powershell
Write-Host "Starting BDD Cucumber Tests..." -ForegroundColor Green
$env:JAVA_HOME = "C:\Program Files\Java\jdk-21.0.10"
$env:M2_HOME = "C:\tools\apache-maven-3.9.6"
$env:Path = "$env:Path;$env:M2_HOME\bin"
cd C:\Users\nikkale\Test
Write-Host "Running: mvn clean test -Dtest=CucumberTestRunner" -ForegroundColor Yellow
mvn clean test -Dtest=CucumberTestRunner
Write-Host "Tests Complete!" -ForegroundColor Green
Write-Host "Opening HTML Report..." -ForegroundColor Yellow
Start-Process "target\cucumber-reports\report.html"
```

**Then run in PowerShell:**
```powershell
powershell -ExecutionPolicy Bypass -File C:\Users\nikkale\Test\run-tests.ps1
```

---

## Fastest Way to Run Tests

### Option 1: Direct Command
```powershell
cd C:\Users\nikkale\Test; mvn clean test -Dtest=CucumberTestRunner
```

### Option 2: Create & Run Batch File
```batch
run-tests.bat
```

### Option 3: VS Code Task
Press `Ctrl+Shift+B` in VS Code to run build task

---

## View Test Results

### 1. Console Output
After running tests, results appear in terminal:
```
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

### 2. Open HTML Report
```powershell
start target\cucumber-reports\report.html
```

### 3. View JSON Report
```powershell
cat target\cucumber-reports\report.json
```

---

## Expected Output

```
[INFO] Scanning for projects...
[INFO] Building Sauce Labs Automation 1.0.0
[INFO] --- test (default-test) @ sauce-automation ---
[INFO] 
[INFO] Running com.saucelabs.runners.CucumberTestRunner

Feature: OrangeHRM User Login

  Scenario: Successful login with valid credentials ✓
  Scenario: Login and verify current URL ✓
  Scenario: Verify login page is displayed ✓

[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```
