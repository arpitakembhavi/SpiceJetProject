package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.SPBaseclass;
import pageObjects.SPPassengerDetailsPage;
import pageObjects.SPSearchFlightPage;
import pageObjects.SPSelectFlightPage;

public class SPSearchFlightTest extends SPBaseclass{

	//To search for flights by entering dummy origin and destination information for one way trip
	@Test(priority = 2)
	public void SearchFlightOnewWayTrip() throws InterruptedException, IOException {
		//Create an object
		SPSearchFlightPage onewaysearchflight=new SPSearchFlightPage(driver);

		//Select oneway trip
		onewaysearchflight.OneWayClick();

		//Fill the details
		onewaysearchflight.EnterOnboarding(prop.getProperty("From"));
		onewaysearchflight.EnterDestinationTo(prop.getProperty("To"));

		//Select the departure date
		onewaysearchflight.ClickDepartureDate();
		onewaysearchflight.selectmonth(prop.getProperty("day"),prop.getProperty("MonthValue"));

		//Select the number of Passengers 
		onewaysearchflight.SelectPassengers();
		onewaysearchflight.IncreaseAdult();
		onewaysearchflight.IncreaseChildren();
		onewaysearchflight.SelecCurrency(prop.getProperty("currency"));
		onewaysearchflight.FlightSearchClick();

		//Validation
		String actualValue = onewaysearchflight.getOnewayTripValidation().getText();
		Assert.assertTrue(actualValue.contains("One Way : Delhi to Bengaluru"));
		SelectFlight(driver);
	}


	//To search for flights by entering dummy origin and destination information for Round trip
	@Test(priority = 1)
	public void SearchFlightRoundTrip() throws InterruptedException, IOException {
		//Create an object
		SPSearchFlightPage roundTripsearchflight=new SPSearchFlightPage(driver);

		//Select roundTrip trip
		roundTripsearchflight.RoundTripClick();

		//Fill the details
		roundTripsearchflight.EnterOnboarding(prop.getProperty("From"));
		roundTripsearchflight.EnterDestinationTo(prop.getProperty("To"));

		//Select the departure date and return date
		roundTripsearchflight.ClickDepartureDate();
		roundTripsearchflight.selectmonth(prop.getProperty("day"),prop.getProperty("MonthValue"));

		roundTripsearchflight.ClickDepartureDate();
		roundTripsearchflight.selectmonth(prop.getProperty("day"),prop.getProperty("MonthValue"));

		roundTripsearchflight.SelectPassengers();
		roundTripsearchflight.IncreaseAdult();
		roundTripsearchflight.IncreaseChildren();
		roundTripsearchflight.SelecCurrency(prop.getProperty("currency"));
		roundTripsearchflight.FlightSearchClick();

		//Validation
		String actualValue = roundTripsearchflight.getOnewayTripValidation().getText();
		Assert.assertTrue(actualValue.contains("Round Trip : Delhi to Bengaluru"));


	}

	
	public void SelectFlight(WebDriver driver) throws InterruptedException, IOException {
		//Create an object
		SPSelectFlightPage selectflight=new SPSelectFlightPage(driver);

		selectflight.SelecDepFlight(prop.getProperty("FlightNumber"));

		//Validation
		Thread.sleep(2000);
		Assert.assertTrue(selectflight.getFlightInfo().getText().contains("Flight Info"));
		System.out.println("Flight Info");
		Thread.sleep(2000);
		selectflight.CheckInClick();
		Assert.assertTrue(selectflight.getBaggageInfo().getText().contains("Baggage Information")); 
		System.out.println("Baggage Info");
		Thread.sleep(2000);
		selectflight.ManageBookingClick();
		Assert.assertTrue(selectflight.getcancellationInfo().getText().contains("Cancellation Charges"));

		//Click Continue Button
		selectflight.ContinueClick();

		//Call Passenger Details method
		EnterPassengerDetails(driver);
	}


	public void EnterPassengerDetails(WebDriver driver) throws InterruptedException {
		//Create an object
		SPPassengerDetailsPage sppassengerDetails=new SPPassengerDetailsPage(driver);

		//Enter PassengerTitle
		sppassengerDetails.SelecPassengerTitle(prop.getProperty("Title"));
		//enter First Name
		sppassengerDetails.EnterFirstName(prop.getProperty("FirstName"));
		//Enter Last Name
		sppassengerDetails.EnterLastName(prop.getProperty("LastName"));
		//Enter Mobile number
		sppassengerDetails.EnterTelephoneNumber(prop.getProperty("MobileNumber"));
		//Enter Email
		sppassengerDetails.EnterEmail(prop.getProperty("EMail"));
		//Enter country
		sppassengerDetails.EnterCountry(prop.getProperty("Country"));
		//Enter City
		sppassengerDetails.EnterCity(prop.getProperty("City"));

		//Enter Primary Passenger details
		sppassengerDetails.EnterPassenger(prop.getProperty("Passenger1Title"), prop.getProperty("Passenger1FirstName"), prop.getProperty("Passenger1LastName"), prop.getProperty("Passenger1MobileNumber"));
		sppassengerDetails.ClickNext();

		//Enter second Passenger details
		sppassengerDetails.EnterPassenger(prop.getProperty("Passenger2Title"), prop.getProperty("Passenger2FirstName"), prop.getProperty("Passenger2LastName"), prop.getProperty("Passenger2MobileNumber"));
		sppassengerDetails.ClickNext();

		//Fill child passenger details
		sppassengerDetails.EnterChildPassenger(prop.getProperty("Passenger3Title"), prop.getProperty("Passenger3FirstName"), prop.getProperty("Passenger3LastName"));
		//Click on continue button
		sppassengerDetails.ClickContinue();
	}

}
