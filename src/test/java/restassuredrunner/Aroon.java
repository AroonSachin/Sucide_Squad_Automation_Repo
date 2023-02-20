package restassuredrunner;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import commonuseractions.CommonActionMethods;
import commonuseractions.RestAssuredCommons;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Aroon extends RestAssuredCommons {


	@BeforeSuite
	public static void setup() {
		PropertyConfigurator.configure(configFilename);
		setBaseUrl("https://reqres.in/api");

	}

	@Test
	public void Post() throws Exception {
		String requestBody = "{\r\n"
				+ "    \"email\":\"george.bluth@reqres.in\",\r\n"
				+ "    \"password\":\"aroon1015\"\r\n"
				+ "}";
		logMessage("Request_Body: \r\n"+requestBody);
		post("/register", requestBody);
	}
	
	@Test
	public void update() throws Exception {
		String requestBody = "{\r\n"
				+ "    \"last_name\":\"Euler\"\r\n"
				+  "}";
		put("/user/1", requestBody);
	}
	
	@Test
	public void testget() throws Exception {
		
		logMessage(get("/users/4"));
		Delete("/users/4");
		
	
	}

}
