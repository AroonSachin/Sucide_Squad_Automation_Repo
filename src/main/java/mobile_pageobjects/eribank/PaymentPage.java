package mobile_pageobjects.eribank;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import commonuseractions.CommonActionMethods;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PaymentPage extends CommonActionMethods {
	 public static String sliderdollar = null;
     String totalbal = null;
	 String name=null;

	@AndroidFindBy(id = "com.experitest.ExperiBank:id/phoneTextField")
	@CacheLookup
	WebElement phonenumber;

	@AndroidFindBy(id = "com.experitest.ExperiBank:id/nameTextField")
	@CacheLookup
	WebElement customername;

	@AndroidFindBy(id = "com.experitest.ExperiBank:id/amount")
	@CacheLookup
	WebElement amountslider;

	@AndroidFindBy(id = "com.experitest.ExperiBank:id/amountLabel")
	@CacheLookup
	WebElement slideramount;

	@AndroidFindBy(id = "com.experitest.ExperiBank:id/countryButton")
	@CacheLookup
	WebElement country;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView")
	@CacheLookup
	List<WebElement> countryselect;

	@AndroidFindBy(id = "com.experitest.ExperiBank:id/sendPaymentButton")
	@CacheLookup
	WebElement sendpayment;

	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	WebElement confrompayment;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View")
	@CacheLookup
	WebElement totalbalance;
	
	@AndroidFindBy(xpath = "//android.widget.ListView[@resource-id='com.experitest.ExperiBank:id/countryList']//android.widget.TextView[@text='Canada']")
	@CacheLookup
	WebElement countrycanada;
	

	public PaymentPage()  {
			PageFactory.initElements(new AppiumFieldDecorator(appiumdriver), this);
	}

	public void payment() throws Exception {
		webWait(phonenumber);
		sendKeysMethod(phonenumber, "9858153885");
		sendKeysMethod(customername, "venkatesh");
		Actions amntslider = new Actions(appiumdriver);
		amntslider.dragAndDropBy(amountslider, 100, 0).perform();
		sliderdollar = getTextElement(slideramount, "balance").replace("Amount (", "").replace("$)", "");
		clickMethod(country, "country");
	    swipeUp(countrycanada, "canadacity",true);
		clickMethod(sendpayment, "sendpayment");
		clickMethod(confrompayment, "confrompayment");
		webWait(totalbalance);
		totalbal = getTextElement(totalbalance, "balance").replace("Your balance is: ", "").replace("$", "");
		double actualamount = Double.valueOf(LoginPage.dollar) - Double.valueOf(PaymentPage.sliderdollar);
		checkEquality(actualamount, Double.valueOf(totalbal));

	}
}