/**
 * Base TEst class which offers the most common functionality
 * Date :
 * Author : Bhanu Prakash Medichallam
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Base_Class {

    public static WebDriver driver;


    public void setDriver()
    {
        Browser_Provider browser_provider = new Browser_Provider();
        driver = browser_provider.getChromeWebDriver();
    }

    public  WebDriver loadSite(){
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
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return driver;
    }


    /**
     * helper calss which closes and quits the browser instance
     */
    public void quitDriver()
    {
        driver.close();
        driver.quit();
    }

    public void  include_delay()
    {
        try {
            Thread.sleep(Global.WAIT_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * helper class to check if string contains a part of the given compare string!
     * @param driver
     * @param compare_string
     * @return boolean value
     */
    public  boolean check_strings(WebDriver driver,String compare_string)
    {
        if (driver.getCurrentUrl().contains(compare_string))
        {
             return true;
        }
        return false;
    }


}
