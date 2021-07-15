import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    public WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void getSpiceJetURL() {
        driver.get("https://www.spicejet.com");
    }
    public void getQaClickAcademyURL() {
        driver.get("http://www.qaclickacademy.com/");
    }
    public void getPhpTravelsURL() {
        driver.get("https://www.phptravels.net/");
    }
    public void getGameURL() { driver.get("http://ec2-54-208-152-154.compute-1.amazonaws.com/"); }
    public void getConAffURL() { driver.get("https://www.consumeraffairs.com/recalls/liberty-mountain-recalls-birdie-belay-devices-032921.html"); }

    @AfterSuite
    public void TearDown() {
        driver.close();
        driver.quit();
    }

    @AfterSuite
    public WebDriver getDriver() {
        return driver;
    }
}