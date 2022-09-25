package commonuseractions;

import java.io.IOException;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import utils.Mail;

public class TestListner implements ITestListener {
	
	public static ThreadLocal<Map<String, String>> inputdata = ThreadLocal.withInitial(() -> {
		Map<String, String> map = new HashMap<>();
		return map;
	});

	public static Map<String, String> getInputData() {
		return inputdata.get();
	}

	CommonActionMethods commonfunctions = null;
	public static String mailText = "";
	public static LocalTime startTime;
	public static boolean mailFlag = true;
	public static ThreadLocal<String> FailedScreenShotdestination = new ThreadLocal<String>();
	public static JSONObject testNumber = new JSONObject();
	public static Set<String> setTestNames = new LinkedHashSet<String>();

	public static int passed = 0;
	public static int failure = 0;
	public static int skipping = 0;


	public static ThreadLocal<String> scenarioIterate = new ThreadLocal<String>();


	public static ThreadLocal<String> scenarioComments = new ThreadLocal<String>();

	public static String getScenarioComments() {
		return scenarioComments.get();
	}

	public static ThreadLocal<String> scenarioNo = new ThreadLocal<String>();

	public static String getScenarioNumber() {
		return scenarioNo.get();
	}

	public static ThreadLocal<String> scenarioDescription = new ThreadLocal<String>();

	public static String getScenarioDescription() {
		return scenarioDescription.get();
	}

	public static ThreadLocal<String> scenarioStatus = new ThreadLocal<String>();

	public static String getScenarioStatus() {
		return scenarioStatus.get();
	}

	public static ThreadLocal<Integer> errorLogCount = ThreadLocal.withInitial(() -> {
		return Integer.valueOf(0);
	});

	public static Integer getErrorLogCount() {
		return errorLogCount.get();
	}

	public static ThreadLocal<Integer> totalClassTest = ThreadLocal.withInitial(() -> {
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
	public synchronized void onFinish(ITestContext context) {

	}

	@Override
	public synchronized void onTestStart(ITestResult result) {
		totalClassTest.set(getClassTestCount() + 1);
		errorLogCount.set(0);

	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		System.out.println("On success");
			try {
				scenarioNo.set(commonfunctions.getdata("Number"));
				scenarioDescription.set(commonfunctions.getdata("Scenario"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			scenarioStatus.set("Passed");
			scenarioComments.set(" Execution Passed successfuly ");
			passed++;
			Map<Object, Object> testAttrb = new HashMap<Object, Object>();
			testAttrb.put("scenario_no", getScenarioNumber());
			testAttrb.put("scenario_description", getScenarioDescription());
			testAttrb.put("scenario_status", getScenarioStatus());
			testAttrb.put("scenario_comment", getScenarioComments());

			testNumber.put(getScenarioNumber() + "_" + commonfunctions.testName, testAttrb);
			setTestNames.add(commonfunctions.testName);
			System.out.println(testNumber);
			scenarioNo.set(null);
			scenarioDescription.set(null);
			scenarioStatus.set(null);
			scenarioComments.set(null);

	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		failure++;
		System.out.println("On Failiure");
		Map<Object, Object> testAttrb = new HashMap<Object, Object>();
		testAttrb.put("scenario_no", getScenarioNumber());
		testAttrb.put("scenario_description", getScenarioDescription());
		testAttrb.put("scenario_status", getScenarioStatus());
		testAttrb.put("scenario_comment", getScenarioComments());
		testNumber.put(getScenarioNumber() + "_" + commonfunctions.testName, testAttrb);
		setTestNames.add(commonfunctions.testName);
		System.out.println(testNumber);
		try {
			Mail.sendReport("Null");
		} catch (IOException e) {
			e.printStackTrace();
		}
		scenarioNo.set(null);
		scenarioDescription.set(null);
		scenarioStatus.set(null);
		scenarioComments.set(null);
	}

	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		System.out.println("On skipped");
//		try {
//			skipping++;
//			scenarioNo.set("Skipped: "+commonfunctions.getdata("Number"));
//			scenarioDescription.set(commonfunctions.getdata("Scenario"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		scenarioStatus.set("Skipped");
//		scenarioComments.set(" Test skipped ");
//		Map<Object, Object> testAttrb = new HashMap<Object, Object>();
//		testAttrb.put("scenario_no", getScenarioNumber());
//		testAttrb.put("scenario_description", getScenarioDescription());
//		testAttrb.put("scenario_status", getScenarioStatus());
//		testAttrb.put("scenario_comment", getScenarioComments());
//
//		testNumber.put(getScenarioNumber() + "_" + commonfunctions.testName, testAttrb);
//		setTestNames.add(commonfunctions.testName);
//		System.out.println(testNumber);
//		scenarioNo.set(null);
//		scenarioDescription.set(null);
//		scenarioStatus.set(null);
//		scenarioComments.set(null);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}


}
