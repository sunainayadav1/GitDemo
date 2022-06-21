package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		GoogleAPI obj= new GoogleAPI();
		
		if(GoogleAPI.placeid==null)
		{
		obj.add_place_payload_with("Shetty", "Atlantis", "Spanish");
		obj.user_calls_with_post_http_request("/maps/api/place/add/json");
		obj.verify_place_id_created_maps_to_using("Shetty", "/maps/api/place/get/json");
		
		}
	}

}
