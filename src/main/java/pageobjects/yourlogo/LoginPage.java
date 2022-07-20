package pageobjects.yourlogo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

public class LoginPage extends CommonActionMethods {
	@FindBy(xpath="//div[@class='header_user_info']//a[@title='Log in to your customer account']")
	public static WebElement signin;

	@FindBy(xpath = "//input[@id='email_create']")
	public static WebElement emailaddress;

	@FindBy(xpath = "//button[@id = 'SubmitCreate']")
	public static WebElement submitbutton;

	@FindBy(xpath = "//label[@for='id_gender1']")
	public static WebElement selectgender;

	@FindBy(xpath = "//input[@id='customer_firstname']")
	public static WebElement firstname;

	@FindBy(xpath = "//input[@id='customer_lastname']")
	public static WebElement lastname;

	@FindBy(xpath = "//input[@id='email']")
	public static WebElement email;

	@FindBy(xpath = "//input[@id='passwd']")
	public static WebElement password;

	@FindBy(xpath = "//div[@class='col-xs-4']//select[@id='days']")
	public static WebElement birthdate;

	@FindBy(xpath="//div[@id='uniform-months']//select[@id='months']")
	public static WebElement birthmonth;

	@FindBy(xpath = "//select[@id='years']")
	public static WebElement birthyear;

	@FindBy(xpath = "//input[@id='firstname']")
	public static WebElement addressfirstname;

	@FindBy(xpath = "//input[@id='lastname']")
	public static WebElement addresslastname;

	@FindBy(xpath = "//input[@id='company']")
	public static WebElement companyname;

	@FindBy(xpath = "//input[@id='address1']")
	public static WebElement address;

	@FindBy(xpath = "//input[@id='city']")
	public static WebElement cityname;

	@FindBy(xpath = "//select[@id='id_state']")
	public static WebElement statename;

	@FindBy(xpath = "//input[@id='postcode']")
	public static WebElement postalcode;

	@FindBy(xpath = "//select[@id='id_country']")
	public static WebElement countryname;

	@FindBy(xpath = "//input[@id='phone_mobile']")
	public static WebElement phonenumber;

	@FindBy(xpath = "//button[@id='submitAccount']")
	public static WebElement registerbutton;
	
	
	
	public LoginPage() {

		PageFactory.initElements(new AjaxElementLocatorFactory(DriverFactory.getDriver(), 30), this);

	}
	
	public void login(String emailid,String Firstname,String Lastname,String Password,String Birthdate,String Birthmonth,String Birthyear,String Companyname,String Address,String Cityname,String Statename,String pincode,String Phonenumber) throws Exception {
		Thread.sleep(10000);
		clickMethod(signin, "sigin");
		sendKeysMethod(emailaddress, emailid);
		clickMethod(submitbutton,"submitbutton" );
		clickMethod(selectgender, "selectgender");
		sendKeysMethod(firstname,Firstname);
		sendKeysMethod(lastname, Lastname);
		clickMethod(email, "email");
		sendKeysMethod(password, Password);
		selectByValue(birthdate, Birthdate);
		Thread.sleep(3000);
		selectByValue(birthmonth, Birthmonth);
		selectByValue(birthyear, Birthyear);
		clickMethod(addressfirstname, "addressfirstname");
		clickMethod(addresslastname, "addresslastname");
		sendKeysMethod(companyname, Companyname);
		sendKeysMethod(address, Address);
		sendKeysMethod(cityname, Cityname);
		selectByValue(statename, Statename);
		sendKeysMethod(postalcode,pincode);
		clickMethod(countryname, "countryname");
		sendKeysMethod(phonenumber,Phonenumber);
		clickMethod(registerbutton, "registerbutton");
	}


}
