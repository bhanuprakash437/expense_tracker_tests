import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser_Provider {

    public WebDriver getChromeWebDriver(){
        // Provides the webdriver instance

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Medichalam\\IdeaProjects\\expence_tracker_tests\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        return driver;
    }

}
