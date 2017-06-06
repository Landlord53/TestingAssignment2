package javaTests.pageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by nikolai on 6/5/17.
 */
public class LoginPage extends WebPage{
    public LoginPage(String url) {
        super(url);
        driver.get(url);
    }

    public LoggedInHomePage login(String login, String password) {
        driver.findElement(By.id("login")).click();
        driver.findElement(By.name("username")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("commit")).click();

        try {
            driver.findElement(By.id("user_name_and_image"));
        } catch (NoSuchElementException e) {
            return null;
        }

        return new LoggedInHomePage(driver.getCurrentUrl());
    }
}
