package github;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Deleterepoe {
	
	
	@Test
	public void test1() {
		RestAssured.baseURI = "https://api.github.com/repos/MaheshWaran02/PostmanDemo07";
		RequestSpecification reques = RestAssured.given();
		
		Response response = reques.auth().oauth2("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").delete();
		String body = response.getBody().asString();

		System.out.println("Response Body is " + body);

		System.out.println("Response Code is " + response.getStatusCode());
	}

}
