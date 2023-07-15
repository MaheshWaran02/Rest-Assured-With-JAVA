package restAPIBDD;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GETRequestBDD {
	
	
	@Test
	public void test1() {
		RestAssured.given().baseUri("http://localhost:3000/employees")
		            .when().get()
		            .then().log().body()
		            .statusCode(200).body("[3].name", Matchers.equalTo("John"));
		
		//.log mean it will give response of they body
		
	}
	
	@Test
	public void test2() {
		
		
			RestAssured.given().baseUri("http://localhost:3000/employees")
			            .when().get("/3")
			            .then().log().everything()
			            .statusCode(200).body("name",Matchers.equalTo("Vidhya"));
			
			//.log().body() it will print they body of my output .log().everything() it will give a out put in all they thing  including e.g. headers, cookies, body. Pretty-prints the body 
		
	}
	
	@Test
	public void test3() {
		
		Response response = RestAssured.given().baseUri("http://localhost:3000/employees")
	                                   .when().get();
		
		System.out.println("The body is " + response.getBody().asString());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		JsonPath json = response.jsonPath();
		List<String> names = json.get("name");
		List<Integer> ids = json.get("id");
		int empId=2;
		
		for(int i=0;i<ids.size();i++) {
			
			if(ids.get(i) == empId) {
				Assert.assertEquals(names.get(i), "Rob");

			}
			
		}
		
		
	}

}
