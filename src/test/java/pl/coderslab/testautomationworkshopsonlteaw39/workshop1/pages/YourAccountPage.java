package pl.coderslab.testautomationworkshopsonlteaw39.workshop1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccountPage {
    @FindBy(xpath = "//*[@id=\"footer_account_list\"]/li[4]/a")
    private WebElement addressesLink;

    public YourAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickAddresses() {
        addressesLink.click();
    }
}
