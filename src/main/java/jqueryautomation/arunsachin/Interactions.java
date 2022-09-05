package jqueryautomation.arunsachin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

public class Interactions extends CommonActionMethods {
	
	@FindBy(xpath = "//a[contains(text(),'Draggable')]")
	WebElement draggableButton;
	
	@FindBy(xpath = "//iframe[@class='demo-frame']")
	WebElement demoFrame;
	
	@FindBy(xpath = "//p[contains(text(),'Drag me around')]")
	WebElement dragbox;
	
	public Interactions() {
		PageFactory.initElements(new AjaxElementLocatorFactory(DriverFactory.getDriver(), 30), this);
	}
	
	public void validatePage() {
		getTitle();
		getURL();
	}
	
	
	public void draggeble() throws Exception {
		clickMethod(draggableButton,"Draggeble button");
		frameByElement(demoFrame);
		Actions act = new Actions(DriverFactory.getDriver());
		act.dragAndDropBy(dragbox, +1000, +1000).build().perform();
		defaultwindow();
	}
	
	

}
