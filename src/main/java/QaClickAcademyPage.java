import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.log.Log;

public class QaClickAcademyPage extends BasePage {

    public QaClickAcademyPage(WebDriver driver) {
        super(driver);
    }

    public By navLogin = By.cssSelector("#homepage .pull-right li a i.fa-lock");

    public LoginPage ClickNavLogin() {
        this.driver.findElement(navLogin).click();
        return new LoginPage(this.driver);
    }


}