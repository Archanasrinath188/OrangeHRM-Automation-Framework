package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.LeavePage;
import PageObjects.LoginPage;
import testBase.BaseClass;

public class TC005LeaveData extends BaseClass {
	@BeforeMethod
	public void login_data() {
		LoginPage lp=new LoginPage(driver);
		lp.login_data("Admin","admin123");
		
	}
	@Test
	public void leave_data() {
		LeavePage lp=new LeavePage(driver);
		lp.leave_data();
		Assert.assertTrue(lp.leaveisdisplayed(),"leave page is not displayed");
		
	}
	

}
