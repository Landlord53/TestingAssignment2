package javaTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by nikolai on 6/6/17.
 */
public class BasicActions {
    public static final String login = "Nikolay.Chalykh@gmail.com";
    static String invalidLogin = "Putin";
    public static final String password = "12345678";

    public static final String validTitle = "Multi-lingual language learning and language exchange | Lang-8: For learning foreign languages";

    public static void login(String user, String password, WebDriver driver) {
        driver.findElement(By.id("login")).click();

        driver.findElement(By.name("username")).sendKeys(user);
        driver.findElement(By.name("password")).sendKeys(password);

        driver.findElement(By.name("commit")).click();
    }
}
