package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PIMpage<webelement> extends BasePage {

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
		pim.click();
		
	}
	
	public void add_employee(String fname,String lname) {
		addemployee.click();
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		save.click();

	}
	
	public void employeelist() {
		employee_list.click();
	}
	
	
	public void search_employee(String Ename) {
		
		employeename.sendKeys(Ename);
		search.click();
		
	}

    public void clickDelete()
    {
       delete_btn.click();
    }

    public void confirmDelete()
    {
        confirm_delete.click();
    }
	
	}

