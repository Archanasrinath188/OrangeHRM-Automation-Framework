package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.AdminPage;
import PageObjects.LoginPage;
import testBase.BaseClass;

public class TC004AdminData extends BaseClass{

	@BeforeMethod
	public void login_data() {
		LoginPage lp=new LoginPage(driver);
		lp.login_data("Admin","admin123");
		
	}
	
	
	@Test
	public void admin_data() {
		
		
		AdminPage ad=new AdminPage(driver);
		ad.adm();
		Assert.assertTrue(ad.admin_isdisplayed(),"Admin page is not displayed");
		
	}
	
}
