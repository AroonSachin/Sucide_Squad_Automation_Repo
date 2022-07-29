package pageobjects.phptravels;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
 */
public class Homepage extends CommonActionMethods {
	@FindBy(xpath = "(//ul[@class='nav nav-tabs listitems']//button)[2]")
	static WebElement flightbutton;

	@FindBy(xpath = "(//div[@class='row contact-form-action g-1']//input)[1]")
	static WebElement depcity;
	
	@FindBy(xpath = "(//div[@class='row contact-form-action g-1']//input)[2]")
	static WebElement descity;
	
	@FindBy(xpath = "(//div[@class='autocomplete-results troll intro in'])[1]//strong")
	static
	List<WebElement> depcitylist;
	
	@FindBy(xpath = "(//div[@class='autocomplete-results troll intro in'])[2]//strong")
	List<WebElement> descitylist;

	@FindBy(xpath = "((//table[@class=' table-condensed'])[3]//i)[2]")
	static
	WebElement nextarrow;

	@FindBy(xpath = "((//table[@class=' table-condensed'])[4]//i)[2]")
	static
	WebElement returnnxtarw;
	
	@FindBy(xpath = "(//table[@class=' table-condensed'])[3]//th[@class='switch']")
	static
	WebElement month;

	@FindBy(xpath = "(//table[@class=' table-condensed'])[4]//th[@class='switch']")
	static
	WebElement monthreturn;

	@FindBy(xpath = "(//table[@class=' table-condensed'])[3]//td[@class='day ']")
	static
	List<WebElement> dateele;

	@FindBy(xpath = "(//table[@class=' table-condensed'])[4]//td[@class='day ']")
	static
	List<WebElement> datereturn;

	@FindBy(xpath = "(//div[@class='form-group'])[8]//input")
	static
	WebElement calenderbox;

	@FindBy(xpath = "//div[@id='onereturn']//button")
	WebElement searchbutton;

	@FindBy(xpath = "(//div[@class='form-check'])[2]//input")
	static
	WebElement roundtrip;

	@FindBy(xpath = "//div[@id='onereturn']//input[@id='departure']")
	static
	WebElement departuredate;

	@FindBy(xpath = "//div[@id='onereturn']//input[@id='return']")
	WebElement returndate;

	@FindBy(xpath = "//div[@id='onereturn']//a")
	static
	WebElement paxbotton;

	@FindBy(xpath = "((//div[@class='dropdown-menu dropdown-menu-wrap'])[2]//i[@class='la la-plus'])[1]")
	WebElement adultplus;

	@FindBy(xpath = "((//div[@class='dropdown-menu dropdown-menu-wrap'])[2]//i[@class='la la-plus'])[2]")
	WebElement childplus;

	@FindBy(xpath = "((//div[@class='dropdown-menu dropdown-menu-wrap'])[2]//i[@class='la la-plus'])[3]")
	WebElement infantplus;
	
	@FindBy(xpath = "//div[@id='cookie_disclaimer']//button")
	static
	WebElement cookie;
	/**
	 * Constructor to store the above located elements.
	 */
	public Homepage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(DriverFactory.getDriver(), 10), this);
	}
	/**
	 * method to locate the given month.
	 * This method should be used within the class. 
	 * @param ele
	 * @param monthtoselect
	 * @param nxtbutton
	 * @return 
	 * @throws Exception
	 */
	private static void monthloc(WebElement ele, String monthtoselect, WebElement nxtbutton) throws Exception {
		while (true) {
			if (ele.getText().contains(monthtoselect)) {
				break;
			} else {
				clickMethod(nxtbutton, "next arrow");
			}
		}
	}
	public static String dateSel(int plusdays) {
		Calendar cal = Calendar.getInstance();
		cal.add(7,+plusdays);
		SimpleDateFormat date = new SimpleDateFormat();
		date.applyPattern("MMMMMMMMMM/dd/yyyy");
		String dat = date.format(cal.getTime());
		return dat;
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
	public  void  SearchFlight() throws Exception {
		getTitle();
		getURL();
		logMessage("Current URL:" + getURL());
		logMessage("Current page title:" + getTitle());
		clickMethod(flightbutton, "Flight button");
		sendKeysMethod(depcity, "MAA");
		listDrop(depcitylist, "dep");
		sendKeysMethod(descity, "LAS");
		listDrop(depcitylist, "des");
		String[] date = splitString(dateSel(Integer.parseInt(getdata("date"))),"/");
		String mnth = date[0];
		String depdate = date[1];
		String[] rtrndate = splitString(dateSel(Integer.parseInt(getdata("returndate"))),"/");
		String returnmonth = rtrndate[0];
		String returnday = rtrndate[1];
		if (!getdata("trip") .equalsIgnoreCase("round trip")) {
			clickMethod(calenderbox, "Calender box");
			monthloc(month, mnth, nextarrow);
			listDrop(dateele, depdate);
		} else {
			clickMethod(roundtrip, "Round trip button");
			clickMethod(departuredate, "departure Calender box");
			monthloc(month, mnth, nextarrow);
			listDrop(dateele, depdate);
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
	public void pax() throws Exception {
		int adult = Integer.valueOf(getdata("adult"));
		int child = Integer.valueOf(getdata("child"));
		int infant = Integer.valueOf(getdata("infant"));
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
