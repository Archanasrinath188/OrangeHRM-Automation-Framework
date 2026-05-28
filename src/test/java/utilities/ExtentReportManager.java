package utilities;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.util.List;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;//UI of the reports(color,theme,etc...)
	public ExtentReports extent;//populate common info of the reports(browsername ,computer name, os....)
	public ExtentTest Test;//create test case entries in the report and update status of the test methods
	
	String repName;
	
	public void onStart(ITestContext testcontext) {
		
		 System.out.println("onStart executed"); 

		
		
	/*	SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date d=new Date();
		String timeStamp=df.format(d);
	*/	
		
		//we simplify the above staments in one single statement.
		
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName="Test-Report"+timeStamp+".html";
		
		sparkReporter = new ExtentSparkReporter(".\\reports\\ExtentReport.html");
		sparkReporter.config().setDocumentTitle("Automation report");//title of the report
		sparkReporter.config().setReportName("Functional testing");//name of the report		
		sparkReporter.config().setTheme(Theme.DARK);//color of the report
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("computername","local host");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("Browser Name", "Chrome");
		extent.setSystemInfo("Tester name","archana");
		extent.setSystemInfo("OS","Windows10");
		
		String os=testcontext.getCurrentXmlTest().getParameter("os");  //THIS WILL CAPTURE OPERATIONG SYSTEM NAME FROM XML FILE
		extent.setSystemInfo("operating System", os);
		
		String browser=testcontext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
	
		
		
		//getCurentXmlTest()will return the xml file
	//	getincludedgropus()will capture the group names which we are specified in the include section.and display them
		
		List<String> includedGroups=(List<String>) testcontext.getCurrentXmlTest().getIncludedGroups();
		if (!includedGroups.isEmpty()) {  //group information is not empty
			extent.setSystemInfo("Groups",includedGroups.toString());// add the information to the report
			
		}
		
		
		
	}
	public void onTestSuccess(ITestResult result) {
		
		//getTestclassmethod is used to get the name of the class
		Test=extent.createTest(result.getTestClass().getName());//create anew entry in the report and get the name of the report
		Test.assignCategory(result.getMethod().getGroups());//to display groups in report
		Test.log(Status.PASS,"Test case PASSED is:/"+result.getName());//update the status
		
		
	}
	public void onTestFailure(ITestResult result) {
		Test=extent.createTest(result.getTestClass().getName());
		Test.assignCategory(result.getMethod().getGroups());
		
		Test.log(Status.FAIL,result.getName()+"got failed");
		Test.log(Status.INFO,result.getThrowable().getMessage());
		try{
			String imgpath=new  BaseClass().captureScreen(result.getName());//calling capturescreen method from baseclass then the targetfile path will be stored in a variable of imgpath
			Test.addScreenCaptureFromPath(imgpath);//this imgpath will be added tothe report
		}catch (Exception e1) {
			
			e1.printStackTrace();//if screenshot is not captured or not available then file not found exception will throw
			
			
		}
			
			
		
		
		
	}
	public void OnTestSkipped(ITestResult result) {
		Test=extent.createTest(result.getName());
		Test.log(Status.SKIP, "Test case SKIPPED is :/"+result.getName());
	}
	@Override
	public void onFinish(ITestContext context) {
		if (extent != null) {
            extent.flush();
        }
		
		String pathofExtentReport=System.getProperty("user.dir")+"\\reports\\"+repName;//path of the report
		File extentReport=new File(pathofExtentReport); //store into a file
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());//this automatically open the extent report
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



 {

 }}
