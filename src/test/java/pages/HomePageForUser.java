package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Fantasy on 11.02.2016.
 */
public class HomePageForUser extends BasePage {
    public HomePageForUser(WebDriver driver) {
        super(driver);
    }

    public final String BUTTON_OUT = " .//*[@id='userbar']/div[1]/a";
    @FindBy(xpath = BUTTON_OUT)
    private WebElement buttonOut;

    public final String TECH_TAB ="(.//*[@href = 'http://tech.onliner.by'])[2]";
    @FindBy(xpath = TECH_TAB)
    private WebElement techTab;

    public final String LINK_NOTEBOOK =".//*[@href='http://catalog.onliner.by/notebook']";
    @FindBy(xpath = LINK_NOTEBOOK)
    private WebElement linkNotebook;


    public void goToTabTech(){
        waitForElement(TECH_TAB);
        techTab.click();
        log.info("Click 'tabTech'");
    }

    public void goToTabNotebook(){
        waitForElement(LINK_NOTEBOOK);
        linkNotebook.click();
        log.info("Click 'linkNotebook'");
    }





}
