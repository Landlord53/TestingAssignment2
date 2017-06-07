package javaTests.advanced;

import javaTests.BasicActions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by nikolai on 6/7/17.
 */
public class DragAndDropTest {
    static WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "res/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://lang-8.com/login?from=header");
    }

    @Test
    public void dragAndDropTest() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
        //driver.switchTo().frame(0);
        WebElement from = driver.findElement(By.id("login"));
        WebElement to   = driver.findElement(By.id("username"));

        Actions builder = new Actions(driver);

        try {
            builder.clickAndHold(from).build().perform();
            Thread.sleep(5000);
            builder.release(to).build().perform();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals("https://lang-8.com/auth/twitter", to.getAttribute("value"));
    }

    @After
    public void closeDriver() {
        driver.close();
    }
}
