import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public By emailAddressSelector = By.cssSelector("#user_email");
    public By passwordSelector = By.cssSelector("#user_password");
    public By loginButton = By.cssSelector("#new_user .form-group.text-center input");

    public void EnterEmailAddressField (String emailAddress) {
        this.driver.findElement(emailAddressSelector).sendKeys(emailAddress);
    }

    public void EnterPasswordField (String password) {
        this.driver.findElement(passwordSelector).sendKeys(password);
    }

    public CoursesPage ClickLogin() {
        this.driver.findElement(loginButton).click();
        return new CoursesPage(this.driver);
    }


}