package ActionBotPattern;

import com.sun.media.jfxmedia.locator.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

/**
 * Created by nikolai on 6/5/17.
 */
public class ActionBot {
    private ChromeDriver driver;

    public ActionBot(ChromeDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        (new WebDriverWait(driver, 90)).until
                (ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    public void fillTextArea(By locator, String value) throws IOException {
        (new WebDriverWait(driver, 30)).until
        (ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(value);
    }

    public void moveCursorToElement(By locator) {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(locator)).build().perform();
    }
}
