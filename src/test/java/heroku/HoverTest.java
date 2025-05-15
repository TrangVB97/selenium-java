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

public class HoverTest {
    WebDriver driver;

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
    }

    @Test
    void hoverTest(){
//        todo: When user hover on user 1 avatar
        WebElement ava1 = driver.findElement(By.xpath("//div[@class='example']/div[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(ava1).perform();
//        todo: Then the "name: user1" label is present.
        WebElement user1 = driver.findElement(By.xpath("//div[@class='example']/div[1]/div[@class='figcaption']/h5"));
        Assert.assertEquals(user1.getText(),"name: user1");
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}