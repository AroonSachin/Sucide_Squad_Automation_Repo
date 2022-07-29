package pageobjects.swaglabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

public class Info extends CommonActionMethods {

	public Info() {
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

	public void enterFirstName() throws Exception {
		sendKeysMethod(firstName, getdata("FirstName"));

	}

	public void enterLastName() throws Exception {
		sendKeysMethod(lastName, getdata("LastName"));

	}

	public void enterPincode() throws Exception {
		sendKeysMethod(PinCode, getdata("Pincode"));

	}

	public void clickContinueButton() throws Exception {
		clickMethod(continueButton, "continue");

	}

}
