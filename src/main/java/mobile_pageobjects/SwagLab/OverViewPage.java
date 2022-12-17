package mobile_pageobjects.SwagLab;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonuseractions.CommonActionMethods;

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
	
	public OverViewPage() {
		PageFactory.initElements(appDriver, this);
	}
	
	public void overViewValidation() throws Exception {
		webWait(product1Description);
		checkEquality(Products_Page.product1Name, getTextElement(product1Description, " Product 1 heading "));
		checkEquality(Products_Page.product2Name, getTextElement(product2Description, " Product 2 heading "));
		swipeUp();
		swipeUpToElement(finishButton, "Finish button ", "click","");
	}

}
