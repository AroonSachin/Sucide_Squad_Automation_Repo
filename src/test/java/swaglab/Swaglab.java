package swaglab;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonuseractions.CommonActionMethods;
import commonuseractions.TestListner;
import pageobjects.swaglabs.Checkout;
import pageobjects.swaglabs.Confirmation;
import pageobjects.swaglabs.HomePage;
import pageobjects.swaglabs.InfoPage;
import pageobjects.swaglabs.LoginPage;
import utils.DriverFactory;
import utils.ExcelReader;
import utils.Mail;

/**
 *
 * @author svenkateshwaran
 * @this is the runner class that has all the test scenarios
 *
 */
@Listeners(TestListner.class)
public class Swaglab extends CommonActionMethods {
	private static ThreadLocal<Boolean> status = new ThreadLocal<>();
	
	@BeforeClass
	public void extent() {
		extentReports("Swag_Lab.html");
		testName = "Swag_Lab";
	}
	@BeforeTest
	public void reportClean() {
		invokeMail = true;
		File allureFile = new File(System.getProperty("user.dir") + "\\allure-results");
		deleteFolder(allureFile);
	}

	@DataProvider(name = "automation")
	public static Iterator<Object[]> datas() throws Exception {
		return getTestData("Test", "database.xlsx");
	}

	/**
	 * @this method is used to navigate to the sauce demo page
	 * @throws Exception
	 */
	@BeforeMethod(alwaysRun = true)
	public void startBrowser() throws Exception {
		url.set("https://www.saucedemo.com/");

	}

	/**
	 * @this test is to validate the entire checkout flow in swaglab
	 * @param mapData
	 * @throws Exception
	 */

	@Test(dataProvider = "automation",description = "to verify login functionality")
	public void testCase1(Map<String, String> mapData) throws Exception {
		inputdata.set(mapData);
		if (CommonActionMethods.getdata("Number").equals("1")) {
			invokeBrowser("chrome", "Windows", url.get());
			extent(" Login ", "Sowmya", "Functional Test");
			status.set(false);
			new LoginPage().login();
			new HomePage().homepageValidation();
			status.set(true);

		} else {
			throw new SkipException("Skip test");
		}
	}

	@Test(dataProvider = "automation",description = "to verify booking functionality")
	public void testCase2(Map<String, String> mapData) throws Exception {
		inputdata.set(mapData);
		if (CommonActionMethods.getdata("Number").equals("2")) {
			invokeBrowser("firefox", "Windows", url.get());
			extent(" Order Confirmation ", "Sowmya", "Functional Test");
			status.set(false);
			new LoginPage().login();
			new HomePage().homepageValidation();
			new Checkout().checkoutValidation();
			new Checkout().clickOnCheckoutButton();
			new InfoPage().info();
			new InfoPage().clickContinue();
			new Confirmation().clickOnFinishButton();
			new Confirmation().verifyOrderConfirmation();
			status.set(true);
		} else {
			throw new SkipException("Skip test");
		}

	}

	@AfterMethod
	public void logStatus() throws Exception {
		if (status.get() != null) {
			if (status.get()) {
				ExcelReader.xlWriteStatus("database.xlsx", "Test", "Pass");
			} else {
				ExcelReader.xlWriteStatus("database.xlsx", "Test", "Fail");
			}
		}
		if (DriverFactory.getDriver() != null) {
			DriverFactory.closeDriver();
		}
		url.remove();
	}

	@AfterClass
	public void afterClass() {
		extentreport.flush();
	}

	@AfterSuite
	public void afterSuit() throws IOException {
		mailFlag = false;
		Mail.sendReport("/Swag_Lab.html");
		scenarioNo.remove();
		scenarioDescription.remove();
		scenarioStatus.remove();
		scenarioComments.remove();
		FailedScreenShotdestination.remove();
	}
}
