package Playwright.opencart.Base;

import java.nio.file.Paths;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;

import Playwright.opecart.BrowserInit.PlaywrightFactory;
import PlaywrightOpencart.Pages.HomePage;
import PlaywrightOpencart.Pages.LoginPage;

public class BaseTest 
{

	
	PlaywrightFactory pf;
	

	 protected HomePage homepage;
	 
	 
	 protected LoginPage loginpage;
	 
	 Page page;
	 
	protected Properties prop;
	 
	 @BeforeTest
	 public void setup()
	 {
		 pf=new PlaywrightFactory();
		prop=pf.initpropeties();
		 page=pf.initbrowser(prop);
		 
		 homepage=new HomePage(page);
		 loginpage=new LoginPage(page);
		 
	 }
	
	 @AfterTest
	 public void end()
	 {
		pf.closescreenshot();
		 page.context().browser().close();
	 }
	 
}
