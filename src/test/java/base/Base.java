package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import pages.ValueAddedTaxCalculatorPage;

public class Base {
    private WebDriver driver;

    protected ValueAddedTaxCalculatorPage valueAddedTaxCalculatorPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        var options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.calkoo.com/en/vat-calculator");
        valueAddedTaxCalculatorPage = new ValueAddedTaxCalculatorPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
