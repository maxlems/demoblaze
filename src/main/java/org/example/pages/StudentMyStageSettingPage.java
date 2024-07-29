package org.example.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class StudentMyStageSettingPage {
    private final WebDriver driver;

    private final By enterMyStageButton = By
            .xpath("//div[@class='lesson-join']/div[@class='join_btn']/a[@type='primary']");

    // Video Input
    private final By videoInput = By.cssSelector(".camera-selection .el-input__inner");
    private final By videoInputOptions = By.cssSelector("[x-placement] .el-select-dropdown__list li");

    public StudentMyStageSettingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickVideoInput() {
        driver.findElement(videoInput).click();
    }

    public void selectVideoInputOption(String value) {
        Duration timeoutDuration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(videoInputOptions));

        List<WebElement> elements = driver.findElements(videoInputOptions);

        for (WebElement element : elements) {
            if ((element.getText().equals("video1"))) {
                element.click();
                break;
            }
        }
    }

    public void clickEnterMyStageButton() throws Exception {
        Duration timeoutDuration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration); // Wait upto 10 seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterMyStageButton));

        try {
            driver.findElement(enterMyStageButton).click();
        } catch (Exception e) {
        }
    }

}
