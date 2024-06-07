package org.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    // Define locators
    private final By usernameField = By.id("loginusername");
    private final By passwordField = By.id("loginpassword");
    private final By submitButton = By.xpath("//button[@onclick='logIn()' and @class='btn btn-primary']");
    private final By logoutButton = By.xpath("//a[@id='logout2']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigatetoLogin() {
        String xpathExpression = "//a[@class='nav-link' and @id='login2' and @data-toggle='modal' and @data-target='#logInModal']";
        By locator = By.xpath(xpathExpression);
        Duration timeoutDuration = Duration.ofSeconds(5);

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutDuration);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            element.click();
        } catch (NoSuchElementException e) {
            System.out.println("Login link not found.");
        }
    }

    public void enterUsername(String username) {
        Duration timeoutDuration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration); // Wait up to 10 seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));

        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSubmit();
    }

    public String clickLogout() {
        // Click on the logout button
        driver.findElement(logoutButton).click();

        // Verify if the login menu is visible after logout
        boolean isLoginMenuVisible = isLoginMenuVisible();
        if (isLoginMenuVisible) {
            return "Login menu is visible after logout.";
        } else {
            return "Login menu is not visible after logout.";
        }
    }
    public boolean isLoginMenuVisible() {
        String xpathExpression = "//a[@class='nav-link' and @id='login2' and @data-toggle='modal' and @data-target='#logInModal']";
        By loginMenuLocator = By.xpath(xpathExpression);
        Duration timeoutDuration = Duration.ofSeconds(5);

        // Check if the login menu is visible
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutDuration);
            WebElement loginMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(loginMenuLocator));
            return loginMenu.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
    public String isSuccessLogin(String username) {
        String xpathExpression = "//a[@class='nav-link' and contains(text(), 'Welcome') and contains(text(), '" + username + "')]";
        By locator = By.xpath(xpathExpression);
        Duration timeoutDuration = Duration.ofSeconds(5);

        try {
            // Check and handle alert first
            try {
                WebDriverWait alertWait = new WebDriverWait(driver, timeoutDuration);
                alertWait.until(ExpectedConditions.alertIsPresent());
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                alert.accept();
                return "Alert text: " + alertText;
            } catch (NoAlertPresentException ex) {
                // No alert present, proceed with finding the element
            }

            // Explicit wait for the element to be present with a timeout of 5 seconds
            WebDriverWait wait = new WebDriverWait(driver, timeoutDuration);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return "Login Successful";
        } catch (TimeoutException e) {
            return "Login unsuccessful";
        } catch (UnhandledAlertException e) {
            // Handle unexpected alert
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                alert.accept();
                return "Alert text: " + alertText;
            } catch (NoAlertPresentException ex) {
                return "Login unsuccessful";
            }
        }
    }
}
