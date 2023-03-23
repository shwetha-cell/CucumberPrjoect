package org.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Subscription
	{
	public WebDriver ndriver;
	public Subscription(WebDriver sdriver) {
  	ndriver =sdriver;
  	PageFactory.initElements(sdriver, this);
  	
	}
  	@FindBy(xpath="//h2[text()='Subscription']")
	@CacheLookup
	WebElement sub_vf;
	
  	@FindBy(id="susbscribe_email")
	@CacheLookup
	WebElement sub_email;
  	
 	@FindBy(id="subscribe")
	@CacheLookup
	WebElement sub_Click;
  	
 	@FindBy(xpath="//div[text()=\"You have been successfully subscribed!\"]")
	@CacheLookup
	WebElement msg_sucess;
 	
	
	public String subscriptionIsDisplayed() {
		return sub_vf.getText();
		
	}
	public void submail(String mail) throws InterruptedException {	
		sub_email.sendKeys(mail);		
	
	}
	
	public void subClick() {
		
		WebDriverWait wait = new WebDriverWait(ndriver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(sub_Click));
		wait.until(ExpectedConditions.elementToBeClickable(sub_Click));
		sub_Click.click();
	}
	
	public String sucessMsg() {
	 return msg_sucess.getText();
	
	}
	public void tearDown() {
		ndriver.close();
	}
}