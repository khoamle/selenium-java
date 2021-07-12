import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmationPage extends BasePage {

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public By confirmButton = By.cssSelector("#bookingdetails > div.form-group > button");
    public By h4header = By.cssSelector("body > div.body-inner > div.main-wrapper.scrollspy-action > div > div > div > div > div.acc_section > div > div.col-md-8.offset-0.go-right.order-2.order-lg-first > div:nth-child(2) > div.success-box > div.content > h4");

    public void ScrollIntoView() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = this.driver.findElement(confirmButton);
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public InvoicePage ConfirmBooking() {
        this.driver.findElement(confirmButton).click();
        return new InvoicePage(this.driver);
    }

    public boolean IsHeaderDisplayed(String text) {
        waitForElementToAppear(h4header);
        return this.driver.findElement(h4header).getText().contains(text);
    }
}