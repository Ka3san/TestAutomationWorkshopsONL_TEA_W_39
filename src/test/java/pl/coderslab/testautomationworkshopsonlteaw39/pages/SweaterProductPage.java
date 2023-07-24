package pl.coderslab.testautomationworkshopsonlteaw39.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SweaterProductPage {
    @FindBy(id = "group_1")
    private WebElement sizeSelectBox;
    @FindBy(id = "quantity_wanted")
    private WebElement quantitySelectBox;

    public SweaterProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickAndSelectSize(String size) {
        sizeSelectBox.click();
        sizeSelectBox.sendKeys(size);
        sizeSelectBox.sendKeys(Keys.TAB);
    }

    public void clickAndSelectQuantity() {
        quantitySelectBox.sendKeys("5");
    }
}
