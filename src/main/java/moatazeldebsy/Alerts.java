package moatazeldebsy;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Alerts {
    WebDriver driver;

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/alerts");
    }

    @Test
    void verifySimpleAlert() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("//button[@data-test='alert-button']"));
        button.click();

        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().equals("This is a simple alert!"));
        alert.accept();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-test='result-container']")).getText().contains("Alert shown"));
    }

    @Test
    void verifyConfirmationAlert(){
        WebElement button = driver.findElement(By.xpath("//button[@data-test='confirm-button']"));
        button.click();

        Alert confirmAlert = driver.switchTo().alert();
        Assert.assertTrue(confirmAlert.getText().equals("Do you want to proceed?"));
        confirmAlert.accept();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-test='result-container']")).getText().contains("Confirm dialog: OK"));
    }

    @Test
    void getCheckButtonShowPrompt(){
        WebElement button = driver.findElement(By.xpath("//button[@data-test='prompt-button']"));
        button.click();

        Alert promptAlert = driver.switchTo().alert();
        Assert.assertTrue(promptAlert.getText().equals("Please enter your name:"));
        promptAlert.sendKeys("Nancy");
        promptAlert.accept();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-test='result-container']")).getText().contains("Prompt dialog: \"Nancy\""));
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
