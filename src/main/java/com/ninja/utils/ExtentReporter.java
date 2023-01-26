package com.ninja.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports GenerateExtentReport() {
		
		ExtentReports extentReport = new ExtentReports();
		File ExtentReportFile = new File(System.getProperty("user.dir")+"//ExtentReports//extent.html");
		ExtentSparkReporter sparkreport = new ExtentSparkReporter(ExtentReportFile);
		
		sparkreport.config().setTheme(Theme.DARK);
		sparkreport.config().setTimeStampFormat("dd/MM/yyyy hh:mm");
		sparkreport.config().setDocumentTitle("Ninja Automation");
		sparkreport.config().setReportName("Ninja Automation Report");

		extentReport.attachReporter(sparkreport);
		
		Properties configprop = new Properties();
		File Configpropfile = new File(System.getProperty("user.dir")+"//src//main//java//com//ninja//qa//config//config.properties");
		try {
			FileInputStream fisfile = new FileInputStream(Configpropfile);
			configprop.load(fisfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		extentReport.setSystemInfo("Application URL", configprop.getProperty("url"));
		extentReport.setSystemInfo("Browser", configprop.getProperty("browser"));
		extentReport.setSystemInfo("OS Used" , System.getProperty("os-name"));
		extentReport.setSystemInfo("JAVA Version", System.getenv("java.version"));
		
		return extentReport;
		
	}

	

}
