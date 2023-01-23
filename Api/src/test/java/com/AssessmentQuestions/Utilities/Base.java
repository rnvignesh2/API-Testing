package com.AssessmentQuestions.Utilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base extends DataProviderClass{
	
	public static String BaseURI = "https://test.ouraipro.com/assessment";
	public static String Resources = "/v1/api/assessment-question";

	public static RequestSpecification response;
	
	
	public static void baseURI(String URI) {

		RestAssured.baseURI = URI;
		response = RestAssured.given();
		response.header("Content-Type", "application/json");
	}

	public static void queryParamter(String paramterName, String parameterValue) {
		response.queryParam(paramterName, parameterValue);
	}

	public static void pathParameter(String paramterName, String parameterValue) {
		response.pathParam(paramterName, parameterValue);
	}

	public static Response responseObject(String requestType, String Resources) {
		if(requestType== "GET") {
			return response.request(Method.GET, Resources);
		} else if (requestType== "PUT") {
			return response.request(Method.PUT, Resources);
		}else if (requestType== "POST") {
			return response.request(Method.POST, Resources);
	    }else  {
		    return response.request(Method.DELETE, Resources);
		}
   }
	
	public static void printResponseCode(Response response) {
		System.out.println("The Response code is " + response.getStatusCode());
	}

	public static void printResponseBody(Response response) {

		System.out.println(response.getBody().asPrettyString());
	}
	

	
}
	