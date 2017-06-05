package pageObjectPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by nikolai on 6/5/17.
 */
public abstract class WebPage {
    protected static WebDriver driver;
    protected String url;
    protected String title;

    public WebPage(String url) {
        this.url = url;
    }

    public static void closeDriver() {
        driver.close();
    }
}
