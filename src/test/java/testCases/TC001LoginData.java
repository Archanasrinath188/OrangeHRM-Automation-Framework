package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.Dataprovider;

import PageObjects.Dashboard;
import PageObjects.LoginPage;

import testBase.BaseClass;

public class TC001LoginData extends BaseClass {

    @Test(
        dataProvider = "logindata",
        dataProviderClass = Dataprovider.class
    )

    public void Verify_logindata(
            String username,
            String password,
            String result)
            throws InterruptedException {
    	System.out.println(username);
    	System.out.println(password);
    	System.out.println(result);

        LoginPage lp =
                new LoginPage(driver);

        lp.login_data(username, password);

        Dashboard dashboard =
                new Dashboard(driver);

        Thread.sleep(2000);

        if(result.equals("pass")) {

            Assert.assertTrue(
                    dashboard.isDashboardDisplayed());

            lp.log_out();
        }

        else {

            Assert.assertTrue(
                    lp.invalid_cred());
        }
    }
}