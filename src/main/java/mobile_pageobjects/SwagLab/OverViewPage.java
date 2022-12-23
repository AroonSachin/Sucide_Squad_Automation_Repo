package mobile_pageobjects.SwagLab;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonuseractions.CommonActionMethods;

/**
 * @Class To Validate Product name , price and Total price then click on finnish button. 
 * @author amaduraiveeran
 *
 */
public class OverViewPage extends CommonActionMethods {
	
	@CacheLookup
	@FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-Description\"])[1]")
	WebElement product1Description;
	
	@CacheLookup
	@FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-Description\"])[2]")
	WebElement product2Description;
	
	@CacheLookup
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-FINISH\"]")
	WebElement finishButton;
	
	@CacheLookup
	@FindBy(xpath = "(//android.view.ViewGroup[@content-desc='test-Price'])[1]/android.widget.TextView")
	WebElement cartProd1Price;
	
	@CacheLookup
	@FindBy(xpath = "(//android.view.ViewGroup[@content-desc='test-Price'])[2]/android.widget.TextView")
	WebElement cartProd2Price;
	
	@CacheLookup
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Item total')]")
	WebElement itemTotal;
	
	@CacheLookup
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Tax')]")
	WebElement tax;
	
	@CacheLookup
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Total')]")
	WebElement totalPrice;
	
	public OverViewPage() {
		PageFactory.initElements(appDriver, this);
	}
	
	/**
	 * @method Validates Product name and price then clicks the Finish button.
	 * @throws Exception
	 */
	public void overViewValidation() throws Exception {
		webWait(product1Description);
		checkEquality(Products_Page.product1Name, getTextElement(product1Description, " Product 1 heading "));
		checkEquality(Products_Page.product2Name, getTextElement(product2Description, " Product 2 heading "));
		checkEquality(Double.valueOf(getTextElement(cartProd1Price, " Product 1 price ").replace("$","")), Products_Page.product1Pricevalue);
		swipeUpToElement(cartProd2Price, " Product 2 ", null, null);
		checkEquality(Double.valueOf(getTextElement(cartProd2Price, " Product 2 price ").replace("$","")), Products_Page.product2Pricevalue);
		swipeUpToElement(itemTotal, " Ite total ", null, null);
		checkEquality(Double.valueOf(getTextElement(itemTotal, " Item total ").replace("Item total: $", "")), (Products_Page.product1Pricevalue+Products_Page.product2Pricevalue));
		checkEquality((Double.valueOf(getTextElement(tax, " Tax ").replace("Tax: $", ""))+Double.valueOf(getTextElement(itemTotal, " Item total ").replace("Item total: $", ""))), Double.valueOf(getTextElement(totalPrice, " Item total ").replace("Total: $", "")));
		swipeUp();
		swipeUpToElement(finishButton, "Finish button ", "click","");
	}
}
