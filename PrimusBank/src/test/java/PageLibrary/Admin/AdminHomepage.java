package PageLibrary.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdminHomepage {
	WebDriver driver;
	ExtentTest Adminpage;
	public AdminHomepage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath = "//a[contains(@href,'admin_banker_master')]")  public WebElement Branches;
	@FindBy(xpath = "//a[contains(@href,'Admin_Roles_details')]")  public WebElement Roles;
	@FindBy(xpath = "//a[contains(@href,'userdetails')]")          public WebElement Users;
	@FindBy(xpath = "//a[contains(@href,'Admin_Emp_details')]")    public WebElement Employees;
	@FindBy(xpath = "//a[contains(@href,'adminflow')]")            public WebElement AdminHome;
	@FindBy(xpath = "//a[contains(@href,'adminflow')]")            public WebElement AdminHome1;
	@FindBy(xpath = "//a[contains(@href,'change_password')]")      public WebElement AdminChangepassword;
	@FindBy(id = "lst_countryS")                                   public WebElement listofcountries;
	@FindBy(id = "lab_101")                                        public WebElement UserDetails;
	@FindBy(id= "Label4")                                          public WebElement RolesDetails;
	@FindBy(id = "lab_12")                                         public WebElement EmployeeDeatils;
	
public void AdminBranches(ExtentTest Adminpage)
{
	Adminpage.log(LogStatus.PASS, "Admin Branches page is opening");
	Branches.click();
	if(listofcountries.isDisplayed()){
		
		Adminpage.log(LogStatus.PASS, "Admin Branches", "Admin Branches is opened successfully");
	}
	else{
		Adminpage.log(LogStatus.FAIL, "Admin Branches", "Admin Branches is Not opened successfully");
	}
}
public void AdminRoles(ExtentTest Adminpage)
{
	Adminpage.log(LogStatus.PASS, "Admin Roles page is opening");
	Roles.click();
	if(RolesDetails.isDisplayed()){
		Adminpage.log(LogStatus.PASS, "Admin Roles", "Admin Roles Page is opened Successfully");	
	}
	else{
		Adminpage.log(LogStatus.FAIL, "Admin Roles", "Admin Roles Page is Not opened Successfully");
	}
}
public void AdminUserDetails(ExtentTest Adminpage)
{
	Adminpage.log(LogStatus.PASS, "Admin User Details page is opening");
	Users.click();
	if(UserDetails.isDisplayed()){
		Adminpage.log(LogStatus.PASS, "Admin Users", "Admin Users page is opened successfully");
	}
	else{
		Adminpage.log(LogStatus.FAIL, "Admin Users", "Admin Users page is NOt opened successfully");
	}	
}
public void AdminEmployeeDetails(ExtentTest Adminpage)
{
	Adminpage.log(LogStatus.PASS, "Admin Employee Details page is opening");
	Employees.click();
	if(EmployeeDeatils.isDisplayed()){
		Adminpage.log(LogStatus.PASS, "Admin Employees", "Admin Employees page is opened successfully");
	}
	else{
		Adminpage.log(LogStatus.FAIL, "Admin Employees", "Admin Employees page is NOt opened successfully");
	}	
}
public void AdminChangepassword(ExtentTest Adminpage)
{
	Adminpage.log(LogStatus.PASS, "Admin Password", "Admin Page Password change is under Construction");
}
public void AdminHomepage1(ExtentTest Adminpage)
{
	Adminpage.log(LogStatus.PASS ,"Admin Homepage is opening");
	AdminHome1.click();
	if(Branches.isDisplayed()){
		Adminpage.log(LogStatus.PASS, "Admin Homepage", "Admin Homepage is opened successfully");
	}
	else{
		Adminpage.log(LogStatus.FAIL, "Admin Homepage", "Admin Homepage is Not opened successfully");
	}
}
public void AdminHomeNavigations(ExtentTest Adminpage)
{
	try{
	AdminBranches(Adminpage);
	AdminRoles(Adminpage);
	AdminUserDetails(Adminpage);
	AdminEmployeeDetails(Adminpage);
	AdminChangepassword(Adminpage);
	AdminHomepage1(Adminpage);
	}
	catch(Exception AdminAll){
		AdminAll.printStackTrace();
		Adminpage.log(LogStatus.FAIL, AdminAll);
	}
	
	
}
}
