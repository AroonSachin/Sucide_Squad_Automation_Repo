package phptravels;

import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import commonuseractions.CommonActionMethods;
import pageobjects.phptravels.Flightchoosepage;
import pageobjects.phptravels.Homepage;
import pageobjects.phptravels.Invoicepage;
import pageobjects.phptravels.Paxdetailspage;
import utils.DriverFactory;


public class PhpTravelFlightBooking extends CommonActionMethods {
	@BeforeMethod
	public void invoke() {
		invokeBrowser("chrome", "Normal", "https://phptravels.net/");
	}

	@DataProvider(name = "automation")
	public Iterator<Object[]> getTestData() throws Exception {
		return getTestData("php");
	}

	@Test(dataProvider = "automation")
	public void searchFlight(Map<String, String> mapdata) throws Exception {
		inputdata.set(mapdata);
		if (getdata("number").equalsIgnoreCase("1")) {
			new Homepage().SearchFlight();
			new Homepage().pax();
			new Flightchoosepage().flightDetailValidate();
			new Flightchoosepage().chooseFlight();
		}
	}

	@Test(dataProvider = "automation")
	public void booking(Map<String, String> mapdata) throws Exception {
		inputdata.set(mapdata);
		if (getdata("number").equalsIgnoreCase("1")) {
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
		}
	}
	
	@AfterMethod
	public void close() {
		DriverFactory.closeDriver();
	}
}