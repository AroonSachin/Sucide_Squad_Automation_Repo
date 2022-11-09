package mobile_pageobjects.eribank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import commonuseractions.CommonActionMethods;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Login_Page extends CommonActionMethods {
	
	static String dollar=null;
	
	
	@AndroidFindBy(id = "android:id/button1")
	static WebElement popup;

	@AndroidFindBy(id = "com.experitest.ExperiBank:id/usernameTextField")
	static WebElement user;

	@AndroidFindBy(id = "com.experitest.ExperiBank:id/passwordTextField")
	static WebElement pass;

	@AndroidFindBy(id = "com.experitest.ExperiBank:id/loginButton")
	static WebElement sigin;

	public Login_Page() throws Exception {
		System.out.println("Appium driver is ------" + appiumdriver);
		try {
			PageFactory.initElements(new AppiumFieldDecorator(appiumdriver), this);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" Page Factory failed: " + e);
		}
	}
		
		
	public static void login() throws Exception {
		
		/*
		 * WebElement popupbutton =
		 * appiumdriver.findElement(By.id("android:id/button1")); popupbutton.click();
		 * logMessage("popup is clicked"); WebElement username =
		 * appiumdriver.findElement(By.id(
		 * "com.experitest.ExperiBank:id/usernameTextField"));
		 * username.sendKeys("company"); logMessage("user name is entered"); WebElement
		 * password = appiumdriver.findElement(By.id(
		 * "com.experitest.ExperiBank:id/passwordTextField"));
		 * password.sendKeys("company"); logMessage("password is entered"); WebElement
		 * login =
		 * appiumdriver.findElement(By.id("com.experitest.ExperiBank:id/loginButton"));
		 * login.click(); logMessage("login button is clicked"); WebElement totalamount
		 * = appiumdriver.findElement(By.id(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View"
		 * )); dollar=getTextElement(totalamount,
		 * "balanceamount").replace("Your balance is: ", "").replace("$", "");
		 * WebElement makepayment = appiumdriver.findElement(By.id(
		 * "com.experitest.ExperiBank:id/makePaymentButton")); makepayment.click();
		 * logMessage("make payment button is clicked");
		 */
			 
		Thread.sleep(10000); 
		clickMethod(popup, "popup");
		sendKeysMethod(user, "company");
		sendKeysMethod(pass, "company");
		clickMethod(sigin, "sigin");
		
	}
	
	

}
