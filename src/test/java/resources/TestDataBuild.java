package resources;

import java.util.ArrayList;
import java.util.List;

import googleAPIPojo.AddPlaceAPI;
import googleAPIPojo.DeletePlaceAPI;
import googleAPIPojo.Location;
import pojo.AuthRequest;

public class TestDataBuild {
	
	public AuthRequest testData(String clientId, String clientSecret)
	{
		AuthRequest aR = new AuthRequest();
		aR.setClientId(clientId);
		aR.setClientSecret(clientSecret);
		return aR;

	}
	
	public AddPlaceAPI testData1(String name, String address, String language)
	{
		AddPlaceAPI payload= new AddPlaceAPI();
		
		payload.setAccuracy(50);
		payload.setName(name);
		payload.setPhone_number("(+91) 983 893 3937");
		payload.setAddress(address);
		payload.setWebsite("https://rahulshettyacademy.com");
		payload.setLanguage(language);
		
		Location loc= new Location();
		loc.setLng(33.427362);
		loc.setLat(-38.383494);
		payload.setLocation(loc);
		
		List<String> list= new ArrayList<String>();
		list.add("shoe park");
		list.add("shop");
		payload.setTypes(list);
		
		return payload;

	}
	
	public String testData2(String place_id)
	{
		return "{\r\n    \"place_id\":\""+place_id+"\"\r\n}";
	}

}
