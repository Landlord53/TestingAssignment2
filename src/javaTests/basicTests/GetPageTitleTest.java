package javaTests.basicTests;

import javaTests.BasicActions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by nikolai on 6/4/17.
 */
public class GetPageTitleTest {
    static WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "res/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://lang-8.com/");
    }

    @Test
    public void getPageTitleTest() {
        String title = driver.getTitle();
        Assert.assertEquals(BasicActions.validTitle, title);
    }

    @After
    public void closeDriver() {
        driver.close();
    }
}
