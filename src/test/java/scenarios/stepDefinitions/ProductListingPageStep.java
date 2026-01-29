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

public class ProductListingPageStep {

    HomePage homePage;
    AccountPage accountPage;
    LoginPage loginPage;
    CheckoutPage checkoutPage;
    HeaderPage headerPage;
    CredsLoader credsLoader;
    ConfigLoader configLoader;
    WishlistPage wishlistPage;
    ProductListingPage productListingPage;
    Scenario scenario;

    public ProductListingPageStep(TestContext context) {

        homePage = new HomePage(context.driver);
        accountPage = new AccountPage(context.driver);
        loginPage = new LoginPage(context.driver);
        checkoutPage = new CheckoutPage(context.driver);
        headerPage = new HeaderPage(context.driver);
        wishlistPage = new WishlistPage(context.driver);
        productListingPage = new ProductListingPage(context.driver);
        this.credsLoader = context.credsLoader;
        this.configLoader = context.configLoader;
        this.scenario = context.scenario;
    }

    @Then("User validates product shade popup text")
    public void user_validates_product_shade_popup_text() {

        productListingPage.validateShade();
        String actualText = productListingPage.getProductShadePopupText();
        System.out.println("Shade Popup text: " + actualText);

        String shadeProductKeyword = configLoader.getProperty("selectShadeProduct");
        Assert.assertEquals(actualText, shadeProductKeyword);
    }

    @Then("user selects product shade variant in popup")
    public void user_selects_product_shade_variant_in_popup() {

        productListingPage.selectShadeVariant();
    }

    @Then("user verify product shade variant name in cart page")
    public void user_verify_product_shade_variant_name_in_cart_page() {

        String actualProductName = productListingPage.cartProductName();
        System.out.println(" Product name: " + actualProductName);

        String shadeProductKeyword = configLoader.getProperty("shadeProductcartName");
        Assert.assertEquals(actualProductName, shadeProductKeyword);
    }


}
