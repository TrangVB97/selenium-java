package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedFrameTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
    }

    @Test
    void verifyFrameContent(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("LEFT"));
    }

//    @AfterMethod
//    void tearDown(){
//        driver.quit();
//    }
}
