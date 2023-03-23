package org.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {
	
	
	public WebDriver ndriver;
	public Logout(WebDriver sdriver) {
		ndriver =sdriver;
		PageFactory.initElements(sdriver, this);
	}
	@FindBy(xpath="//i[@class=\"fa fa-lock\"]")
	@CacheLookup
	WebElement signUp1;
		
	@FindBy(xpath="//h2[text()=\"Login to your account\"]")
	@CacheLookup
	WebElement login_msg;	

	@FindBy(xpath="(//input[@placeholder=\"Email Address\"])[1]")
	@CacheLookup
	WebElement email_id;

	@FindBy(xpath="//input[@name=\"password\"]")
	@CacheLookup
	WebElement password2;

	@FindBy(xpath="(//button[@class=\"btn btn-default\"])[1]")
	@CacheLookup
	WebElement login_btn;	



	@FindBy(xpath="//b[text()=\"shwetha\"]")
	@CacheLookup
	WebElement login_Uname;
	
	@FindBy(xpath="	//a[text()=\" Logout\"]")
	@CacheLookup
	WebElement logout_btn;
	
	
	@FindBy(xpath="//h2[text()=\"Login to your account\"]")
	@CacheLookup
	WebElement loginname;

	public void button_click() {
		signUp1.click();
	}
	public String loginIsDisplayed() {
		 return login_msg.getText();
		
	}
	public void emailId(String id,String pass) {
		email_id.sendKeys(id);
		password2.sendKeys(pass);
	}
	
	public void clickLogin() {
		login_btn.click();
	}
	
	public boolean loginUnnameDisplayed() {
		boolean lgname = login_Uname.isDisplayed();
		return lgname;
	}
	public void logoutClick() {
		logout_btn.click();
	}
	
	public boolean homepageVerify() {
		boolean Logname = loginname.isDisplayed();
		return Logname;
	}
	
	public void teardown() {
		ndriver.close();
	}
}
