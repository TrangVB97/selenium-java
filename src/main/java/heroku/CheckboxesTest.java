package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckboxesTest
{
    WebDriver driver;

    @BeforeClass
    void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    void verifySelectCheckboxWorking(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement cbx1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        checkCheckbox(cbx1);
        Assert.assertTrue(cbx1.isSelected());
        WebElement cbx2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        checkCheckbox(cbx2);
        Assert.assertTrue(cbx2.isSelected());
    }

    @Test
    void verifyUncheckCheckboxWorking(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement cbx1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        uncheckCheckbox(cbx1);
        Assert.assertFalse(cbx1.isSelected());
        WebElement cbx2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        uncheckCheckbox(cbx2);
        Assert.assertFalse(cbx2.isSelected());
    }
    @Test
    void verifyButtonCheckAllWorking(){
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");
        driver.findElement(By.xpath("//button[@data-test='check-all-button']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox1']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox2']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox3']")).isSelected());
    }

    @Test
    void verifyButtonUncheckAllWorking(){
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");
        driver.findElement(By.xpath("//button[@data-test='uncheck-all-button']")).click();

        Assert.assertFalse(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox1']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox2']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox3']")).isSelected());
    }

    @AfterTest
    void tearDown(){
        driver.quit();
    }

    void checkCheckbox(WebElement element){
        if(!element.isSelected()){
            element.click();
        }
    }

    void uncheckCheckbox(WebElement element){
        if(element.isSelected()){
            element.click();
        }
    }
}
