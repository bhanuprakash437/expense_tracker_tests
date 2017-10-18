import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    public WebDriver driver ;

    /**
     * Constructor initializes the driver
     * @param driver
     */
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    /**
     * we load the site here
     * @return
     */
    public  WebDriver loadSite(){
        System.out.println(Global.TEST_SITE_URL);

        driver.get(Global.TEST_SITE_URL);
        return driver;
    }


    /**
     * this is a helper method which performs the login
     */
    public WebDriver login(){
        driver = this.loadSite();

        driver.findElement(By.xpath("//*[@id=\"login\"]")).sendKeys(Global.ACTUAL_UNAME);

        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(Global.ACTUAL_PASSWORD);

        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();


        //we wait for the site to load
        try {
            Thread.sleep(Global.WAIT_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return driver;
    }



}
