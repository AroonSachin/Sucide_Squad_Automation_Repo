package jqueryrunner;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonuseractions.CommonActionMethods;
import jqueryautomation.JQuerySowmya;

public class JQueryTest extends CommonActionMethods {
	@BeforeMethod
	public void startBrowser() throws Exception
	{
		invokeBrowser("chrome", "Windows", "https://jqueryui.com/");
	}
	@Test
	public void test1() throws Exception
	{
		new JQuerySowmya().draggable();
		new JQuerySowmya().dragAndDrop();
		new JQuerySowmya().droppable();
		new JQuerySowmya().resizable();
		new JQuerySowmya().selectable();
	}
	
//	public void test2() throws Exception
//	{
//		new JQuerySowmya().dragAndDrop();
//	}
	
	

}
