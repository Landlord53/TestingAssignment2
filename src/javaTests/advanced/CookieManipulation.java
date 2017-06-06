package javaTests.advanced;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

/**
 * Created by nikolai on 6/5/17.
 */
public class CookieManipulation {
    static ChromeDriver driver;
    private String cookieName = "mycookie";
    private Set<Cookie> cookiesList;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "res/chromedriver");
        driver = new ChromeDriver();
        String URL="http://lang-8.com/";
        driver.navigate().to(URL);
    }

    @Test
    public void addCookie() {
        Cookie name = new Cookie(cookieName, "123456789123");
        driver.manage().addCookie(name);

        cookiesList =  driver.manage().getCookies();
        for(Cookie getcookies :cookiesList) {
            System.out.println(getcookies );
        }
    }

    @Test
    public void deleteCookieByName() {
        driver.manage().deleteCookieNamed(cookieName);

        cookiesList =  driver.manage().getCookies();
        for(Cookie getcookies :cookiesList) {
            System.out.println(getcookies );
        }
    }

    @Test
    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();

        cookiesList =  driver.manage().getCookies();
        for(Cookie getcookies :cookiesList) {
            System.out.println(getcookies );
        }
    }

    @After
    public void closeDriver() {
        driver.close();
    }
}
