package javaTests.advanced;

import javaTests.BasicActions;
import javaTests.actionBotPattern.ActionBot;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by nikolai on 6/7/17.
 */
public class HoverTest {
    static WebDriver driver;
    private WebElement elem;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "res/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://lang-8.com/login?from=header");
        BasicActions.login(BasicActions.login, BasicActions.password, driver);
         elem = driver.findElement(By.xpath("//a[@href='/sessions/delete']"));
    }

    @Test
    public void HoverTestWithACoursorAboveCheckedElem() {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.id("user_name_and_image"))).build().perform();

        Assert.assertEquals(true, elem.isDisplayed());
    }

    @Test
    public void HoverTestWithACoursorNotAboveCheckedElem() {
        Assert.assertEquals(false, elem.isDisplayed());
    }

    @After
    public void closeDriver() {
        driver.close();
    }
}
