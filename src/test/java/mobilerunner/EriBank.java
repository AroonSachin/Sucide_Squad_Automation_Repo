package mobilerunner;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import commonuseractions.CommonActionMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import mobile_pageobjects.eribank.LoginPage;
import mobile_pageobjects.eribank.PaymentPage;
import utils.DriverFactory;

public class EriBank extends CommonActionMethods{
	
	@BeforeTest
	private void setup() throws MalformedURLException {
		PropertyConfigurator.configure(configFilename);
		UiAutomator2Options cap = new UiAutomator2Options()
				.setPlatformName("Android")
				.setDeviceName("Pixel 2 XL API 28")
				.setApp("D:\\EriBank.apk")
				.setAutomationName("UiAutomator2")
				.setAppPackage("com.experitest.ExperiBank")
				.setAppActivity("com.experitest.ExperiBank.LoginActivity")
				.eventTimings();
		appiumdriver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub/"),cap);
		appiumdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    DriverFactory.setDriver(appiumdriver);

	}
	@Test(priority = 1)
	private void test() throws Exception {
		windowSize=appiumdriver.manage().window().getSize();
		new LoginPage().login();
		 
	}
	@Test(priority = 2)
	private void pay() throws Exception {
		new PaymentPage().payment();
	}
	
}
