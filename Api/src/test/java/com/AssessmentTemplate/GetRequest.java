package com.AssessmentTemplate;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Utilities.Base;
import com.Utilities.ExcelWriter;
import com.Utilities.ListenersClass;

import io.qameta.allure.Description;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

@Listeners(ListenersClass.class)
public class GetRequest extends Base{
	
	public static String Resources1 = "/v1/api/assessment-template";

	@Description("Test for GET request")
	@Test
	public void testForGET() throws Exception {
		baseURI(BaseURI);
    	Response response = responseObject("GET", Resources1);
		printResponseCode(response);
		printResponseBody(response);
//		System.out.println(response.getBody());
//		JsonPath jsonPath = response.jsonPath();
//		List<String> idList = new ArrayList();
//		idList = jsonPath.get("id");
//		for (int i = 0; i < idList.size(); i++) {
//		String id = idList.get(i);
//			writeExcel(id);
		}
	//	Assert.assertEquals(response.getStatusCode(), 201);
}
	

