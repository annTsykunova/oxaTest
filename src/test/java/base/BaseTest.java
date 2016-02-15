package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Fantasy on 11.02.2016.
 */
public abstract class BaseTest {

    protected WebDriver driver;
    protected Logger log = Logger.getLogger(this.getClass().getName());
    protected final String BASE_URL = "http://www.onliner.by/";

    public OnlinerHomePage onlinerHomePage;
    public LoginPage loginPage;
    public HomePageForUser homePageForUser;
    public PageTechnologies pageTechnologies;
    public PageNotebook pageNotebook;
    public Product product;


    public abstract void initPages();

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else {
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }
        initPages();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        log.info("Set timeout from 10 seconds");

        driver.get(BASE_URL);

    }

    @AfterMethod
    public void shutDown() {
        driver.quit();
        log.info("Driver shut down");
    }

}
