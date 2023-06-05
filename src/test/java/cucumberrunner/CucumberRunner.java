package cucumberrunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(tags ="@SwagLab", features = {"src/test/resources/features/feature_Sowmya"}, glue = {
"stepdefinition" }, monochrome = true)

public class CucumberRunner {
	
	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUP() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	} 
	
	@DataProvider(name="data")
	public Object[][] data() {
		return testNGCucumberRunner.provideScenarios();
	}

	@Test(dataProvider = "data")
	public void firstTest(PickleWrapper pickle, FeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runScenario(pickle.getPickle());
	}

	

	@AfterClass(alwaysRun = true)
	public void tearDownClass() {
		testNGCucumberRunner.finish();
	}

}
