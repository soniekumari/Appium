package org.testUtils;

import java.io.IOException;

import org.testCases.ExtentReport;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.utils.AppiumUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;

public class Listeners extends AppiumUtils implements ITestListener {

	AndroidDriver driver;
	ExtentTest test;
	ExtentReports extent = ExtentReport.config();

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "test pass");
	}

	public void onTestFailure(ITestResult result) {
//		test.log(Status.FAIL, "test fail");
		test.fail(result.getThrowable());

		try {
			driver = (AndroidDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());

 		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			test.addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName(), driver),
					result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "test skip");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		

	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
