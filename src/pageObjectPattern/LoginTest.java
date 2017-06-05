package pageObjectPattern;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nikolai on 6/5/17.
 */
public class LoginTest {
    static String login = "Nikolay.Chalykh@gmail.com";
    static String invalidLogin = "Putin";
    static String password = "12345678";
    private HomePage homepage;
    private LoginPage loginPage;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "res/chromedriver");
        homepage = new HomePage();
        loginPage = homepage.loginBtn();
    }

    @Test
    public void loginTest() {
        Assert.assertNotNull(loginPage.login(login, password));
    }

    @Test
    public  void loginTestWithIncorrectlogin() {
        Assert.assertNull(loginPage.login(invalidLogin, password));
    }

    @After
    public void closeDriver() {
        WebPage.closeDriver();
    }

}
