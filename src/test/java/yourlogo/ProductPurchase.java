package yourlogo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import commonuseractions.CommonActionMethods;
public class ProductPurchase extends CommonActionMethods {	
	@BeforeMethod	
	  public void bro() {
		invokeBrowser("chrome", "normal", "https://www.javatpoint.com/log4j-properties");
	}

  @Test
 private void meth() {
	logMessage("hi");
	logMessage(getTitle());
	logMessage(getURL());
	
}
}
