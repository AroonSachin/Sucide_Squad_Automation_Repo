package pageobjects.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

/**
 * This class fills up the passenger details.
 * 
 * @author amaduraiveeran
 *
 */
public class Paxdetailspage extends CommonActionMethods {

	@FindBy(xpath = "//div[@class='form-content ']//input[@name='firstname']")
	WebElement perfirstname;

	@FindBy(xpath = "//div[@class='form-content ']//input[@name='lastname']")
	WebElement perlastname;

	@FindBy(xpath = "//div[@class='form-content ']//input[@name='email']")
	WebElement peremail;

	@FindBy(xpath = "//div[@class='form-content ']//input[@name='phone']")
	WebElement perphone;

	@FindBy(xpath = "//div[@class='form-content ']//input[@name='address']")
	WebElement peraddress;

	@FindBy(xpath = "//div[@class='form-content ']//select[@name='nationality']")
	WebElement pernationality;

	@FindBy(xpath = "//div[@class='form-content ']//select[@name='country_code']")
	WebElement percountry;
	
	@FindBy(xpath = "//label[@for='agreechb']")
	WebElement TCbox;
	
	@FindBy(id = "booking")
	WebElement confirmbooking;

	/**
	 * Constructor to store the elements which are located above.
	 */
	public Paxdetailspage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(DriverFactory.getDriver(), 30), this);
	}

	/**
	 * This method fills up the personal details section.
	 * 
	 * @throws Exception
	 */
	public void personalDetails(String firstnameper, String lastnameper, String emailper, String phoneper,
			String addressper, String countryper, String nationalityper) throws Exception {
		sendKeysMethod(perfirstname, "arun");
		sendKeysMethod(perlastname, "sachin");
		sendKeysMethod(peremail, "test@mail.com");
		sendKeysMethod(perphone, "1234567890");
		sendKeysMethod(peraddress, "teststreet,testcity");
		selectByVisibleText(percountry, "India");
		selectByVisibleText(pernationality, "India");
	}
	/**
	 * This method selects the given title to the passengers
	 * @param paxtitle
	 * @throws Exception
	 */
	public void title(String paxtitle) throws Exception {
		int titleitrt = 1;
		String titlearr[] = splitString(paxtitle);
		for (String title : titlearr) {
			WebElement Title = DriverFactory.getDriver()
					.findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='title_" + titleitrt + "']"));
			selectByVisibleText(Title, title);
			titleitrt++;
		}
	}
	/**
	 * This method select's the given nation of the passengers
	 * @param paxnationality
	 * @throws Exception
	 */
	public void nationality(String paxnationality) throws Exception {
		int natitrt = 1; 
		
		for (String nationality:splitString(paxnationality)) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='nationality_"+natitrt+"']"));
			selectByVisibleText(ele,paxnationality);
			natitrt++;
		}
	}
	/**
	 * this method selects the month of birth of the passengers
	 * @param DOBmonth
	 * @throws Exception
	 */
	public void dobMonth(String DOBmonth) throws Exception {
		int dobmnthitrt = 1;
		for (String dom:splitString(DOBmonth)) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='dob_month_"+dobmnthitrt+"']"));
			selectByValue(ele, dom);
			dobmnthitrt++;
		}
	}
	/**
	 * this method selects the Day of birth of the passenger
	 * @param DOBday
	 * @throws Exception
	 */
	public void dobday(String DOBday) throws Exception {
		int dobdayitrt= 1;
		for (String dod:splitString(DOBday)) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='dob_day_"+dobdayitrt+"']"));
			selectByValue(ele, dod);
			dobdayitrt++;
		}
	}
	/**
	 * this method selects the year of birth of the passenger.
	 * @param DOByear
	 * @throws Exception
	 */
	public void dobYear(String DOByear) throws Exception {
		int dobdayitrt = 1;
		for(String doy:splitString(DOByear)) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='dob_year_"+dobdayitrt+"']"));
			selectByVisibleText(ele, doy);
			dobdayitrt++;
		}
	}
	/**
	 * This method selects the passport issuence month.
	 * @param PIDmonth
	 * @throws Exception
	 */
	public void pidMonth(String PIDmonth) throws Exception {
		int pidmnthitrt = 1;
		for (String pidm:splitString(PIDmonth)) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='passport_issuance_month_"+pidmnthitrt+"']"));
			selectByValue(ele, pidm);
			pidmnthitrt++;
		}
	}
	/**
	 * This method selects the passport issuence day.
	 * @param PIDday
	 * @throws Exception
	 */
	public void pidDay(String PIDday) throws Exception {
		int piddayitrt = 1;
		for (String pidd:splitString(PIDday)) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='passport_issuance_day_"+piddayitrt+"']"));
			selectByVisibleText(ele, pidd);
			piddayitrt++;
		}
	}
	/**
	 * This method selects the passport issuence Year.
	 * @param PIDyear
	 * @throws Exception
	 */
	public void pidYear(String PIDyear) throws Exception {
		int pidyearitrt=1;
		for(String pidy:splitString(PIDyear)) {
			WebElement ele =DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='passport_issuance_year_"+pidyearitrt+"']"));
			selectByVisibleText(ele, pidy);
			pidyearitrt++;
		}
	}
	/**
	 * This method selects the passport expiry Year.
	 * @param PEDyear
	 * @throws Exception
	 */
	public void pedYear(String PEDyear) throws Exception {
		int pedyearitrt = 1;
		for(String pedy:splitString(PEDyear)) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='passport_year_"+pedyearitrt+"']"));
			selectByVisibleText(ele, pedy);
			pedyearitrt++;
		}
	}
	/**
	 *This method selects the passport expiry month. 
	 * @param PEDmonth
	 * @throws Exception
	 */
	public void pedMonth(String PEDmonth) throws Exception {
		int pedmonthitrt = 1;
		for(String pedm:splitString(PEDmonth)) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='passport_month_"+pedmonthitrt+"']"));
			selectByValue(ele, pedm);
			pedmonthitrt++;
		}
	}
	/**
	 * This method selects the passport expiry day.
	 * @param PEDday
	 * @throws Exception
	 */
	public void pedDay(String PEDday) throws Exception {
		int peddayitrt = 1;
		for(String pedd:splitString(PEDday)) {
			WebElement ele =DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='passport_day_"+peddayitrt+"']"));
			selectByVisibleText(ele, pedd);
			peddayitrt++;
		}
	}
	/**
	 * This method sends the first name of the passenger's.
	 * @param firstname
	 * @throws Exception
	 */
	public void firstName(String firstname) throws Exception {
		int firstnameitrt = 1;
		for (String fn:splitString(firstname)) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//input[@name='firstname_"+firstnameitrt+"']"));
			sendKeysMethod(ele,fn);
		}
	}
	/**
	 * This method sends the last name of the passengers.
	 * @param lastname
	 * @throws Exception
	 */
	public void lastName(String lastname) throws Exception {
		int lastnameitrt = 1;
		for (String ln:splitString(lastname)) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//input[@name='lastname_"+lastnameitrt+"']"));
			sendKeysMethod(ele,ln);
		}
	}
	/**
	 * This method sends the passportID of the passengers.
	 * @param passportid
	 * @throws Exception
	 */
	public void passportID(String passportid) throws Exception {
		int passportitrt=1;
		for (String pass:splitString(passportid)) {
		WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//input[@name='passport_"+passportitrt+"']"));
		sendKeysMethod(ele,pass);
		}
	}
	/**
	 * This method check the terms and condition checkbox and clicks the confirm booking button.
	 * @throws Exception
	 */
	public void clickBook() throws Exception {
		clickMethod(TCbox," T&C check box");
		clickMethod(confirmbooking, "Confirm booking button");
	}
}