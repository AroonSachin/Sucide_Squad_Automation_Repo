package commonuseractions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Allure;
import utils.DriverFactory;
import utils.Mail;

public class TestListner implements ITestListener {
	public static boolean haveallure=false;
	protected static ThreadLocal<Map<String, String>> inputdata = ThreadLocal.withInitial(() -> {
		return new HashMap<>();	

	});

	public static Map<String, String> getInputData() {
		return inputdata.get();
	}	
	
	CommonActionMethods commonfunctions = null;
	public static String mailText = "";
	public static LocalTime startTime = null;
	public static boolean mailFlag = true;
	public static ThreadLocal<String> FailedScreenShotdestination = new ThreadLocal<>();
	public static JSONObject testNumber = new JSONObject();
	public static Set<String> setTestNames = new LinkedHashSet<>();
	protected static int passed = 0;
	protected static int failure = 0;
	protected static int skipping = 0;
	protected static ThreadLocal<String> scenarioIterate = new ThreadLocal<>();


	protected static ThreadLocal<String> scenarioComments = new ThreadLocal<>();

	protected static String getScenarioComments() {
		return scenarioComments.get();
	}

	protected static ThreadLocal<String> scenarioNo = new ThreadLocal<>();

	protected static String getScenarioNumber() {
		return scenarioNo.get();
	}

	protected static ThreadLocal<String> scenarioDescription = new ThreadLocal<>();

	public static String getScenarioDescription() {
		return scenarioDescription.get();
	}

	protected static ThreadLocal<String> scenarioStatus = new ThreadLocal<>();

	public static String getScenarioStatus() {
		return scenarioStatus.get();
	}

	protected static ThreadLocal<Integer> errorLogCount = ThreadLocal.withInitial(() -> {
		return Integer.valueOf(0);
	});

	public static Integer getErrorLogCount() {
		return errorLogCount.get();
	}

	protected static ThreadLocal<Integer> totalClassTest = ThreadLocal.withInitial(() -> {
		return Integer.valueOf(0);
	});

	public static Integer getClassTestCount() {
		return totalClassTest.get();
	}

	// Extent Report Declarations
	
	@Override
	public synchronized void onStart(ITestContext context) {
		startTime = LocalTime.now();
	}

	@Override
	public synchronized void onTestStart(ITestResult result) {
		
		totalClassTest.set(getClassTestCount() + 1);
		errorLogCount.set(0);

	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		try {
			scenarioNo.set(CommonActionMethods.getdata("Number"));
			scenarioDescription.set(CommonActionMethods.getdata("Scenario"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		scenarioStatus.set("Passed");
		scenarioComments.set(" Execution Passed successfuly ");
		passed++;
		Map<Object, Object> testAttrb = new HashMap<>();
		testAttrb.put("scenario_no", getScenarioNumber());
		testAttrb.put("scenario_description", getScenarioDescription());
		testAttrb.put("scenario_status", getScenarioStatus());
		testAttrb.put("scenario_comment", getScenarioComments());

		testNumber.put(getScenarioNumber() + "_" + CommonActionMethods.testName, testAttrb);
		setTestNames.add(CommonActionMethods.testName);
		scenarioNo.remove();
		scenarioDescription.remove();
		scenarioStatus.remove();
		scenarioComments.remove();

	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		failure++;
		Map<Object, Object> testAttrb = new HashMap<>();
		testAttrb.put("scenario_no", getScenarioNumber());
		testAttrb.put("scenario_description", getScenarioDescription());
		testAttrb.put("scenario_status", getScenarioStatus());
		testAttrb.put("scenario_comment", getScenarioComments());
		testNumber.put(getScenarioNumber() + "_" + CommonActionMethods.testName, testAttrb);
		setTestNames.add(CommonActionMethods.testName);
		try {
			Mail.sendReport("Null");
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(haveallure) {
			Allure.addAttachment(UUID.randomUUID().toString(),new ByteArrayInputStream(((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES)));
			haveallure=false;
		}
		scenarioNo.remove();
		scenarioDescription.remove();
		scenarioStatus.remove();
		scenarioComments.remove();

	}

}
