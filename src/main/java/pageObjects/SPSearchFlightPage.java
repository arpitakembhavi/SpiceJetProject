//This Class contains webelements and methods of flight search page
//=================================================================

package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import utilities.SPUtilityPgm;

public class SPSearchFlightPage extends SPUtilityPgm {

	//Data members
	public WebDriver driver;
	public Select select;


	//Constructors
	public SPSearchFlightPage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		InilializeActions();
		initializeProp();
		InilializeWebDriverWait();
	}

	//Webelements
	@FindBy(xpath = "(//div[.='one way'])[2]")
	WebElement oneWayButton;

	@FindBy(xpath = "//div[@data-testid='round-trip-radio-button']")
	WebElement roundTripButton;

	@FindBy(xpath = "(//input)[1]")
	WebElement boardingFrom;

	@FindBy(xpath = "(//input)[2]")
	WebElement boardingTo;

	@FindBy(xpath = "//div[.='Departure Date']")
	WebElement deptDate;

	@FindBy(xpath = "//div[.='Return Date']")
	WebElement returnDate;

	@FindBy(xpath = "//div[@data-testid='home-page-flight-cta']")
	WebElement searchFlight;

	@FindBys({
		@FindBy(xpath = "//div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']")
	})
	List<WebElement> monthYear;

	@FindBys({
		@FindBy(xpath = "//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']")
	})
	List<WebElement> month;

	@FindBy(xpath = "//div[.='Passengers']")
	WebElement passengers;

	@FindBy(xpath = "//div[@data-testid='Adult-testID-plus-one-cta']")
	WebElement adultPlus;

	@FindBy(xpath = "//div[@data-testid='Children-testID-plus-one-cta']")
	WebElement childrenPlus;

	@FindBy(xpath = "//div[.='Currency']")
	WebElement currency;

	@FindBy(xpath = "//div[@class='css-76zvg2 r-homxoj r-1hfyk0a']")
	WebElement onewayTripValidation;

	@FindBys({
		@FindBy(xpath = "//div[@class='css-76zvg2 r-homxoj r-ubezar']")
	})
	List<WebElement> currencyName;


	//Getters

	public WebElement getOnewayTripValidation() {
		return onewayTripValidation;
	}

	//Methods

	//Select date 
	public void selectmonth(String dayValue,String monthValue) throws InterruptedException {
		String date1="(//div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088'])[";
		String date2="]/div/div/div/div/child::div";

		InilializeJavaScriptExecutor();
	//	System.out.println(month.size());
		for(int i = 0 ; i<month.size(); i++) {
			Thread.sleep(1000);
		//	System.out.println(prop.getProperty("MonthValue"));
			if (month.get(i).getText().contains(monthValue)) {
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(month.get(i)));
				action.moveToElement(month.get(i)).click().build().perform();
				String date=date1+(i+1)+date2;
			//	System.out.println(date);
				List<WebElement> dateList = driver.findElements(By.xpath(date));
				for(int j = 0 ; j<dateList.size(); j++) {
					InilializeJavaScriptExecutor();
				//	System.out.println(dateList.get(j).getText());
				//	String dayValue=prop.getProperty("day");
					//System.out.println("day = "+ prop.getProperty("day"));
					if (dateList.get(j).getText().equalsIgnoreCase(dayValue)) {
						Thread.sleep(1000);
						wait.until(ExpectedConditions.elementToBeClickable(dateList.get(j)));
						action.moveToElement(dateList.get(j)).click().build().perform();
						break;
					}
				}
				break;
			}
		}
	}


	//Select currency
	public void SelecCurrency(String currencyValue) {
		currency.click();
		for(int i = 0 ; i<currencyName.size(); i++) {
			if (currencyName.get(i).getText().contains(currencyValue)) {
				action.moveToElement(currencyName.get(i)).click().build().perform();
				break;
			}
		}

	}

	//click on Passenger field
	public void SelectPassengers() {
		wait.until(ExpectedConditions.elementToBeClickable(passengers));
		passengers.click();
	}

	//Increase the adults
	public void IncreaseAdult() {
		wait.until(ExpectedConditions.elementToBeClickable(adultPlus));
		adultPlus.click();
	}

	//Increase the Child
	public void IncreaseChildren() {
		wait.until(ExpectedConditions.elementToBeClickable(childrenPlus));
		childrenPlus.click();
	}

	//Choose one way trip
	public void OneWayClick() {
		wait.until(ExpectedConditions.elementToBeClickable(oneWayButton));
		oneWayButton.click();
	}

	//Choose Round trip
	public void RoundTripClick() {
		wait.until(ExpectedConditions.elementToBeClickable(roundTripButton));
		roundTripButton.click();
	}

	//Select boarding place
	public void EnterOnboarding(String Boarding) {
		wait.until(ExpectedConditions.elementToBeClickable(boardingFrom));
		boardingFrom.click();
		boardingFrom.sendKeys(Boarding);
	}

	//Select destination place
	public void EnterDestinationTo(String Destination) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(boardingTo));
		Thread.sleep(1000);
		boardingTo.sendKeys(Destination);
		Thread.sleep(1000);
	}

	//Select departure date
	public void ClickDepartureDate() throws InterruptedException {
		//wait.until(ExpectedConditions.elementToBeClickable(deptDate));
		Thread.sleep(2000);
		//deptDate.click();
		action.clickAndHold(deptDate).build().perform();
	}

	//Select return date
	public void ClickReturnDate() throws InterruptedException {
		//wait.until(ExpectedConditions.elementToBeClickable(deptDate));
		Thread.sleep(2000);
		//deptDate.click();
		action.clickAndHold(returnDate).build().perform();
	}

	//Click on search button
	public void FlightSearchClick() {
		wait.until(ExpectedConditions.elementToBeClickable(searchFlight));
		searchFlight.click();
	}
}
