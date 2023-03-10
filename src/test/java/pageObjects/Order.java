package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Order {

	public WebDriver ndriver;
	public Order(WebDriver sdriver) {
		ndriver =sdriver;
		PageFactory.initElements(sdriver, this);

	}
	@FindBy(xpath="//input[@data-qa=\"login-email\"]")
	@CacheLookup
	WebElement user_name;

	@FindBy(xpath="//input[@name=\"password\"]")
	@CacheLookup
	WebElement pass;

	@FindBy(xpath="	//button[text()=\"Login\"]")
	@CacheLookup
	WebElement login;

	@FindBy(xpath="//b[text()=\"shwetha\"]")
	@CacheLookup
	WebElement login_Name;

	@FindBy(xpath="(//div[@class=\"productinfo text-center\"])[1]")
	@CacheLookup
	WebElement imageFrame;

	@FindBy(xpath="(//a[@class=\"btn btn-default add-to-cart\"])[1]")
	@CacheLookup
	WebElement clickOn;


	@FindBy(xpath="//h4[@class=\"modal-title w-100\"]")
	@CacheLookup
	WebElement vf_Cartadd;

	@FindBy(xpath="(//a[@href=\"/view_cart\"])[1]")
	@CacheLookup
	WebElement vf_Cartadd1;

	@FindBy(xpath="//a[contains(text(),\"Proc\")]")
	@CacheLookup
	WebElement procced;

	@FindBy(xpath="(//li[text()=\"India\"])[1]")
	@CacheLookup
	WebElement adrss_txt;

	@FindBy(xpath="(//li[@class=\"address_phone\"])[1]")
	@CacheLookup
	WebElement phone_txt;

	@FindBy(xpath="//textarea[@name=\"message\"]")
	@CacheLookup
	WebElement comment;

	@FindBy(xpath="//a[text()=\"Place Order\"]")
	@CacheLookup
	WebElement placeOrder;

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

	@FindBy(xpath="//p[contains(text(),\"Your \")]")
	@CacheLookup
	WebElement sMsg;

	@FindBy(xpath="//p[text()=\"Congratulations! Your order has been confirmed!\"]")
	@CacheLookup
	WebElement sucess;			

	@FindBy(xpath="//a[@href=\"/delete_account\"]")
	@CacheLookup
	WebElement delete;	
	
	
	@FindBy(xpath="//a[@class=\"btn btn-primary\"]")
	@CacheLookup
	WebElement continue_Click;	

	public void userName(String uname,String password) {
		user_name.sendKeys(uname);
		pass.sendKeys(password);
		login.click();

	}
	public String nameUser() {
		return  login_Name.getText();
		
	}

	public void addCart() {
		Actions a = new Actions(ndriver);
		a.moveToElement(imageFrame);
		clickOn.click();
	}
	public String cartAddedDisplayed() {
		return vf_Cartadd.getText();
	
	}
	public void viewCart() {
		vf_Cartadd1.click();
	}
	public void checkout() {
		procced.click();
	}

	public String getAdressText() {
		return adrss_txt.getText();

	}
	public String getPhoneText() {
		return 	phone_txt.getText();
	}
	public void comments() {
		comment.sendKeys("Please delviery the order moring 6am to 9am");
		placeOrder.click();
	}

	public void cardDetails() {
		name.sendKeys("SHweta shetty");
		cardNo.sendKeys("2345677");
		cvv.sendKeys("123");
		expireDate.sendKeys("12");
		expireyear.sendKeys("12345");
		confirmOrder.click();
	}


	public String sucessfullmsg() {
		return sucess.getText();
		
	}

	public void deleteButton() {
		delete.click();

	}
	public boolean delete_msg() {
		boolean msg =sMsg.isDisplayed();
		return msg;
	}
	
	public void continueClick() {
		continue_Click.click();
	}
	public void tearDown() {
		ndriver.close();
	}
}




