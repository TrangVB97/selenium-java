package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EdgeTest {
    @Test
    void openWithDefaultMode(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(), "Selenium");
        driver.quit();
    }

    @Test
    void openWithHeadlessMode(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless");

        WebDriver driver = new EdgeDriver(options);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(), "Selenium");
        driver.quit();
    }
}
