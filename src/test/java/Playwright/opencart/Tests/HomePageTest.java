package Playwright.opencart.Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Playwright.opencart.Base.BaseTest;
import Playwright.opencart.Constant.Appconstant;

public class HomePageTest extends BaseTest
{
	
	 
	 @Test
	 
	 public void HomepageTitleTest()
	 {
		 
		 String title=homepage.getHomePageTitle();
		 Assert.assertEquals(title,Appconstant.HOMEPAGE_TITLE);
	 }
	 
	 
 @Test
	 
	 public void HomepageURLTest()
	 {
		 
		 String URL=homepage.getHomePageURL();
		 Assert.assertEquals(URL,prop.getProperty("url"));
	 }
	 
 
 @DataProvider
	public Object[][] getProductData() {
	return new Object[][]
			{
			{ "Macbook" }, 
			{ "iMac" }, 
			{ "Samsung" }
	};
	}
 
 @Test(dataProvider = "getProductData")
 
 public void searchTest(String productname) throws InterruptedException 
 {
	 
	 String searchtext=homepage.dosearch(productname);
	 Assert.assertEquals(searchtext,"Search - "+productname);
 }
 
	 
	
	
}
