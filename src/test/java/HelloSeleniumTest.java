import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.*;


public class HelloSeleniumTest {
    public String baseUrl = "https://www.javatpoint.com/";
    String driverPath = "resources/chromedriver.exe";
    public WebDriver driver ;


    @BeforeClass
    public static void SetUpClass()
    {
        chromedriver().setup();
    }



    @Test
    public void firstTest(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        // get the current URL of the page
        String URL= driver.getCurrentUrl();
        System.out.print(URL);
        //get the title of the page
        String title = driver.getTitle();
        System.out.println(title);
        driver.quit();

    }
}
