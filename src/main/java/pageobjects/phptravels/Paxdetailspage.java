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
	public void nationality(String paxnationality) throws Exception {
		int natitrt = 1; 
		
		for (String nationality:splitString(paxnationality)) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='nationality_"+natitrt+"']"));
			selectByVisibleText(ele,paxnationality);
			natitrt++;
		}
	}
	public void dobMonth(String DOBmonth) throws Exception {
		int dobmnthitrt = 1;
		for (String dom:splitString(DOBmonth)) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='dob_month_"+dobmnthitrt+"']"));
			selectByValue(ele, dom);
			dobmnthitrt++;
		}
	}
	public void dobday(String DOBday) throws Exception {
		int dobdayitrt= 1;
		for (String dod:splitString(DOBday)) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='dob_day_"+dobdayitrt+"']"));
			selectByValue(ele, dod);
			dobdayitrt++;
		}
	}
	public void dobYear(String DOByear) throws Exception {
		int dobdayitrt = 1;
		for(String doy:splitString(DOByear)) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='dob_year_"+dobdayitrt+"']"));
			selectByVisibleText(ele, doy);
			dobdayitrt++;
		}
	}
	public void pidMonth(String PIDmonth) throws Exception {
		int pidmnthitrt = 1;
		for (String pidm:splitString(PIDmonth)) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='passport_issuance_month_"+pidmnthitrt+"']"));
			selectByValue(ele, pidm);
			pidmnthitrt++;
		}
	}
	public void pidDay(String PIDday) throws Exception {
		int piddayitrt = 1;
		for (String pidd:splitString(PIDday)) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='passport_issuance_day_"+piddayitrt+"']"));
			selectByVisibleText(ele, pidd);
			piddayitrt++;
		}
	}
	public void pidYear(String PIDyear) throws Exception {
		int pidyearitrt=1;
		for(String pidy:splitString(PIDyear)) {
			WebElement ele =DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='passport_issuance_year_"+pidyearitrt+"']"));
			selectByVisibleText(ele, pidy);
			pidyearitrt++;
		}
	}
	public void pedYear(String PEDyear) throws Exception {
		int pedyearitrt = 1;
		for(String pedy:splitString(PEDyear)) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='passport_year_"+pedyearitrt+"']"));
			selectByVisibleText(ele, pedy);
			pedyearitrt++;
		}
	}
	public void pedMonth(String PEDmonth) throws Exception {
		int pedmonthitrt = 1;
		for(String pedm:splitString(PEDmonth)) {
			WebElement ele = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='passport_month_"+pedmonthitrt+"']"));
			selectByValue(ele, pedm);
			pedmonthitrt++;
		}
	}
	public void pedDay(String PEDday) throws Exception {
		int peddayitrt = 1;
		for(String pedd:splitString(PEDday)) {
			WebElement ele =DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='passport_day_"+peddayitrt+"']"));
			selectByVisibleText(ele, pedd);
			peddayitrt++;
		}
	}
}
