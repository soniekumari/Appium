package org.testCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	public static ExtentReports extent;
	
	public static ExtentReports config() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//reports//index.html");
		reporter.config().setReportName("Automation Testing");
		reporter.config().setDocumentTitle("Extent Title by sonie maurya");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sonie maurya");
		return extent;
	}

}
