package yourlogo;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	int counter=0;
    int retrylist=3;
	@Override
	public boolean retry(ITestResult result) {
		if(counter <retrylist) {
			counter++;
		return true;
	}
		return false;
	}

}