package pageobjects.swaglabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

public class LoginPage extends CommonActionMethods {

	public LoginPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	@FindBy(id = "user-name")
	private static WebElement userName;
	@FindBy(id = "password")
	private static WebElement passWord;
	@FindBy(id = "login-button")
	private static WebElement loginButton;

	public void enterUsername() throws Exception {

		sendKeysMethod(userName, getdata("Username"));

	}

	public void enterPassword() throws Exception {

		sendKeysMethod(passWord, getdata("Password"));

	}

	public void clickLogin() throws Exception {
		clickMethod(loginButton, "login");

	}

}
