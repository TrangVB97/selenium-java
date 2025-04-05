package moatazeldebsy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

public class FileDownload {

    @Test
    void verifyDownloadFile() throws InterruptedException {
        // Set download folder
        String downloadFilePath = "C:\\Users\\admin\\Desktop\\selenium-downloads";

        // Create folder if it doesn't exist
        File folder = new File(downloadFilePath);
        if (!folder.exists()) folder.mkdirs();

        // Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-notifications");

        // Set Chrome download preferences
        HashMap<String, Object> chromePrefs = new java.util.HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilePath);
        options.setExperimentalOption("prefs", chromePrefs);

        // Launch browser
        WebDriver driver = new ChromeDriver(options);

        // Go to download page and click the download link/button
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/file-download"); // Change this to your actual URL
        driver.findElement(By.xpath("//button[@data-test='download-button-0']")).click(); // Adjust selector

        // Wait for download to complete
        String expectedFileName = "sample.txt";

        boolean isDownloaded = waitForFile(downloadFilePath, expectedFileName, 30); // 30 seconds timeout

        driver.quit();
    }

public static boolean waitForFile(String dirPath, String fileName, int timeoutSeconds) throws InterruptedException {
    File dir = new File(dirPath);
    File file = new File(dirPath + File.separator + fileName);
    int waited = 0;

    while (waited < timeoutSeconds) {
        // If file exists and no ".crdownload" extension is left
        File[] files = dir.listFiles((d, name) -> name.equals(fileName));
        if (files != null && files.length > 0) {
            return true;
        }

        Thread.sleep(1000);
        waited++;
    }
    return false;
    }
}
