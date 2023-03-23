package org.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Register {

	public WebDriver ldriver;
	
	public Register(WebDriver rdriver){
		ldriver =rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//i[@class=\"fa fa-lock\"]")
	@CacheLookup
	WebElement signUp;

	@FindBy(xpath="//input[@name=\"name\"]")
	@CacheLookup
	WebElement nameText;

	@FindBy(xpath="(//input[@name=\"email\"])[2]")
	@CacheLookup
	WebElement passwordText;

	@FindBy(xpath="//button[text()=\"Signup\"]")
	@CacheLookup
	WebElement signup_Button;

	@FindBy(id="uniform-id_gender2")
	@CacheLookup
	WebElement   title;

	@FindBy(id ="password")
	@CacheLookup
	WebElement pswrd;

	@FindBy(id ="newsletter")
	@CacheLookup
	WebElement checkbox;

	@FindBy(id ="first_name")
	@CacheLookup
	WebElement firstName;

	@FindBy(id ="last_name")
	@CacheLookup
	WebElement lastName;

	@FindBy(id ="company")
	@CacheLookup
	WebElement company;

	@FindBy(id ="address1")
	@CacheLookup
	WebElement adress;

	@FindBy(id ="state")
	@CacheLookup
	WebElement state;

	@FindBy(id ="city")
	@CacheLookup
	WebElement city;

	@FindBy(id ="zipcode")
	@CacheLookup
	WebElement zipcode ;


	@FindBy(id ="mobile_number")
	@CacheLookup
	WebElement mobilenumber ;

	@FindBy(xpath="//button[text()=\"Create Account\"]")
	@CacheLookup
	WebElement createaccount ;

	@FindBy(xpath ="//a[text()=\"Continue\"]")
	@CacheLookup
	WebElement account ;

	@FindBy(xpath ="//i[@class=\"fa fa-trash-o\"]")
	@CacheLookup
	WebElement deleteAcco;


	@FindBy(xpath="//h2[text()=\"New User Signup!\"]")
	@CacheLookup
	WebElement signup_msg;
	
	
	
	@FindBy(xpath="//label[text()=\"Receive special offers from our partners!\"]")
	@CacheLookup
	WebElement checkbox_Vf;
	
	

	@FindBy(xpath="//p[contains(text(),\"Congratulations! Your new account \")]")
	@CacheLookup
	WebElement account_Created;
	

	@FindBy(xpath="//b[text()=\"shwetha\"]")
	@CacheLookup
	WebElement username_vf;
	

	
	@FindBy(xpath="//b[text()=\"Enter Account Information\"]")
	@CacheLookup
	WebElement 
	userName_verfiy;
	
	
	@FindBy(xpath="//p[contains(text(),\"Your account \")]")
	@CacheLookup
	WebElement delete_msg;
		
	
	public void signUpButton() {
		signUp.click();
	}	
	public void setName(String uname,String pswrd) {
		nameText.sendKeys(uname);
		passwordText.sendKeys(pswrd);

	}
	
	
public void clickSignup() {
		signup_Button.click();
	}
	public void titleClick() {
		title.click();
	}
	public void titlePassword() {
		pswrd.sendKeys("Password"); 
	}

	public void checkBoxClick() {
		checkbox.click();
	}
	public void PersonalDetails(String fName,String lName,String companye,String states,String zipCode,String adreSS,String ciTTy,String mobileNumber) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		company.sendKeys(companye);
		state.sendKeys(states);
		zipcode.sendKeys(zipCode);
		adress.sendKeys(adreSS);
		city.sendKeys(ciTTy);
		mobilenumber.sendKeys(mobileNumber);
		
	}
	


	

	public void createAccount() {
		createaccount.click();
	}

	public void continueAccount() {
		account.click();
		
	}
	public void deleteAccount() {
		deleteAcco.click();
	}

	public String signupButtonisPresent( ) {
		 
   return signup_msg.getText();
   
	}
	
	public String userNameisPresent() {
		return  userName_verfiy.getText();
			}
	
	public String chechboxTextisDisplayed() {
		 return checkbox_Vf.getText();
	
	}
	
	public String accountisDisplayed() {
		 return account_Created.getText();
		
	}
	
	public String usernameisDisplayed() {
		return username_vf.getText();
	
	}
	
	public String deleteMessage() {
		 return delete_msg.getText();
		
	}
	public void quitBrowser() {
		ldriver.quit();
	}
	

	
}




