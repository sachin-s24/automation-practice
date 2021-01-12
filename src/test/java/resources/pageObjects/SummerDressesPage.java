package resources.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummerDressesPage extends BasePage{

    public SummerDressesPage() {
        PageFactory.initElements(driver, this);
    }

    public @FindBy (xpath = "//div[@class='cat_desc']")
    WebElement imgSummerDress ;

    public @FindBy (xpath = "//*[@id=\"layered_price_slider\"]/a[2]")
    WebElement btnRightSliderHandle ;

    public @FindBy (id = "layered_price_range")
    WebElement priceRange ;

    public @FindBy(xpath = "//body/div[@id='page']/div[@class='columns-container']/div[@id='columns']/div[@class='row']/div[@id='center_column']/ul[@class='product_list grid row']/p[1]")
    WebElement imgLoading;

    public By prodPrices = By.xpath("//div[@class='right-block']/div[1]/span[1]");

    public void validateSummerItemDisplayed() {
        verifyElementIsDisplayed(imgSummerDress);
    }

    public void moveRightSliderToDesiredRange(String prcRange) {
        moveToElement(btnRightSliderHandle);
        btnRightSliderHandle.click();
        while (!priceRange.getText().equalsIgnoreCase(prcRange)) {
            sendLeftArrowKey();
        }
    }

    public void validatePriceRange(String prcRange) {
        Assert.assertTrue(priceRange.getText().equalsIgnoreCase(prcRange));
    }

    public void validateSearchResultUpdated(){
        verifyElementIsDisplayed(imgLoading);
        waitUntilElementDisappeared(imgLoading);
    }

    public void validateResultPricesInRange(String prcMin , String prcMax) {
        int priceMinimum = Integer.valueOf(prcMin);
        int priceMaximum = Integer.valueOf(prcMax);
        verifyExpectedPriceRangeOfItemsOnPage(prodPrices , priceMinimum , priceMaximum) ;
    }
}
