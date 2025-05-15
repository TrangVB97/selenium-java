package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Browser {
    private static WebDriver driver;
    public static WebDriverWait wait;

    public static void openBrowser(String browserName){
        switch (browserName.toLowerCase()){
            case "safari":
                driver = new SafariDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                driver = new ChromeDriver(options);
                break;
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void visit(String url){
        driver.get(url);
    }

    public static void quit() {
        driver.quit();
    }

    public static void click(By by) {
        wait
                .until(ExpectedConditions.elementToBeClickable(by))
                .click();
    }

    public static void fill(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public static boolean isSelected(By by){
        return driver.findElement(by).isSelected();
    }

    public static void check(By by){
        if (!isSelected(by)){
            click(by);
        }
    }

    public static void uncheck(By by){
        if (isSelected(by)){
            click(by);
        }
    }

    public static String getText(By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
    }

    public static String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public static void captureScreenshot(String fileName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) Browser.getDriver();
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(String.format("target/screenshots-%s-%s.png", fileName, System.currentTimeMillis()));
        try {
            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
