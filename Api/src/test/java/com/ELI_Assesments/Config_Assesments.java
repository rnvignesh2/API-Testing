package com.ELI_Assesments;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.asynchttpclient.util.Assertions;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Tests.DataProvider;
import com.Utilities.Base;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Config_Assesments extends Base{

	
	@Test
	public void testForGET() throws Exception {
	baseURI("https://test.ouraipro.com/assessment/");
	Response response = responseObject("GET", "v1/api/question-type");
	printResponseCode(response);
	printResponseBody(response);
	response.getBody().asString();
	JsonPath jsonPath = response.jsonPath();
	List<String> idValue = new ArrayList();
			idValue=jsonPath.get("id");
			System.out.println(idValue.size());
			// adding the id value to excel
			String firstId = idValue.get(0);
			writeExcel(firstId);
			// -----------------------------------
	for (int i = 0; i < idValue.size(); i++) {
		System.out.println(idValue.get(i));
	}
	Assert.assertEquals(response.getStatusCode(),200);
	System.out.println("*************************************************************");
}
	
	
	@Test(dataProvider="excelReader", dataProviderClass = DataProvider.class)
	public void testForPOST(String questionTypeNAme,String resonseType,String extra) {
		RestAssured.baseURI="https://test.ouraipro.com";
	    RequestSpecification request = RestAssured.given();
    	request.header("Content-Type","application/json");
		JSONObject json=new JSONObject();
		json.put("questionTypeName",questionTypeNAme);
		json.put("responseType",resonseType);
		json.put("extra", extra);
		request.body(json.toJSONString());
		Response response = request.request(Method.POST,"/assessment/v1/api/question-type");
		printResponseCode(response);
		printResponseBody(response);
		Assert.assertEquals( response.getStatusCode(),201);
		System.out.println("*************************************************************");
	}
	
	
	
	@Test(dataProvider="putDataSupplier", dataProviderClass = DataProvider.class)
	public void testForPUT(String id,String questionTypeNAme,String resonseType) {
		RestAssured.baseURI="https://test.ouraipro.com";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		JSONObject json=new JSONObject();
		json.put("id",id);
		json.put("questionTypeName",questionTypeNAme);
		json.put("responseType",resonseType);
		request.body(json.toJSONString());
		Response response = request.request(Method.PUT,"/assessment/v1/api/question-type");
		printResponseCode(response);
		printResponseBody(response);
		Assert.assertEquals( response.getStatusCode(),201);
		System.out.println("*************************************************************");
	}
	
	
	@Test(dataProvider="deleteDataSupplier", dataProviderClass = DataProvider.class)
	public void testForDELETE(String id) {
		RestAssured.baseURI="https://test.ouraipro.com";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		JSONObject json=new JSONObject();
		json.put("id",id);
		request.body(json.toJSONString());
		Response response = request.request(Method.DELETE,"/assessment/v1/api/question-type");
		printResponseCode(response);
		printResponseBody(response);
		Assert.assertEquals(response.getStatusCode(),201);
		System.out.println("*************************************************************");
	}
	
	@Test(dataProvider="putDataSupplier",dataProviderClass = DataProvider.class)
	public void testForGETandPUT(String questionTypeNAme,String resonseType) {
		
		baseURI("https://test.ouraipro.com/assessment/");
		Response response = responseObject("GET", "v1/api/question-type");
		printResponseCode(response);
		printResponseBody(response);
		response.getBody().asString();
		RestAssured.baseURI="https://test.ouraipro.com";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		JsonPath jsonPath = response.jsonPath();
		List<String> idValue = new ArrayList();
				idValue=jsonPath.get("id");
	for (int i = idValue.size()-1;i>=idValue.size()-2 ; i--) {
			int size = idValue.size();
			System.out.println("PUT request ID " + idValue.get(idValue.size()-1));
			JSONObject json=new JSONObject();
			json.put("id",idValue.get(i));
			json.put("questionTypeName",questionTypeNAme);
			json.put("responseType",resonseType);
			request.body(json.toJSONString());
			Response putResponse = request.request(Method.PUT,"/assessment/v1/api/question-type");		
			printResponseCode(putResponse);
			printResponseBody(putResponse);
			System.out.println("*************************************************************");

	}
	System.out.println("*************************************************************");

}
	
}