package org.example.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.example.pages.LoginPage;
import org.example.utils.DataProviderUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.example.utils.ExtentReportListener.getTest;
import static org.example.utils.TestUtils.captureScreenShot;
import static org.testng.Assert.assertEquals;

public class LoginValidationTests extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderUtils.class)
    @Parameters("browser")
    public void testLogin(String username, String password, boolean isSuccessExpected, String testDescription) throws IOException {
        ExtentTest test = getTest();

        // Navigate to the login page
        test.info(testDescription + " on " + Webbrowser);
        test.info("Navigate to the login page: https://www.demoblaze.com/index.html#");
        driver.get("https://www.demoblaze.com/index.html");

        // Perform login
        LoginPage loginPage = new LoginPage(driver);
        test.info("Verify login with username: " + username + " and password: " + password);
        loginPage.navigatetoLogin();
        loginPage.login(username, password);

        String path = captureScreenShot(driver, "Login_");
        test.pass(MediaEntityBuilder.createScreenCaptureFromPath(path, "Login Successful").build());

        String loginResult = loginPage.isSuccessLogin(username);

        if (isSuccessExpected) {
            test.info("Verifying login success message");
            String newPath = captureScreenShot(driver, "Verify_");
            if (loginResult.equals("Login Successful")) {
                // Verify login success message
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath(newPath, "Login Successful").build());
                String logoutMessage = loginPage.clickLogout();
                test.pass("Login passed: " + loginResult);
            } else {
                test.fail("Login failed: expected 'Logged In Successfully' but got: " + loginResult);
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath(newPath, "Login Failed").build());
            }
        } else {
            String newPath = captureScreenShot(driver, "Verify_");
            // Login was expected to be unsuccessful
            test.pass("Login unsuccessful: Error message displayed - " + loginResult);
            test.pass(MediaEntityBuilder.createScreenCaptureFromPath(newPath, "Login Unsuccessful").build());
        }
    }
}
