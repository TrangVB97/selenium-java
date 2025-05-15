package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenImagesTest {
    WebDriver driver;

    @BeforeTest
    void setUp(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--headless");
        driver = new ChromeDriver(option);
        driver.get("https://the-internet.herokuapp.com/broken_images");
    }

    @Test
    void checkBrokenImages(){
        List<WebElement> images = driver.findElements(By.cssSelector(".example img"));
        images.forEach(image -> {
            if (image.getDomProperty("naturalWidth").equals("0")) {
                System.out.println("Broken image found");
            } else {
                System.out.println("Image is not broken");
            }
        });
    }

    @AfterTest
    void tearDown() {
        driver.quit();
    }
}
