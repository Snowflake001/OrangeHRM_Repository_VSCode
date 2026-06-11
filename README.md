# Sauce Labs Automation - Java Project

Automated testing framework for Sauce Labs using Java, Selenium WebDriver, and Maven.

## Project Structure

```
sauce-automation/
├── src/
│   ├── main/
│   │   ├── java/com/saucelabs/
│   │   │   └── SauceLabsConfig.java          # Configuration management
│   │   └── resources/
│   │       └── log4j.properties               # Logging configuration
│   └── test/
│       └── java/com/saucelabs/
│           ├── BaseTest.java                  # Base test class with setup/teardown
│           └── SampleWebTest.java             # Example test cases
├── pom.xml                                     # Maven configuration
├── README.md                                   # This file
└── .github/
    └── copilot-instructions.md                 # VS Code Copilot instructions
```

## Prerequisites

- **Java 11+** - [Download Java](https://www.oracle.com/java/technologies/downloads/)
- **Maven 3.6+** - [Download Maven](https://maven.apache.org/download.cgi)
- **Sauce Labs Account** - [Sign up for free](https://saucelabs.com/sign-up)

## Setup

### 1. Install Dependencies

Ensure Maven is installed:
```bash
mvn --version
```

### 2. Configure Sauce Labs Credentials

Set environment variables with your Sauce Labs credentials:

**Windows (PowerShell):**
```powershell
$env:SAUCE_USERNAME = "your_username"
$env:SAUCE_ACCESS_KEY = "your_access_key"
$env:SAUCE_PLATFORM = "Windows 10"
$env:SAUCE_BROWSER = "Chrome"
$env:SAUCE_BROWSER_VERSION = "latest"
```

**Windows (Command Prompt):**
```cmd
set SAUCE_USERNAME=your_username
set SAUCE_ACCESS_KEY=your_access_key
set SAUCE_PLATFORM=Windows 10
set SAUCE_BROWSER=Chrome
set SAUCE_BROWSER_VERSION=latest
```

**macOS/Linux:**
```bash
export SAUCE_USERNAME="your_username"
export SAUCE_ACCESS_KEY="your_access_key"
export SAUCE_PLATFORM="macOS 12"
export SAUCE_BROWSER="Chrome"
export SAUCE_BROWSER_VERSION="latest"
```

### 3. Update Sauce Labs Credentials in Code

Edit [src/main/java/com/saucelabs/SauceLabsConfig.java](src/main/java/com/saucelabs/SauceLabsConfig.java) and replace:
- `your_username` with your Sauce Labs username
- `your_access_key` with your Sauce Labs access key

## Building the Project

### Compile
```bash
mvn clean compile
```

### Run All Tests
```bash
mvn clean test
```

### Run Specific Test
```bash
mvn -Dtest=SampleWebTest test
```

### Build JAR
```bash
mvn clean package
```

## Available Test Cases

The project includes the following example tests in [src/test/java/com/saucelabs/SampleWebTest.java](src/test/java/com/saucelabs/SampleWebTest.java):

1. **testSauceLabsWebsite** - Navigates to Sauce Labs website and verifies page title
2. **testPageLoadPerformance** - Measures and validates page load time
3. **testBasicNavigation** - Tests URL navigation and verification

## Creating Custom Tests

1. Create a new test class in `src/test/java/com/saucelabs/`
2. Extend `BaseTest` class
3. Use `@Test` annotation for test methods
4. Example:

```java
package com.saucelabs;

import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.*;

public class MyCustomTest extends BaseTest {
    
    @Test
    public void myTestCase() {
        driver.navigate().to("https://www.example.com");
        // Add your test logic here
        assertTrue(driver.getTitle().contains("Example"));
    }
}
```

## Viewing Test Results

Test results are available:
- **Console Output** - During test execution
- **Sauce Labs Dashboard** - [https://app.saucelabs.com](https://app.saucelabs.com)
  - Login with your credentials
  - View video recordings, screenshots, and detailed test logs

## Supported Browsers & Platforms

Sauce Labs supports:
- **Browsers**: Chrome, Firefox, Safari, Edge, IE
- **Platforms**: Windows 10/11, macOS, Linux
- **Mobile**: iOS, Android (with Appium)

Update environment variables to test different browsers and platforms.

## Troubleshooting

### Build Failures
```bash
mvn clean compile
```

### Clear Maven Cache
```bash
mvn clean
```

### View Detailed Logs
Logs are written to `target/logs/app.log`

### Connection Issues
- Verify Sauce Labs credentials are correct
- Check internet connectivity
- Ensure firewall allows connections to ondemand.saucelabs.com

## Dependencies

- **Selenium WebDriver 4.15.0** - Browser automation
- **JUnit 4.13.2** - Test framework
- **SauceLabs Java Client 1.2.1** - Integration library
- **WebDriverManager 5.6.3** - Driver management
- **SLF4J 2.0.7** - Logging

## Documentation

- [Sauce Labs Documentation](https://docs.saucelabs.com/)
- [Selenium WebDriver Documentation](https://www.selenium.dev/documentation/)
- [JUnit Documentation](https://junit.org/junit4/)

## License

This project is provided as-is for testing purposes.

## Support

For issues or questions:
- [Sauce Labs Support](https://support.saucelabs.com/)
- [GitHub Issues](https://github.com/)
