package phptravels;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonuseractions.CommonActionMethods;
import pageobjects.phptravels.Flightchoosepage;
import pageobjects.phptravels.Homepage;
import pageobjects.phptravels.Paxdetailspage;
import utils.ExcelReader;

public class PhpTravelFlightBooking extends CommonActionMethods{
	private ExcelReader xlRead = null;
	private int xlRowCount = 0;
	@BeforeClass
	public void invoke() {
		invokeBrowser("chrome", "Normal","https://phptravels.net/");
	}
	
	@DataProvider(name = "automation")
	public Iterator<Object[]> getTestData() throws Exception {
		xlRead = new ExcelReader("DataBase.xlsx", "PhpTravels");
		xlRowCount = xlRead.getRowCount();
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		for (int i = 1; i < xlRowCount; i++) {
			data.add(new Object[] { xlRead.xlReader(i) });
		}
		return data.iterator();
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
		
		}
	}
} 

