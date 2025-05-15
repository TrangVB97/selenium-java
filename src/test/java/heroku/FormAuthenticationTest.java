package heroku;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.heroku.FormAuthenticationPage;
import utils.Browser;

import static utils.Browser.*;

public class FormAuthenticationTest extends TestBase {
    FormAuthenticationPage formAuthenticationPage;

    @BeforeClass
    void setUp() {
        openBrowser("chrome");
        formAuthenticationPage = new FormAuthenticationPage();
    }

    @Parameters({"browser"})
    @Test
    void tc01(String browser) {
        formAuthenticationPage
                .open()
                .login("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(formAuthenticationPage
                .getWelcomeMessage()
                .contains("Welcome to the Secure Area"));
    }

    @AfterClass
    void tearDown() {
        quit();
    }
}
