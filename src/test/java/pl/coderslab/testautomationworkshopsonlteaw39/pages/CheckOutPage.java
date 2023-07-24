package pl.coderslab.testautomationworkshopsonlteaw39.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
    @FindBy(css = "#checkout-addresses-step > div > div > form > div.clearfix > button")
    private WebElement addressContinueButton;
    @FindBy(id = "delivery_option_8")
    private WebElement deliveryOptionCheckBox;
    @FindBy(css = "button.continue.btn.btn-primary.float-xs-right")
    private WebElement shippingContinueButton;

    public CheckOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickContinueButton() {
        addressContinueButton.submit();
    }

    public void selfPickUp() {
        deliveryOptionCheckBox.click();
        shippingContinueButton.click();
    }
}
