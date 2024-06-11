package listener;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import helper.Utility;


public class ExtentManager {
	
	static ExtentReports extent;
	public static ExtentReports getInstance()
	{
		if(extent==null)
		{
			extent=createExtent();
			return extent;
		}
		else
			return extent;
	}
	
	
	public static ExtentReports createExtent()
	{
		ExtentSparkReporter spark=new ExtentSparkReporter(new File("./reports/Automation_"+Utility.getCurrentTime()+"_ report.html"));
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Sprint Automation");
		spark.config().setReportName("Automation report");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(spark);
		return extent;
	}
}
