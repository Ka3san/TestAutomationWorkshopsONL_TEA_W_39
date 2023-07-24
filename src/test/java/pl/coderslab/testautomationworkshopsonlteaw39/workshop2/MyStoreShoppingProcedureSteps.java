package pl.coderslab.testautomationworkshopsonlteaw39.workshop2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.testautomationworkshopsonlteaw39.UserData;
import pl.coderslab.testautomationworkshopsonlteaw39.pages.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyStoreShoppingProcedureSteps {
    private WebDriver driver;
    private UserData userData;
    private MainPage mainPage;
    private LogInPage logInPage;
    private YourAccountPage yourAccountPage;
    private ClothesPage clothesPage;
    private SweaterProductPage sweaterProductPage;
    private CheckOutPage checkOutPage;


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
        sweaterProductPage = new SweaterProductPage(driver);
        checkOutPage = new CheckOutPage(driver);

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

    @And("Choose {string} size")
    public void selectSizeM(String size) {
        sweaterProductPage.clickAndSelectSize(size);
    }

    @And("Choose {string} pcs")
    public void selectQuantity(String quantity) {
        sweaterProductPage.SelectQuantity(quantity);
    }

    @And("Click ADD TO CART button")
    public void clickAddCart() {
        sweaterProductPage.clickAddToCart();
    }

    @And("Proceed to checkout")
    public void clickProceedToCheckoutTwice() {
        sweaterProductPage.proceedToCheckout();
    }

    @And("Address confirmed")
    public void confirmAddress() {
//        WebElement addressField = driver.findElement(By.xpath("//*[@id=\"id-address-delivery-address-4037\"]/header"));
//        assertTrue(addressField.isDisplayed());
//        WebElement addressCheckBox = driver.findElement(By.xpath("//*[@id=\"id-address-delivery-address-4037\"]/header/label/span[1]/span"));
//        assertTrue(addressCheckBox.isSelected());
        checkOutPage.clickContinueButton();
    }

//    @And("Self pick up shipping method chosen")
//    public void choosePickUpShippingMethod() {
//        checkOutPage.selfPickUp();
//    }

//    And Pay by Check payment chosen
//    And Click Terms Of Service agreement checkbox
//    And Click PLACE ORDER button
//    Then Takes a screenshot to confirm order and total payment amount
}

