package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class CartPage extends BasePage{

    public final JavascriptExecutor js = (JavascriptExecutor) driver;

    // ---------- Locators ----------
    private final By cartIcon = By.xpath("//span[@class='MuiBadge-root css-1g48zis']");
    private final By bag = By.xpath("//p[contains(text(),'Bag')]");
    private final By address = By.xpath("(//p[contains(text(),'Address')])[1]");
    private final By payment = By.xpath("//p[contains(text(),'Payment')]");
    private final By bestCoupon = By.xpath("//p[contains(text(),'Best coupons for you')]");
    public final By increaseQuan = By.xpath("(//button[@type='button'])[3]");
    public final By decreaseQuan = By.xpath("(//button[@type='button'])[2]");
    private final By xMark = By.xpath("(//div[@class='MuiBox-root css-emasls'])[1]");
    private final By moveToWishlist = By.xpath("//button[contains(text(),'move to wishlist')]");
    private final By remove = By.xpath("//button[contains(text(),'Remove')]");
    private final By check = By.xpath("//button[contains(text(),'Change Address')]");
    private final By pinCode = By.xpath("//input[@placeholder='Enter Pincode']");



    public CartPage(WebDriver driver) {
        super(driver);
    }

    // ---------- Common Actions ----------
    public void clickOnCartIcon() {
        isElementPresent(cartIcon);
        clickOnElement(cartIcon);
    }
    public boolean validateCartComponentsByText(List<String> expectedSections) {
        List<By> expectedComponents = Arrays.asList(
                bag,
                address,
                payment,
                bestCoupon
        );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean allFound = true;
        for (By locator : expectedComponents) {
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            } catch (TimeoutException e) {
                allFound = false;
            }
        }
        return allFound;
    }
    public void adjustQuantity(int times, boolean increaseChoice, By element) throws InterruptedException {

        for (int i = 0; i < times; i++) {
            Thread.sleep(2000);
            safeClick(element);
            System.out.println(increaseChoice ? "Quantity Increased" : "Quantity Decreased");
        }
    }
    public void clickOnProductToRemove() {
        waitForPresenceOfElement(xMark);
        safeClick(xMark);
    }
    public void clickOnMoveToWishlist() {
        waitForPresenceOfElement(moveToWishlist);
        safeClick(moveToWishlist);
    }
    public void clickOnRemoveItem() {
        waitForPresenceOfElement(remove);
        safeClick(remove);
    }
    public void clickOnCheckOption() {
        safeClick(check);
    }
    public void enterThePinCode(String pin) {
        enterTextOnElement(pinCode, pin);
    }


}
