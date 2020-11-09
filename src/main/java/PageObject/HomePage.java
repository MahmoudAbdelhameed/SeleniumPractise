package PageObject;

import Utils.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Utils.Common.*;
import static Utils.ObjectRepo.*;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    PropertiesReader propertiesReader;

    public HomePage(WebDriver driver) {
        propertiesReader = new PropertiesReader();
        this.driver = driver;
        wait = new WebDriverWait(this.driver,propertiesReader.getWaitTimeOut());
    }

    public void openBankingSite()  {
        Common.scrollToElement(element(bankingSite));
        wait.until(ExpectedConditions.elementToBeClickable(bankingSite));
        element(bankingSite).click();
    }
}
