package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragDropTest {
    WebDriver driver;

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
    }

    @Test
    void dragDropTest(){
        WebElement boxA = driver.findElement(By.id("column-a"));
        WebElement boxB = driver.findElement(By.id("column-b"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(boxA,boxB).perform();

        Assert.assertTrue(driver.findElement(By.cssSelector("#column-a header")).getText().contains("B"));
        Assert.assertTrue(driver.findElement(By.cssSelector("#column-b header")).getText().contains("A"));
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
