import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class use_case_001 {
    public static WebDriver driver;


    /**
     * This is a helper method to get the browser instance before the test suite runs.
     */
    @Before
    public void setDriver()
    {
        Browser_Provider browser_provider = new Browser_Provider();
        driver = browser_provider.getChromeWebDriver();
    }

    /**
     * This is a test case to load the site
     */
    @Test
    public void loadSite()
    {
        driver.get(Global.TEST_SITE_URL);
        Assert.assertEquals(driver.getTitle(),"Expense tracker");
    }






    @Test





    @After
    public void quitDriver()
    {
        driver.close();
        driver.quit();
    }
}
