package scenarios.stepDefinitions;

import context.TestContext;
import io.cucumber.datatable.DataTable;
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

public class WishlistStep {

    HomePage homePage;
    AccountPage accountPage;
    LoginPage loginPage;
    CheckoutPage checkoutPage;
    HeaderPage headerPage;
    CredsLoader credsLoader;
    ConfigLoader configLoader;
    WishlistPage wishlistPage;
    Scenario scenario;

    public WishlistStep(TestContext context) {

        homePage = new HomePage(context.driver);
        accountPage = new AccountPage(context.driver);
        loginPage = new LoginPage(context.driver);
        checkoutPage = new CheckoutPage(context.driver);
        headerPage = new HeaderPage(context.driver);
        wishlistPage = new WishlistPage(context.driver);
        this.credsLoader = context.credsLoader;
        this.configLoader = context.configLoader;
        this.scenario = context.scenario;
    }

    @When("system should display the following components on the wishlist page")
    public void system_should_display_the_following_components_on_the_wishlist_page(DataTable dataTable) throws InterruptedException {

        List<String> expectedSections = dataTable.asList();
        boolean result = wishlistPage.validateWishlistComponentsByText(expectedSections);
        Assert.assertTrue(result, "Some expected components are missing on the wishlist page!");

    }

    @When("User validates wishlist product count in wishlist page")
    public void user_validates_wishlist_product_count_in_wishlist_page() {

        int count = wishlistPage.validateWishlistedCount(1);
        scenario.log(count + " Products Wishlisted");
    }

    @When("user validates product remove x mark in wishlist page")
    public void user_validates_product_remove_x_mark_in_wishlist_page() {

        wishlistPage.validateProductToRemoveWishlist();
        scenario.log("Product remove x is present");
    }



}
