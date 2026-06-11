package com.saucelabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

/**
 * Page Object Model for OrangeHRM Dashboard Page
 */
public class DashboardPage {
    
    private static final Logger logger = LoggerFactory.getLogger(DashboardPage.class);
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    // Page Elements
    @FindBy(xpath = "//h6[contains(text(), 'Dashboard')]")
    private WebElement dashboardTitle;
    
    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    private WebElement userDropdown;
    
    @FindBy(xpath = "//a[contains(text(), 'Logout')]")
    private WebElement logoutButton;
    
    // Constructor
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
    
    // Page Actions
    public boolean isDashboardDisplayed() {
        try {
            wait.until(ExpectedConditions.urlContains("dashboard"));
            logger.info("Dashboard page is displayed");
            return true;
        } catch (Exception e) {
            logger.error("Dashboard not displayed: {}", e.getMessage());
            return false;
        }
    }
    
    public String getDashboardTitle() {
        try {
            return dashboardTitle.getText();
        } catch (Exception e) {
            logger.warn("Could not get dashboard title: {}", e.getMessage());
            return "";
        }
    }
    
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    
    public String getPageTitle() {
        return driver.getTitle();
    }
    
    public void logout() {
        try {
            userDropdown.click();
            wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
            logoutButton.click();
            logger.info("Logged out successfully");
        } catch (Exception e) {
            logger.error("Error during logout: {}", e.getMessage());
            throw e;
        }
    }
    
    public void waitForDashboardToLoad() {
        wait.until(ExpectedConditions.urlContains("dashboard"));
        wait.until(ExpectedConditions.presenceOfElementLocated(
            org.openqa.selenium.By.xpath("//h6[contains(text(), 'Dashboard')]")));
    }
}
