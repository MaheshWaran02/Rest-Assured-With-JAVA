package restAPI;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequeswithJsonObject {
	
	@Test
	public void test1() {
		
		
		JSONObject jsonobject =  new JSONObject();
		jsonobject.put("name", "Greg");
		jsonobject.put("salary", "3000");
	
	
		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();
		
		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(jsonobject.toString()).post("/create");
		String body = response.getBody().asString();

		System.out.println("Response Body is " + body);

		System.out.println("Response Code is " + response.getStatusCode());
		
		Assert.assertEquals(response.getStatusCode(), 201);

}
}


