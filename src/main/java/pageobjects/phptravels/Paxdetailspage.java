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
	 * @throws Exception
	 */
	public void personalDetails(String firstnameper,String lastnameper,String emailper,String phoneper,String addressper,String countryper,String nationalityper) throws Exception {
		sendKeysMethod(perfirstname, "arun");
		sendKeysMethod(perlastname, "sachin");
		sendKeysMethod(peremail, "test@mail.com");
		sendKeysMethod(perphone,"1234567890");
		sendKeysMethod(peraddress, "teststreet,testcity");
		selectByVisibleText(percountry, "India");
		selectByVisibleText(pernationality,"India");
	}
	
	public void title(String paxtitle) throws Exception {
		
		int titleitrt = 1;
		String titlearr[] = paxtitle.split("||");
		for (int i = 0;i<=titlearr.length;i++){
			System.out.println("sep:"+titlearr[i]);
		}
		for(String title:titlearr) {
			System.out.println(titleitrt);
			WebElement Title = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='card-body'])[1]//select[@name='title_"+titleitrt+"']"));
			System.out.println(title);
			webWait(Title);
			clickMethod(Title, "Title box");
			selectByValue(Title,title);
			
			titleitrt++;
		}
		
	}
	
}
