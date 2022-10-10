package phptravels;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonuseractions.Allurelistener;
import commonuseractions.CommonActionMethods;
import io.qameta.allure.Feature;
import pageobjects.phptravels.Flightchoosepage;
import pageobjects.phptravels.Homepage;
import pageobjects.phptravels.Invoicepage;
import pageobjects.phptravels.Paxdetailspage;
import utils.DriverFactory;
import utils.Mail;

@Listeners(Allurelistener.class)
@Feature("PhpTravels")
public class PhpTravelFlightBooking extends CommonActionMethods {
	@BeforeTest
	public void reportClean() {
		invokeMail = true;
		File allureFile = new File(System.getProperty("user.dir") + "\\allure-results");
		deleteFolder(allureFile);
	}

	@BeforeMethod
	public void invoke() throws Exception {
		URL.set("https://phptravels.net/");
		testName = "Php Travels";
	}

	@DataProvider(name = "automation")
	public Iterator<Object[]> getTestData() throws Exception {
		return getTestData("php");
	}

	@Test(dataProvider = "automation", description = "To verify search functionality")
	public void searchFlight(Map<String, String> mapdata) throws Exception {
		inputdata.set(mapdata);
		if (getdata("Number").equalsIgnoreCase("1")) {
			System.out.println("Test_1");
			invokeBrowser("Chrome", "Normal", URL.get());
			new Homepage().SearchFlight();
			new Homepage().pax();
			new Flightchoosepage().flightDetailValidate();
			new Flightchoosepage().chooseFlight();
		} else {
			throw new SkipException("Skipped to iterate data");
		}
	}

	@Test(dataProvider = "automation", description = "To verify booking functionality")
	public void booking(Map<String, String> mapdata) throws Exception {
		inputdata.set(mapdata);
		if (getdata("Number").equalsIgnoreCase("2")) {
			System.out.println("Test_2");
			invokeBrowser("Chrome", "Normal", URL.get());
			new Homepage().SearchFlight();
			new Homepage().pax();
			new Flightchoosepage().flightDetailValidate();
			new Flightchoosepage().chooseFlight();
			new Paxdetailspage().personalDetails();
			new Paxdetailspage().title();
			new Paxdetailspage().dobMonth();
			new Paxdetailspage().dobday();
			new Paxdetailspage().dobYear();
			new Paxdetailspage().pidMonth();
			new Paxdetailspage().pidDay();
			new Paxdetailspage().pidYear();
			new Paxdetailspage().pedMonth();
			new Paxdetailspage().pedDay();
			new Paxdetailspage().pedYear();
			new Paxdetailspage().firstName();
			new Paxdetailspage().lastName();
			new Paxdetailspage().passportID();
			new Paxdetailspage().nationality();
			new Paxdetailspage().validatePrice();
			new Paxdetailspage().book();
			new Invoicepage().invoiceValidation();
			new Invoicepage().proceed();
		} else {
			throw new SkipException("Skipped to iterate data");
		}
	}

	@AfterMethod
	public void close() {
		if (DriverFactory.getDriver() != null) {
			DriverFactory.closeDriver();
		}
		URL.remove();
	}

	@AfterSuite
	public void afterSuit() throws IOException {
		mailFlag = false;
		Mail.sendReport("Null");
		scenarioNo.remove();
		scenarioDescription.remove();
		scenarioStatus.remove();
		scenarioComments.remove();
		FailedScreenShotdestination.remove();

	}
}