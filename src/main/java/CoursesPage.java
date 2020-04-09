import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoursesPage extends BasePage {

    public CoursesPage(WebDriver driver) {
        super(driver);
    }

    public By myCourses = By.cssSelector("body > header > div.header-upper > div > div > div.nav-outer.clearfix > nav > div.navbar-collapse.collapse.clearfix > ul > li:nth-child(1) > a");

    public boolean IsMyCoursesTextDisplayed(String text) {
        return driver.findElement(myCourses).getText().contains(text);
    }

}