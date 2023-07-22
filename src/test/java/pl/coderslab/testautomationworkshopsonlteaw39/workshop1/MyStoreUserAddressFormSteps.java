package pl.coderslab.testautomationworkshopsonlteaw39.workshop1;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MyStoreUserAddressFormSteps {
    private WebDriver driver;
//    private MainPage mainPage;

    @Given("^([^ ]+) opened in Google Chrome browser$")
    public void openInBrowser(String url) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
//        mainPage = new MainPage(driver);

        driver.get(url);

    }


//    @When("Sign In button clicked")
//
//
//    @And("Email and Password filled")
//
//
//    @And("SIGN IN button clicked")
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
