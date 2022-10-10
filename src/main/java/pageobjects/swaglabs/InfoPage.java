package pageobjects.swaglabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

/**
 *
 * @author svenkateshwaran
 * @this class contains methods of info page
 */
public class InfoPage extends CommonActionMethods {



	@FindBy(id = "first-name")
	WebElement firstName;

	@FindBy(id = "last-name")
	WebElement lastName;

	@FindBy(id = "postal-code")
	WebElement PinCode;

	@FindBy(id = "continue")
	WebElement continueButton;

	public InfoPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	/**
	 * @this method is used to fill the user info
	 * @throws Exception
	 */
	public void info() throws Exception {
		sendKeysMethod(firstName, getdata("FirstName"));
		sendKeysMethod(lastName, getdata("LastName"));
		sendKeysMethod(PinCode, getdata("Pincode"));

		clickMethod(continueButton, "continue");

	}

}
