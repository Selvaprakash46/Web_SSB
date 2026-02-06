package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDetailPage extends BasePage {

    private final JavascriptExecutor js = (JavascriptExecutor) driver;

    // ---------- Locators ----------

    private final By shareWithFriendsBtn = By.xpath("//p[contains(text(), 'Share it with friends')]");
    private final By facebookBtn = By.xpath("//button[contains(text(),'FACEBOOK')]");
    private final By whatsappBtn = By.xpath("//button[contains(text(),'WHATSAPP')]");
    private final By pinterestBtn = By.xpath("//button[contains(text(),'PINTEREST')]");
    private final By emailBtn = By.xpath("//button[contains(text(),'EMAIL')]");
    public final By productList = By.xpath("(//div[@data-item-type='ProdctSCCard'])[1]");
    public final By customerAlsoBoughtProduct = By.xpath("(//p[contains(text(),'CUSTOMERS ALSO BOUGHT')]/following::div[@data-item-type='ProdctSCCard'])[1]");
    public final By customersAlsoBought = By.xpath("//p[contains(text(),'CUSTOMERS ALSO BOUGHT')]");
    public final By moreFromTheBrand = By.xpath("//p[contains(text(),'MORE FROM THE BRAND')]");
    public final By reviewAndRating = By.xpath("//p[contains(text(),'Review & Ratings')]");
    private final By viewSimilarProductsIcon = By.xpath("(//div[contains(@class,'MuiBox-root css-12m2grd')]//*[name()='svg'])[1]");
    private final By addToBagSimilarProductsIcon = By.xpath("//p[normalize-space()='SIMILAR PRODUCTS']/following::button[normalize-space()='Add To Bag']");
    private final By addToBagCustomersAlsoBoughtIcon = By.xpath("//p[normalize-space()='CUSTOMERS ALSO BOUGHT']/following::button[normalize-space()='Add To Bag']");
    private final By addToFavouriteSimilarProductsIcon = By.xpath("(//p[normalize-space()='SIMILAR PRODUCTS']/following::div[@class='MuiGrid-root css-shd5b'])[1]");
    private final By addToFavouriteCustomersAlsoBoughtIcon = By.xpath("(//p[normalize-space()='CUSTOMERS ALSO BOUGHT']/following::div[@class='MuiGrid-root css-shd5b'])[1]");
    private final By ProductAddedToCartMsg = By.xpath("//p[contains(text(),'Product successfully added to your cart')]");
    private final By writeAReviewBtn = By.xpath("//button[contains(text(),'WRITE A REVIEW')]");
    private final By addPhotosPopup = By.xpath("//p[contains(text(),'ADD PHOTOS')]");
    private final By ratingForThisProduct = By.xpath("//p[contains(text(),'Your rating for this product')]");
    private final By writeAReviewPopup = By.xpath("//p[contains(text(),'Write a review')]");
    private final By threeStarRating = By.xpath("//span[@class='MuiRating-root MuiRating-sizeMedium css-my98p3']/label[3]");
    private final By reviewTitleTxtBox = By.xpath("//input[@placeholder='Review title']");
    private final By reviewDescriptionTxtBox = By.xpath("//textarea[@placeholder='Review description']");
    private final By AddReviewBtn = By.xpath("//button[contains(text(),'Add Review')]");
    private final By reviewSubmittedMessage = By.xpath("//p[contains(text(),'Thanks for Sharing Your Review!')]");
    private final By cartFirstProductName = By.xpath("(//div[@data-item-type='CartProductCard']//p[contains(@class,'MuiTypography-body1')])[1]");
    private final By productNamePDP = By.xpath("//h2[@class='MuiTypography-root MuiTypography-h2 css-y8yexr']");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    // ---------- Common Actions ----------

    public boolean validateShareOptionsComponentsByText(List<String> expectedSections) {

        isElementPresent(shareWithFriendsBtn);
        List<By> expectedComponents = Arrays.asList(
                shareWithFriendsBtn,
                facebookBtn,
                whatsappBtn,
                pinterestBtn,
                emailBtn

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

    public void clickOnViewSimilarProductsIconPDP() {

        isElementPresent(viewSimilarProductsIcon);
        safeClick(viewSimilarProductsIcon);
        waitFor(1);
    }

    public void validateSimilarProductsAreChambor() {

        List<WebElement> productNames = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[@class='css-12anm3s']")));
        System.out.println(productNames);
        for (int i = 0; i < Math.min(productNames.size(), 4); i++) {
            String productName = productNames.get(i).getText().trim();
            Assert.assertTrue(
                    productName.toLowerCase().contains("chambor"),
                    "Non-Chambor product found: " + productName
            );
        }
    }

    public void clickOnAddToCartSimilarProductPDP() {

        isElementPresent(addToBagSimilarProductsIcon);
        safeClick(addToBagSimilarProductsIcon);
        waitFor(2);
    }

    public void clickOnAddToFavouriteSimilarProductPDP() {

        waitFor(5);
        isElementPresent(addToFavouriteSimilarProductsIcon);
        safeClick(addToFavouriteSimilarProductsIcon);
        waitFor(2);
    }

    public void clickOnAddToFavouriteCustomersAlsoBoughtPDP() {

        waitFor(5);
        isElementPresent(addToFavouriteCustomersAlsoBoughtIcon);
        safeClick(addToFavouriteCustomersAlsoBoughtIcon);
        waitFor(2);
    }

    public void moveToProduct() {

        isElementPresent(productList);
        moveToElement(productList);
    }

    public void moveToSimilarProductPDP() {

        try {
            hoverOnElement(productList);
            if (isElementPresent(addToBagSimilarProductsIcon)) {
                safeClick(addToBagSimilarProductsIcon);
            }
        } catch (Exception e) {}
    }

    public void moveToCustomersAlsoBoughtPDP() {

        try {
            hoverOnElement(customerAlsoBoughtProduct);
            if (isElementPresent(addToBagCustomersAlsoBoughtIcon)) {
                safeClick(addToBagCustomersAlsoBoughtIcon);
            }
        } catch (Exception e) {}
    }

    public void scrollSimilarProductsProductPDP() {

        scrollIntoElementUsingJS(customersAlsoBought);
        waitFor(2);
    }

    public void scrollCustomersAlsoBoughtProductPDP() {

//        scrollIntoElementUsingJS(moreFromTheBrand);
//        scrollIntoElementUsingJS(moreFromTheBrand);
//        scrollToElement(moreFromTheBrand);
        scrollTillElement(moreFromTheBrand);
//        scrollEndOfPage();
        waitFor(2);
    }

    public void ValidateProductAddedToCart() {

        isWebElementDisplayed(ProductAddedToCartMsg);
    }
    public void scrollElement() {
        scrollDown();
    }

    public void scrollToWriteAReviewPDP() {

        scrollAndClickUsingJS(writeAReviewBtn);
        waitFor(2);
    }

    public void clickOnRatingsStar() {

        isElementPresent(threeStarRating);
        safeClick(threeStarRating);
    }

    public boolean validateWriteAReviewComponentsByText(List<String> expectedSections) {

        isElementPresent(writeAReviewPopup);
        List<By> expectedComponents = Arrays.asList(
                writeAReviewPopup,
                addPhotosPopup,
                ratingForThisProduct

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

    public void enterReviewTitle(String str) {

        enterKeywordOnElement(reviewTitleTxtBox, str);
    }

    public void enterReviewDescription(String str) {

        enterKeywordOnElement(reviewDescriptionTxtBox, str);
    }

    public void clickOnAddReviewBtn() {

        isElementPresent(AddReviewBtn);
        safeClick(AddReviewBtn);
        waitFor(10);
    }

    public void validateReviewSubmittedPopup() {

        isElementPresent(reviewSubmittedMessage);
        validateErrorMessageByPartialText("Thanks for Sharing Your Review!", "Thanks For Sharing Your Review!");
    }

    public String getFirstCartProductName() {

        WebElement productNameElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(cartFirstProductName));

        String productName = productNameElement.getText().trim();
        System.out.println("First Cart Product Name: " + productName);

        return productName;
    }

    public String getProductNamePDP() {

        WebElement productNameElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(productNamePDP));

        String productName = productNameElement.getText().trim();
        System.out.println("Product Name from PDP: " + productName);

        return productName;
    }

}
