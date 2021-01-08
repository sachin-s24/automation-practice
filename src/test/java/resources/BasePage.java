package resources;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public static WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jsExecutor;

    public BasePage() {
        this.wait = new WebDriverWait(driver, 10);
        jsExecutor = ((JavascriptExecutor) driver);
    }

    public static WebDriver initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }






}
