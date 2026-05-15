package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement log_uname;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement log_pass;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement log_submit;
	

	
	
	@FindBy(xpath="//p[text()='Invalid credentials']")
	WebElement invalid_credit;
	
	@FindBy(xpath="//span[@class='oxd-userdropdown-tab']")
	WebElement profileMenu;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement logout;
	

	
	public void login_data(String uname,String pass) {
		

	    log_uname.clear();

	    log_pass.clear();

		log_uname.sendKeys(uname);
		log_pass.sendKeys(pass);
		log_submit.click();
		
	}
	public boolean invalid_cred() throws InterruptedException {

	    Thread.sleep(2000);

	    return invalid_credit.isDisplayed();
	}
	public void log_out() throws InterruptedException {

	    profileMenu.click();

	    Thread.sleep(2000);

	    logout.click();
	    Thread.sleep(2000);

	}
	public boolean loginpage_isdisplayed() {
		return log_uname.isDisplayed();
	}

}
