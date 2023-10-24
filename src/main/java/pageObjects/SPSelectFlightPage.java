//This class contains webelements and methods for Select flight page
package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import utilities.SPUtilityPgm;

public class SPSelectFlightPage extends SPUtilityPgm {

	//Data members
	public WebDriver driver;
	public Select select;

	//Constructor
	public SPSelectFlightPage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		InilializeActions();
		initializeProp();
		//InilializeJavaScriptExecutor();
		InilializeWebDriverWait();
	}

	//Webelements

	@FindBys({
		@FindBy(xpath = "//div[@class='css-1dbjc4n r-1xdf14d']//div[@class='css-1dbjc4n']/descendant::div[@class='css-1dbjc4n r-13awgt0']")
	})
	List<WebElement> flightNumber;			

	@FindBys({
		@FindBy(xpath = "(//div[@class='css-1dbjc4n r-1xdf14d']/descendant::div[@data-testid='spicesaver-flight-select-radio-button-0']")
	})
	List<WebElement> spiceSaverButton;

	@FindBys({
		@FindBy(xpath = "(//div[@class='css-1dbjc4n r-1xdf14d']/descendant::div[@data-testid='spicesaver-flight-select-radio-button-1']")
	})
	List<WebElement> spiceFlexButton;

	@FindBys({
		@FindBy(xpath = "(//div[@class='css-1dbjc4n r-1xdf14d']/descendant::div[@data-testid='spicesaver-flight-select-radio-button-2']")
	})
	List<WebElement> spiceMaxButton;

	@FindBys({
		@FindBy(xpath = "//div[@class='css-1dbjc4n']/descendant::div[@class='css-1dbjc4n r-13awgt0']")
	})
	List<WebElement> flightNumberOneway;			

	@FindBys({
		@FindBy(xpath = "//div[@class='css-1dbjc4n']/descendant::div[@data-testid='spiceflex-flight-select-radio-button-1']")
	})
	List<WebElement> spiceFlexOneway;

	@FindBys({
		@FindBy(xpath = "//div[@class='css-76zvg2 r-1xedbs3 r-n6v787 r-16dba41 r-7o8qx1 r-156q2ks']")
	})
	List<WebElement> flightsInfo;

	@FindBy(xpath = "//div[@data-testid='continue-search-page-cta']/div[text()='Continue']")
	WebElement continueButton;

	@FindBy(xpath = "//div[contains(text(),'Flight Info')]")
	WebElement flightInfo;

	@FindBy(xpath = "//div[text()='Baggage']")
	WebElement checkIn;

	@FindBy(xpath = "//div[contains(text(),'Cancellation')]")
	WebElement manageBooking;

	@FindBy(xpath = "//div[.='Baggage Information']")
	WebElement baggageInfo;

	@FindBy(xpath = "//div[.='Cancellation Charges']")
	WebElement cancellationInfo;

	//Getters

	public WebElement getFlightInfo() {
		return flightInfo;
	}

	public WebElement getBaggageInfo() {
		return baggageInfo;
	}

	public WebElement getcancellationInfo() {
		return cancellationInfo;
	}

	public WebElement getManageBooking() {
		return manageBooking;
	}


	//Methods


	//Click on checkIn button
	public void CheckInClick() throws InterruptedException {
		Thread.sleep(2000);
		InilializeJavaScriptExecutor();		
		javascriptExecutor.executeScript("arguments[0].scrollIntoView();",checkIn);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(checkIn));
		action.moveToElement(checkIn).click().build().perform();
		//checkIn.click();

	}


	//Click on manageBooking button
	public void ManageBookingClick() throws InterruptedException {
		Thread.sleep(2000);
		InilializeJavaScriptExecutor();
		javascriptExecutor.executeScript("arguments[0].scrollIntoView();",manageBooking);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(manageBooking));
		action.moveToElement(manageBooking).click().build().perform();
	}


	//Select the flight 
	public void SelecDepFlight(String FlightNumber) throws InterruptedException {		
		InilializeJavaScriptExecutor();
		//Search the flight
		for(int i = 0 ; i<flightNumberOneway.size(); i++) {	
			javascriptExecutor.executeScript("arguments[0].scrollIntoView();",flightNumberOneway.get(i));
			wait.until(ExpectedConditions.visibilityOf(flightNumberOneway.get(i)));	
			Thread.sleep(2000);
			if (flightNumberOneway.get(i).getText().contains(FlightNumber)) {
				wait.until(ExpectedConditions.visibilityOf(flightNumberOneway.get(i)));
				//	action.moveToElement(flightsInfo.get(i)).click().build().perform();	
				Thread.sleep(2000);
				SelecFare(i);	
				break;
			}
		}

	}


	//Select fare
	public void SelecFare(int i) throws InterruptedException {	
		InilializeJavaScriptExecutor();		
		wait.until(ExpectedConditions.elementToBeClickable(spiceFlexOneway.get(i)));
		Thread.sleep(4000);
		action.moveToElement(spiceFlexOneway.get(i)).click().build().perform();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOf(flightsInfo.get(i)));
		action.moveToElement(flightsInfo.get(i)).click().build().perform();	
		Thread.sleep(2000);
	}

	//Click on continue button
	public void ContinueClick() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		action.moveToElement(continueButton).click().build().perform();
		Thread.sleep(2000);
	}
}
