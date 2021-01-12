package resources.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static resources.pageObjects.RegistrationPage.firstName;
import static resources.pageObjects.RegistrationPage.lastName;

public class MyAccountPage extends BasePage {

    public MyAccountPage() {
        PageFactory.initElements(driver, this);
    }

    public @FindBy (xpath = "//*[@id=\"center_column\"]/p")
    WebElement welAccntText ;

    public @FindBy (xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")
    WebElement accountName ;

    public void validateOnMyAccountPage(){
        verifyElementIsDisplayed(welAccntText);
    }

    public void validateAccountName(){
        Assert.assertEquals( firstName + " " +lastName , accountName.getText());
    }

}
