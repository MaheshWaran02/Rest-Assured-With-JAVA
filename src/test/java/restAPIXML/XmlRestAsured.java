package restAPIXML;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.response.Response;

public class XmlRestAsured {
	

@Test	
	public void test1() {
	
	RestAssured.given().baseUri("https://chercher.tech/sample/api/books.xml")
    .when().get()
    .then().log().body()
    .statusCode(200);
		
	}

@Test
public void test2() {
	Response response = RestAssured.given().baseUri("https://chercher.tech/sample/api/books.xml")
		                           .when().get();
	
	NodeChildrenImpl books = response.then().extract().path("bookstore.book.title");
	System.out.println("All they book is " + books.toString());
	System.out.println("They first book is " + books.get(0).toString());
	System.out.println("They second book is " + books.get(1).toString());
	
	
	NodeChildrenImpl booktags = response.then().extract().path("bookstore.book");
	for (int i=0;i<booktags.size();i++) {
		System.out.println(booktags.get(i).getAttribute("category"));
	}
	
}

}
