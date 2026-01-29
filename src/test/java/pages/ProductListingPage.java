package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ProductListingPage extends BasePage {

    private final JavascriptExecutor js = (JavascriptExecutor) driver;

    // ---------- Locators ----------
    public final By productList = By.xpath("//div[@data-item-type='ProductSCCard']");
    private final By shade = By.xpath("//button[contains(text(),'Select Shade')]");
    private final By shadePopup = By.xpath("(//div[@class='MuiBox-root css-rs1ufz'])[2]");
    private final By productShadePopup = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-4bv7er']");
    private final By addToBag = By.xpath("//button[contains(text(),'Add To Bag')]");

    public ProductListingPage(WebDriver driver) {
        super(driver);
    }

    // ---------- Common Actions ----------

    public void moveToProduct() {
        isElementPresent(productList);
        moveToElement(productList);
    }
    public void validateShade() {
        try {
            moveToProduct();

            if (isElementPresent(shade)) {
                safeClick(shade);
            }
        } catch (Exception e) {}
    }

    public void selectShadeVariant() {
        try {
            if (isElementPresent(shadePopup)) {
                safeClick(shadePopup);
            }
            if (isElementPresent(addToBag)) {
                safeClick(addToBag);
            }
            waitFor(2);
        } catch (Exception e) {}
    }

    public String getProductShadePopupText() {
        WebElement popupText =
                wait.until(ExpectedConditions.visibilityOfElementLocated(productShadePopup));
        return popupText.getText().trim();
    }

    public String cartProductName() {
        WebElement popupText =
                wait.until(ExpectedConditions.visibilityOfElementLocated(productShadePopup));
        return popupText.getText().trim();
    }


}
