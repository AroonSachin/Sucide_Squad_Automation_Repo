package pageobjects.phptravels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

public class Homepage extends CommonActionMethods{
	@FindBy(xpath = "(//ul[@class='nav nav-tabs listitems']//button)[2]")
	static WebElement flightbutton;
	
	@FindBy(xpath = "(//div[@class='row contact-form-action g-1']//input)[1]")
	static
	WebElement depcity;
	
	@FindBy(xpath = "(//div[@class='row contact-form-action g-1']//input)[2]")
	static
	WebElement descity;
	
	
	
	public Homepage() {
		 PageFactory.initElements(new AjaxElementLocatorFactory(DriverFactory.getDriver(), 30), this);
	}
	
	
	public void SearchFlight() throws Exception {
		logMessage("Current URL:"+getURL());
		logMessage("Current page title:"+getTitle());
		clickMethod(flightbutton,"Flight button");
		sendKeysMethod(depcity, "MAA");
		sendKeysMethod(descity, "LAS");
		
	}
	
	

}
