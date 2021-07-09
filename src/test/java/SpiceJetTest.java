import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpiceJetTest extends BaseTest {

    @Test
    public void SelectFlightTest() {
        SpiceJetPage spiceJetPage = new SpiceJetPage(getDriver());
        getSpiceJetURL();

        //Selects the departure and arrival city
        spiceJetPage.waitForElementToAppear(spiceJetPage.originDropdown);
        spiceJetPage.ClickRoundTrip();
        spiceJetPage.ClickOriginDropdown();
        spiceJetPage.SelectAirport(getDriver(), "BLR", spiceJetPage.originSelector);
        spiceJetPage.SelectAirport(getDriver(), "MAA", spiceJetPage.destinationSelector);
        Assert.assertTrue(spiceJetPage.IsDepartAirportNameDisplayed("BLR"));
        Assert.assertTrue(spiceJetPage.IsArrivalAirportNameDisplayed("MAA"));

        //Selects the departure and return dates (Day, Month, Year). Month/Year selection up to 12 months limit
        spiceJetPage.SelectCalendarYear(getDriver(), "2021");
        spiceJetPage.SelectCalendarMonth(getDriver(), "July");
        spiceJetPage.SelectCalendarDay(getDriver(), "20");
        Assert.assertTrue(spiceJetPage.IsDepartDateDisplayed("Jul 20 2021"));

        spiceJetPage.ClickReturnDateCalendar();
        spiceJetPage.SelectCalendarYear(getDriver(), "2021");
        spiceJetPage.SelectCalendarMonth(getDriver(), "October");
        spiceJetPage.SelectCalendarDay(getDriver(), "10");
        Assert.assertTrue(spiceJetPage.IsArrivalDateDisplayed("Oct 10 2021"));

        //Selects the number of adults, children, and infants
        By adultDropdown = By.cssSelector("select#ctl00_mainContent_ddl_Adult");
        By childDropdown = By.cssSelector("select#ctl00_mainContent_ddl_Child");
        By infantDropdown = By.cssSelector("select#ctl00_mainContent_ddl_Infant");
        Select selectAdultDropdown = new Select(getDriver().findElement(adultDropdown));
        Select selectChildDropdown = new Select(getDriver().findElement(childDropdown));
        Select selectInfantDropdown = new Select(getDriver().findElement(infantDropdown));
        spiceJetPage.ClickPassengerDropdown();
        spiceJetPage.waitForElementToAppear(adultDropdown);
        selectAdultDropdown.selectByValue("3");
        selectChildDropdown.selectByValue("4");
        selectInfantDropdown.selectByValue("3");

        //Randomly select currency option from dropdown list
        spiceJetPage.ClickCurrencyDropdown();
        spiceJetPage.SelectRandomCurrency();
        spiceJetPage.ClickCurrencyDropdown();
        SelectFlightPage selectFlightPage = spiceJetPage.ClickSearchButton();
        Assert.assertEquals(selectFlightPage.IsOutboundTitleTextDisplayed(), "CHOOSE A");
        Assert.assertEquals(selectFlightPage.IsDepartureFlightTextDisplayed(), "DEPARTURE FLIGHT");
    }
}
