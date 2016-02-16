package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    final String EMAIL_FIELD = ".//input[@class='auth-box__input' and @type='text']";
    @FindBy(xpath = EMAIL_FIELD)
    private WebElement emailField;

    final String PASSWORD_FIELD = ".//input[@class='auth-box__input' and @type='password']";
    @FindBy(xpath = PASSWORD_FIELD)
    private WebElement passwordField;

    final String LOGIN_BUTTON = ".//div[@class='auth-box__line auth-box__line--final']/button";
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
