import org.testng.Assert;
import org.testng.annotations.Test;

public class ConAff extends BaseTest {

    @Test
    public void WebPageTest () {
        ConAffPage conAffPage = new ConAffPage(getDriver());
        getConAffURL();


        Assert.assertTrue(conAffPage.IsDisclaimerDisplayed("ConsumerAffairs is not a government agency"));
        Assert.assertTrue(conAffPage.IsFooterDisplayed("2021 Consumers Unified LLC"));
        conAffPage.ClickFacebookLink();
        conAffPage.waitForElementToAppear(conAffPage.facebookConAffText);
        conAffPage.SwitchWindow();
        //Assert.assertTrue(conAffPage.IsFooterDisplayed("ConsumerAffairs.Com"));




    }





}
