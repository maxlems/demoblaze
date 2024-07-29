package org.example.actions;

import static org.example.utils.ExtentReportListener.getTest;
import static org.example.utils.TestUtils.captureScreenShot;

import org.example.pages.StudentHomePage;
import org.example.pages.StudentLoginPage;
import org.example.utils.ActionKeywords;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class StudentActions {
    private final WebDriver driver;

    public StudentActions(WebDriver driver) {
        this.driver = driver;
    }

    public void loginAndClickEnterMyStageButton(String userEmail, String password) throws InterruptedException {
        ExtentTest test = getTest();

        // Perform login
        StudentLoginPage loginPage = new StudentLoginPage(driver);
        test.info("Verify login with username: " + userEmail + " and password: " + password);

        loginPage.login(userEmail, password);
        String path = captureScreenShot(driver, "Login_");
        test.pass(MediaEntityBuilder.createScreenCaptureFromPath(path, "Login Successful").build());

        StudentHomePage homePage = new StudentHomePage(driver);
        test.info("Student click the enter my stage button in Homepage");
        homePage.clickEnterMyStageButton();
        ActionKeywords actionKeywords = new ActionKeywords(driver);
        actionKeywords.switchTab(1);
        path = captureScreenShot(driver, "MyStageSetting_");
        test.pass(MediaEntityBuilder.createScreenCaptureFromPath(path, "MyStageSetting").build());
        test.pass("Student is in MyStageSetting Page");
    }

}
