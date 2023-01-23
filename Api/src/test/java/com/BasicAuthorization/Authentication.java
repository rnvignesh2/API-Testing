package com.BasicAuthorization;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Config.QuestionType.Utilities.Base;
import com.Utilities.GetDataProviderClass;
import com.Utilities.ListenersClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(ListenersClass.class)
public class Authentication extends Base{
	@Description("Test for GET request")
	@Test
	public static void authentication(){
		String Resources1="/v1/api/assessment-user/verify/login";
		baseURI(BaseURI);
		response.body("{\r\n"
				+ "    \"email\": \"vignesh.n@pionglobal.com\"\r\n"
				+ "}");
    	Response response1 = responseObject("POST", Resources1);
		printResponseCode(response1);
		printResponseBody(response1);
	//	Assert.assertEquals(response1.getStatusCode(), 200);
		JsonPath jsonPath = response1.jsonPath();
		String token = jsonPath.getString("data.token");
		System.out.println(token);
		String cookie = response1.getDetailedCookies().toString();

	
		
		String Resources2="/v1/api/assessment-user/login";
		response.header("Authorization","Bearer "+ token).header("Content-Type","application/json").header("Cookie",cookie);
		JSONObject json1=new JSONObject();
		json1.put("password", "Pass@123");
		response.body(json1.toJSONString());	
    	Response response2 = responseObject("POST", Resources2);
		printResponseCode(response2);
		printResponseBody(response2);
		JsonPath jsonPath2 = response2.jsonPath();
		Object token2 = jsonPath2.get("data.token");
		Cookies cookie2 = response2.detailedCookies();
		System.out.println(cookie2.getValue("_la"));
		String cookie3 = cookie2.getValue("_la");
		
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://mail.ouraipro.com");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]")).click();
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='tab-pane ng-scope active']"));
		//driver.findElement(By.xpath("(//a[@data-toggle='tab'])[2]")).click();
		driver.switchTo().frame(frame);
     	String otp = driver.findElement(By.tagName("b")).getText();
		
		
		baseURI(BaseURI);
		String Resources3="/v1/api/assessment-user/verify/login-code";
		response.header("Authorization","Bearer "+ token2).header("Content-Type","application/json").header("Cookie","_la="+cookie3);
		JSONObject json=new JSONObject();
		json.put("token", otp);
		response.body(json.toJSONString());	
    	Response response3 = responseObject("POST", Resources3);
    	Cookies cookie4 = response3.getDetailedCookies();
		System.out.println(cookie4.getValue("_la"));
		String cookie5 = cookie4.getValue("_la");
    	response.header("Cookie","_la="+cookie5);
    	Response request = response.request(Method.GET,"/v1/api/question-type");
    	printResponseBody(request);
//		printResponseCode(response3);
//		printResponseBody(response3);
    	
    		
 
	}
	}

