package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.*;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Fantasy on 12.02.2016.
 */
public class PageTechnologies extends BasePage {

    public final String DATE_OF_NEWS = ".//*[@class='b-inner-pages-footer-1']/span[2]/time";
    @FindBy(xpath = DATE_OF_NEWS)
    private List<WebElement> dateOfNews;

    public final String NAME_OF_NEWS = ".//*[@class='b-posts-1-item__title'][1]/a/span[1]";
    @FindBy(xpath = NAME_OF_NEWS)
    private List<WebElement> nameOfNews;

    public final String PREV_PAGE = ".//a[@class='previous-page']";
    @FindBy(xpath = PREV_PAGE)
    private WebElement prevPage;

    private int countOfPages = 3;
    BufferedWriter fileWriter;

    public PageTechnologies(WebDriver driver) throws IOException {

        super(driver);
        fileWriter = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("information.txt"),
                        Charset.forName("UTF-8")
                )
        );
    }

    public boolean getInformationOfNews()  {

        boolean flag = true;
        int i = 0;

         while (i<countOfPages){

            for(int j =0; j < nameOfNews.size();j++){

                String date = dateOfNews.get(j).getAttribute("datetime");
                String name = nameOfNews.get(j).getText();

                try {
                    writeInfoInFile(name, date);
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

    private void writeInfoInFile(String name, String date) throws ParseException,IOException{

        String dateFormat = "yyyy-MM-dd'T'HH:mm:ss'+03:00'";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        simpleDateFormat.setLenient(false);
        Date  date1 = simpleDateFormat.parse(date);
            fileWriter.append("Name: ").append(name).append("\n");
            fileWriter.append("Date: " ).append(date1.toString()).append( "\n\n");


    }

}
