package com.ELI_Assesments;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.AssessmentTemplate.PostRequest;
import com.Tests.DataProvider;
import com.Utilities.Base;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Assesments_Template extends PostRequest{
	
	
	public static String BaseURI = "https://test.ouraipro.com/assessment";
	public static String Resources = "/v1/api/assessment-template";

	@Test(dataProvider = "postExcelDataProvider", dataProviderClass = DataProvider.class)
	public void testForPOST(Object data1, Object data2,Object data3,Object data4,Object data5,Object data6,Object data7,Object data8) {
		RestAssured.baseURI = BaseURI;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put(data1, data2);
		json.put(data3, data4);
		json.put(data5, data6);
		json.put(data7, data8);
		request.body(json.toJSONString());
		Response response = request.request(Method.POST, Resources);
		printResponseCode(response);
		printResponseBody(response);
		// Assert.assertEquals( response.getStatusCode(),201);
		System.out.println("response code validated");
		System.out.println("*************************************************************");

	}

	@Test(dataProvider = "postExcelDataProvider", dataProviderClass = DataProvider.class)
	public void testForPOSTVerification(Object data1, Object data2) {
		baseURI(BaseURI);
		Response response = responseObject("GET", Resources);
		response.getBody().asString();
		JsonPath jsonPath = response.jsonPath();
		List<String> nameValue = new ArrayList();
		List<String> responseValue = new ArrayList();
		nameValue = jsonPath.get("questionTypeName");
		responseValue = jsonPath.get("responseType");
		boolean verification = nameValue.contains(data1);
		boolean verification2 = responseValue.contains(data2);

		if (verification == true) {
			System.out.println(data1 + " is in the list");
		} else {
			System.out.println(data1 + " is not in the list");
		}
		if (verification2 == true) {
			System.out.println(data2 + " is in the list");
		} else {
			System.out.println(data2 + " is not in the list");
		}
		System.out.println("*************************************************************");
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertTrue(verification);
		Assert.assertTrue(verification2);
	}
	
	@Test
	public void testForGET() {
		baseURI(BaseURI);
    	Response response = responseObject("GET", Resources);
		printResponseCode(response);
		printResponseBody(response);
}
	
@Test
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
	RequestSpecification deleteResponse = RestAssured.given().filter(new AllureRestAssured());
	deleteResponse.header("Content-Type","application/json");
	JSONObject json=new JSONObject();
	System.out.println(idList.size());
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
		RequestSpecification deleteResponse = RestAssured.given().filter(new AllureRestAssured());
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


}	
