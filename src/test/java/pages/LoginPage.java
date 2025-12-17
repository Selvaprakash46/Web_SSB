package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    // ---------- Locators ----------
    private final By login = By.id("menu-button");
    private final By userID = By.xpath("//input[@placeholder=\"Enter Your Mobile Number\"]");
    private final By continueButton = By.xpath("//button[contains(text(),'Continue')]");
    public final By invalidFormatMsg = By.xpath("//div[contains(text(), 'Please enter a valid number')]");
    private final By otp = By.xpath("//input[@type=\"tel\"]");
    public final By invalidOTP = By.xpath("//p[contains(text(), 'Please enter a valid OTP')]");
    public final By maxOtpAttempts = By.xpath("//p[contains(text(),'Since you have exceeded the maximum OTP attempts')]");
    public final By logout = By.xpath("//li[contains(text(), 'Logout')]");
    private final By resendOTP = By.xpath("//p[contains(text(), 'Resend SMS')]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // ---------- Common Actions ----------
    public void clickOnMenuButton()  {
        waitForPresenceOfElement(login);
        clickOnElement(login);
    }

    public void clickOnLogout() {
       if (!isWebElementDisplayed(logout)) {
           clickOnMenuButton();
           waitForPresenceOfElement(logout);
           safeClick(logout);
       }
    }

    public void enterUserID(String str) {
        waitForPresenceOfElement(userID);
        enterTextOnElement(userID, str);
    }

    public boolean clickOnTheContinueButton() {
        clickOnElement(continueButton);
        try {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(invalidFormatMsg),
                    ExpectedConditions.visibilityOfElementLocated(maxOtpAttempts)
            ));
            return false;
        } catch (TimeoutException e) {
            return true;
        }
    }

    public void enterOTP(String str) {
        clickOnElement(otp);
        enterTextOnElement(otp, str);
    }

    public boolean clickOnTheVerifyOTP() {
        try {
            clickOnElement(continueButton);
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(invalidOTP));
                return false;
            } catch (TimeoutException te) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void clickOnResendOTP() {
        waitForPresenceOfElement(resendOTP);
        clickOnElement(resendOTP);
    }


}
