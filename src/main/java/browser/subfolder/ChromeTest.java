package browser.subfolder;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ChromeTest {
    @Test
    void openWithDefaultMode(){
        new ChromeDriver();
    }
}
