package jqueryrunner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonuseractions.CommonActionMethods;
import jqueryautomation.arunsachin.Interactions;
import utils.DriverFactory;

public class AroonSachin extends CommonActionMethods{
	
	@BeforeMethod
	public void invoke() throws Exception {
		invokeBrowser("chrome","normal","https://jqueryui.com/");
	}
	
	@Test
	public void interactionstest() throws Exception {
		new Interactions().dragAxis();
		new Interactions().dragAndDrop();
		new Interactions().resize();
		new Interactions().selectable();
		new Interactions().sort();
	}
	
	@Test
	public void widgets() throws Exception {
		new Interactions().accord();
		new Interactions().autoComplete();
		new Interactions().button();
		new Interactions().checkBox();
		new Interactions().controlGRP();
		new Interactions().datePicker();
		new Interactions().dialog();
		new Interactions().menu();
		new Interactions().progressBar();
		new Interactions().slide();
		new Interactions().spinner();
		new Interactions().tabs();
		new Interactions().toolTip();
	}
	
	@Test
	public void effect() throws Exception {
		new Interactions().addClass();
		new Interactions().colorAnim();
		new Interactions().easting();
		new Interactions().effect();
		new Interactions().removeClass();
		new Interactions().hide();
		new Interactions().show();
		new Interactions().switchClass();
		new Interactions().toggle();
		new Interactions().toggleClass();
	}
	
	@Test
	public void Utilities() throws Exception {
		new Interactions().position();
		new Interactions().widgetFactory();
	}
	
	@AfterMethod
	public void aftrMHD() {
		DriverFactory.closeDriver();
	}
	
}
