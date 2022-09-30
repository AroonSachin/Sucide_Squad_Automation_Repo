package pageobjects.phptravels;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import commonuseractions.CommonActionMethods;
import io.qameta.allure.Step;
import utils.DriverFactory;
/**
 * This class is to search the flight.
 * @author amaduraiveeran
 */
public class Homepage extends CommonActionMethods {
	
	@FindBy(xpath = "//button[@aria-controls='flights']")
	WebElement flightbutton;

	@FindBy(xpath = "(//div[@class='row contact-form-action g-1']//input)[1]")
	WebElement depcity;
	
	@FindBy(xpath = "(//div[@class='row contact-form-action g-1']//input)[2]")
	WebElement descity;
	
	@FindBy(xpath = "(//div[@class='autocomplete-results troll intro in'])[1]//b")
	List<WebElement> depcitylist;
	
	@FindBy(xpath = "(//div[@class='autocomplete-results troll intro in'])[2]//b")
	List<WebElement> descitylist;

	@FindBy(xpath = "((//div[@class='datepicker dropdown-menu'])[5]//th[@class='prev']/following-sibling::th[@class='next'])[1]//i")
	WebElement nextarrow;

	@FindBy(xpath = "((//div[@class='datepicker dropdown-menu'])[6]//th[@class='prev']/following-sibling::th[@class='next'])[1]//i")
	WebElement returnnxtarw;
	
	@FindBy(xpath = "((//div[@class='datepicker dropdown-menu'])[5]//th[@class='prev']/following-sibling::th[@class='switch'])[1]")
	WebElement depmonth;

	@FindBy(xpath = "((//div[@class='datepicker dropdown-menu'])[6]//th[@class='prev']/following-sibling::th[@class='switch'])[1]")
	WebElement monthreturn;

	@FindBy(xpath = "(//table[@class=' table-condensed'])[5]//td[@class='day ']")
	List<WebElement> dateele;

	@FindBy(xpath = "(//table[@class=' table-condensed'])[6]//td[@class='day ']")
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

	@FindBy(xpath = "(//div[@class='dropdown-menu dropdown-menu-wrap'])[2]//input[@name='adults']/following-sibling::div")
	WebElement adultplus;

	@FindBy(xpath = "((//div[@class='dropdown-menu dropdown-menu-wrap'])[2]//input[@name='childs']/following-sibling::div)[1]")
	WebElement childplus;

	@FindBy(xpath = "((//div[@class='dropdown-menu dropdown-menu-wrap'])[2]//input[@name='childs']/following-sibling::div)[2]")
	WebElement infantplus;
	
	@FindBy(xpath = "//div[@id='cookie_disclaimer']//button")
	WebElement cookie;
	
	@FindBy(xpath = "((//div[@class='datepicker dropdown-menu'])[3]//th[@class='prev']/following-sibling::th[@class='switch'])[1]")
	WebElement month;
	
	/**
	 * Constructor to store the above located elements.
	 */
	public Homepage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(DriverFactory.getDriver(), 0), this);
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
	@Step("To locate month ")
	public static void monthloc(WebElement ele, String monthtoselect, WebElement nxtbutton) throws Exception {
		while (true) {
			if (getTextElement(ele, " Month ").contains(monthtoselect)) {
				break;
			} else {
				clickMethod(nxtbutton, " next arrow ");
			}
		}
	}
	public static synchronized String dateSel(int plusdays) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,+plusdays);
		SimpleDateFormat date = new SimpleDateFormat();
		date.applyPattern("MMMMMMMMMM/d/yyyy");
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
	@Step("To Search the flight for the given details")
	public void  SearchFlight() throws Exception {
		getTitle();
		getURL();
		logMessage("Current URL:" + getURL());
		logMessage("Current page title:" + getTitle());
		clickMethod(flightbutton, "Flight button");
		sendKeysMethod(depcity,getdata("Departure"));
		listDrop(depcitylist, getdata("Departure"));
		sendKeysMethod(descity, getdata("Destination"));
		listDrop(depcitylist, getdata("Destination"));
		String[] date = splitString(dateSel(Integer.parseInt(getdata("date"))),"/");
		String mnth = date[0];
		String depdate = date[1];
		System.out.println("mnth  "+mnth);
		System.out.println("depdate  "+depdate);
		String[] rtrndate = splitString(dateSel(Integer.parseInt(getdata("returndate"))),"/");
		String returnmonth = rtrndate[0];
		String returnday = rtrndate[1];
		System.out.println("returnmonth  "+returnmonth);
		System.out.println("returnday"+returnday);
		if (!getdata("trip") .equalsIgnoreCase("round trip")) {
			clickMethod(calenderbox, "Calender box");
			monthloc(month, mnth, nextarrow);
			listDrop(dateele, depdate);
		} else { 
			clickMethod(roundtrip, "Round trip button");
			clickMethod(departuredate, "departure Calender box");
			monthloc(depmonth, mnth, nextarrow);
			listDrop(dateele, depdate);
			monthloc(monthreturn, returnmonth, returnnxtarw);
			Thread.sleep(3000);
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
	@Step("To Input number of passanger")
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
