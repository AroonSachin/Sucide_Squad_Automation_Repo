package restassuredrunner;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import commonuseractions.CommonActionMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Venkat extends CommonActionMethods {
	@BeforeSuite
    public static void setup() {
		PropertyConfigurator.configure(configFilename);
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    
    public void getRequest() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/users/4")
                .then()
                .extract().response();
       logMessage(response.getBody().asString());
		System.out.println(response.getStatusCode());
    }
    @Test
    public void deleteRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete("/users/4")
                .then()
                .extract().response();
        System.out.println(response.getStatusCode());
      

}}
