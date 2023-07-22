package pl.coderslab.testautomationworkshopsonlteaw39.workshop1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.testautomationworkshopsonlteaw39.workshop1.pages.LogInPage;
import pl.coderslab.testautomationworkshopsonlteaw39.workshop1.pages.MainPage;

import java.time.Duration;

public class MyStoreUserAddressFormSteps {
    private WebDriver driver;
    private MainPage mainPage;
    private LogInPage logInPage;

    @Given("^([^ ]+) opened in Google Chrome browser$")
    public void openInBrowser(String url) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        logInPage = new LogInPage(driver);

        driver.get(url);
    }

    @When("Sign In button clicked")
    public void clickSignInButton() {
        mainPage.clickSignInButton();
    }

    @And("Email and Password filled")
    public void fillEmailAndPassword() {
        logInPage.fillEmailAndPassword();
    }

    @And("SIGN IN button clicked")
    public void clickSignIn() {
        logInPage.clickSignIn();
    }
//
//
//    @And("Addresses link from bottom 'YOUR ACCOUNT' block clicked")
//
//
//    @And("+ Create new address button clicked")
//
//
//    @And("New address form filled with alias, address, city, zip/postal code, country, phone")
//
//
//    @Then("Check if the filled data is correct")
//

}
