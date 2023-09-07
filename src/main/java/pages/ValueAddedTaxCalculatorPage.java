package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ValueAddedTaxCalculatorPage {
    private WebDriver driver;

    private By consentBtn = By.xpath("//p[text()='Consent']");
    private By countryDropDown = By.xpath("//select[@name='Country']");

    private By vatRate5RadioBtn = By.xpath("//*[@for='VAT_5']");
    private By vatRate8RadioBtn = By.xpath("//*[@for='VAT_8']");
    private By vatRate10RadioBtn = By.xpath("//*[@for='VAT_10']");

    private By priceWithoutVatField = By.id("NetPrice");
    private By priceInclVatField = By.id("Price");

    private By priceWithoutVatRadioBtn = By.xpath("//label[text()='Price without VAT']");
    private By priceInclVatRadioBtn = By.xpath("//label[text()='Price incl. VAT']");

    public ValueAddedTaxCalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void giveConsent() {
        driver.findElement(consentBtn).click();
    }

    public void selectFromDropDown(String option) {
        findDropDownElement().selectByVisibleText(option);
    }

    private Select findDropDownElement() {
        return new Select(driver.findElement(countryDropDown));
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public WebElement scrollToWebElementJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    public void selectVat8Rate() {
        scrollToWebElementJS(driver.findElement(vatRate5RadioBtn));
        try {
            if (driver.findElement(vatRate8RadioBtn).isDisplayed()) {
                driver.findElement(vatRate8RadioBtn).click();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Unable to select VAT rate" + e.getMessage());
        }
    }

    public void addPriceInclVat(String price) {
        try {
            if (driver.findElement(priceInclVatRadioBtn).isDisplayed()) {
                driver.findElement(priceInclVatRadioBtn).click();
                driver.findElement(priceInclVatField).clear();
                driver.findElement(priceInclVatField).sendKeys(price);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Unable to add price" + e.getMessage());
        }
    }

    public String getPriceWithoutVat() {
        scrollToWebElementJS(driver.findElement(priceWithoutVatRadioBtn));
        driver.findElement(priceWithoutVatRadioBtn).click();
        return driver.findElement(priceWithoutVatField).getText();
    }

    public void selectVat10Rate() {
        scrollToWebElementJS(driver.findElement(vatRate10RadioBtn));
        try {
            if (driver.findElement(vatRate10RadioBtn).isDisplayed()) {
                driver.findElement(vatRate10RadioBtn).click();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Unable to select VAT rate" + e.getMessage());
        }
    }

    public void addPriceWithoutVat(String price) {
        try {
            if (driver.findElement(priceWithoutVatRadioBtn).isDisplayed()) {
                driver.findElement(priceWithoutVatRadioBtn).click();
                driver.findElement(priceWithoutVatField).clear();
                driver.findElement(priceWithoutVatField).sendKeys(price);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Unable to add price" + e.getMessage());
        }
    }

    public String getPriceInclVat() {
        scrollToWebElementJS(driver.findElement(priceInclVatRadioBtn));
        driver.findElement(priceInclVatRadioBtn).click();
        return driver.findElement(priceInclVatField).getText();
    }
}
