package pageobjects.phptravels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

public class Flightchoosepage extends CommonActionMethods {
	
	@FindBy(xpath = "(//div[@class='row g-0'])[2]//button")
	static
	WebElement bookbutton;
	
	public Flightchoosepage(){
		PageFactory.initElements(new AjaxElementLocatorFactory(DriverFactory.getDriver(), 30), this);
	}
	
	public void chooseFlight() throws Exception {
		getTitle();
		getURL();
		clickMethod(bookbutton, "Book button");
	}

}
