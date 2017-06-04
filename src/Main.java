import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Search Google example.
 *
 * @author Rahul
 */
public class Main {
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
    public void editProfileTest() {
        LoginTest.login(LoginTest.login, LoginTest.password, driver);

        //Actions builder = new Actions(driver);
        //builder.moveToElement(driver.findElement(By.id("user_name_and_image"))).build().perform();
        WebElement element = driver.findElement(By.xpath("//a[@href='/profiles/edit']"));

        element = wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    @After
    public void closeDriver() {
        driver.close();
    }
}
