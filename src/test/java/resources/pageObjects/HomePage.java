package resources.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[2]/div[2]/a[1]/span[1]")
    WebElement btnAddToCart;

    public void addItemToCart()throws Throwable{
        actionMoveAndClick(btnAddToCart);
    }
}
