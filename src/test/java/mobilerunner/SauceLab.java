package mobilerunner;

import java.io.File;
import java.io.IOException;
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
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import mobile_pageobjects.saucelab.ConfirmationPage;
import mobile_pageobjects.saucelab.HomePage;
import mobile_pageobjects.saucelab.InfoPage;
import mobile_pageobjects.saucelab.LoginPage;
import mobile_pageobjects.saucelab.ProductPage;
import utils.DriverFactory;

public class SauceLab extends CommonActionMethods {
	@DataProvider(name = "automation")
	public Iterator<Object[]> getTestData() throws Exception {
		return getTestData("SauceLab", "Mobile.xlsx");
	}

	@BeforeClass
	public static void setUp() throws MalformedURLException {
		PropertyConfigurator.configure(configFilename);
		UiAutomator2Options opt = new UiAutomator2Options().setApp("D:\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk")
				.setAppActivity("com.swaglabsmobileapp.MainActivity").setAppPackage("com.swaglabsmobileapp")
				.setAutomationName("UiAutomator2").setDeviceName("Pixel 2 XL API 31").eventTimings();
		appDriver = new AndroidDriver(new java.net.URL("http://127.0.0.1:4723/wd/hub/"), opt);
		DriverFactory.setDriver(appDriver);
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
		appDriver.quit();
	}

}
