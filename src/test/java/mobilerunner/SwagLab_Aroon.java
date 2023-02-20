package mobilerunner;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Service;

import commonuseractions.CommonActionMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import mobile_pageobjects.swaglab.CartPage;
import mobile_pageobjects.swaglab.CheckOutCompletePage;
import mobile_pageobjects.swaglab.CheckOutInfoPage;
import mobile_pageobjects.swaglab.Login_Page;
import mobile_pageobjects.swaglab.OverViewPage;
import mobile_pageobjects.swaglab.Products_Page;
import mobile_pageobjects.swaglab.*;
import utils.DriverFactory;
import utils.ScreenRecorderUtil;

public class SwagLab_Aroon extends CommonActionMethods {
	static AppiumDriverLocalService service = null;
	public static void invokeServer() throws IOException {
		emptyFile(System.getProperty("user.dir") + "\\AppiumLogs.txt");
		String nodePath = "C:\\Program Files\\nodejs\\node.exe";
		String appiumMainJsPath = "C:\\Program Files\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js";
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File(nodePath)).withAppiumJS(new File(appiumMainJsPath))
				.withIPAddress("127.0.0.1").usingPort(4723).withArgument(GeneralServerFlag.BASEPATH, "wd/hub").withLogFile(new File(System.getProperty("user.dir") + "\\AppiumLogs.txt")));
		service.clearOutPutStreams();
		service.start();
		
	}

	@DataProvider(name = "automation")
	public Iterator<Object[]> getTestData() throws Exception {
		return getTestData("SwagLab", "Mobile_Data.xlsx");
	}

	@BeforeClass
	public static void setUp() throws Exception {
		invokeServer();
		ScreenRecorderUtil.startRecord("PhpTravels");
		extentReports("SwaglabMobile.html");
		
		Thread.sleep(2000);
		PropertyConfigurator.configure(configFilename);
		UiAutomator2Options opt = new UiAutomator2Options()
				.setApp("D:\\Mobile Automation\\APK\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk")
				.setAppActivity("com.swaglabsmobileapp.MainActivity").setAppPackage("com.swaglabsmobileapp")
				.setAutomationName("UiAutomator2").setDeviceName("Pixel 2 XL API 31").eventTimings();
		appDriver = new AndroidDriver(service.getUrl(), opt);
		DriverFactory.setDriver(appDriver);
	}

	@Test(dataProvider = "automation")
	public void logIn(Map<String, String> mapdata) throws Exception {
		extent("LogIn", "Aroon Sachin", "Login scenario");
		inputdata.set(mapdata);
		new Login_Page().logIn();
		new Login_Page().loginValidation();
		new Products_Page().sortValidation();
	}

	@Test
	public void orderProduct() throws Exception {
		extent("Product ordering", "Aroon Sachin", "Product order scenario");
		new Products_Page().addToCart();
		new CartPage().productValidation();
		new CheckOutInfoPage().inputInformation();
		new OverViewPage().overViewValidation();
		new CheckOutCompletePage().orderValidation();

	}

	@AfterClass
	public void tearDown() throws Exception {
		extentreport.flush();
		appDriver.quit();
		DriverFactory.closeDriver();
		service.stop();
		ScreenRecorderUtil.stopRecord();
	}
}
