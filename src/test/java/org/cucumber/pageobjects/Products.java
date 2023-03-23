package org.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products {

	public WebDriver ndriver;
	public Products(WebDriver sdriver) {
  	ndriver =sdriver;
  	PageFactory.initElements(sdriver, this);
  	
 	}
	
	@FindBy(xpath="//a[@href=\"/product_details/3\"]")
	@CacheLookup
	WebElement viewCart;
	
	
	@FindBy(xpath="//a[contains(text(),\"Sleeveless Dress\")]")
	@CacheLookup
	WebElement viewCart_vf;
	
	
			
	@FindBy(id="quantity")
	@CacheLookup
	WebElement  qty;
	
	
	@FindBy(xpath="//button[@type=\"button\"]")
	@CacheLookup
	WebElement  addClick;
	
	@FindBy(xpath="//u[text()=\"View Cart\"]")
	@CacheLookup
	WebElement  click_link;
	
	
	@FindBy(xpath="//button[text()=\"4\"]")
	@CacheLookup
	WebElement  qty_Valu;
	
	
	public void cartClick() {
		viewCart.click();
	}
	public String infoisDisplayed() {
	 
	 return viewCart_vf.getText();
	}
	public void enterQuantity(String value) {
		qty.clear();
		qty.sendKeys(value);
		
	}
	public void addtoCartClick() {
		addClick.click();
		click_link.click();
		
	}
	public String qtyIsDisplayed() {
		return qty_Valu.getText();
		
		
	}
	public void tearDown() {
		ndriver.close();
	}
	
	
}
