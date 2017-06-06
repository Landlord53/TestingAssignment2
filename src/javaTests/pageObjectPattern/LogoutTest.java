package javaTests.pageObjectPattern;

import javaTests.BasicActions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nikolai on 6/5/17.
 */
public class LogoutTest {
    private HomePage homepage;
    private LoginPage loginPage;
    private LoggedInHomePage loggedInHomePage;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "res/chromedriver");
        homepage = new HomePage();
        loginPage = homepage.loginBtn();
        loggedInHomePage = loginPage.login(BasicActions.login, BasicActions.password);
    }

    @Test
    public void logoutTest() {
        Assert.assertNotNull(loggedInHomePage.logout());
    }

    @After
    public void closeDriver() {
        WebPage.closeDriver();
    }
}
