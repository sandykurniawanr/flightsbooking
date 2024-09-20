package com.goibibo.flightsbooking;

import org.testng.annotations.Test;

import testbase.TestSuiteBase;

public class GoibiboPOMFramework extends TestSuiteBase{
	
	@Test
	public void testGoibiboFlightTab() throws InterruptedException {
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
	
}
