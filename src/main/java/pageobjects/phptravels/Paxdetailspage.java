package pageobjects.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	static Double adltpreprz =0.0;
	static Double chldpreprz =0.0;
	static Double inftpreprz=0.0;
	Double totalprz =0.0;
	
	@FindBy(xpath = "(//div[@class='card-body p-0']//small)[1]")
	WebElement adltprice;
	
	@FindBy(xpath = "(//div[@class='card-body p-0']//small)[2]")
	WebElement childprice;
	
	@FindBy(xpath = "(//div[@class='card-body p-0']//small)[3]")
	WebElement infntprice;
	
	@FindBy(xpath = "(//div[@class='card-body p-0']//strong)[1]")
	WebElement totlprice;
	
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
	
	@FindBy(xpath = "//button[@id='booking']")
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
	public void personalDetails() throws Exception {
		sendKeysMethod(perfirstname, getdata("perfirstname"));
		sendKeysMethod(perlastname, getdata("perlastname"));
		sendKeysMethod(peremail, getdata("permail"));
		sendKeysMethod(perphone, getdata("perphone"));
		sendKeysMethod(peraddress, getdata("peraddress"));
		selectByVisibleText(percountry,getdata("percountry"));
		selectByVisibleText(pernationality, getdata("pernationality"));
	}
	/**
	 * This method selects the given title to the passengers
	 * @param paxtitle
	 * @throws Exception
	 */
	public void title() throws Exception {
		int titleitrt = 1;
		String titlearr[] = splitString(getdata("paxtitle"),",");
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
	public void nationality() throws Exception {
		int natitrt = 1; 
		
		for (String nationality:splitString(getdata("nationality"),",")) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='nationality_"+natitrt+"']"));
			selectByVisibleText(ele,nationality);
			natitrt++;
		}
	}
	/**
	 * this method selects the month of birth of the passengers
	 * @param DOBmonth
	 * @throws Exception
	 */
	public void dobMonth() throws Exception {
		int dobmnthitrt = 1;
		for (String dom:splitString(getdata("paxdom"),",")) {
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
	public void dobday() throws Exception {
		int dobdayitrt= 1;
		for (String dod:splitString(getdata("paxdod"),",")) {
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
	public void dobYear() throws Exception {
		int dobdayitrt = 1;
		for(String doy:splitString(getdata("paxdoy"),",")) {
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
	public void pidMonth() throws Exception {
		int pidmnthitrt = 1;
		for (String pidm:splitString(getdata("pidmonth"),",")) {
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
	public void pidDay() throws Exception {
		int piddayitrt = 1;
		for (String pidd:splitString(getdata("pidday"),",")) {
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
	public void pidYear() throws Exception {
		int pidyearitrt=1;
		for(String pidy:splitString(getdata("pidyear"),",")) {
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
	public void pedYear() throws Exception {
		int pedyearitrt = 1;
		for(String pedy:splitString(getdata("pedyear"),",")) {
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
	public void pedMonth() throws Exception {
		int pedmonthitrt = 1;
		for(String pedm:splitString(getdata("pedmonth"),",")) {
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
	public void pedDay() throws Exception {
		int peddayitrt = 1;
		for(String pedd:splitString(getdata("pedday"),",")) {
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
	public void firstName() throws Exception {
		int firstnameitrt = 1;
		for (String fn:splitString(getdata("firstname"),",")) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//input[@name='firstname_"+firstnameitrt+"']"));
			sendKeysMethod(ele,fn);
			firstnameitrt++;
		}
	}
	/**
	 * This method sends the last name of the passengers.
	 * @param lastname
	 * @throws Exception
	 */
	public void lastName() throws Exception {
		int lastnameitrt = 1;
		for (String ln:splitString(getdata("lastname"),",")) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//input[@name='lastname_"+lastnameitrt+"']"));
			sendKeysMethod(ele,ln);
			lastnameitrt++;
		}
	}
	/**
	 * This method sends the passportID of the passengers.
	 * @param passportid
	 * @throws Exception
	 */
	public void passportID() throws Exception {
		int passportitrt=1;
		for (String pass:splitString(getdata("passportid"),",")) {
		WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//input[@name='passport_"+passportitrt+"']"));
		sendKeysMethod(ele,pass);
		passportitrt++;
		}
	}
	/**
	 * This method check the terms and condition checkbox and clicks the confirm booking button.
	 * @throws Exception
	 */
	public void book() throws Exception {
		try {
			JavascriptExecutor executor = (JavascriptExecutor)DriverFactory.getDriver();
			executor.executeScript("arguments[0].click();", TCbox);
			logMessage("Term's and condition checkbox clicked");
		} catch (Exception e) {
			logErrorMessage("Term's and condition checkbox not clicked");
		}
		try {
			JavascriptExecutor executor = (JavascriptExecutor)DriverFactory.getDriver();
			executor.executeScript("arguments[0].click();", confirmbooking);
			logMessage("confirm booking button is clicked");
		} catch (Exception e) {
			logErrorMessage("confirm booking button is not clicked");
		}
	}
	/**
	 * This method is to split and store the Pax details in the variables for validation.
	 * @throws Exception
	 */
	public void splitPrice() throws Exception {
		String adltprz = getTextElement(adltprice,"Adult price");
		String chldprz = getTextElement(childprice,"child price");
		String inftprz = getTextElement(infntprice,"infant price");
		String[] Aprz= splitString(adltprz," ");
		String[] Cprz= splitString(chldprz," ");
		String[] Iprz= splitString(inftprz," ");
		String[] totprz = splitString(getTextElement(totlprice, "Total price"), " ");
		adltpreprz = Double.valueOf(Aprz[1]);
		chldpreprz = Double.valueOf(Cprz[1]);
		inftpreprz = Double.valueOf(Iprz[1]);
		totalprz = Double.valueOf(totprz[1]);
	}
	/**
	 * This method splits and validates the Total price.
	 * @throws Exception
	 */
	public void validatePrice() throws Exception {
		splitPrice();
		double acttotal = adltpreprz+chldpreprz+inftpreprz;
		checkEquality(acttotal, totalprz);
	}
	/**
	 * This method adds the pax price and returns the total.
	 * @return
	 */
	public static double returntotal() {
		double acttotal = adltpreprz+chldpreprz+inftpreprz;
		return acttotal;
	}


}