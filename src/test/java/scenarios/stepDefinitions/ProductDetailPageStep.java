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

public class ProductDetailPageStep {

    HomePage homePage;
    AccountPage accountPage;
    LoginPage loginPage;
    CheckoutPage checkoutPage;
    HeaderPage headerPage;
    CredsLoader credsLoader;
    ConfigLoader configLoader;
    WishlistPage wishlistPage;
    GuestUserPage guestUserPage;
    ProductListingPage productListingPage;
    ProductDetailPage productDetailPage;
    Scenario scenario;

    public ProductDetailPageStep(TestContext context) {

        homePage = new HomePage(context.driver);
        accountPage = new AccountPage(context.driver);
        loginPage = new LoginPage(context.driver);
        checkoutPage = new CheckoutPage(context.driver);
        headerPage = new HeaderPage(context.driver);
        guestUserPage = new GuestUserPage(context.driver);
        wishlistPage = new WishlistPage(context.driver);
        productListingPage = new ProductListingPage(context.driver);
        productDetailPage = new ProductDetailPage(context.driver);
        this.credsLoader = context.credsLoader;
        this.configLoader = context.configLoader;
        this.scenario = context.scenario;
    }

    private String productNamePDP;
    private String firstProductNameCart;

    @When("system should display the following components on the share options page")
    public void system_should_display_the_following_components_on_the_share_options_page(DataTable dataTable) throws InterruptedException {

        List<String> expectedSections = dataTable.asList();
        boolean result = productDetailPage.validateShareOptionsComponentsByText(expectedSections);
        Assert.assertTrue(result, "Some expected components are missing on the PDP page!");
    }

    @When("User clicks on the view similar products icon in PDP")
    public void user_clicks_on_the_view_similar_products_icon_in_PDP(){

        productDetailPage.clickOnViewSimilarProductsIconPDP();
    }

    @When("User validates similar products")
    public void user_validates_similar_products(){

        productDetailPage.validateSimilarProductsAreChambor();
    }

    @When("User clicks on the add to bag from similar product in PDP")
    public void user_clicks_on_the_add_to_bag_from_similar_product_in_PDP(){

        productDetailPage.clickOnAddToCartSimilarProductPDP();
    }

    @When("User clicks on the add to favourite from similar product in PDP")
    public void user_clicks_on_the_add_to_favourite_from_similar_product_in_PDP(){

        productDetailPage.clickOnAddToFavouriteSimilarProductPDP();
    }

    @When("User clicks on the add to favourite from customers also bought in PDP")
    public void user_clicks_on_the_add_to_favourite_from_customers_also_bought_in_PDP(){

        productDetailPage.clickOnAddToFavouriteCustomersAlsoBoughtPDP();
    }

    @When("Move to similar product from PDP and click on add to bag")
    public void move_to_similar_product_from_PDP_and_click_on_add_to_bag(){

        productDetailPage.moveToSimilarProductPDP();
    }

    @When("Move to customers also bought from PDP and click on add to bag")
    public void move_to_customers_also_bought_from_PDP_and_click_on_add_to_bag(){

        productDetailPage.moveToCustomersAlsoBoughtPDP();
    }

    @When("Scroll to similar products product")
    public void scroll_to_similar_products_product(){

        productDetailPage.scrollSimilarProductsProductPDP();
    }

    @When("Scroll to customers also bought product")
    public void scroll_to_customers_also_bought_product(){

        productDetailPage.scrollCustomersAlsoBoughtProductPDP();
    }

    @When("Scroll and click on write a review")
    public void scroll_and_click_on_write_a_review(){

        productDetailPage.scrollToWriteAReviewPDP();
    }

    @When("system should display the following components on write a review popup")
    public void system_should_display_the_following_components_on_write_a_review_popup(DataTable dataTable) throws InterruptedException {

        List<String> expectedSections = dataTable.asList();
        boolean result = productDetailPage.validateWriteAReviewComponentsByText(expectedSections);
        Assert.assertTrue(result, "Some expected components are missing on the PDP page!");
    }

    @When("Select ratings star from write a review popup")
    public void select_ratings_star_from_write_a_review_popup(){

        productDetailPage.clickOnRatingsStar();
    }

    @Then("User enters review title in review title textbox")
    public void User_enters_review_title_in_review_title_textbox() {

        String keyword = configLoader.getProperty("reviewTitle");
        productDetailPage.enterReviewTitle(keyword);
        scenario.log("user Entered the keyword: " + keyword);
    }

    @Then("User enters review description in review title textbox")
    public void User_enters_review_description_in_review_title_textbox() {

        String keyword = configLoader.getProperty("reviewDescription");
        productDetailPage.enterReviewDescription(keyword);
        scenario.log("user Entered the keyword: " + keyword);
    }

    @When("Click on add review button from write a review popup")
    public void click_on_add_review_button_from_write_a_review_popup(){

        productDetailPage.clickOnAddReviewBtn();
    }

    @When("Validate review submitted message in submitted popup")
    public void validate_review_submitted_message_in_submitted_popup(){

        productDetailPage.validateReviewSubmittedPopup();
    }

    @Then("Get Product name from PDP")
    public void Get_Product_name_from_PDP() {

        productNamePDP = productDetailPage.getProductNamePDP();
        scenario.log("Product name from PDP: " + productNamePDP);
    }

    @Then("Get First Product name in the cart page")
    public void Get_First_Product_name_in_the_cart_page() {

        firstProductNameCart = productDetailPage.getFirstCartProductName();
        scenario.log("First product name in the cart: " + firstProductNameCart);
    }

    @Then("Validate PDP product name and added cart product name")
    public void Validate_PDP_product_name_and_added_cart_product_name() {

        Assert.assertEquals(productNamePDP,firstProductNameCart,"Both the product name do not match");

        scenario.log("Product is Added to bag and verified in Cart page");
    }


}
