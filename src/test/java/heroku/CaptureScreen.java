package heroku;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v131.page.model.Screenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class CaptureScreen {
    WebDriver driver;

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        driver.get("https://testingvn.gitbook.io/automationtester/getting-started/test-cases");
    }

    @Test
    void screenShotTest(){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File desFile = new File(String.format("screenshot-%s-%s.png","context-menu",System.currentTimeMillis()));
        try {
            FileUtils.copyFile(srcFile, desFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
