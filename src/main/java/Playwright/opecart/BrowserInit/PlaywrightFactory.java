package Playwright.opecart.BrowserInit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class PlaywrightFactory 
{
	Playwright playwright;
	Browser browser;
	static BrowserContext browsercontxt;
	Page page;
	Properties prop;
	public Page initbrowser(Properties prop)

	{
		String browsername=prop.getProperty("browser");
		System.out.println("Browsertype is "+browsername);
		 playwright=Playwright.create();
		 
		 
		switch (browsername) 
		{
		case "chrome":
			
			browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;

         case "firefox":
			
			browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
			
         case "safari":

 			browser=playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
 			break;
	
         default:
			
			System.out.println("Browsertype is not valid");
			break;
		}
		
		browsercontxt=browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myvideo/")));
		
		//opengetscreenshot();
		
		page=browsercontxt.newPage();
		
		page.navigate(prop.getProperty("url"));
		
		
		return page;
		
	}
	
	
	public Properties initpropeties() 
	{
		
		try {
			FileInputStream fin=new FileInputStream("./src/test/resource/config/config.properties");
			
			prop=new Properties();
			prop.load(fin);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
		
	}
	
/*	public static void opengetscreenshot()
	{
		try {
			browsercontxt.tracing().start(new Tracing.StartOptions()
					  .setScreenshots(true)
					  .setSnapshots(true));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void closescreenshot()
	{
		browsercontxt.tracing().stop(new Tracing.StopOptions()
	    		  .setPath(Paths.get("trace1.zip")));
	}*/
}
