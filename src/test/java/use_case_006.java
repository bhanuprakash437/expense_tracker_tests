import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class use_case_006 extends Base_Class {
    public static WebDriver driver;
    /**
     * This is a helper method to get the browser instance before the test suite runs.
     */
    @Before
    public void setDriver()
    {
        super.setDriver();
    }

    /**
     * Here we check the functionalities - Add Expense, List Expense , List Categories, Show Statistics.
     * Click of these functionalities must not allow the user any functionalities but insted redirect the user to login page.
     */
    @Test
    public void check_functionality_without_login()
    {
        driver = this.loadSite();

        // we define some boolean values to test
        boolean s1 = false ,s2 = false,s3  = false,s4  = false;

        //We click on the functionalities without the sign in
        driver.findElement(By.xpath("//*[@id=\"go_add_expense\"]")).click();
        s1 = this.check_strings(driver,"addexpense.jsp");

        driver.findElement(By.xpath("//*[@id=\"go_list_expenses\"]")).click();
        s2 = this.check_strings(driver,"listexpenses");


        driver.findElement(By.xpath("//*[@id=\"go_list_categories\"]")).click();
        s3 = this.check_strings(driver,"listcategories");


        driver.findElement(By.xpath("//*[@id=\"go_show_statistics\"]")).click();
        s4 = this.check_strings(driver,"showstatistics");

        boolean status = s1 & s2 & s3 & s4;

        Assert.assertEquals(status,false);
    }


    /**
     * check the functionality vith login and the user must be able to access the functionalities.
     */
    @Test
    public void check_functionality_with_login()
    {
        driver = this.login();

        // we define some boolean values to test
        boolean s1 = false ,s2 = false,s3  = false,s4  = false;

        //We click on the functionalities without the sign in
        driver.findElement(By.xpath("//*[@id=\"go_add_expense\"]")).click();
        s1 = this.check_strings(driver,"addexpense.jsp");

        driver.findElement(By.xpath("//*[@id=\"go_list_expenses\"]")).click();
        s2 = this.check_strings(driver,"listexpenses");


        driver.findElement(By.xpath("//*[@id=\"go_list_categories\"]")).click();
        s3 = this.check_strings(driver,"listcategories");


        driver.findElement(By.xpath("//*[@id=\"go_show_statistics\"]")).click();
        s4 = this.check_strings(driver,"showstatistics");

        boolean status = s1 & s2 & s3 & s4;

        Assert.assertEquals(status,true);
    }

    @After
    public void quitDriver()
    {
        super.quitDriver();
    }

}
