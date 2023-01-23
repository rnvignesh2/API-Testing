package com.AssessmentDimension;

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
	@Test(dataProvider = "putExcelDataProvider5", dataProviderClass = PutDataProviderClass.class)
	public void testForPUT5(Object data1, Object data2, Object data3, Object data4, Object data5, Object data6, Object data7, Object data8,Object data9, Object data10, Object expectedResponse) {

	baseURI(BaseURI);
		JSONObject json = new JSONObject();
		json.put(data1, data2);
		json.put(data3, data4);
		json.put(data5, data6);
		json.put(data7, data8);
		json.put(data9, data10);
		response.body(json.toJSONString());
		Response putResponse = response.request(Method.PUT, Resources);
		printResponseCode(putResponse);
		printResponseBody(putResponse);
		System.out.println(expectedResponse);
	//	int expectedresponsecode=Integer.valueOf((String)expectedResponse);
	    Assert.assertEquals( putResponse.getStatusCode(),expectedResponse);
		System.out.println("*************************************************************");
	}
	
	@Description("Test for PUT request by updating the values")
	@Test(dataProvider = "putExcelDataProvider4", dataProviderClass = PutDataProviderClass.class)
	public void testForPUT4(Object data1, Object data2, Object data3, Object data4, Object data5, Object data6, Object data7, Object data8, Object expectedResponse) {

	baseURI(BaseURI);
		JSONObject json = new JSONObject();
		json.put(data1, data2);
		json.put(data3, data4);
		json.put(data5, data6);
		json.put(data7, data8);
		response.body(json.toJSONString());
		Response putResponse = response.request(Method.PUT, Resources);
		printResponseCode(putResponse);
		printResponseBody(putResponse);
		System.out.println(expectedResponse);
		//int expectedresponsecode=Integer.valueOf((String)expectedResponse);
	    Assert.assertEquals( putResponse.getStatusCode(),expectedResponse);
		System.out.println("*************************************************************");
	}
	@Description("Test for PUT request by updating the values")
	@Test(dataProvider = "putExcelDataProvider3", dataProviderClass = PutDataProviderClass.class)
	public void testForPUT3(Object data1, Object data2, Object data3, Object data4, Object data5, Object data6, Object expectedResponse) {

	baseURI(BaseURI);
		JSONObject json = new JSONObject();
		json.put(data1, data2);
		json.put(data3, data4);
		json.put(data5, data6);
		response.body(json.toJSONString());
		Response putResponse = response.request(Method.PUT, Resources);
		printResponseCode(putResponse);
		printResponseBody(putResponse);
		System.out.println(expectedResponse);
//		int expectedresponsecode=Integer.valueOf((String)expectedResponse);
	    Assert.assertEquals( putResponse.getStatusCode(),expectedResponse);
		System.out.println("*************************************************************");
	}
	@Description("Test for PUT request by updating the values")
	@Test(dataProvider = "putExcelDataProvider2", dataProviderClass = PutDataProviderClass.class)
	public void testForPUT2(Object data1, Object data2, Object data3, Object data4, Object expectedResponse) {

	baseURI(BaseURI);
		JSONObject json = new JSONObject();
		json.put(data1, data2);
		json.put(data3, data4);
		response.body(json.toJSONString());
		Response putResponse = response.request(Method.PUT, Resources);
		printResponseCode(putResponse);
		printResponseBody(putResponse);
		System.out.println(expectedResponse);
	//	int expectedresponsecode=Integer.valueOf((String)expectedResponse);
	    Assert.assertEquals( putResponse.getStatusCode(),expectedResponse);
		System.out.println("*************************************************************");
	}
	

	
	@Description("Test for PUT request by updating the values")
	@Test(dataProvider = "putExcelDataProvider1", dataProviderClass = PutDataProviderClass.class)
	public void testForPUT1(Object data1, Object data2, Object expectedResponse) {

	baseURI(BaseURI);
		JSONObject json = new JSONObject();
		json.put(data1, data2);
		response.body(json.toJSONString());
		Response putResponse = response.request(Method.PUT, Resources);
		printResponseCode(putResponse);
		printResponseBody(putResponse);
		System.out.println(expectedResponse);
//		int expectedresponsecode=Integer.valueOf((String)expectedResponse);
	    Assert.assertEquals( putResponse.getStatusCode(),expectedResponse);
		System.out.println("*************************************************************");
	}
}
