package phptravels;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonuseractions.CommonActionMethods;
import pageobjects.phptravels.Flightchoosepage;
import pageobjects.phptravels.Homepage;

public class PhpTravelFlightBooking extends CommonActionMethods{
	
	@BeforeMethod
	public void invoke() {
		invokeBrowser("chrome", "Normal","https://phptravels.net/");
		
	}
	
	@Test
	public void searchFlight() throws Exception {
		new Homepage().SearchFlight();
		new Flightchoosepage().chooseFlight();
	}
} 

