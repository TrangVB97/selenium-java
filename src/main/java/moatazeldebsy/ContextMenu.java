package moatazeldebsy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ContextMenu {
    WebDriver driver;

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/context-menu");
    }

    @Test
    void checkEnableRightClick(){
        WebElement contextArea = driver.findElement(By.xpath("//div[@data-test='context-menu-area']"));

        Actions actions = new Actions(driver);
        actions.contextClick(contextArea).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='context-menu']")));

        List<WebElement> buttonList = driver.findElements(By.xpath("//div[@data-test='context-menu']/button"));
        buttonList.forEach(button -> System.out.println(button.getText()));
        buttonList.forEach(button -> System.out.println(button.getDomAttribute("data-test")));
    }

    @Test (dependsOnMethods = "checkEnableRightClick")
    void checkClickEnableClickMenuItem(){
        WebElement contextArea = driver.findElement(By.xpath("//div[@data-test='context-menu-area']"));

        Actions actions = new Actions(driver);
        actions.contextClick(contextArea).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='context-menu']")));

        List<WebElement> buttonList = driver.findElements(By.xpath("//div[@data-test='context-menu']/button"));
        buttonList.getFirst().click();
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
