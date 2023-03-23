package stepDefination;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.cucumber.pageobjects.Addreview;
import org.cucumber.pageobjects.Invoice;
import org.cucumber.pageobjects.Logout;
import org.cucumber.pageobjects.Order;
import org.cucumber.pageobjects.Products;
import org.cucumber.pageobjects.Register;
import org.cucumber.pageobjects.Subscription;
import org.cucumber.pageobjects.Testcases;
import org.cucumber.pageobjects.Viewproducts;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.utilities.ExcelReader;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class steps {

   public WebDriver driver;
	public Register rl;
	public Logout Lg;
	public Testcases Ts;
	public Subscription St;
	public Products Vf;
	public Order Lp;
	public Viewproducts Vp;
	public Addreview Ar;
	public Invoice Di;
	


	@Given("User Launch chromebrowser")
	public void user_launch_chromebrowser() {

		String projectpath =System.getProperty("user.dir");
		System.out.println("project path:"+projectpath);

//	System.setProperty("webdriver.gecko.driver", projectpath+"/src/test/resources/Drivers/geckodriver.exe");
//	driver = new FirefoxDriver();
		
//		System.setProperty("webdriver.chrome.driver", projectpath+"/src/test/resources/Drivers/chromedriver.exe");
//	    driver = new ChromeDriver();
		
		System.setProperty("webdriver.edge.driver", projectpath+"/src/test/resources/Drivers/msedgedriver.exe");
		 driver = new EdgeDriver();
		
		rl = new Register(driver);
		Lg = new Logout(driver);
		Ts = new Testcases(driver);
		St = new Subscription(driver);
		Vf = new Products(driver);
		Lp= new Order(driver);
		Vp = new Viewproducts(driver);
		Ar = new Addreview(driver);
		Di = new  Invoice(driver);

		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@When("User Open URL {string}")
	public void user_open_url(String url) {
		driver.get(url);
      }

	@Then("Homepage title should be {string}")
	public void homepage_title_should_be(String title) {
		String ActualTitle = driver.getTitle();
		assertEquals(title, ActualTitle);
	}

	@Then("Click on signup button")
	public void click_on_signup_button() {
		rl.signUpButton();
	}

	@Then("verfiy New User Signup is displayed or not")
	public void user_name_should_visble( ) {
		String expectedSignup =rl.signupButtonisPresent();
		String actualSignup ="New User Signup!";
		assertEquals(expectedSignup,actualSignup);
	}

	@When("User fills the form from given  {string} and  {int}")
	public void user_fills_the_form_from_given_and(String sheetName, int RowNumber) throws InvalidFormatException, IOException {
		
		 ExcelReader reader = new ExcelReader();
		 List<Map<String, String>> testdata = reader.getData("C:/Users/SHWETHSH/OneDrive - Capgemini/Desktop/DataForSelenium.xlsx", sheetName);
		
		String heading =testdata.get(RowNumber).get("Name");
		String emails =testdata.get(RowNumber).get("Email");

	rl.setName(heading, emails);
		
	}

	@When("Click signup button")
	public void click_signup_button() {
		rl.clickSignup();
	}

	@Then("Verfiy Account information is  displayed or not")
	public void verfiy_account_information_is_displayed_or_not() {
		String actualAccountVerfiy = "ENTER ACCOUNT INFORMATION";
		String expectedAccountVerfiy =rl.userNameisPresent();
		assertEquals(actualAccountVerfiy,expectedAccountVerfiy);
	}

	@Then("Enter All account information")
	public void enter_all_account_information() throws InterruptedException {
		rl.titleClick();
		rl.titlePassword();
	}

	@Then("Select checkbox for newselter")
	public void select_checkbox_for_newselter() {
		rl.checkBoxClick();
	}

	@Then("Verfiy Receive special offers from our partners!")
	public void verfiy_receive_special_offers_from_our_partners() {
		String actualCheckbox ="Receive special offers from our partners!";
		String expectedheckbox =rl.chechboxTextisDisplayed();
		assertEquals(actualCheckbox,expectedheckbox);
	}


@Then("user enter all the details given {string} and {int}")
public void user_enter_all_the_details_given_and(String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		
		 ExcelReader reader = new ExcelReader();
		 List<Map<String, String>> testdata = reader.getData("C:/Users/SHWETHSH/OneDrive - Capgemini/Desktop/DataForSelenium.xlsx", sheetName);
	
		String fname =testdata.get(RowNumber).get("firstName");
		String lastName =testdata.get(RowNumber).get("LastName");
		String companyName =testdata.get(RowNumber).get("companyName");
		String adress1 =testdata.get(RowNumber).get("adress1");
		String states =testdata.get(RowNumber).get("states");
		String zipcode =testdata.get(RowNumber).get("zipcode");
		String city =testdata.get(RowNumber).get("city");
		String mobileNumber=testdata.get(RowNumber).get("number");
        rl.PersonalDetails(fname, lastName,companyName,adress1,states,zipcode,city,mobileNumber);
	}

	@Then("Click on create button")
	public void click_on_create_button() {
		rl.createAccount();
	}

	@Then("Verfiy account is visible")
	public void verfiy_account_is_visible() {

	}

	@Then("Click continue button")
	public void click_continue_button() {

		rl.continueAccount();		
	}

	@Then("Verfiy Logged in username")
	public void verfiy_logged_in_username() {
		String actualUsername = "shwetha";
		String expectedUsername =rl.usernameisDisplayed();
		assertEquals(actualUsername,expectedUsername);

	}

	@Then("Click delete button")
	public void click_delete_button() {	
		rl.deleteAccount();
	}

	@Then("Verfiy account is deleted")
	public void verfiy_account_is_deleted() {

		String actualDeleteText = "Your account has been permanently deleted!";
		String expectedDeleteText = rl.deleteMessage();
		assertEquals(actualDeleteText,expectedDeleteText);
		rl.quitBrowser();
	}

	@Then("Verify Login to your account is displayed")
	public void verify_login_to_your_account_is_displayed() {
		String actualText=Lg.loginIsDisplayed();
		String expectedText="Login to your account";
		assertEquals(expectedText,actualText);
	}


@When("User enters email as {string} and password as {int}")
public void user_enters_email_as_sheet_number_and_password_as(String sheetName,Integer RowNumber) throws InvalidFormatException, IOException{
		  Lg.button_click();
		 ExcelReader reader = new ExcelReader();
		 List<Map<String, String>> testdata = reader.getData("C:/Users/SHWETHSH/OneDrive - Capgemini/Desktop/DataForSelenium.xlsx", sheetName);
	
		String usermailid =testdata.get(RowNumber).get("emailId");
		String password =testdata.get(RowNumber).get("Password");
		Lg.emailId(usermailid, password);
	}

	@When("cilck on Login Button")
	public void cilck_on_login_button() {
		Lg.clickLogin();
	}

	@Then("Verify that Logged in as username is displayed")
	public void verify_that_logged_in_as_username_is_displayed() {
		if(Lg.loginUnnameDisplayed()==true) {
			System.out.println("Account user name should be display");
		}
		else {
			System.out.println("account user name should not display");
		} 
	}

	@Then("Click on Logout button")
	public void click_on_logout_button() {
		Lg.logoutClick();
	}

	@Then("Verify that user is navigated to login page")
	public void verify_that_user_is_navigated_to_login_page() {
		if(Lg.homepageVerify()==true) {
			System.out.println("verfied Home page is diplayed");
		}
		else {
			System.out.println("verfied Home Page is displayed");
		} 
	}

	@Then("Click on testcases button")
	public void click_on_testcases_button() throws InterruptedException {

		Ts.testcase_btn();
	}

	@Then("Verify user is navigated to test cases page successfully")
	public void verify_user_is_navigated_to_test_cases_page_successfully() {
		String actualTextOfMsg ="TEST CASES";
		String excepectedTextOfMsg =Ts.testcasePageDisplayed();
		assertEquals(actualTextOfMsg,excepectedTextOfMsg);
		St.tearDown();
	}

	@Then("Scroll down to footer")
	public void scroll_down_to_footer() {

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	@Then("Verfiy text is visible")
	public void verfiy_text_is_visible() {
		String  actualSubscription = "SUBSCRIPTION";
		String expectedSubscription = St.subscriptionIsDisplayed();
		assertEquals(actualSubscription,expectedSubscription);
	}
	@Then("fill the form as {string} and {int} click arrow button")
	public void fill_the_form_as_and_click_arrow_button(String sheetName, Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException {

		ExcelReader reader = new ExcelReader();
		 List<Map<String, String>> testdata = reader.getData("C:/Users/SHWETHSH/OneDrive - Capgemini/Desktop/DataForSelenium.xlsx", sheetName);
	
		String mailid =testdata.get(RowNumber).get("emailId");
		St.submail(mailid);
	    
		St.subClick();

	}

	@Then("Verify success message You have been successfully subscribed is visible")
	public void verify_success_message_you_have_been_successfully_subscribed_is_visible() throws InterruptedException {
		String actualSubscribeText ="You have been successfully subscribed!";
		String expectedSubscribeText =St.sucessMsg();
		assertEquals(actualSubscribeText,expectedSubscribeText);
		
		St.tearDown();

	}

	@Then("Click View Product for any product on home page")
	public void click_view_product_for_any_product_on_home_page() {
		Vf.cartClick();

	}

	@Then("Verify product detail is opened")
	public void verify_product_detail_is_opened() {
		//	String actualTextDress = "Sleveless Dress";
		//	String expectedTextDress=Vf.infoisDisplayed();
		//	assertEquals(actualTextDress,expectedTextDress);

	}

	@Then("Increase quantity to {string}")
	public void increase_quantity_to(String Qtvalue) {
		Vf.enterQuantity(Qtvalue);
	}

	@Then("Click Add to cart button")
	public void click_add_to_cart_button() {	

	}

	@Then("Click View Cart button")
	public void click_view_cart_button() {
		Vf.addtoCartClick();
	}

	@Then("Verify that product is displayed in cart page with exact quantity")
	public void verify_that_product_is_displayed_in_cart_page_with_exact_quantity() {
		String actualQuantity = "4";
		String expectedQuantity =Vf.qtyIsDisplayed();
		assertEquals(actualQuantity,expectedQuantity);
		Vf.tearDown();

	}
	@When("Click on Products button in home page")
	public void click_on_products_button_in_home_page() throws InterruptedException {
		Ar.cilckProducts();

	}

	@Then("Verify user is navigated to ALL PRODUCTS page successfully")
	public void verify_user_is_navigated_to_all_products_page_successfully() throws InterruptedException {
		String actualProductsName =Ar.vfProducts();
		String expectedProductName ="ALL PRODUCTS";
		assertEquals(actualProductsName, expectedProductName);
	}

	@Then("Click on viewproduct button on home page")
	public void click_on_viewproduct_button_on_home_page() {
		Ar.viewCart();

	}

	@Then("Verify Write Your Review is visible")
	public void verify_write_your_review_is_visible() {

	
	}

	@Then("User fill the form using given form {string} and {int}")
	public void user_fill_the_form_using_given_form_and(String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		 ExcelReader reader = new ExcelReader();
		 List<Map<String, String>> testdata = reader.getData("C:/Users/SHWETHSH/OneDrive - Capgemini/Desktop/DataForSelenium.xlsx", sheetName);
	
		String useName =testdata.get(RowNumber).get("UserName");
		String mailId =testdata.get(RowNumber).get("MailId");
		String review = testdata.get(RowNumber).get("comments");
		Ar.accountDetail(useName, mailId,review);
	}
	@Then("Click Submit button")
	public void click_submit_button() {
		Ar.buttonClick();
	}

	@Then("Verify success message Thank you for your review")
	public void verify_success_message_thank_you_for_your_review() {
		String actualThankText = Ar.reviewVf();
		String expectedThankText ="Thank you for your review.";
		assertEquals(actualThankText,expectedThankText);
		Ar.tearDown();
	}
	@When("User enters the details  {string} and  {int} and click on login button")
	public void user_enters_the_details_and_and_click_on_login_button(String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		 ExcelReader reader = new ExcelReader();
		 List<Map<String, String>> testdata = reader.getData("C:/Users/SHWETHSH/OneDrive - Capgemini/Desktop/DataForSelenium.xlsx", sheetName);
	
		String email =testdata.get(RowNumber).get("emailId");
		String password =testdata.get(RowNumber).get("Password");
		Lp.userName(email, password);

	}

	@Then("Verify Logged in as username at top")
	public void verify_logged_in_as_username_at_top() {

		String actualUserName ="shwetha";
		String expectedUserNmae =Lp.nameUser();
		assertEquals(actualUserName,expectedUserNmae);

	}

	@Then("Add to product to cart")
	public void add_to_product_to_cart() {

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,500)", "");

	}

	@Then("Click on cart button")
	public void click_on_cart_button() {
		Lp.addCart();
	}

	@Then("Verify that cart page is displayed")
	public void verify_that_cart_page_is_displayed() {

		//		String actualCartadd = "Added!";
		//		String expectedCardadded=Lp.cartAddedDisplayed();
		//		assertEquals(actualCartadd,expectedCardadded);
	}

	@Then("Click Proceed To Checkout")
	public void click_proceed_to_checkout() {
		Lp.viewCart();
		Lp.checkout();
	}

	@Then("Verify Address Detaials {string} and {string} and Review Your Order")
	public void verify_address_detaials_adress_and_phone_number_and_review_your_order(String address, String phNo) {
		if(Lp.getAdressText().equals(address)&& Lp.getPhoneText().equals(phNo)) {
			System.out.println("Adress and phone number is verfied ");
		}
		else {
			System.out.println("Adress and Phone number not veried ");
		}
	}

	@Then("Enter description in {string} and {int}  and click Place Order")
	public void enter_description_in_and_and_click_place_order(String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		 List<Map<String, String>> testdata = reader.getData("C:/Users/SHWETHSH/OneDrive - Capgemini/Desktop/DataForSelenium.xlsx", sheetName);
	
		String useName =testdata.get(RowNumber).get("comments");
		Lp.comments(useName);
	}

	@Then("Enter all card details as per the sheet {string} and {int}")
	public void enter_all_card_details_as_per_the_sheet_and(String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		 List<Map<String, String>> testdata = reader.getData("C:/Users/SHWETHSH/OneDrive - Capgemini/Desktop/DataForSelenium.xlsx", sheetName);	
		String cardName =testdata.get(RowNumber).get("cardName");
		String cardNumber =testdata.get(RowNumber).get("Cardnumber");
		String expereDate =testdata.get(RowNumber).get("expaireDates");
		String cvv =testdata.get(RowNumber).get("cvv Number");
		String expereyear =testdata.get(RowNumber).get("expaired year");
		Lp.cardDetails(cardName, cardNumber, cardNumber, expereDate, expereyear);
	}

	@Then("Click Pay and Confirm Order button")
	public void click_pay_and_confirm_order_button() {

	}

	@Then("Verify success message Your order has been placed successfully!")
	public void verify_success_message_your_order_has_been_placed_successfully() {
		String  actualTextMsg ="Congratulations! Your order has been confirmed!";
		String expectedTextMsg =Lp.sucessfullmsg();
		assertEquals(actualTextMsg,expectedTextMsg);

	}

	@Then("Click Delete Account button")
	public void click_delete_account_button() {
		Lp.deleteButton();
		Lp.continueClick();
	}

	@Then("Verify {string} and click Continue button")
	public void verify_account_deleted_and_click_continue_button(String title1) {
		String ActualTitle = driver.getTitle();
		assertEquals(title1,ActualTitle);
		//Lp.tearDown();    	

	}
	@Then("Click on Products button")
	public void click_on_products_button() {
		Vp.productsClick();
	}

	@Then("Verify that Brands are visible on left side bar")
	public void verify_that_brands_are_visible_on_left_side_bar() {
		String actualBrand ="BRANDS";
		String expectedBrand =Vp.brandsname();
		assertEquals(actualBrand,expectedBrand);
	}

	@Then("Click on any brand name")
	public void click_on_any_brand_name() {
		Vp.brandsname();
	}

	@Then("Verify that user is navigated to brand page and brand products are displayed")
	public void verify_that_user_is_navigated_to_brand_page_and_brand_products_are_displayed() {

		String actualBrandText ="ALL PRODUCTS";
		String expectedBrandText =Vp.verfiybrandName();
		assertEquals(actualBrandText,expectedBrandText);
	}

	@When("On left side bar, click on any other brand link")
	public void on_left_side_bar_click_on_any_other_brand_link() {
		Vp.brandname_Link();
	}

	@Then("Verify that user is navigated to that brand page and can see products")
	public void verify_that_user_is_navigated_to_that_brand_page_and_can_see_products() {
		String actualProduts ="Brand - Biba Products";
		String expectedProducts =Vp.brandName_Verfiy();
		Vp.tearDoen();

	}
	@Then("Add to cart product button and click on cart button")
	public void add_to_cart_product_button_and_click_on_cart_button() throws InterruptedException {
//		JavascriptExecutor js2 = (JavascriptExecutor) driver;
//		js2.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(3000);
		Di.mouseHover();

	}
	@Then("Validate that cart page is displayed")
	public void validate_that_cart_page_is_displayed() {
		String actualProductText ="Blue Top";
		String expectedProductText =Di.productVerfiy();
		assertEquals(actualProductText,expectedProductText);
	}

	@Then("Click Proceed To Checkout then click on login button")
	public void click_proceed_to_checkout_then_click_on_login_button() throws InterruptedException {
		Di.chechkOutproducts();

	}

	@Then("user fill the details as given form {string} and {int}")
	public void user_fill_the_details_as_given_form_and(String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	ExcelReader reader = new ExcelReader();
	 List<Map<String, String>> testdata = reader.getData("C:/Users/SHWETHSH/OneDrive - Capgemini/Desktop/DataForSelenium.xlsx", sheetName);

	String useName =testdata.get(RowNumber).get("UserName");
	String mailId =testdata.get(RowNumber).get("MailId");
	Di.loginUser(useName, mailId);
    String password =testdata.get(RowNumber).get("Pasword");
	String fname =testdata.get(RowNumber).get("firstName");
	String lastName =testdata.get(RowNumber).get("LastName");
	String companyName =testdata.get(RowNumber).get("companyNames");
	String adress1 =testdata.get(RowNumber).get("adress1");
	String states =testdata.get(RowNumber).get("states");
	String zipcode =testdata.get(RowNumber).get("zipcode");
	String city =testdata.get(RowNumber).get("city");
	String mobileNumber=testdata.get(RowNumber).get("number");
  

	Di.userDetails(password, fname, lastName, adress1, states, city, zipcode, mobileNumber);


	}

	@Then("Verify ACCOUNT CREATED and click Continue button")
	public void verify_and_click_button() throws InterruptedException {
		String actualProductText ="ACCOUNT CREATED!";
		String expectedProuductText =Di.accountCreatedVerfiy();
		assertEquals(expectedProuductText,actualProductText);
	}
    @Then("Validate Logged in as username at top of the page and click on cart button")
	public void verify_at_top_and_click_on_cart_button() throws InterruptedException {

		Di.clickOnContinue();
		String actualName = "shwetha";
		String expectedName =Di.userName_vf();
		assertEquals(actualName,expectedName);
	}
    @Then("Click Proceed To Checkout button")
	public void click_proceed_to_checkout_button() throws InterruptedException {		
		Di.cartButton();
	}
	@Then("Verify Address Details and Review Your Order")
	public void verify_address_details_and_review_your_order() {
		String actualCountryName ="India";
		String expectrdCountryName =Di.adressVerfiy();
		assertEquals(actualCountryName,expectrdCountryName);
	}
	@Then("Enter description in comment text area and click Place Order button")
	public void enter_description_in_comment_text_area_and_click_place_order_button() {
	
	}
	@Then("Enter user enter the card details as per in the form {string} and {int}")
	public void enter_user_enter_the_card_details_as_per_in_the_form_and(String sheetName, Integer RowNumber ) throws InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();
		 List<Map<String, String>> testdata = reader.getData("C:/Users/SHWETHSH/OneDrive - Capgemini/Desktop/DataForSelenium.xlsx", sheetName);

	
	    String comments =testdata.get(RowNumber).get("Comments");
		String cardName =testdata.get(RowNumber).get("cardName");
		String cardNumber =testdata.get(RowNumber).get("Card Number");
		String expereDate =testdata.get(RowNumber).get("expaireDates");
		String cvv =testdata.get(RowNumber).get("cvv Number");
		String expereyear =testdata.get(RowNumber).get("expaired year");
		Di.cardDetails(comments, cardName, cardNumber, cardNumber, expereDate, expereyear);
	
	}

	@Then("Verify success message Your order has been placed successfully is displayed")
	public void verify_success_message_your_order_has_been_placed_successfully_is_displayed() {
		String actualSuccessMsg ="Congratulations! Your order has been confirmed!";
		String expectedSuccessMsg =Di.sucessFullmsg();
		assertEquals(actualSuccessMsg,expectedSuccessMsg);
	}
	@Then("Click Download Invoice button and verify invoice is downloaded successfully.")
	public void click_download_invoice_button_and_verify_invoice_is_downloaded_successfully() {
		Di.dowloadInvoiceCpy();
	}
	@Then("Click on continue button and Click Delete Account button")
	public void click_on_continue_button_and_click_delete_account_button() {

		Di.deleteButton();;
	}
	@Then("Verify ACCOUNT DELETED and click Continue button")
	public void verify_account_deleted_and_click_continue_button() {
		String actualDeleteText = "Your account has been permanently deleted!" ;
		String expectedDeleteText =Di.delete_msg();
		assertEquals(actualDeleteText, expectedDeleteText);
		Di.tearDown();
	}
      //TO TAKE SCREENSHOT//
	@After(order = 1)
	public void takeScreenShot(Scenario scenario) {
		if(scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", "screenshot");
	    	}
	     }
	@After(order = 0)
	public void tearDown() {
	driver.quit();	
	}

}
