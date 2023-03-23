package org.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Viewproducts {
	public WebDriver ndriver;
	public Viewproducts(WebDriver sdriver) {
		ndriver =sdriver;
		PageFactory.initElements(sdriver, this);
	}	
	@FindBy(xpath="//a[@href=\"/products\"]")
	@CacheLookup
	WebElement products;
	
	@FindBy(xpath="//h2[text()=\"Brands\"]")
	@CacheLookup
	WebElement brands;
	
	@FindBy(xpath="//a[@href=\"/brand_products/Madame\"]")
	@CacheLookup
	WebElement brand_name;
		
	@FindBy(xpath="//h2[@class=\"title text-center\"]")
	@CacheLookup
	WebElement verfiyName;
	
	@FindBy(xpath="//a[@href=\"/brand_products/Biba\"]")
	@CacheLookup
	WebElement brandNameLink;
	
	
	@FindBy(xpath="//h2[text()=\"Brand - Biba Products\"]")
	@CacheLookup
	WebElement brandName_verfiy;
	
	public void productsClick() {
		products.click();
		
	}
	public String brandsname() {
		return brands.getText();
		
	}
	
	public void someBrandname() {
		brand_name.click();
	}
	public String verfiybrandName() {
           return verfiyName.getText();
	
	}
	
	public void brandname_Link() {
		brandNameLink.click();
	}
	
	public String brandName_Verfiy() {
	return brandName_verfiy.getText();
	
	}
	public void tearDoen() {
		ndriver.close();
	}
	
}

