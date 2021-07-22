package com.automationPractice.TestCases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationPractice.util.TestUtils;
import com.automationPractice.Base.TestBase;
import com.automationPractice.pages.Registration;

public class RegistrationTest extends TestBase {

	
	public RegistrationTest() throws IOException {
		super();
	}

	Registration registration;
	
	@Parameters({"browser"})
	@BeforeMethod(groups= {"E2E", "Regression", "Sanity"})
	//public void PreReq(String URL)
	public void PreReq(String browser) throws IOException 
	{
		initialization(browser);
		registration = new Registration(); 
	}
	
	@AfterMethod(groups= {"E2E", "Regression", "Sanity"})
	public void PostReq()
	{
       // driver.quit();
	}
	
	
	@Test(dataProvider = "testData", priority = 1, groups= {"Sanity", "E2E", "Regression"})
	public void RegisterUser(String Email, String firstName, String lastName, String Password,
			 String AddressFirstName, String AddressLastName, String AddressText,
			 String AddressCity, String AddressState, String AddressPostcode,
			 String AddressCountry, String AddressPhoneMobile, String AddressAlias)
	{
	   registration.OpenSignInPage();
       registration.SubmitEmailAddress(Email); 
       registration.FillPersonalInfo(firstName, lastName, Password);
       registration.FillAddressInfo(AddressFirstName, AddressLastName, AddressText,
    		   AddressCity, AddressState, AddressPostcode, AddressCountry,
    		   AddressPhoneMobile, AddressAlias);	
       registration.SubmitRegistrationForm();
	}
	
	@DataProvider
	public Object[][] testData() throws Exception
	{
		Object data[][] = TestUtils.getDataFromExcel("Registration data");
		return data;
	}
}
