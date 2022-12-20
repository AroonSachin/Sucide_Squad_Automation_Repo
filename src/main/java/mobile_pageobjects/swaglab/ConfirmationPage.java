package mobile_pageobjects.swaglab;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonuseractions.CommonActionMethods;

public class ConfirmationPage extends CommonActionMethods {	
	public ConfirmationPage() throws Exception {
		try {
			PageFactory.initElements((appdriver), this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@CacheLookup
	@FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-Description\"])[1]")
	WebElement product1Details;
	
	@CacheLookup
	@FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-Description\"])[2]")
	WebElement product2Details;
	
	@CacheLookup
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-FINISH\"]")
	WebElement finishButton;
	
	@CacheLookup
	@FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]")
	WebElement orderConfirmation;
	
	
	public void productDetailsValidation() throws Exception {
		webWait(product1Details);
		checkEquality(HomePage.item1, getTextElement(product1Details, " Product 1 heading "));
		checkEquality(HomePage.item2, getTextElement(product2Details, " Product 2 heading "));
		swipeUp();
		swipeUpToElement(finishButton, "Finish button ", "click","");
	}
		
		public void validateConfirmation() throws Exception {
			webWait(orderConfirmation);
			checkEquality(getTextElement(orderConfirmation, " OrderConfirmation text "), "THANK YOU FOR YOU ORDER");
		}
	

}
