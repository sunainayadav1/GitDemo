package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.builder.ResponseSpecBuilder;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import resources.TestDataBuild;
import resources.Utils;

public class GenerateTokenTest extends Utils {

	RequestSpecification res;
	ResponseSpecification resSpec;
	TestDataBuild data = new TestDataBuild();
	Response response;

	@Given("authorisation paylod with {string} {string}")
	public void authorisation_paylod_with(String clientId, String clientSecret) throws IOException {

		resSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
		res = given().spec(requestSpecification()).body(data.testData(clientId, clientSecret));

	}

	@When("user call {string} with POST http request")
	public void user_call_with_post_http_request(String endPoint) {

		response = res.when().post(endPoint).then().spec(resSpec).extract().response();
	}

	@Then("API call will get success with status code {int}")
	public void api_call_will_get_success_with_status_code(int statusCode) {
		assertEquals(response.getStatusCode(), statusCode);
	}

	@Then("{string} is  {string} generated in response body")
	public void is_generated_in_response_body(String key, String string2) {

		System.out.println(getJsonPath(response, "token"));

	}

}
