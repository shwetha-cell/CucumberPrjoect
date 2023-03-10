package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addreview {
		
	public WebDriver ndriver;
	public Addreview(WebDriver sdriver) {
  	ndriver =sdriver;
  	PageFactory.initElements(sdriver, this);
	}
	
	@FindBy(xpath="//a[@href=\"/products\"]")
	@CacheLookup
	WebElement cilck_Products;
	

	@FindBy(xpath="//h2[text()=\"All Products\"]")
	@CacheLookup
	WebElement vf_products;


	@FindBy(xpath="//a[@href=\"/product_details/1\"]")
	@CacheLookup
	WebElement click_ViewDetails;
	
	
	@FindBy(id="review")
	@CacheLookup
	WebElement review;
	
	@FindBy(id="name")
	@CacheLookup
	WebElement naMe;
	
	@FindBy(id="email")
	@CacheLookup
	WebElement eMail;
	
	@FindBy(xpath="//button[@class=\"btn btn-default pull-right\"]")
	@CacheLookup
	WebElement submitButton;
	
	
	@FindBy(xpath="//span[text()=\"Thank you for your review.\"]")
	@CacheLookup
	WebElement thank;
	
	public void cilckProducts() {
		cilck_Products.click();	
	}
	public String vfProducts() {
		return vf_products.getText();
		
	}
	public void viewCart() {
		click_ViewDetails.click();
	}
	public void writeReview() {
		review.sendKeys("Nice Product");
	}
	public void accountDetail() {
		naMe.sendKeys("shwetha");
		eMail.sendKeys("xyxs@shwe");
	}
	public void buttonClick() {
		submitButton.click();	
	}
	
	public String reviewVf() {
	return thank.getText();
	
	}
	
	
	public void tearDown() {
		ndriver.close();
	}
}
