package mobile_pageobjects.eribank;
import java.util.List;
import org.openqa.selenium.Dimension;
import java.time.Duration;
import java.util.Arrays;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import commonuseractions.CommonActionMethods;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Payment_Page extends CommonActionMethods {
	static String sliderdollar = null;
	static String totalbal = null;
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
	

	public Payment_Page() throws Exception {
		try {
			PageFactory.initElements(new AppiumFieldDecorator(appiumdriver), this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void payment() throws Exception {
		webWait(phonenumber);
		sendKeysMethod(phonenumber, "9858153885");
		sendKeysMethod(customername, "venkatesh");
		Actions amntslider = new Actions(appiumdriver);
		amntslider.dragAndDropBy(amountslider, 100, 0).perform();
		sliderdollar = getTextElement(slideramount, "balance").replace("Amount (", "").replace("$)", "");
		clickMethod(country, "country");
	    swipeUp(countrycanada, "canadacity");
		clickMethod(sendpayment, "sendpayment");
		clickMethod(confrompayment, "confrompayment");
		webWait(totalbalance);
		//Thread.sleep(7000);
		totalbal = getTextElement(totalbalance, "balance").replace("Your balance is: ", "").replace("$", "");
		double actualamount = Double.valueOf(Login_Page.dollar) - Double.valueOf(Payment_Page.sliderdollar);
		checkEquality(actualamount, Double.valueOf(totalbal));

	}
	public void swipeUp(WebElement element, String name) throws Exception {
		while (true) {
			System.out.println(element);
			if (isElementPresent(element)==false) {
				Dimension windowSize = appiumdriver.manage().window().getSize();
				System.out.println(windowSize);
				PointerInput finger = new PointerInput(org.openqa.selenium.interactions.PointerInput.Kind.TOUCH,
						"finger");
				Sequence swipeUp = new Sequence(finger, 1);
				swipeUp.addAction(finger.createPointerMove(Duration.ZERO, Origin.viewport(), windowSize.width / 2,
						windowSize.height / 2)).addAction(finger.createPointerDown(MouseButton.LEFT.asArg()))
						.addAction(finger.createPointerMove(Duration.ofMillis(700), Origin.viewport(),
								windowSize.height / 2, windowSize.height / 2 - windowSize.height / 2))
						.addAction(finger.createPointerUp(MouseButton.LEFT.asArg()));
				appiumdriver.perform(Arrays.asList(swipeUp));
				logMessage(" Element not in view, Scrolling up ");
			} else if (isElementPresent(element)==true) {
				clickMethod(element, name);
				logMessage("Element is in view ");
				break;
			}
		}
	}

	public boolean isElementPresent(WebElement element) {

		boolean flag = true;
		try {
			logMessage(" presence of Element is "+String.valueOf(element.isDisplayed()));
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
}