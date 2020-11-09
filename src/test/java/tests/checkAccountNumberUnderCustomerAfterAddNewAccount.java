package tests;


import Utils.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Utils.Common.*;
import static Utils.ObjectRepo.*;


public class checkAccountNumberUnderCustomerAfterAddNewAccount extends BaseTest{
//
//    @BeforeClass
//    public void beforeClass() throws InterruptedException {
//        Thread.sleep(2000);
//        homePage.openBankingSite();
//        Common.switchToTab();
//        bankManagementLogin.openBankMangment();
//    }
    @Test
    public void check() throws InterruptedException {
        homePage.openBankingSite();
        Common.switchToTab();
        bankManagementLogin.openBankMangment();
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
        Assert.assertEquals(10,Integer.parseInt(AccountNumberFromTable), "the retrieved Account Number from the alert is not the same in the Table Account Number Cell");

        Assert.assertAll();
    }
}
