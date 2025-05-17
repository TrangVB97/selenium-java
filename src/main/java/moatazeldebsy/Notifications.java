package moatazeldebsy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Notifications {
    WebDriver driver;

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/notifications");
    }

    @Test
    void checkShowThreeButtons() {
        List<WebElement> buttons = driver.findElements(By.xpath("//div[@data-test='notification-example']/div/button"));

        Assert.assertTrue(buttons.size()==3);
        Assert.assertEquals(buttons.getFirst().getText(), "Success Message");
        Assert.assertEquals(buttons.get(1).getText(), "Error Message");
        Assert.assertEquals(buttons.getLast().getText(), "Info Message");
    }

    @Test
    void checkCorrectAlertMessage(){
        List<WebElement> buttons = driver.findElements(By.xpath("//div[@data-test='notification-example']/div/button"));

        buttons.getFirst().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='notification-container']/div")));
    }

    @Test
    void checkCloseMessage() throws InterruptedException {
        List<WebElement> buttons = driver.findElements(By.xpath("//div[@data-test='notification-example']/div/button"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        buttons.getFirst().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='notification-container']/div")));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-test='notification-container']/div")).getText().equals("This is a success notification message."));
        driver.findElement(By.xpath("//div[@data-test='notification-container']/div/button")).click();

        buttons.getLast().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='notification-container']/div")));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-test='notification-container']/div")).getText().equals("This is a info notification message."));
        driver.findElement(By.xpath("//div[@data-test='notification-container']/div/button")).click();

        buttons.get(1).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='notification-container']/div")));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-test='notification-container']/div")).getText().equals("This is a error notification message."));
        driver.findElement(By.xpath("//div[@data-test='notification-container']/div/button")).click();

    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
