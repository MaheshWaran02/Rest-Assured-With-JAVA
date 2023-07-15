package springboot;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:8088/employees";
		RequestSpecification request = RestAssured.given();
		Response response = request.get(); 
		String body = response.getBody().asString();
		System.out.println("Response Body is " + body);
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
		
	}

}
