package org.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Testcases {
	

	public WebDriver ndriver;
	public Testcases(WebDriver sdriver) {
  	ndriver =sdriver;
  	PageFactory.initElements(sdriver, this);
	}
	
	@FindBy(xpath="//a[@href=\"/test_cases\"]")
	@CacheLookup
	WebElement testcase_click;
	
	
	@FindBy(xpath="//b[text()=\"Test Cases\"]")
	@CacheLookup
	WebElement testcase_vf;
	
	
	

public void testcase_btn() {
	testcase_click.click();
	
}
public String testcasePageDisplayed() {
	return testcase_vf.getText();
}
public void tearDown() {
	ndriver.close();
}
}
