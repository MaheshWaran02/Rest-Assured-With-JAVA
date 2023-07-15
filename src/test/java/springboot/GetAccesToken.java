package springboot;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAccesToken {
	

	public static void main(String[] args){
		
		Response response = RestAssured.given().baseUri("http://localhost:8088")
				                       .auth().basic("rest-assured", "password")
				                       .contentType("application/x-www-form-urlencoded")
				                       .formParam("username", "onlyfullstack")
				                       .formParam("password", "secret")
				                       .formParam("grant_type", "password")
				                       .when().post("/oauth/token");
		
		System.out.println("Respons is " + response.getBody().asString());
		
		JsonPath jpath = response.jsonPath();
		String token = jpath.get("access_token");
		System.out.println("Token is " + token);
		
		//Get Student
		
		response = RestAssured.given().baseUri("http://localhost:8088")
				               .auth().oauth2(token)
				               .when().get("/students");
		
		System.out.println("Get Student Respons is " + response.getBody().asString());
		
		Assert.assertEquals(response.getStatusCode(), 201);
		}
	}

