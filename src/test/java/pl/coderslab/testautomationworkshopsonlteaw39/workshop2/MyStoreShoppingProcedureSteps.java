package pl.coderslab.testautomationworkshopsonlteaw39.workshop2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.testautomationworkshopsonlteaw39.UserData;
import pl.coderslab.testautomationworkshopsonlteaw39.pages.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    private OrderConfirmationPage orderConfirmationPage;
    private OrderHistoryPage orderHistoryPage;


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
        orderConfirmationPage = new OrderConfirmationPage(driver);
        orderHistoryPage = new OrderHistoryPage(driver);

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

    @And("Check for a 20% discount")
    public void checkDiscount() {
        WebElement regularPrice = driver.findElement(By.cssSelector("span.regular-price"));
        String price = regularPrice.getText();
        String noEuroSymbolPrice = price.replaceAll("[€,]", "");
        WebElement discountPrice = driver.findElement(By.cssSelector("span.current-price-value"));
        String newPrice = discountPrice.getText();
        String noEuroSymbolNewPrice = newPrice.replaceAll("[€,]", "");
        double price1 = Double.parseDouble(noEuroSymbolPrice);
        double price2 = Double.parseDouble(noEuroSymbolNewPrice);
        double discount = (price1 - price2) / price1 * 100;
        assertEquals(20, discount);
    }

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
        WebElement addressField = driver.findElement(By.cssSelector("label.radio-block"));
        assertTrue(addressField.isDisplayed());
        WebElement addressCheckBox = driver.findElement(By.name("id_address_delivery"));
        assertTrue(addressCheckBox.isSelected());
        checkOutPage.clickContinueButton();
    }

    @And("Self pick up shipping method chosen")
    public void choosePickUpShippingMethod() {
        checkOutPage.selfPickUp();
    }

    @And("Pay by Check payment chosen")
    public void choosePaymentMethod() {
        checkOutPage.paymentMethod();
    }

    @And("Click Terms Of Service agreement checkbox")
    public void agreeTermsOfService() {
        checkOutPage.termsAgreement();
    }

    @And("Click PLACE ORDER button")
    public void placeOrder() {
        checkOutPage.clickPlaceOrder();
    }

    @Then("Takes a screenshot to confirm order and total payment amount")
    public void takeScreenShot() throws IOException {
        File tmpScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(), Paths.get("/", "users", "ka3", "prove_of_test", "shop-success-" + currentDateTime + ".png"));
    }

    @And("Go to the Orders history and details page")
    public void goToTheOrdersHistoryPage() {
        orderConfirmationPage.clickUserName();
        yourAccountPage.ordersHistoryClick();
    }

    @And("Check if an order is on the 'Awaiting check payment' list")
    public void orderStatusCheck() {
        String statusCheckText = orderHistoryPage.getOrderStatus();
        assertEquals("Awaiting check payment", statusCheckText);
    }

    @And("Compare Total price with order confirmation page")
    public void totalPriceCheck() {
        String orderConfirmationPageTotalPrice = orderConfirmationPage.getTotalPrice();
        String orderHistoryPageTotalPrice = orderHistoryPage.getTotalPrice();
        assertEquals(orderConfirmationPageTotalPrice, orderHistoryPageTotalPrice);
    }
}
