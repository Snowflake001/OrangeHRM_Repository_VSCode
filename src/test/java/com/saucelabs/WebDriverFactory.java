package com.saucelabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Factory class for creating and managing WebDriver instances
 */
public class WebDriverFactory {
    
    private static final Logger logger = LoggerFactory.getLogger(WebDriverFactory.class);
    private static final boolean USE_LOCAL_CHROME = true;
    
    private WebDriverFactory() {
        // Private constructor to prevent instantiation
    }
    
    /**
     * Create and initialize WebDriver instance
     */
    public static WebDriver createWebDriver() {
        if (USE_LOCAL_CHROME) {
            return createLocalChromeDriver();
        } else {
            return createRemoteWebDriver();
        }
    }
    
    /**
     * Create local Chrome WebDriver
     */
    private static WebDriver createLocalChromeDriver() {
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        
        WebDriver driver = new ChromeDriver(options);
        logger.info("✓ Local Chrome WebDriver initialized");
        
        return driver;
    }
    
    /**
     * Create remote WebDriver (for Sauce Labs)
     */
    private static WebDriver createRemoteWebDriver() {
        logger.info("Remote WebDriver setup not configured");
        throw new RuntimeException("Remote driver not configured");
    }
}
