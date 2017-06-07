package javaTests.basicTests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by nikolai on 6/4/17.
 */
public class ConfigurationFileUsageTest {
    @Test
    public void chromeTest() throws Exception
    {
        ConfigFile config = new ConfigFile();

        System.setProperty("webdriver.chrome.driver", config.getChromePath());

        WebDriver driver = new ChromeDriver();

        driver.get(config.getApplicationURL());

        driver.quit();
    }
}
