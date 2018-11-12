package com.hellofresh.challenge;

import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestApiTest {

	// Get all countries and validate that US, DE and GB were returned in the response
	@Test
	public void Test_getAllCountries()
	{
		Response restResp = RestAssured.get("http://services.groupkt.com/country/get/all");
		JsonPath respBody = restResp.getBody().jsonPath();
		List<String> Countries = respBody.get("RestResponse.result.alpha2_code");
		Assert.assertTrue(Countries.contains("DE"));
		Assert.assertTrue(Countries.contains("GB"));
		Assert.assertTrue(Countries.contains("US"));
	}
	
	// Get each country (US) individually and validate the response
	@Test
    public void Test_US()
    {
		Response restResp = RestAssured.get("http://services.groupkt.com/country/get/iso2code/US");
		JsonPath respBody = restResp.getBody().jsonPath();
		Assert.assertEquals(restResp.getStatusCode(), 200);
		Assert.assertTrue(respBody.get("RestResponse.messages").toString().contains("Country found matching code"));
		Assert.assertTrue(respBody.get("RestResponse.result.alpha2_code").toString().equals("US"));
    }
	
	//Get each country (DE) individually and validate the response
	@Test
    public void Test_DE()
    {
		Response restResp = RestAssured.get("http://services.groupkt.com/country/get/iso2code/DE");
		JsonPath respBody = restResp.getBody().jsonPath();
		Assert.assertEquals(restResp.getStatusCode(), 200);
		Assert.assertTrue(respBody.get("RestResponse.messages").toString().contains("Country found matching code"));
		Assert.assertTrue(respBody.get("RestResponse.result.alpha2_code").toString().equals("DE"));
    }
	
	//Get each country (GB) individually and validate the response
	@Test
    public void Test_GB()
    {
		Response restResp = RestAssured.get("http://services.groupkt.com/country/get/iso2code/GB");
		JsonPath respBody = restResp.getBody().jsonPath();
		Assert.assertEquals(restResp.getStatusCode(), 200);
		Assert.assertTrue(respBody.get("RestResponse.messages").toString().contains("Country found matching code"));
		Assert.assertTrue(respBody.get("RestResponse.result.alpha2_code").toString().equals("GB"));
    }
	
	//Try to get information for inexistent countries and validate the response
	@Test
    public void Test_InexistentCountry()
    {
		Response restResp = RestAssured.get("http://services.groupkt.com/country/get/iso2code/usb");
		JsonPath respBody = restResp.getBody().jsonPath();
		Assert.assertEquals(restResp.getStatusCode(), 200);
		Assert.assertTrue(respBody.get("RestResponse.messages").toString().contains("No matching country found for requested code"));
    }
	
	// POST test layout but cannot exceute because not implemented, so it is commented
	
//	@SuppressWarnings("unchecked")
//	@Test
//	public void Test_PostCountry()
//	{		
//		RestAssured.baseURI ="http://services.groupkt.com/country";
//		RequestSpecification request = RestAssured.given();
//	 
//		JSONObject requestParams = new JSONObject();
//		requestParams.put("name", "Test Country"); 
//		requestParams.put("alpha2_code", "TC");
//		requestParams.put("alpha3_code", "TCY");
//
//		request.body(requestParams.toJSONString());
//		Response response = request.post("/register");
//		
//		Assert.assertEquals(response.getStatusCode(), "201");
//		Assert.assertEquals( "Correct Success code was returned", response.jsonPath().get("Message"), "Country Added");
//	}
}
