import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectFlightPage extends BasePage {

    public SelectFlightPage(WebDriver driver) {
        super(driver);
    }

    public By outboundTitleSelector = By.cssSelector("#availabilityTable1 span.outbound-title");
    public By departFlightSelector = By.cssSelector("span.bound-city.uppercase");

    public String IsOutboundTitleTextDisplayed() {
        return driver.findElement(outboundTitleSelector).getText();
    }

    public String IsDepartureFlightTextDisplayed() {
        return driver.findElement(departFlightSelector).getText();
    }
}