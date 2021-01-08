package resources.pageObjects;

import com.vimalselvam.cucumber.listener.Reporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.Date;

public class BasePage {

    public static WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jsExecutor;
    private static String screenshotName ;


    public static WebDriver initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }


    /**********************************************************************************
     **CLICK METHODS
     **********************************************************************************/
    public void waitAndClickElement(WebElement element) {
        boolean clicked = false;
        int attempts = 0;
        while (!clicked && attempts < 10) {
            try {
                this.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                System.out.println("Successfully clicked on the WebElement: " + "<" + element.toString() + ">");
                clicked = true;
            } catch (Exception e) {
                System.out.println("Unable to wait and click on WebElement, Exception: " + e.getMessage());
                Assert.fail("Unable to wait and click on the WebElement, using locator: " + "<" + element.toString() + ">");
            }
            attempts++;
        }
    }

    public void actionMoveAndClick(WebElement element) throws Exception {
        Actions ob = new Actions(driver);
        try {
            this.wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
            ob.moveToElement(element).click().build().perform();
            System.out.println("Successfully Action Moved and Clicked on the WebElement, using locator: " + "<" + element.toString() + ">");
        } catch (StaleElementReferenceException elementUpdated) {
            WebElement elementToClick = element;
            Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(elementToClick)).isEnabled();
            if (elementPresent == true) {
                ob.moveToElement(elementToClick).click().build().perform();
                System.out.println("(Stale Exception) - Successfully Action Moved and Clicked on the WebElement, using locator: " + "<" + element.toString() + ">");
            }
        } catch (Exception e) {
            System.out.println("Unable to Action Move and Click on the WebElement, using locator: " + "<" + element.toString() + ">");
            Assert.fail("Unable to Action Move and Click on the WebElement, Exception: " + e.getMessage());
        }
    }


    /**********************************************************************************
     **SEND KEYS METHODS /
     **********************************************************************************/
    public void sendKeysToWebElement(WebElement element, String textToSend) throws Exception {
        try {
            this.WaitUntilWebElementIsVisible(element);
            element.clear();
            element.sendKeys(textToSend);
            System.out.println("Successfully Sent the following keys: '" + textToSend + "' to element: " + "<" + element.toString() + ">");
        } catch (Exception e) {
            System.out.println("Unable to locate WebElement: " + "<" + element.toString() + "> and send the following keys: " + textToSend);
            Assert.fail("Unable to send keys to WebElement, Exception: " + e.getMessage());
        }
    }


    /**********************************************************************************
     **WAIT METHODS
     **********************************************************************************/
    public boolean WaitUntilWebElementIsVisible(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("WebElement is visible using locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            System.out.println("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
            Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
            return false;
        }
    }

    /**********************************************************************************
     **PAGE METHODS
     **********************************************************************************/
    public boolean isElementClickable(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.elementToBeClickable(element));
            System.out.println("WebElement is clickable using locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            System.out.println("WebElement is NOT clickable using locator: " + "<" + element.toString() + ">");
            return false;
        }
    }

    public BasePage loadUrl(String url) throws Exception {
        try {
            driver.get(url);
        } catch (Exception e) {
            System.out.println("Unable to click the current URL, Exception: " + e.getMessage());
        }
        return new BasePage();
    }


    public String getCurrentURL() {
        try {
            String url = driver.getCurrentUrl();
            System.out.println("Found(Got) the following URL: " + url);
            return url;
        } catch (Exception e) {
            System.out.println("Unable to locate (Get) the current URL, Exception: " + e.getMessage());
            return e.getMessage();
        }
    }

    public void verifyFileExists(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exist.");
        }
        Assert.assertTrue(file.exists() && !file.isDirectory());
    }



    /**********************************************************************************
     **EXTENT REPORT
     **********************************************************************************/

    public static String returnDateStamp(String fileExtension) {
        Date d = new Date();
        String date = d.toString().replace(":", "_").replace(" ", "_") + fileExtension;
        return date;
    }

    public static void captureScreenshot() throws IOException, InterruptedException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        screenshotName = returnDateStamp(".jpg");
        FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "\\output\\imgs\\" + screenshotName));
        Reporter.addStepLog("Taking a screenshot!");
        Reporter.addStepLog("<br>");
        Reporter.addStepLog("<a target=\"_blank\", href="+ returnScreenshotName() + "><img src="+ returnScreenshotName()+ " height=200 width=300></img></a>");
    }

    public static String returnScreenshotName() {
        return (System.getProperty("user.dir") + "\\output\\imgs\\" + screenshotName).toString();
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }

        } finally {
            is.close();
            os.close();
        }
    }

    public static void copyLatestExtentReport() throws IOException {
        Date d = new Date();
        String date = d.toString().replace(":", "_").replace(" ", "_");
        File source = new File(System.getProperty("user.dir") + "\\output\\report.html");
        File dest = new File(System.getProperty("user.dir") + "\\output\\" + date.toString() + ".html");
        copyFileUsingStream(source, dest);
    }
}







