package pl.coderslab.testautomationworkshopsonlteaw39.workshop1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(css = "#_desktop_user_info > div > a")
    private WebElement signInButton;


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickSignInButton() {
        signInButton.click();
    }
}
