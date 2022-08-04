package yourlogo;

import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import commonuseractions.CommonActionMethods;
import pageobjects.yourlogo.LoginPage;
import pageobjects.yourlogo.Orderpage;
import utils.DriverFactory;

public class YourLogo extends CommonActionMethods {

	@BeforeClass
	private void extentReport() {
		extentReport("Yourlogo.html");

	}

	/**
	 * @This method used to invoke the browser
	 */
	@BeforeMethod
	public void browser() {
		invokeBrowser("chrome", "normal", "http://automationpractice.com/index.php");
	}

	/**
	 * @This method return the data from excel
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name = "yolo")
	private Iterator<Object[]> sheet() throws Exception {
		return getTestData("yolo");

	}

	/**
	 * @This method is to verify login functionality
	 * @param page
	 * @throws Exception
	 */

	@Test(dataProvider = "yolo")
	private void login(Map<String, String> page) throws Exception {
		inputdata.set(page);
		if (getdata("Number").equalsIgnoreCase("1")) {
			extent("Login page ", "Venkatesh", "Functional testing");
			new LoginPage().login();
		}
	}

	/**
	 * @This method is to verify orderpage functionality
	 * @param page
	 * @throws Exception
	 */
	@Test(dataProvider = "yolo")
	private void orderPage(Map<String, String> page) throws Exception {
		inputdata.set(page);
		if (getdata("Number").equalsIgnoreCase("1")) {
			extent("Order Page", "Venkatesh", "Functional testing");
			DriverFactory.getDriver().getCurrentUrl();
			new LoginPage().login();
			new Orderpage().order();
		}
	}

	@AfterClass
	private void Report() {
		extentreport.flush();

	}

	/**
	 * @This method is to quit the browser
	 */
	@AfterMethod
	private void quit() {
		DriverFactory.closeDriver();
	}

}