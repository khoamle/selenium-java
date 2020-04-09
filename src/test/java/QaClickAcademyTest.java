import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class QaClickAcademyTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void QaClickAcademyTest(String emailAddress, String password) {
        QaClickAcademyPage qaClickAcademyPage = new QaClickAcademyPage(getDriver());
        getQaClickAcademyURL();

        LoginPage loginPage = qaClickAcademyPage.ClickNavLogin();
        loginPage.EnterEmailAddressField(emailAddress);
        loginPage.EnterPasswordField(password);
        CoursesPage coursesPage = loginPage.ClickLogin();
        Assert.assertTrue(coursesPage.IsMyCoursesTextDisplayed("My Courses"));
    }

    @DataProvider
    public static Object[][] getData() {
        Object[][] data = new Object[2][2];
        // 1st row
        data[0][0] ="Tester1@test.com";
        data[0][1] = "Tester!Login";

        // 2nd row
        data[1][0] ="Tester2@test.com";
        data[1][1] = "Tester!Login";
        return data;
    }


}
