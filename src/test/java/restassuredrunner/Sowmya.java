package restassuredrunner;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonuseractions.RestAssuredCommons;

public class Sowmya extends RestAssuredCommons {
	@BeforeClass
	public static void setup() {
		PropertyConfigurator.configure(configFilename);
		setBaseUrl("https://dummy.restapiexample.com/api/v1");

	}
	@Test
	public void apiRequest() throws Exception
	{
		String postBody = "{\"employee_name\":\"Tiger Nixon\",\"employee_salary\":320800,\"employee_age\":61,\"profile_image\":\"\"}";
		post("/create", postBody);
	}
	
	


}
