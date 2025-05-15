package flight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BookTicketTest {
    WebDriver driver;

    @BeforeMethod
    void setUp(){
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("permissions.default.geo", 2); // 1 = allow, 2 = deny
        profile.setPreference("permissions.default.desktop-notification", 2); // 1 = allow, 2 = deny
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        driver = new FirefoxDriver(options);
        driver.get("https://www.vietnamairlines.com/vn/vi/home");
    }

    @Test
    void selectDepartureDate() throws InterruptedException {
//        todo: click cookie
        driver.findElement(By.id("cookie-agree")).click();
//        todo: click ngày đi
        WebElement departureDate = driver.findElement(By.id("roundtrip-date-depart"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait
                .until(ExpectedConditions
                        .visibilityOf(departureDate))
                .click();
//        todo: click Một chiều
        wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//a[@data-content-title='Một chiều']")))
                .click();
        wait
                .until(ExpectedConditions
                        .visibilityOf(departureDate))
                        .click();
//        todo: select 07/04/2025
        driver.findElements(By.cssSelector(".ui-datepicker-group-first a"))
                .stream()
                .filter(el -> el.getText().equals("9"))
                .findFirst()
                .get()
                .click();
//        todo: verify
        String departDate = wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("roundtrip-date-depart")))
                .getDomProperty("value");
        Assert.assertEquals(departDate, "09/04/2025");
    }

    @AfterMethod
     void tearDown(){
        driver.quit();
    }
}
