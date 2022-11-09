package mobilerunner;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonuseractions.CommonActionMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import mobile_pageobjects.eribank.Login_Page;
import mobile_pageobjects.eribank.Payment_Page;

public class EriBank extends CommonActionMethods{
	
	@BeforeSuite
	private void setup() throws MalformedURLException {
		PropertyConfigurator.configure(configFilename);
		UiAutomator2Options opt = new UiAutomator2Options()
				.setPlatformName("Android")
				.setDeviceName("Pixel 2 XL API 31")
				.setApp("D:\\EriBank.apk")
				.setAutomationName("UiAutomator2")
				.setAppPackage("com.experitest.ExperiBank")
				.setAppActivity("com.experitest.ExperiBank.LoginActivity")
				.eventTimings();
		appiumdriver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub/"),opt);
		appiumdriver.manage().timeouts().implicitlyWait(6000,TimeUnit.MILLISECONDS);

	}
	@Test(priority = 1)
	private void test() throws Exception {
		 Login_Page.login();
		 
	}
	@Test(priority = 2)
	private void pay() throws Exception {
		Payment_Page.payment();
	}
	
}
