package com.AssessmentTemplate;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Utilities.Base;
import com.Utilities.DataProviderClass;
import com.Utilities.ListenersClass;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(ListenersClass.class)
public class PostRequest extends Base{

	@Description("Test for post request using all the required field by interchanging the values")
	@Test(dataProvider = "postExcelDataProvider4", dataProviderClass = TemplateDataProviderClass.class)
	public void testForPOST4(Object data1, Object data2,Object data3,Object data4,Object data5,Object data6,Object data7,Object data8,Object expectedResponse) {
		RestAssured.baseURI = BaseURI;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		System.out.println(data1 + "" +data2+ "" +data3+ "" +data4+ "" +data5 + "" +data6 + "" +data7+ "" +data8);
		json.put(data1, data2);
		json.put(data3, data4);
		json.put(data5, data6);
		json.put(data7, data8);
		request.body(json.toJSONString());
		Response response = request.request(Method.POST, Resources);
		printResponseCode(response);
		printResponseBody(response);
		int expectedresponsecode=Integer.valueOf((String)expectedResponse);
	    Assert.assertEquals( response.getStatusCode(),expectedresponsecode);
		System.out.println("response code validated");
		System.out.println("*************************************************************");

	}
	
	@Description("Test for post request after removing comment field")
	@Test(dataProvider = "postExcelDataProvider3", dataProviderClass = TemplateDataProviderClass.class)
	public void testForPOST3(Object data1, Object data2,Object data3,Object data4,Object data5,Object data6,Object expectedResponse) {
		RestAssured.baseURI = BaseURI;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		System.out.println(data1 + "" +data2+ "" +data3+ "" +data4+ "" +data5 + "" +data6);

		json.put(data1, data2);
		json.put(data3, data4);
		json.put(data5, data6);
		request.body(json.toJSONString());
		Response response = request.request(Method.POST, Resources);
		printResponseCode(response);
		printResponseBody(response);
		int expectedresponsecode=Integer.valueOf((String)expectedResponse);
	    Assert.assertEquals( response.getStatusCode(),expectedresponsecode);
		System.out.println("response code validated");
		System.out.println("*************************************************************");

	}
	@Description("Test for post request after removing status field")
	@Test(dataProvider = "postExcelDataProvider2", dataProviderClass = TemplateDataProviderClass.class)
	public void testForPOST2(Object data1, Object data2,Object data3,Object data4,Object expectedResponse) {
		RestAssured.baseURI = BaseURI;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put(data1, data2);
		json.put(data3, data4);
		request.body(json.toJSONString());
		Response response = request.request(Method.POST, Resources);
		printResponseCode(response);
		printResponseBody(response);
		int expectedresponsecode=Integer.valueOf((String)expectedResponse);
	    Assert.assertEquals( response.getStatusCode(),expectedresponsecode);
		System.out.println("response code validated");
		System.out.println("*************************************************************");

	}
	@Description("Test for post request by passing only one required field")
	@Test(dataProvider = "postExcelDataProvider1", dataProviderClass = TemplateDataProviderClass.class)
	public void testForPOST1(Object data1, Object data2,Object expectedResponse) {
		RestAssured.baseURI = BaseURI;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put(data1, data2);
		request.body(json.toJSONString());
		Response response = request.request(Method.POST, Resources);
		printResponseCode(response);
		printResponseBody(response);
		int expectedresponsecode=Integer.valueOf((String)expectedResponse);
	    Assert.assertEquals( response.getStatusCode(),expectedresponsecode);
		System.out.println("response code validated");
		System.out.println("*************************************************************");

	}

//	@Test(dataProvider = "postExcelDataProvider1", dataProviderClass = DataProviderClass.class)
//	public void testForPOSTVerification(String BaseURI,String Resources,Object data1, Object data2) {
//		baseURI(BaseURI);
//		Response response = responseObject("GET", Resources);
//		response.getBody().asString();
//		JsonPath jsonPath = response.jsonPath();
//		List<String> nameValue = new ArrayList();
//		List<String> responseValue = new ArrayList();
//		nameValue = jsonPath.get("questionTypeName");
//		responseValue = jsonPath.get("responseType");
//		boolean verification = nameValue.contains(data1);
//		boolean verification2 = responseValue.contains(data2);
//
//		if (verification == true) {
//			System.out.println(data1 + " is in the list");
//		} else {
//			System.out.println(data1 + " is not in the list");
//		}
//		if (verification2 == true) {
//			System.out.println(data2 + " is in the list");
//		} else {
//			System.out.println(data2 + " is not in the list");
//		}
//		System.out.println("*************************************************************");
//		Assert.assertEquals(response.getStatusCode(), 200);
//		Assert.assertTrue(verification);
//		Assert.assertTrue(verification2);
//	}
	
	
}
