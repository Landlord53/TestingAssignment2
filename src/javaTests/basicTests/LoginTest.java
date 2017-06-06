package javaTests.basicTests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javaTests.BasicActions;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by nikolai on 6/4/17.
 */
public class LoginTest {
    static WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "res/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://lang-8.com/");
    }

    @Test
    public void loginTest() {
        BasicActions.login(BasicActions.login, BasicActions.password, driver);

        boolean result;
        try {
            result = driver.findElement(By.tagName("body")).getText().contains("Post an entry now!");
        } catch(Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            driver.close();
        }

        System.out.println("Test " + (result? "passed." : "failed."));
        if (!result) {
            System.exit(1);
        }
    }
}
