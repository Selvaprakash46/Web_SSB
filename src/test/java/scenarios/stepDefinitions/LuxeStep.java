//package scenarios.stepDefinitions;
//
//import context.TestContext;
//import io.cucumber.java.Scenario;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import utilities.ConfigLoader;
//import utilities.CredsLoader;
//
//public class LuxeStep {
//
//
//    AccountPage accountPage;
//    LoginPage loginPage;
//    HomePage homePage;
//    LuxePage luxePage;
//    CatalogPage catalogPage;
//    CredsLoader credsLoader;
//    ConfigLoader configLoader;
//    Scenario scenario;
//
//    public static String expectedText = " ";
//
//    public LuxeStep(TestContext context) {
//
//        loginPage = new LoginPage(context.driver);
//        accountPage = new AccountPage(context.driver);
//        homePage = new HomePage(context.driver);
//        luxePage = new LuxePage(context.driver);
//        catalogPage = new CatalogPage(context.driver);
//        this.credsLoader = context.credsLoader;
//        this.configLoader = context.configLoader;
//        this.scenario = context.scenario;
//    }
//
//    @Given("User is on the luxepage")
//    public void user_is_on_the_luxepage() {
//
//        luxePage.clickOnLuxe();
//    }
//    @When("User clicks on a banner from the luxe")
//    public void user_clicks_on_a_banner_from_the_luxe() {
//
//        luxePage.clickOnHeroBanner();
//    }
//
//    @When("User clicks a sunglasses from categories you will love section")
//    public void user_clicks_a_sunglasses_from_categories_you_will_love_section() {
//
//        catalogPage.clickElementWithScroll(luxePage.sunGlass);
//    }
//    @When("User selects a product from selected category PLP")
//    public void user_selects_a_product_from_selected_category_plp() {
//
////        luxePage.clickOnProductLux();
//    }
//    @Then("User return to the luxe page from PDP")
//    public void user_return_to_the_luxe_page_from_pdp() {
//
//
//    }
//    @Then("User selects a citizen brand from brands to look out for")
//    public void user_selects_a_citizen_brand_from_brands_to_look_out_for() {
//
//    }
//    @Then("User return to main page")
//    public void user_return_to_main_page() {
//
//    }
//}
