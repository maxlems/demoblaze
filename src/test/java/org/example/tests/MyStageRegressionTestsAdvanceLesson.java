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

public class MyStageRegressionTestsAdvanceLesson extends BaseTest {

    private String myStageUrl = "https://bizmates:=LJh+m4=tH+395-T@dev07.dev.bizmates.jp/MyBizmates/student/login";
    private String studentEmail = "uat-student+234933@bizmates.jpn";
    private String studentPassword = "password";
    private String videoInput = "Intel Virtual Camera";
    private String audioOutput = "Headset Earphone (Plantronics Blackwire 3220 Series)";
    private String audioInput = "Headset Microphone (Plantronics Blackwire 3220 Series)";

    @Test
    @Parameters("browser")
    public void SK2_T330_UserCanEnterMyStage() throws Exception {
        ExtentTest test = getTest();
        String testDescription = "SK2_T330 User can enter MyStage";

        // Navigate to the student login page
        test.info(testDescription + " on " + WebBrowser);
        test.info("Navigate to the login page: https://dev07.dev.bizmates.jp/MyBizmates/student/login");
        driver.get(myStageUrl);

        // Perform login
        StudentLoginPage loginPage = new StudentLoginPage(driver);
        test.info("Verify login with username: " + studentEmail + " and password: " + studentPassword);

        loginPage.login(studentEmail, studentPassword);
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

        test.info(testDescription + " on " + WebBrowser);
        test.info("Navigate to the login page: " + myStageUrl);
        driver.get(myStageUrl);

        StudentActions studentActions = new StudentActions(driver);
        studentActions.loginAndClickEnterMyStageButton(studentEmail, studentPassword);

        StudentMyStageSettingPage myStageSettingPage = new StudentMyStageSettingPage(driver);
        test.pass("Student click the enter my stage button in MyStageSetting Page");
        myStageSettingPage.clickEnterMyStageButton();
        String path = captureScreenShot(driver, "MyStage Page");
        test.pass(MediaEntityBuilder.createScreenCaptureFromPath(path, "MyStagePage").build());
        test.pass("Student Successfully entered MyStage before lesson time");

        StudentMyStagePage myStagePage = new StudentMyStagePage(driver);

        myStagePage.isNavaBarMystageLogoVisible();

    }

    @Test
    @Parameters("browser")
    public void SK2_T334_UserCanSelectVideoInputDeviceTheyUse() throws Exception {
        ExtentTest test = getTest();
        String testDescription = "SK2_T334 User can Select Video Input Device the use";

        test.info(testDescription + " on " + WebBrowser);
        test.info("Navigate to the login page: " + myStageUrl);
        driver.get(myStageUrl);

        StudentActions studentActions = new StudentActions(driver);
        studentActions.loginAndClickEnterMyStageButton(studentEmail, studentPassword);

        StudentMyStageSettingPage myStageSettingPage = new StudentMyStageSettingPage(driver);
        test.pass("Student is in MyStageSetting Page");
        String path = captureScreenShot(driver, "MyStage Page");
        test.pass(MediaEntityBuilder.createScreenCaptureFromPath(path, "MyStagePage").build());

        myStageSettingPage.clickVideoInput();
        test.pass("Student clicked the Video Input dropdown list");
        test.pass(MediaEntityBuilder.createScreenCaptureFromPath(path, "MyStage dropdown").build());
        myStageSettingPage.selectVideoInputOption(videoInput);
        test.pass("Student selected the video input: " + videoInput);

        myStageSettingPage.isVideoInputCorrectValue(videoInput);
        test.pass("Student selected the video input is correct: " + videoInput);
    }

    @Test
    @Parameters("browser")
    public void SK2_T335_UserCanSelectAudioInputDeviceTheyUse() throws Exception {
        ExtentTest test = getTest();
        String testDescription = "SK2_T334 User can Select Audio Input Device";

        test.info(testDescription + " on " + WebBrowser);
        test.info("Navigate to the login page: " + myStageUrl);
        driver.get(myStageUrl);

        StudentActions studentActions = new StudentActions(driver);
        studentActions.loginAndClickEnterMyStageButton(studentEmail, studentPassword);

        StudentMyStageSettingPage myStageSettingPage = new StudentMyStageSettingPage(driver);
        test.pass("Student is in MyStageSetting Page");
        String path = captureScreenShot(driver, "MyStage Page");
        test.pass(MediaEntityBuilder.createScreenCaptureFromPath(path, "MyStagePage").build());

        myStageSettingPage.clickAudioInput();
        test.pass("Student clicked the Video Input dropdown list");
        test.pass(MediaEntityBuilder.createScreenCaptureFromPath(path, "MyStage Audio dropdown").build());
        myStageSettingPage.selectVideoInputOption(audioInput);
        test.pass("Student selected the Audio input: " + audioInput);
    }

    @Test
    @Parameters("browser")
    public void SK2_T336_UserCanPreviewGraphicalAudioInputLevels() throws Exception {
        ExtentTest test = getTest();
        String testDescription = "SK2_T334 User can Select Audio Input Device";

        test.info(testDescription + " on " + WebBrowser);
        test.info("Navigate to the login page: " + myStageUrl);
        driver.get(myStageUrl);

        StudentActions studentActions = new StudentActions(driver);
        studentActions.loginAndClickEnterMyStageButton(studentEmail, studentPassword);

        StudentMyStageSettingPage myStageSettingPage = new StudentMyStageSettingPage(driver);
        test.pass("Student is in MyStageSetting Page");
        String path = captureScreenShot(driver, "MyStage Page");
        test.pass(MediaEntityBuilder.createScreenCaptureFromPath(path, "MyStagePage Settings").build());

        myStageSettingPage.clickAudioInput();
        test.pass("Student clicked the Video Input dropdown list");
        myStageSettingPage.selectVideoInputOption(audioInput);
        test.pass("Student selected the Audio input: " + audioInput);

        myStageSettingPage.isWaveIconDisplayed();
        test.pass("The wave Icon is displayed: " + audioInput);

    }

    // SK2_T334_UserCanSelectVideoInputDeviceTheyUse
}
