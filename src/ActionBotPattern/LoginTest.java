package ActionBotPattern;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectPattern.HomePage;
import pageObjectPattern.LoginPage;

import java.io.IOException;

/**
 * Created by nikolai on 6/5/17.
 */
public class LoginTest {
    static String login = "Nikolay.Chalykh@gmail.com";
    static String invalidLogin = "Putin";
    static String password = "12345678";
    static ChromeDriver driver;
    ActionBot actionBot;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "res/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://lang-8.com/");
        actionBot = new ActionBot(driver);
    }

    @Test
    public void loginTest() {
        actionBot.click(By.id("login"));

        try {
            actionBot.fillTextArea(By.id("username"), login);
            actionBot.fillTextArea(By.id("password"), password);
        } catch (IOException e) {
            e.printStackTrace();
        }

        actionBot.click(By.name("commit"));

        boolean res = true;

        try {
            driver.findElement(By.id("user_name_and_image"));
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
