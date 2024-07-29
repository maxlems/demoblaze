package org.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class StudentHomePage {
    private final WebDriver driver;

    private final By enterMyStageButton = By.cssSelector(".trigger-item > a");

    public StudentHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickEnterMyStageButton() {
        // Find all div elements

        Duration timeoutDuration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration); // Wait upto 10 seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterMyStageButton));

        List<WebElement> elements = driver.findElements(enterMyStageButton);

        if (elements.isEmpty()) {
            WebElement enterMyStageButton = driver.findElement((By) elements);
            enterMyStageButton.click();
        } else {
            WebElement element = driver.findElement(enterMyStageButton);

            element = elements.get(elements.size() - 1);
            element.click();
        }
    }
}
