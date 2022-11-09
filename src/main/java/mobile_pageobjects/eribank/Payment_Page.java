package mobile_pageobjects.eribank;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import commonuseractions.CommonActionMethods;


public class Payment_Page extends CommonActionMethods {
	
	static String sliderdollar=null;
	static String totalbal=null;
	/*
	 * @AndroidFindBy(id="com.experitest.ExperiBank:id/phoneTextField") WebElement
	 * phonenumber;
	 * 
	 * @AndroidFindBy(id="com.experitest.ExperiBank:id/nameTextField") WebElement
	 * name;
	 * 
	 * @AndroidFindBy(id="com.experitest.ExperiBank:id/amount") WebElement
	 * amountslider;
	 * 
	 * @AndroidFindBy(id="com.experitest.ExperiBank:id/countryButton") WebElement
	 * country;
	 * 
	 * @AndroidFindBy(id="com.experitest.ExperiBank:id/sendPaymentButton")
	 * WebElement sendpayment;
	 * 
	 * @AndroidFindBy(id="android:id/button1") WebElement confrompayment;
	 */
	
	public static void payment() throws Exception  {
		WebElement mobilenumber = appiumdriver.findElement(By.id("com.experitest.ExperiBank:id/phoneTextField"));
		mobilenumber.sendKeys("9858153885");
		logMessage("mobile number is entered ");
		WebElement customername = appiumdriver.findElement(By.id("com.experitest.ExperiBank:id/nameTextField"));
		customername.sendKeys("venkatesh");
		logMessage("name is entered");
		WebElement slider = appiumdriver.findElement(By.id("com.experitest.ExperiBank:id/amount"));
		Actions amntslider = new Actions(appiumdriver);
		amntslider.dragAndDropBy(slider, 100, 0).perform();
		logMessage("slider is moved");
		WebElement slideramount = appiumdriver.findElement(By.id("com.experitest.ExperiBank:id/amountLabel"));
		sliderdollar=getTextElement(slideramount, "balance").replace("Amount (", "").replace("$)", "");
		WebElement countryname = appiumdriver.findElement(By.id("com.experitest.ExperiBank:id/countryButton"));
		countryname.click();
		logMessage("countryname is entered");
		List<WebElement> countryselect = appiumdriver.findElements(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView"));
	    listDrop(countryselect, "India");
		logMessage("country is selected");
		WebElement payment = appiumdriver.findElement(By.id("com.experitest.ExperiBank:id/sendPaymentButton"));
		payment.click();
		logMessage("payment button is clicked");
		WebElement confrom = appiumdriver.findElement(By.id("android:id/button1"));
		confrom.click();
		logMessage("confrom button is clicked");
		WebElement totalbalance = appiumdriver.findElement(By.id("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View"));
		totalbal =getTextElement(totalbalance, "balance").replace("Your balance is: ", "").replace("$", "");
		double actualamount=Double.valueOf(Login_Page.dollar)-Double.valueOf(Payment_Page.sliderdollar);
		checkEquality(actualamount, Double.valueOf(totalbal));
		
		}

}
