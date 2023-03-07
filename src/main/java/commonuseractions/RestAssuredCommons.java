package commonuseractions;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredCommons extends CommonActionMethods {

	public static void setBaseUrl(String url) {
		RestAssured.baseURI = url;
	}

	public Response put(String page, String body) throws Exception {
		Response res = RestAssured.given().header("Content-type", "application/json").and().body(body).when().put(page)
				.then().extract().response();
		if (String.valueOf(res.getStatusCode()).contains("20")) {
			logMessage("PUT request sucessfull");
			logMessage(res.asPrettyString());
		} else {
			logErrorMessage(res.asPrettyString());
		}
		return res;
	}

	public Response post(String page, String body) throws Exception {

		Response res = RestAssured.given().header("Content-type", "application/json").and().body(body).when().post(page)
				.then().statusCode(200).extract().response();
		if (String.valueOf(res.getStatusCode()).contains("20")) {
			logMessage("POST request sucessfull");
			logMessage(res.asPrettyString());
		} else {
			logErrorMessage(res.asPrettyString());
		}
		return res;

	}

	public Response get(String args) throws Exception {
		Response res = RestAssured.given().header("Content-type", "application/json").when().get(args).then()
				.extract().response();
		if (String.valueOf(res.getStatusCode()).contains("20")) {
			logMessage("GET request sucessfull");
			logMessage(res.asPrettyString());
		} else {
			logErrorMessage(res.asPrettyString());
		}
		return res;
	}

	public Response Delete(String args) throws Exception {
		Response res = RestAssured.given().header("Content-type", "application/json").when().delete(args).then()
				.extract().response();
		if (String.valueOf(res.getStatusCode()).contains("20")) {
			logMessage("DELETE request sucessfull");
		} else {
			logErrorMessage(res.asPrettyString());
		}
		return res;
	}

}
