package jqueryautomation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

public class JQuerySowmya extends CommonActionMethods {
	
	public JQuerySowmya()
	{
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}
	@FindBy(xpath = "//<a>[text()='Draggable']")
	private static WebElement dragButton;
	
	
	
	
	public void draggable()
	{
		dragButton.click();
	}
	
	

}
