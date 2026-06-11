# Sauce Labs Automation - Copilot Instructions

This file provides custom instructions for VS Code Copilot when working with this Java Sauce Labs automation project.

## Project Overview

- **Language**: Java 11+
- **Build System**: Maven 3.6+
- **Test Framework**: JUnit 4.13.2
- **Automation Tool**: Selenium WebDriver 4.15.0
- **Platform**: Sauce Labs Cloud

## Key Files

- `pom.xml` - Maven project configuration and dependencies
- `src/main/java/com/saucelabs/SauceLabsConfig.java` - Configuration management
- `src/test/java/com/saucelabs/BaseTest.java` - Base test class with WebDriver setup
- `src/test/java/com/saucelabs/SampleWebTest.java` - Example test cases
- `README.md` - Project documentation

## Common Tasks

### Build Commands
- **Compile**: `mvn clean compile`
- **Run Tests**: `mvn clean test`
- **Build JAR**: `mvn clean package`
- **Run Specific Test**: `mvn -Dtest=ClassName test`

### Configuration
- Set environment variables: `SAUCE_USERNAME`, `SAUCE_ACCESS_KEY`, `SAUCE_PLATFORM`, `SAUCE_BROWSER`, `SAUCE_BROWSER_VERSION`
- Update `SauceLabsConfig.java` with actual credentials

### Test Development Guidelines
1. Create new test classes in `src/test/java/com/saucelabs/`
2. Extend `BaseTest` class to inherit WebDriver setup/teardown
3. Use `@Test` annotation for test methods
4. Use JUnit assertions for validations
5. WebDriver setup: `driver`, `config`, `sessionId` are available from BaseTest
6. Logging: Use `logger` from BaseTest for logging

### Directory Structure
- `src/main/java/` - Main Java source code
- `src/test/java/` - Test code
- `src/main/resources/` - Resource files (log4j.properties)
- `target/` - Build output directory (generated)

## Dependencies Overview

- **selenium-java** - WebDriver browser automation
- **junit** - Test framework
- **saucelabs-java-client** - Sauce Labs integration
- **webdrivermanager** - Automatic driver management
- **slf4j** - Logging framework
- **json** - JSON parsing

## Environment Setup

### Prerequisites
- Java 11+ installed
- Maven 3.6+ installed
- Internet connection for Sauce Labs cloud
- Valid Sauce Labs account

### Credentials
Store credentials in environment variables rather than hardcoding:
- `SAUCE_USERNAME` - Sauce Labs username
- `SAUCE_ACCESS_KEY` - Sauce Labs access key

## Logging

- Logs are configured in `src/main/resources/log4j.properties`
- Output: Console and `target/logs/app.log`
- Logger available in test classes as `protected static Logger logger`

## Common Issues & Solutions

1. **Maven not found** - Ensure Maven is in system PATH
2. **Connection timeout** - Check Sauce Labs credentials and internet connection
3. **Build failures** - Run `mvn clean compile` to clear cache
4. **Selenium timeouts** - Increase wait duration in WebDriverWait

## Next Steps

1. Set up environment variables with Sauce Labs credentials
2. Run sample tests: `mvn clean test`
3. View results in Sauce Labs dashboard
4. Create custom test cases by extending BaseTest
5. Integrate into CI/CD pipeline

---

For detailed instructions, see [README.md](../README.md)
