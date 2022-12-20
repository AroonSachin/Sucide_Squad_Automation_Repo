package mobilerunner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
import mobile_pageobjects.SwagLab.CartPage;
import mobile_pageobjects.SwagLab.CheckOutCompletePage;
import mobile_pageobjects.SwagLab.CheckOutInfoPage;
import mobile_pageobjects.SwagLab.Login_Page;
import mobile_pageobjects.SwagLab.OverViewPage;
import mobile_pageobjects.SwagLab.Products_Page;
import utils.DriverFactory;

public class SwagLab_Aroon extends CommonActionMethods{
	static AppiumDriverLocalService service = null;
	public static void invokeServer() throws IOException {
		
		String nodePath = "C:\\Program Files\\nodejs\\node.exe";
		String appiumMainJsPath = "C:\\Program Files\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js";
		
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File(nodePath))
				.withAppiumJS(new File(appiumMainJsPath))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.withArgument(GeneralServerFlag.BASEPATH, "wd/hub/")
				);
	}
	
	@DataProvider(name = "automation")
	public Iterator<Object[]> getTestData() throws Exception {
		return getTestData("SwagLab","Mobile_Data.xlsx");
	}
	
	@BeforeClass
	public static void setUp() throws IOException {
		invokeServer();
		service.start();
		PropertyConfigurator.configure(configFilename);
		UiAutomator2Options opt = new UiAutomator2Options()
				.setApp("D:\\Mobile Automation\\APK\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk")
				.setAppActivity("com.swaglabsmobileapp.MainActivity")
				.setAppPackage("com.swaglabsmobileapp")
				.setAutomationName("UiAutomator2")
				.setDeviceName("Pixel 2 XL API 31")
				.eventTimings();
		appDriver = new AndroidDriver(new java.net.URL("http://127.0.0.1:4723/wd/hub/"),opt);
		DriverFactory.setDriver(appDriver);
	}

	@Test(dataProvider = "automation")
	public void logIn(Map<String, String> mapdata) throws Exception {
		inputdata.set(mapdata);
		new Login_Page().logIn();
		new Login_Page().loginValidation();
		new Products_Page().shortValidation();
	}
	
	@Test
	public void orderProduct() throws Exception {
		new Products_Page().addToCart();
		new CartPage().productValidation();
		new CheckOutInfoPage().inputInformation();
		new OverViewPage().overViewValidation();
		new CheckOutCompletePage().orderValidation();
		
	}
	
	@AfterClass
	public void tearDown() {
	 appDriver.quit();
	 service.stop();
	}
}
