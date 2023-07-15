package springboot;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostNewEmployee {
	@Test
	public void test1() {
		HashMap<String,Object> requestbody = new HashMap<String,Object>();
		requestbody.put("firstName", "mahesh");
		requestbody.put("lastName", "waran");
		requestbody.put("salary", "2000000");
		requestbody.put("email", "sms@gmail.com");
	RestAssured.baseURI = "http://localhost:8088/employees";
	RequestSpecification request = RestAssured.given();
	
	Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(requestbody).post();
    String body = response.getBody().asString();
	System.out.println("Respons Body is " + body);
	System.out.println("Response code is " + response.getStatusCode());
}
}