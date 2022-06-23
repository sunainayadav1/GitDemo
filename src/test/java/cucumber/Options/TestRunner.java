package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/googleAPI.feature", 
		/*
		 * format = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
		 * "json:target/cucumber-reports/CucumberTestReport.json",
		 * "rerun:target/cucumber-reports/rerun.txt" },
		 */
                 plugin="json:target/jsonReports/cucumber-maven-report.json",
                 
                 glue = "stepDefinitions",
                 tags= "@DeletePlace")
public class TestRunner {
	
	//This command is to just test git
	//This command is added from gitHub
	
	//Trying git fetch
	//Trying git pull

}
