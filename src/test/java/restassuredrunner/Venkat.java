package restassuredrunner;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import commonuseractions.RestAssuredCommons;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Venkat extends RestAssuredCommons {

	@BeforeSuite
	public static void setup() {
		PropertyConfigurator.configure(configFilename);
		setBaseUrl("https://jsonplaceholder.typicode.com/");
	}
	@Test
	private void request() throws Exception {
		String postbody ="{\"userId\":1,\"title\":\"eum et est occaecati\",\"body\":\"aroon\"}";
        post("/posts", postbody);
        String putBody ="{\"title\":\"venkatesh\",\"body\":\"aroon\"}";
        Response putRes = put("/posts/1", putBody);
		if(JsonPath.from(putRes.asString()).get("title").toString().contains("venkatesh")) {
			logMessage("Put request successfully updated with response code "+putRes.getStatusCode());
		}else {
			logErrorAndMessage("Update failed--"+putRes.asPrettyString());
		}
        get("/posts");
        get("/posts/1");
        Delete("/posts/1");	

	}
	
	

}
