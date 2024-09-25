package com.goibibo.flightsbooking;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testbase.TestSuiteBase;
import utilities.ExcelUtility;

public class GoibiboPOMFramework extends TestSuiteBase{
	
	@DataProvider(name = "flightData")
	public Object[][] dataProvider(){
		Object[][] testData = ExcelUtility.getTestData("Flight_Tab");
		return testData;
	}
	
	@Test(dataProvider = "flightData")
	public void testGoibiboFlightTab(String fromKeyword, 
			String fromCode, 
			String toKeyword, 
			String toCode,
			String departureMonth, 
			String departureDate, 
			String returnMonth, 
			String returnDate, 
			String seat) throws InterruptedException {
		homePage.clickPopUpClose();
		homePage.clickFlightOriginField();
		homePage.sendFlightLocationKeys(fromKeyword);
		homePage.clickAutoSuggestions(fromCode);
		homePage.sendFlightLocationKeys(toKeyword);
		homePage.clickAutoSuggestions(toCode);
		homePage.clickFlightDeparture();
		homePage.clickNextMonthBtn();
		homePage.chooseFlightDates(departureMonth, departureDate);
		homePage.clickFlightReturn();
		homePage.clickFlightReturn();
		homePage.chooseFlightDates(returnMonth, returnDate);
		homePage.clickTravelerField();
		homePage.clickAddAdult(2);
		homePage.clickAddChildren(2);
		homePage.clickAddInfant(2);
		homePage.clickDeductAdult(1);
		homePage.clickDeductChildren(1);
		homePage.clickDeductInfant(1);
		homePage.chooseTravelClass(seat);
		homePage.clickDoneBtn();
		homePage.clickSearchFlightBtn();
	}
	
}
