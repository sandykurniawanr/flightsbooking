package extentreports;


import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.CreateScreenshot;

public class ExtentReportFactory {
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	public static WebDriver driver;
	
	@BeforeSuite
	public void startReporter() {
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "\\logs\\Spark.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult testResult, Method method) throws IOException{
		if(testResult.getStatus() == ITestResult.FAILURE) {
			String ssdirectory = CreateScreenshot.takeScreenshot(driver);
			test.fail("Flight Tab doesnt work").addScreenCaptureFromPath(ssdirectory);
		} else if (testResult.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, method.getName() + " Success");
		} else {
			test.log(Status.SKIP, "Test Skipped");
		}
	}
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
//		driver.quit();
	}
	
}
