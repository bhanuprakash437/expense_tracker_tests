import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
