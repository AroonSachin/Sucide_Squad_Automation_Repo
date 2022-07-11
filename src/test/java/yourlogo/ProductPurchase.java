package yourlogo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonuseractions.CommonActionMethods;

public class ProductPurchase extends CommonActionMethods {
	
	@BeforeMethod
	
	  public void bro() {
		invokeBrowser("chrome", "normal", "http://automationpractice.com/index.php");
	}

@Test
 private void meth() {
	logMessage("hi");
	logMessage(getTitle());
	logMessage(getURL());
	
}
}
