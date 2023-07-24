package pl.coderslab.testautomationworkshopsonlteaw39.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClothesPage {
    @FindBy(css = ".js-product:nth-child(2) img")
    private WebElement sweaterTile;

    public ClothesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickSweater() {
        sweaterTile.click();
    }
}
