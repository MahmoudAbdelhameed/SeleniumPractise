package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {
    private static WebDriverSingleton webDriverSingleton =null;
    private WebDriver driver;

    private WebDriverSingleton() {
        WebDriverManager.chromedriver().clearDriverCache();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static WebDriverSingleton getInstance(){
        if (webDriverSingleton == null) {
            webDriverSingleton = new WebDriverSingleton();
        }
        return webDriverSingleton;
    }

    public WebDriver getDriver(){
        return driver;
    }
}
