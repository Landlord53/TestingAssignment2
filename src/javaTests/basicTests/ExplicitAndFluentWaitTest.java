package javaTests.basicTests;

import com.google.common.base.Function;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import javaTests.BasicActions;
import java.util.concurrent.TimeUnit;

/**
 * Search Google example.
 *
 * @author Rahul
 */
public class ExplicitAndFluentWaitTest {
    static WebDriver driver;
    static Wait<WebDriver> wait;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "res/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://lang-8.com/");
        wait = new WebDriverWait(driver, 30);

    }

    @Test
    public void explicitWaitTest() {
        BasicActions.login(BasicActions.login, BasicActions.password, driver);

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.id("user_name_and_image"))).build().perform();
        WebElement element = driver.findElement(By.xpath("//a[@href='/profiles/edit']"));

        element = wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();

        Assert.assertEquals("http://lang-8.com/profiles/edit", driver.getCurrentUrl());
    }

    @Test
    public void fluentWaintTest() {
        BasicActions.login(BasicActions.login, BasicActions.password, driver);

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.id("user_name_and_image"))).build().perform();
        WebElement element = driver.findElement(By.xpath("//a[@href='/profiles/edit']"));

        element = wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();

        FluentWait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        element = wait1.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//input[@class='input_submit bt_lv1 bt_size_01']"));
            }
        });
    }

    @After
    public void closeDriver() {
        driver.close();
    }
}
