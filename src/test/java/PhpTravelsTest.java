import org.testng.Assert;
import org.testng.annotations.Test;

public class PhpTravelsTest extends BaseTest {

    @Test
    public void PhpTravelsTest() {
        PhpTravelsPage phpTravelsPage = new PhpTravelsPage(getDriver());
        getPhpTravelsURL();

        phpTravelsPage.waitForElementToAppear(phpTravelsPage.myAccount);
        LoginPage loginPage = phpTravelsPage.ClickLogin();
        loginPage.waitForElementToAppear(loginPage.header);
        Assert.assertEquals(loginPage.IsURLDisplayed("login"), true);

        loginPage.waitForElementToAppear(loginPage.loginButton);
        AccountPage accountPage = loginPage.EnterLoginInfo("user@phptravels.com", "demouser");

        accountPage.ClickHomeButton();

        phpTravelsPage.waitForElementToAppear(phpTravelsPage.myAccount);

        ToursPage toursPage = phpTravelsPage.SelectTour();
        toursPage.FutureBookingDate();
        toursPage.SelectRandomNumberOfAdults();
        toursPage.SelectRandomNumberOfChildren();
        toursPage.SelectRandomNumberOfInfants();

        ConfirmationPage confirmationPage = toursPage.BookNow();
        confirmationPage.waitForElementToAppear(confirmationPage.h4header);
        confirmationPage.ScrollIntoView();
        InvoicePage invoicePage = confirmationPage.ConfirmBooking();
        invoicePage.waitForElementToAppear(invoicePage.h4Header);
        invoicePage.ClickPayOnArrival();
    }
}
