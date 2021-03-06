package tests;

import base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import static junit.framework.Assert.assertTrue;


public class SearchTest extends BaseTest {

    private final String login = "fantasy95";
    private final String pass = "28031995";

    @Override
    public void initPages() {
        onlinerHomePage = PageFactory.initElements(driver, OnlinerHomePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homePageForUser = PageFactory.initElements(driver, HomePageForUser.class);
        pageNotebook = PageFactory.initElements(driver, PageNotebook.class);
        product = PageFactory.initElements(driver, Product.class);
    }
    @DataProvider(name = "verifyResult")
    public Object[][] verifyResult() {

        return new Object[][] {
                { "Поверхность экрана", "матовый",true },
                { "Поверхность экрана", "4",false }

        };
    }

    @Test(dataProvider = "verifyResult")
    public void test1(String p1,String v1,boolean flag){
        log.info("Log step 1: Go to form for login");
        onlinerHomePage.goToButtonEnter();
        log.info("Log step 2: Login");
        loginPage.loginToHomePage(login, pass);
        log.info("Log step 3: Go to tab notebook");
        homePageForUser.goToTabNotebook();
        log.info("Log step 4: Go to additional parameters");
        pageNotebook.goToAdditionalParam();
        log.info("Log step 5: Set parameters");
        product.setParameters();
        log.info("Log step 6:  Verify, that result contains specified parameter");
        product.getNotebook();
        Assert.assertEquals(product.checkFirstParameter(p1,v1),flag,"result don't contain specified parameter");

    }
}
