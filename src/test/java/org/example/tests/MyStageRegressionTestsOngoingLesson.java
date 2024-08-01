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

public class MyStageRegressionTestsOngoingLesson extends BaseTest {

    private String myStageUrl = "https://bizmates:=LJh+m4=tH+395-T@dev07.dev.bizmates.jp/MyBizmates/student/login";
    private String studentEmail = "uat-student+234872@bizmates.jpn";
    private String studentPassword = "password";
    private String trainerEmail = "uat-trainer+17969@bizmates.jpn";
    private String trainerPassword = "password";
    private String myStageLink = "https://dev07.dev.bizmates.jp/MyStage/lesson/21043033?_=2024725142451";

    @Test
    @Parameters("browser")
    public void SK2_T396_In_the_MyStage_room_ensure_that_Agora_is_the_utilized_RTC() throws Exception {
        ExtentTest test = getTest();
        String testDescription = "SK2_T396 In the MyStage room ensure that Agora is the utilized RTC";

        test.info(testDescription + " on " + WebBrowser);
        test.info("Navigate to the login page: " + myStageUrl);
        driver.get(myStageUrl);

        StudentActions studentActions = new StudentActions(driver);
        studentActions.loginAndClickEnterMyStageButton("uat-student+234872@bizmates.jpn", studentPassword);

        // Need database testing to check if it is agora webRTC
    }

    @Test
    @Parameters("browser")
    public void SK2_T333_In_the_MyStage_room_ensure_that_AWS_Chime_is_the_utilized_RTC() throws Exception {
        ExtentTest test = getTest();
        String testDescription = "SK2_T396 In the MyStage room ensure that AWS Chime is the utilized RTC";

        test.info(testDescription + " on " + WebBrowser);
        test.info("Navigate to the login page: " + myStageUrl);
        driver.get(myStageUrl);

        StudentActions studentActions = new StudentActions(driver);
        studentActions.loginAndClickEnterMyStageButton(studentEmail, studentPassword);

        // Need database testing to check if it is AWS chime webRTC
    }

    @Test
    @Parameters("browser")
    public void SK2_T395_In_the_MyStage_room_ensure_that_Skyway_is_the_utilized_RTC() throws Exception {
        ExtentTest test = getTest();
        String testDescription = "SK2_T396 In the MyStage room ensure that Skyway is the utilized RTC";

        test.info(testDescription + " on " + WebBrowser);
        test.info("Navigate to the login page: " + myStageUrl);
        driver.get(myStageUrl);

        StudentActions studentActions = new StudentActions(driver);
        studentActions.loginAndClickEnterMyStageButton(studentEmail, studentPassword);

        // Need database testing to check if it is Skyway webRTC
    }

    @Test
    @Parameters("browser")
    public void SK2_T332_StudentUserCanEnterMyStageDuringLessonTime() throws Exception {
        ExtentTest test = getTest();
        String testDescription = "SK2_T332 Student User Can Enter MyStage During Lesson Time";

        // Navigate to the student login page
        test.info(testDescription + " on " + WebBrowser);
        test.info("Navigate to the login page: " + myStageUrl);
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

        StudentMyStagePage myStagePage = new StudentMyStagePage(driver);
        myStagePage.isNavaBarMystageLogoVisible();
        test.pass("Student Preview is visible");
    }

    @Test
    @Parameters("browser")
    public void SK2_T341_UserCanTurnTheirOwnVideoStreamOffOrOn() throws Exception {
        ExtentTest test = getTest();
        String testDescription = "SK2_T341 User Can Turn Their Own Video Stream Off Or On";

        // Navigate to the student login page
        test.info(testDescription + " on " + WebBrowser);
        test.info("Navigate to the login page: " + myStageUrl);
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

        StudentMyStagePage myStagePage = new StudentMyStagePage(driver);
        myStagePage.clickVideoStreamingButtonOff();
        test.pass("Video streaming button is turned off");
        Thread.sleep(3000);
        myStagePage.clickVideoStreamingButtonOn();
        test.pass("Video streaming button is turned on");
    }

    @Test
    @Parameters("browser")
    public void SK2_T342_UserCanRefreshTheirOwnVideoComponent() throws Exception {
        ExtentTest test = getTest();
        String testDescription = "SK2_T342 User Can Refresh Their Own Video Component";

        // Navigate to the student login page
        test.info(testDescription + " on " + WebBrowser);
        test.info("Navigate to the login page: " + myStageUrl);
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

        StudentMyStagePage myStagePage = new StudentMyStagePage(driver);
        myStagePage.clickVideoReconnectButton();
        test.pass("Video reconnect button is clicked");
        Thread.sleep(3000);
    }

    @Test
    @Parameters("browser")
    public void SK2_T350_StudentCanLeaveTheMyStageSessionDuringBookingTime() throws Exception {
        ExtentTest test = getTest();
        String testDescription = "SK2_T350 Student Can Leave The MyStage Session During Booking Time";

        // Navigate to the student login page
        test.info(testDescription + " on " + WebBrowser);
        test.info("Navigate to the login page: " + myStageUrl);
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

        StudentMyStagePage myStagePage = new StudentMyStagePage(driver);
        myStagePage.clickLeaveTheRoomButtonOnNavaBar();
        test.pass("Leave the room button is clicked");
        Thread.sleep(3000);

        myStagePage.clickLeaveTheRoomButton();
        test.pass("Leave the room button is clicked");
    }

    @Test
    @Parameters("browser")
    public void SK2_T351_StudentCanBackOutTheMyStageSessionDuringBookingTime() throws Exception {
        ExtentTest test = getTest();
        String testDescription = "SK2_T351 Student Can Back Out The MyStage Session During Booking Time";

        // Navigate to the student login page
        test.info(testDescription + " on " + WebBrowser);
        test.info("Navigate to the login page: " + myStageUrl);
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

        StudentMyStagePage myStagePage = new StudentMyStagePage(driver);
        myStagePage.clickLeaveTheRoomButtonOnNavaBar();
        test.pass("Leave the room button is clicked");
        Thread.sleep(3000);

        myStagePage.clickBackToLessonButton();
        test.pass("Back to lesson button is clicked");
    }

    @Test
    @Parameters("browser")
    public void SK2_T352_StudentCanBackOutTheMyStageSessionByClickingOutsideMenu() throws Exception {
        ExtentTest test = getTest();
        String testDescription = "SK2_T352 Student Can Back Out The MyStage Session By Clicking Outside Menu";

        // Navigate to the student login page
        test.info(testDescription + " on " + WebBrowser);
        test.info("Navigate to the login page: " + myStageUrl);
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

        StudentMyStagePage myStagePage = new StudentMyStagePage(driver);
        myStagePage.clickLeaveTheRoomButtonOnNavaBar();
        test.pass("Leave the room button is clicked");
        Thread.sleep(3000);

        myStagePage.clickOutSideModal();
        test.pass("Out side modal is clicked");
    }
}
