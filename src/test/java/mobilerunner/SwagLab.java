package mobilerunner;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import commonuseractions.CommonActionMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import pageobjects.swaglabs.LoginPage;
import utils.DriverFactory;

public class SwagLab extends CommonActionMethods {
	
	@BeforeSuite
	public static void setUp() throws MalformedURLException
	{
		PropertyConfigurator.configure(configFilename);
		UiAutomator2Options opt = new UiAutomator2Options()
				.setPlatformName("Android")
				.setDeviceName("Pixel 2 XL API 31")
				.setApp("D:\\mda-1.0.13-docs-16.apk")
				.setAutomationName("UiAutomator2")
				.setAppPackage("com.saucelabs.mydemoapp.android")
				.setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity")
				.eventTimings();
		appdriver =new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub/"),opt);
		appdriver.manage().timeouts().implicitlyWait(6000,TimeUnit.MILLISECONDS);
		DriverFactory.setDriver(appdriver);
	}
	
	@Test
	public void loginFunction() throws Exception
	{
	new LoginPage().login();
	}
	

}
