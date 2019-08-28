package runner;

import io.cucumber.junit.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features ="src/test/java/features"
,glue = {"steps"}
, plugin = {"pretty","html:target/cucumber-html-report"})
public class TestRunner extends TestBase
{
	
}
//strict = false, features = "features", format = { "pretty",
	  //  "html:target/site/cucumber-pretty",
	   // "json:target/cucumber.json" }, tags = { "~@ignore" }




