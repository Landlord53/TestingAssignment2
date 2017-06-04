import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by nikolai on 6/4/17.
 */
public class LoginTest {
    static WebDriver driver;
    static Wait<WebDriver> wait;

    public static final String login = "Nikolay.Chalykh@gmail.com";
    public static final String password = "42908326";

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "res/chromedriver");
        driver = new ChromeDriver();
        // https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/ui/WebDriverWait.html
        wait = new WebDriverWait(driver, 30);
        driver.get("http://lang-8.com/");
    }

    @Test
    public void loginTest() {
        login(login, password, driver);

        boolean result;
        try {
            result = driver.findElement(By.tagName("body")).getText().contains("Post an entry now!");
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

    public static void login(String user, String password, WebDriver driver) {
        driver.findElement(By.id("login")).click();

        driver.findElement(By.name("username")).sendKeys(user);
        driver.findElement(By.name("password")).sendKeys(password);

        driver.findElement(By.name("commit")).click();
    }
}
