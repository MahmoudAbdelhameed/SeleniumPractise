package tests;

import PageObject.BankManagementLogin;
import PageObject.HomePage;
import Utils.Common;
import Utils.PropertiesReader;
import Utils.WebDriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    WebDriverWait wait;
    PropertiesReader propertiesReader;
    SoftAssert Assert;
    HomePage homePage;
    BankManagementLogin bankManagementLogin;

    @BeforeClass
    public void beforeClass() throws InterruptedException {
        propertiesReader = new PropertiesReader();
        wait = new WebDriverWait(WebDriverSingleton.getInstance().getDriver(),propertiesReader.getWaitTimeOut());
        homePage= new HomePage(WebDriverSingleton.getInstance().getDriver());
        bankManagementLogin = new BankManagementLogin(WebDriverSingleton.getInstance().getDriver());
        Assert = new SoftAssert();

        //Create new chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriverSingleton.getInstance().getDriver().manage().window().maximize();

        //navigate to the Banking Url
        WebDriverSingleton.getInstance().getDriver().navigate().to(propertiesReader.getUrl());

 }

    @AfterClass
    public void tearDownAfterClass(){
    WebDriverSingleton.getInstance().getDriver().quit();
    }
}
