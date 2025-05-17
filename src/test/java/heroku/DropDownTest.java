package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropDownTest {
    WebDriver driver;

    @BeforeMethod
    void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @Test
    void ableSelectSingleOption(){
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select select =  new Select(driver.findElement(By.id("dropdown")));
        select.selectByContainsVisibleText("Option 2");
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Option 2']")).isSelected());
    }

    @Test
    void ableSelectMultipleOptions(){
        driver.get("https://output.jsbin.com/osebed/2");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fruits")));

        Select select = new Select(driver.findElement(By.id("fruits")));
        select.selectByValue("banana");
        select.selectByValue("grape");

        Assert.assertTrue(driver.findElement(By.xpath("//option[@value='banana']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//option[@value='grape']")).isSelected());

        select.deselectAll();
        Assert.assertFalse(driver.findElement(By.xpath("//option[@value='banana']")).isSelected());
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
