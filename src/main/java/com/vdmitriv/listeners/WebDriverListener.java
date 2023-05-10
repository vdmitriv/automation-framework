package com.vdmitriv.listeners;

import com.vdmitriv.webdriver.Utils;
import com.vdmitriv.webdriver.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class WebDriverListener implements ITestListener {

    public void onTestFailure(ITestResult result){
        File screenshot = Utils.makeScreenshot(WebDriverManager.getDriver());

        //Copy screenshot to destination
        String timeStamp = new Date().toString().replace(":", "_").replace(" ", "_");
        File destination = new File("./Screenshots/"+ result.getMethod().getMethodName() + "_" + timeStamp + ".png");

        try {
            FileUtils.copyFile(screenshot, destination);
        } catch (IOException e) {
            throw new RuntimeException("Could not copy failed test screenshot: " + e.getMessage());
        }
    }


}
