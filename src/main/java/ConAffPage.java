import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class ConAffPage extends BasePage {

    public ConAffPage(WebDriver driver) {
        super(driver);
    }

    public By disclaimer = By.xpath("//*[@id=\"news_article\"]/footer/div[2]/div[1]/p[1]");
    public By footer = By.xpath("//*[@id=\"news_article\"]/footer/div[2]/div[1]/p[2]");
    public By facebookLink = By.xpath("//*[@id=\"wrpr\"]/div[3]/article/div[2]/a[1]");
    public By facebookConAffText = By.cssSelector("#content > span");




    public boolean IsDisclaimerDisplayed(String text) {
        return this.driver.findElement(disclaimer).getText().contains(text);
    }

    public boolean IsFooterDisplayed(String text) {
        return this.driver.findElement(footer).getText().contains(text);
    }

    public boolean IsFacebookTextDisplayed(String text) {
        return this.driver.findElement(facebookConAffText).getText().contains(text);
    }

    public void ClickFacebookLink() {
        this.driver.findElement(facebookLink).click();
    }

    public void SwitchWindow() {
        Set<String> window = this.driver.getWindowHandles();
        Iterator<String> i = window.iterator();
        String mainWindow = i.next();
        String popUpWindow = i.next();
        this.driver.switchTo().window(popUpWindow);
        IsFacebookTextDisplayed("ConsumerAffairs.Com");
    }
}