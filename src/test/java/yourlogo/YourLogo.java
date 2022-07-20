package yourlogo;

import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import commonuseractions.CommonActionMethods;
import pageobjects.yourlogo.LoginPage;
import pageobjects.yourlogo.Orderpage;
public class YourLogo extends CommonActionMethods {	
	@BeforeMethod	
	  public void bro() {
		invokeBrowser("chrome", "normal", "http://automationpractice.com/index.php");
	}
	
	
 @DataProvider(name="excel")
 private Iterator<Object[]> sheet() throws Exception {
	return getTestData("yolo");
	 
}

  @Test (dataProvider = "excel")
 private void login(Map<String, String> page) throws Exception {
	  inputdata.set(page);
    if (getdata("Number").equalsIgnoreCase("1")) {  
	new LoginPage().login(getdata("Email id"),getdata("Firstname"),getdata("Lastname"),getdata("Password"),getdata("Birthdate"),getdata("Birthmonth"),getdata("BirthYear"),getdata("CompanyName"),getdata("Address"),getdata("Cityname"),getdata("Statename"),getdata("Pincode"),getdata("PhoneNumber"));
	new Orderpage().order();
}
}
}