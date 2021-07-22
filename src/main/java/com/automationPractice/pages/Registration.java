package com.automationPractice.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automationPractice.Base.TestBase;

public class Registration extends TestBase{

	public Registration() throws IOException 
	{
		PageFactory.initElements(driver, this);
	}

				//............ Registration Elements ............ //

  //............ Create an account  
	
	 //@FindBy (xpath="//a[contains(text(),'Sign in')]")
	@FindBy (className ="login")
	 WebElement SignInButton;
	 
	 @FindBy (id="email_create")
	 WebElement EmailCreate;
	 
	 @FindBy (id="SubmitCreate")
	 WebElement CreateAccountButton;
	
	
  //............ Personal Info
	
	 @FindBy (id="customer_firstname")
	 WebElement customer_firstname;
	 
	 @FindBy (id="customer_lastname")
	 WebElement customer_lastname;
	 
	 @FindBy (id="passwd")
	 WebElement customer_password;
	 
  //............ Address Info
	 
	 @FindBy (id="firstname")
	 WebElement Address_firstname;

	 @FindBy (id="lastname")
	 WebElement Address_lastname;
	 
	 @FindBy (id="address1")
	 WebElement Address_addressText;
	 
	 @FindBy (id="city")
	 WebElement Address_city;
	 
	 @FindBy (id="id_state")
	 WebElement Address_stateID;
	 	 
	 Select State;
	 
	 @FindBy (id="postcode")
	 WebElement Address_postcode;
	 
	 @FindBy (id="id_country")
	 WebElement Address_countryID;
	 
	 Select Country;
	 
	 @FindBy (id="phone_mobile")
	 WebElement Address_phone_mobile;
	 
	 @FindBy (id="alias")
	 WebElement Address_alias;
	 
	 @FindBy (id="submitAccount")
	 WebElement submitAccountButton;
	 
	 @FindBy (linkText = "Sign out")
	 WebElement SignoutButton;
	
	 
	 			//............ Registration Methods ............ //
	 
	 public void OpenSignInPage()
	 {
		 SignInButton.click();
	 }
	 
	 public void SubmitEmailAddress(String Email)
	 {
		 EmailCreate.sendKeys(Email);
		 CreateAccountButton.click();
	 }
	
	 public void FillPersonalInfo(String firstName, String lastName, String Password)
	 {
		 customer_firstname.sendKeys(firstName);
		 customer_lastname.sendKeys(lastName);
		 customer_password.sendKeys(Password);
	 }
	 
	 public void FillAddressInfo(String AddressFirstName, String AddressLastName, 
			 String AddressText, String AddressCity, String AddressState, String AddressPostcode,
			 String AddressCountry, String AddressPhoneMobile, String AddressAlias)
	 {
		 
		 //Address_firstname.sendKeys(AddressFirstName);
		 //Address_lastname.sendKeys(AddressLastName);
		 Address_addressText.sendKeys(AddressText);
		 Address_city.sendKeys(AddressCity);
		 State = new Select(Address_stateID);
		 State.selectByVisibleText(AddressState);
		 Address_postcode.sendKeys(AddressPostcode);
		 Country = new Select(Address_countryID);
		 Country.selectByVisibleText(AddressCountry); 
		 Address_phone_mobile.sendKeys(AddressPhoneMobile);
		 Address_alias.clear();
		 Address_alias.sendKeys(AddressAlias);
		 System.out.println(AddressPostcode);
		 
	 }
	 
	 public void SubmitRegistrationForm()
	 {
		 submitAccountButton.click();
	 }
	 
	 public void ClickSignoutButton()
	 {
		 SignoutButton.click();
	 }
	 
}
