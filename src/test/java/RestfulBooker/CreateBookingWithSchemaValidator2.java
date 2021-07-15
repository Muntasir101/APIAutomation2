// This is demo comment
package RestfulBooker;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateBookingWithSchemaValidator2 {

	public static void main(String[] args) {
		// Setup request
		RestAssured
			.given()
			.log()
			.all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.basePath("booking")
			.body("{\r\n" + 
				"    \"firstname\" : \"Muntasir\",\r\n" +
				"    \"lastname\" : \"Abdullah\",\r\n" +
				"    \"totalprice\" : 15,\r\n" + 
				"    \"depositpaid\" : false,\r\n" + 
				"    \"bookingdates\" : {\r\n" + 
				"        \"checkin\" : \"2021-01-01\",\r\n" + 
				"        \"checkout\" : \"2021-01-01\"\r\n" + 
				"    },\r\n" + 
				"    \"additionalneeds\" : \"Lunch\"\r\n" + 
				"}")
			.contentType(ContentType.JSON)
			// Hit the request and get the response
			.post()
			// Validate the response 
			.then()
			.log()
			.all()
			.statusCode(200)
			.body(JsonSchemaValidator
					.matchesJsonSchema
					(new File("C:\\APIBatchDec\\restassuredProjectMse\\src\\test\\java\\RestfulBooker\\CreateBookingResponseSchema1.json")));
		
		
		
		
	}
}
