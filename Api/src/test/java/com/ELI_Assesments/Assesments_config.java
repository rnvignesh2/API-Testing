package com.ELI_Assesments;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Utilities.Base;
import com.Utilities.ListenersClass;

import io.qameta.allure.Attachment;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(ListenersClass.class)
public class Assesments_config extends Base {

	public static String BaseURI = "https://test.ouraipro.com/assessment";
	public static String Resources = "/v1/api/question-type";

	@Test(dataProvider = "postDataSupplier", dataProviderClass = DataProvider.class)
	public void testForPOST(Object data1, Object data2) {
		RestAssured.baseURI = BaseURI;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("questionTypeName", data1);
		json.put("responseType", data2);
		request.body(json.toJSONString());
		Response response = request.request(Method.POST, Resources);
		printResponseCode(response);
		printResponseBody(response);
		Assert.assertEquals( response.getStatusCode(),201);
		System.out.println("response code validated");
		System.out.println("*************************************************************");

	}

	@Test(dataProvider = "postDataSupplier", dataProviderClass = DataProvider.class)
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
// ***************************************************************************************

	@Test(dataProvider = "putDataSupplier", dataProviderClass = DataProvider.class)
	public void testForGETandPUT(Object data1, Object data2) {

		baseURI(BaseURI);
		Response response = responseObject("GET", Resources);
		printResponseCode(response);
		// printResponseBody(response);
		// response.getBody().asString();

		RestAssured.baseURI = BaseURI;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JsonPath jsonPath = response.jsonPath();
		List<String> idValue = new ArrayList();
		idValue = jsonPath.get("id");
		// for (int i = idValue.size()-1;i>=idValue.size()-2 ; i--) {
		int size = idValue.size();
		System.out.println("PUT request ID " + idValue.get(idValue.size() - 1));
		JSONObject json = new JSONObject();
		json.put("id", idValue.get(idValue.size() - 1));
		json.put("questionTypeName", data1);
		json.put("responseType", data2);
		request.body(json.toJSONString());
		Response putResponse = request.request(Method.PUT, Resources);
		printResponseCode(putResponse);
		printResponseBody(putResponse);
		System.out.println("*************************************************************");
	}

	@Test(dataProvider = "putDataSupplier", dataProviderClass = DataProvider.class)
	public void verificationForGETandPUT(Object data1, Object data2) {
		baseURI(BaseURI);
		Response response = responseObject("GET", Resources);
		List<String> nameValue = new ArrayList();
		List<String> responseValue = new ArrayList();
		JsonPath jsonPath = response.jsonPath();
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
	}
	
}
	
//	@Attachment
//	public String logOutput(List<String> outputList) {
//    String output = ""; 
//	    for (String o : outputList) 
//	        output += o + "<br/>"; 
//	    return output;
//	}
//	
//	public void onTestFailures(ITestResult testResult) {
//	    // Reporter.getOutput(testResult)will give the output logged in testng reporter
//	    logOutput(Reporter.getOutput(testResult));
//	    super.onTestFailures(testResult);
//	}
//	
	
}
