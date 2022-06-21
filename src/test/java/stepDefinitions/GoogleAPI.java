package stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import googleAPIPojo.AddPlaceAPI;
import googleAPIPojo.DeletePlaceAPI;
import googleAPIPojo.Location;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.*;

public class GoogleAPI extends Utils {
	Response response;
	RequestSpecification reqspec1;
	//RequestSpecification reqspec2;
	ResponseSpecification resSpec;
	JsonPath js;
	TestDataBuild data = new TestDataBuild();
	static String placeid;
	

	@Given("Add Place Payload with {string}  {string} {string}")
	public void add_place_payload_with(String name, String address, String language) throws IOException {
		// resSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
		reqspec1 = given().spec(requestSpecification1()).queryParam("key", "qaclick123").body(data.testData1(name, address, language));
	}

	@When("user calls {string} with POST http request")
	public void user_calls_with_post_http_request(String resource) throws IOException {

		if (resource.contains("add")) {
			response = reqspec1.when().post(resource).then().extract().response();
		}
		else if (resource.contains("delete")) {
			response = reqspec1.when().post(resource).then().extract().response();
		}

	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(int statusCode) {
		assertEquals(response.getStatusCode(), statusCode);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
		String actualValue = getJsonPath(response, key);
		assertEquals(actualValue, value);

		

	}

	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedname, String resource) throws IOException {
		
		placeid = getJsonPath(response, "place_id");
		Response resp1 = given().spec(requestSpecification1()).queryParam("key", "qaclick123")
				.queryParam("place_id", placeid).when().get(resource).then().log().all().extract().response();

		String actualresult = getJsonPath(resp1, "name");
		assertEquals(actualresult, expectedname);

	}

	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {

		reqspec1 = given().log().all().spec(requestSpecification1()).queryParam("key", "qaclick123")
				.body(data.testData2(placeid));

	}

}
