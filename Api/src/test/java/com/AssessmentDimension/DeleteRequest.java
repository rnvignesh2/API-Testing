package com.AssessmentDimension;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Utilities.Base;
import com.Utilities.GetDataProviderClass;
import com.Utilities.ListenersClass;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(ListenersClass.class)
public class DeleteRequest extends Base{

	
	@Test(dataProvider = "getExcelDataProvider", dataProviderClass = GetDataProviderClass.class)
	public void testForDELETEAll(String data2) {
		String Resources1 = "/v1/api/assessment-dimension/get-by-template-id";
		baseURI(BaseURI);
		JSONObject json = new JSONObject();
		System.out.println("Assessment Template id is "+data2);
		json.put("assessmentTemplateId", data2);
		response.body(json.toJSONString());
    	Response response = responseObject("POST", Resources1);
//		printResponseCode(response);
//		printResponseBody(response);
		RestAssured.baseURI=BaseURI;
		RequestSpecification deleteResponse = RestAssured.given();
		deleteResponse.header("Content-Type","application/json");
		JSONObject json1=new JSONObject();
		JsonPath jsonPath = response.jsonPath();
		List idList=new ArrayList();
		idList = jsonPath.get("id");
		System.out.println("Assessment dimension id count inside the TemplateId is  "+idList.size());
		for (int i = 0; i<idList.size(); i++) {
		Object id = idList.get(i);
		System.out.println("Deleting Assesment dimension id "+id);
		json1.put("id",id);
		deleteResponse.body(json1.toJSONString());
		Response delete = deleteResponse.request(Method.DELETE,Resources);
		printResponseCode(delete);
		printResponseBody(delete);
	Assert.assertTrue(true);		
		System.out.println("*************************************************************");
	}
}
	
	
	// @Test(dataProvider = "getExcelDataProvider", dataProviderClass = GetDataProviderClass.class)
	public void testForDELETE(String data2) {
		String Resources1 = "/v1/api/assessment-section/get-by-template-id";
		baseURI(BaseURI);
		JSONObject json = new JSONObject();
		System.out.println("Assessment Template id is "+data2);
		json.put("assessmentTemplateId", data2);
		response.body(json.toJSONString());
    	Response response = responseObject("POST", Resources1);
		JsonPath jsonPath = response.jsonPath();
		List idList=new ArrayList();
		idList = jsonPath.get("id");
		RestAssured.baseURI=BaseURI;
		RequestSpecification deleteResponse = RestAssured.given();
		deleteResponse.header("Content-Type","application/json");
		JSONObject json1=new JSONObject();
		System.out.println("Total ids present " + idList.size());
		for (int i = idList.size(); i >= idList.size()-1; i--) {
		Object id = idList.get(i);
		json.put("id",id);
		deleteResponse.body(json1.toJSONString());
		Response delete = deleteResponse.request(Method.DELETE,Resources);
		printResponseCode(delete);
		printResponseBody(delete);
		Assert.assertEquals(delete.getStatusCode(),200);		
		System.out.println("*************************************************************");
	}}
}
