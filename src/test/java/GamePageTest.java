import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GamePageTest extends BaseTest {

    @Test
    public void GameTest () {
        GamePage gamePage = new GamePage(getDriver());
        getGameURL();
        System.out.println("AfterLoop" + gamePage.bars);
        gamePage.secondWeighing();
        System.out.println(gamePage.bars);


        //gamePage.bars.get(gamePage.secondWeighing()).click();

        //gamePage.clickOnElements(gamePage.bars.get(gamePage.secondWeighing()));
        //Assert.assertEquals(gamePage.expectedResult, gamePage.alertText());
    }





}
