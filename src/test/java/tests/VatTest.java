package tests;

import base.Base;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class VatTest extends Base {
    @Test
    public void verifyPageTitle() {
        valueAddedTaxCalculatorPage.giveConsent();
        assertEquals("Value-Added Tax (VAT) Calculator", valueAddedTaxCalculatorPage.getPageTitle());
    }

    @Test
    public void verifyPriceIncludingVat() {
        valueAddedTaxCalculatorPage.giveConsent();
        valueAddedTaxCalculatorPage.selectFromDropDown("Poland");
        valueAddedTaxCalculatorPage.selectVat8Rate();
        valueAddedTaxCalculatorPage.addPriceInclVat("1000");
        assertEquals("920", valueAddedTaxCalculatorPage.getPriceWithoutVat());
    }

    @Test
    public void verifyPriceWithoutVat() {
        valueAddedTaxCalculatorPage.giveConsent();
        valueAddedTaxCalculatorPage.selectFromDropDown("Spain");
        valueAddedTaxCalculatorPage.selectVat10Rate();
        valueAddedTaxCalculatorPage.addPriceWithoutVat("1000");
        //6Thread.sleep(5000);
        assertEquals("1100", valueAddedTaxCalculatorPage.getPriceInclVat());
    }
}
