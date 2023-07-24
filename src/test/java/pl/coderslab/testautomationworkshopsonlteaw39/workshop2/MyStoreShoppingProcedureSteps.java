package pl.coderslab.testautomationworkshopsonlteaw39.workshop2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.testautomationworkshopsonlteaw39.UserData;
import pl.coderslab.testautomationworkshopsonlteaw39.pages.ClothesPage;
import pl.coderslab.testautomationworkshopsonlteaw39.pages.LogInPage;
import pl.coderslab.testautomationworkshopsonlteaw39.pages.MainPage;
import pl.coderslab.testautomationworkshopsonlteaw39.pages.YourAccountPage;

import java.time.Duration;

public class MyStoreShoppingProcedureSteps {
    private WebDriver driver;
    private UserData userData;
    private MainPage mainPage;
    private LogInPage logInPage;
    private YourAccountPage yourAccountPage;
    private ClothesPage clothesPage;


    @Given("^([^ ]+) is opened in Google Chrome browser$")
    public void openInBrowser(String url) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        userData = new UserData(driver);
        mainPage = new MainPage(driver);
        logInPage = new LogInPage(driver);
        yourAccountPage = new YourAccountPage(driver);
        clothesPage = new ClothesPage(driver);

        driver.get(url);
    }

    @When("Existing user logged in with given {string} and {string}")
    public void logInUser(String email, String password) {
        mainPage.clickSignInButton();
        logInPage.fillEmailAndPassword(userData.setEmail(email).setPassword(password));
        logInPage.clickSignIn();
    }

    @And("Click Clothes button in top menu")
    public void clickClothesButton() {
        yourAccountPage.clickClothes();
    }

    @And("Click Hummingbird Printed Sweater tile to purchase")
    public void clickSweaterTile() {
        clothesPage.clickSweater();
    }
////    And Check for a 20% discount
//    And Choose M size
//    And Choose 5 pcs
//    And Click ADD TO CART button
//    And Proceed to checkout
//    And Address confirmed
//    And Self pick up shipping method chosen
//    And Pay by Check payment chosen
//    And Click Terms Of Service agreement checkbox
//    And Click PLACE ORDER button
//    Then Takes a screenshot to confirm order and total payment amount
}

