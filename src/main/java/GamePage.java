import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class GamePage extends BasePage {

    public GamePage(WebDriver driver) {
        super(driver);
    }

    public static final String expectedResult = "Yay! You find it!";

    //List of element;
    public List<WebElement> bars = this.driver.findElements(By.cssSelector(".coins .square"));
    public By resultStatus = By.cssSelector(".result .button");
    public By weigh = By.id("weigh");
    public By reset = By.xpath("//button[.='Reset']");

    private String leftBowlBoard = "//input[@id='left_%s']";
    private String rightBowlBoard = "//input[@id='right_%s']";

    // returns ">", "<" or "="
    public String resultCheck(){
        waitForElementToAppear(resultStatus);
        return this.driver.findElement(resultStatus).getText().trim();
    }

    // first Weighing: I decided to split golden bars  into 3 parts
    // at this method I put 0-2 on left and 3-5 on right Bowl Boards.
    public void firstWeighing(){
        int third = (bars.size()-1)/3;
        for (int i = 0; i < third ; i++) {
            //this will re-assign element to 0-2
            WebElement elementOnLeft = driver.findElement(By.xpath(String.format(leftBowlBoard,i)));
            //will send text in the left bowl 0-2
            enterText(elementOnLeft,i+"");
            //this will re-assign element to 3-5
            WebElement elementOnRight = driver.findElement(By.xpath(String.format(rightBowlBoard,i+third)));
            //will send text in the right bowl 3-5
            enterText(elementOnRight,i+third+"");
        }
        //click on weigh button
        clickOnElement(weigh);
        System.out.println(bars);
    }

    public int secondWeighing() {
        firstWeighing();

//        if(resultCheck().equals("=")) {
//            clickOnElement(reset);
//            int third = (bars.size()-1)/3;
//            for (int i = 0; i < third ; i++) {
//                //this will re-assign element to 0-2
//                WebElement elementOnLeft = driver.findElement(By.xpath(String.format(leftBowlBoard,i)));
//                //will send text in the left bowl 0-2
//                enterText(elementOnLeft,i+"");
//                //this will re-assign element to 6-8
//                WebElement elementOnRight = driver.findElement(By.xpath(String.format(rightBowlBoard,i+third + third)));
//                //will send text in the right bowl 6-8
//                enterText(elementOnRight,i + third + third +"");
//            }
//            //click on weigh button
//            clickOnElement(weigh);
//            return (resultCheck().equals("<"))?3:(resultCheck().equals(">"))?4:5;
//        }

        // 1. ">" - means that fake gold bar is on the left bowl: so its 3,4 or 5. I compare 3 and 4 in second weighing; also 3 possible scenarios
        // depends on the second weighing I built ternary return. If "<", fake bar is number 3, If ">", fake bar is number 4, if "=", fake bar is 5(no other options left).
        if(resultCheck().equals(">")){
            clickOnElement(reset);
            this.driver.findElement(By.xpath(String.format(leftBowlBoard,3))).sendKeys(3+"");
            this.driver.findElement(By.xpath(String.format(rightBowlBoard,4))).sendKeys(4+"");
            clickOnElement(weigh);
            return (resultCheck().equals("<"))?3:(resultCheck().equals(">"))?4:5;
            // 2. ">" - means that fake gold bar is on the left bowl: so its 0,1 or 2. I compare 0 and 1 in second weighing; also 3 possible scenarios
            // depends on the second weighing I built ternary return. If "<", fake bar is number 0, If ">", fake bar is number 1, if "=", fake bar is 2(no other options left).
        }else if (resultCheck().equals("<")){
            clickOnElement(reset);
            this.driver.findElement(By.xpath(String.format(leftBowlBoard,0))).sendKeys(0+"");
            this.driver.findElement(By.xpath(String.format(rightBowlBoard,1))).sendKeys(1+"");
            clickOnElement(weigh);
            return (resultCheck().equals("<"))?0:(resultCheck().equals(">"))?1:2;
            // 3. ">" - means that fake gold bar is on the left bowl: so its 6,7 or 8. I compare 6 and 7 in second weighing; also 3 possible scenarios
            // depends on the second weighing I built ternary return. If "<", fake bar is number 6, If ">", fake bar is number 7, if "=", fake bar is 8(no other options left).
        }else{
            clickOnElement(reset);
            this.driver.findElement(By.xpath(String.format(leftBowlBoard,6))).sendKeys(6+"");
            this.driver.findElement(By.xpath(String.format(rightBowlBoard,7))).sendKeys(7+"");
            clickOnElement(weigh);
            return (resultCheck().equals("<"))?6:(resultCheck().equals(">"))?7:8;
        }
    }

    public String alertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }
}