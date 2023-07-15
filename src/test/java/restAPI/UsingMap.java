package restAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UsingMap {
	

	@Test
	public void test1() {

		RestAssured.baseURI = "http://localhost:3000/employees";

		RequestSpecification request = RestAssured.given();

		Response response = request.get();

		String body = response.getBody().asString();

		System.out.println("Response Body is " + body);
		

		JsonPath json = response.jsonPath();
		List<String> names = json.get("name");
		
		for(String name:names) {
			
			System.out.println("The name is " + name);
		}

	}

}

