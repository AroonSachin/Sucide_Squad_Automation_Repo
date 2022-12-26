package mobile_pageobjects.SwagLab;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonuseractions.CommonActionMethods;

/**
 * @Class To Confirm order completion.
 * @author amaduraiveeran
 *
 */
public class CheckOutCompletePage extends CommonActionMethods {

	@CacheLookup
	@FindBy(xpath = "//android.widget.ScrollView[@content-desc='test-CHECKOUT: COMPLETE!']/android.view.ViewGroup/android.widget.TextView[1]")
	WebElement orderConfirmation;
	
	public CheckOutCompletePage() {
		PageFactory.initElements(appDriver, this);
	}
	
	/**
	 * @Method To Confirm order placement.
	 * @throws Exception
	 */
	public void orderValidation() throws Exception {
		webWait(orderConfirmation);
		checkEquality(getTextElement(orderConfirmation, " OrderConfirmation text "), "THANK YOU FOR YOU ORDER");
	}
	
}
