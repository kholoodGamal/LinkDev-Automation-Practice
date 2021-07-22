package com.automationPractice.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.Base.TestBase;

public class Login extends TestBase{

	public Login() throws IOException 
	{
		PageFactory.initElements(driver, this);
	}

	
				//............ LogIn Elements ............ //
	
	 @FindBy (id="email")
	 WebElement userEmail;

	 @FindBy (id="passwd")
	 WebElement userPassword;
	 
	 @FindBy (id="SubmitLogin")
	 WebElement SigninButton;
	 
	 
				//............ LogIn Methods ............ //

	 
	 public void FillLogInCredentials(String Email, String Password)
	 {
		 userEmail.sendKeys(Email);
		 userPassword.sendKeys(Password);
	 }
	 
	 public void ClickSignIn()
	 {
		 SigninButton.click();
	 }
}
