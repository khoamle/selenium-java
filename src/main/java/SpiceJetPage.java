import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SpiceJetPage extends BasePage {

    public SpiceJetPage(WebDriver driver) {
        super(driver);
    }

    public By originDropdown = By.cssSelector("div #ctl00_mainContent_ddl_originStation1_CTXT");
    public By destinationDropdown = By.cssSelector("div #ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By roundTrip = By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1");
    private By returnDateCalendar = By.cssSelector("div #ctl00_mainContent_view_date2");
    private By passengerDropdown = By.cssSelector("#divpaxinfo");
    private By currencyDropdown = By.cssSelector("#ctl00_mainContent_DropDownListCurrency");
    public By currencyOptionsSelector =  By.cssSelector("#ctl00_mainContent_DropDownListCurrency option");
    public By departDate =  By.cssSelector("span#view_fulldate_id_1");
    public By arrivalDate =  By.cssSelector("span#view_fulldate_id_2");
    public By searchButton = By.cssSelector("input#ctl00_mainContent_btn_FindFlights");

    String originSelector = "#glsctl00_mainContent_ddl_originStation1_CTNR #dropdownGroup1 li a";
    String destinationSelector = "#glsctl00_mainContent_ddl_destinationStation1_CTNR #dropdownGroup1 li a";

    public void ClickOriginDropdown() {
        driver.findElement(originDropdown).click();
    }

    public void ClickRoundTrip() {
        driver.findElement(roundTrip).click();
    }

    public void ClickReturnDateCalendar() {
        driver.findElement(returnDateCalendar).click();
    }

    public void ClickPassengerDropdown() {
        driver.findElement(passengerDropdown).click();
    }

    public void ClickCurrencyDropdown() {
        driver.findElement(currencyDropdown).click();
    }

    public SelectFlightPage ClickSearchButton() {
        this.driver.findElement(searchButton).click();
        return new SelectFlightPage(this.driver);
    }

    public void SelectAirport (WebDriver driver, String airportCity, String airportSelector) {
        By originAirportSelector = By.cssSelector(airportSelector);
        List<WebElement> airportNames = driver.findElements(originAirportSelector);
        for(int i = 0; i < airportNames.size(); i++) {
            String airportName = airportNames.get(i).getAttribute("value");
            if(airportName.contains(airportCity)) {
                WebElement pickedAirport = driver.findElements(originAirportSelector).get(i);
                pickedAirport.click();
            }
        }
    }

    public void SelectCalendarYear (WebDriver driver, String year) {
        By yearSelector = By.cssSelector("div.ui-datepicker-group-first .ui-datepicker-year");
        while(!driver.findElement(yearSelector).getText().contains(year)) {
            WebElement nextMonth = driver.findElement(By.cssSelector("a.ui-datepicker-next"));
            nextMonth.click();
        }
    }

    public void SelectCalendarMonth (WebDriver driver, String month) {
        By monthSelector = By.cssSelector("div.ui-datepicker-group-first .ui-datepicker-month");
        while(!driver.findElement(monthSelector).getText().contains(month)) {
            WebElement nextMonth = driver.findElement(By.cssSelector("a.ui-datepicker-next"));
            nextMonth.click();
        }
    }

    public void SelectCalendarDay (WebDriver driver, String day) {
        By days = By.cssSelector("div.ui-datepicker-group-first .ui-state-default");
        List<WebElement> dates = driver.findElements(days);
        for(int i = 0; i < dates.size(); i++) {
            String calendarDate = dates.get(i).getText();
            if(calendarDate.equalsIgnoreCase(day)) {
                WebElement pickedDay = driver.findElements(days).get(i);
                pickedDay.click();
                break;
            }
        }
    }

    public void SelectRandomCurrency() {
        List<WebElement> currencyOptions = driver.findElements(currencyOptionsSelector);
        int size = currencyOptions.size();
        int randomNumber = ThreadLocalRandom.current().nextInt(1, size);
        currencyOptions.get(randomNumber).click();
    }

    public boolean IsDepartAirportNameDisplayed(String text) {
        return driver.findElement(originDropdown).getAttribute("value").contains(text);
    }

    public boolean IsArrivalAirportNameDisplayed(String text) {
        return driver.findElement(destinationDropdown).getAttribute("value").contains(text);
    }

    public boolean IsDepartDateDisplayed(String text) {
        return driver.findElement(departDate).getText().contains(text);
    }
    public boolean IsArrivalDateDisplayed(String text) {
        return driver.findElement(arrivalDate).getText().contains(text);
    }
}