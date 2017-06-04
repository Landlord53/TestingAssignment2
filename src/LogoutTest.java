import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by nikolai on 6/4/17.
 */
public class LogoutTest {
    static WebDriver driver;
    static Wait<WebDriver> wait;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "res/chromedriver");
        driver = new ChromeDriver();
        // https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/ui/WebDriverWait.html
        wait = new WebDriverWait(driver, 30);
        driver.get("http://lang-8.com/");
    }

    @Test
    public void logoutTest() {
        boolean result;
        LoginTest.login(LoginTest.login, LoginTest.password, driver);

        try {
            result = logout();
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

    private static boolean logout() {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.id("user_name_and_image"))).build().perform();
        driver.findElement(By.xpath("//a[@href='/sessions/delete']")).click();

        return driver.findElement(By.id("login")) != null;
    }
}
