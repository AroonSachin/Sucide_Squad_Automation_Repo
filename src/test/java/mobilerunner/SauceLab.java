package mobilerunner;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonuseractions.CommonActionMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import mobile_pageobjects.swaglab.ConfirmationPage;
import mobile_pageobjects.swaglab.HomePage;
import mobile_pageobjects.swaglab.InfoPage;
import mobile_pageobjects.swaglab.LoginPage;
import mobile_pageobjects.swaglab.ProductPage;
import utils.DriverFactory;

public class SauceLab extends CommonActionMethods{
	@DataProvider(name = "automation")
	public Iterator<Object[]> getTestData() throws Exception {
		return getTestData("SauceLab","Mobile.xlsx");
	}
	
	@BeforeClass
	public static void setUp() throws MalformedURLException {
		PropertyConfigurator.configure(configFilename);
		UiAutomator2Options opt = new UiAutomator2Options()
				.setApp("D:\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk")
				.setAppActivity("com.swaglabsmobileapp.MainActivity")
				.setAppPackage("com.swaglabsmobileapp")
				.setAutomationName("UiAutomator2")
				.setDeviceName("Pixel 2 XL API 31")
				.eventTimings();
		appdriver = new AndroidDriver(new java.net.URL("http://127.0.0.1:4723/wd/hub/"),opt);
		DriverFactory.setDriver(appdriver);
	}

	@Test(dataProvider = "automation")
	public void loginScenario(Map<String, String> mapdata) throws Exception {
		inputdata.set(mapdata);
		new LoginPage().login();
		new LoginPage().loginPageValidation();
		new HomePage().homePageValidation();
	}
	
	
	@Test
	public void orderConfirmation() throws Exception {
		new HomePage().addProducts();
		new ProductPage().productValidation();
		new InfoPage().Info();
		new ConfirmationPage().productDetailsValidation();
		new ConfirmationPage().validateConfirmation();
		
	}
	
	@AfterClass
	public void tearDown() {
	 appdriver.quit();
	}

}
