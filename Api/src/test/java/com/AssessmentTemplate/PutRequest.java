package com.AssessmentTemplate;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Utilities.Base;
import com.Utilities.ListenersClass;
import com.Utilities.PutDataProviderClass;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(ListenersClass.class)
public class PutRequest extends Base{
	@Description("Test for PUT request by updating the values")
	@Test(dataProvider = "putExcelDataProvider4", dataProviderClass = PutDataProviderClass.class)
	public void testForPUT4(Object data1, Object data2, Object data3, Object data4, Object data5, Object data6, Object data7, Object data8,Object expectedResponse) {

		baseURI(BaseURI);
		Response response = responseObject("GET", Resources);
		printResponseCode(response);
		// printResponseBody(response);
		// response.getBody().asString();

		RestAssured.baseURI = BaseURI;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JsonPath jsonPath = response.jsonPath();
		List<String> idList = new ArrayList();
		idList = jsonPath.get("id");
		// for (int i = idValue.size()-1;i>=idValue.size()-2 ; i--) {
		int size = idList.size();
		System.out.println("PUT request ID " + idList.get(idList.size() - 1));
		JSONObject json = new JSONObject();
		json.put("id", idList.get(idList.size() - 1));
		json.put(data1, data2);
		json.put(data3, data4);
		json.put(data5, data6);
		json.put(data7, data8);
		request.body(json.toJSONString());
		Response putResponse = request.request(Method.PUT, Resources);
		printResponseCode(putResponse);
		printResponseBody(putResponse);
		int expectedresponsecode=Integer.valueOf((String)expectedResponse);
	    Assert.assertEquals( putResponse.getStatusCode(),expectedresponsecode);
		System.out.println("*************************************************************");
	}
	
	@Test(dataProvider = "putExcelDataProvider3", dataProviderClass = PutDataProviderClass.class)
	public void testForPUT3(Object data1, Object data2, Object data3, Object data4, Object data5, Object data6) {

		baseURI(BaseURI);
		Response response = responseObject("GET", Resources);
		printResponseCode(response);
		// printResponseBody(response);
		// response.getBody().asString();

		RestAssured.baseURI = BaseURI;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JsonPath jsonPath = response.jsonPath();
		List<String> idList = new ArrayList();
		idList = jsonPath.get("id");
		// for (int i = idValue.size()-1;i>=idValue.size()-2 ; i--) {
		int size = idList.size();
		System.out.println("PUT request ID " + idList.get(idList.size() - 1));
		JSONObject json = new JSONObject();
		json.put("id", idList.get(idList.size() - 1));
		json.put(data1, data2);
		json.put(data3, data4);
		json.put(data5, data6);
		request.body(json.toJSONString());
		Response putResponse = request.request(Method.PUT, Resources);
		printResponseCode(putResponse);
		printResponseBody(putResponse);
		System.out.println("*************************************************************");
	}
	
	@Test(dataProvider = "putExcelDataProvider2", dataProviderClass = PutDataProviderClass.class)
	public void testForPUT2(Object data1, Object data2, Object data3, Object data4, Object data5, Object data6, Object data7, Object data8) {

		baseURI(BaseURI);
		Response response = responseObject("GET", Resources);
		printResponseCode(response);
		// printResponseBody(response);
		// response.getBody().asString();

		RestAssured.baseURI = BaseURI;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JsonPath jsonPath = response.jsonPath();
		List<String> idList = new ArrayList();
		idList = jsonPath.get("id");
		// for (int i = idValue.size()-1;i>=idValue.size()-2 ; i--) {
		int size = idList.size();
		System.out.println("PUT request ID " + idList.get(idList.size() - 1));
		JSONObject json = new JSONObject();
		json.put("id", idList.get(idList.size() - 1));
		json.put(data1, data2);
		json.put(data3, data4);
		request.body(json.toJSONString());
		Response putResponse = request.request(Method.PUT, Resources);
		printResponseCode(putResponse);
		printResponseBody(putResponse);
		System.out.println("*************************************************************");
	}
	
	@Test(dataProvider = "putExcelDataProvider1", dataProviderClass = PutDataProviderClass.class)
	public void testForPUT1(Object data1, Object data2, Object data3, Object data4, Object data5, Object data6, Object data7, Object data8) {

		baseURI(BaseURI);
		Response response = responseObject("GET", Resources);
		printResponseCode(response);
		// printResponseBody(response);
		// response.getBody().asString();

		RestAssured.baseURI = BaseURI;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JsonPath jsonPath = response.jsonPath();
		List<String> idList = new ArrayList();
		idList = jsonPath.get("id");
		// for (int i = idValue.size()-1;i>=idValue.size()-2 ; i--) {
		int size = idList.size();
		System.out.println("PUT request ID " + idList.get(idList.size() - 1));
		JSONObject json = new JSONObject();
		json.put("id", idList.get(idList.size() - 1));
		json.put(data1, data2);
		request.body(json.toJSONString());
		Response putResponse = request.request(Method.PUT, Resources);
		printResponseCode(putResponse);
		printResponseBody(putResponse);
		System.out.println("*************************************************************");
	}
	
}
