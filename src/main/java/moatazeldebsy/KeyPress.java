package moatazeldebsy;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;

public class KeyPress {
    WebDriver driver;

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/key-press");
    }

    @Test
    void verifyPressKey(){
        WebElement element = driver.findElement(By.xpath("//*[@data-test='last-key-pressed']"));

        Actions actions = new Actions(driver);
        actions.click(element).sendKeys(Keys.ENTER).perform();
        actions.click(element).sendKeys("T").perform();
        actions.click(element).sendKeys(Keys.TAB).perform();

    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
