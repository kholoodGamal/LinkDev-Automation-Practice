package com.automationPractice.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase() throws IOException
	{
		prop = new Properties();
	    FileInputStream FIS = new FileInputStream("C:\\Users\\Kholood\\eclipse-workspace\\automationPractice\\src\\main\\java\\com\\automationPractice\\config\\config.properties");
	    prop.load(FIS);
	}
	
	
	public void initialization(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "E:\\Programs\\SEL\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{		
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();		
		}
		
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
}
