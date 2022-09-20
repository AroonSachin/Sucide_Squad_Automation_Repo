package jqueryrunner;

import org.testng.annotations.Test;

import commonuseractions.CommonActionMethods;
import jqueryautomation.JQuerySowmya;

public class JQueryTest extends CommonActionMethods {
	
	public void startBrowser() throws Exception
	{
		invokeBrowser("chrome", "Windows", "https://jqueryui.com/");
	}
	@Test
	public void test1()
	{
		new JQuerySowmya().draggable();
	}
	
	

}
