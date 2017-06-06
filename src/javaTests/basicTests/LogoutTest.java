package javaTests.basicTests;

import javaTests.BasicActions;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by nikolai on 6/4/17.
 */
public class LogoutTest {
    static WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "res/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://lang-8.com/");
    }

    @Test
    public void logoutTest() {
        boolean result;
        BasicActions.login(BasicActions.login, BasicActions.password, driver);
        logout();

        try {
            result = driver.findElement(By.id("login")) != null;
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

    private static void logout() {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.id("user_name_and_image"))).build().perform();
        driver.findElement(By.xpath("//a[@href='/sessions/delete']")).click();
    }
}
