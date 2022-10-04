package Playwright.opencart.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Playwright.opencart.Base.BaseTest;
import Playwright.opencart.Constant.Appconstant;

public class LoginPageTest extends BaseTest
{

	@Test(priority = 1)
	public void loginPageNavigationTest() {
		loginpage = homepage.navigateToLoginPage();
		String actLoginPageTitle = loginpage.getLoginPageTitle();
		System.out.println("page act title: " + actLoginPageTitle);
		Assert.assertEquals(actLoginPageTitle,Appconstant.LOGINPAGE_TITLE);
	}

	@Test(priority = 2)
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginpage.isForgotPwdLinkExist());
	}

	@Test(priority = 3)
	public void appLoginTest() {
		Assert.assertTrue(loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
	}
	
}
