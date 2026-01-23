package hooks;

import context.TestContext;
import factory.DriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.*;
import utilities.ConfigLoader;
import utilities.CredsLoader;

public class Hooks {

    private WebDriver driver;
    private final TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setUp(Scenario scenario) {

        // ✅ Create driver ONCE
        driver = DriverFactory.initializeDriver();

        // ✅ Share via context
        context.driver = driver;
        context.scenario = scenario;

        // ✅ Load utilities (safe)
        context.credsLoader = new CredsLoader();
        context.configLoader = new ConfigLoader();
    }

    @After
    public void tearDown(Scenario scenario) {

        if (driver != null) {
            if (scenario.isFailed()) {
                byte[] screenshot =
                        ((TakesScreenshot) driver)
                                .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failure Screenshot");
            }
            driver.quit();
        }
    }
}








//package hooks;
//
//import context.TestContext;
//import factory.DriverFactory;
//import io.cucumber.java.*;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import pages.*;
//import utilities.ConfigLoader;
//import utilities.CredsLoader;
//import java.io.*;
//
//public class Hooks {
//    private static WebDriver driver;
//    private final TestContext context;
//
//    public Hooks(TestContext context) {
//        this.context = context;
//    }
//
////    @BeforeAll
////    public static void setUpAll() {
////        driver = DriverFactory.initializeDriver();
////    }
//    @Before
//    public void setUp() {
//    driver = new ChromeDriver();
//    driver.manage().window().maximize();
//    }
//
//    @Before
//    public void setUp(Scenario scenario) {
//        driver = DriverFactory.initializeDriver();
//        driver = DriverFactory.getDriver();
//        context.driver = driver;
//        context.credsLoader = new CredsLoader();
//        context.configLoader = new ConfigLoader();
//        context.loginPage = new LoginPage(context.driver);
//        context.accountPage = new AccountPage(context.driver);
//        context.checkoutPage = new CheckoutPage(context.driver);
//        context.headerPage = new HeaderPage(context.driver);
//        context.cartPage = new CartPage(context.driver);
//        context.homePage = new HomePage(context.driver);
//        context.scenario = scenario;
//
//    }
//
//    @After
//    public void tearDown(Scenario scenario) {
//        if (driver != null) {
//            if (scenario.isFailed()) {
//                byte[] screenshot =
//                        ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//                scenario.attach(screenshot, "image/png", "Failure Screenshot");
//            }
//            driver.quit();
//        }
//    }
//}







//package hooks;
//
//import context.TestContext;
//import factory.DriverFactory;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import pages.BasicFormPage;
//import pages.UsingTheGridPage;
//import utilities.ConfigLoader;
//import utilities.CredsLoader;
//
//import java.io.File;
//import java.io.IOException;
//
//public class Hooks {
//    private WebDriver driver;
//    private final TestContext context;
//
//    public Hooks(TestContext context) {
//        this.context = context;
//    }
//
//    @Before
//    public void setUp(Scenario scenario) {
//        driver = DriverFactory.initializeDriver();
//        context.driver = driver;
//        context.credsLoader = new CredsLoader();
//        context.configLoader = new ConfigLoader();
//        context.basicFormPage = new BasicFormPage(context.driver);
//        context.usingTheGridPage = new UsingTheGridPage(context.driver);
//        context.scenario = scenario;
//    }
//
//    @After
//    public void tearDown(Scenario scenario) throws IOException {
//        // Take screenshot if the scenario failed
//        if (scenario.isFailed()) {
//            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
//            scenario.attach(fileContent, "image/png", "image");
//        }
//
//        if (driver != null)
//            driver.quit();
//    }
//
//}
