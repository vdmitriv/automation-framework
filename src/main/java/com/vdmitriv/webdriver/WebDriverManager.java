package com.vdmitriv.webdriver;

import com.vdmitriv.config.ConfigUtil;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverManager {

    private static WebDriver driverInstance;

    public static WebDriver getDriver(){
        if(driverInstance == null) {
            driverInstance = initDriver();
        }

        return driverInstance;
    }

    private static WebDriver initDriver() {
        switch (ConfigUtil.getBrowser()){
            case "Chrome":
                return initChromeDriver();
            case "FireFox":
                return initFireFoxDriver();
            default:
                return initChromeDriver();
        }
    }

    private static FirefoxDriver initFireFoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        return new FirefoxDriver(options);
    }

    private static ChromeDriver initChromeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return new ChromeDriver(options);
    }

    public static void quitDriver(){
        driverInstance.quit();
    }

}
