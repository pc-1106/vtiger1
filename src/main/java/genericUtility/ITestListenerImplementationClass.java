package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ITestListenerImplementationClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	JavaUtility jUtils = new JavaUtility();

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());

		try {
			String screenshotPath = WebDriverUtility.takeScreenshot(BaseClass.sDriver,
					result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(screenshotPath, "Failed huh !!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./extent_reports/vtiger_report.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("vtiger extent report");
		spark.config().setDocumentTitle("vtiger Report");

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("By", "Piyush");
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("Machine Brand", "HP");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Created at", jUtils.generateSystemDateAndTime());
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
	}

}
