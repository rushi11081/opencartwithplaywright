package PlaywrightOpencart.Pages;

import com.microsoft.playwright.Page;

public class HomePage
{
   Page page;
	
	// 1 Locators present on homepage 
   private String search= "input[name='search']";
   private String searchbtn="div#search button";
   
   private String searchresult="div#content h1";
   
   private String loginLink = "a:text('Login')";
	private String myAccountLink = "a[title='My Account']";
	
   
	
   // 2 need to initialise the page
   
   
   public HomePage(Page page)
   {
	   this.page=page;
   }
   
   // 3 actions/method  performed on page 
    
   // 3.1 pageTitle 
   public String getHomePageTitle()
   {
	   
	   return page.title(); 
   }
   
   
   // 3.2 pageURL
   public String getHomePageURL()
   {
	   
	   return page.url(); 
   }
   
   // 3.3 Search operation
   public String dosearch(String productname) throws InterruptedException
   {
	   page.fill(search, productname);    // driver.sendkesys()=fill()  
	   
	   page.click(searchbtn);
	 
	   String result=page.textContent(searchresult);        // gettext()=textcontent
	   
	   return result;
   }
   
   public LoginPage navigateToLoginPage() {
		page.click(myAccountLink);
		page.click(loginLink);
		return new LoginPage(page);
	}
}
