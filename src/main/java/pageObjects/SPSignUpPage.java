//WebElements and Methods for the SpiceJet Signup WebPage
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

public class SPSignUpPage extends SPUtilityPgm{

	//Data members
	public WebDriver driver;
	public Select select;

	//Constructor
	public SPSignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		InilializeActions();
		InilializeWebDriverWait();
	}

	//WebElements
	@FindBy(xpath = "//a/div[contains(text(),'Signup')]")
	WebElement signupLink;

	@FindBy(xpath = "(//select[contains(@class,'form-control form-select')])[1]")
	WebElement signupTitle;

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='last_name']")
	WebElement lastName;

	@FindBy(xpath = "(//select[contains(@class,'form-control form-select')])[2]")
	WebElement country;

	@FindBy(xpath = "//input[@id='dobDate']")
	WebElement dobDate;

	@FindBy(xpath = "//div[@data-provide='datepicker']/a")
	WebElement calender;

	@FindBy(xpath = "//select[@class='react-datepicker__year-select']")
	WebElement year;

	@FindBy(xpath = "//select[@class='react-datepicker__month-select']")
	WebElement month;

	@FindBys({	
		@FindBy(xpath = "//div[@class='react-datepicker__month']/div[@class='react-datepicker__week']/div")
	})
	List<WebElement> day;

	@FindBy(xpath = "//input[@type='tel']")
	WebElement telephoneNumber;

	@FindBy(xpath = "//input[@id='email_id']")
	WebElement emailId;

	@FindBy(xpath = "//input[@id='new-password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='c-password']")
	WebElement confirmPassword;

	@FindBy(xpath = "//input[@id='defaultCheck1']")
	WebElement termsConditionsCheckbox;

	@FindBy(xpath = "//button[.='Submit']")
	WebElement submitBtn;

	@FindBy(xpath = "//input[@id='defaultCheck1']")
	WebElement termsCheckbox;

	//Methods

	//Click on Signup Link
	public void SignupClick() {
		wait.until(ExpectedConditions.elementToBeClickable(signupLink));
		signupLink.click();
		SwitchWindow();
		wait.until(ExpectedConditions.visibilityOf(signupTitle));
	}

	//Click on submit Link
	public void SubmitClick() {
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		submitBtn.click();
	}

	//Click on SlelctTermsConditions Link
	public void SelectTermsConditions() {
		wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox));
		termsCheckbox.click();
	}

	//Enter the Title
	public void EnterTitle(String Title) {
		wait.until(ExpectedConditions.elementToBeClickable(signupTitle));
		signupTitle.click();
		select=new Select(signupTitle);
		select.selectByVisibleText(Title);
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

	//Enter the Country
	public void EnterCountry(String Country) {
		wait.until(ExpectedConditions.elementToBeClickable(country));
		country.click();
		select=new Select(country);
		select.selectByVisibleText(Country);
	}

	//Enter the DOB
	public void EnterDOB(String MonthValue,String yearvalue,String dayvalue) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(dobDate));
		InilializeJavaScriptExecutor();
		dobDate.click();
		//calender.click();
		wait.until(ExpectedConditions.visibilityOf(month));
		select=new Select(month);
		month.click();
		Thread.sleep(1500);
		select.selectByVisibleText(MonthValue);
		year.click();
		Thread.sleep(1500);
		select=new Select(year);
		select.selectByValue(yearvalue);
		
	//	action.moveToElement(day.get(dayvalue)).click().build().perform();
		
		day.get(Integer.valueOf(dayvalue)-1).click();
		Thread.sleep(1500);
	}

	//Enter the MobilePoneNumber
	public void EnterTelephoneNumber(String TelephoneNumber) {
		wait.until(ExpectedConditions.elementToBeClickable(telephoneNumber));
		telephoneNumber.sendKeys(TelephoneNumber);
		wait.until(ExpectedConditions.elementToBeClickable(telephoneNumber));
	}

	//Enter the Email
	public void EnterEmail(String Email) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(emailId));
		emailId.click();
		Thread.sleep(1500);
		emailId.sendKeys(Email);
	}

	//Enter the Password
	public void EnterPassword(String Password) throws InterruptedException {
		password.click();
		Thread.sleep(2000);
		password.sendKeys(Password);
	}

	//Enter the ConfirmPassword
	public void EnterConfirmPassword(String ConfirmPassword) throws InterruptedException {
		confirmPassword.click();
		Thread.sleep(1500);
		confirmPassword.sendKeys(ConfirmPassword);
	}
}
