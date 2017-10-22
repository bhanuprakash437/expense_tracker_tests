import com.sun.jna.platform.win32.GL;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class use_case_008 extends Base_Class{
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
     * To testcase register a new user!
     */
    @Test
    public void registerNewUser_success()
    {
        driver = super.loadSite();
        RegisterNewUserPage Registernewuserpage = new RegisterNewUserPage(driver);
        driver.findElement(By.xpath("/html/body/div/div/a")).click();

        // we are at the new page
       driver = Registernewuserpage.Register_new_user(Global.NEW_USERNAME , Global.PASSWORD, Global.PASSWORD);

       ListExpensesPage listExpensesPage = new ListExpensesPage(driver);
       String new_name = listExpensesPage.get_username();
       Assert.assertEquals(new_name, Global.NEW_USERNAME);
    }
}
