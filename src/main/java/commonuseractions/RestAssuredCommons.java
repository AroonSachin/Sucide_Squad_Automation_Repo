package commonuseractions;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredCommons extends CommonActionMethods {

	public static void setBaseUrl(String url) {
		RestAssured.baseURI = url;
	}

	public static void put(String page, String body) throws Exception {
		Response res = RestAssured.given().header("Content-type", "application/json").and().body(body).when().put(page)
				.then().statusCode(200).extract().response();
		logMessage("Respose---" + res.asString());
		if (res.getStatusCode() == 200) {
			logMessage("Status Code 200");
		} else {
			logErrorMessage("Error Code- " + res.getStatusCode());
		}
	}

	public static void post(String page, String body) throws Exception {

		Response res = RestAssured.given().header("Content-type", "application/json").and().body(body).when().post(page)
				.then().statusCode(200).extract().response();
		logMessage("Respose---" + res.asString());
		if (res.getStatusCode() == 200) {
			logMessage("Status Code 200");
		} else {
			logErrorMessage("Error Code- " + res.getStatusCode());
		}

	}

}
