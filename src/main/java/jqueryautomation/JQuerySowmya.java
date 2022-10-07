package jqueryautomation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

public class JQuerySowmya extends CommonActionMethods {
	Actions drag=new Actions(DriverFactory.getDriver());
	
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
	
	@FindBy(xpath = "//a[text()='Resizable']")
	public  WebElement resizeButton;
	
	@FindBy(xpath = "//div[@id='resizable']//div[3]")
	public  WebElement resizable;
	
	@FindBy(xpath = "//a[text() = 'Selectable']")
	public WebElement selectableButton;
	
	
	
	
	
	public void draggable() throws Exception
	{
		Thread.sleep(1000);
		clickMethod(dragButton, "drag");
		logMessage("Draggable button is clicked");
	}
	
	public void dragAndDrop() throws Exception {
		frameByIndex(0);
		webWait(draggable);
		
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
	
	public void resizable() throws Exception
	{
		clickMethod(resizeButton, "resizable");
		frameByIndex(0);	
		
		webWait(resizable);
		drag.clickAndHold(resizable).moveByOffset(100,60).release(resizable).perform();
		System.out.println("height&width:"+resizable.getSize());
		defaultwindow();
	}
	
	public void selectable()
	{
		selectableButton.click();
	}
	
	
	

}
