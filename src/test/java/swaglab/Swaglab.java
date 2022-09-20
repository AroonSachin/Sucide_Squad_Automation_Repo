package swaglab;

import java.util.Iterator;
import java.util.Map;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import commonuseractions.CommonActionMethods;
import commonuseractions.MailTestListener;
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


@Listeners(commonuseractions.MailTestListener.class)
public class Swaglab extends CommonActionMethods {
	
	@BeforeClass
	private void extentReport() {
		extentReport("Yourlogo.html");
		

	}
	private static ThreadLocal<Boolean> status = new ThreadLocal<>();




	@DataProvider(name = "automation")
	public static Iterator<Object[]> datas() throws Exception {
		return getTestData("Test");
	}

	/**
	 * @this method is used to navigate to the sauce demo page
	 * @throws Exception
	 */
	@BeforeMethod(alwaysRun=true)
	public void startBrowser() throws Exception {
		
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
			invokeBrowser("chrome", "Windows", "https://www.saucedemo.com/");
			testname.set("Test1");
            status.set(false);
            MailTestListener.setDescription(getdata("Description"));
            extent("Login", "Sowmya", "Logging in");
			new LoginPage().login();
			new HomePage().homepageValidation();
			new Checkout().checkoutValidation();
			new Checkout().clickOnCheckoutButton();
			new InfoPage().info();
            //new Confirmation().clickOnFinishButton();
			new Confirmation().verifyOrderConfirmation();
			status.set(true);

		} else {
			throw new SkipException("Skip test");
		}
	}

	@Test(dataProvider = "automation")

	public void testCase2(Map<String, String> mapData) throws Exception {
		inputdata.set(mapData);
		
		if (CommonActionMethods.getdata("Number").equals("2")) {
			testname.set("Test2");
			invokeBrowser("chrome", "Windows", "https://www.saucedemo.com/");
			status.set(false);
			MailTestListener.setDescription(getdata("Description"));
			 extent("Purchase", "Sowmya", "Purchasing items");
			new LoginPage().login();
			new HomePage().homepageValidation();
			new Checkout().checkoutValidation();
			new Checkout().clickOnCheckoutButton();
			new InfoPage().info();
			new Confirmation().clickOnFinishButton();
			new Confirmation().verifyOrderConfirmation();
			status.set(true);
		} else {
			throw new SkipException("Skip test");
		}

	}

	@AfterMethod
	public void logStatus() throws Exception {
		
		if(status.get()!=null)
		{
        if (status.get()) {
			ExcelReader.xlWriteStatus("database.xlsx", "Test", "Pass");
		} else {
			ExcelReader.xlWriteStatus("database.xlsx", "Test", "Fail");
		}
        DriverFactory.closeDriver();
	}

}
	@AfterClass
	public void aftrclass() {
		extentreport.flush();
	}
	@AfterSuite
	public void sendMailReport() throws Exception
	{
		System.err.println("After method");
		mailFlag = false;
		Mail.sendReport();
		scenarioStatus.remove();
		scenarioComments.remove();
		scenarioDescription.remove();
		scenarioNo.remove();
	}
}
