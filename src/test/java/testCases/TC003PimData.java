package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.PIMpage;
import testBase.BaseClass;

public class TC003PimData extends BaseClass {
	   @Test
	    public void pim_data() throws InterruptedException {
		   
		   LoginPage lp =
	                new LoginPage(driver);

	        lp.login_data("Admin", "admin123");


	        PIMpage pm = new PIMpage(driver);

	        // Open PIM
	        pm.pim_click();

	        // Add Employee
	        pm.add_employee("Archana", "M");

	        Thread.sleep(3000);
	        
	        pm.employeelist();
	        Thread.sleep(3000);


	        // Search Employee
	        pm.search_employee("Archana M");

	        Thread.sleep(2000);

	        // Delete Employee
	        pm.clickDelete();

	        Thread.sleep(2000);

	        pm.confirmDelete();
	    }
	}
