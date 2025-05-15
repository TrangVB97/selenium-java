package pages.heroku;

import org.openqa.selenium.By;

import static utils.Browser.*;

public class CheckboxPage {

    private static final String CHECKBOX1 = "//form[@id='checkboxes']/input[1]";
    private static final String CHECKBOX2 = "//form[@id='checkboxes']/input[2]";
    private static final String CHECK_ALL_BUTTON = "//button[@data-test='check-all-button']";
    private static final String UNCHECK_ALL_BUTTON = "//button[@data-test='uncheck-all-button']";

    public void open(){
        visit("https://the-internet.herokuapp.com/checkboxes");
    }

    public void checkCheckbox1() {
        check(By.xpath(CHECKBOX1));
    }

    public void checkCheckbox2() {
        check(By.xpath(CHECKBOX2));
    }

    public void uncheckCheckbox1() {
        uncheck(By.xpath(CHECKBOX1));
    }

    public void uncheckCheckbox2() {
        uncheck(By.xpath(CHECKBOX2));
    }

}
