import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ToursPage extends BasePage {

    public ToursPage(WebDriver driver) {
        super(driver);
    }

    public By bookingDate = By.cssSelector("body > div.body-inner > div > div > div.page-wrapper.page-detail.bg-light > div:nth-child(5) > div > div.col-12.col-lg-4.col-xl-3.order-lg-last > aside > div > form > div > div > div > div > div:nth-child(1) > input");
    public By adults = By.cssSelector("#selectedAdults > option");
    public By children = By.cssSelector("#selectedChild > option");
    public By infants = By.cssSelector("#selectedInfants > option");
    public By bookNowButton = By.cssSelector("body > div.body-inner > div > div > div.page-wrapper.page-detail.bg-light > div:nth-child(5) > div > div.col-12.col-lg-4.col-xl-3.order-lg-last > aside > div > form > div > form > button");

    public void FutureBookingDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.MONTH, 3);
        Date futureDate = calendar.getTime();
        this.driver.findElement(bookingDate).clear();
        this.driver.findElement(bookingDate).sendKeys(dateFormat.format(futureDate));
    }

    public void SelectRandomNumberOfAdults() {
        List<WebElement> adultOptions = driver.findElements(adults);
        int size = adultOptions.size();
        int randomAdult = ThreadLocalRandom.current().nextInt(1, size);
        adultOptions.get(randomAdult).click();
    }

    public void SelectRandomNumberOfChildren() {
        List<WebElement> childrenOptions = driver.findElements(children);
        int size = childrenOptions.size();
        int randomChildren = ThreadLocalRandom.current().nextInt(0, size);
        childrenOptions.get(randomChildren).click();
    }

    public void SelectRandomNumberOfInfants() {
        List<WebElement> infantsOptions = driver.findElements(infants);
        int size = infantsOptions.size();
        int randomInfants = ThreadLocalRandom.current().nextInt(1, size);
        infantsOptions.get(randomInfants).click();
    }

    public ConfirmationPage BookNow() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = this.driver.findElement(bookNowButton);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        waitForElementToAppear(bookNowButton);
        this.driver.findElement(bookNowButton).click();
        return new ConfirmationPage(this.driver);
    }
}