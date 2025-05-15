package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TableTest {
    WebDriver driver;

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
    }
    @Test
    void validateLargestDuePerson1(){
//        todo: focus on table 1
        WebElement table = driver.findElement(By.id("table1"));
//        todo: The person who has largest due
        List<Double> dueList = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .map(cel -> Double.valueOf(cel.getText().replace("$","")))
                .collect(Collectors.toList());
//        todo: assert "Jason Doe"
        Double maxDue = Collections.max(dueList);
        int rowIndex = dueList.indexOf(maxDue)+1;
        String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[1]")).getText();
        String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[2]")).getText();
        Assert.assertEquals(String.format("%s %s", firstName, lastName), "Jason Doe");
    }

    @Test
    void validateLargestDuePerson2(){
//        todo: focus on table 2
        List<Double> dueList = driver.findElements(By.xpath("//table[@id='table2']/tbody/tr/td[@class='dues']"))
                .stream()
                .map(cel -> Double.valueOf(cel.getText().replace("$","")))
                .collect(Collectors.toList());
//        todo: find max due
        Double maxDue = Collections.max(dueList);
//        todo: find person who have max due
        int rowIndex = dueList.indexOf(maxDue)+1;
        String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[1]")).getText();
        String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[2]")).getText();
//        todo: assert
        Assert.assertEquals(String.format("%s %s", firstName, lastName), "Jason Doe");
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
