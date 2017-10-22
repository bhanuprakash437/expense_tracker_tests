import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class use_case_005 extends  Base_Class {

    public static WebDriver driver;
    /**
     * This is a helper method to get the browser instance before the test suite runs.
     */
    @Before
    public void setDriver()
    {
        super.setDriver();
    }


    @Test
    public void check_graph_exisits()
    {

        driver = this.login();

        ListExpensesPage list_expenses_page = new ListExpensesPage(driver);

        list_expenses_page.click_show_statistics_link();

        StatisticsPage statisticsPage = new StatisticsPage(driver);

        boolean status = statisticsPage.check_graph();

        Assert.assertEquals(status,true);
    }


    @Test
    public void check_summary_exisits()
    {

        driver = this.login();

        ListExpensesPage list_expenses_page = new ListExpensesPage(driver);

        list_expenses_page.click_show_statistics_link();

        StatisticsPage statisticsPage = new StatisticsPage(driver);

        boolean status = statisticsPage.show_summary();

        Assert.assertEquals(status,true);
    }

    @Test
    public void check_date_picker()
    {

        driver = this.login();

        ListExpensesPage list_expenses_page = new ListExpensesPage(driver);

        list_expenses_page.click_show_statistics_link();

        StatisticsPage statisticsPage = new StatisticsPage(driver);

        boolean status = statisticsPage.show_datepicker();

        Assert.assertEquals(status,true);
    }

    @After
    public void quitDriver()
    {
        super.quitDriver();
    }


}
