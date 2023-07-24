package pl.coderslab.testautomationworkshopsonlteaw39.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.coderslab.testautomationworkshopsonlteaw39.UserData;

public class NewAddressPage {
    @FindBy(className = "form-control")
    private WebElement aliasInputBox;
    @FindBy(id = "field-address1")
    private WebElement addressInputBox;
    @FindBy(id = "field-city")
    private WebElement cityInputBox;
    @FindBy(id = "field-postcode")
    private WebElement postCodeInputBox;
    @FindBy(id = "field-id_country")
    private WebElement countryInputBox;
    @FindBy(id = "field-phone")
    private WebElement phoneInputBox;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
    private WebElement saveButton;

    public NewAddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addressFormFill(UserData userData) {
        aliasInputBox.sendKeys(userData.getAlias());
        addressInputBox.sendKeys(userData.getAddress());
        cityInputBox.sendKeys(userData.getCity());
        postCodeInputBox.sendKeys(userData.getPostcode());
        countryInputBox.sendKeys(userData.getCountry());
        phoneInputBox.sendKeys(userData.getPhone());
    }

    public void clickSaveButton() {
        saveButton.click();
    }
}
