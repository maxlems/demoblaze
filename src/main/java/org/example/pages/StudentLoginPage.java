package org.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StudentLoginPage {
    private final WebDriver driver;

    // locators
    private final By userEmailField = By.id("email");
    private final By userPasswordField = By.id("password");
    private final By loginSubmitBtn = By.id("login_submit");

    public StudentLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        enterUserEmail(username);
        enterPassword(password);
        clickSubmit();
    }

    public void enterUserEmail(String username) {
        Duration timeoutDuration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration); // Wait upto 10 seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(userEmailField));

        driver.findElement(userEmailField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(userPasswordField).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(loginSubmitBtn).click();
    }

    public boolean isLoginMenuVisible() {
        String xpathExpression = "//img[@src='/common_student/images/logo_after_login.jpg']";
        By LoginLogoLocator = By.xpath(xpathExpression);
        Duration timeoutDuration = Duration.ofSeconds(5);

        // Check if the login menu is visible
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutDuration);
            WebElement loginMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLogoLocator));
            return loginMenu.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
