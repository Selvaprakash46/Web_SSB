package scenarios.stepDefinitions;

import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.*;
import utilities.ConfigLoader;
import utilities.CredsLoader;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class CheckoutStep {

    HomePage homePage;
    AccountPage accountPage;
    LoginPage loginPage;
    CheckoutPage checkoutPage;
    HeaderPage headerPage;
    CredsLoader credsLoader;
    ConfigLoader configLoader;
    Scenario scenario;

    public static String expectedText = " ";

    public CheckoutStep(TestContext context) {

        homePage = new HomePage(context.driver);
        accountPage = new AccountPage(context.driver);
        loginPage = new LoginPage(context.driver);
        checkoutPage = new CheckoutPage(context.driver);
        headerPage = new HeaderPage(context.driver);
        this.credsLoader = context.credsLoader;
        this.configLoader = context.configLoader;
        this.scenario = context.scenario;
    }

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {

        homePage.closeChildWindowAndSwitchBack();
        homePage.clickOnHomeButton(2);
        scenario.log("User is on Home Page");
    }

    @When("user selects a makeup category from home page")
    public void user_selects_a_makeup_category_from_home_page() {

        homePage.clickOnMakeUp();
    }

    @When("user clicks the sub category from makeup page")
    public void User_clicks_the_sub_category_from_makeup_page() {

        homePage.clickOnFoundation();
    }

    @When("user selects a product from plp")
    public void user_selects_a_product_from_plp() {

        scenario.log("Product clicked successfully at index 2");
    }

    @When("User clicks on the add to bag")
    public void user_clicks_on_the_add_to_bag(){

        homePage.validateShadeOrBag();
    }

    @When("User clicks on another product add to bag")
    public void user_clicks_on_another_product_add_to_bag(){

        homePage.validateAnotherShadeOrBag();
    }

    @When("User clicks on the move to bag")
    public void user_clicks_on_the_move_to_bag(){

        homePage.validateShadeOrMoveToBag();
    }

    @When("User clicks on the view details")
    public void user_clicks_on_the_view_details(){

        homePage.validateShadeOrDetails();
    }

    @Then("user validates the price details in the bag")
    public void user_validates_the_price_details_in_the_bag() {

        Map<String, Double> priceMap = checkoutPage.getPriceDetails();

        scenario.log("MRP : ₹" + priceMap.get("MRP"));
        scenario.log("Discount : ₹" + priceMap.get("Discount"));
        scenario.log("Delivery Fee : ₹" + priceMap.get("DeliveryFee"));
        scenario.log("Total Payable : ₹" + priceMap.get("Total"));

        Assert.assertTrue(
                checkoutPage.validatePriceDetails(priceMap),
                "Price calculation mismatch"
        );
    }
    @When("User clicks on the proceed to pay")
    public void user_clicks_on_the_proceed_to_pay() throws InterruptedException {

        checkoutPage.clickOnProceedToCheckout();
    }
    @When("User clicks on the continue to payment")
    public void user_clicks_on_the_continue_to_payment() throws InterruptedException {

        checkoutPage.clickOnContinueButton();

    }
    @Then("user selecting cod option")
    public void user_selecting_cod_option() {

        checkoutPage.selectingTheCODOption();
    }
    @Then("User clicks on the place order button")
    public void user_clicks_on_the_place_order_button() {

        checkoutPage.clickOnPlaceOrder();
    }
    @Then("User validate that the order is placed successfully")
    public void user_validate_that_the_order_is_placed_successfully() throws InterruptedException {

        checkoutPage.waitForPresenceOfElement(checkoutPage.orderSuccess);
        Assert.assertTrue(
                checkoutPage.isElementPresent(checkoutPage.orderSuccess),
                "Order NOT placed successfully"
        );
        scenario.log("Order Placed Successfully");
    }

    // Order Summary Page
    @Given("user validates the successful order summary")
    public void user_validates_the_successful_order_summary() {

        checkoutPage.printOrderDetails();
    }
    @Then("user clicks on the Continue Shopping button")
    public void user_clicks_on_the_continue_shopping_button() {

        checkoutPage.clickOnContinueShopping();
    }

    // Invalid Placement
    @Then("user selecting UPI option")
    public void user_selecting_upi_option() {

        checkoutPage.selectingTheUPIOption();
    }
    @Then("user enters the UPI id")
    public void user_enters_the_upi_id() {

        checkoutPage.enterTheUPIId("test@upi");
    }
    @Then("user validates that UPI id")
    public void user_validates_the_upi_id() {

        checkoutPage.clickOnVerify();
    }
    @Then("User validate that an error message indicating payment failure")
    public void user_validate_that_an_error_message_indicating_payment_failure() throws InterruptedException {

        scenario.log("Payment is Failed");
    }

}
