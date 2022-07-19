package yourlogo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import commonuseractions.CommonActionMethods;
import pageobjects.yourlogo.LoginPage;
import pageobjects.yourlogo.Orderpage;
public class YourLogo extends CommonActionMethods {	
	@BeforeMethod	
	  public void bro() {
		invokeBrowser("chrome", "normal", "http://automationpractice.com/index.php");
	}

  @Test
 private void login() throws Exception {
	new LoginPage().login();
	new Orderpage().order();
}
}
