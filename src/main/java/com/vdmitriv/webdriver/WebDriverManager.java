package com.vdmitriv.webdriver;

import com.vdmitriv.config.ConfigUtil;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverManager {

    private WebDriver driver;

    public WebDriver getDriver(){
        if(this.driver == null) {
            this.driver = initDriver();
        }

        return this.driver;
    }

    private WebDriver initDriver() {
        switch (ConfigUtil.getBrowser()){
            case "Chrome":
                return initChromeDriver();
            case "FireFox":
                return initFireFoxDriver();
            default:
                return initChromeDriver();
        }
    }

    private FirefoxDriver initFireFoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        return new FirefoxDriver(options);
    }

    private ChromeDriver initChromeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return new ChromeDriver(options);
    }

    public void quitDriver(){
        driver.quit();
    }

}
