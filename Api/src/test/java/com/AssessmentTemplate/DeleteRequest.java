package com.AssessmentTemplate;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Utilities.Base;
import com.Utilities.ListenersClass;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(ListenersClass.class)
public class DeleteRequest extends Base{

	
	@Test
	public void testForDELETEAll() {
		baseURI(BaseURI);
		Response response = responseObject("GET", Resources);
		printResponseCode(response);
		// printResponseBody(response);
		// response.getBody().asString();
		
		JsonPath jsonPath = response.jsonPath();

		List idList=new ArrayList();
		idList = jsonPath.get("id");
		RestAssured.baseURI=BaseURI;
		RequestSpecification deleteResponse = RestAssured.given();
		deleteResponse.header("Content-Type","application/json");
		JSONObject json=new JSONObject();
		System.out.println(idList.size());
		for (int i = 0; i<idList.size(); i++) {
		Object id = idList.get(i);
		json.put("id",id);
		deleteResponse.body(json.toJSONString());
		Response delete = deleteResponse.request(Method.DELETE,Resources);
		printResponseCode(delete);
		printResponseBody(delete);
	//	Assert.assertEquals(delete.getStatusCode(),200);		
		System.out.println("*************************************************************");
	}
}
	
	
	public void testForDELETE() {
		baseURI(BaseURI);
		Response response = responseObject("GET", Resources);
		printResponseCode(response);
		// printResponseBody(response);
		// response.getBody().asString();
		JsonPath jsonPath = response.jsonPath();
		List idList=new ArrayList();
		idList = jsonPath.get("id");
		RestAssured.baseURI=BaseURI;
		RequestSpecification deleteResponse = RestAssured.given();
		deleteResponse.header("Content-Type","application/json");
		JSONObject json=new JSONObject();
		System.out.println("Total ids present " + idList.size());
		for (int i = idList.size(); i >= idList.size()-1; i--) {
		Object id = idList.get(i);
		json.put("id",id);
		deleteResponse.body(json.toJSONString());
		Response delete = deleteResponse.request(Method.DELETE,Resources);
		printResponseCode(delete);
		printResponseBody(delete);
		Assert.assertEquals(delete.getStatusCode(),200);		
		System.out.println("*************************************************************");
	}}
}
