package org.example.tests;

import org.example.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public abstract class BaseTest {
    protected static String Webbrowser;
    protected WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setup(String browser) throws InterruptedException {
        Thread.sleep(2000);
        Webbrowser = browser;
        driver = DriverManager.getDriver(browser);

    }

    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
