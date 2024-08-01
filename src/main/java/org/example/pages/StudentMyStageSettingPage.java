package org.example.pages;

import java.time.Duration;

import org.example.utils.ActionKeywords;
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
    private final By videoInputOption1 = By.cssSelector("[x-placement] .el-select-dropdown__list li:nth-of-type(1)");

    // Audio Input Mic
    private final By audioInput = By.cssSelector(".mic-selection .el-input__inner");
    private final By audioInputOption1 = By.cssSelector(
            "body > div:nth-of-type(3) .el-scrollbar__view.el-select-dropdown__list > .el-select-dropdown__item");
    private final By waveIcon = By.cssSelector(".right-side canvas");

    // Audio Output speaker
    private final By audioOutput = By.cssSelector(".speaker-selection .el-input__inner");
    private final By audioOutputOption1 = By
            .cssSelector("div:nth-of-type(4) .el-scrollbar__view.el-select-dropdown__list > .el-select-dropdown__item");

    public StudentMyStageSettingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickVideoInput() {
        Duration timeoutDuration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(videoInput));
        driver.findElement(videoInput).click();
    }

    public void selectVideoInputOption() throws InterruptedException {
        Duration timeoutDuration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(videoInputOption1));
        driver.findElement(videoInputOption1).click();
    }

    public void isVideoInputCorrectValue(String videoInputText) throws InterruptedException {
        Duration timeoutDuration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(videoInput));

        WebElement element = driver.findElement(videoInput);

        ActionKeywords.isInputValuePresence(element, videoInputText);
    }

    public void clickAudioInput() {
        Duration timeoutDuration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(audioInput));
        driver.findElement(audioInput).click();
    }

    public void selectAudioInputOption(String value) throws InterruptedException {
        Duration timeoutDuration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(audioInputOption1));
        driver.findElement(audioInputOption1).click();
    }

    public void isAudioInputCorrectValue(String audioInputText) throws InterruptedException {
        Duration timeoutDuration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(audioInput));

        WebElement element = driver.findElement(audioInput);
        ActionKeywords.isInputValuePresence(element, audioInputText);
    }

    public void isWaveIconDisplayed() {
        Duration timeoutDuration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(waveIcon));
        driver.findElement(waveIcon).isDisplayed();
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
