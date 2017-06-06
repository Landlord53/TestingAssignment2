package javaTests.pageObjectPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by nikolai on 6/5/17.
 */
public abstract class WebPage {
    protected static WebDriver driver;
    protected String url;

    public WebPage(String url) {
        this.url = url;
    }

    public static void closeDriver() {
        driver.quit();
        WebDriver driver1 = driver;
    }
}
