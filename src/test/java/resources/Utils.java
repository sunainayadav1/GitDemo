package resources;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static  RequestSpecification res;
	public static  RequestSpecification res1;
	
	public RequestSpecification requestSpecification() throws IOException {
		
		if (res==null)
		{
		PrintStream log= new PrintStream(new FileOutputStream("logging.txt"));
		
		 res = new RequestSpecBuilder().setContentType(ContentType.JSON)
				.setBaseUri(getGlobalProperties("baseUrl"))
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log)).
				build();
		
		return res;
		}
		else return res;
	}
	
public RequestSpecification requestSpecification1() throws IOException {
		
		if (res1==null)
		{
		PrintStream log= new PrintStream(new FileOutputStream("logging.txt"));
		
		 res1 = new RequestSpecBuilder().setContentType(ContentType.JSON)
				.setBaseUri(getGlobalProperties("baseUrl1"))
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log)).
				build();
		
		return res1;
		}
		else return res1;
	}
	
	
	public static String getGlobalProperties(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\P7109842\\eclipse-workspace_SeleniumClass\\APIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
		
	}
	
	public String getJsonPath(Response resp, String key)
	{
		
		
		String result = resp.asString();
		JsonPath js = new JsonPath(result);
		return js.get(key).toString();
	}
	
	

}
