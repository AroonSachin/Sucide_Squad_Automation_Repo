package mobile_pageobjects.swaglab;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonuseractions.CommonActionMethods;

/**
 * @this class is used to validate the product title in cart
 * @author svenkateshwaran
 *
 */
public class ProductPage extends CommonActionMethods {
	public ProductPage() throws Exception {
		try {
			PageFactory.initElements((appdriver), this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@CacheLookup
	@FindBy(xpath = "((//android.view.ViewGroup[@content-desc='test-Description'])[1]//android.widget.TextView)[1]")
	WebElement product1Title;

	@CacheLookup
	@FindBy(xpath = "((//android.view.ViewGroup[@content-desc='test-Description'])[2]//android.widget.TextView)[1]")
	WebElement product2Title;

	@CacheLookup
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CHECKOUT']")
	WebElement checkOutButton;

	/**
	 * @this method is used to validate the product title
	 * @throws Exception
	 */
	public void productValidation() throws Exception {
		webWait(product1Title);
		checkEquality(HomePage.item1, getTextElement(product1Title, " Product 1 heading "));
		checkEquality(HomePage.item2, getTextElement(product2Title, " Product 2 heading "));
		Thread.sleep(2000);
		swipeUp();
		logMessage(" Element not in view, Scrolling up ");
		clickMethod(checkOutButton, " Checkout button ");

	}

}
