package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HorizontalSliderTest {
    WebDriver driver;

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
    }

    @Test
    void horizontalSliderTest(){
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        Actions actions = new Actions(driver);

        int width = slider.getSize().getWidth();
        actions.clickAndHold(slider)
                .moveByOffset(width/10,0)
                .release()
                .perform();
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
