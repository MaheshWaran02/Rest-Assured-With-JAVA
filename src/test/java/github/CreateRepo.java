package github;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateRepo {
	@Test
	public void test1() throws IOException {
		
		byte[] dataFile = Files.readAllBytes(Paths.get("repodata.json"));
		RestAssured.baseURI = "https://api.github.com/user/repos";
		RequestSpecification request = RestAssured.given();
		
		Response response = request.auth().oauth2("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").contentType(ContentType.JSON).accept(ContentType.JSON).body(dataFile).post();
		String body = response.getBody().asString();

		System.out.println("Response Body is " + body);

		System.out.println("Response Code is " + response.getStatusCode());
		
		Assert.assertEquals(response.getStatusCode(), 201);
		
	}

}
