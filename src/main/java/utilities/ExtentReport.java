package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static ExtentReports getExtentReport() {
		
		// define the path where ectentreport will be generated
		String extentReportPath=System.getProperty("user.dir")+"\\Reports\\extentreport.html";
		
		//Create an object for ExtentSparkReport
		ExtentSparkReporter reporter= new ExtentSparkReporter(extentReportPath);
		
		//set the report name and document title
		reporter.config().setReportName("Spicejet Automation Result");
		reporter.config().setDocumentTitle("Spicejet Automation Test Result");
		
		//create an object of ExtentReport
		ExtentReports extentReport=new ExtentReports();
		
		extentReport.attachReporter(reporter);
		
		return extentReport;
		
	}
}
