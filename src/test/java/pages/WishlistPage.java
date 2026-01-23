package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class WishlistPage extends BasePage {

    private final JavascriptExecutor js = (JavascriptExecutor) driver;

    // ---------- Locators ----------
    private final By productWishlisted = By.xpath("//p[contains(text(), 'Products Wishlist')]");
    private final By search = By.xpath("//input[@placeholder='Search']");
    private final By homeButton = By.xpath("//img[@alt='Image 1']");
    private final By emptyCartBtn = By.xpath("(//div[@class='MuiBox-root css-1dy8gno'])[2]");
    private final By removeWishlist = By.xpath("//*[name()='svg' and contains(@class,'css-1exo64a')]");


    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    // ---------- Common Actions ----------

    public boolean validateWishlistComponentsByText(List<String> expectedSections) {
        isElementPresent(productWishlisted);
        List<By> expectedComponents = Arrays.asList(
                productWishlisted,
                search,
                homeButton,
                emptyCartBtn
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

    public int getWishlistedProductCount(By locator) {

        String text = driver.findElement(locator).getText();

        return Integer.parseInt(text.split(" ")[0]);
    }

    public int validateWishlistedCount(int expectedCount) {

        int actualCount = getWishlistedProductCount(productWishlisted);
        Assert.assertEquals(actualCount, expectedCount, "Wishlist count mismatch");
        return actualCount;
    }

    public void validateProductToRemoveWishlist() {

        isElementPresent(removeWishlist);
    }

}
