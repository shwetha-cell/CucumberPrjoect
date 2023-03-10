package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Invoice {


	public WebDriver ndriver;
	public Invoice(WebDriver sdriver) {
		ndriver =sdriver;
		PageFactory.initElements(sdriver, this);
	}

	@FindBy(xpath="(//div[@class=\"productinfo text-center\"])[1]")
	@CacheLookup
	WebElement imageFrame1;


	@FindBy(xpath="(//a[@class=\"btn btn-default add-to-cart\"])[1]")
	@CacheLookup
	WebElement clickOn;

	@FindBy(xpath="(//a[@href=\"/view_cart\"])[2]")
	@CacheLookup
	WebElement viewCart;

	@FindBy(xpath="//a[text()=\"Blue Top\"]")
	@CacheLookup
	WebElement vf_Products;


	@FindBy(xpath="//a[text()=\"Proceed To Checkout\"]")
	@CacheLookup
	WebElement continueCheck;

	@FindBy(xpath="//u[text()=\"Register / Login\"]")
	@CacheLookup
	WebElement loginButton;


	@FindBy(xpath="(//input[@name=\"name\"])[1]")
	@CacheLookup
	WebElement uName;	


	@FindBy(xpath="(//input[@name=\"email\"])[2]")
	@CacheLookup
	WebElement eMail;

	@FindBy(xpath="(//button[@type=\"submit\"])[2]")
	@CacheLookup
	WebElement logIn;


	@FindBy(xpath="(//button[@type=\"submit\"])[2]")
	@CacheLookup
	WebElement passWord;

	@FindBy(xpath="(//button[@type=\"submit\"])[2]")
	@CacheLookup
	WebElement fristName;


	@FindBy(id="password")
	@CacheLookup
	WebElement passwordUser;		

	@FindBy(id="first_name")
	@CacheLookup
	WebElement firstName;		

	@FindBy(id="last_name")
	@CacheLookup
	WebElement lName;

	@FindBy(id="address1")
	@CacheLookup
	WebElement adreSs;

	@FindBy(id="state")
	@CacheLookup
	WebElement staTe;		

	@FindBy(id="city")
	@CacheLookup
	WebElement ciTy;				


	@FindBy(id="zipcode")
	@CacheLookup
	WebElement ZipCode;	
	
	@FindBy(id="mobile_number")
	@CacheLookup
	WebElement MobileNumber;


	@FindBy(xpath="(//button[@class=\"btn btn-default\"])[1]")
	@CacheLookup
	WebElement createAccount;	

	@FindBy(xpath="//b[text()=\"Account Created!\"]")
	@CacheLookup
	WebElement createAccount_vf;					



	@FindBy(xpath="//a[text()=\"Continue\"]")
	@CacheLookup
	WebElement conTinue;




	@FindBy(xpath="//b[text()=\"Shwetha\"]")
	@CacheLookup
	WebElement logginName;		

	@FindBy(xpath="(//a[@href=\"/view_cart\"])[1]")
	@CacheLookup
	WebElement cartClick;

	@FindBy(xpath="//a[@class=\"btn btn-default check_out\"]")
	@CacheLookup
	WebElement placeOrder;


	@FindBy(xpath="//a[@href=\"/delete_account\"]")
	@CacheLookup
	WebElement deleteacc;


	@FindBy(xpath="(//li[text()=\"India\"])[1]")
	@CacheLookup
	WebElement adress_vf;


	@FindBy(xpath="//textarea[@name=\"message\"]")
	@CacheLookup
	WebElement commentText;


	@FindBy(xpath="//a[@class=\"btn btn-default check_out\"]")
	@CacheLookup
	WebElement placeOrder1;


	@FindBy(xpath="//input[@name=\"name_on_card\"]")
	@CacheLookup
	WebElement name;

	@FindBy(xpath="//input[@name=\"card_number\"]")
	@CacheLookup
	WebElement cardNo;

	@FindBy(xpath="//input[@name=\"cvc\"]")
	@CacheLookup
	WebElement cvv;

	@FindBy(xpath="//input[@name=\"expiry_month\"]")
	@CacheLookup
	WebElement expireDate;

	@FindBy(xpath="//input[@name=\"expiry_year\"]")
	@CacheLookup
	WebElement expireyear;

	@FindBy(xpath="//button[text()=\"Pay and Confirm Order\"]")
	@CacheLookup
	WebElement confirmOrder;

	@FindBy(xpath="//p[text()=\"Congratulations! Your order has been confirmed!\"]")
	@CacheLookup
	WebElement sucess;	


	@FindBy(xpath="//a[@class=\"btn btn-default check_out\"]")
	@CacheLookup
	WebElement downloadInvoice;

	@FindBy(xpath="//a[@href=\"/delete_account\"]")
	@CacheLookup
	WebElement Delete;

	@FindBy(xpath="//p[contains(text(),\"Your \")]")
	@CacheLookup
	WebElement sMsg;
	
	
	@FindBy(xpath="//p[text()=\"Your account has been permanently deleted!\"]")
	@CacheLookup
	WebElement deleteMsg;
	public void mouseHover() {
		Actions a = new Actions(ndriver);
		a.moveToElement(imageFrame1);
		clickOn.click();
		viewCart.click();

	}
	public String productVerfiy() {
		return vf_Products.getText();
	

	}
	public void chechkOutproducts() {
		continueCheck.click();
		loginButton.click();
	}
	public void loginUser() {
		uName.sendKeys("Shwetha");
		eMail.sendKeys("Xyzuhkjkjh@ejh");
		logIn.click();
	}

	public void userDetails() {
		passwordUser.sendKeys("1234");
		firstName.sendKeys("shwetha");
		lName.sendKeys("Shetty");
		adreSs.sendKeys("bangalore");
		staTe.sendKeys("karnataka");
		ciTy.sendKeys("bangalore");
		ZipCode.sendKeys("12345");
		MobileNumber.sendKeys("1234456788");
		createAccount.click();

	}
	public String accountCreatedVerfiy() {
		 return createAccount_vf.getText();
		

	}
	public void clickOnContinue() {
		conTinue.click();

	}


	public String userName_vf() {
		return logginName.getText();		
	}


	public void cartButton() {
		cartClick.click();
		placeOrder.click();

	}

	public String adressVerfiy() {
		 return adress_vf.getText();
		
	}

	public void commentEnter() {
		commentText.sendKeys("delivery  the product tomorrow");
		placeOrder1.click();
	}

	public void cardDetails() {
		name.sendKeys("SHweta shetty");
		cardNo.sendKeys("2345677");
		cvv.sendKeys("123");
		expireDate.sendKeys("12");
		expireyear.sendKeys("12345");
		confirmOrder.click();
	}

	public String sucessFullmsg() {
		return sucess.getText();
	
	}

	public void deleteButton() {
		Delete.click();
	}
	public void dowloadInvoiceCpy() {
		downloadInvoice.click();
	}

	public String delete_msg() {
		return deleteMsg.getText();
		
	}
public void tearDown() {
	ndriver.quit();
}
}
