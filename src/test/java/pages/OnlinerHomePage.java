package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Fantasy on 11.02.2016.
 */
public class OnlinerHomePage extends BasePage {

    public OnlinerHomePage(WebDriver driver) {
        super(driver);
    }

    final String ENTER_BUTTON = ".//*[@id='userbar']/div[2]/div[1]";
    @FindBy(xpath = ENTER_BUTTON)
    private WebElement enterButton;

    public void goToButtonEnter(){
        waitForElement(ENTER_BUTTON);
        enterButton.click();
        log.info("Click 'enterButton'");
    }



}
