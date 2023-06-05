package pageobjects.swaglabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonuseractions.CommonActionMethods;
import io.qameta.allure.Step;
import utils.DriverFactory;

/**
 *
 * @author svenkateshwaran
 * @this class contains methods of info page
 */
public class InfoPage extends CommonActionMethods {

	@FindBy(id = "checkout")
	WebElement checkout;


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
	@Step("To info details are given")
	public void info() throws Exception {
		sendKeysMethod(firstName, "Sowmya");
		sendKeysMethod(lastName, "Venkateshwaran");
		sendKeysMethod(PinCode, "621714");
	}
	@Step("To click a continue button")
	public void clickContinue() throws Exception
	{

		clickMethod(continueButton, "continue");

	}

}
