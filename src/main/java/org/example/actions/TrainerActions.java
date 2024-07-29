package org.example.actions;

import static org.example.utils.ExtentReportListener.getTest;
import static org.example.utils.TestUtils.captureScreenShot;

import org.example.pages.StudentHomePage;
import org.example.pages.StudentLoginPage;
import org.example.utils.ActionKeywords;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class TrainerActions {
    private final WebDriver driver;

    public TrainerActions(WebDriver driver) {
        this.driver = driver;
    }

    public void loginAndClickEnterMyStageButton(String userEmail, String password) throws InterruptedException {

    }

}
