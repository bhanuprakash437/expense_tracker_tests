import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class StatisticsPage {
    public WebDriver driver ;

    /**
     * Constructor initializes the driver
     * @param driver
     */
    public StatisticsPage(WebDriver driver)
    {
        this.driver = driver;
    }




    /**
     * This is a functionality which adds a new expense when called
     */
    public boolean check_graph()
    {
        boolean status = false;
        WebElement image_div = driver.findElement(By.xpath("//*[@id=\"myChart\"]"));

        if (image_div.findElement(By.tagName("svg")).isDisplayed())
        {
            status = true;
        }
        return status;

    }

    public  boolean show_summary()
    {

        boolean status = false;
        WebElement image_div = driver.findElement(By.xpath("/html/body/div/div[2]/table"));

        if (image_div.isDisplayed())
        {
            status = true;
        }
        return status;
    }


    public  boolean show_datepicker()
    {

        boolean status = false;
        WebElement image_div = driver.findElement(By.xpath("/html/body/div/div[1]/form/select"));

        if (image_div.isDisplayed())
        {
            status = true;
        }
        return status;
    }

}
