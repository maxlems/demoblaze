package org.example.utils;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

public class DriverManager {
    public static WebDriver driver;

    public static WebDriver getDriver(String browser) throws MalformedURLException, URISyntaxException {
        String gridURL = "https://marlito.barrozo:NO3gcVwtRZ9GZGKuqivpGD8U2JaAGJj29epVrrPV1Z7vKZlIAc@https://hub.lambdatest.com/wd/hub";

        if (driver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "/src/test/resources/webdriver/chromedriver.exe");
                // Set the preferences to allow camera, microphone, and audio access
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("profile.default_content_setting_values.media_stream_camera", 1);
                prefs.put("profile.default_content_setting_values.media_stream_mic", 1);
                prefs.put("profile.default_content_setting_values.media_stream", 1);
                options.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(options);
            } else if (browser.equalsIgnoreCase("edge")) {
                EdgeOptions options = new EdgeOptions();
                System.setProperty("webdriver.edge.driver",
                        System.getProperty("user.dir") + "/src/test/resources/webdriver/msedgedriver.exe");

                Map<String, Object> prefs = new HashMap<>();
                prefs.put("profile.default_content_setting_values.media_stream_camera", 1);
                prefs.put("profile.default_content_setting_values.media_stream_mic", 1);
                prefs.put("profile.default_content_setting_values.media_stream", 1);
                options.setExperimentalOption("prefs", prefs);

                driver = new EdgeDriver(options);
            } else if (browser.equalsIgnoreCase("mac_safari")) {
                SafariOptions safariOptions = new SafariOptions();
                safariOptions.setCapability("browserName", "safari");
                safariOptions.setCapability("browserVersion", "latest");
                safariOptions.setCapability("platformName", "macOS Sonoma");

                Map<String, Object> ltOptions = new HashMap<>();
                ltOptions.put("build", "MyStageRegressionTests");
                ltOptions.put("name", "MyStage Regression Test");
                safariOptions.setCapability("LT:Options", ltOptions);

                driver = new RemoteWebDriver(new URI(gridURL).toURL(), safariOptions);
            }
            if (driver != null) {
                driver.manage().window().maximize();
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
