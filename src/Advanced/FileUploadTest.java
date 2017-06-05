package Advanced;

import ActionBotPattern.ActionBot;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by nikolai on 6/5/17.
 */
public class FileUploadTest {
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
        moveToFileUploadPage();
    }

    @Test
    public void fileUploadTest() {
        File file = new File("res/file.jpg");
        driver.findElement(By.name("upfile")).sendKeys(file.getAbsolutePath());
        actionBot.click(By.name("submit"));
    }

    private void moveToFileUploadPage() {
        actionBot.click(By.id("login"));

        try {
            actionBot.fillTextArea(By.id("username"), login);
            actionBot.fillTextArea(By.id("password"), password);
        } catch (IOException e) {
            e.printStackTrace();
        }

        actionBot.click(By.name("commit"));

        actionBot.moveCursorToElement(By.id("user_name_and_image"));
        actionBot.click(By.xpath("//li//a[@href='/profiles/edit']"));

        actionBot.click(By.xpath("//div[@class='tab on_middle ']//a"));;
    }

    @After
    public void closeDriver() {
        driver.close();
    }
}
