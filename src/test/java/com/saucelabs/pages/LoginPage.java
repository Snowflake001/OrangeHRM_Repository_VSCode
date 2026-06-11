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
 * Page Object Model for OrangeHRM Login Page
 */
public class LoginPage {
    
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    // Page Elements
    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;
    
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    
    @FindBy(xpath = "//div[@class='oxd-alert oxd-alert--error']")
    private WebElement errorMessage;
    
    @FindBy(tagName = "h5")
    private WebElement pageTitle;
    
    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
    
    // Page Actions
    public void navigateToLoginPage() {
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        logger.info("Navigated to OrangeHRM login page");
        wait.until(ExpectedConditions.presenceOfElementLocated(
            org.openqa.selenium.By.xpath("//input[@name='username']")));
    }
    
    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
        logger.info("Entered username: {}", username);
    }
    
    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        logger.info("Entered password: ****");
    }
    
    public void clickLoginButton() {
        loginButton.click();
        logger.info("Clicked login button");
    }
    
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        logger.info("Attempted login with username: {}", username);
    }
    
    public boolean isLoginPageDisplayed() {
        try {
            return pageTitle.isDisplayed();
        } catch (Exception e) {
            logger.warn("Login page not displayed: {}", e.getMessage());
            return false;
        }
    }
    
    public String getErrorMessage() {
        try {
            return errorMessage.getText();
        } catch (Exception e) {
            logger.warn("Error message not found: {}", e.getMessage());
            return "";
        }
    }
    
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
