import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InvoicePage extends BasePage {

    public InvoicePage(WebDriver driver) {
        super(driver);
    }

    public By h4Header = By.cssSelector("body > div.body-inner > div.main-wrapper.scrollspy-action > div.main-wrapper.scrollspy-action > div > div > div.success-box.unpaid > div.content > h4");
    public By payOnArrival = By.xpath("//*[text()='Pay on Arrival']");

    public void ClickPayOnArrival() {
        waitForElementToAppear(payOnArrival);
        this.driver.findElement(payOnArrival).click();
        this.driver.switchTo().alert().accept();
    }

    public boolean IsHeaderDisplayed(String text) {
        waitForElementToAppear(h4Header);
        return this.driver.findElement(h4Header).getText().contains(text);
    }

}