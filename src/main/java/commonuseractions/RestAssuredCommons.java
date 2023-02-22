package commonuseractions;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredCommons extends CommonActionMethods {

	public static void setBaseUrl(String url) {
		RestAssured.baseURI = url;
	}

	public void put(String page, String body) throws Exception {
		Response res = RestAssured.given().header("Content-type", "application/json").and().body(body).when().put(page)
				.then().statusCode(200).extract().response();
		logMessage("Respose---" + res.asString());
		if (String.valueOf(res.getStatusCode()).contains("20")) {
			logMessage("PUT command sucessfull");
		} else {
			logErrorMessage("Error Code- " + res.getStatusCode());
		}
	}

	public void post(String page, String body) throws Exception {

		Response res = RestAssured.given().header("Content-type", "application/json").and().body(body).when().post(page)
				.then().statusCode(200).extract().response();
		logMessage("Respose---" + res.asString());
		if (String.valueOf(res.getStatusCode()).contains("20")) {
			logMessage("PUT command sucessfull");
		} else {
			logErrorMessage("Error Code- " + res.getStatusCode());
		}

	}

	public String get(String args) throws Exception {
		Response res = RestAssured.given().header("Content-type", "application/json").when().get(args).then()
				.extract().response();
		if (String.valueOf(res.getStatusCode()).contains("20")) {
			logMessage("GET command sucessfull");
		} else {
			logErrorMessage("Error Code- " + res.getStatusCode());
		}
		return res.asString();
	}

	public void Delete(String args) throws Exception {
		Response res = RestAssured.given().header("Content-type", "application/json").when().delete(args).then()
				.extract().response();
		if (String.valueOf(res.getStatusCode()).contains("20")) {
			logMessage("DELETE command sucessfull");
		} else {
			logErrorMessage("Error Code- " + res.getStatusCode());
		}

	}

}
