package pageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by nikolai on 6/5/17.
 */
public class HomePage extends WebPage{
    public HomePage() {
        super("http://lang-8.com/");

        if (driver != null) {
            closeDriver();
        }

        driver = new ChromeDriver();
        driver.get(url);
    }

    public LoginPage loginBtn() {
        driver.findElement(By.id("login"));
        return new LoginPage(driver.getCurrentUrl());
    }
}
