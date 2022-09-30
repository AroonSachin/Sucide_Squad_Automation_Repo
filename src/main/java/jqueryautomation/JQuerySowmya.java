package jqueryautomation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

public class JQuerySowmya extends CommonActionMethods {
	
	public JQuerySowmya()
	{
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}
	@FindBy(xpath = "//a[text()='Draggable']")
	public WebElement dragButton;
	
	@FindBy(id="draggable") 
	public  WebElement draggable;
	
	@FindBy(xpath = "//a[text()='Droppable']")
	public WebElement dropButton;
	
	
	
	
	
	public void draggable() throws InterruptedException
	{
		Thread.sleep(1000);
		dragButton.click();
		System.out.println("Draggable button is clicked");
	}
	
	public void dragAndDrop() throws Exception {
		frameByIndex(0);
		webWait(draggable);
		Actions drag=new Actions(DriverFactory.getDriver());
		int x= draggable.getLocation().getX();
		int y=draggable.getLocation().getY();
		drag.dragAndDropBy(draggable, x+45,y+65).perform();
		defaultwindow();
	}
	
	public void droppable()
	{
		dropButton.click();
		System.out.println("Droppable button is clicked");
	}
	
	
	

}
