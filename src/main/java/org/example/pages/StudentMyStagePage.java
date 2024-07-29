package org.example.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentMyStagePage {
    private final WebDriver driver;

    private final By myStageLogo = By
            .xpath("//header[@id='header']/div[@class='header_content']//img[@src='/MyStage/lp/img/logo_myStage-GR.36481e29.svg']");

    public StudentMyStagePage(WebDriver driver) {
        this.driver = driver;
    }

    public void getNavBarMystageLogo() throws Exception {
        Duration timeoutDuration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration); // Wait upto 10 seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(myStageLogo));

        driver.findElement(myStageLogo);
    }

    public boolean isNavaBarMystageLogoVisible() {
        String xpathExpression = "//header[@id='header']/div[@class='header_content']//img[@src='/MyStage/lp/img/logo_myStage-GR.36481e29.svg']";
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
