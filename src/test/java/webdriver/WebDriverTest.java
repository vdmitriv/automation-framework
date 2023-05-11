package webdriver;

import com.vdmitriv.listeners.WebDriverListener;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.vdmitriv.webdriver.WebDriverManager;

@Listeners(WebDriverListener.class)
public class WebDriverTest {

    @Test
    public void chromeDriverTest(){

        var driver = WebDriverManager.getDriver();

        driver.navigate().to("https://www.google.com/");

//        driver.findElement(By.name("q")).sendKeys("selenium");
//        driver.findElement(By.name("btnI")).click();

    }

    @AfterClass
    public void tearDown(){
        WebDriverManager.quitDriver();
    }
}
