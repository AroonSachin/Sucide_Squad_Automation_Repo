package pageobjects.phptravels;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import commonuseractions.CommonActionMethods;
import io.qameta.allure.Step;
import utils.DriverFactory;

/**
 * This class chooses the flight and validates the departure and destination
 * cities and date.
 *
 * @author amaduraiveeran
 *
 */
public class Flightchoosepage extends CommonActionMethods {

	@FindBy(xpath = "(//button[@type='submit'])[1]")
	static WebElement bookbutton;

	@FindBy(xpath = "(//p[@class='theme-search-results-item-flight-section-meta-city'])[1]")
	WebElement frmcty;

	@FindBy(xpath = "(//p[@class='theme-search-results-item-flight-section-meta-city'])[2]")
	WebElement tocty;

	@FindBy(xpath = "(//p[@class='theme-search-results-item-flight-section-meta-city'])[3]")
	WebElement rtrnfrmcity;

	@FindBy(xpath = "(//p[@class='theme-search-results-item-flight-section-meta-city'])[4]")
	WebElement rtrntocity;

	@FindBy(xpath = "(//p[@class='theme-search-results-item-flight-section-meta-time'])[1]")
	WebElement deptime;

	@FindBy(xpath = "(//p[@class='theme-search-results-item-flight-section-meta-time'])[2]")
	WebElement destime;

	@FindBy(xpath = "(//p[@class='theme-search-results-item-flight-section-meta-time'])[3]")
	WebElement rtrndeptime;

	@FindBy(xpath = "(//p[@class='theme-search-results-item-flight-section-meta-time'])[4]")
	WebElement rtrndestime;

	@FindBy(xpath = "(//p[@class='theme-search-results-item-flight-section-meta-date'])[1]")
	WebElement depdate;

	@FindBy(xpath = "(//p[@class='theme-search-results-item-flight-section-meta-date'])[2]")
	WebElement desdate;

	@FindBy(xpath = "(//p[@class='theme-search-results-item-flight-section-meta-date'])[3]")
	WebElement rtrndepdate;

	@FindBy(xpath = "(//p[@class='theme-search-results-item-flight-section-meta-date'])[4]")
	WebElement rtrndesdate;

	/**
	 * Constructor to store the webeleents
	 */
	public Flightchoosepage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(DriverFactory.getDriver(), 30), this);
	}

	/**
	 * This method is to click the book button
	 *
	 * @throws Exception
	 */
	@Step("To click book button")
	public void chooseFlight() throws Exception {

		clickMethod(bookbutton, "Book button");
	}
	/**
	 * This method returns the date added from the current date as requested.
	 * @param plusdays
	 * @return
	 */
	public static String dateSelval(int plusdays) {
		Calendar cal = Calendar.getInstance();
		cal.add(7, +plusdays);
		SimpleDateFormat date = new SimpleDateFormat();
		date.applyPattern("dd/MMM/yyyy");
		String dat = date.format(cal.getTime());
		return dat;
	}

	/**
	 * This method is to validate the flight details.
	 *
	 * @param actlfrmcty
	 * @param actltocty
	 * @param triptype
	 * @throws Exception
	 */
	@Step("To perform validation on Travel details")
	public void flightDetailValidate() throws Exception {
		getTitle();
		getURL();
		String[] frmarr = splitString(getTextElement(frmcty, "From city"), " ");
		String[] toarr = splitString(getTextElement(tocty, "To city"), " ");
		String[] rtrnfrmarr = splitString(getTextElement(rtrnfrmcity, "Return city"), " ");
		String[] rtrntoarr = splitString(getTextElement(rtrntocity, "Return to city"), " ");
		String[] datearr = splitString(getTextElement(depdate, "Departure date"), " ");
		String[] actldatearr = splitString(dateSelval(Integer.parseInt(getdata("date"))), "/");
		String[] rtrnactldatearr = splitString(dateSelval(Integer.parseInt(getdata("returndate"))), "/");
		String[] rtrndatearr = splitString(getTextElement(rtrndepdate, "return Departure date"), " ");
		String frm = frmarr[0];
		String to = toarr[0];
		String rtrnfrm = rtrnfrmarr[0];
		String rtrnto = rtrntoarr[0];
		String dateval = datearr[0];
		String mnthval = datearr[1];
		String actldayval = actldatearr[0];
		String actlmnthval = actldatearr[1];
		String rtrndayval = rtrndatearr[0];
		String rtrnmnthval = rtrndatearr[1];
		String rtrnactldayval = rtrnactldatearr[0];
		String rtrnactlmnthval = rtrnactldatearr[1];
		if (getdata("trip").equalsIgnoreCase("round trip")) {
			checkEquality(frm, getdata("Departure"));
			checkEquality(to, getdata("Destination"));
			checkEquality(dateval, actldayval);
			checkEquality(mnthval, actlmnthval);
		} else {
			checkEquality(frm, getdata("Departure"));
			checkEquality(to, getdata("Destination"));
			checkEquality(rtrnfrm, getdata("Destination"));
			checkEquality(rtrnto, getdata("Departure"));
			checkEquality(dateval, actldayval);
			checkEquality(mnthval, actlmnthval);
			checkEquality(rtrnmnthval, rtrnactlmnthval);
			checkEquality(rtrndayval, rtrnactldayval);
		}
	}
}
