package com.goibibo.flightsbooking;

import java.net.URL;
import java.time.Duration;

//import org.openqa.selenium.Platform;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import extentreports.ExtentReportFactory;

public class GoibiboPOM extends ExtentReportFactory{
	WebDriver driver;
	String baseURL;
	GoibiboHomeFactory homePage;
	URL gridURL;
	
	@BeforeClass
	public void setUp() throws Exception {
//		gridURL = new URI("http://192.168.1.3:4444").toURL();
//		DesiredCapabilities caps = new DesiredCapabilities();
//		caps.setBrowserName("chrome");
//		caps.setPlatform(Platform.fromString("Windows 10"));
//		driver = new RemoteWebDriver(gridURL, caps);
		baseURL = "https://www.goibibo.com/";
		driver = new ChromeDriver();
		ExtentReportFactory.driver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(baseURL);
	}
	
	@Test
	public void testGoibiboFlightTab() throws InterruptedException {
		test = extent.createTest("Goibibo Flight Tab Test");
		homePage = new GoibiboHomeFactory(driver, test);
		homePage.clickPopUpClose();
		homePage.clickFlightOriginField();
		homePage.sendFlightLocationKeys("jakarta");
		homePage.clickAutoSuggestions("CGK");
		homePage.sendFlightLocationKeys("denpasar");
		homePage.clickAutoSuggestions("DPS");
		homePage.clickFlightDeparture();
		homePage.clickNextMonthBtn();	
		homePage.clickPreviousMonthBtn();
		homePage.chooseFlightDates("September 2024", "25");
		homePage.clickFlightReturn(); 
		homePage.clickFlightReturn();
		homePage.chooseFlightDates("October 2024", "25");
		homePage.clickTravelerField();
		homePage.clickAddAdult(2);
		homePage.clickAddChildren(2);
		homePage.clickAddInfant(2);
		homePage.clickDeductAdult(1);
		homePage.clickDeductChildren(1);
		homePage.clickDeductInfant(1);
		homePage.chooseTravelClass("Economy");
		homePage.clickDoneBtn();
		homePage.clickSearchFlightBtn();
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
