package pl.coderslab.testautomationworkshopsonlteaw39.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {
    @FindBy(css = "span.label.label-pill.bright")
    private WebElement orderStatusField;
    @FindBy(css = "td.text-xs-right")
    private WebElement totalPriceField;

    public OrderHistoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getOrderStatus() {
        orderStatusField.getText();
        return orderStatusField.getText();
    }

    public String getTotalPrice() {
        totalPriceField.getText();
        return totalPriceField.getText();
    }
}
