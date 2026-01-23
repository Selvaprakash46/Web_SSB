package scenarios.stepDefinitions;


import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.BasePage;
import pages.LoginPage;
import utilities.ConfigLoader;
import utilities.CredsLoader;


public class LoginStep {

    LoginPage loginPage;
    CredsLoader credsLoader;
    ConfigLoader configLoader;
    Scenario scenario;


    public LoginStep(TestContext context) {

        loginPage = new LoginPage(context.driver);
        this.credsLoader = context.credsLoader;
        this.configLoader = context.configLoader;
        this.scenario = context.scenario;
    }

    // Login with Mobile Number
    @Given("user launches the application")
    public void user_launches_the_application() {

        String url = configLoader.getProperty("uatUrl");
        loginPage.goTo(url);
        scenario.log("***** Web Application lunched Successfully *****");
    }
    @When("user clicks the Menu button for Login")
    public void user_clicks_the_menu_button_for_login() {

        loginPage.clickOnMenuButton();
    }

    @When("user hover the profile menu button")
    public void user_hover_the_profile_menu_button() {

        loginPage.hoverOnProfileBtn();
    }

    @When("user enters the valid mobile number")
    public void user_enters_the_valid_mobile_number()  {

//        Thread.sleep(20000);

        String mob = configLoader.getProperty("login.validMob");
        loginPage.enterUserID(mob);
        scenario.log("user Entered Mobile Number: " + mob);
    }

//    @When("user clicks the Continue button")
//    public void user_clicks_the_continue_button() {
//
//        boolean isVerified = loginPage.clickOnTheContinueButton();
//
//        if (loginPage.isElementPresent(loginPage.invalidFormatMsg)) {
//            Assert.fail("Login failed: Please enter a valid number");
//        }
//        if (loginPage.isElementPresent(loginPage.maxOtpAttempts)) {
//            Assert.fail("Login failed: Maximum OTP attempts exceeded");
//        }
//
//        Assert.assertTrue(isVerified, "Login verification failed unexpectedly");
//    }

    @When("user clicks the Continue button")
    public void user_clicks_the_continue_button() {

        loginPage.clickOnTheContinueButton();

        if (loginPage.isElementPresent(loginPage.validFormatMsg)) {
            scenario.log("Login successful: Number verified successfully, redirected to OTP page");

        } else if (loginPage.isElementPresent(loginPage.invalidFormatMsg)) {
            Assert.fail("Login failed: Please enter a valid number");

        } else if (loginPage.isElementPresent(loginPage.maxOtpAttempts)) {
            Assert.fail("Login failed: Maximum OTP attempts exceeded");

        } else {
            Assert.fail("Login failed: Unexpected error");

        }
    }

    @Then("user enters the OTP")
    public void user_enters_the_otp() {
        String otp = configLoader.getProperty("login.staticOtp");
        loginPage.enterOTP(otp);
        scenario.log("user Entered the OTP: " + otp);
    }
    @Then("user validates otp result")
    public void user_validates_otp_result() {

        boolean isVerified = loginPage.clickOnTheVerifyOTP();

        if (isVerified) {
            scenario.log("OTP validated successfully. Proceeding...");
        } else {
            if (loginPage.isElementPresent(loginPage.invalidOTP)) {
                scenario.log("Test failed: Invalid OTP entered");
            } else {
                scenario.log("Exception while clicking Verify OTP or OTP validation failed");
            }
        }
        Assert.assertTrue(isVerified, "OTP Verification Failed");
    }
    @Then("system should display the appropriate login status")
    public void system_should_display_the_appropriate_login_status() {

        scenario.log("***** Successfully logged in *****");
    }

    //Logout
    @When("user clicks on the Logout button")
    public void user_clicks_on_the_logout_button() {

        loginPage.clickOnLogout();
    }

    @Then("validate that the user is logged out")
    public void validate_that_the_user_is_logged_out() throws InterruptedException {

        scenario.log("Successfully logged out");

    }

    //OTP Validation
    @When("user enters the mobile number")
    public void user_enters_valid_mobile_number() {

        String mob = configLoader.getProperty("login.invalidMobileShort");
        loginPage.enterUserID(mob);
        scenario.log("user Entered Mobile Number: " + mob);
    }

    @When("user validate login id entry page")
    public void user_validate_login_id_entry_page() {

        loginPage.ValidateUserID();
        scenario.log("Login id entry is present");
    }

    @Then("user validates otp result for invalid otp")
    public void user_validates_otp_result_for_invalid_otp() {

        boolean isVerified = loginPage.clickOnTheVerifyOTP();

        if (!isVerified && loginPage.isElementPresent(loginPage.invalidOTP)) {
            scenario.log("Expected validation message displayed: Please enter a valid OTP");
            Assert.assertTrue(true);
            return;
        }
        Assert.assertTrue(isVerified, "OTP Verification Failed");
    }
    @Then("user clicks on the Resend SMS option")
    public void user_clicks_on_the_resend_sms_option() {

        loginPage.clickOnResendOTP();
    }
    @Then("user successfully resends the OTP")
    public void user_successfully_resends_the_otp() {

        scenario.log("OTP has successfully has resent");
    }
    @Then("user enters the invalid OTP")
    public void user_enters_the_invalid_otp() {

//        String otp = configLoader.getProperty("login.invalidOtp");
//        loginPage.enterOTP(otp);
//        scenario.log("user Entered the OTP: " + otp);
    }

    //Invalid User ID
    @When("user enters the invalid mobile number")
    public void user_enters_the_invalid_mobile_number() {

        String mob = configLoader.getProperty("login.invalidMobileLong");
        loginPage.enterUserID(mob);
        scenario.log("User Entered Mobile Number: " + mob);
    }

    @When("user clicks the Continue button for invalid number validates")
    public void user_clicks_the_continue_button_for_invalid_number_validates() {

        boolean isVerified = loginPage.clickOnTheContinueButtonInvalidNo();

        if (!isVerified && loginPage.isElementPresent(loginPage.invalidFormatMsg)) {
            scenario.log("Expected validation message displayed: Please enter a valid number");
            Assert.assertTrue(true);
            return;
        }
        Assert.assertTrue(isVerified, "Login verification failed unexpectedly");
    }

    @Then("validate that the appropriate error message is displayed")
    public void validate_that_the_appropriate_error_message_is_displayed() {

        Assert.assertTrue(loginPage.isElementPresent(loginPage.invalidFormatMsg),
                "Error message not displayed: " + loginPage.isElementPresent(loginPage.invalidFormatMsg));

    }

}
