package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Product extends BasePage {

    public Product(WebDriver driver) {
        super(driver);
    }

    public final String SCREEN_TYPE = ".//*[@value='matt']/../span";
    @FindBy(xpath = SCREEN_TYPE)
    private WebElement screenType;

    public final String NOTEBOOK = ".//*[@class='schema-product__title']";
    @FindBy(xpath = NOTEBOOK )
    private WebElement noteBook;

    public final String ELEMENT_OF_TABLE = ".//*[@class='product-specs__table']/tbody[5]/tr[5]/td";
    @FindBy(xpath = ELEMENT_OF_TABLE )
    private List<WebElement> elementOfTable;

    public void setParameters(){
        log.info("Click 'screenType' and 'numberOfCores");
        screenType.click();
    }

    public void getNotebook(){
        waitForElement(NOTEBOOK);
        log.info("Click first notebook");
        noteBook.click();
    }

    public boolean checkFirstParameter(String param1,String value1){

        boolean flag;

        if(elementOfTable.get(0).getText().equals(param1) && elementOfTable.get(1).getText().equals(value1)){
            flag = true;
        }
        else {
            flag = false;
        }
        return flag;
    }


}
