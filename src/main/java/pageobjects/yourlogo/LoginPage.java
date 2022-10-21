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
	/**
	 * @This method for clicking a sigin button 
	 * @throws Exception
	 */
	public void siginButton() throws Exception {
		webWait(signin);
		clickMethod(signin, "sigin");
	}
	/**
	 * @This method for enter the valid mail address
	 * @throws Exception
	 */
	public void email() throws Exception {
		String mail = "venkatesh22+" + mail() + "@gmail.com";
		sendKeysMethod(emailaddress, mail);
	}
	/**
	 * @This method for clicking a create account button
	 * @throws Exception
	 */
	public void createAccount() throws Exception {
		clickMethod(submitbutton, "submitbutton");

	}
	/**
	 * @This method for clicking a gender button
	 * @throws Exception
	 */
	public void gender() throws Exception   {
		clickMethod(selectgender, "selectgender");

	}
	/**
	 * This method for entered the first name
	 * @param firstName
	 * @throws Exception
	 */
	public void firstName(String firstName) throws Exception {
		sendKeysMethod(firstname, firstName);

	}
	/**
	 * @This method for entered the last name 
	 * @throws Exception
	 */
	public void lastName(String LastName) throws Exception {
		sendKeysMethod(lastname, LastName);
	}
	/**
	 * @This method for clicking a emailcheckbox
	 * @throws Exception
	 */
	public void emailCheckBox() throws Exception {
		clickMethod(email, "email");
	}
	/**
	 * @This method for entered the password
	 * @param passWord
	 * @throws Exception
	 */
	public void passWord(String passWord) throws Exception {
		sendKeysMethod(password, passWord);

	}
	/**
	 * @This method for selecting a date of birth
	 * @param date
	 * @param month
	 * @param year
	 * @throws Exception
	 */
	public void dateOfBirth(String date) throws Exception {
		String[] DOB=splitString(date, "/");
		selectByValue(birthdate,DOB[0]);
		selectByValue(birthmonth, DOB[1] );
		selectByValue(birthyear, DOB[2] );
	}
	/**
	 * @This method for clicking a address firstname
	 * @throws Exception
	 */
	public void addressfirstname() throws Exception {
		clickMethod(addressfirstname, "addressfirstname");
	}
	/**
	 * @This method for clicking a address lastname
	 * @throws Exception
	 */
	public void addresslastname() throws Exception {
		clickMethod(addresslastname, "addresslastname");
	}
	/**
	 * @This method for entered the company name
	 * @param companyName
	 * @throws Exception
	 */
	public void companyName(String companyName) throws Exception {
		sendKeysMethod(companyname, companyName);
	}
	/**
	 * @This method for entered the Address
	 * @param Address
	 * @throws Exception
	 */
	public void address(String Address) throws Exception {
		sendKeysMethod(address,Address );
	}
	/**
	 * @This method for entered the cityname
	 * @param cityName
	 * @throws Exception
	 */
	public void cityName(String cityName) throws Exception {
		sendKeysMethod(cityname,cityName );
	}
	/**
	 * @This method for selecting a state name
	 * @param stateName
	 * @throws Exception
	 */
	public void stateName(String stateName ) throws Exception {
		selectByValue(statename, stateName);
	}
	/**
	 * @This method for entered the postal code
	 * @param postalCode
	 * @throws Exception
	 */
	public void postalCode(String postalCode) throws Exception {
		sendKeysMethod(postalcode, postalCode);
	}
	/**
	 * @This method for clicking a country name
	 * @throws Exception
	 */
	public void countryName() throws Exception {
		clickMethod(countryname, "countryname");
		
	}
	/**
	 * @This method for entered the phone number
	 * @param phoneNumber
	 * @throws Exception
	 */
	public void phoneNumber(String phoneNumber) throws Exception {
		sendKeysMethod(phonenumber, phoneNumber);
	}
	/**
	 * @This method for clicking a register button
	 * @throws Exception
	 */
	public void registerButton() throws Exception {
		clickMethod(registerbutton, "registerbutton");
	}
	}
