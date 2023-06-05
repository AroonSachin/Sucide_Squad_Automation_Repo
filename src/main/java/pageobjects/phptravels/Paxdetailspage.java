package pageobjects.phptravels;

import java.text.SimpleDateFormat;
import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import com.github.javafaker.Faker;
import commonuseractions.CommonActionMethods;
import commonuseractions.CommonVariables;
import io.qameta.allure.Step;
import utils.DriverFactory;

/**
 * This class fills up the passenger details.
 *
 * @author amaduraiveeran
 *
 */
public class Paxdetailspage extends CommonActionMethods {
	int totPAX = 0;
	String adltNO="";
	String chldNO="";
	String infNO="";
	
	Double totalprz =0.0;
	Faker fake = new Faker(new Locale("en-IN"));

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
	@Step("To input Personal details of the passenger ")
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
	@Step("To input title of every passenger")
	public void title() throws Exception {
		int titleitrt = 1;
		String[] titlearr = splitString(getdata("paxtitle"),",");
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
	@Step("To input Nationality of every passenger")
	public void nationality() throws Exception {
		int natitrt = 1;
		for (int i = 1;i<=totPAX;i++) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='nationality_"+natitrt+"']"));
			selectByVisibleText(ele,fakeCountry());
			natitrt++;
		}
	}
	/**
	 * this method selects the month of birth of the passengers
	 * @param DOBmonth
	 * @throws Exception
	 */
	@Step("To input Month of birth of every passenger")
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
	@Step("To input day of birth of every passenger")
	public void dobday() throws Exception {
		int dobdayitrt= 1;
		for (int i = 1;i<=totPAX;i++) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='dob_day_"+dobdayitrt+"']"));
			String day = fakeDOB("d");
			if(Integer.valueOf(day)>=30) {
				int actlday = Integer.valueOf(day)-1;
			selectByVisibleText(ele, String.valueOf(actlday));
			}else {
				selectByVisibleText(ele, day);
			}
			dobdayitrt++;
		}
	}
	/**
	 * this method selects the year of birth of the passenger.
	 * @param DOByear
	 * @throws Exception
	 */
	@Step("To input Year of birth of every passenger")
	public void dobYear() throws Exception {
		int dobdayitrt = 1;
		for(int i = 1;i<=totPAX;i++) {
			if (i<=(totPAX-Integer.valueOf(infNO))) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='dob_year_"+dobdayitrt+"']"));
			selectByVisibleText(ele, fakeDOB("YYYY"));
			dobdayitrt++;
			}else {
				WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='dob_year_"+dobdayitrt+"']"));
				selectByVisibleText(ele, "2022");
				dobdayitrt++;
			}
		}
	}
	/**
	 * This method selects the passport issuence month.
	 * @param PIDmonth
	 * @throws Exception
	 */
	@Step("To input Passport issuence month of every passenger")
	public void pidMonth() throws Exception {
		int pidmnthitrt = 1;
		for (int i = 1;i<=totPAX;i++) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='passport_issuance_month_"+pidmnthitrt+"']"));
			selectByValue(ele, fakeDOB("MM"));
			pidmnthitrt++;
		}
	}
	/**
	 * This method selects the passport issuence day.
	 * @param PIDday
	 * @throws Exception
	 */
	@Step("To input Passport issuence day of every passenger")
	public void pidDay() throws Exception {
		int piddayitrt = 1;
		for (int i = 1;i<=totPAX;i++) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='passport_issuance_day_"+piddayitrt+"']"));
			selectByVisibleText(ele, fakeDOB("d"));
			piddayitrt++;
		}
	}
	/**
	 * This method selects the passport issuence Year.
	 * @param PIDyear
	 * @throws Exception
	 */
	@Step("To input Passport issuence year of every passenger")
	public void pidYear() throws Exception {
		int pidyearitrt=1;
		for(int i = 1;i<=totPAX;i++) {
			WebElement ele =DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='passport_issuance_year_"+pidyearitrt+"']"));
			selectByVisibleText(ele, fakeDOB("YYYY"));
			pidyearitrt++;
		}
	}
	/**
	 * This method selects the passport expiry Year.
	 * @param PEDyear
	 * @throws Exception
	 */
	@Step("To input Passport expiry year of every passenger")
	public void pedYear() throws Exception {
		int pedyearitrt = 1;
		for(int i = 1;i<=totPAX;i++) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='passport_year_"+pedyearitrt+"']"));
			selectByVisibleText(ele, "2024");
			pedyearitrt++;
		}
	}
	/**
	 *This method selects the passport expiry month.
	 * @param PEDmonth
	 * @throws Exception
	 */
	@Step("To input Passport expiry month of every passenger")
	public void pedMonth() throws Exception {
		int pedmonthitrt = 1;
		for(int i = 1;i<=totPAX;i++) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='passport_month_"+pedmonthitrt+"']"));
			selectByValue(ele, fakeDOB("MM"));
			pedmonthitrt++;
		}
	}
	/**
	 * This method selects the passport expiry day.
	 * @param PEDday
	 * @throws Exception
	 */
	@Step("To input Passport expiry day of every passenger")
	public void pedDay() throws Exception {
		int peddayitrt = 1;
		for(int i = 1;i<=totPAX;i++) {
			WebElement ele =DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='passport_day_"+peddayitrt+"']"));
			selectByVisibleText(ele, fakeDOB("d"));
			peddayitrt++;
		}
	}
	/**
	 * This method sends the first name of the passenger's.
	 * @param firstname
	 * @throws Exception
	 */
	@Step("To input firstname of every passenger")
	public void firstName() throws Exception {
		int firstnameitrt = 1;
		for (int i = 1;i<=totPAX;i++) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//input[@name='firstname_"+firstnameitrt+"']"));
			sendKeysMethod(ele,fakefirstName());
			firstnameitrt++;
		}
	}
	/**
	 * This method sends the last name of the passengers.
	 * @param lastname
	 * @throws Exception
	 */
	@Step("To input Lastname of every passenger")
	public void lastName() throws Exception {
		int lastnameitrt = 1;
		for (int i = 1;i<=totPAX;i++) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//input[@name='lastname_"+lastnameitrt+"']"));
			sendKeysMethod(ele,fakeLastName());
			lastnameitrt++;
		}
	}
	
	public String fakePassid() {
		return String.valueOf(fake.number().randomNumber(12, true));
	}
	
	public void tcCheckBox() throws Exception {
		try {
			JavascriptExecutor executor = (JavascriptExecutor)DriverFactory.getDriver();
			executor.executeScript("arguments[0].click();", TCbox);
			logMessage("Term's and condition checkbox clicked");
		} catch (Exception e) {
			logErrorMessage("Term's and condition checkbox not clicked");
		}
	}
	
	public void clickBook() throws Exception {
		try {
			JavascriptExecutor executor = (JavascriptExecutor)DriverFactory.getDriver();
			executor.executeScript("arguments[0].click();", confirmbooking);
			logMessage("confirm booking button is clicked");
		} catch (Exception e) {
			logErrorMessage("confirm booking button is not clicked");
		}
	}
	
	/**
	 * This method sends the passportID of the passengers.
	 * @param passportid
	 * @throws Exception
	 */
	@Step("To input passportID of every passenger")
	public void passportID() throws Exception {
		int passportitrt=1;
		for (int i = 1;i<=totPAX;i++) {
		WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//input[@name='passport_"+passportitrt+"']"));
		sendKeysMethod(ele,fakePassid());
		passportitrt++;
		}
	}
	/**
	 * This method check the terms and condition checkbox and clicks the confirm booking button.
	 * @throws Exception
	 */
	@Step("To check the terms and condition's checkbox and click book button")
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
		CommonVariables.setAdltpreprz(Double.valueOf(Aprz[1])); 
		CommonVariables.setChldpreprz( Double.valueOf(Cprz[1])); 
		CommonVariables.setInftpreprz(Double.valueOf(Iprz[1])); 
		totalprz = Double.valueOf(totprz[1]);
	}
	/**
	 * This method splits and validates the Total price.
	 * @throws Exception
	 */
	@Step("To validate total price")
	public void validatePrice() throws Exception {
		splitPrice();
		double acttotal  =CommonVariables.getAdltpreprz() +CommonVariables.getChldpreprz()+CommonVariables.getInftpreprz();
		checkEquality(acttotal, totalprz);
	}
	/**
	 * This method adds the pax price and returns the total.
	 * @return
	 */
	public static double returntotal() {
		return CommonVariables.getAdltpreprz() +CommonVariables.getChldpreprz()+CommonVariables.getInftpreprz();

	}
	
	public String fakefirstName() {
		return fake.name().firstName();
	}
	
	public String fakeLastName() {
		return fake.name().lastName();
	}
	
	public String fakeMail() {
		return fake.internet().safeEmailAddress();
	}
	
	public String fakePhone() {
		return fake.phoneNumber().cellPhone();
	}
	
	public String fakeAddress() {
		return fake.address().fullAddress();
	}
	
	public String fakeCountry() {
		return fake.country().name();
	}
	
	
	
	public void personalDet() throws Exception {
		sendKeysMethod(perfirstname,fakefirstName());
		sendKeysMethod(perlastname, fakeLastName());
		sendKeysMethod(peremail, fakeMail());
		sendKeysMethod(perphone, fakePhone());
		sendKeysMethod(peraddress, fakeAddress());
		logMessage(fakeCountry());
		try {
		selectByVisibleText(percountry,fakeCountry());
		selectByVisibleText(pernationality,fakeCountry());
		}catch(Exception e) {
			selectByVisibleText(percountry,"India");
			selectByVisibleText(pernationality,"India");
		}
		
	}
	
	public String fakeTitle() {
		String rtrnstrng = fake.name().prefix().replace(".","");
		if(rtrnstrng.equalsIgnoreCase("dr") || rtrnstrng.equalsIgnoreCase("Ms") ) {
			return "Mr";
		}else {
			return rtrnstrng ;
		}
	}
	
	public String fakeDOB(String format){
		SimpleDateFormat smp = new SimpleDateFormat(format);
		return smp.format(fake.date().birthday());
	}
	
	public void paxTitle() throws Exception {
		String[] paxARR = splitString(CommonVariables.getPaxno(),",");
		adltNO=paxARR[0];
		chldNO=paxARR[1];
		infNO=paxARR[2];
		totPAX = Integer.valueOf(adltNO)+Integer.valueOf(chldNO)+Integer.valueOf(infNO);
		for (int i = 1;i<=totPAX;i++) {
			WebElement Title = DriverFactory.getDriver()
					.findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='title_" + i + "']"));
			selectByVisibleText(Title, fakeTitle().toUpperCase());
		}
	}
	
	public void paxNationality() throws Exception {
		int natitrt = 1;
		for (String nationality:splitString(getdata("nationality"),",")) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='nationality_"+natitrt+"']"));
			selectByVisibleText(ele,nationality);
			natitrt++;
		}
	}
	
	public void paxdobMonth() throws Exception {
		for (int i = 1;i<=totPAX;i++) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='dob_month_"+i+"']"));
			selectByValue(ele, fakeDOB("MM"));
		}
	}

}