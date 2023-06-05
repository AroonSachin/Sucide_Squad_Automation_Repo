package mobilerunner;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Map;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import commonuseractions.CommonActionMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import mobile_pageobjects.eribank.LoginPage;
import mobile_pageobjects.eribank.PaymentPage;
import utils.DriverFactory;

public class eribank extends CommonActionMethods {
	static AppiumDriverLocalService service = null;
	public static void invokeServer() throws IOException {
		String nodePath = "C:\\Program Files\\nodejs\\node.exe";
		String appiumMainJsPath = "C:\\Users\\vbaskar\\AppData\\Local\\Programs\\Appium Server GUI\\resources\\app\\node_modules\\appium";
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File(nodePath))
				.withAppiumJS(new File(appiumMainJsPath))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.withArgument(GeneralServerFlag.BASEPATH, "wd/")
				);
	}

	@DataProvider(name = "automation")
	public Iterator<Object[]> getTestData() throws Exception {
		return getTestData("EriBank", "Mobile_Data.xlsx");
	}

	@BeforeTest
	private void setup() throws IOException {
		extentReports("Yourlogo.html");
		invokeServer();
		service.start();
		PropertyConfigurator.configure(configFilename);
		UiAutomator2Options cap = new UiAutomator2Options().setPlatformName("Android")
				.setDeviceName("Pixel 2 XL API 28").setApp("D:\\EriBank.apk").setAutomationName("UiAutomator2")
				.setAppPackage("com.experitest.ExperiBank").setAppActivity("com.experitest.ExperiBank.LoginActivity")
				.eventTimings();
		appDriver = new AndroidDriver(service.getUrl(), cap);
		appDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		DriverFactory.setDriver(appDriver);

	}

	@Test(priority = 1 , dataProvider = "automation")
	private void test(Map<String, String> mapdata) throws Exception {
		inputdata.set(mapdata);
		extent("LoginPage ", "Venkatesh", "Functional testing");
		new LoginPage().login();

	}

	@Test(priority = 2,  dataProvider = "automation")
	private void pay(Map<String, String> mapdata) throws Exception {
		inputdata.set(mapdata);
		extent("PaymentPage ", "Venkatesh", "Functional testing");
		new PaymentPage().payment();
	}

	@AfterClass
	public void tearDown() {
		extentreport.flush();
		appDriver.quit();
		service.stop();
	}

}
