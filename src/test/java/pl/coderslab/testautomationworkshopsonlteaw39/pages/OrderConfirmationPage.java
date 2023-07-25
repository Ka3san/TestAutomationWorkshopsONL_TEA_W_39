package pl.coderslab.testautomationworkshopsonlteaw39.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
    @FindBy(css = "span.hidden-sm-down")
    private WebElement loggedUserClick;

    public OrderConfirmationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickUserName() {
        loggedUserClick.click();
    }
}
