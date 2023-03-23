package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue={"stepDefination"},monochrome=true,
plugin = {"pretty","html:target/cucumber-report-html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","json:target/cucumber.json"},publish=true,tags="@LogoutBefore")
public class TestRunner {
	

}
