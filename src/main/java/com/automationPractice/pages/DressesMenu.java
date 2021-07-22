package com.automationPractice.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automationPractice.Base.TestBase;

public class DressesMenu extends TestBase{

	public DressesMenu() throws IOException {
		PageFactory.initElements(driver, this);
	}

	
				//............ Dresses Elements ............ //

	 @FindBy (xpath = "(//a[@class ='sf-with-ul'])[4]")
	 WebElement DressesButton;

	 @FindBy(xpath = "//div[@class ='product-image-container']")
	 List <WebElement> DressItem;
	 
	 @FindBy(xpath = "//div[@class ='right-block']")
	 List <WebElement> Blocks;
	 
	 @FindBy(xpath="//a[@title = 'Add to cart']")
	 List <WebElement> AddToCartButton;
	 
	 @FindBy(id = "search_query_top")
	 WebElement Search;
	 
	 @FindBy (id = "layer_cart_product_price")
	 WebElement DressPrice;
	 
	 
	@FindBy (xpath = "//*[contains(@class,'ajax_cart_product_txt')]")
	 List <WebElement> CartItemsNo;
	
	@FindBy (xpath = "//span[@class ='ajax_block_cart_total']")
	 WebElement TotalItemsPrice;

	 @FindBy (xpath = "//a[@title ='Proceed to checkout']")
	 WebElement ProceedButton;
	 
	 @FindBy (xpath = "//span[@title ='Continue shopping']")
	 WebElement ContinuoButton;
	 
	 @FindBy (xpath = "//span[@class ='cross']")
	 WebElement CloseButton;
	 
	 @FindBy (id = "total_price")
	 WebElement PriceAfterCheckOut;
	 
	 @FindBy (id = "total_shipping")
	 WebElement ShippingPrice;
	 
	 @FindBy (id = "total_tax")
	 WebElement Tax;
	 
     Actions action;
     
     DressesMenu dressesMenu;
     

     
	
        //............ Dresses Methods ............ //

	 public void ExplicitWait(WebElement element)
	 {
	     WebDriverWait wait = new WebDriverWait(driver,30);
	     wait.until(ExpectedConditions.visibilityOf(element));
	 }
     
     public void OpenDressesSection()
	 {
		 ExplicitWait(DressesButton);
		 DressesButton.click();
	 }
	 
	 public String GetDressPrice() throws InterruptedException
	 {
		 ExplicitWait(DressPrice);
		 String DressPriceValue = DressPrice.getText();
		 //Thread.sleep(3000);
		 String CorrectDressPriceValue = DressPriceValue.substring(1);
		 return CorrectDressPriceValue;
	 }
	 
	 public String GetPriceAfterCheckOut() throws InterruptedException
	 {
		 ExplicitWait(PriceAfterCheckOut);
		 String PriceAfterCheckOutValue = PriceAfterCheckOut.getText();
		 //Thread.sleep(3000);
		 PriceAfterCheckOutValue = PriceAfterCheckOutValue.substring(1);
		 return PriceAfterCheckOutValue;
	 }
	 
	 public String GetShippingPrice() throws InterruptedException
	 {
		 ExplicitWait(ShippingPrice);
		 String ShippingPriceValue = ShippingPrice.getText();
		 //Thread.sleep(3000);
		 ShippingPriceValue = ShippingPriceValue.substring(1);
		 return ShippingPriceValue;
	 }
	 
	 public String GetTaxPrice() throws InterruptedException
	 {
		 ExplicitWait(Tax);
		 String TaxValue = Tax.getText();
		 //Thread.sleep(3000);
		 TaxValue = TaxValue.substring(1);
		 return TaxValue;
	 }
	 
	 public String GetItemsNo()
	 {
		 String ItemText="";
		 for(int i = 0; i<CartItemsNo.size(); i++)
		 {
			 ItemText = CartItemsNo.get(i).getText();
			 if (ItemText.contains("in your cart"))
				{
				   return ItemText;
			    }	
		 }
		 
		 return ItemText;
	 }
	 
	 public String GetTotalPrice() throws InterruptedException
	 {
		 ExplicitWait(TotalItemsPrice);
         String TotalPrice = TotalItemsPrice.getText();
         //Thread.sleep(3000);
         TotalPrice= TotalPrice.substring(1);    //replace('$', ' ');
		 return TotalPrice;
	 }
 
     public void addToCart(Integer ElementIndex)
     {
    	 JavascriptExecutor je = ((JavascriptExecutor)driver);
         je.executeScript("arguments[0].scrollIntoView(true);", DressItem.get(ElementIndex));
         System.out.println("Hello"+Blocks.size());
         action = new Actions(driver);
         ExplicitWait(Blocks.get(ElementIndex));
         action.moveToElement(Blocks.get(ElementIndex)).click().build().perform();
         ExplicitWait(AddToCartButton.get(ElementIndex));
         AddToCartButton.get(ElementIndex).click();   
     }
     
	 public void ClickContinuo()
	 {
		 ContinuoButton.click();
	 }
	 
	 public void ClickCheckOut()
	 {
		 ProceedButton.click();
	 }
	 
	 public void Clickclose()
	 {
		 CloseButton.click();
	 }
     
}
