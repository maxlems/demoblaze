package org.example.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StudentMyStagePage {
    private final WebDriver driver;

    private final By myStageLogo = By
            .xpath("//header[@id='header']/div[@class='header_content']//img[@src='/MyStage/lp/img/logo_myStage-GR.36481e29.svg']");
    private final By myPreviewVideoInput = By.cssSelector(".local-video > span > span > video");
    private final By videoStreamingButtonOn = By.xpath(
            "//div[@id='video-column']//div[@class='video']/div[@class='video-btn-1 video-sm-button']/button[2]");
    private final By videoStreamingButtonOff = By.xpath(
            "//div[@id='video-column']//div[@class='video']/div[@class='video-btn-1 video-sm-button']/button[2]//img[@src='/MyStage/lp/img/camera_icn-off@2x.917e68d8.png']");
    private final By videoReconnectButton = By.cssSelector(".el-button.el-button--default.is-circle.reconnect");

    private final By navbarLeaveRoomButton = By.xpath("//div[@class='lesson_exit']//a[@type='primary']");
    private final By leaveRoomButton = By.xpath("//div[@role='dialog']//span[@class='dialog-footer']/button[2]");

    public StudentMyStagePage(WebDriver driver) {
        this.driver = driver;
    }

    public void getNavBarMystageLogo() throws Exception {
        Duration timeoutDuration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration); // Wait upto 10 seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(myStageLogo));

        driver.findElement(myStageLogo);
    }

    public void isMyVideoPreviewVisible() {
        Duration timeoutDuration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration); // Wait upto 10 seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(myPreviewVideoInput));

        Assert.assertTrue(driver.findElement(myStageLogo).isDisplayed());
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

    public void clickVideoStreamingButtonOn() {
        Duration timeoutDuration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration); // Wait upto 10 seconds
        wait.until(ExpectedConditions.elementToBeClickable(videoStreamingButtonOn));
        driver.findElement(videoStreamingButtonOn).click();
    }

    public void clickVideoStreamingButtonOff() {
        Duration timeoutDuration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration); // Wait upto 10 seconds
        wait.until(ExpectedConditions.elementToBeClickable(videoStreamingButtonOff));
        driver.findElement(videoStreamingButtonOff).click();
    }

    public void clickVideoReconnectButton() {
        Duration timeoutDuration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration); // Wait upto 10 seconds
        wait.until(ExpectedConditions.elementToBeClickable(videoStreamingButtonOff));
        driver.findElement(videoReconnectButton).click();
    }

    public void clickLeaveTheRoomOnNavaBar() {
        Duration timeoutDuration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration); // Wait upto 10 seconds
        wait.until(ExpectedConditions.elementToBeClickable(navbarLeaveRoomButton));
        driver.findElement(navbarLeaveRoomButton).click();
    }

    public void clickLeaveTheRoom() {
        Duration timeoutDuration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration); // Wait upto 10 seconds
        wait.until(ExpectedConditions.elementToBeClickable(leaveRoomButton));
        driver.findElement(leaveRoomButton).click();
    }

}
