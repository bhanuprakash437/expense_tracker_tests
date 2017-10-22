import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class use_case_003 extends Base_Class {



    /**
     * This is a helper method to get the browser instance before the test suite runs.
     */
    @Before
    public void setDriver()
    {
        super.setDriver();
    }

    /**
     * To delete an entry form the list of expenses.We accept the alert pop up.
     */
    @Test
    public void delete_expense_with_alert(){
        HomePage homePage = new HomePage(driver);

        driver = homePage.login();

        ListExpensesPage list_expenses_page = new ListExpensesPage(driver);
        boolean  status = list_expenses_page.delete_an_expense();

        Assert.assertEquals(status,true);
    }

    /**
     * To delete an entry form the list of expenses.We accept the alert pop up.
     */
    @Test
    public void modify_expense(){
        HomePage homePage = new HomePage(driver);
        driver = homePage.login();

        ListExpensesPage list_expenses_page = new ListExpensesPage(driver);
        boolean  status = list_expenses_page.modify_expense();

        Assert.assertEquals(status,true);
    }




    @After
    public void quitDriver()
    {
        super.quitDriver();
    }

}
