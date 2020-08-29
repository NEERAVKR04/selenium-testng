import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import java.lang.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;


public class SampleTest {

    public String URL = "https://thoughtcoders.com";
    public WebDriver driver;
    public WebElement e;
    String driverPath = "C:\\Users\\Administrator\\Downloads\\chromedriver_win32\\chromedriver.exe";

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver",driverPath);
        System.out.println("launching chrome browser");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method testing");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After method testing");
    }
    @Test(priority = 1)
    public void verifyHomepageTitle() {

        String expWinTitle ="ThoughtCoders | Web Development, Automation, QA Training";
        String actWinTitle = driver.getTitle();

        //Assertion for window title
        Assert.assertEquals(actWinTitle,expWinTitle);

    }
    @Test(priority = 2)
    public void goToBlogs() throws InterruptedException {
        Actions action = new Actions(driver);
        e = driver.findElement(By.xpath("//a[@title='Blogs']"));
        action.moveToElement(e).perform();

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Blog']")));
        e = driver.findElement(By.xpath("//a[@title='Blog']"));
        e.click();
        Thread.sleep(5000);

        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        String winUrl = driver.getCurrentUrl();
        System.out.println(winUrl);

        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//a[contains(text(),'Top 25 Appium Interview Questions with Answers')]")).click();
        Thread.sleep(5000);

    }
    @Test(priority = 3)
    public void postValidation(){
        String winUrl = driver.getCurrentUrl();
        System.out.println(winUrl);
        String postTitle = driver.getTitle();
        System.out.println(driver.getTitle());

        // verify post title
        if(!postTitle.contains("Top 25 Appium Interview Questions with Answers")){
            Assert.fail();
        }


    }

    @AfterTest
    public void closeConnections() {
        driver.quit();
        System.out.println("Browser closed!!");

    }
}
