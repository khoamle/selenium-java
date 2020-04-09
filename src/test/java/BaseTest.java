import io.github.bonigarcia.wdm.WebDriverManager;
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