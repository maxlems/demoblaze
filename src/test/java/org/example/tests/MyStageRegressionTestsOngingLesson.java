package org.example.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.example.pages.StudentHomePage;
import org.example.pages.StudentLoginPage;
import org.example.pages.StudentMyStagePage;
import org.example.pages.StudentMyStageSettingPage;
import org.example.utils.ActionKeywords;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.example.utils.ExtentReportListener.getTest;
import static org.example.utils.TestUtils.captureScreenShot;

import org.example.actions.StudentActions;

public class MyStageRegressionTestsOngingLesson extends BaseTest {

    private String myStageUrl = "https://bizmates:=LJh+m4=tH+395-T@dev07.dev.bizmates.jp/MyBizmates/student/login";

    @Test
    @Parameters("browser")
    public void SK2_T330_UserCanEnterMyStage() throws Exception {
        ExtentTest test = getTest();
        String testDescription = "SK2_T330 User can enter MyStage";
        String userEmail = "uat-student+234933@bizmates.jpn";
        String password = "password";

        // Navigate to the student login page
        test.info(testDescription + " on " + WebBrowser);
        test.info("Navigate to the login page: https://dev07.dev.bizmates.jp/MyBizmates/student/login");
        driver.get(myStageUrl);

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

        StudentMyStageSettingPage myStageSettingPage = new StudentMyStageSettingPage(driver);
        test.pass("Student click the enter my stage button in MyStageSetting Page");
        myStageSettingPage.clickEnterMyStageButton();
        path = captureScreenShot(driver, "MyStage Page");
        test.pass(MediaEntityBuilder.createScreenCaptureFromPath(path, "MyStagePage").build());
        test.pass("Student Successfully entered MyStage");
    }

    @Test
    @Parameters("browser")
    public void SK2_T331_UserCanEnterMyStageBeforeLessonTime() throws Exception {
        ExtentTest test = getTest();
        String testDescription = "SK2_T331 User can enter MyStage before lesson time";
        String userEmail = "uat-student+234933@bizmates.jpn";
        String password = "password";

        test.info(testDescription + " on " + WebBrowser);
        test.info("Navigate to the login page: " + myStageUrl);
        driver.get(myStageUrl);

        StudentActions studentActions = new StudentActions(driver);
        studentActions.loginAndClickEnterMyStageButton(userEmail, password);

        StudentMyStageSettingPage myStageSettingPage = new StudentMyStageSettingPage(driver);
        test.pass("Student click the enter my stage button in MyStageSetting Page");
        myStageSettingPage.clickEnterMyStageButton();
        String path = captureScreenShot(driver, "MyStage Page");
        test.pass(MediaEntityBuilder.createScreenCaptureFromPath(path, "MyStagePage").build());
        test.pass("Student Successfully entered MyStage before lesson time");

        StudentMyStagePage myStagePage = new StudentMyStagePage(driver);

        myStagePage.isNavaBarMystageLogoVisible();

    }
}
