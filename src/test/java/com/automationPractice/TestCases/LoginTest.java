package com.automationPractice.TestCases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationPractice.Base.TestBase;
import com.automationPractice.pages.Login;
import com.automationPractice.pages.Registration;
import com.automationPractice.util.TestUtils;

public class LoginTest extends TestBase{

	public LoginTest() throws IOException {
		super();
	}
	
	Registration registration;
	Login login;
	
	@Parameters({"browser"})
	@BeforeMethod(groups= {"E2E", "Regression", "Sanity"})
	public void PreReq(String browser) throws IOException 
	{
		initialization(browser);
		login = new Login(); 
		registration = new Registration(); 
	}
	
	@AfterMethod(groups= {"E2E", "Regression", "Sanity"})
	public void PostReq()
	{
       // driver.quit();
	}

	@Test(dataProvider = "testData", priority = 1, groups= {"Sanity", "E2E", "Regression"})
	public void LoginWithRegisteredUser(String Email, String Password)
	{
		registration.OpenSignInPage();
		login.FillLogInCredentials(Email, Password);
		login.ClickSignIn();
	}
	
	@DataProvider
	public Object[][] testData() throws Exception
	{
		Object data[][] = TestUtils.getDataFromExcel("LogIn data");
		return data;
	}
}
