package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.RecruitementPage;
import testBase.BaseClass;

public class TC006RecruitmentData extends BaseClass {
	@BeforeMethod
	public void login_data() {
		LoginPage lp=new LoginPage(driver);
		lp.login_data("Admin","admin123");
		
	}
	@Test
	public void Recruitment_data() {
	
		RecruitementPage rp=new RecruitementPage(driver);
		rp.recruit();
		Assert.assertTrue(rp.recruit_isdisplayed(),"recruitment is not displayed");
		
		
		
		
		
	}
}
