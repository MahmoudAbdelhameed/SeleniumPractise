package tests;

import Utils.Common;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.security.Key;

import static Utils.Common.element;
import static Utils.ObjectRepo.*;


public class deleteAccount extends BaseTest{

    @BeforeClass
     public void NavigateToCustomer() throws InterruptedException {
        bankManagementLogin.openBankMangment();
        bankManagementLogin.clickOnCustomers();
    }
    @Test
    public void deleteAccount() {
    wait.until(ExpectedConditions.elementToBeClickable(CustomerBtn));
    //delete the added customer
    element(deleteBtn).click();
    //Assert that the customer is no longer found in the customers' table
    Assert.assertFalse(element(AccountNumberInTable).isDisplayed(),"the New Added Customer is still Exist");
    Assert.assertAll();
    }
}
