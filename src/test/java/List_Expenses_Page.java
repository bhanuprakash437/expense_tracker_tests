import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class List_Expenses_Page {
    public WebDriver driver ;

    /**
     * Constructor initializes the driver
     * @param driver
     */
    public List_Expenses_Page(WebDriver driver)
    {
        this.driver = driver;
    }

    /**
     * This check if  the user can add new expense in the list_expense_Page.
     * The user clisks on the green + button and he is redirected to the Add expense page
     * @return boolean TRUE if sucess
     */
    public boolean add_new_expense () {
        boolean status = false;

        //We check if the table content is there
        WebElement table = driver.findElement(By.xpath("/html/body/div/table"));
        List<WebElement> tr_collection = table.findElements(By.tagName("tr"));
        List <WebElement> td_collection;


        return status;
    }

    public void click_add_expense_link()
    {
        driver.findElement(By.xpath("//*[@id=\"go_add_expense\"]")).click();
    }

    public void click_show_statistics_link()
    {
        driver.findElement(By.xpath("//*[@id=\"go_show_statistics\"]")).click();
    }


    /**
     * @ FIXME To be removed
     * we check ifd the value added is shown in the lists
     * @return
     */
    public boolean check_new_expense_in_list(String date, String category, int amount,String reason)
    {
        boolean status = false;

        WebElement table = driver.findElement(By.xpath("/html/body/div/table"));

        List<WebElement> tr_collection = table.findElements(By.tagName("tr"));
        List <WebElement> td_collection;

        System.out.println(tr_collection.size());

        for (WebElement tr:tr_collection) {

             td_collection = tr.findElements(By.tagName("td"));

             System.out.println(td_collection.size());
             //System.out.println(td_collection.get(0).getText());
            System.out.println(td_collection.get(0).getText());
            System.out.println(td_collection.get(1).getText());
            System.out.println(td_collection.get(2).getText());
            System.out.println(td_collection.get(3).getText());
            System.out.println("____________");
             if(td_collection.get(0).getText().equalsIgnoreCase(date))
             {
                 if (td_collection.get(1).getText().equalsIgnoreCase(category))
                 {
                     if(Integer.toString(amount).equals(td_collection.get(2).getText()));
                     {
                         if(td_collection.get(3).getText().contains(reason))
                         {
                             status = true;
                             break;
                         }
                     }
                 }
             }

            System.out.println(status);

        }
        return false;
    }

    /**
     *
     * @return
     */
    public int getListSize() {

        int size = 0;

        //FIXME : Include the handling for more than 10 elements
//
//        WebElement more_arrow = driver.findElement(By.xpath("/html/body/div/table/thead/tr[1]/th"));
//
//        while(more_arrow.findElement(By.tagName("a")).isDisplayed())
//        {
//            WebElement table = driver.findElement(By.xpath("/html/body/div/table"));
//
//            List<WebElement> tr_collection = table.findElements(By.tagName("tr"));
//
//            size = size + tr_collection.size();
//
//            more_arrow.findElement(By.tagName("a")).click();
//
//        }


        WebElement table = driver.findElement(By.xpath("/html/body/div/table"));

        List<WebElement> tr_collection = table.findElements(By.tagName("tr"));

        size = size + tr_collection.size();

        return size;
    }

    public boolean delete_an_expense() {

        //we see the list of expenses:
        WebElement table = driver.findElement(By.xpath("/html/body/div/table"));
        List <WebElement> tr_collection = table.findElements(By.tagName("tr"));
        List <WebElement> td_collection;


        int no_of_categories = tr_collection.size()-1; // we exclude the header


        // We want to delete the last entry
        td_collection = tr_collection.get(no_of_categories).findElements(By.tagName("td"));


        // we click on the delete icon
        List <WebElement> anchor_tags = td_collection.get(4).findElements(By.tagName("a"));


        anchor_tags.get(2).findElement(By.tagName("img")).click();

        WebDriverWait wait = new WebDriverWait(driver, Global.WAIT_TIME);
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        //accept delete in alert box
        alert.accept();

        //we see the list of categories:
        WebElement table_new = driver.findElement(By.xpath("/html/body/div/table"));
        List <WebElement> tr_collection_new = table_new.findElements(By.tagName("tr"));

        int no_of_rows_after_delete = tr_collection_new.size() -1 ; //exclude the header

        boolean status = false;

        if (no_of_rows_after_delete == (no_of_categories -1))
        {
            status = true;
        }

        return status;

    }


    /**
     * We modifiy only the reasons
     * @return
     */
    public boolean modify_expense() {

        //we see the list of expenses:
        WebElement table = driver.findElement(By.xpath("/html/body/div/table"));
        List <WebElement> tr_collection = table.findElements(By.tagName("tr"));
        List <WebElement> td_collection;


        int no_of_categories = tr_collection.size()-1; // we exclude the header


        // We want to edit the last entry
        td_collection = tr_collection.get(no_of_categories).findElements(By.tagName("td"));


        // we click on the delete icon
        List <WebElement> anchor_tags = td_collection.get(4).findElements(By.tagName("a"));


        anchor_tags.get(0).findElement(By.tagName("img")).click();

        EditExpensePage editExpensePage = new EditExpensePage(driver);

        // get  day , month and year from the string
        int day = Integer.parseInt(Global.EXPENSE_ADD_DATE.split("\\.")[0]);
        int month = Integer.parseInt(Global.EXPENSE_ADD_DATE.split("\\.")[1]);
        int year = Integer.parseInt(Global.EXPENSE_ADD_DATE.split("\\.")[2]);

        int amount =  Global.AMOUNT;

        driver = editExpensePage.edit_expense(day+3,month+2,year,Global.CATEGORY_NAME,amount, "Pizza");


        //we now check if the data edited is saved or not



        WebElement table_new = driver.findElement(By.xpath("/html/body/div/table"));
        List <WebElement> tr_collection_new = table_new.findElements(By.tagName("tr"));
        List <WebElement> td_collection_new;

        int no_of_categories_new = tr_collection.size()-1; // we exclude the header

        td_collection_new = tr_collection_new.get(no_of_categories).findElements(By.tagName("td"));

        //FIXME : include other validation as well which are commented below
        //String modified_date = td_collection.get(0).getText();
        //String modifie_category = td_collection.get(1).getText();
        //String modifie_Amount = td_collection.get(2).getText();

        String modifie_Reason = td_collection_new.get(3).getText();

        boolean status = false;

        if (modifie_Reason.equals("Pizza"))
        {
            status = true;
        }

        return status;
    }
}
