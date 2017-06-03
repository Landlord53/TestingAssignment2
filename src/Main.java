import static org.junit.Assert.*;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Search Google example.
 *
 * @author Rahul
 */
public class Main {
    static WebDriver driver;
    static Wait<WebDriver> wait;

    @Test
    public void mainTest() {
        System.setProperty("webdriver.chrome.driver", "res/chromedriver");
        driver = new ChromeDriver();
        // https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/ui/WebDriverWait.html
        wait = new WebDriverWait(driver, 30);
        driver.get("http://lang-8.com/");

        boolean result;
        try {
            result = FillSimpleFormAndSend();
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

    private static void login() {
        driver.findElement(By.id("login")).click();

        driver.findElement(By.name("username")).sendKeys("nikolay.chalykh@gmail.com");
        driver.findElement(By.name("password")).sendKeys("42908326");

        driver.findElement(By.name("commit")).click();
    }

    private static boolean FillSimpleFormAndSend() {
        login();
        boolean res = driver.findElement(By.tagName("body")).getText().contains("Post an entry now!");
        return res;
    }


}