package pl.coderslab.testautomationworkshopsonlteaw39.workshop1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.coderslab.testautomationworkshopsonlteaw39.workshop1.UserData;

public class LogInPage {

    @FindBy(id = "field-email")
    private WebElement emailInputBox;
    @FindBy(id = "field-password")
    private WebElement passwordInputBox;
    @FindBy(id = "submit-login")
    private WebElement signInButton;

    public LogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillEmailAndPassword(UserData userData) {
        emailInputBox.sendKeys(userData.getEmail());
        passwordInputBox.sendKeys(userData.getPassword());
    }

    public void clickSignIn() {
        signInButton.click();
    }
}


