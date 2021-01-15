package resources.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }


    public @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]/img[1]")
    WebElement firstProductImage;

    public @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[2]/div[2]/a[1]")
    WebElement btnAddToCart;

    public @FindBy(xpath = "//span[@title='Continue shopping']//span[1]")
    WebElement btnContinue;

    public @FindBy(xpath = "//a[@title='View my shopping cart']")
    WebElement btnCartWindow;

    public @FindBy(xpath = "//a[@title='View my shopping cart']")
    WebElement dropdownViewShoppingCart ;

    public @FindBy(xpath = "//div[@class='product-name']")
    WebElement cartItemName;

    public @FindBy (xpath = "//a[@class='sf-with-ul'][normalize-space()='Women']")
    WebElement btnWomen ;

    public @FindBy (xpath = "//li[@class='sfHover']//a[@title='Summer Dresses'][normalize-space()='Summer Dresses']")
    WebElement linkSummerDresses;


    public void addItemToCart() throws Throwable {
        moveToElement(firstProductImage);
        waitAndClickElement(btnAddToCart);
        waitAndClickElement(btnContinue);
    }

    public void navigateToCartPage() throws Throwable {
        waitAndClickElement(btnCartWindow);
    }

    public void validateItemInCartDropdown() throws Throwable{
        moveToElement(dropdownViewShoppingCart);
        verifyElementIsDisplayed(cartItemName);
    }

    public void hoverOverWomenButton() {
        moveToElement(btnWomen);
    }

    public void validateSummerDressesOption() {
        verifyElementIsDisplayed(linkSummerDresses);
    }


}
