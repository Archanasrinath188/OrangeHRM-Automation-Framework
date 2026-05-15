package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends BasePage {

	public AdminPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//span[text()='Admin']")
	WebElement admin;
	
	@FindBy(xpath="//h6[text()='Admin']")
	WebElement admin_msg;


	public void adm() {
		admin.click();
		
	}
	
	public boolean admin_isdisplayed() {
		return admin_msg.isDisplayed();
	}
	
}