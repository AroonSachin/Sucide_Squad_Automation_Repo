package mobile_pageobjects.eribank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import commonuseractions.CommonActionMethods;
import commonuseractions.CommonVariables;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends CommonActionMethods {


	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	WebElement popup;

	@AndroidFindBy(id = "com.experitest.ExperiBank:id/usernameTextField")
	@CacheLookup
	WebElement user;

	@AndroidFindBy(id = "com.experitest.ExperiBank:id/passwordTextField")
	@CacheLookup
	WebElement pass;

	@AndroidFindBy(id = "com.experitest.ExperiBank:id/loginButton")
	@CacheLookup
	WebElement sigin;

	@AndroidFindBy(id = "com.experitest.ExperiBank:id/makePaymentButton")
	@CacheLookup
	WebElement makepayment;

	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'Your balance is: ')]")
	@CacheLookup
	WebElement totalamount;

	public LoginPage() {
		
			PageFactory.initElements(new AppiumFieldDecorator(appDriver), this);
	}

	public void login() throws Exception {
		webWait(popup);
		clickMethod(popup, "popup");
		sendKeysMethod(user, getdata("Username"));
		sendKeysMethod(pass, getdata("Password"));
		clickMethod(sigin, "sigin");
		webWait(totalamount);
		CommonVariables.setDollar(getTextElement(totalamount, "totalamount").replace("Your balance is: ", "").replace("$", "")); 
		clickMethod(makepayment, "makepayment");

	}

}
