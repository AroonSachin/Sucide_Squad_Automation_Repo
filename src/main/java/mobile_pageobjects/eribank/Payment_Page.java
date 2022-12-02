package mobile_pageobjects.eribank;

import java.awt.Dimension;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import commonuseractions.CommonActionMethods;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utils.DriverFactory;

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
	
	@AndroidFindBy(id="com.experitest.ExperiBank:id/countryList")
	@CacheLookup
	WebElement countryscroll;
	
	

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
	    swipeScreen(Direction.UP);
		listDrop(countryselect, "India");
		clickMethod(sendpayment, "sendpayment");
		clickMethod(confrompayment, "confrompayment");
		webWait(totalbalance);
		totalbal = getTextElement(totalbalance, "balance").replace("Your balance is: ", "").replace("$", "");
		double actualamount = Double.valueOf(Login_Page.dollar) - Double.valueOf(Payment_Page.sliderdollar);
		checkEquality(actualamount, Double.valueOf(totalbal));

	}
	
	/**
	 * Performs swipe from the center of screen
	 *
	 * @param dir the direction of swipe
	 * @version java-client: 7.3.0
	 **/
	public void swipeScreen(Direction dir) {
	    System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

	    // Animation default time:
	    //  - Android: 300 ms
	    //  - iOS: 200 ms
	    // final value depends on your app and could be greater
	    final int ANIMATION_TIME = 300; // ms

	    final int PRESS_TIME = 200; // ms

	    int edgeBorder = 10; // better avoid edges
	    PointOption pointOptionStart, pointOptionEnd;

	    // init screen variables
	    org.openqa.selenium.Dimension dims = appiumdriver.manage().window().getSize();

	    // init start point = center of screen
	    pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

	    switch (dir) {
	        case DOWN: // center of footer
	            pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
	            break;
	        case UP: // center of header
	            pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
	            break;
	        case LEFT: // center of left side
	            pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
	            break;
	        case RIGHT: // center of right side
	            pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
	            break;
	        default:
	            throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
	    }

	    // execute swipe using TouchAction
	    try {
	        new TouchAction(appiumdriver)
	                .press(pointOptionStart)
	                // a bit more reliable when we add small wait
	                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
	                .moveTo(pointOptionEnd)
	                .release().perform();
	    } catch (Exception e) {
	        System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
	        return;
	    }

	    // always allow swipe action to complete
	    try {
	        Thread.sleep(ANIMATION_TIME);
	    } catch (InterruptedException e) {
	        // ignore
	    }
	}

	public enum Direction {
	    UP,
	    DOWN,
	    LEFT,
	    RIGHT;
	}

}
