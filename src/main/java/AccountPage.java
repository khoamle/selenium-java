import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public By homeButton = By.cssSelector("#mobileMenuMain > nav > ul:nth-child(1) > li > a");

    public PhpTravelsPage ClickHomeButton() {
        this.driver.findElement(homeButton).click();
        return new PhpTravelsPage(this.driver);
    }

    public boolean IsURLDisplayed(String url)   {
        return this.driver.getCurrentUrl().contains(url);
    }

}