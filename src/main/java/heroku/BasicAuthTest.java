package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasicAuthTest {
    WebDriver driver;

    @BeforeTest
    void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    void verifyBasicAuth(){
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("content"))));
        Assert.assertTrue(driver.findElement(By.id("content")).getText().contains("Congratulations"));
    }

    @AfterTest
    void tearDown(){
        driver.quit();
    }
}
