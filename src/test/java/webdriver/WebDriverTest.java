package webdriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.vdmitriv.webdriver.WebDriverManager;

public class WebDriverTest {

    private final WebDriverManager webDriverManager = new WebDriverManager();

    @Test
    public void chromeDriverTest(){

        var driver = webDriverManager.getDriver();

        driver.navigate().to("https://www.google.com/");

//        driver.findElement(By.name("q")).sendKeys("selenium");
//        driver.findElement(By.name("btnI")).click();

    }

    @AfterClass
    public void tearDown(){
        webDriverManager.quitDriver();
    }
}
