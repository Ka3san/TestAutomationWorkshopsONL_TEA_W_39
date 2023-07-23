package pl.coderslab.testautomationworkshopsonlteaw39.workshop1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.testautomationworkshopsonlteaw39.workshop1.pages.*;

import java.time.Duration;

public class MyStoreUserAddressFormSteps {
    private WebDriver driver;
    private UserData userData;
    private MainPage mainPage;
    private LogInPage logInPage;
    private YourAccountPage yourAccountPage;
    private YourAddressesPage yourAddressesPage;
    private NewAddressPage newAddressPage;


    @Given("^([^ ]+) opened in Google Chrome browser$")
    public void openInBrowser(String url) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        userData = new UserData(driver);
        mainPage = new MainPage(driver);
        logInPage = new LogInPage(driver);
        yourAccountPage = new YourAccountPage(driver);
        yourAddressesPage = new YourAddressesPage(driver);
        newAddressPage = new NewAddressPage(driver);

        driver.get(url);
    }

    @When("Sign In button clicked")
    public void clickSignInButton() {
        mainPage.clickSignInButton();
    }

    @And("{string} and {string} filled")
    public void fillEmailAndPassword(String email, String password) {
        logInPage.fillEmailAndPassword(userData.setEmail(email).setPassword(password));
    }

    @And("SIGN IN button clicked")
    public void clickSignIn() {
        logInPage.clickSignIn();
    }

    @And("Addresses link from bottom 'YOUR ACCOUNT' block clicked")
    public void clickAddressesLink() {
        yourAccountPage.clickAddresses();
    }

    @And("+ Create new address button clicked")
    public void clickCreateNewAddress() {
        yourAddressesPage.clickCreateNewAddress();
    }

    @And("New address form filled with {string}, {string}, {string}, {string}, {string}, {string}")
    public void fillAddressForm(String alias, String address, String city, String postcode, String country, String phone) {
        newAddressPage.addressFormFill(userData.setAlias(alias).setAddress(address).setCity(city).setPostcode(postcode).setCountry(country).setPhone(phone));
    }

    @And("Save button clicked")
    public void clickSaveButton() {
        newAddressPage.clickSaveButton();
    }

//
//
//    @Then("Check if the filled data is correct")
//

}
