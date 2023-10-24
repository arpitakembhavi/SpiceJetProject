//This class contains webelements and methods for Passenger Information page
package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.SPUtilityPgm;

public class SPPassengerDetailsPage extends SPUtilityPgm {

	//Data members
	public WebDriver driver;
	public Select select;

	//Constructor
	public SPPassengerDetailsPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
		InilializeActions();
		//InilializeJavaScriptExecutor();
		InilializeWebDriverWait();
	}

	//Web elements
	@FindBy(xpath = "//div[@data-testid='title-contact-detail-card']")
	WebElement title;	

	@FindBy(xpath = "//input[@data-testid='first-inputbox-contact-details']")
	WebElement firstName;	

	@FindBy(xpath = "//input[@data-testid='last-inputbox-contact-details']")
	WebElement lastName;

	@FindBy(xpath = "//input[@data-testid='contact-number-input-box']")
	WebElement contactNumber;

	@FindBy(xpath = "//input[@data-testid='emailAddress-inputbox-contact-details']")
	WebElement eMailAddress;

	@FindBy(xpath = "//input[@data-testid='city-inputbox-contact-details']")
	WebElement city;	

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-76uxam r-zso239 r-khh7iy r-1unwek3']/descendant::div[@class='css-76zvg2 css-bfa6kz r-homxoj r-poiln3 r-ubezar']")
	WebElement country;	

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-6ity3w']/descendant::input[contains(@data-testid,'sc-member-mobile-number-input-box')]")
	WebElement passengerContactNumber;	

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-6ity3w']/descendant::input[contains(@data-testid,'last-traveller-info-input-box')]")
	WebElement passengerLastName;	

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-6ity3w']/descendant::input[contains(@data-testid,'first-traveller-info-input-box')]")
	WebElement passengerFirstName;	

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-6ity3w']/descendant::div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-1ugchlj r-1777fci r-ymttw5 r-5njf8e r-1otgn73 r-19554kt r-184en5c']")
	WebElement travellerTitle;	

	@FindBys({
		@FindBy(xpath = "//div[@class='css-1dbjc4n r-6ity3w']/descendant::div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-rs99b7 r-g93hjn r-1g94qm0 r-yfq7p9 r-1w50u8q r-u8s1d r-19554kt r-8fdsdq']")
	})
	List<WebElement> PassengerTitleselection;

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-1uavh4e r-z2wwpe r-d9fdf6 r-9qu9m4']")
	WebElement passengers;	

	@FindBy(xpath = "//div[@class='css-76zvg2 r-jwli3a r-poiln3 r-ubezar r-1kfrs79']")
	WebElement nextBtn;	

	@FindBy(xpath = "//div[@data-testid='traveller-info-continue-cta']")
	WebElement continueBtn;	

	@FindBys({
		@FindBy(xpath = "//div[@class='css-1dbjc4n r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-11yh6sk r-1rnoaur r-1sncvnh']//div[contains(@class,'css-76zvg2 r-homxoj r-poiln3 r-ubezar')]")
	})
	List<WebElement> passengerTitle;	

	@FindBys({
		@FindBy(xpath = "//div[@class='css-1dbjc4n']/div/div[@class='css-76zvg2 r-qsz3a2 r-poiln3 r-n6v787 r-1e081e0 r-oyd9sg']")
	})
	List<WebElement> passengerCountry;

	//Methods

	//Click Passenger
	public void ClickPassenger() {
		wait.until(ExpectedConditions.elementToBeClickable(passengers));
		passengers.click();
	}


	//Enter Passenger details
	public void EnterPassenger(String Title,String FirstName,String LastName, String MobileNumber) {
		wait.until(ExpectedConditions.elementToBeClickable(travellerTitle));
		travellerTitle.click();
		for(int i = 0 ; i<PassengerTitleselection.size(); i++) {
			if (PassengerTitleselection.get(i).getText().contains(Title)) {
				System.out.println(PassengerTitleselection.get(i));
				wait.until(ExpectedConditions.elementToBeClickable(PassengerTitleselection.get(i)));
				action.moveToElement(PassengerTitleselection.get(i)).click().build().perform();
				break;
			}
		}
		passengerFirstName.sendKeys(FirstName);
		passengerLastName.sendKeys(LastName);
		passengerContactNumber.sendKeys(MobileNumber);
	}

	//Enter Child Passenger Details
	public void EnterChildPassenger(String Title,String FirstName,String LastName) {
		wait.until(ExpectedConditions.elementToBeClickable(travellerTitle));
		travellerTitle.click();
		for(int i = 0 ; i<PassengerTitleselection.size(); i++) {
			if (PassengerTitleselection.get(i).getText().contains(Title)) {
				System.out.println(PassengerTitleselection.get(i));
				wait.until(ExpectedConditions.elementToBeClickable(PassengerTitleselection.get(i)));
				action.moveToElement(PassengerTitleselection.get(i)).click().build().perform();
				break;
			}
		}
		passengerFirstName.sendKeys(FirstName);
		passengerLastName.sendKeys(LastName);
	}


	//Select PassengerTitle
	public void SelecPassengerTitle(String Title) {
		wait.until(ExpectedConditions.elementToBeClickable(title));
		title.click();
		for(int i = 0 ; i<passengerTitle.size(); i++) {
			if (passengerTitle.get(i).getText().contains("Mrs")) {
				System.out.println(passengerTitle.get(i));
				wait.until(ExpectedConditions.elementToBeClickable(passengerTitle.get(i)));
				action.moveToElement(passengerTitle.get(i)).click().build().perform();
				break;
			}
		}

	}


	//Enter the Firstname
	public void EnterFirstName(String FirstName) {
		wait.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.sendKeys(FirstName);
	}

	//Enter the LastName
	public void EnterLastName(String LastName) {
		wait.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.sendKeys(LastName);
	}

	//Enter the MobilePoneNumber
	public void EnterTelephoneNumber(String TelephoneNumber) {
		wait.until(ExpectedConditions.elementToBeClickable(contactNumber));
		contactNumber.sendKeys(TelephoneNumber);
		wait.until(ExpectedConditions.elementToBeClickable(contactNumber));
	}

	//Enter the Email
	public void EnterEmail(String Email) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(eMailAddress));
		eMailAddress.click();
		Thread.sleep(1500);
		eMailAddress.sendKeys(Email);
	}

	//Enter the Country
	public void EnterCountry(String Country) {

		wait.until(ExpectedConditions.elementToBeClickable(country));
		country.click();
		InilializeJavaScriptExecutor();
		System.out.println(passengerCountry.size());
		for(int i = 0 ; i<passengerCountry.size(); i++) {
			if (passengerCountry.get(i).getText().contains("Germany")) {
				javascriptExecutor.executeScript("arguments[0].scrollIntoView();",passengerCountry.get(i));
				wait.until(ExpectedConditions.visibilityOf(passengerCountry.get(i)));
				System.out.println(passengerCountry.get(i));

				wait.until(ExpectedConditions.elementToBeClickable(passengerCountry.get(i)));
				action.moveToElement(passengerCountry.get(i)).click().build().perform();
				break;
			}
		}
	}

	//Enter the City
	public void EnterCity(String City) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(city));
		city.click();
		Thread.sleep(1500);
		city.sendKeys(City);
	}

	//Click on continue button
	public void ClickContinue() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
		continueBtn.click();

	}	

	//Click on next button
	public void ClickNext() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
		nextBtn.click();

	}	
}

