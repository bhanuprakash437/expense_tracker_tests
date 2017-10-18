/**
 * Usecase 004 : to list categories and add, edit and delete categories.
 * Date : 17 October, 2017
 * Author : Bhanu Prakash
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class use_case_004 extends Base_Class {
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
     * Test case to goto List categories page. Success if the page is reached.
     */
    @Test
    public void show_list_category()
    {
        // we login into the site
        driver = super.login();

        //click the List categories
        driver.findElement(By.xpath("//*[@id=\"go_list_categories\"]")).click();

        // we are at the new page
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/h1")).getText(), "List Categories");
    }


    /***
     * To add a new category. Sucess if the added category is seen in the list
     * @throws InterruptedException
     */
    @Test
    public void add_new_category() throws InterruptedException {
        String category_name = Global.CATEGORY_NAME;

        // we login into the site
        driver = this.login();

        //click the List categories
        driver.findElement(By.xpath("//*[@id=\"go_list_categories\"]")).click();


        ListCategoryPage listCategoryPage = new ListCategoryPage(driver);
        driver = listCategoryPage.add_category(category_name);


        WebElement table = driver.findElement(By.xpath("/html/body/div/table"));
        List <WebElement> tr_collection = table.findElements(By.tagName("tr"));
        List <WebElement> td_collection;

        boolean status = false;

        for (WebElement tr :tr_collection) {

            td_collection = tr.findElements(By.tagName("td"));

            String category_text = tr.getText().split("\\s+")[0];
            if (category_text.equalsIgnoreCase(category_name))
            {
                status = true;
                break;
            }
        }
        Assert.assertEquals(status, true);
    }


    /**
     * To modify the already exisitng data in the list.
     * We change the name of teh category. Sucess if the name is changed
     */
    @Test
    public void modify_single_category()
    {
        // we login into the site
        driver = this.login();

        //click the List categories
        driver.findElement(By.xpath("//*[@id=\"go_list_categories\"]")).click();

        //we see the list of categories:
        WebElement table = driver.findElement(By.xpath("/html/body/div/table"));
        List <WebElement> tr_collection = table.findElements(By.tagName("tr"));
        List <WebElement> td_collection;


        // We want to change or modify the first row entry!
        td_collection = tr_collection.get(2).findElements(By.tagName("td"));

        // we click on the modify icon
        WebElement anchor_tag = td_collection.get(1).findElement(By.tagName("a"));
        anchor_tag.findElement(By.tagName("img")).click();


        //induce a delay
        super.include_delay();

        // we reach edit category page
        // We don't follow Page Object Model but rather use it directly here.
        WebElement category_txtbox = driver.findElement(By.xpath("//*[@id=\"name\"]"));

        String exisiting_category = category_txtbox.getText();

        System.out.println(exisiting_category);

        //We modify the category name by appending the _modified:
        String modified_category = exisiting_category + "_modified";


        System.out.println(modified_category);

        // we add the modified data into the text box
        category_txtbox.clear();
        category_txtbox.sendKeys(modified_category);

        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

        super.include_delay();

        // we verify if the modified data is available in the list categories
        WebElement table_new = driver.findElement(By.xpath("/html/body/div/table"));
        List <WebElement> tr_collection_new = table_new.findElements(By.tagName("tr"));


        boolean status = false;

        for (WebElement tr :tr_collection_new) {

            String category_text = tr.getText().split("\\s+")[0];
            if (category_text.equalsIgnoreCase(modified_category))
            {
                status = true;
                break;
            }
        }
        Assert.assertEquals(status, true);
    }


    /**
     * To ask for confirmation before delete the existing category. Success if alert message is present!
     */
    @Test
    public void delete_single_category_check_confirmation()
    {
        // we login into the site
        driver = this.login();

        //click the List categories
        driver.findElement(By.xpath("//*[@id=\"go_list_categories\"]")).click();

        //we see the list of categories:
        WebElement table = driver.findElement(By.xpath("/html/body/div/table"));
        List <WebElement> tr_collection = table.findElements(By.tagName("tr"));
        List <WebElement> td_collection;


        // We want to change or modify the first row entry!
        td_collection = tr_collection.get(2).findElements(By.tagName("td"));

        // we click on the delete icon
        List <WebElement> anchor_tags = td_collection.get(1).findElements(By.tagName("a"));

        anchor_tags.get(1).findElement(By.tagName("img")).click();

        this.include_delay();

        Alert alert = driver.switchTo().alert();

        boolean status;

        status = alert.getText().contains("Attention: Unrecoverable Delete Action\n" + "\n" +"Do you really want to delete");

        Assert.assertEquals(status,true);
    }


    /**
     * To delete the existing category. Success if deleted!
     * We delete the last row entry!!
     * Note: If the first entry is referenced in the expenses it cannot be deleted!
     * BUG : Please show a user info saying referenced items cannot be deleted.
     */
    @Test
    public void delete_single_category()
    {

        // we login into the site
        driver = this.login();

        //click the List categories
        driver.findElement(By.xpath("//*[@id=\"go_list_categories\"]")).click();

        //we see the list of categories:
        WebElement table = driver.findElement(By.xpath("/html/body/div/table"));
        List <WebElement> tr_collection = table.findElements(By.tagName("tr"));
        List <WebElement> td_collection;

        //We save the number of rows in the table
        int no_of_categories = tr_collection.size()-1; // we exclude the header


        // We want to delete the last entry
        td_collection = tr_collection.get(no_of_categories).findElements(By.tagName("td"));

        // we click on the delete icon
        List <WebElement> anchor_tags = td_collection.get(1).findElements(By.tagName("a"));

        anchor_tags.get(1).findElement(By.tagName("img")).click();

        WebDriverWait wait = new WebDriverWait(driver, Global.WAIT_TIME);
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        this.include_delay();

        //accept delete in alert box
        alert.accept();

        //induce delay
        this.include_delay();

        //we see the list of categories:
        WebElement table_new = driver.findElement(By.xpath("/html/body/div/table"));
        List <WebElement> tr_collection_new = table_new.findElements(By.tagName("tr"));

        int no_of_rows_afeter_delete = tr_collection_new.size() -1 ; //exclude the header

        boolean status = false;

        if (no_of_rows_afeter_delete == (no_of_categories -1))
        {
            status = true;
        }

        Assert.assertEquals(status,true);

    }

    @After
    public void quitDriver()
    {
        super.quitDriver();
    }

}
