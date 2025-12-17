package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;
import java.util.NoSuchElementException;


public class AccountPage extends BasePage {

    private final JavascriptExecutor js;
    private String selectedStore;
    private String selectedDateFormatted;
    private String selectedSlot;

    // ---------- Locators (unchanged) ----------
    public final By profile = By.xpath("//li[contains(text(),'Profile')]");
    public final By myOrders = By.xpath("//li[contains(text(),'My Orders')]");
    public final By manageAddress = By.xpath("//li[contains(text(),'Manage Address')]");
    public final By fcc = By.xpath("//li[contains(text(),'First Citizen Club')]");
    public final By myWallet = By.xpath("//li[contains(text(),'My Wallet')]");
    public final By savedPayments = By.xpath("//li[contains(text(),'Saved Payments')]");
    public final By helpAndSupport = By.xpath("//li[contains(text(),'Help & Support')]");
    public final By privacyPolicy = By.xpath("//li[contains(text(),'Privacy Policy')]");
    public final By firstConnect = By.xpath("(//p[contains(text(),'FIRST CONNECT')])[2]");
    public final By silver = By.xpath("(//p[contains(text(),'SILVER EDGE')])[2]");
    public final By golden = By.xpath("//p[contains(text(),'GOLDEN GLOW')]");
    public final By platinum = By.xpath("//p[contains(text(),'PLATINUM AURA')]");
    public final By black = By.xpath("//p[contains(text(),'BLACK')]");
    private final By card = By.xpath("//button[contains(text(),'Card')]");
    private final By firstName = By.name("firstName");
    private final By lastName = By.name("lastName");
    private final By fName = By.xpath("//input[@placeholder='Enter First Name']");
    private final By lName = By.xpath("//input[@placeholder='Enter Last Name']");
    private final By gender = By.xpath("//input[@type='radio']");
    private final By updateChangesBtn = By.xpath("//button[contains(text(),'Update Changes')]");
    private final By manageAddresses = By.xpath("//p[contains(text(),'Manage Addresses')]");
    private final By newAddAddress = By.xpath("//p[contains(text(),'Add Address')]");
    private final By mobNo = By.xpath("//input[@placeholder='Enter Phone Number']");
    private final By pinCode = By.xpath("//input[@placeholder='Enter Pin Code']");
    private final By address = By.xpath("//textarea[@placeholder='Enter Address']");
    private final By addAdd = By.xpath("//button[contains(text(),'add address')]");
    private final By addressType = By.xpath("//span[contains(text(),'Work')]");
    private final By editOption = By.xpath("(//button[contains(text(),'Edit')])[2]");
    private final By updateAddress = By.xpath("//button[contains(text(),'update address')]");
    private final By deleteAddress = By.xpath("(//button[contains(text(),'Remove')])[2]");
    private final By confirmDelete = By.xpath("(//p[contains(text(),'Remove Address')])[3]");


    public AccountPage(WebDriver driver) {
        super(driver);
        this.js = (JavascriptExecutor) this.driver;
    }

    // ---------------------- Public methods (kept signatures + behavior) ----------------------
    public void clickOnProfile() {
        safeClick(profile);
    }

    public void clicksOnFCC() {
        waitForPresenceOfElement(fcc);
        safeClick(fcc);
    }

    public void moveToProfile() {
        WebElement el = retryGetElement(profile);
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", el);
    }

    public String getEnteredName() {
        try {
            if (isWebElementDisplayed(firstName)) {
                return find(firstName).getAttribute("value");
            } else {
                return find(lastName).getAttribute("value");
            }
        } catch (Exception e) {
            return null;
        }
    }

    public void enterFirstName(String name) {
        isWebElementDisplayed(firstName);
        safeClick(firstName);
        enterTextOnElement(firstName, name);

    }

    public void enterLastName(String name) {
        isWebElementDisplayed(lastName);
        safeClick(lastName);
        enterTextOnElement(lastName, name);
    }

    public void enterUpdateFirstName(String name) {
        isWebElementDisplayed(fName);
        safeClick(fName);
        enterTextOnElement(fName, name);
    }

    public void enterUpdateLastName(String name) {
        isWebElementDisplayed(lName);
        safeClick(lName);
        enterTextOnElement(lName, name);
    }

    public void toggleGenderSelection() {
        List<WebElement> genders = findAll(gender);
        if (genders.size() >= 2) {
            WebElement maleGender = genders.get(0);
            WebElement femaleGender = genders.get(1);
            String aria = maleGender.getAttribute("aria-checked");
            boolean isMaleSelected = "true".equalsIgnoreCase(aria);
            safeClick(isMaleSelected ? femaleGender : maleGender);
        } else {
            throw new RuntimeException("Gender elements not found or insufficient count");
        }
    }

    public void clickOnTheUpdateChanges() {
        if (isElementPresent(updateChangesBtn)) {
            WebElement update = retryGetElement(updateChangesBtn);
            if (update.isDisplayed() && update.isEnabled()) {
                safeClick(update);
            }
        }
    }

    public void clickOnManageAddresses() {
        safeClick(manageAddresses);
    }

    public void clicksOnNewAddress() {
        safeClick(newAddAddress);
    }

    public void enterTheMobile(String no) {
        enterTextOnElement(mobNo, no);
    }

    public void enterThePinCode(String pin) {
        enterTextOnElement(pinCode, pin);
    }

    public void enterTheAddress(String adr) {
        scrollDown();
        enterTextOnElement(address, adr);
    }

    public void clickOnAddAddress() {
        waitForPresenceOfElement(addAdd);
        safeClick(addAdd);
    }

    public void clickOnAddressType() {
        safeClick(addressType);
    }

    public void clickOnEdit() {
        waitForPresenceOfElement(editOption);
        safeClick(editOption);
    }

    public void clickOnUpdateAddress() {
        waitForPresenceOfElement(updateAddress);
        safeClick(updateAddress);
    }

    public void clickOnRemove() {
        waitForPresenceOfElement(deleteAddress);
        safeClick(deleteAddress);
    }

    public void clickOnConfirmRemoveButton() {
        waitForPresenceOfElement(confirmDelete);
        safeClick(confirmDelete);
    }
}