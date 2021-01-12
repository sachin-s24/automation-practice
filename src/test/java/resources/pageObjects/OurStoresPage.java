package resources.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class OurStoresPage extends BasePage{

    public OurStoresPage() {
        PageFactory.initElements(driver, this);
    }

    public @FindBy(xpath = "//*[@id=\"map\"]/div[2]/table/tr/td[2]/button")
    WebElement btnOK ;

    public @FindBy(xpath = "//*[@id=\"map\"]/div/div/div[12]/div/div[2]/div/button[2]")
    WebElement btnZoomOut ;

    public @FindBy(xpath = "//*[@id='map']/div/div/div[1]/div[3]/div/div[3]/div[2]")
    WebElement btnMap ;

    public @FindBy(xpath = "//*[@id=\"center_column\"]/div[2]/div[3]/button")
    WebElement btnSearch ;



    public void  dragAndZoomOut() throws Throwable{
        waitAndClickElement(btnOK);
        clickAndDrag(btnMap,btnSearch);
        waitAndClickElement(btnZoomOut);

    }


    public void verifyScreenshotCaptured() {
        verifyFileExists(System.getProperty("user.dir") + "\\output\\imgs\\" + screenshotName);
    }


}
