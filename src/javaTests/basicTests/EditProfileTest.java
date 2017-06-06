package javaTests.basicTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javaTests.BasicActions;

/**
 * Created by nikolai on 6/4/17.
 */
public class EditProfileTest {
    static WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "res/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://lang-8.com/");
    }

    @Test
    public void editProfileTest() {
        BasicActions.login(BasicActions.login, BasicActions.password, driver);

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.id("user_name_and_image"))).build().perform();
        driver.findElement(By.xpath("//a[@href='/profiles/edit']")).click();

        driver.findElement(By.name("profile[nickname]")).clear();
        driver.findElement(By.name("profile[nickname]")).sendKeys("Landlord53");

        driver.findElement(By.name("profile[realname][value]")).clear();
        driver.findElement(By.name("profile[realname][value]")).sendKeys("Nikolai");
        new Select(driver.findElement(By.name("profile[birth_year][value]"))).selectByVisibleText("1993");

        boolean travelcell = driver.findElements(By.name("profile[l1_purpose][value][]")).get(0).isSelected();
        boolean studyAbroad = driver.findElements(By.name("profile[l1_purpose][value][]")).get(1).isSelected();

        driver.findElements(By.name("profile[l1_purpose][value][]")).get(0).click();
        driver.findElements(By.name("profile[l1_purpose][value][]")).get(1).click();

        driver.findElement(By.cssSelector("input[class='input_submit bt_lv1 bt_size_01']")).click();

        Assert.assertEquals("Landlord53",  driver.findElement(By.name("profile[nickname]")).getAttribute("value"));
        Assert.assertEquals("Nikolai", driver.findElement(By.name("profile[realname][value]")).getAttribute("value"));
        Assert.assertEquals("1993", driver.findElement(By.name("profile[birth_year][value]")).getAttribute("value"));
        Assert.assertEquals(!travelcell, driver.findElements(By.name("profile[l1_purpose][value][]")).get(0).isSelected());
        Assert.assertEquals(!studyAbroad, driver.findElements(By.name("profile[l1_purpose][value][]")).get(1).isSelected());
    }

    @After
    public void closeDriver() {
        driver.close();
    }
}
