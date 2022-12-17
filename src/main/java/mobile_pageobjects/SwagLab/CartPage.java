package mobile_pageobjects.SwagLab;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonuseractions.CommonActionMethods;

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
	
	public CartPage() {
		PageFactory.initElements(appDriver, this);
	}
	
	public void productValidation() throws Exception {
		webWait(product1Head);
		checkEquality(Products_Page.product1Name, getTextElement(product1Head, " Product 1 heading "));
		checkEquality(Products_Page.product2Name, getTextElement(product2Head, " Product 2 heading "));
		Thread.sleep(2000);
		swipeUp();
		logMessage(" Element not in view, Scrolling up ");
		clickMethod(checkOutButton, " Checkout Button ");
		
	}
	

}
