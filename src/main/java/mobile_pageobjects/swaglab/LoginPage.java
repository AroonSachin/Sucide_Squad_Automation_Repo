package mobile_pageobjects.swaglab;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonuseractions.CommonActionMethods;
import io.appium.java_client.AppiumDriver;

public class LoginPage extends CommonActionMethods{
	
	@FindBy(id = "com.saucelabs.mydemoapp.android:id/menuIV")
	@CacheLookup
	static WebElement hamburgerButton;
	
	@FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc=\\\"Recycler view for menu\\\"]/android.view.ViewGroup[12]/android.widget.TextView")
	@CacheLookup
	static WebElement loginOption;
	
	@FindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
	@CacheLookup
	static WebElement username;
	
	@FindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
	@CacheLookup
	static WebElement password;
	
	@FindBy(id = "com.saucelabs.mydemoapp.android:id/loginBtn")
	@CacheLookup
	static WebElement loginButton;
	
	public LoginPage()
	{
		PageFactory.initElements(appdriver, Duration.ofSeconds(15));
	}
	
	public static void login() throws Exception
	{
		
	    sendKeysMethod(username, "bod@example.com");
	    
	    sendKeysMethod(password, "10203040");
	    
	    clickMethod(loginButton, "Login button");
	}


}
