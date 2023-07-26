package pl.coderslab.testautomationworkshopsonlteaw39.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
    @FindBy(css = "span.hidden-sm-down")
    private WebElement loggedUserClick;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section[2]/div/div/div[1]/div[2]/table/tbody/tr[4]/td[2]")
    private WebElement totalField;

    public OrderConfirmationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickUserName() {
        loggedUserClick.click();
    }

    public String getTotalPrice() {
        totalField.getText();
        return totalField.getText();
    }
}
