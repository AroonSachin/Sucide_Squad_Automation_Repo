package swaglab;

import java.util.Iterator;
import java.util.Map;
import java.util.zip.CheckedOutputStream;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonuseractions.CommonActionMethods;
import swaglabs.Checkout;
import swaglabs.Confirmation;
import swaglabs.HomePage;
import swaglabs.Info;
import swaglabs.LoginPage;

public class Runner extends CommonActionMethods{
	
		
	
	@DataProvider (name = "automation")
	public static Iterator<Object[]> datas() throws Exception
	{ 
		return getTestData("test");
	}

	@Test (dataProvider = "automation")
	public void testCase1(Map<String, String> mapData) throws Exception
	{
		inputdata.set(mapData);
		if (CommonActionMethods.getdata("Number").equals("1"))
		{
			invokeBrowser("chrome", "Windows", "https://www.saucedemo.com/");
			new LoginPage().enterUsername(getdata("Username"));
            new LoginPage().enterPassword(getdata("Password"));
			new LoginPage().clickLogin();
			new HomePage().verifyLogin();
			new HomePage().getCart();
			new HomePage().sortPrice();
			//new HomePage().verifyPrice();
			new HomePage().selectItem(getdata("Quantity"));
			new HomePage().clickCart();
			//new Checkout().verifyCart();
			new Checkout().clickOnCheckoutButton();
			new Info().enterFirstName(getdata("FirstName"));
			new Info().enterLastName(getdata("LastName"));
			new Info().enterPincode(getdata("Pincode"));
			new Info().clickContinueButton();
			new Confirmation().clickOnFinishButton();
			new Confirmation().verifyOrderConfirmation();
			
		
		}
		else
		{
			throw new SkipException("Skip test");
		}
	}
		
		@Test (dataProvider = "automation")
		
		public void testCase2(Map<String, String> mapData) throws Exception
		{
			inputdata.set(mapData);
		
		if (CommonActionMethods.getdata("Number").equals("2"))
				{
			invokeBrowser("chrome", "Windows", "https://www.saucedemo.com/");
			new LoginPage().enterUsername(getdata("Username"));
            new LoginPage().enterPassword(getdata("Password"));
			new LoginPage().clickLogin();
			new HomePage().verifyLogin();
			new HomePage().getCart();
			new HomePage().selectItem(getdata("Quantity"));
			new HomePage().clickCart();
			//new Checkout().verifyCart();
			new Checkout().clickOnCheckoutButton();
			new Info().enterFirstName(getdata("FirstName"));
			new Info().enterLastName(getdata("LastName"));
			new Info().enterPincode(getdata("Pincode"));
			new Info().clickContinueButton();
			new Confirmation().clickOnFinishButton();
			new Confirmation().verifyOrderConfirmation();
				}
		else
		{
			throw new SkipException("Skip test");
		}
	    
	
		
		
	}

}

