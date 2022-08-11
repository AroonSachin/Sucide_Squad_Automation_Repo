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

	public InfoPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	@FindBy(id = "first-name")
	private static WebElement firstName;

	@FindBy(id = "last-name")
	private static WebElement lastName;

	@FindBy(id = "postal-code")
	private static WebElement PinCode;

	@FindBy(id = "continue")
	private static WebElement continueButton;

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
