# Fix Maven 'mvn not recognized' Error

## Solution 1: Quick Fix (For Current Session Only)

Run these 2 commands in PowerShell, then mvn will work:

```powershell
$env:JAVA_HOME = "C:\Program Files\Java\jdk-21.0.10"
$env:Path = "$env:Path;C:\tools\apache-maven-3.9.6\bin"
```

Then run your tests:
```powershell
cd C:\Users\nikkale\Test
mvn clean test -Dtest=CucumberTestRunner
```

---

## Solution 2: Permanent Fix (Recommended!)

Set environment variables permanently so mvn always works:

### Step 1: Open Environment Variables
```
Windows Key + R
Type: sysdm.cpl
Press Enter
```

### Step 2: Click "Environment Variables"
- Click the button at bottom right: "Environment Variables"

### Step 3: Add JAVA_HOME
- Click "New" under "User variables"
- Variable name: `JAVA_HOME`
- Variable value: `C:\Program Files\Java\jdk-21.0.10`
- Click OK

### Step 4: Add M2_HOME
- Click "New" under "User variables"
- Variable name: `M2_HOME`
- Variable value: `C:\tools\apache-maven-3.9.6`
- Click OK

### Step 5: Update PATH
- Select "Path" in User variables
- Click "Edit"
- Click "New"
- Add: `C:\tools\apache-maven-3.9.6\bin`
- Click OK, OK, OK

### Step 6: Restart PowerShell or CMD
Close and reopen the terminal

### Step 7: Verify
```powershell
mvn --version
```

You should see Maven version!

---

## Solution 3: Use Full Path (Quick but Long)

Run tests with full path to mvn:

```powershell
cd C:\Users\nikkale\Test
C:\tools\apache-maven-3.9.6\bin\mvn clean test -Dtest=CucumberTestRunner
```

---

## Solution 4: Use Batch File (Easiest!)

Just double-click: `C:\Users\nikkale\Test\run-tests.bat`

The batch file already sets up everything automatically!

---

## Verification Commands

Check if each tool is installed:

```powershell
# Check Java
java -version

# Check Maven (after fixing PATH)
mvn --version

# Check if paths exist
Test-Path "C:\Program Files\Java\jdk-21.0.10"
Test-Path "C:\tools\apache-maven-3.9.6\bin"
```

---

## If Still Having Issues

### Check Current PATH
```powershell
$env:Path
```

### Check if Maven exists at path
```powershell
Get-ChildItem "C:\tools\apache-maven-3.9.6\bin\mvn.cmd"
```

### Set PATH for Current Session
```powershell
$env:JAVA_HOME = "C:\Program Files\Java\jdk-21.0.10"
$env:M2_HOME = "C:\tools\apache-maven-3.9.6"
$env:Path = "$env:Path;$env:M2_HOME\bin"
mvn --version
```

If this shows Maven version, then Maven works! 
If not, Maven may not be installed properly.

---

## RECOMMENDED: Simplest Solution

### Just use the batch file!
```
Double-click: C:\Users\nikkale\Test\run-tests.bat
```

This file automatically:
✓ Sets JAVA_HOME
✓ Sets Maven PATH
✓ Runs tests
✓ Opens report

No terminal commands needed!
