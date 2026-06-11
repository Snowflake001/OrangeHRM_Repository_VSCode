package com.saucelabs.steps;

import com.saucelabs.WebDriverFactory;
import com.saucelabs.pages.LoginPage;
import com.saucelabs.pages.DashboardPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.*;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

/**
 * Step Definitions for Login Feature
 */
public class LoginSteps {
    
    private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
    
    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    
    @Before
    public void setup() {
        logger.info("========== TEST EXECUTION STARTED ==========");
        driver = WebDriverFactory.createWebDriver();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        logger.info("WebDriver and Page Objects initialized");
    }
    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("✓ WebDriver closed");
        }
        logger.info("========== TEST EXECUTION COMPLETED ==========\n");
    }
    
    @Given("user navigates to OrangeHRM login page")
    public void userNavigatesToLoginPage() {
        logger.info("Step: Navigate to OrangeHRM login page");
        loginPage.navigateToLoginPage();
    }
    
    @When("user enters username {string}")
    public void userEntersUsername(String username) {
        logger.info("Step: Enter username - {}", username);
        loginPage.enterUsername(username);
    }
    
    @And("user enters password {string}")
    public void userEntersPassword(String password) {
        logger.info("Step: Enter password");
        loginPage.enterPassword(password);
    }
    
    @And("user clicks login button")
    public void userClicksLoginButton() {
        logger.info("Step: Click login button");
        loginPage.clickLoginButton();
        
        // Wait for dashboard to load after login
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    @Then("user should see the dashboard page")
    public void userShouldSeeDashboard() {
        logger.info("Step: Verify dashboard page is displayed");
        assertTrue("Dashboard page should be displayed", dashboardPage.isDashboardDisplayed());
    }
    
    @And("user should see the page title {string}")
    public void userShouldSeePageTitle(String expectedTitle) {
        logger.info("Step: Verify page title is - {}", expectedTitle);
        String actualTitle = dashboardPage.getPageTitle();
        logger.info("Page title: {}", actualTitle);
        assertTrue("Page title should contain '" + expectedTitle + "'", 
            actualTitle.contains(expectedTitle));
    }
    
    @Then("user should be redirected to dashboard URL")
    public void userShouldBeRedirectedToDashboard() {
        logger.info("Step: Verify dashboard URL");
        String currentUrl = dashboardPage.getCurrentUrl();
        logger.info("Current URL: {}", currentUrl);
        assertTrue("URL should contain 'dashboard'", currentUrl.contains("dashboard"));
    }
    @Then("user should not be redirected to dashboard URL")
    public void userShouldNotBeRedirectedToDashboard() {
        logger.info("Step: Verify error message for invalid credentials");
        String errorMsg = loginPage.getErrorMessageforInvalidCredentials();
        logger.info("Error message: {}", errorMsg);
        assertFalse("Error message should be displayed", errorMsg.isEmpty());
    }
    
    @Then("login page should be displayed")
    public void loginPageShouldBeDisplayed() {
        logger.info("Step: Verify login page is displayed");
        assertTrue("Login page should be displayed", loginPage.isLoginPageDisplayed());
    }
}
