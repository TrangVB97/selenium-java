package moatazeldebsy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Base64;

public class FileUpload {
    WebDriver driver;

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/file-upload");
    }

    @Test (priority = 1)
    void verifyTraditionalFileInput(){
        WebElement uploadElement = driver.findElement(By.xpath("//input[@data-test='file-input']"));
        uploadElement.sendKeys("C:\\Users\\admin\\IdeaProjects\\AK48\\src\\main\\java\\moatazeldebsy\\example.txt");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='uploaded-files']")));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-test='uploaded-files']")).getText().contains("Uploaded Files"));
        Assert.assertTrue(driver.findElement(By.xpath("//li[@data-test='uploaded-file-0']")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@data-test='uploaded-file-0']")).getText().contains("example.txt"));
    }

    @Test (priority = 2)
    void verifyDragAndDropFileArea() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement area = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='drop-zone']")));

        String filePath = "C:\\Users\\admin\\IdeaProjects\\AK48\\src\\main\\java\\moatazeldebsy\\example.txt";
        byte[] fileContent = Files.readAllBytes(Paths.get(filePath));
        String base64String = Base64.getEncoder().encodeToString(fileContent);

//         Execute JavaScript to simulate file drop
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "var dt = new DataTransfer();" +
                "var byteCharacters = atob(arguments[0]);" +
                "var byteNumbers = new Array(byteCharacters.length);" +
                "for (var i = 0; i < byteCharacters.length; i++) {" +
                "    byteNumbers[i] = byteCharacters.charCodeAt(i);" +
                "}" +
                "var byteArray = new Uint8Array(byteNumbers);" +
                "var file = new File([byteArray], 'example.txt', {type: 'text/plain'});" +
                "dt.items.add(file);" +
                "var event = new DragEvent('drop', {dataTransfer: dt, bubbles: true, cancelable: true});" +
                "arguments[1].dispatchEvent(event);";
        js.executeScript(script,base64String, area);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='uploaded-files']")));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-test='uploaded-files']")).getText().contains("Uploaded Files"));
        Assert.assertTrue(driver.findElement(By.xpath("//li[@data-test='uploaded-file-0']")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@data-test='uploaded-file-0']")).getText().contains("example.txt"));
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
