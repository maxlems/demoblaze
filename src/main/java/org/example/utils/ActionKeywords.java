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

    public static void isTextPresence(WebElement element, String expectedInputValue) throws InterruptedException {

        String actualValue = element.getText();
        System.out.println("Actual value: " + actualValue);

        try {
            Assert.assertTrue(expectedInputValue.equals(actualValue));
        } catch (Exception e) {
            System.out.println("Actual value: " + actualValue);
            Assert.fail();
        }
    }

    public static void isInputValuePresence(WebElement element, String expectedInputValue) throws InterruptedException {

        String actualValue = element.getAttribute("value");
        System.out.println("Actual value: " + actualValue);

        try {
            Assert.assertTrue(expectedInputValue.equals(actualValue));
        } catch (Exception e) {
            System.out.println("Actual value: " + actualValue);
            Assert.fail();
        }
    }

}
