package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Product extends BasePage {

    public Product(WebDriver driver) {
        super(driver);
    }

    private final String param1="Экран";
    private final String param2="Количество ядер";
    private final String value1="матовый";
    private final String value2="4";

    public final String SCREEN_TYPE = ".//*[@value='matt']/../span";
    @FindBy(xpath = SCREEN_TYPE)
    private WebElement screenType;

    public final String NUMBER_OF_CORES = "(.//*[@name = 'filter-number-range__cpu_corenb'])[2]/../span";
    @FindBy(xpath = NUMBER_OF_CORES )
    private WebElement numberOfCores;

    public final String NOTEBOOK = ".//*[@class='schema-product__title']";
    @FindBy(xpath = NOTEBOOK )
    private WebElement noteBook;

    public void setParameters(){
        log.info("Click 'screenType' and 'numberOfCores");
        screenType.click();
        numberOfCores.click();

    }

    public void getNotebook(){
        waitForElement(NOTEBOOK);
        log.info("Click first notebook");
        noteBook.click();
    }

    public boolean checkParameters(){

        WebElement elementOfScreen = driver.findElement(By.xpath(".//*[@class='product-specs__table']/tbody[5]/tr[5]/td[2]/span"));
        WebElement elementOfCores = driver.findElement(By.xpath(".//*[@class='product-specs__table']/tbody[2]/tr[5]/td[2]/span"));

        if(elementOfScreen.getText().equals(value1) && elementOfCores.getText().equals(value2)){
            return true;
        }
        else {
            return false;
        }


    }




}
