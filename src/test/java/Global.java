import java.util.Date;
import java.util.List;
import java.util.Random;

public class Global {

    static Random ran = new Random();

    public static  String[] reason = {"gym" , "misc." , "shopping" , "doctor visit" , "bla bla", "i need to eat", "travel"};


    //program settings
    public static String CHROME_DRIVER_PATH =  "C:\\Users\\Medichalam\\IdeaProjects\\expence_tracker_tests\\chromedriver.exe";
    public static  int WAIT_TIME = 5000;     // 5000 milli seconds



    public static String TEST_SITE_URL = "http://thawing-shelf-73260.herokuapp.com/index.jsp";


    //User Data
    public static  String ACTUAL_UNAME = "RajM";
    public static  String ACTUAL_PASSWORD = "bhanu";


    //Category name
    public static String CATEGORY_NAME = "Food";


    //add expense
    public static String EXPENSE_ADD_DATE = "21.01.2017";
    public static int AMOUNT = ran.nextInt(1000);
    public static String REASON = reason[ran.nextInt(reason.length)];



}
