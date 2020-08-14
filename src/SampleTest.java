import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class SampleTest {

    public String URL = "https://thoughtcoders.com";
    public WebDriver driver;

    @Test(priority = 1)
    public void verifyHomepageTitle() {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.out.println("launching chrome browser");
        driver = new ChromeDriver();
        driver.get("https://thoughtcoders.com");
        String expWinTitle ="ThoughtCoders | Web Development, Automation, QA Training";
        String actWinTitle = driver.getTitle();

        //Assertion for window title
        Assert.assertEquals(actWinTitle,expWinTitle);


    }
    @Test(priority = 2)
    public void closeConnections() {
        driver.quit();

    }
}
