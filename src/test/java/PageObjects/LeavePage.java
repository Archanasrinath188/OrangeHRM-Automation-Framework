package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeavePage extends BasePage

{

	public LeavePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//span[text()=\"Leave\"]")
	WebElement leave;
	
	@FindBy(xpath="//h6[text()=\"Leave\"]")
	WebElement leave_isdisplayed;
	
	public void leave_data() {
		leave.click();
		
	}
	public Boolean leaveisdisplayed() {
		return leave_isdisplayed.isDisplayed();
	}
	
	
	
}
