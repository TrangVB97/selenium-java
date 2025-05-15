package browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class ChromeTest {
    @Test
    void openWithDefaultMode(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(), "Selenium");
        driver.quit();
    }

    @Test
    void openWithHeadlessMode(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(), "Selenium");
        driver.quit();
    }

    @Test
    void openBrowserWithMobileViewMode(){
        Map<String, Object> deviceMatrics = new HashMap<>();
        deviceMatrics.put("width", 344);
        deviceMatrics.put("height", 882);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMatrics);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getTitle(), "Selenium");
        driver.quit();
    }

    @Test
    void openBrowserWithOldVersion(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("129");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(), "Selenium");
        driver.quit();
    }

    @Test
    void fakeGeoLocation(){
        WebDriver cDriver = new ChromeDriver();
//        access Chrome DevTools Protocol (CDP)
        DevTools devTools = ((HasDevTools)cDriver).getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setGeolocationOverride(
                Optional.of(37.386052),
                Optional.of(-122.083851),
                Optional.of(1)
        ));
        cDriver.get("https://the-internet.herokuapp.com/geolocation");
        cDriver.findElement(By.tagName("button")).click();

        Assert.assertEquals(cDriver.findElement(By.id("lat-value")).getText(),"37.386052");
        Assert.assertEquals(cDriver.findElement(By.id("long-value")).getText(), "-122.083851");
        cDriver.quit();
    }
}

