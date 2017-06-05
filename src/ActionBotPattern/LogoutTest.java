package ActionBotPattern;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

/**
 * Created by nikolai on 6/5/17.
 */
public class LogoutTest {
    static String login = "Nikolay.Chalykh@gmail.com";
    static String invalidLogin = "Putin";
    static String password = "12345678";
    static ChromeDriver driver;
    private ActionBot actionBot;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "res/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://lang-8.com/");
        actionBot = new ActionBot(driver);

        actionBot.click(By.id("login"));

        try {
            actionBot.fillTextArea(By.id("username"), login);
            actionBot.fillTextArea(By.id("password"), password);
        } catch (IOException e) {
            e.printStackTrace();
        }

        actionBot.click(By.name("commit"));
    }

    @Test
    public void logoutTest() {
        actionBot.moveCursorToElement(By.id("user_name_and_image"));
        actionBot.click(By.xpath("//a[@href='/sessions/delete']"));

        boolean res = true;

        try {
            driver.findElement(By.id("login"));
        } catch (NoSuchElementException e) {
            res = false;
        }

        Assert.assertEquals(true, res);
    }

    @After
    public void closeDriver() {
        driver.close();
    }
}
