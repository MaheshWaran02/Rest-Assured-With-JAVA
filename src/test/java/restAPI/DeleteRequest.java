package restAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {

	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:3000/employees";

		RequestSpecification request = RestAssured.given();

		Response response = request.delete("/7");
		
		System.out.println("Response Hader is " + response.getHeader("ETag"));

		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
}