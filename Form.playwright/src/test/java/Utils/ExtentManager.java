package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	public static ExtentReports extent;
	
	public static ExtentReports getReportInstance()
	{
		if(extent==null)
		{
			ExtentSparkReporter spark=new ExtentSparkReporter("Reports/ExtentReport.html");
			spark.config().setReportName("Form Automation Test Report");
			spark.config().setDocumentTitle("Test Results");
			
			extent=new ExtentReports();
			extent.attachReporter(spark);		}
		return extent;
	}

}
