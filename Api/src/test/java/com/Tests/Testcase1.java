package com.Tests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.Utilities.Base;

import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class Testcase1 extends Base{

	
	@Test
	public void testForGET() {

		//baseURI("https://reqres.in/");
		queryParamter("page", "2");
	//	Response response = responseObject("GET", "api/users");
		baseURI("https://test.ouraipro.com/assessment/");
//		queryParamter("page", "2");
    	Response response = responseObject("GET", "v1/api/question-type");
		printResponseCode(response);
		printResponseBody(response);
		
	}
	
	@Test
	public void testForPOST() {
		RestAssured.baseURI="https://test.ouraipro.com";
	    RequestSpecification request = RestAssured.given();
    	request.header("Content-Type","application/json");
		baseURI("https://test.ouraipro.com/assessment");
		JSONObject json=new JSONObject();
		json.put("questionTypeName","viafasfasfafgnesh");
		json.put("responseType","qafafdaa");
		request.body(json.toJSONString());
		Response response = request.request(Method.POST,"/assessment/v1/api/question-type");
		printResponseCode(response);
		printResponseBody(response);
		}
	//@Test
//	public void testForGET2() {
//
//		baseURI("https://reqres.in/");
//		queryParamter("page", "2");
//		Response response = responseObject("GET", "api/users");
//		baseURI("https://test.ouraipro.com/assessment/");
//		queryParamter("page", "2");
//		Response response = responseObject("GET", "v1/api/question-type");
//		printResponseCode(response);
//		printResponseBody(response);
//		
//	}
	@Test
	public void testForPUT() {
		RestAssured.baseURI="https://test.ouraipro.com";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		JSONObject json=new JSONObject();
		json.put("id","b72e9238-ade1-46cb-a411-4cc7c32172c4");
		json.put("questionTypeName","Automation123");
		json.put("responseType","qa123");
		request.body(json.toJSONString());
		Response response = request.request(Method.PUT,"/assessment/v1/api/question-type");
		printResponseCode(response);
		printResponseBody(response);
	}
	
	@Test
	public void testForDELETE1() {
		RestAssured.baseURI="https://test.ouraipro.com";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		JSONObject json=new JSONObject();
		json.put("id","b72e9238-ade1-46cb-a411-4cc7c32172c4");
		request.body(json.toJSONString());
		Response response = request.request(Method.DELETE,"/assessment/v1/api/question-type");
		printResponseCode(response);
		printResponseBody(response);
		
	}

	
	@Test
	public void testForDELETE() {
		RestAssured.baseURI="https://test.ouraipro.com";
		RequestSpecification request = RestAssured.given();
			String id="{\r\n"
					+ "    \"id\": \"ca13b34e-0f0a-4131-a9b0-bfac6fd75916\"\r\n"
					+ "}";
		request.header("Content-Type","application/json");
		Response response = request.body(id).delete("/assessment/v1/api/question-type");
		printResponseCode(response);
		printResponseBody(response);
	}
	

//private void workingDelete() {
//RestAssured.baseURI="https://test.ouraipro.com";
//RequestSpecification request = RestAssured.given();
//	String id="{\r\n"
//			+ "    \"id\": \"a9307400-0d37-42de-ac34-9c53dcd1d6b4\"\r\n"
//			+ "}";
//	request.header("Content-Type","application/json");
//	Response response = request.body(id).delete("/assessment/v1/api/question-type");
//	System.out.println(response.getStatusCode());
//	printResponseCode(response);
//	printResponseBody(response);
//}
	
	private ByteArrayOutputStream request= new ByteArrayOutputStream();
	private ByteArrayOutputStream response= new ByteArrayOutputStream();
	private PrintStream requestVar=new PrintStream(request,true);
	private PrintStream responseVar=new PrintStream(response,true);

	RestAssured.filters(new ResponseLoggingFilter(LogDetail.BODY,responseVar));
	RestAssured.filters(new RequestLoggingFilter(LogDetail.ALL,requestVar));


	@Attachment(value="request")
	public byte[] logRequest(final ByteArrayOutputStream stream) {
		return attach(stream);
	}
	
	@Attachment(value="response")
	public byte[] logResponse(final ByteArrayOutputStream stream) {
		return attach(stream);
	}
	
	public byte[] attach(final ByteArrayOutputStream log) {
		final byte[] array =log.toByteArray();
		log.reset();
		return array;

}