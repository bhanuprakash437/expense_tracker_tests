import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterNewUserPage {

    public WebDriver driver ;

    /**
     * Constructor initializes the driver
     * @param driver
     */
    public RegisterNewUserPage(WebDriver driver)
    {
        this.driver = driver;
    }


    /**
     * This is a functionality which adds a new user when called
     */
    public WebDriver Register_new_user(String USERNAME, String PASSWORD, String RPASSWORD)
    {


        driver.findElement(By.xpath("//*[@id=\"login\"]")).sendKeys(USERNAME);

        driver.findElement(By.xpath("//*[@id=\"password1\"]")).sendKeys(PASSWORD);

        driver.findElement(By.xpath("//*[@id=\"password2\"]")).sendKeys(RPASSWORD);

        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

        return driver;
        // if success the control is in the ListExpensesPage
    }



}
