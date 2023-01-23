package com.Config.QuestionType;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BasicAuthorization.Authentication;
import com.Config.QuestionType.Utilities.Base;
import com.Utilities.GetDataProviderClass;
import com.Utilities.ListenersClass;

import io.qameta.allure.Description;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

@Listeners(ListenersClass.class)
public class GetRequest extends Base{
	@Description("Test for GET request")
	@Test
	public void testForGET(){
		Authentication.authentication();
	//	baseURI(BaseURI);
	//	response.header("Authorization", "Bearer "+"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfY3NyZiI6ImU1ODE2NGQ3LTIzZmYtNGM1Yi1hZmJkLWQyYWE3YWJmMjhhYSIsImlhdCI6MTY3NDAyNjUwNSwiZXhwIjoxNjc0MTEyOTA1fQ.snhHAD3Tdwy0hkK_DLbjBfpkqCxRtyk0WABKziNy0m0");
    	Response response1 = responseObject("GET", Resources);
		printResponseCode(response1);
		printResponseBody(response1);
		Assert.assertEquals(response1.getStatusCode(), 200);		
		response1.then().body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\Singa\\Downloads\\Eclipse\\workspace\\Api\\src\\test\\java\\com\\Config\\QuestionType\\Utilities\\Schema.json")));
}
	}

