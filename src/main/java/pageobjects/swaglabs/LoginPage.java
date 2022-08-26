package pageobjects.swaglabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

/**
 * 
 * @author svenkateshwaran
 * @this class is to log in into the application
 *
 */

public class LoginPage extends CommonActionMethods {

	public LoginPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	@FindBy(id = "user-name")
	WebElement userName;
	@FindBy(id = "password")
	WebElement passWord;
	@FindBy(id = "login-button")
	WebElement loginButton;

	public void enterUsername() throws Exception {

		sendKeysMethod(userName, getdata("Username"));

	}

	public void enterPassword() throws Exception {

		sendKeysMethod(passWord, getdata("Password"));

	}

	/**
	 * @this method is used to enter the login credentials and login to the
	 *       application
	 * @throws Exception
	 */

	public void login() throws Exception {

		sendKeysMethod(userName, getdata("Username"));
		sendKeysMethod(passWord, getdata("Password"));

		clickMethod(loginButton, "login");

	}

}
