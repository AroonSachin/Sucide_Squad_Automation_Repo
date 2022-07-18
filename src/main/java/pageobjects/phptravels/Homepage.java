package pageobjects.phptravels;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import commonuseractions.CommonActionMethods;
import utils.DriverFactory;
/**
 * This class is to search the flight.
 * @author amaduraiveeran
 *
 */
public class Homepage extends CommonActionMethods {
	@FindBy(xpath = "(//ul[@class='nav nav-tabs listitems']//button)[2]")
	static WebElement flightbutton;

	@FindBy(xpath = "(//div[@class='row contact-form-action g-1']//input)[1]")
	static WebElement depcity;

	@FindBy(xpath = "(//div[@class='row contact-form-action g-1']//input)[2]")
	static WebElement descity;

	@FindBy(xpath = "(//div[@class='autocomplete-results troll intro in'])[1]//strong")
	List<WebElement> depcitylist;

	@FindBy(xpath = "(//div[@class='autocomplete-results troll intro in'])[2]//strong")
	List<WebElement> descitylist;

	@FindBy(xpath = "((//table[@class=' table-condensed'])[3]//i)[2]")
	WebElement nextarrow;

	@FindBy(xpath = "((//table[@class=' table-condensed'])[4]//th)[3]")
	WebElement returnnxtarw;

	@FindBy(xpath = "(//table[@class=' table-condensed'])[3]//th[@class='switch']")
	WebElement month;

	@FindBy(xpath = "(//table[@class=' table-condensed'])[4]//th[@class='switch']")
	WebElement monthreturn;

	@FindBy(xpath = "(//table[@class=' table-condensed'])[3]//td[@class='day ']")
	List<WebElement> date;

	@FindBy(xpath = "(//table[@class=' table-condensed'])[4]//td[@class='day ']")
	List<WebElement> datereturn;

	@FindBy(xpath = "(//div[@class='form-group'])[8]//input")
	WebElement calenderbox;

	@FindBy(xpath = "//div[@id='onereturn']//button")
	WebElement searchbutton;

	@FindBy(xpath = "(//div[@class='form-check'])[2]//input")
	WebElement roundtrip;

	@FindBy(xpath = "//div[@id='onereturn']//input[@id='departure']")
	WebElement departuredate;

	@FindBy(xpath = "//div[@id='onereturn']//input[@id='return']")
	WebElement returndate;

	@FindBy(xpath = "//div[@id='onereturn']//a")
	WebElement paxbotton;

	@FindBy(xpath = "((//div[@class='dropdown-menu dropdown-menu-wrap'])[2]//i[@class='la la-plus'])[1]")
	WebElement adultplus;

	@FindBy(xpath = "((//div[@class='dropdown-menu dropdown-menu-wrap'])[2]//i[@class='la la-plus'])[2]")
	WebElement childplus;

	@FindBy(xpath = "((//div[@class='dropdown-menu dropdown-menu-wrap'])[2]//i[@class='la la-plus'])[3]")
	WebElement infantplus;
	
	@FindBy(xpath = "//div[@id='cookie_disclaimer']//button")
	WebElement cookie;
	/**
	 * Constructor to store the above located elements.
	 */
	public Homepage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(DriverFactory.getDriver(), 30), this);
	}
	/**
	 * method to locate the given month.
	 * This method should be used within the class. 
	 * @param ele
	 * @param monthtoselect
	 * @param nxtbutton
	 * @throws Exception
	 */
	private void monthloc(WebElement ele, String monthtoselect, WebElement nxtbutton) throws Exception {
		while (true) {
			if (ele.getText().equalsIgnoreCase(monthtoselect)) {
				break;
			} else {
				clickMethod(nxtbutton, "next arrow");
			}
		}

	}
	/**
	 * This method passes the information to search a suitable flight. 
	 * @param dep
	 * @param des
	 * @param mnth
	 * @param depdate
	 * @param trip
	 * @param returnmonth
	 * @param returnday
	 * @throws Exception
	 */
	public void SearchFlight(String dep, String des, String mnth, String depdate, String trip, String returnmonth,
			String returnday) throws Exception {
		getTitle();
		getURL();
		logMessage("Current URL:" + getURL());
		logMessage("Current page title:" + getTitle());
		webWait(flightbutton);
		clickMethod(flightbutton, "Flight button");
		sendKeysMethod(depcity, "MAA");
		listDrop(depcitylist, "dep");
		sendKeysMethod(descity, "LAS");
		listDrop(depcitylist, "des");
		if (!trip.equalsIgnoreCase("round trip")) {
			clickMethod(calenderbox, "Calender box");
			monthloc(month, mnth, nextarrow);
			listDrop(date, depdate);
		} else {
			clickMethod(roundtrip, "Round trip button");
			clickMethod(departuredate, "departure Calender box");
			monthloc(month, mnth, nextarrow);
			listDrop(date, depdate);
			Thread.sleep(2000);
			monthloc(monthreturn, returnmonth, returnnxtarw);
			listDrop(datereturn, returnday);
		}
		clickMethod(cookie, "Cookie got it button");
		clickMethod(paxbotton, "Passenger button");
		
	}
	/**
	 * This method chooses the number of adults,child's and infants.
	 * @param numofadult
	 * @param numofchild
	 * @param numofinfant
	 * @throws Exception
	 */
	public void pax(String numofadult, String numofchild, String numofinfant) throws Exception {
		int adult = Integer.valueOf(numofadult);
		int child = Integer.valueOf(numofchild);
		int infant = Integer.valueOf(numofinfant);
			for (int i = 1; i <= adult-1; i++) {
				clickMethod(adultplus,"Adult plus button");
			}
			for (int i = 1; i <=child; i++) {
				clickMethod(childplus,"Adult plus button");
			}
			for (int i = 1; i <=infant; i++) {
				clickMethod(infantplus,"Adult plus button");
			}
			clickMethod(searchbutton, "search button");
	}
}
