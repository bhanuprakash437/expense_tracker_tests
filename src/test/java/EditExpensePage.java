import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EditExpensePage {
    public WebDriver driver ;

    /**
     * Constructor initializes the driver
     * @param driver
     */
    public EditExpensePage(WebDriver driver)
    {
        this.driver = driver;
    }


    /**
     * This is a functionality which adds a new expense when called
     */
    public WebDriver edit_expense(int day,int month,int year, String category, int amount,String reason)
    {
        driver.findElement(By.xpath("//*[@id=\"day\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"day\"]")).sendKeys(Integer.toString(day));

        driver.findElement(By.xpath("//*[@id=\"month\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"month\"]")).sendKeys(Integer.toString(month));

        driver.findElement(By.xpath("//*[@id=\"year\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"year\"]")).sendKeys(Integer.toString(year));

        WebElement dropdown_element = driver.findElement(By.xpath("//*[@id=\"category\"]"));
        Select dropdown = new Select(dropdown_element);
        dropdown.selectByVisibleText(category);

        driver.findElement(By.xpath("//*[@id=\"amount\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"amount\"]")).sendKeys(Integer.toString(amount));

        driver.findElement(By.xpath("//*[@id=\"reason\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"reason\"]")).sendKeys(reason);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

        // control goes to list_expenses page
        return driver;
    }

}
