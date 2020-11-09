package tests;


import Utils.Common;
import Utils.ObjectRepo;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static Utils.Common.*;
import static Utils.ObjectRepo.*;

public class AddCustomerTest extends BaseTest{

    @Test
    public void addNewCustomer() throws InterruptedException {
        homePage.openBankingSite();
        Common.switchToTab();
        bankManagementLogin.openBankMangment();
        bankManagementLogin.clickOnAddCustomer();
        bankManagementLogin.fillInCustomerData();

        //Get Customer ID From the Alert
        String [] splitAlertMessage = Common.getAlertText().split(":");
        int CustomerID = Integer.parseInt(splitAlertMessage[1]);
        Common.acceptAlert();

        //Click on Customers Tab
        bankManagementLogin.clickOnCustomers();

        //assert that the user order in the list is the same from the alert
        // assert that there is a new table row is added with an index equal to the new added customer id
        element(By.xpath(".//tbody/tr["+CustomerID+"]")).isDisplayed();
        //get the count of table Rows
        int tableRowsCount = elements(tableRows).size();
        //Assert the table count are the equal to the new added customer ID.
        Assert.assertEquals(tableRowsCount-1,CustomerID, "the table Rows count are not equal to the new added customer ID.");

        //Assert that the user details are precisely the same as entered in the form
        String customerFirsName = element(By.xpath(".//tbody/tr["+CustomerID+"]/td[1]")).getText();
        String customerLastName = element(By.xpath(".//tbody/tr["+CustomerID+"]/td[2]")).getText();
        String customerPostCode = element(By.xpath(".//tbody/tr["+CustomerID+"]/td[3]")).getText();
        Assert.assertEquals(customerFirsName,propertiesReader.getFirstName(), "the Customer firstName is not correct ");
        Assert.assertEquals(customerLastName,propertiesReader.getLastName(), "the Customer lastName is not correct ");
        Assert.assertEquals(customerPostCode,propertiesReader.getpostCode(), "the Customer PostCode is not correct ");
        Assert.assertAll();
    }
    @Test
    public void check() throws InterruptedException {
    // Click on Open Account
        bankManagementLogin.clickOnOpenAccount();
    //select the new added customer From the list
        Common.selectFromListByText(element(clickSelectNameList), propertiesReader.getFirstName() +" "+propertiesReader.getLastName());
    //Select a random currency (changed Every New Run)
        Common.selectRandomOptionFromList(currencyList,currencyOption);
    //Submit account
        bankManagementLogin.clickProceed();

    //Extract the Account Number From The Alert
    String [] splitAlertMessage = Common.getAlertText().split(":");
    int accountNumber = Integer.parseInt(splitAlertMessage[1]);
    //close the Alert
        Common.acceptAlert();
    //Click on Customers tab
        bankManagementLogin.clickOnCustomers();

    // Assert that the Account Number retrieved from the alert is displayed in its cell for the created customer
    String AccountNumberFromTable = element(AccountNumberInTable).getText();
        Assert.assertEquals(accountNumber,Integer.parseInt(AccountNumberFromTable), "the retrieved Account Number from the alert is not the same in the Table Account Number Cell");

        Assert.assertAll();
}
}
