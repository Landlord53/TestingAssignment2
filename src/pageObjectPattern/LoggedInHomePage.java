package pageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by nikolai on 6/5/17.
 */
public class LoggedInHomePage extends WebPage{
    public LoggedInHomePage(String url) {
        super(url);
    }

    public HomePage logout() {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.id("user_name_and_image"))).build().perform();
        driver.findElement(By.xpath("//a[@href='/sessions/delete']")).click();

        try {
            driver.findElement(By.id("user_name_and_image"));
        } catch (NoSuchElementException e) {
            return new HomePage();
        }

        return null;
    }
}
