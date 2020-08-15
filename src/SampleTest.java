import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import java.lang.*;




public class SampleTest {

    public String URL = "https://thoughtcoders.com";
    public WebDriver driver;

    @Test(priority = 1)
    public void verifyHomepageTitle() {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.out.println("launching chrome browser");
        driver = new ChromeDriver();
        driver.get(URL);
        String expWinTitle ="ThoughtCoders | Web Development, Automation, QA Training";
        String actWinTitle = driver.getTitle();

        //Assertion for window title
        Assert.assertEquals(actWinTitle,expWinTitle);


    }
    @Test(priority = 2)
    public void goToBlogs(){
        driver.findElement(By.xpath("//a[@title='Blogs']")).click();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//            driver.findElement(By.xpath("//a[contains(text(),'Top 25 Appium Interview Questions with Answers')]")).click();
//        driver.switchTo().window("Blog | ThoughtCoders");
        //*[@id="menu-item-662"]/a
        String winUrl = driver.getCurrentUrl();
        System.out.println(winUrl);

        System.out.println(driver.getTitle());
    }

    @Test(priority = 3)
    public void closeConnections() {
        driver.quit();

    }
}
