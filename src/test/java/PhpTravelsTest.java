import org.testng.Assert;
import org.testng.annotations.Test;

public class PhpTravelsTest extends BaseTest {

    @Test
    public void PhpTravelsTest() {
        PhpTravelsPage phpTravelsPage = new PhpTravelsPage(getDriver());
        getPhpTravelsURL();

        LoginPage loginPage = phpTravelsPage.ClickLogin();
        Assert.assertEquals(loginPage.IsURLDisplayed("login"), true);

        AccountPage accountPage = loginPage.EnterLoginInfo("user@phptravels.com", "demouser");
        Assert.assertTrue(accountPage.IsHeaderDisplayed("Demo User"));

        accountPage.ClickHomeButton();
        ToursPage toursPage = phpTravelsPage.SelectTour();
        toursPage.FutureBookingDate();
        toursPage.SelectRandomNumberOfAdults();
        toursPage.SelectRandomNumberOfChildren();
        toursPage.SelectRandomNumberOfInfants();

        ConfirmationPage confirmationPage = toursPage.BookNow();
        Assert.assertTrue(confirmationPage.IsHeaderDisplayed("Please read"));

        confirmationPage.ScrollIntoView();
        InvoicePage invoicePage = confirmationPage.ConfirmBooking();
        Assert.assertTrue(invoicePage.IsHeaderDisplayed("Unpaid"));

        invoicePage.ClickPayOnArrival();
    }
}
