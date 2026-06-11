# Setup Instructions

## Prerequisites Installation

### 1. Install Maven

Maven is required to build and run this project.

#### Windows

**Option A: Using Chocolatey (Recommended)**
```powershell
choco install maven
```

**Option B: Manual Installation**
1. Download Maven from [Apache Maven](https://maven.apache.org/download.cgi)
2. Extract to a folder (e.g., `C:\maven`)
3. Add Maven to PATH:
   - Open System Properties → Environment Variables
   - Add to PATH: `C:\maven\bin`
4. Verify: `mvn -version`

#### macOS

```bash
brew install maven
```

#### Linux (Ubuntu/Debian)

```bash
sudo apt-get update
sudo apt-get install maven
```

### 2. Set Sauce Labs Credentials

**Windows (PowerShell - Permanent)**
```powershell
# Create/edit profile
notepad $PROFILE

# Add these lines:
$env:SAUCE_USERNAME = "your_sauce_username"
$env:SAUCE_ACCESS_KEY = "your_sauce_access_key"
$env:SAUCE_PLATFORM = "Windows 10"
$env:SAUCE_BROWSER = "Chrome"
$env:SAUCE_BROWSER_VERSION = "latest"

# Save and reload:
. $PROFILE
```

**Windows (Command Prompt - Session Only)**
```cmd
set SAUCE_USERNAME=your_sauce_username
set SAUCE_ACCESS_KEY=your_sauce_access_key
set SAUCE_PLATFORM=Windows 10
set SAUCE_BROWSER=Chrome
set SAUCE_BROWSER_VERSION=latest
```

**macOS/Linux (Permanent)**
```bash
# Add to ~/.bash_profile or ~/.zshrc
export SAUCE_USERNAME="your_sauce_username"
export SAUCE_ACCESS_KEY="your_sauce_access_key"
export SAUCE_PLATFORM="macOS 12"
export SAUCE_BROWSER="Chrome"
export SAUCE_BROWSER_VERSION="latest"

# Reload:
source ~/.bash_profile  # or source ~/.zshrc
```

### 3. Get Sauce Labs Credentials

1. Go to [Sauce Labs Dashboard](https://app.saucelabs.com)
2. Click your username → Account
3. Copy your **Username** and **Access Key**
4. Use these values for the environment variables above

## First Run

After setting up Maven and credentials:

```bash
# Navigate to project directory
cd sauce-automation

# Build project
mvn clean compile

# Run tests
mvn clean test

# View results in Sauce Labs Dashboard
# https://app.saucelabs.com
```

## Troubleshooting

**Maven command not found**
- Verify Maven installation: `mvn -version`
- Ensure Maven bin folder is in system PATH
- Restart terminal after adding to PATH

**Tests fail with connection error**
- Verify credentials are set: `echo %SAUCE_USERNAME%` (Windows) or `echo $SAUCE_USERNAME` (Mac/Linux)
- Check internet connection
- Verify Sauce Labs account is active

**Selenium timeout errors**
- Increase wait times in test code
- Check browser version availability on Sauce Labs
- Verify platform/browser combination is supported

## Next Steps

1. Complete the setup above
2. Run: `mvn clean test`
3. View test results in [Sauce Labs Dashboard](https://app.saucelabs.com)
4. Create custom tests in `src/test/java/com/saucelabs/`
5. Extend `BaseTest` class for common setup/teardown

## Resources

- [Sauce Labs Documentation](https://docs.saucelabs.com/)
- [Maven Documentation](https://maven.apache.org/guides/)
- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [JUnit 4 Documentation](https://junit.org/junit4/)
