import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class use_case_001 extends Base_Class{
    public static WebDriver driver;


    /**
     * This is a helper method to get the browser instance before the test suite runs.
     */
    @Before
    public void setDriver()
    {
        super.setDriver();
    }

    // THE TESTS ARE INCLUDED IN OTHER USECASES


    @After
    public void quitDriver()
    {
        super.quitDriver();
    }
}
