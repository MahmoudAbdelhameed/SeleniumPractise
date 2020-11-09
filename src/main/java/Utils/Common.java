package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Common {


    static WebDriver driver = WebDriverSingleton.getInstance().getDriver();

    public static WebElement element(By element) {
        return WebDriverSingleton.getInstance().getDriver().findElement(element);
    }
    public static List<WebElement> elements(By element) {
        return WebDriverSingleton.getInstance().getDriver().findElements(element);
    }
    public static void scrollToElement(WebElement element){
        ((JavascriptExecutor) WebDriverSingleton.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void selectFromListByText(WebElement element, String text) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(text);
    }
    public static String getAlertText() {
        Alert alert =  driver.switchTo().alert();
        return alert.getText();
    }
    public static void acceptAlert(){
       Alert alert =  driver.switchTo().alert();
        alert.accept();
    }
    public static void selectRandomOptionFromList(By listName, By listElements) throws InterruptedException {
//        element(listName).click();
//        Thread.sleep(2000);
//        List<WebElement> option = driver.findElements(listElements);
//        option.get(getRandomNumber(option.size()));
//        option.get(1).sendKeys();
        Select dropdown = new Select(element(listName));
        int min = 1;
        int listSize = driver.findElements(listElements).size()-1;
        dropdown.selectByIndex(getRandomNumber((listSize - min) + 1) + min);
    }
    public static int getRandomNumber(int No) {
        Random randomNo = new Random();
        return randomNo.nextInt(No);
    }
    public static void switchToTab(){
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
//        element(switchTab).sendKeys(Keys.CONTROL+"\t");
    }
}

