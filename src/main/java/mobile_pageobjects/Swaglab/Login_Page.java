package mobile_pageobjects.Swaglab;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonuseractions.CommonActionMethods;

/**
 * @Class To automate login page.
 * @author amaduraiveeran
 *
 */
public class Login_Page extends CommonActionMethods{
	
	@CacheLookup
	@FindBy(xpath =  "//android.widget.EditText[@content-desc=\"test-Username\"]")
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
	
	public Login_Page() {
		PageFactory.initElements(appDriver, this);
	}
	
	/**
	 * @Method  To Login.
	 * @throws Exception
	 */
	public void logIn() throws Exception {
		webWait(userName);
		sendKeysMethod(userName, getdata("UserName"));
		sendKeysMethod(passWord, getdata("PassWord"));
		clickMethod(loginButton," Login button ");
	}
	
	/**
	 * @Method tTo validate Login.
	 * @throws Exception
	 */
	public void loginValidation() throws Exception {
		webWait(hamburgerButton);
		clickMethod(hamburgerButton, "Hamburger button ");
		webWait(logOutButton);
		if(isElementPresent(logOutButton)) {
			logMessage("LogIn Successfull");
		}else {
			logErrorMessage("Login Failed");
		}
		clickMethod(closeButton, " Close button ");
		
	}

}
