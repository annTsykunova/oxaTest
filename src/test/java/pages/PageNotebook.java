package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PageNotebook extends BasePage {

    public PageNotebook(WebDriver driver) {
        super(driver);
    }

    public final String ADDITIONAL_PARAM = ".//*[@class='schema-filter-additional__trigger']/a";
    @FindBy(xpath = ADDITIONAL_PARAM)
    private WebElement additionalParam;

    public void goToAdditionalParam(){
        waitForElement(ADDITIONAL_PARAM);
        additionalParam.click();
        log.info("Click 'additionalParam'");
    }


}
