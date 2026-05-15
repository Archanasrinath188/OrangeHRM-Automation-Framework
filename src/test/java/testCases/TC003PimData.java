package testCases;

import org.testng.annotations.Test;

import PageObjects.PIMpage;
import testBase.BaseClass;

public class TC003PimData extends BaseClass {
	@Test
	public void pim_data() {

	
	
	PIMpage pm=new PIMpage(driver);
	pm.pim_click();
	pm.add_employee("Archana","M");
	
	
	
	}
	

}
