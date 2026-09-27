package resorces;

import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReporterTestNG {
	@BeforeMethod
	public static ExtentReports report() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Test");
		reporter.config().setDocumentTitle("Results");
		
		 ExtentReports report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "Chetan Shinde");
		report.createTest(path);
		return report;
	}
}
