package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(tags = "@PhpTravels or @YourLogo", features = {"src/test/resources/features"}, glue = {
		"stepdefinition" }, monochrome = true)
public class CucumberTestRunner {

	private TestNGCucumberRunner testNGCucumberRunner = null;

	@BeforeClass(alwaysRun = true)
	public void setUP() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	} 

	@Test(dataProvider = "data")
	public void firstTest(PickleWrapper pickle, FeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runScenario(pickle.getPickle());
	}

	@DataProvider(name="data")
	public Object[][] data() {
		return testNGCucumberRunner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() {
		testNGCucumberRunner.finish();
	}

}
