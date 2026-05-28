package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMpage<webelement> extends BasePage{
	
    WebDriverWait wait;


	public PIMpage(WebDriver driver) {
		super(driver);
		
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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
	
	
	
	@FindBy(xpath="//a[text()=\"Employee List\"]")
	WebElement employee_list;
	
	@FindBy(xpath="(//input[@placeholder=\"Type for hints...\"])[1]")
	WebElement employeename;

	@FindBy(xpath="//button[@type='submit']")
	WebElement search;

    @FindBy(xpath="//i[@class='oxd-icon bi-trash']")
	WebElement delete_btn;

   @FindBy(xpath="//button[text()=' Yes, Delete ']")
	WebElement confirm_delete;

   

	
	
	public void pim_click() {
		wait.until(
				ExpectedConditions.visibilityOf(pim)
				).click();		
	}
	
	public void add_employee(String fname,String lname)
	{
	    wait.until(ExpectedConditions.elementToBeClickable(addemployee)).click();

	    wait.until(ExpectedConditions.visibilityOf(firstname)).sendKeys(fname);

	    wait.until(ExpectedConditions.visibilityOf(lastname)).sendKeys(lname);

	    wait.until(ExpectedConditions.elementToBeClickable(save)).click();
	}
	public void employeelist() {
		
	    wait.until(ExpectedConditions.elementToBeClickable(employee_list)).click();

	}
	
	
	public void search_employee(String Ename) {
		
		
	    wait.until(ExpectedConditions.visibilityOf(employeename)).sendKeys(Ename);
	    wait.until(ExpectedConditions.elementToBeClickable(search)).click();


		
		
	}

    public void clickDelete()
    {
	    wait.until(ExpectedConditions.elementToBeClickable(delete_btn)).click();
    }

    public void confirmDelete()
    {
	    wait.until(ExpectedConditions.elementToBeClickable(confirm_delete)).click();
    }
	
	}

