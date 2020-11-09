package PageObject;

import Utils.PropertiesReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static Utils.Common.element;
import static Utils.ObjectRepo.*;


public class BankManagementLogin {
    WebDriver driver;
    WebDriverWait wait;
    PropertiesReader propertiesReader;

    public BankManagementLogin(WebDriver driver) {
        propertiesReader = new PropertiesReader();
        this.driver = driver;
        wait = new WebDriverWait(this.driver,propertiesReader.getWaitTimeOut());
    }

    public void openBankMangment(){
        wait.until(ExpectedConditions.elementToBeClickable(bankManagementLogin));
        element(bankManagementLogin).click();

    }
    public void clickOnAddCustomer(){
        wait.until(ExpectedConditions.elementToBeClickable(addCustomerBtn));
        element(addCustomerBtn).click();
    }
    public void fillInCustomerData() {
        wait.until(ExpectedConditions.elementToBeClickable(firstName));
        element(firstName).sendKeys(propertiesReader.getFirstName());
        wait.until(ExpectedConditions.elementToBeClickable(lastName));
        element(lastName).sendKeys(propertiesReader.getLastName());
        wait.until(ExpectedConditions.elementToBeClickable(postCode));
        element(postCode).sendKeys(propertiesReader.getpostCode());
        wait.until(ExpectedConditions.elementToBeClickable(addCustomerSubmitBtn));
        element(addCustomerSubmitBtn).click();
    }

    public void clickProceed() {
        wait.until(ExpectedConditions.elementToBeClickable(proceed));
        element(proceed).click();
    }

    public void clickOnCustomers() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(CustomerBtn));
        element(CustomerBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(CustomerBtn));
        Thread.sleep(1000);
    }

    public void clickOnOpenAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(openAccountBtn));
        element(openAccountBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(clickSelectNameList));
    }

}
