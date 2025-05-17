package moatazeldebsy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HoverState {
    WebDriver driver;

    @BeforeMethod
    void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/hover");
    }

    @Test
    void checkHoverState(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hoverExample = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test='hover-example']")));
        List<WebElement> images = driver.findElements(By.xpath("//*[@data-test='hover-example']/div"));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@data-test='"+images.get(0).getDomAttribute("data-test")+"']"))).perform();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-test='hover-caption-1']")).isEnabled());
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
