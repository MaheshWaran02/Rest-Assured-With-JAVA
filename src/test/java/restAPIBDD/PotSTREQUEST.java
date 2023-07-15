package restAPIBDD;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PotSTREQUEST {
	
	
 @Test
	public void test1() {
	 
	 JSONObject jsonobject =  new JSONObject();
		jsonobject.put("name", "Priya");
		jsonobject.put("salary", "6593");
		
		RestAssured.given().baseUri("http://localhost:3000/employees").contentType(ContentType.JSON).accept(ContentType.JSON).body(jsonobject.toString())
		           .when().post("/create")
		           .then().log().body().statusCode(201);
		
	}

}
