package pl.coderslab.testautomationworkshopsonlteaw39.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAddressesPage {
    @FindBy(css = "div.addresses-footer span")
    private WebElement createNewAddressButton;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[2]/article/div[2]/a[2]/span")
    private WebElement deleteButton;


    public YourAddressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickCreateNewAddress() {
        createNewAddressButton.click();
    }

    public void clickDelete() {
        deleteButton.click();
    }
}
