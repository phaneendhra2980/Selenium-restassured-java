package browserStackPages;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserStackSignUpPage {
    WebDriver driver;
    By Header = By.xpath("//h1");
    By userName = By.xpath("//*[@id='user_full_name']");
    By businessEmail = By.xpath("//*[@id='user_email_login']");
    By password = By.xpath("//*[@id='user_password']");

    public BrowserStackSignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void veryHeader() {
        String getheadertext = driver.findElement(Header).getText().trim();
        assertEquals("Create a FREE Account", getheadertext);
    }
    public void enterFullName(String arg1) {
        driver.findElement(userName).sendKeys(arg1);
    }
    public void enterBusinessEmail(String arg1) {
        driver.findElement(businessEmail).sendKeys(arg1);
    }
    public void enterPasswrod(String arg1) {
        driver.findElement(password).sendKeys(arg1);
    }
}