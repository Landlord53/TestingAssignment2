package javaTests.basicTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javaTests.BasicActions;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by nikolai on 6/4/17.
 */
public class StaticWebPageTest {
    static WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "res/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://lang-8.com/");
    }

    @Test
    public void staticWebPageTest() throws MalformedURLException, IOException {
        int responseStatusCode = getStatusCode(driver.findElement(By.xpath("//a[@class='help']")).getAttribute("href"));
        Assert.assertEquals(200, responseStatusCode);

        BasicActions.login(BasicActions.login, BasicActions.password, driver);
        responseStatusCode = getStatusCode(driver.findElement(By.xpath("//a[@class='bt_blue bt_size_02']")).getAttribute("href"));
        Assert.assertEquals(200, responseStatusCode);
    }

    @Test
    public void multipleWebPageTest() throws MalformedURLException, IOException {
        ArrayList<WebElement> webElements = new ArrayList<>();

        webElements.add(driver.findElement(By.xpath("//div[@id='learn_for_free_box']//a[@data-dismiss='modal']")));
        webElements.add(driver.findElement(By.xpath("//li[@id='login']//a[@class='help']")));

        for(WebElement webElem: webElements) {
            int responseCode = getResponStatuseCode(webElem);

            Assert.assertEquals(200, responseCode);
        }
    }

    @After
    public void closeDriver() {
        driver.close();
    }

    private static int getStatusCode(String strUrl) throws MalformedURLException, IOException {
        URL url = new URL(strUrl);
        HttpURLConnection huc = (HttpURLConnection)url.openConnection();
        huc.setRequestMethod("GET");
        huc.connect();
        int responseStatusCode = huc.getResponseCode();
        return responseStatusCode;
    }

    private static int getResponStatuseCode(WebElement elem) throws MalformedURLException, IOException {
        String url = elem.getAttribute("href");
        return url == null ? 404 : getStatusCode(url);
    }
}
