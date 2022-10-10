package pageobjects.yourlogo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

/**
 * @This class is to login the page
 * @author vbaskar
 *
 */
public class LoginPage extends CommonActionMethods {
	@FindBy(xpath = "//div[@class='header_user_info']//a[@title='Log in to your customer account']")
	public static WebElement signin;

	@FindBy(id = "email_create")
	public static WebElement emailaddress;

	@FindBy(id = "SubmitCreate")
	public static WebElement submitbutton;

	@FindBy(xpath = "//label[@for='id_gender1']")
	public static WebElement selectgender;

	@FindBy(id = "customer_firstname")
	public static WebElement firstname;

	@FindBy(id = "customer_lastname")
	public static WebElement lastname;

	@FindBy(id = "email")
	public static WebElement email;

	@FindBy(id = "passwd")
	public static WebElement password;

	@FindBy(xpath = "//div[@class='col-xs-4']//select[@id='days']")
	public static WebElement birthdate;

	@FindBy(xpath = "//div[@id='uniform-months']//select[@id='months']")
	public static WebElement birthmonth;

	@FindBy(id = "years")
	public static WebElement birthyear;

	@FindBy(id = "firstname")
	public static WebElement addressfirstname;

	@FindBy(id = "lastname")
	public static WebElement addresslastname;

	@FindBy(id = "company")
	public static WebElement companyname;

	@FindBy(id = "address1")
	public static WebElement address;

	@FindBy(id = "city")
	public static WebElement cityname;

	@FindBy(id = "id_state")
	public static WebElement statename;

	@FindBy(id = "postcode")
	public static WebElement postalcode;

	@FindBy(id = "id_country")
	public static WebElement countryname;

	@FindBy(id = "phone_mobile")
	public static WebElement phonenumber;

	@FindBy(id = "submitAccount")
	public static WebElement registerbutton;

	public LoginPage() {

		PageFactory.initElements(new AjaxElementLocatorFactory(DriverFactory.getDriver(), 30), this);

	}

	/**
	 * @This method should be used for print a emailaddress with current time
	 * @return
	 */

	private String mail() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat date = new SimpleDateFormat();
		date.applyPattern("ssSS");
		String dat = date.format(cal.getTime());
		return dat;
	}

	/**
	 * @This method should be used for call the elements
	 * @throws Exception
	 */

	public void login() throws Exception {
		getURL();
		webWait(signin);
		clickMethod(signin, "sigin");
		String mail = "venkatesh22+" + mail() + "@gmail.com";
		sendKeysMethod(emailaddress, mail);
		clickMethod(submitbutton, "submitbutton");
		clickMethod(selectgender, "selectgender");
		sendKeysMethod(firstname, getdata("Firstname"));
		sendKeysMethod(lastname, getdata("Lastname"));
		clickMethod(email, "email");
		sendKeysMethod(password, getdata("Password"));
		selectByValue(birthdate, getdata("Birthdate"));
		selectByValue(birthmonth, getdata("Birthmonth"));
		selectByValue(birthyear, getdata("BirthYear"));
		clickMethod(addressfirstname, "addressfirstname");
		clickMethod(addresslastname, "addresslastname");
		sendKeysMethod(companyname, getdata("CompanyName"));
		sendKeysMethod(address, getdata("Address"));
		sendKeysMethod(cityname, getdata("Cityname"));
		selectByValue(statename, getdata("Statename"));
		sendKeysMethod(postalcode, getdata("Pincode"));
		clickMethod(countryname, "countryname");
		sendKeysMethod(phonenumber, getdata("PhoneNumber"));
		clickMethod(registerbutton, "registerbutton");
	}

}
