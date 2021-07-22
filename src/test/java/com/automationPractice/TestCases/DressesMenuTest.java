package com.automationPractice.TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationPractice.Base.TestBase;
import com.automationPractice.pages.DressesMenu;
import com.automationPractice.pages.Login;
import com.automationPractice.pages.Registration;
import com.automationPractice.util.TestUtils;

public class DressesMenuTest extends TestBase{

	public DressesMenuTest() throws IOException {
		super();
	}

	DressesMenu dressesMenu;
	Registration registration;
	Login login;
	
	@Parameters({"browser"})
	@BeforeMethod(groups= {"E2E", "Regression", "Sanity"})
	public void PreReq(String browser) throws IOException 
	{
		initialization(browser);
		dressesMenu = new DressesMenu(); 
		registration = new Registration();
		login = new Login();
	}
	
	@AfterMethod(groups= {"E2E", "Regression", "Sanity"})
	public void PostReq()
	{
       // driver.quit();
	}
	
	@Test(dataProvider = "testData", priority = 1, groups= {"Sanity", "E2E", "Regression"})
	//public void AddDresses(String Email, String Password) throws InterruptedException
	public void AddDresses(String Email, String firstName, String lastName, String Password,
			 String AddressFirstName, String AddressLastName, String AddressText,
			 String AddressCity, String AddressState, String AddressPostcode,
			 String AddressCountry, String AddressPhoneMobile, String AddressAlias) throws InterruptedException
	{
		Double ExpectedTotalPrice = 0.0;
		
	//Register User
		registration.OpenSignInPage();
	    registration.SubmitEmailAddress(Email);
		registration.FillPersonalInfo(firstName, lastName, Password);
		registration.FillAddressInfo(AddressFirstName, AddressLastName, AddressText, AddressCity, AddressState, AddressPostcode, AddressCountry, AddressPhoneMobile, AddressAlias);
		registration.SubmitRegistrationForm();
		registration.ClickSignoutButton(); //--> Registration LogIn directly (For test the login)
		
	//Login with registered user
		login.FillLogInCredentials(Email, Password);
		login.ClickSignIn();
		
	//Open Dresses Tab
		dressesMenu.OpenDressesSection();
		
	//Add first Element
		dressesMenu.addToCart(1);
		//Thread.sleep(3000);
		String DressPriceValue =  dressesMenu.GetDressPrice();	
		ExpectedTotalPrice = ExpectedTotalPrice + Double.parseDouble(DressPriceValue);
		//Thread.sleep(3000);
		String ItemsNumber1 = dressesMenu.GetItemsNo();
	 
	//Close First item pop up
		dressesMenu.ClickContinuo();
		
	//Add second element	
		dressesMenu.addToCart(2);
		//Thread.sleep(3000);
		DressPriceValue =  dressesMenu.GetDressPrice();
		ExpectedTotalPrice = ExpectedTotalPrice + Double.parseDouble(DressPriceValue);
		//Thread.sleep(3000);
		String ItemsNumber2 = dressesMenu.GetItemsNo();
	
	//Assertions    
	    assertEquals("There is 1 item in your cart.", ItemsNumber1, "Number of items in Cart is not correct");
	    assertEquals("There are 2 items in your cart.", ItemsNumber2, "Number of items in Cart is not correct");
	 
	    dressesMenu.ClickCheckOut();
	    String TotalPriceAfterCheckOut = dressesMenu.GetPriceAfterCheckOut();
	    ExpectedTotalPrice = ExpectedTotalPrice + Double.parseDouble(dressesMenu.GetShippingPrice()) + Double.parseDouble(dressesMenu.GetTaxPrice());
	    assertEquals(Double.parseDouble(TotalPriceAfterCheckOut), ExpectedTotalPrice, "Total price after checkout is not correct");
	}
	
	@DataProvider
	public Object[][] testData() throws Exception
	{
		//Object data[][] = TestUtils.getDataFromExcel("LogIn data");
		Object data[][] = TestUtils.getDataFromExcel("Registration data");
		return data;
	}
}
