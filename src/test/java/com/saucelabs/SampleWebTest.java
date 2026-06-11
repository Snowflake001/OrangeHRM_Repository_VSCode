package com.saucelabs;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.Assert.*;

import java.time.Duration;

/**
 * Sample test class demonstrating Sauce Labs testing with Selenium.
 * Tests basic web application functionality.
 */
public class SampleWebTest extends BaseTest {

    @Test
    public void testOrangeHRMLogin() {
        try {
            // Navigate to OrangeHRM login page
            driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            logger.info("Navigated to OrangeHRM login page");
            
            // Wait for page to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
            
            // Wait for username field
            WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@name='username']")));
            logger.info("Username field found");
            
            // Enter credentials
            usernameField.clear();
            usernameField.sendKeys("Admin");
            logger.info("Entered username: Admin");
            
            // Find and fill password field
            WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
            passwordField.clear();
            passwordField.sendKeys("admin123");
            logger.info("Entered password: admin123");
            
            // Click login button
            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
            loginButton.click();
            logger.info("Clicked login button");
            
            // Wait for dashboard to load after login
            wait.until(ExpectedConditions.urlContains("dashboard"));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            // Verify successful login
            String pageTitle = driver.getTitle();
            logger.info("After login - Page title: {}", pageTitle);
            String currentUrl = driver.getCurrentUrl();
            logger.info("After login - Current URL: {}", currentUrl);
            
            assertTrue("Should be redirected to dashboard after login", 
                currentUrl.toLowerCase().contains("dashboard"));
            
            logger.info("✓ Login test passed! Session: {}", sessionId);
        } catch (Exception e) {
            logger.error("Login test failed with error: {}", e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    @Test
    public void testPageLoadPerformance() {
        try {
            long startTime = System.currentTimeMillis();
            driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
            
            long loadTime = System.currentTimeMillis() - startTime;
            logger.info("OrangeHRM page load time: {} ms", loadTime);
            
            assertTrue("Page should load within 10 seconds", loadTime < 10000);
            logger.info("✓ Performance test passed! Session: {}", sessionId);
        } catch (Exception e) {
            logger.error("Performance test failed: {}", e.getMessage());
            throw e;
        }
    }

    @Test
    public void testBasicNavigation() {
        try {
            driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
            
            // Get page URL
            String currentUrl = driver.getCurrentUrl();
            logger.info("Current URL: {}", currentUrl);
            
            assertNotNull("URL should not be null", currentUrl);
            assertTrue("Should be on OrangeHRM domain", 
                currentUrl.toLowerCase().contains("orangehrm"));
            
            logger.info("✓ Navigation test passed! Session: {}", sessionId);
        } catch (Exception e) {
            logger.error("Navigation test failed: {}", e.getMessage());
            throw e;
        }
    }
}
