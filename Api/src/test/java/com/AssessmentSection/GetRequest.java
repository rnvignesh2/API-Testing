package com.AssessmentSection;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Utilities.Base;
import com.Utilities.GetDataProviderClass;
import com.Utilities.ListenersClass;

import io.qameta.allure.Description;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

@Listeners(ListenersClass.class)
public class GetRequest extends Base{
	@Description("Test for GET request")
	@Test(dataProvider = "getExcelDataProvider", dataProviderClass = GetDataProviderClass.class)
	public void testForGET(String data2) throws Exception {
		String Resources1 = "/v1/api/assessment-section/get-by-template-id";
		baseURI(BaseURI);
		JSONObject json = new JSONObject();
		System.out.println("Assessment Template id is "+data2);
		json.put("assessmentTemplateId", data2);
		response.body(json.toJSONString());
    	Response response1 = responseObject("POST", Resources1);
    	JsonPath jsonPath = response1.jsonPath();
		List<String> idList = new ArrayList();
		idList = jsonPath.get("id");
		if(idList.size()==0) {
			System.out.println("no sectionid is present in this template id");
		}else {
		String id = idList.get(0);
		putTemplateIdExcel(data2);
		putWriteExcel(id);
		printResponseCode(response1);
		printResponseBody(response1);
		Assert.assertEquals(response1.getStatusCode(), 201);
}
	}
}
