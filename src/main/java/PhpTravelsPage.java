import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PhpTravelsPage extends BasePage {

    public PhpTravelsPage(WebDriver driver) {
        super(driver);
    }

    public By myAccount = By.cssSelector(".dropdown-login #dropdownCurrency");
    public By login = By.cssSelector("a.dropdown-item.active.tr");
    public By tours = By.cssSelector("body > div.body-inner > div.main-wrapper.scrollspy-action > div:nth-child(6) > div > div.row.equal-height.cols-2.cols-md-2.cols-lg-4.gap-10.gap-md-20.gap-xl-30 > div > figure");

    public LoginPage ClickLogin() {
        waitForElementToAppear(myAccount);
        this.driver.findElement(myAccount).click();
        this.driver.findElement(login).click();
        return new LoginPage(this.driver);
    }

//    public ToursPage SelectTour(String attribute, String text) {
//        List<WebElement> tours = this.driver.findElements(By.cssSelector("body > div.body-inner > div.main-wrapper.scrollspy-action > div:nth-child(6) > div > div.row.equal-height.cols-2.cols-md-2.cols-lg-4.gap-10.gap-md-20.gap-xl-30 > div > figure > div > img"));
//        for(int i=0;i<tours.size();i++) {
//            Boolean tour = tours.get(i).getAttribute(attribute).contains(text);
//            if(tour) {
//                this.driver.findElements(By.cssSelector("body > div.body-inner > div.main-wrapper.scrollspy-action > div:nth-child(6) > div > div.row.equal-height.cols-2.cols-md-2.cols-lg-4.gap-10.gap-md-20.gap-xl-30 > div > figure")).get(i).click();
//                break;
//            }
//        }
//        return new ToursPage(this.driver);
//    }

    public ToursPage SelectTour() {
        waitForElementToAppear(myAccount);
        List<WebElement> toursOptions = driver.findElements(tours);
        int size = toursOptions.size();
        int randomTour = ThreadLocalRandom.current().nextInt(1, size);
        toursOptions.get(randomTour).click();
        return new ToursPage(this.driver);
    }
}