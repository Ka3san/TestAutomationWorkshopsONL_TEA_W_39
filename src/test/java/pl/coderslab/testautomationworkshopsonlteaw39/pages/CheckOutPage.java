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
    @FindBy(css = ".continue:nth-child(2)")
    private WebElement shippingContinueButton;
    @FindBy(id = "payment-option-1")
    private WebElement payByCheckCheckBox;
    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement termsOfServiceAgreementCheckbox;
    @FindBy(css = "button.btn.btn-primary.center-block")
    private WebElement placeOrderButton;


    public CheckOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickContinueButton() {
        addressContinueButton.click();
    }

    public void selfPickUp() {
//        deliveryOptionCheckBox.click();
        shippingContinueButton.click();
    }

    public void paymentMethod() {
        payByCheckCheckBox.click();
    }

    public void termsAgreement() {
        termsOfServiceAgreementCheckbox.click();
    }

    public void clickPlaceOrder() {
        placeOrderButton.click();
    }
}

