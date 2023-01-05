package mobile_pageobjects.Swaglab;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import commonuseractions.CommonActionMethods;

/**
 * @Class To Input Checkout details and click on Continue button. 
 * @author amaduraiveeran
 *
 */
public class CheckOutInfoPage extends CommonActionMethods {
	
	@CacheLookup
	@FindBy(xpath = "//android.widget.EditText[@content-desc='test-First Name']")
	WebElement firstName;
	
	@CacheLookup
	@FindBy(xpath = "//android.widget.EditText[@content-desc='test-Last Name']")
	WebElement lastName;
	
	@CacheLookup
	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]")
	WebElement zipCode;
	
	@CacheLookup
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CONTINUE']")
	WebElement continueButton;
	
	public CheckOutInfoPage() {
		PageFactory.initElements(appDriver, this);
	}

	/**
	 * @Method To Inout Checkout details and click on Continue button.
	 * @throws Exception
	 */
	public void inputInformation() throws Exception {
		Faker fake = new Faker();
		sendKeysMethod(firstName,fake.name().firstName());
		sendKeysMethod(lastName,fake.name().lastName());
		sendKeysMethod(zipCode, fake.address().zipCode());
		swipeUpToElement(continueButton, " continue button ", "click","");
	}
	
}
