package org.example.tests;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.example.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest {
    protected static String WebBrowser;
    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) throws InterruptedException, MalformedURLException, URISyntaxException {
        Thread.sleep(2000);
        WebBrowser = browser;
        driver = DriverManager.getDriver(browser);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
