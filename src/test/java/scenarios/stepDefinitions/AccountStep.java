package scenarios.stepDefinitions;

import context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AccountPage;
import pages.LoginPage;
import utilities.ConfigLoader;
import utilities.CredsLoader;

import java.util.Arrays;
import java.util.List;


public class AccountStep {

    AccountPage accountPage;
    LoginPage loginPage;
    CredsLoader credsLoader;
    ConfigLoader configLoader;
    Scenario scenario;

    public static String expectedText = " ";

    public AccountStep(TestContext context) {

        loginPage = new LoginPage(context.driver);
        accountPage = new AccountPage(context.driver);
        this.credsLoader = context.credsLoader;
        this.configLoader = context.configLoader;
        this.scenario = context.scenario;
    }

    // Verify Components of Account
    @Given("user navigates to My Profile")
    public void user_navigates_to_my_profile() {

        accountPage.moveToProfile();
    }
    @Then("system should display the following components in the Account section")
    public void system_should_display_the_following_components_in_the_account_section(DataTable dataTable) {

        List<String> actualCom = dataTable.asList();
        List<By> cartOptions = Arrays.asList(
                accountPage.profile,
                accountPage.myOrders,
                accountPage.manageAddress,
                accountPage.fcc,
                accountPage.myWallet,
                accountPage.savedPayments,
                accountPage.helpAndSupport,
                accountPage.privacyPolicy,
                loginPage.logout
        );
        scenario.log("Actual Components: " + actualCom);
        for (By option : cartOptions) {
            if (accountPage.isElementPresent(option)) {
                accountPage.scrollDown();
            }
            if (!accountPage.isElementPresent(option)) {
                Assert.assertTrue(accountPage.isElementPresent(option),
                        "Account Components not displayed: " + cartOptions);
                scenario.log("Account Component Options: " + cartOptions);
            }
        }
    }

    // FCC
    @When("user clicks the First citizen club")
    public void user_clicks_the_first_citizen_club() {

        accountPage.clicksOnFCC();
    }
    @When("system should display the following components in the FCC section")
    public void system_should_display_the_following_components_in_the_FCC_section(DataTable dataTable) {

        List<String> actualCom = dataTable.asList();
        List<By> cartOptions = Arrays.asList(
                accountPage.firstConnect,
                accountPage.silver,
                accountPage.golden,
                accountPage.platinum,
                accountPage.black
        );
        scenario.log("Actual Components: " + actualCom);
        for (By option : cartOptions) {
            if (!accountPage.isElementPresent(option)) {
                accountPage.scrollDown();
            }
            if (!accountPage.isElementPresent(option)) {
                Assert.assertTrue(accountPage.isElementPresent(option),
                        "FCC Component not displayed: " + accountPage.isElementPresent(option));
                scenario.log("FCC Options: " + accountPage.isElementPresent(option));
            }
        }
    }

    // CRUD
    @When("user clicks on the my Profile option")
    public void user_clicks_on_the_my_profile_option() {

        accountPage.clickOnProfile();
    }
    @When("user update their first name")
    public void user_update_their_first_name() {

        String name1 = configLoader.getProperty("address.firstName");
        String name2 = configLoader.getProperty("address.firstName1");

        String currentName = accountPage.getEnteredName();

        if (currentName != null && currentName.equalsIgnoreCase(name1)) {
            accountPage.enterFirstName(name2);
            scenario.log("Entered First Name: " + name2);
        } else {
            accountPage.enterFirstName(name1);
            scenario.log("Entered First Name: " + name1);
        }
    }
    @When("user update their last name")
    public void user_update_their_last_name() {

        String name1 = configLoader.getProperty("address.lastName");
        String name2 = configLoader.getProperty("address.lastName1");

        String currentName = accountPage.getEnteredName();

        if (currentName != null && currentName.equalsIgnoreCase(name1)) {
            accountPage.enterLastName(name2);
            scenario.log("Entered Last Name: " + name2);
        } else {
            accountPage.enterLastName(name1);
            scenario.log("Entered Last Name: " + name1);
        }
    }
    @When("user update their gender details")
    public void user_update_their_gender_details() {

        accountPage.toggleGenderSelection();
    }
    @When("user clicks on the update changes")
    public void user_clicks_on_the_update_changes() {

        accountPage.clickOnTheUpdateChanges();
    }
    @When("user validate that personal details successfully updated")
    public void user_validate_that_personal_details_successfully_updated() {

        scenario.log("Your profile has been updated successfully");
    }
    @When("user clicks on the manage addresses")
    public void user_clicks_on_the_manage_addresses() throws InterruptedException {

        accountPage.clickOnManageAddresses();
    }
    @When("user is able to add a new address")
    public void user_is_able_to_add_a_new_address() {

        accountPage.clicksOnNewAddress();
    }
    @When("user enters the new first name")
    public void user_enters_the_new_first_name() {

        String name = configLoader.getProperty("address.new.fName");
        accountPage.enterUpdateFirstName(name);
        scenario.log("user Entered Name: " + name);
    }
    @When("user enters the new last name")
    public void user_enters_the_new_last_name() {

        String name = configLoader.getProperty("address.new.lName");
        accountPage.enterUpdateLastName(name);
        scenario.log("user Entered Name: " + name);
    }
    @When("user enters the new number")
    public void user_enters_the_new_number() {

        String mob = configLoader.getProperty("address.new.mobile");
        accountPage.enterTheMobile(mob);
        scenario.log("user Entered Name: " + mob);
    }
    @When("user enters the new pin code")
    public void user_enters_the_new_pin_code() {

        String pin = configLoader.getProperty("address.new.pin");
        accountPage.enterThePinCode(pin);
        scenario.log("user Entered Name: " + pin);
    }
    @When("user enters the new address")
    public void user_enters_the_new_address() {

        String address = configLoader.getProperty("address.new.line");
        accountPage.enterTheAddress(address);
        scenario.log("user Entered Name: " + address);
    }
    @When("user selects a address type as work")
    public void user_selects_a_address_type_as_work() {

        accountPage.clickOnAddressType();
    }
    @When("user clicks on the add address")
    public void user_clicks_on_the_add_address() {

        accountPage.clickOnAddAddress();
    }
    @When("user validate that new address added successfully")
    public void user_validate_that_new_address_added_successfully() {

        scenario.log("New address has been created successfully.");
    }
    @Then("user updates an existing address")
    public void user_updates_an_existing_address() {

        accountPage.clickOnEdit();
    }
    @Then("user clicks on the save changes")
    public void user_clicks_on_the_save_changes() {

        accountPage.clickOnUpdateAddress();
    }
    @Then("Validate that existing address has updated")
    public void validate_that_existing_address_has_updated() {

        scenario.log("Changes Saved");
    }
    @Then("user is able to delete exiting address")
    public void user_is_able_to_delete_exiting_address() throws InterruptedException {

        accountPage.clickOnRemove();
    }
    @Then("user clicks on the confirm remove button for delete address")
    public void user_clicks_on_the_confirm_remove_button_for_delete_address() {

        accountPage.clickOnConfirmRemoveButton();
    }
    @Then("user validate that delete address message is displayed")
    public void user_validate_that_delete_address_message_is_displayed() {

        scenario.log("Address has been deleted successfully");
    }

}
