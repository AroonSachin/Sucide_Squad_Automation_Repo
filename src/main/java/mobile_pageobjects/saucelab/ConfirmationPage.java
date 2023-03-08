package mobile_pageobjects.saucelab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonuseractions.CommonActionMethods;
import commonuseractions.CommonVariables;

/**
 * @this class is used to validate and remove the product and also checks for
 *       order confirmation
 * @author svenkateshwaran
 *
 */
public class ConfirmationPage extends CommonActionMethods {
	public ConfirmationPage() throws Exception {
		try {
			PageFactory.initElements((appDriver), this);
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
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Delete']//android.widget.TextView")
	WebElement productRemove;

	@CacheLookup
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-FINISH\"]")
	WebElement finishButton;

	@CacheLookup
	@FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]")
	WebElement orderConfirmation;

	/**
	 * @this method is used to validate and remove the product
	 * @throws Exception
	 */

	public void productDetailsValidation() throws Exception {
		webWait(product1Details);
		checkEquality(CommonVariables.getItem1(), getTextElement(product1Details, " Product 1 heading "));
		checkEquality(CommonVariables.getItem2(), getTextElement(product2Details, " Product 2 heading "));
		swipeElement(product2Details, "Left");
		clickMethod(productRemove, "Delete button");
		swipeElement(product1Details, "Left");
		appDriver
				.findElement(By.xpath("//android.view.ViewGroup[@content-desc='test-Delete']//android.widget.TextView"))
				.click();
		swipeUp();
		clickMethod(finishButton, "Finish");
	}

	/**
	 * @Method To confirm order placement.
	 * @throws Exception
	 */
	public void validateConfirmation() throws Exception {
		webWait(orderConfirmation);
		checkEquality(getTextElement(orderConfirmation, " OrderConfirmation text "), "THANK YOU FOR YOU ORDER");
	}

}
