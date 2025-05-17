package moatazeldebsy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class DragAndDrop {
    WebDriver driver;

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/drag-drop");
    }

    @Test
    void orderItemUsingMouse(){
        List<WebElement> items = driver.findElements(By.xpath("//div[@data-test='drag-drop-list']/div/button"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(items.get(0)).moveToElement(items.get(1)).release().perform();
        actions.clickAndHold(items.get(4)).moveToElement(items.get(3)).release().perform();
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }

}
