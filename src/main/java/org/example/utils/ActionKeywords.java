package org.example.utils;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ActionKeywords {
    private final WebDriver driver;

    public ActionKeywords(WebDriver driver) {
        this.driver = driver;
    }

    public void switchTab(int tab) throws InterruptedException {
        try {
            ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(wid.get(tab));
            Thread.sleep(3000);
        } catch (Exception e) {
        }
    }

    public void isFieldVisible(WebElement element) throws InterruptedException {
        try {
            Assert.assertTrue(element.isDisplayed());
            Thread.sleep(3000);
        } catch (Exception e) {

        }
    }
}
