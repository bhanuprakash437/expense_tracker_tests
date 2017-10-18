import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Test_Suite {

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
    public void registerUser_username_blank() throws InterruptedException {
        driver.get(Global.TEST_SITE_URL);
        driver.findElement(By.xpath("/html/body/div/div/a")).click();

        Thread.sleep(5000);


        driver.findElement(By.xpath("//*[@id=\"login\"]")).sendKeys("");

        driver.findElement(By.xpath("//*[@id=\"password1\"]")).sendKeys("12345690");

        driver.findElement(By.xpath("//*[@id=\"password2\"]")).sendKeys("12345690");

        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"http://thawing-shelf-73260.herokuapp.com/listexpenses");
    }


    /**
     * checks if the error message is shown if passed our system works as expected.
     * @throws InterruptedException
     */
    @Test
    public void registerUser_incorrect_passwords() throws InterruptedException {
        driver.get(Global.TEST_SITE_URL);
        driver.findElement(By.xpath("/html/body/div/div/a")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"login\"]")).sendKeys("asd");

        driver.findElement(By.xpath("//*[@id=\"password1\"]")).sendKeys("12345690");

        driver.findElement(By.xpath("//*[@id=\"password2\"]")).sendKeys("1234569");

        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

        String alertMessage = driver.switchTo().alert().getText();

        Thread.sleep(10000);

        Assert.assertEquals(alertMessage, "Error: Passwords aren't equal!");

        ///Assert.assertEquals(driver.getCurrentUrl(),"http://thawing-shelf-73260.herokuapp.com/listexpenses");
    }

    @Test
    public void login() throws InterruptedException {
        driver.get(Global.TEST_SITE_URL);
        driver.findElement(By.xpath("/html/body/div/div/a")).click();

        Thread.sleep(5000);


        driver.findElement(By.xpath("//*[@id=\"login\"]")).sendKeys("RajM");

        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("bhanu");


        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"http://thawing-shelf-73260.herokuapp.com/listexpenses");
    }
    /**
     * helper method to close the browser after test cases are run.
     */
    @After
    public void quitDriver()
    {
       driver.close();
       driver.quit();
    }
}
