package restAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {

	@Test
	public void test1() {

		RestAssured.baseURI = "http://localhost:3000/employees";

		RequestSpecification request = RestAssured.given();

		Response response = request.get();

		String body = response.getBody().asString();

		System.out.println("Response Body is " + body);

		System.out.println("Response Code is " + response.getStatusCode());

		System.out.println("Response Hader is " + response.getHeader("ETag"));

		Assert.assertEquals(response.getStatusCode(), 200);
		
	
	}
}
