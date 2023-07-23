package pl.coderslab.testautomationworkshopsonlteaw39.workshop1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAddressesPage {
    @FindBy(css = "div.addresses-footer span")
    private WebElement createNewAddressButton;


    public YourAddressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickCreateNewAddress() {
        createNewAddressButton.click();
    }
}
