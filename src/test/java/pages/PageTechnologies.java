package pages;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Fantasy on 12.02.2016.
 */
public class PageTechnologies extends BasePage {

    //public final String ALL_NEWS = ".//section[@class='b-posts-1 b-content-posts-1']/article";
    /*@FindBy(xpath = ALL_NEWS)
    private List<WebElement> listOfNews;*/

    public final String DATE_OF_NEWS = ".//*[@class='b-inner-pages-footer-1']/span[2]/time";
    @FindBy(xpath = DATE_OF_NEWS)
    private List<WebElement> dateOfNews;

    public final String NAME_OF_NEWS = ".//*[@class='b-posts-1-item__title'][1]/a/span[1]";
    @FindBy(xpath = NAME_OF_NEWS)
    private List<WebElement> nameOfNews;

    public final String PREV_PAGE = ".//a[@class='previous-page']";
    @FindBy(xpath = PREV_PAGE)
    private WebElement prevPage;

    //public final String nameAttribute = "datetime";
    private int countOfPages = 3;
    private final String dateFormat = "yyyy-MM-dd'T'HH:mm:ss'+03:00'";
    //List<WebElement> listOfNews;
    FileWriter fileWriter;

    public PageTechnologies(WebDriver driver) throws IOException {

        super(driver);
        fileWriter = new FileWriter(new File("information.txt"));
    }


    public boolean getInformationOfNews()  {

        boolean flag = true;
        int i = 0;

         while (i<countOfPages){

            for(int j =0; j < nameOfNews.size();j++){

                String date = dateOfNews.get(j).getAttribute("datetime");
                String name = nameOfNews.get(j).getText();

                try {
                    writeDateInFile(name, date);
                } catch (Exception e) {
                    e.printStackTrace();
                    flag = false;
                }

            }
            prevPage.click();
            i++;
        }
        try {
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
        }

        return flag;

    }

    private void writeDateInFile(String name, String date) throws ParseException,IOException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        Date date1;


            date1 = simpleDateFormat.parse(date);
            fileWriter.append("Name: ").append(name).append("\n");
            fileWriter.append("Date: " ).append(date.toString()).append( "\n\n");




    }

    /*public boolean isThisDateValid() {

        for (int i = 1; i <= countOfPages; ++i) {
            listOfNews = driver.findElements(By.xpath(ALL_NEWS));

            for (WebElement webElement : listOfNews) {
                String dateToValidate = webElement.findElement(By.xpath(DATE_OF_NEWS)).getAttribute(nameAttribute);

                if (dateToValidate == null) {
                    return false;
                }

                SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
                sdf.setLenient(false);

                try {

                    Date date = sdf.parse(dateToValidate);
                    System.out.println(date);

                } catch (ParseException e) {

                    e.printStackTrace();
                    return false;
                }


            }
            prevPage.click();
        }
        return true;
    }*/
}
