import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListCategoryPage {

    public WebDriver driver ;

    /**
     * Constructor initializes the driver
     * @param driver
     */
    public ListCategoryPage(WebDriver driver)
    {
        this.driver = driver;
    }


    /**
     * This is a functionality which adds a new expense when called
     */
    public WebDriver add_category(String category_name)
    {
        driver.findElement(By.xpath("//*[@id=\"go_add_category\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(category_name);

        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

        return driver;
    }



}
