package mobile_pageobjects.swaglab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import commonuseractions.CommonActionMethods;
import io.appium.java_client.MobileBy;

/**
 * @this class used to input the user information
 * @author svenkateshwaran
 *
 */
public class InfoPage extends CommonActionMethods {
	public InfoPage() throws Exception {
		try {
			PageFactory.initElements((appdriver), this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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

	/**
	 * @this method is used to input the user information
	 * @throws Exception
	 */

	public void Info() throws Exception {
		Faker fake = new Faker();
		sendKeysMethod(firstName, fake.name().firstName());
		sendKeysMethod(lastName, fake.name().lastName());
		sendKeysMethod(zipCode, fake.address().zipCode());
		swipeUpToElement(continueButton, " continue button ", "click", "");
	}
}
