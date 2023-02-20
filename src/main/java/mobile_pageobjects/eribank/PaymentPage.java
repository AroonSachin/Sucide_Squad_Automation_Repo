package mobile_pageobjects.eribank;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import commonuseractions.CommonActionMethods;
import commonuseractions.CommonVariables;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PaymentPage extends CommonActionMethods {
	
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

	@AndroidFindBy(id = "com.experitest.ExperiBank:id/sendPaymentButton")
	@CacheLookup
	WebElement sendpayment;

	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	WebElement conformpayment;

	@AndroidFindBy(xpath="//android.view.View[contains(@text,'Your balance is: ')]")
	@CacheLookup
	WebElement totalbalance;
	
	@AndroidFindBy(xpath = "//android.widget.ListView[@resource-id='com.experitest.ExperiBank:id/countryList']//android.widget.TextView[@text='Canada']")
	@CacheLookup
	WebElement countrycanada;
	

	public PaymentPage()  {
			PageFactory.initElements(new AppiumFieldDecorator(appDriver), this);
	}

	public void payment() throws Exception {
		webWait(phonenumber);
		sendKeysMethod(phonenumber, getdata("Phone"));
		sendKeysMethod(customername, getdata("Name"));
		Actions amntslider = new Actions(appDriver);
		amntslider.dragAndDropBy(amountslider, 100, 0).perform();
		CommonVariables.setSliderdollar(getTextElement(slideramount, "balance").replace("Amount (", "").replace("$)", "")); 
		clickMethod(country, "country");
	    swipeUpToElement(countrycanada, "countrycanada","click",null);
		clickMethod(sendpayment, "sendpayment");
		clickMethod(conformpayment, "conformpayment");
		webWait(totalbalance);
		totalbal = getTextElement(totalbalance, "balance").replace("Your balance is: ", "").replace("$", "");
		double actualamount = Double.valueOf(CommonVariables.getDollar()) - Double.valueOf(CommonVariables.getSliderdollar());
		checkEquality(actualamount, Double.valueOf(totalbal));

	}
}