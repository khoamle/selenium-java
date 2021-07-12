import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public By emailField = By.cssSelector("#loginfrm > div.wow.fadeIn > div:nth-child(1) > label > input[type=email]");
    public By passwordField = By.cssSelector("#loginfrm > div.wow.fadeIn > div:nth-child(2) > label > input[type=password]");
    public By loginButton = By.cssSelector("#loginfrm > button");
    public By header = By.cssSelector(".d-flex h3");

    public AccountPage EnterLoginInfo (String email, String password) {
        waitForElementToAppear(loginButton);
        this.driver.findElement(emailField).sendKeys(email);
        this.driver.findElement(passwordField).sendKeys(password);
        this.driver.findElement(loginButton).click();
        return new AccountPage(this.driver);
    }

    public boolean IsURLDisplayed(String url)   {
        waitForElementToAppear(header);
        return this.driver.getCurrentUrl().contains(url);
    }
}