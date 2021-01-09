package resources.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;

public class CartPage extends BasePage{

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    public @FindBy (id = "product_1_1_0_0")
    WebElement cartItem ;

    public @FindBy (xpath= "//i[@class='icon-trash']")
    WebElement btnDeleteCart;

    public @FindBy(xpath = "//p[@class='alert alert-warning']")
    WebElement alertWarning;

    public @FindBy(xpath = "//span[@class='ajax_cart_no_product']")
    WebElement emptyCart ;

    public void validateItemInCart() throws Throwable{
        moveToElement(cartItem);
        verifyElementIsDisplayed(cartItem);
    }

    public void validateCartDeleteBtn() throws Throwable{
        verifyElementIsDisplayed(btnDeleteCart);
    }

    public void validateNoItemInCart() throws Throwable {
        verifyElementIsDisplayed(emptyCart);
        verifyElementIsNotDisplayed(cartItem);
    }

    public void validateBannerMessage(String expectedMsg){
        verifyElementIsDisplayed(alertWarning);
        Assert.assertEquals(expectedMsg,alertWarning.getText());
    }

}
