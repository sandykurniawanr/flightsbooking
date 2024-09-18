package com.goibibo.flightsbooking;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class GoibiboHomeFactory {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	ExtentTest test;

	@FindBy(xpath = "//span[@class='logSprite icClose']")
	WebElement popUpClose;
	
	@FindBy(xpath = "(//div[@class='sc-12foipm-2 eTBlJr fswFld '])[1]")
	WebElement flightOriginField;
	
	@FindBy(xpath = "(//div[@class='sc-12foipm-2 eTBlJr fswFld '])[2]")
	WebElement flightDestinationField;
	
	@FindBy(xpath = "//input[@type='text']")
	WebElement flightInputTextBox;
	
	@FindBy(xpath = "//ul[@id='autoSuggest-list']//li")
	List<WebElement> flightSuggestionList;
	
	@FindBy(xpath = "(//div[@class='sc-12foipm-2 eTBlJr fswFld '])[3]")
	WebElement flightDepartureField;
	
	@FindBy(xpath = "(//div[@class='sc-12foipm-2 eTBlJr fswFld '])[4]")
	WebElement flightReturnField;
	
	@FindBy(xpath = "//span[@aria-label='Next Month']")
	WebElement nextMonthBtn;
	
	@FindBy(xpath = "//span[@aria-label='Previous Month']")
	WebElement previousMonthBtn;
	
	@FindBy(xpath = "//div[@class='DayPicker-Month']")
	List<WebElement> flightDate;
	
	@FindBy(xpath = "(//div[@class='sc-12foipm-2 eTBlJr fswFld '])[5]")
	WebElement flightTravelerField;
	
	@FindBy(xpath = "(//span[@class='sc-12foipm-51 kZvHQU'])[1]")
	WebElement deductAdult;
	
	@FindBy(xpath = "(//span[@class='sc-12foipm-51 kZvHQU'])[2]")
	WebElement addAdult;
	
	@FindBy(xpath = "(//span[@class='sc-12foipm-51 kZvHQU'])[3]")
	WebElement deductChildren;
	
	@FindBy(xpath = "(//span[@class='sc-12foipm-51 kZvHQU'])[4]")
	WebElement addChildren;
	
	@FindBy(xpath = "(//span[@class='sc-12foipm-51 kZvHQU'])[5]")
	WebElement deductInfant;
	
	@FindBy(xpath = "(//span[@class='sc-12foipm-51 kZvHQU'])[6]")
	WebElement addInfant;
	
	@FindBy(xpath = "//ul[@class='sc-12foipm-45 caZeZT']//li")
	List<WebElement> travelClassList;
	
	@FindBy(xpath = "//a[@class='sc-12foipm-63 byVDBE']")
	WebElement cancelBtn;
	
	@FindBy(xpath = "//a[@class='sc-12foipm-64 jkgFUQ']")
	WebElement doneBtn;
	
	@FindBy(xpath = "//span[contains(text(),'SEARCH FLIGHTS')]")
	WebElement searchFlightBtn;
	
	public GoibiboHomeFactory(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	public void clickPopUpClose() {
		popUpClose.click();
		test.info("Clicked on closing pop up");
	}
	
	public void clickFlightOriginField() {
		flightOriginField.click();
		test.info("Clicked on Flight Origin Field");
	}
	
	public void clickFlightDestinationField() {
		flightDestinationField.click();
		test.info("Clicked on Flight Destination Field");
	}
	
	public void sendFlightLocationKeys(String location) {
		flightInputTextBox.sendKeys(location);
		test.info("Inputting flight location");
	}
	
	public void clickAutoSuggestions(String airportCode) {
		for(WebElement code : flightSuggestionList) {
			if(code.getText().contains(airportCode)) {
				code.click();
				break;
			}
		}
		test.info("Clicked on auto suggestions list with aiport code: " + airportCode);
	}
	
	public void clickFlightDeparture() {
		flightDepartureField.click();
		test.info("Clicked on flight departure date field");
	}
	
	public void clickFlightReturn() {
		flightReturnField.click();
		test.info("Clicked on flight return date field");
	}
	
	public void clickNextMonthBtn() {
		nextMonthBtn.click();
		test.info("Clicked on next month button");
	}
	
	public void clickPreviousMonthBtn() {
		previousMonthBtn.click();
		test.info("Clicked on previous month button");
	}
	
	public void chooseFlightDates(String chosenMonth, String flightDates) {
		wait.until(ExpectedConditions.visibilityOfAllElements(flightDate));
		for(WebElement month : flightDate) {
			if(month.getText().contains(chosenMonth)) {
				List<WebElement> validFlightDays = month.findElements(By.xpath("//div[contains(text(),'"
						+ chosenMonth + "')]//parent::div//following-sibling::div//div[contains(@class,'DayPicker-Day') and contains(@aria-disabled,'false')]/p"));
				test.info("Selected Month: " + month.getText());
				for(WebElement days: validFlightDays) {
					if(days.getText().equalsIgnoreCase(flightDates)) {
						days.click();
						break;
					}
				}
			break;
			}
		}
		test.info("Clicked on " + chosenMonth + ", " + flightDates);
	}
	
	public void clickTravelerField() {
		flightTravelerField.click();
		test.info("Clicked on traveler field");
	}
	
	public void clickDeductAdult(int count) {
		for(int i = 0;i<count;i++) {
			deductAdult.click();
		}
		test.info("Clicked on deduct adult");
		
	}
	
	public void clickAddAdult(int count) {
		for(int i = 0;i<count;i++) {
			addAdult.click();
		}
		test.info("Clicked on add adult");
	}
	
	public void clickDeductChildren(int count) {
		for(int i = 0;i<count;i++) {
			deductChildren.click();
		}
		test.info("Clicked on deduct children");
	}
	
	public void clickAddChildren(int count) {
		for(int i = 0;i<count;i++) {
			addChildren.click();
		}
		test.info("Clicked on add children");
	}
	
	public void clickDeductInfant(int count) {
		for(int i = 0;i<count;i++) {
			deductInfant.click();
		}
		test.info("Clicked on deduct infant");
	}
	
	public void clickAddInfant(int count) {
		for(int i = 0;i<count;i++) {
			addInfant.click();
		}
		test.info("Clicked on deduct infant");
	}
	
	public void chooseTravelClass(String chosenClass) {
		for(WebElement travelClass : travelClassList) {
			if(travelClass.getText().contains(chosenClass)) {
				travelClass.click();
				break;
			}
		}
		test.info("Clicked on travel button: " + chosenClass);
	}
	
	public void clickCancelBtn() {
		cancelBtn.click();
		test.info("Clicked on cancel button");
	}
	
	public void clickDoneBtn() {
		doneBtn.click();
		test.info("Clicked on done button");
	}
	
	public void clickSearchFlightBtn() {
		searchFlightBtn.click();
		test.info("Clicked on search flight button");
	}
}
