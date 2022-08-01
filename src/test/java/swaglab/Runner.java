package swaglab;

import java.util.Iterator;
import java.util.Map;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonuseractions.CommonActionMethods;
import pageobjects.swaglabs.Checkout;
import pageobjects.swaglabs.Confirmation;
import pageobjects.swaglabs.HomePage;
import pageobjects.swaglabs.InfoPage;
import pageobjects.swaglabs.LoginPage;

import utils.ExcelWriter;

import utils.DriverFactory;

/**
 * 
 * @author svenkateshwaran
 * @this is the runner class that has all the test scenarios
 *
 */
public class Runner extends CommonActionMethods {
	private static ThreadLocal<Boolean> status = new ThreadLocal<>();

	@DataProvider(name = "automation")
	public static Iterator<Object[]> datas() throws Exception {
		return getTestData("test");
	}

	/**
	 * @this method is used to navigate to the sauce demo page
	 * @throws Exception
	 */
	@BeforeMethod
	public static void startBrowser() throws Exception {
		invokeBrowser("chrome", "Windows", "https://www.saucedemo.com/");
	}

	/**
	 * @this test is to validate the entire checkout flow in swaglab
	 * @param mapData
	 * @throws Exception
	 */

	@Test(dataProvider = "automation")
	public void testCase1(Map<String, String> mapData) throws Exception {
		inputdata.set(mapData);

		if (CommonActionMethods.getdata("Number").equals("1")) {

			status.set(false);

			new LoginPage().login();
			new HomePage().homepageValidation();
			new Checkout().checkoutValidation();
			new Checkout().clickOnCheckoutButton();
			new InfoPage().info();
            new Confirmation().clickOnFinishButton();
			new Confirmation().verifyOrderConfirmation();
			status.set(true);

		} else {
			DriverFactory.getDriver().quit();
			throw new SkipException("Skip test");
		}
	}

	@Test(dataProvider = "automation")

	public void testCase2(Map<String, String> mapData) throws Exception {
		inputdata.set(mapData);

		if (CommonActionMethods.getdata("Number").equals("2")) {

			status.set(false);
			new LoginPage().login();
			new HomePage().homepageValidation();
			new Checkout().checkoutValidation();
			new Checkout().clickOnCheckoutButton();
			new InfoPage().info();
			new Confirmation().clickOnFinishButton();
			new Confirmation().verifyOrderConfirmation();
			status.set(true);
		} else {
			DriverFactory.getDriver().quit();
			throw new SkipException("Skip test");
		}

	}

	@AfterMethod
	public static void logStatus() throws Exception {
		if(status.get()!=null)
		{
        if (status.get()) {
			ExcelWriter.xlWriteStatus("writedata.xlsx", "write", "Pass");
		} else {
			ExcelWriter.xlWriteStatus("writedata.xlsx", "write", "Fail");
		}
	}

}
}
