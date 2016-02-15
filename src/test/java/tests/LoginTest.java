package tests;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePageForUser;
import pages.LoginPage;
import pages.OnlinerHomePage;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Fantasy on 11.02.2016.
 */
public class LoginTest extends BaseTest {

    private final String login = "fantasy95";
    private final String pass = "28031995";

    @Override
    public void initPages() {
        onlinerHomePage = PageFactory.initElements(driver,OnlinerHomePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homePageForUser = PageFactory.initElements(driver, HomePageForUser.class);
    }


    @Test()
    public void test1(){
        log.info("Log step 1: Go to form for login");
        onlinerHomePage.goToButtonEnter();
        log.info("Log step 2: Login");
        loginPage.loginToHomePage(login, pass);
        log.info("Log step 4: Verify that user is logged successfully");
        Assert.assertTrue(homePageForUser.isElementPresent(homePageForUser.BUTTON_OUT)," user isn't logged successfully");

    }
}
