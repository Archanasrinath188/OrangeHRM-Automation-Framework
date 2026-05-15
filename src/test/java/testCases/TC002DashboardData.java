package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Dashboard;
import testBase.BaseClass;

public class TC002DashboardData extends BaseClass {
	@Test
	public void dashboard(){
	
	Dashboard db=new Dashboard(driver);
	 Assert.assertTrue(db.isDashboardDisplayed(), "Dashboard is not displayed");
}
}