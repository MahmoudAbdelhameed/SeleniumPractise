package Utils;

import org.openqa.selenium.By;

public class ObjectRepo {
    static PropertiesReader propertiesReader = new PropertiesReader();

    public static By bankingSite = By.xpath("//h2[contains(.,'Banking')]");
    public static By bankManagementLogin = By.xpath("//button[contains(.,'Bank Manager Login')]");
    public static By addCustomerBtn = By.xpath("//button[contains(.,'Add Customer')]");
    public static By firstName = By.xpath("//input[@placeholder = 'First Name']");
    public static By lastName = By.xpath("//input[@placeholder = 'Last Name']");
    public static By postCode = By.xpath("//input[@placeholder = 'Post Code']");
    public static By proceed = By.xpath("//button[@type='submit' and contains(., 'Process')]");
    public static By addCustomerSubmitBtn = By.xpath("//button[@type='submit' and contains(., 'Add Customer')]");
    public static By CustomerBtn = By.xpath("//button[contains(.,'Customers') and @ng-class = 'btnClass3']");
    public static By openAccountBtn = By.xpath("//button[contains(.,'Open Account')]");
    public static By clickSelectNameList = By.id("userSelect");
    public static By currencyList = By.id("currency");
    public static By currencyOption = By.xpath("//*[@id = 'currency']//option");//to get all the option of the list
    public static By tableRows = By.tagName("tr");

    public static By deleteBtn = By.xpath("//tr[td[contains(.,'"+propertiesReader.getFirstName()+"')]]/following-sibiling::button[contains(.,'Delete')]");
    public static By AccountNumberInTable = By.xpath("//tbody/tr[td[contains(.,'"+propertiesReader.getFirstName()+"')]]/td[4]/span");
//    public static By t = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/table/tbody/tr[6]");

}

