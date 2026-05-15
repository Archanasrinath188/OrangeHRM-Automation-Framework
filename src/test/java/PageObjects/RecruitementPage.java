package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecruitementPage extends BasePage {

	public RecruitementPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//span[text()=\"Recruitment\"]")
	WebElement Recruitment;
	
	@FindBy(xpath="//div[@class=\"oxd-topbar-header-title\"]")
	WebElement RecruitmentIsDisplayed;
	
	public void recruit() {
		Recruitment.click();
	}
	public Boolean recruit_isdisplayed() {
		return RecruitmentIsDisplayed.isDisplayed();
	}

}
