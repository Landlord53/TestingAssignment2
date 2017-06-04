import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by nikolai on 6/4/17.
 */
public class GetPageTitleTest {
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
    public void getPageTitleTest() {
        String title = driver.getTitle();
        Assert.assertEquals("Multi-lingual language learning and language exchange | Lang-8: For learning foreign languages" , title);
    }

    @After
    public void closeDriver() {
        driver.close();
    }
}
