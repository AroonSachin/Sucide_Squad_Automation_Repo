package mobile_pageobjects.saucelab;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonuseractions.CommonActionMethods;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * @this class is used to login the user to the application
 * @author svenkateshwaran
 *
 */
public class LoginPage extends CommonActionMethods {

	public LoginPage() throws Exception {
		try {
			PageFactory.initElements((appDriver), this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@CacheLookup
	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
	WebElement userName;

	@CacheLookup
	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
	WebElement passWord;

	@CacheLookup
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
	WebElement loginButton;

	@CacheLookup
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")
	WebElement hamburgerButton;

	@CacheLookup
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-LOGOUT']")
	WebElement logOutButton;

	@CacheLookup
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Close\"]/android.widget.ImageView")
	WebElement closeButton;

	@CacheLookup
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]")
	WebElement LoginErrorMessage;

	/**
	 * @this method is used to login the user to the application
	 * @throws Exception
	 */
	public void login() throws Exception {
		webWait(hamburgerButton);
		clickMethod(hamburgerButton, "hamburger");
		webWait(logOutButton);
		clickMethod(logOutButton, "Log out");
		webWait(userName);
		sendKeysMethod(userName, getdata("Username"));
		sendKeysMethod(passWord, getdata("Password"));
		clickMethod(loginButton, " Login button ");
	}

	/**
	 * @this method is to validate the login functionality
	 * @throws Exception
	 */
	public void loginValidation() throws Exception {
		webWait(userName);
		sendKeysMethod(userName, getdata("Username"));
		sendKeysMethod(passWord, getdata("Password"));
		clickMethod(loginButton, "Login button ");
		if (isElementPresent(LoginErrorMessage)) {
			logMessage("Login failed");
		} else {
			logMessage("Logged in successfully");
		}
	}

	/**
	 * @this method is used to validate the login page
	 * @throws Exception
	 */
	public void loginPageValidation() throws Exception {
		webWait(hamburgerButton);
		clickMethod(hamburgerButton, "Hamburger button ");
		webWait(logOutButton);
		if (isElementPresent(logOutButton)) {
			logMessage("LogIn Successfull");
		} else {
			logErrorMessage("Login Failed");
		}
		clickMethod(closeButton, " Close button ");

	}
}
