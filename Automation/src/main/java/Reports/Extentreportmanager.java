package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreportmanager {
	
	 private static ExtentReports extent;
	 public static ExtentReports createReport() {
		if(extent==null)
		{
		ExtentSparkReporter reporter =  new ExtentSparkReporter("Report\\ExtentReport.html");
		reporter.config().setReportName("Automation Report");
		reporter.config().setDocumentTitle("Test Resullts");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Tester", "Selenium");
		extent.setSystemInfo("Browser", "Chrome");
		
	
	}
		return extent;

}
}
