package moatazeldebsy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class FormsAndValidation {
    WebDriver driver;

    @BeforeMethod
    void setUp()
    {
        driver = new ChromeDriver();
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/forms");
    }

    @Test
    void checkSignInWithUsernameEmpty() {
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        validateField("username",false);
    }

    @Test
    void checkSignInWithEmailEmpty(){
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        validateField("email", false);
    }

    @Test
    void checkSignInWithPasswordEmpty(){
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        validateField("password", false);
    }

    @Test
    void checkSignInWithInvalidEmail() {
        fillForm("Nancy", "nancy123@gmail", "Nancy@123");
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@data-test='email-error']")).getText(), "Email is invalid");
    }

    @Test
    void checkSignInWithPasswordLess6Characters(){
        fillForm("Nancy", "nancy123@gmail.com", "Nan@1");
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@data-test='password-error']")).getText(), "Password must be at least 6 characters");
    }

    @Test
    void checkSignInWithEmailMissingSpecial(){
        fillForm("Nancy", "nancy", "Nancy@123");
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("button[type=submit]")).isEnabled());
    }

    @Test
    void checkSignInWithNetworkDelay() throws InterruptedException {
        fillForm("Nancy","nancy123@gmail.com","Nancy@123");
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        Assert.assertFalse(driver.findElement(By.cssSelector("button[type=submit]")).isEnabled());
    }

    @AfterMethod
    void tearDown()
    {
        driver.quit();
    }

    void validateField(String name, Boolean valid){
        String message = name.substring(0,1).toUpperCase() + name.substring(1);
        if (!valid){
            Assert.assertEquals(driver.findElement(By.xpath("//*[@data-test='" + name + "-error']")).getText(),message + " is required");
        }
    }

    void fillForm(String username, String email, String password){
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
    }
}
