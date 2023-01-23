package com.Utilities;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class ListenersClass implements ITestListener {

	
	private ByteArrayOutputStream request= new ByteArrayOutputStream();
	private ByteArrayOutputStream response= new ByteArrayOutputStream();
	private PrintStream requestVar=new PrintStream(request,true);
	private PrintStream responseVar=new PrintStream(response,true);
	
	@Override
	public void onTestStart(ITestResult result) {
		RestAssured.filters(new ResponseLoggingFilter(LogDetail.BODY,responseVar));
		RestAssured.filters(new RequestLoggingFilter(LogDetail.ALL,requestVar));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logResponse(response);	
		logRequest(request);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
logResponse(response);	
logRequest(request);
	}
	
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

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}


}
