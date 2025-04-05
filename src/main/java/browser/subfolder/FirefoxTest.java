package browser.subfolder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirefoxTest {
    @Test
    void openWithDefaultMode(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(), "Selenium");
        driver.quit();
    }

//    @Test
//    void openWithHeadlessMode(){
//        System.setProperties("webdriver.gecko.drive",);
//        FirefoxDriver firefoxOptions = new FirefoxDriver();
//
//        WebDriver driver = new FirefoxDriver();
//        driver.get("https://www.selenium.dev/");
//        Assert.assertEquals(driver.getTitle(), "Selenium");
//        driver.quit();
//    }
}
