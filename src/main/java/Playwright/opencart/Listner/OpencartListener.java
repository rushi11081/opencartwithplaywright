
package Playwright.opencart.Listner;

import java.nio.file.Paths;
import java.util.Base64;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Page;
public class OpencartListener implements ITestListener
{
     
	public static ExtentTest test;
    ExtentReports extent =Playwright.opencart.Listner.OpencartExtent.getreport();
	Page page;
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName()).assignAuthor("rushikesh").assignCategory("REGRESSION");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub.
		test.log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

	test.fail(result.getThrowable());
//		test.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
//		
		//test.fail(page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screen5.png"))));
		
	//page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screen1.png")));
//
//	String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
//	//getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
//	
//	byte[] buffer = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
//	String base64Path = Base64.getEncoder().encodeToString(buffer);
//	
//	System.out.println(base64Path);

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
	
	
}
