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

public class HyperLinkTest {
    WebDriver driver;

    @BeforeTest
    void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    void checkHyperlinkText(){
        driver.get("https://the-internet.herokuapp.com/status_codes");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("200")));
        driver.findElement(By.linkText("200")).click();
        Assert.assertTrue(driver.findElement(By.className("example")).getText().contains("200 status code"));

        driver.findElement(By.linkText("here")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes");
        driver.findElement(By.linkText("301")).click();
        Assert.assertTrue(driver.findElement(By.className("example")).getText().contains("301 status code"));

        driver.findElement(By.linkText("here")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes");
        driver.findElement(By.linkText("404")).click();
        Assert.assertTrue(driver.findElement(By.className("example")).getText().contains("404 status code"));

        driver.findElement(By.linkText("here")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes");
        driver.findElement(By.linkText("500")).click();
        Assert.assertTrue(driver.findElement(By.className("example")).getText().contains("500 status code"));
    }

    @AfterTest
    void tearDown(){
        driver.quit();
    }
}
