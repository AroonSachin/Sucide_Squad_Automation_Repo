package pageobjects.phptravels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

public class Invoicepage extends CommonActionMethods{
	@FindBy(id = "form")
	WebElement proceedbutton;
	
	public Invoicepage(){
		PageFactory.initElements(new AjaxElementLocatorFactory(DriverFactory.getDriver(), 30), this);
	}
	
	public void proceed() throws Exception {
		clickMethod(proceedbutton, "Proceed button");
	}
}
