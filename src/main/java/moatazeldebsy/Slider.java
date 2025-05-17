package moatazeldebsy;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Slider {
    WebDriver driver;

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/slider");
    }

    @Test
    void checkAdjustSlider(){
        WebElement slider = driver.findElement(By.xpath("//input[@data-test='slider']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(slider)
                .sendKeys(Keys.ARROW_UP)
                .release()
                .perform();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].valueAsNumber = '80';", slider);
        System.out.println("Slider: "+ slider.getDomAttribute("value"));
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
