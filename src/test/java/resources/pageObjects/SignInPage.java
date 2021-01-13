package resources.pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static resources.utils.Constant.emailDomain;

public class SignInPage extends BasePage{

    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

    public @FindBy (xpath = "//*[@id=\"center_column\"]/h1")
    WebElement headerAuthemtication ;

    public @FindBy(xpath = "//input[@id='email_create']")
    WebElement emailAddress ;

    public @FindBy (xpath = "//*[@id=\"SubmitCreate\"]/span")
    WebElement btnCreateAccount;




    public void enterValidEmail() throws Throwable{
       moveToElement(btnCreateAccount);
       sendKeysToWebElement(emailAddress,generateRandomUUID()+ emailDomain);
    }

    public void clickCreateAccountButton() {
        //moveToElement(btnCreateAccount);
        waitAndClickElement(btnCreateAccount);
    }
}
