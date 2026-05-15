package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PIMpage extends BasePage {

	public PIMpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//span[text()='PIM']")
	WebElement pim;
	
	@FindBy(xpath="//a[text()='Add Employee']")
	WebElement addemployee;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement lastname;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement save;
	
	public void pim_click() {
		pim.click();
		
	}
	
	public void add_employee(String fname,String lname) {
		addemployee.click();
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		save.click();

	}
}
