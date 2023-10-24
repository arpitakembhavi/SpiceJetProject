package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.SPBaseclass;
import utilities.ExtentReport;

public class Listeners extends SPBaseclass implements ITestListener {

	// WebDriver driver;
	ExtentReports extentReport = ExtentReport.getExtentReport();
	public ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest=extentReport.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.log(Status.PASS, "TestPassed");
		String  testName=result.getName();

		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());

		} catch (IllegalAccessException|IllegalArgumentException|NoSuchFieldException|SecurityException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		try {
			String screenshotPath=takeScreenshot(testName,driver);
			extentTest.addScreenCaptureFromPath(screenshotPath,testName);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.fail(result.getThrowable());
		String  testName=result.getName();

		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());

		} catch (IllegalAccessException|IllegalArgumentException|NoSuchFieldException|SecurityException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		try {
			String screenshotPath=takeScreenshot(testName,driver);
			extentTest.addScreenCaptureFromPath(screenshotPath,testName);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}
}
;