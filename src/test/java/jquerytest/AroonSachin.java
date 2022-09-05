package jquerytest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonuseractions.CommonActionMethods;
import jqueryautomation.arunsachin.Interactions;

public class AroonSachin extends CommonActionMethods{
	
	@BeforeMethod
	public void invoke() throws Exception {
		invokeBrowser("chrome","normal","https://jqueryui.com/");
	}
	
	@Test
	public void interactionstest() throws Exception {
		new Interactions().draggeble();
	}

}
