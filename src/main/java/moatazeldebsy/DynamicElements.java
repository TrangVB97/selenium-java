package moatazeldebsy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicElements {
    WebDriver driver;

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/dynamic-elements");
    }

        @Test
    void checkReloadContentByTime() throws InterruptedException {
        WebElement reloadBtn = driver.findElement(By.xpath("//button[@data-test='reload-button']"));
        WebElement loading = driver.findElement(By.xpath("//*[@data-test='loading-indicator']"));
        WebElement content = driver.findElement(By.xpath("//*[@data-test='content-area']"));
        WebElement slider = driver.findElement(By.xpath("//input[@data-test='load-time-slider']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(slider.getSize().width / 20, 0).release().perform();
        Assert.assertTrue(loading.isDisplayed());
        Assert.assertFalse(content.isDisplayed());
        Thread.sleep(17000);
        Assert.assertTrue(content.isDisplayed());
    }

    @Test
    void checkHiddenContent(){
        WebElement toggle = driver.findElement(By.xpath("//button[@data-test='toggle-hidden-button']"));
        WebElement hiddenContent = driver.findElement(By.xpath("//*[@data-test='hidden-content']"));
        Assert.assertTrue(hiddenContent.getDomAttribute("class").equals("hidden"));

        toggle.click();
        Assert.assertTrue(hiddenContent.getDomAttribute("class").equals(""));
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
