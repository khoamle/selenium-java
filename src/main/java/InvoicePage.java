import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InvoicePage extends BasePage {

    public InvoicePage(WebDriver driver) {
        super(driver);
    }

    public By h4Header = By.cssSelector("body > div.body-inner > div.main-wrapper.scrollspy-action > div.main-wrapper.scrollspy-action > div > div > div.success-box.unpaid > div.content > h4");
    public By payOnArrival = By.xpath("//*[@id=\"44\"]");

    public void ClickPayOnArrival() {
        waitForElementToAppear(payOnArrival);
        this.driver.findElement(payOnArrival).click();
        this.driver.switchTo().alert().accept();
    }

}