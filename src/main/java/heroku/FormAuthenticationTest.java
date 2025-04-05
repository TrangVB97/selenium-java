package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FormAuthenticationTest {

    WebDriver driver;

    @BeforeClass
    void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    void testFormAuthentication() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
//        chromeDriver.findElement(By.xpath("//input[contains(@name, 'password')]")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("[type=submit]")).click();
//        chromeDriver.findElement(By.xpath("//*[contains(text(),'Login')]")).click();
        Thread.sleep(5000);
//        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
