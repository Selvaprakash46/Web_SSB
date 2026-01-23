package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage extends BasePage {

    // ---------- Locators ----------
    private final By login = By.id("menu-button");
    private final By userID = By.xpath("//input[@placeholder=\"Enter Your Mobile Number\"]");
    private final By continueButton = By.xpath("//button[contains(text(),'Continue')]");
    public final By invalidFormatMsg = By.xpath("//div[contains(text(), 'Please enter a valid number')]");
    public final By validFormatMsg = By.xpath("//p[contains(text(), 'OTP Verification')]");
    private final By otp = By.xpath("//input[@type='tel' and contains(@class,'MuiOutlinedInput-input')]");
    public final By invalidOTP = By.xpath("//p[contains(text(), 'Please enter a valid OTP')]");
    public final By maxOtpAttempts = By.xpath("//p[contains(text(),'Since you have exceeded the maximum OTP attempts')]");
    public final By logout = By.xpath("//li[contains(text(), 'Logout')]");
    private final By resendOTP = By.xpath("//p[contains(text(), 'Resend SMS')]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // ---------- Common Actions ----------
    public void clickOnMenuButton() {
        isElementPresent(login);
        clickOnElement(login);
    }

    public void hoverOnProfileBtn() {
        isElementPresent(login);
        hoverOnElement(login);
    }

    public void clickOnLogout() {
       isElementPresent(login);
       hoverOnElement(login);
        if (!isWebElementDisplayed(logout)) {
            hoverOnElement(login);
        }
        isElementPresent(logout);
        hoverOnElement(logout);
        clickJsUsingBy(logout);
        waitFor(3);
    }

    public void enterUserID(String str) {
        isElementPresent(userID);
        enterTextOnElement(userID, str);

    }

    public void ValidateUserID() {
        isElementPresent(userID);

    }

//    public boolean clickOnTheContinueButton() {
//        clickOnElement(continueButton);
//        try {
//            wait.until(
//                    ExpectedConditions.visibilityOfElementLocated(validFormatMsg)
//            );
//            return true;
//        } catch (TimeoutException e) {
//            wait.until(ExpectedConditions.or(
//                    ExpectedConditions.visibilityOfElementLocated(invalidFormatMsg),
//                    ExpectedConditions.visibilityOfElementLocated(maxOtpAttempts)
//            ));
//            return false;
//        }
//    }

    public void clickOnTheContinueButton() {

        clickOnElement(continueButton);
    }

    public boolean clickOnTheContinueButtonInvalidNo() {
        clickOnElement(continueButton);
        try {
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(validFormatMsg)
            );
            return true;
        } catch (TimeoutException e) {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(invalidFormatMsg),
                    ExpectedConditions.visibilityOfElementLocated(maxOtpAttempts)
            ));
            return false;
        }
    }

    public void enterOTP(String str) {

        enterTextOnElement(otp, str);
    }

    public boolean clickOnTheVerifyOTP() {

            clickOnElement(continueButton);
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(invalidOTP));
                return false;
            } catch (TimeoutException te) {
                return true;
            }

    }

    public void clickOnResendOTP() {
        isElementPresent(resendOTP);
        clickOnElement(resendOTP);
    }

}
