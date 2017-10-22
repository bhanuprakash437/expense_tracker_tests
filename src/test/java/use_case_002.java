
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class use_case_002 extends Base_Class {


    /**
     * This is a helper method to get the browser instance before the test suite runs.
     */
    @Before
    public void setDriver()
    {
        super.setDriver();
    }


    /**
     * Add a new expense to the account
     *Assumption : A category already exists and there are no more than 10 elements
     */
    @Test
    public void addExpense()
    {
        HomePage homePage = new HomePage(driver);

        driver = homePage.login();

        ListExpensesPage list_expenses_page = new ListExpensesPage(driver);
        int list_size = list_expenses_page.getListSize();

        list_expenses_page.click_add_expense_link();

        // now in the add expense page
        AddExpensePage addExpensePage = new AddExpensePage(driver);


        // get  day , month and year from the string
        int day = Integer.parseInt(Global.EXPENSE_ADD_DATE.split("\\.")[0]);
        int month = Integer.parseInt(Global.EXPENSE_ADD_DATE.split("\\.")[1]);
        int year = Integer.parseInt(Global.EXPENSE_ADD_DATE.split("\\.")[2]);

        int amount =  Global.AMOUNT;

        driver = addExpensePage.add_expense(day,month,year,Global.CATEGORY_NAME,amount, Global.REASON);

        this.include_delay();

        ListExpensesPage list_expenses_page1 =  new ListExpensesPage(driver);

        int list_size_after_add = list_expenses_page1.getListSize();

        Assert.assertEquals(list_size_after_add,list_size+1);

    }


    @After
    public void quitDriver()
    {
        super.quitDriver();
    }
}
