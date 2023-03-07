package restassuredrunner;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import commonuseractions.CommonActionMethods;
import commonuseractions.RestAssuredCommons;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Aroon extends RestAssuredCommons {

	@BeforeSuite
	public static void setup() {
		PropertyConfigurator.configure(configFilename);
		setBaseUrl("https://fakerestapi.azurewebsites.net/api/v1");
	}
	
	@Test
	private void Requests() throws Exception {
		String postBody = "{\"id\":1,\"title\":\"string\",\"dueDate\":\"2023-03-07T03:16:51.390Z\",\"completed\":true}";
		post("/Activities", postBody);
		String putBody = "{\"title\":\"Arun\",\"dueDate\":\"2023-03-07T03:16:51.390Z\",\"completed\":true}";
		Response putRes = put("/Activities/1", putBody);
		if(JsonPath.from(putRes.asString()).get("title").toString().contains("Arun")) {
			logMessage("Put request successfully updated");
		}else {
			logErrorMessage("Update failed--"+putRes.asPrettyString());
		}
		get("/Activities");
		get("/Activities/1");
		Delete("/Activities/1");
	}
}
