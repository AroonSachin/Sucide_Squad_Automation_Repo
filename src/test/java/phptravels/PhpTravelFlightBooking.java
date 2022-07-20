package phptravels;

import java.util.Iterator;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import commonuseractions.CommonActionMethods;
import pageobjects.phptravels.Flightchoosepage;
import pageobjects.phptravels.Homepage;
import pageobjects.phptravels.Invoicepage;
import pageobjects.phptravels.Paxdetailspage;

public class PhpTravelFlightBooking extends CommonActionMethods{
	@BeforeClass
	public void invoke() {
		invokeBrowser("chrome", "Normal","https://phptravels.net/");
	}
	@DataProvider(name = "automation")
	public Iterator<Object[]> getTestData() throws Exception {
		return getTestData("php");
	}
	@Test(priority = 1,dataProvider = "automation")
	public void searchFlight(Map<String, String> mapdata) throws Exception {
		inputdata.set(mapdata);
		if(getdata("number").equalsIgnoreCase("1")) {
		new Homepage().SearchFlight(getdata("Departure"),getdata("Destination"),getdata("month"),getdata("date"),getdata("trip"),getdata("return month"),getdata("returndate"));
		new Homepage().pax(getdata("adult"),getdata("child"),getdata("infant"));
		new Flightchoosepage().chooseFlight();
		}
	}
	@Test(priority = 2,dataProvider = "automation")
	public void booking(Map<String, String> mapdata) throws Exception {
		inputdata.set(mapdata);
		if (getdata("number").equalsIgnoreCase("1")) {
		new Paxdetailspage().personalDetails(getdata("perfirstname"),getdata("perlastname"),getdata("permail"),getdata("perphone"),getdata("peraddress"),getdata("percountry"),getdata("pernationality"));
		new Paxdetailspage().title(getdata("paxtitle"));
		new Paxdetailspage().dobMonth(getdata("paxdom"));
		new Paxdetailspage().dobday(getdata("paxdod"));
		new Paxdetailspage().dobYear(getdata("paxdoy"));
		new Paxdetailspage().pidMonth(getdata("pidmonth"));
		new Paxdetailspage().pidDay(getdata("pidday"));
		new Paxdetailspage().pidYear(getdata("pidyear"));
		new Paxdetailspage().pedMonth(getdata("pedmonth"));
		new Paxdetailspage().pedDay(getdata("pedday"));
		new Paxdetailspage().pedYear(getdata("pedyear"));
		new Paxdetailspage().firstName(getdata("firstname"));
		new Paxdetailspage().lastName(getdata("lastname"));
		new Paxdetailspage().passportID(getdata("passportid"));
		new Paxdetailspage().nationality(getdata("nationality"));
		new Paxdetailspage().validatePrice();
		new Paxdetailspage().book();
		new Invoicepage().invoiceValidation(getdata("adult"),getdata("child"),getdata("infant"));
		new Invoicepage().proceed();
		}
	}
}