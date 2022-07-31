package swaglab;

import java.util.Iterator;
import java.util.LinkedHashSet;
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
import pageobjects.swaglabs.Info;
import pageobjects.swaglabs.LoginPage;

import utils.ExcelWriter;

import utils.DriverFactory;

public class Runner extends CommonActionMethods {
	private static ThreadLocal<Boolean> status = new ThreadLocal<>();

	@DataProvider(name = "automation")
	public static Iterator<Object[]> datas() throws Exception {
		return getTestData("test");
	}

	@BeforeMethod
	public static void startBrowser() throws Exception {
		invokeBrowser("chrome", "Windows", "https://www.saucedemo.com/");
	}

	@Test(dataProvider = "automation")
	public void testCase1(Map<String, String> mapData) throws Exception {
		inputdata.set(mapData);

		if (CommonActionMethods.getdata("Number").equals("1")) {
			
            status.set(false);
			new LoginPage().enterUsername();
			new LoginPage().enterPassword();
			new LoginPage().clickLogin();
			new HomePage().verifyLogin();
			new HomePage().sortPrice();
			new HomePage().verifyPrice();
			new HomePage().selectItem();
			new HomePage().clickCart();
			new Checkout().validateQuantity();
			new Checkout().validateProductInfo();
			new Checkout().clickOnCheckoutButton();
			new Info().enterFirstName();
			new Info().enterLastName();
			new Info().enterPincode();
			new Info().clickContinueButton();
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
			new LoginPage().enterUsername();
			new LoginPage().enterPassword();
			new LoginPage().clickLogin();
			new HomePage().verifyLogin();
			new HomePage().sortPrice();
			new HomePage().verifyPrice();
			new HomePage().selectItem();
			new HomePage().clickCart();
			new Checkout().validateQuantity();
			new Checkout().validateProductInfo();
			new Checkout().clickOnCheckoutButton();
			new Info().enterFirstName();
			new Info().enterLastName();
			new Info().enterPincode();
			new Info().clickContinueButton();
			new Confirmation().clickOnFinishButton();
			new Confirmation().verifyOrderConfirmation();
			status.set(true);
		} else {
			DriverFactory.getDriver().quit();
			throw new SkipException("Skip test");
		}

	}
	
	@AfterMethod
	public static void logStatus() throws Exception
	{
		
		if(status.get())
		{
			ExcelWriter.xlWriteStatus("writedata.xlsx","write", "Pass");
		}
		else
		{
			ExcelWriter.xlWriteStatus("writedata.xlsx","write", "Fail");
		}
	}

}
