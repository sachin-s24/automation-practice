package resources.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage{

    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    public @FindBy (xpath = "//*[@id=\"account-creation_form\"]/div[1]/h3")
    WebElement headerPersonalInfo;

    public @FindBy (id = "customer_firstname")
    WebElement inputFirstName ;

    public @FindBy (id = "customer_lastname")
    WebElement inputLastName ;

    public @FindBy (id = "email")
    WebElement inputEmail ;

    public @FindBy (id = "passwd")
    WebElement inputPassword ;

    public @FindBy (id = "firstname")
    WebElement addFirstName ;

    public @FindBy (id = "lastname")
    WebElement addLastName ;

    public @FindBy (id = "address1")
    WebElement addAddress ;

    public @FindBy (id = "city")
    WebElement addCity ;

    public @FindBy (id = "id_state")
    WebElement addState ;

    public @FindBy (id = "postcode")
    WebElement addPostCode ;

    public @FindBy (id = "id_country")
    WebElement addCountry ;

    public @FindBy (id = "phone_mobile")
    WebElement addMobile ;

    public @FindBy (id = "alias")
    WebElement addAlias ;

    public @FindBy (id = "submitAccount")
    WebElement btnRegister ;

    public @FindBy (xpath = "//*[@id=\"account-creation_form\"]/div[1]/div[2]")
    WebElement inputFieldError ;

    public @FindBy (xpath = "//*[@id=\"center_column\"]/div")
    WebElement msgBannerError ;


    public static String firstName = "John";
    public static String lastName = "Doe";

    private final String address = "Street Name";
    private final String city = "City Name";
    private final String state = "Alabama";
    private final String postalCode = "12345";
    private final String country = "United States";
    private final String mobileNumber = "0123456789";

    public void validateOnRegistrationPage() {
        WaitUntilWebElementIsVisible(headerPersonalInfo);
        verifyElementIsDisplayed(headerPersonalInfo);
    }

   public void inputFirstName() throws Throwable{
       sendKeysToWebElement(inputFirstName , firstName);
    }

    public void inputLastName() throws Throwable{
        sendKeysToWebElement(inputLastName , lastName);
    }

    public void inputPassword() throws Throwable{
        moveToElement(inputPassword);
        sendKeysToWebElement(inputPassword , generateRandomPassword());
    }

    public void inputAddress() throws Throwable{
        moveToElement(addAddress);
        sendKeysToWebElement(addAddress ,address);
    }

    public void inputCity() throws Throwable{
        moveToElement(addCity);
        sendKeysToWebElement(addCity ,city);
    }

    public void selectState() throws Throwable{
        moveToElement(addState);
        clickOnTextFromDropdownList(addState, state);
    }

    public void inputPostalCode() throws Throwable{
        moveToElement(addPostCode);
        sendKeysToWebElement(addPostCode,postalCode);
    }

    public void selectCountry() throws Throwable{
        moveToElement(addCountry);
        clickOnTextFromDropdownList(addCountry, country);
    }

    public void inputMobileNumber() throws Throwable{
        moveToElement(addMobile);
        sendKeysToWebElement(addMobile,mobileNumber);
    }


    public void inputInvalidFirstName() throws Throwable {
        moveToElement(inputFirstName);
        sendKeysToWebElement(inputFirstName , generateRandomUUID());

    }

    public void validateInputFieldErrorDisplayed() {
        verifyElementIsDisplayed(inputFieldError);
    }

    public void validateErrorMessageBannerDisplayed() {
       verifyElementIsDisplayed(msgBannerError);
    }




}
