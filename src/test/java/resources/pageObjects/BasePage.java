package resources.pageObjects;

import com.vimalselvam.cucumber.listener.Reporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class BasePage {

    public static WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jsExecutor;
    public static String screenshotName;


    public  WebDriver initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }


    /**********************************************************************************
     **CLICK METHODS
     **********************************************************************************/
    public void waitAndClickElement(WebElement element) {
        this.wait = new WebDriverWait(driver, 10);
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

    public void waitUntilElementDisappeared(WebElement element) {
        this.wait = new WebDriverWait(driver, 60);
        try {
            this.wait.until(ExpectedConditions.invisibilityOf(element));
            System.out.println("Element disappeared: " + "<" + element.toString() + ">");

        } catch (Exception e) {
            System.out.println("Element did not disappear, Exception: " + e.getMessage());
            Assert.fail("Element did not disappear, using locator: " + "<" + element.toString() + ">");
        }
    }


    public void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        try {
            actions.moveToElement(element).build().perform();
        } catch (Exception e) {
            System.out.println("Unable to move to the WebElement, using locator: " + "<" + element.toString() + ">");
            Assert.fail("Unable to move to the WebElement, Exception: " + e.getMessage());
        }
    }

    public void verifyElementIsDisplayed(WebElement element) {
        this.wait = new WebDriverWait(driver, 10);
        try {
            this.wait.until(ExpectedConditions.visibilityOf(element));
            if (!element.isDisplayed()) {
                System.out.println("Element is not displayed.");
            }
            Assert.assertTrue(element.isDisplayed());
        } catch (Exception e) {
            System.out.println("Unable to locate WebElement, using locator: " + "<" + element.toString() + ">");
            Assert.fail("Unable to locate the WebElement, Exception: " + e.getMessage());
        }

    }


    public void verifyElementIsNotDisplayed(WebElement element) {
        try {
            if (element.isDisplayed()) {
                System.out.println("Element should not have been displayed but it was!");
            }
            Assert.assertFalse(element.isDisplayed());
        } catch (Exception e) {
        }

    }

    public void clickAndDrag(WebElement startPoint, WebElement endPoint) {
        this.wait = new WebDriverWait(driver, 10);
        try {
            this.wait.until(ExpectedConditions.visibilityOf(startPoint));
            Actions actions = new Actions(driver);
            actions.moveToElement(startPoint).
                    clickAndHold().dragAndDrop(startPoint, endPoint).build().perform();
        }
        catch (Exception e)
        {
            System.out.println("Unable to Drag to the WebElement, using locator: " + "<" + endPoint.toString() + ">");
            Assert.fail("Unable to drag to the WebElement, Exception: " + e.getMessage());

        }
    }


    public void clickOnTextFromDropdownList(WebElement list, String textToSearchFor) throws Exception {
        Wait<WebDriver> tempWait = new WebDriverWait(driver, 30);
        try {
            //tempWait.until(ExpectedConditions.elementToBeClickable(list)).click();
            list.sendKeys(textToSearchFor);
            list.sendKeys(Keys.ENTER);
            System.out.println("Successfully sent the following keys: " + textToSearchFor + ", to the following WebElement: " + "<" + list.toString() + ">");
        } catch (Exception e) {
            System.out.println("Unable to send the following keys: " + textToSearchFor + ", to the following WebElement: " + "<" + list.toString() + ">");
            Assert.fail("Unable to select the required text from the dropdown menu, Exception: " + e.getMessage());
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


    public void sendLeftArrowKey() {
        Actions actions = new Actions(driver);
        try {
            actions.sendKeys(Keys.chord(Keys.ARROW_LEFT)).build().perform();
        }
        catch (Exception e) {
            Assert.fail("Unable to send Left Arrow key, Exception: " + e.getMessage());
        }
    }

    /**********************************************************************************
     **WAIT METHODS
     **********************************************************************************/
    public boolean WaitUntilWebElementIsVisible(WebElement element) {
        this.wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
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

    public void loadUrl(String url) throws Exception {
        try {
            driver.get(url);
        } catch (Exception e) {
            System.out.println("Unable to click the current URL, Exception: " + e.getMessage());
        }
    }



    public void verifyFileExists(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exist.");
        }
        Assert.assertTrue(file.exists() && !file.isDirectory());
    }

    public void verifyExpectedPriceRangeOfItemsOnPage(By element,  int minimumPrice , int maximumPrice) {

        List<WebElement> elements = driver.findElements(element);

        for (int i = 0; i < elements.size(); i++) {
            String stringPrice = elements.get(i).getText().substring(1, 3);
            int integerPrice = Integer.parseInt(stringPrice);
            if (integerPrice <= maximumPrice) {
                if (integerPrice >= minimumPrice) {
                    Assert.assertTrue("Item price '" + stringPrice + "'is within the specified range of '" + minimumPrice + "' and '" + maximumPrice + "'", true);
                }
            } else {
                System.out.println("Item Prices were not updated correctly.");
                Assert.fail();
            }
        }
    }


    public String generateRandomUUID() {
        return UUID.randomUUID().toString();
    }

    public String generateRandomPassword() {
        return generateRandomUUID().substring(0, 31);
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
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        screenshotName = returnDateStamp(".jpg");
        FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "\\output\\imgs\\" + screenshotName));

    }

}







