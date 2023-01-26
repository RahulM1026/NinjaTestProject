package com.ninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ninja.utils.ExtentReporter;
import com.ninja.utils.Utilities;

public class Listeners implements ITestListener {
	
	ExtentReports extent; 
	ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
		
		extent = ExtentReporter.GenerateExtentReport();
		
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		
		String TestName = result.getName();
		test = extent.createTest(TestName);
		test.log(Status.INFO,TestName+" Test Execution Started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String TestName = result.getName();
		test.log(Status.PASS,TestName+" Test Executed Successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String TestName = result.getName();
		WebDriver driver=null;
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			
			e.printStackTrace();
		}
		String DstPath = Utilities.CaptureScreenShot(driver, TestName);		
		
		test.addScreenCaptureFromPath(DstPath);
		test.log(Status.INFO, result.getThrowable());
		test.log(Status.FAIL,TestName+" Test Execution Failed");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
		File ExtentReport = new File(System.getProperty("user.dir")+"\\ExtentReports\\extent.html");
		
		try {
			Desktop.getDesktop().browse(ExtentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
