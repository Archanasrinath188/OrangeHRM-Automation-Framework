package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends BasePage {

	public Dashboard(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//h6[text()='Dashboard']")
	WebElement Dashboard;
	
	public boolean isDashboardDisplayed() {
		return Dashboard.isDisplayed();
		
		
		
	}

}