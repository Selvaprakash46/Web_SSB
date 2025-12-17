package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class CheckoutPage extends BasePage {

    private final JavascriptExecutor js = (JavascriptExecutor) driver;

    // ---------- Locators ----------
    public final By emptyBag = By.xpath("//p[contains(text(),'Your Bag Feels Too Light!')]");
    private final By proceedToCheckout = By.xpath("//button[contains(text(),'Proceed to Checkout')]");
    private final By mrpProduct =  By.xpath("//p[contains(text(), 'Total MRP')]/following-sibling::p");
    private final By discountProduct = By.xpath("//p[contains(text(), 'Offer Discount')]/following-sibling::p");
    private final By savingsProduct = By.xpath("//div[contains(text(), 'Your Total Savings')]/following-sibling::p");
    private final By deliveryFeeProduct = By.xpath("//div[contains(text(), 'Delivery Fee')]/following-sibling::p");
    private final By totalFeeProduct =  By.xpath("//p[normalize-space()='Total Amount']/following-sibling::p[contains(text(),'₹')]");
    private final By continueButton = By.xpath("//button[contains(text(), 'continue')]");
    private final By cod = By.xpath("//p[contains(text(),'Select COD')]");
    private final By placeOrder = By.xpath("//p[contains(text(),'Place Order')]");
    public final By orderSuccess = By.xpath("//p[contains(text(),'Order Placed Successfully')]");
    private final By orderDetailsContainer = By.xpath("//div[@class='MuiBox-root css-op4je4']");
    private final By rows = By.xpath("//div[@class='MuiBox-root css-q73mck']");
    private final By continueShopping = By.xpath("(//p[contains(text(),'Continue Shopping')])[1]");
    private final By upi = By.xpath("//p[contains(text(),'Add New UPI Id')]");
    private final By editUpi = By.xpath("//input[@placeholder='Enter UPI ID Here']");
    private final By verify = By.xpath("//button[contains(text(),'VERIFY')]");





    public final By productList = By.xpath("//div[@data-product-id]");
    private final By reviewShop = By.xpath("//div[contains(text(), 'RATE YOUR SHOPPING EXPERIENCE')]");
    private final By submitButton = By.xpath("//p[contains(text(), 'submit')]");
    private final By error = By.xpath("//div[contains(text(), 'What do you hate more than a broken item? A 404 error like this one!')]");
    private final By priceDetails = By.xpath("//div[@class='flex flex-col items-start sm:px-4 md:px-0 md:pt-0 lg:px-0 xs:pt-4 mm:px-0']");
    private final By outOfStockCheck = By.xpath("//*[contains(translate(text(),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'), 'OUT OF STOCK')]");
    private final By sizeBtn = By.xpath("//div[contains(@class,'overflow-x-auto')]//button");
//    private final By addToBag = By.xpath("//img[@alt=\"bag_white\"]");
    private final By addToBag = By.xpath("//p[contains(text(), 'Add to bag')]");
    private final By popUpViewBag = By.xpath("(//p[contains(text(), 'View Bag')])[2]");
    private final By viewBag = By.xpath("//p[contains(text(), 'View Bag')]");
    private final By addressBox = By.xpath("//div[@class=\"rounded-full border border-black p-1\"]");
    private final By item = By.cssSelector("div[data-state='open'][class*='fixed']");

    private final By containerLocator = By.xpath("//div[@class='md: mt-4 flex flex-col gap-5 md:max-w-[1200px] md:flex-row md:flex-wrap md:justify-between md:gap-6 lg:mt-6 lg:gap-8 xl:gap-[72px]']");
    private final By deliverInfo = By.xpath("(//div[@class='rounded border border-lightGray p-4'])[2]");
    private final By paymentMode = By.xpath("//*[contains(text(),'Credit') or contains(text(),'Netbanking') or contains(text(),'Wallets')]");
    private final By iFrame = By.name("HyperServices");
    private final By cardBlockLocator = By.xpath("//div[@class='rounded border border-lightGray md:basis-[31%] lg:rounded-lg']");
    private final By cardBlockEle = By.xpath(".//div | .//p");
    private final By wallet = By.xpath(   "(//*[text()='Wallets' or normalize-space()='Wallets'])[8]");
    private final By phonePe = By.xpath("//*[text()='PhonePe' or contains(text(),'Phone Pe')]");
    private final By proceedBtn = By.xpath("//*[text()='Proceed' or contains(text(),'Proceed')]");


    private final By proceedToPay = By.xpath("(//article[contains(text(), 'Proceed to pay ')])[2]");
    private final By filterLocator = By.xpath("//div[@class='cursor-pointer text-nowrap rounded-[36px] border border-neutral-300 px-2.5 py-3 md:rounded bg-transparent']");
    private final By ratingContainer = By.cssSelector("svg[data-testid='rating-component-star']:nth-of-type(4)");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    // ---------- Common Actions ----------
    public void clickOnProceedToCheckout() {
        waitForPresenceOfElement(proceedToCheckout);
        safeClick(proceedToCheckout);
   }
    public boolean validateEmptyBag() {
        try {
            List<WebElement> emptyBagMessage = driver.findElements(emptyBag);
            return emptyBagMessage.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
    public Map<String, Double> getPriceDetails() {

        Map<String, Double> priceMap = new HashMap<>();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        double mrp = 0, discount = 0, delivery = 0, total = 0;

        try {
            WebElement mrpElem = wait.until(ExpectedConditions.visibilityOfElementLocated(mrpProduct));
            mrp = Double.parseDouble(mrpElem.getText().replaceAll("[^\\d.]", ""));
        } catch (Exception ignored) {}

        try {
            WebElement discountElem = driver.findElement(discountProduct);
            discount = Double.parseDouble(discountElem.getText().replaceAll("[^\\d.]", ""));
        } catch (Exception ignored) {}

        try {
            WebElement deliveryElem = driver.findElement(deliveryFeeProduct);
            String deliveryText = deliveryElem.getText().trim();
            delivery = deliveryText.equalsIgnoreCase("Free") ? 0
                    : Double.parseDouble(deliveryText.replaceAll("[^\\d.]", ""));
        } catch (Exception ignored) {}

        try {
            WebElement totalElem = driver.findElement(totalFeeProduct);
            total = Double.parseDouble(totalElem.getText().replaceAll("[^\\d.]", ""));
        } catch (Exception ignored) {}

        priceMap.put("MRP", mrp);
        priceMap.put("Discount", discount);
        priceMap.put("DeliveryFee", delivery);
        priceMap.put("Total", total);

        return priceMap;
    }
    public boolean validatePriceDetails(Map<String, Double> priceMap) {

        double mrp = priceMap.get("MRP");
        double discount = priceMap.get("Discount");
        double delivery = priceMap.get("DeliveryFee");
        double total = priceMap.get("Total");

        if (mrp <= 0 || total <= 0) return false;

        double expected = mrp - discount + delivery;
        return Math.abs(total - expected) < 0.1;
    }


    public void clickOnContinueButton() {
        waitForPresenceOfElement(continueButton);
        safeClick(continueButton);
    }
    public void selectingTheCODOption() {
        waitForPresenceOfElement(cod);
        safeClick(cod);
    }
    public void clickOnPlaceOrder() {
        waitForPresenceOfElement(placeOrder);
        safeClick(placeOrder);
    }
    public void printOrderDetails() {

        WebElement container = driver.findElement(orderDetailsContainer);
        List<WebElement> details = container.findElements(rows);

        for (WebElement row : details) {
            List<WebElement> texts = row.findElements(By.xpath(".//p"));
            if (texts.size() == 2) {
                String label = texts.get(0).getText().trim();
                String value = texts.get(1).getText().trim();
                System.out.println(label + " : " + value);
            }
        }
    }
    public void clickOnContinueShopping() {
        waitForPresenceOfElement(continueShopping);
        safeClick(continueShopping);
    }
    public void selectingTheUPIOption() {
        waitForPresenceOfElement(upi);
        safeClick(upi);
    }
    public void enterTheUPIId(String upi) {
        waitForPresenceOfElement(editUpi);
        enterTextOnElement(editUpi, upi);
    }
    public void clickOnVerify() {
        waitForPresenceOfElement(verify);
        safeClick(verify);
    }
}