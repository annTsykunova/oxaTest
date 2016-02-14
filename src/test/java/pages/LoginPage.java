package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Fantasy on 11.02.2016.
 */
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    final String EMAIL_FIELD = ".//*[@id='auth-container__forms']/div/div[2]/form/div[1]/div[1]/input";
    @FindBy(xpath = EMAIL_FIELD)
    private WebElement emailField;

    final String PASSWORD_FIELD = ".//*[@id='auth-container__forms']/div/div[2]/form/div[1]/div[2]/input";
    @FindBy(xpath = PASSWORD_FIELD)
    private WebElement passwordField;

    final String LOGIN_BUTTON = ".//*[@id='auth-container__forms']/div/div[2]/form/div[4]/div/button";
    @FindBy(xpath = LOGIN_BUTTON)
    private WebElement loginButton;

    public void setEmailText(String emailText){
        waitForElement(EMAIL_FIELD);
        emailField.clear();
        log.info("set 'emailField'");
        emailField.sendKeys(emailText);
    }

    public void setPasswordText(String passwordText){
        waitForElement(PASSWORD_FIELD);
        log.info("set 'passwordField'");
        passwordField.sendKeys(passwordText);
    }
    public void goToButtonLogin(){
        waitForElement(LOGIN_BUTTON);
        loginButton.click();
        log.info("Click 'loginButton'");
    }

    public void loginToHomePage(String emailText,String passwordText){

        setEmailText(emailText );
        setPasswordText(passwordText);
        goToButtonLogin();
    }


}
