package com.saucelabs;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;

/**
 * Base test class providing common WebDriver setup and teardown.
 * All test classes should extend this class.
 */
public class BaseTest {
    
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;
    protected SauceLabsConfig config;
    protected String sessionId;
    
    // Set this to true for local execution, false for Sauce Labs cloud
    private static final boolean USE_LOCAL_CHROME = true;

    @Before
    public void setUp() throws MalformedURLException {
        config = new SauceLabsConfig();
        setupWebDriver();
        logger.info("WebDriver initialized for test");
    }

    protected void setupWebDriver() throws MalformedURLException {
        if (USE_LOCAL_CHROME) {
            setupLocalChromeDriver();
        } else {
            setupSauceLabsDriver();
        }
    }

    private void setupLocalChromeDriver() {
        // Automatically manage Chrome driver
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        
        driver = new ChromeDriver(options);
        sessionId = "local-chrome-" + System.currentTimeMillis();
        
        logger.info("✓ Local Chrome browser initialized");
        logger.info("Session ID: {}", sessionId);
    }

    private void setupSauceLabsDriver() throws MalformedURLException {
        // This method would use RemoteWebDriver for Sauce Labs
        logger.info("Sauce Labs driver setup not configured in this version");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("WebDriver closed for test");
        }
    }

    protected String getTestName() {
        return this.getClass().getSimpleName();
    }

    public String getSessionId() {
        return sessionId;
    }
}
