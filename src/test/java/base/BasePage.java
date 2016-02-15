package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Fantasy on 11.02.2016.
 */
public class BasePage {

    protected WebDriver driver;
    protected Logger log = Logger.getLogger(this.getClass().getName());

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(String by) {

            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            List<WebElement> list = driver.findElements(By.xpath(by));
            if (list.size() == 0) {
                return false;
            } else {
                return true;
            }
    }

    public void waitForElement(String xpath) {
        for (int second = 0; ; second++) {
            if (second >= 60)
                throw new NoSuchElementException("timeout");
            if (isElementPresent(xpath))
                break;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void alertHandler() {
        if (isAlertDisplayed()) {
            Alert alert = driver.switchTo().alert();

            log.warn("Alert present! " + alert.getText());
            alert.accept();
        }
    }

    private boolean isAlertDisplayed() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }
}
