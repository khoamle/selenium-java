import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public By homeButton = By.cssSelector("#mobileMenuMain > nav > ul:nth-child(1) > li > a");
    public By h3Header = By.cssSelector("body > div.body-inner > div.main-wrapper.scrollspy-action > div:nth-child(2) > div > div > div:nth-child(1) > div > div.col-md-8 > h3");

    public PhpTravelsPage ClickHomeButton() {
        this.driver.findElement(homeButton).click();
        return new PhpTravelsPage(this.driver);
    }

    public boolean IsHeaderDisplayed(String text) {
        waitForElementToAppear(h3Header);
        return this.driver.findElement(h3Header).getText().contains(text);
    }
}