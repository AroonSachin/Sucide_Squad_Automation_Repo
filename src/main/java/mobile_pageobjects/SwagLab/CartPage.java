package mobile_pageobjects.SwagLab;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonuseractions.CommonActionMethods;

/**
 * @Class To Validate the products in the cart and click on checkout button.
 * @author amaduraiveeran
 *
 */
public class CartPage extends CommonActionMethods {
	
	@CacheLookup
	@FindBy(xpath = "((//android.view.ViewGroup[@content-desc='test-Description'])[1]//android.widget.TextView)[1]")
	WebElement product1Head;
	
	@CacheLookup
	@FindBy(xpath = "((//android.view.ViewGroup[@content-desc='test-Description'])[2]//android.widget.TextView)[1]")
	WebElement product2Head;
	
	@CacheLookup
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CHECKOUT']")
	WebElement checkOutButton;
	
	@CacheLookup
	@FindBy(xpath = "(//android.view.ViewGroup[@content-desc='test-Price'])[1]/android.widget.TextView")
	WebElement cartProd1Price;
	
	@CacheLookup
	@FindBy(xpath = "(//android.view.ViewGroup[@content-desc='test-Price'])[2]/android.widget.TextView")
	WebElement cartProd2Price;
	
	public CartPage() {
		PageFactory.initElements(appDriver, this);
	}
	
	/**
	 * @Method Validates Product price and name then clicks Checkout button.
	 * @throws Exception
	 */
	public void productValidation() throws Exception {
		webWait(product1Head);
		checkEquality(Products_Page.product1Name, getTextElement(product1Head, " Product 1 heading "));
		checkEquality(Products_Page.product2Name, getTextElement(product2Head, " Product 2 heading "));
		checkEquality(Double.valueOf(getTextElement(cartProd1Price, " Product 1 price ").replace("$","")), Products_Page.product1Pricevalue);
		swipeUpToElement(cartProd2Price, " Product 2 ", null, null);
		checkEquality(Double.valueOf(getTextElement(cartProd2Price, " Product 2 price ").replace("$","")), Products_Page.product2Pricevalue);
		Thread.sleep(2000);
		swipeUp();
		logMessage(" Element not in view, Scrolling up ");
		clickMethod(checkOutButton, " Checkout Button ");
		
	}
	

}
