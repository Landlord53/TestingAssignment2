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

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by nikolai on 6/7/17.
 */
public class HistoryTest {
    private LinkedList<String> urlList;
    static WebDriver driver;
    private ActionBot actionBot;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "res/chromedriver");
        urlList = new LinkedList<>();
        urlList.add("http://lang-8.com/");
        urlList.add("https://lang-8.com/login?from=header");
        urlList.add("http://blog.lang-8.com/post/19824923520/i-cannot-log-in");
        driver = new ChromeDriver();
        driver.get("http://lang-8.com/");
        actionBot = new ActionBot(driver);
        actionBot.click(By.xpath("//a[@href='https://lang-8.com/login?from=header']"));
        actionBot.click(By.xpath("//a[@href='/help/login']"));
    }

    @Test
    public void browserBackButtonTest() {
        Assert.assertEquals(urlList.getLast(), driver.getCurrentUrl());
        urlList.removeLast();
        driver.navigate().back();
        Assert.assertEquals(urlList.getLast(), driver.getCurrentUrl());
        urlList.removeLast();
        driver.navigate().back();
        Assert.assertEquals(urlList.getLast(), driver.getCurrentUrl());
        urlList.removeLast();
    }

    @After
    public void closeDriver() {
        driver.close();
    }
}
