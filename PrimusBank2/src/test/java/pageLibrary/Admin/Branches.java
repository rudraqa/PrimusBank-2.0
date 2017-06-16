package pageLibrary.Admin;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Branches {
	WebDriver driver;
	ExtentTest Branches;
	public Branches(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
@FindBy(xpath = "//a[contains(@href,'admin_banker_master')]")      public WebElement Branch;
@FindBy(id = "lab19")         public WebElement BranchDetails;
@FindBy(id = "BtnNewBR")      public WebElement Newbranch;
@FindBy(id = "txtbName")      public WebElement BranchName;
@FindBy(id = "txtAdd1")       public WebElement Address1;
@FindBy(id = "Txtadd2")       public WebElement Address2;
@FindBy(id = "txtadd3")       public WebElement Address3;
@FindBy(id = "txtArea")       public WebElement Area;
@FindBy(id = "txtZip")        public WebElement Zipcode;
@FindBy(id = "lst_counrtyU")  public WebElement Country;
@FindBy(id = "lst_stateI")    public WebElement State;
@FindBy(id = "lst_cityI")     public WebElement City;
@FindBy(id = "btn_insert")    public WebElement Submit;
@FindBy(id = "Btn_Reset")     public WebElement Reset;
@FindBy(id = "Btn_cancel")    public WebElement Cancel;
@FindBy(xpath = "//a[contains(@href,'Admin_Emp_details')]") public WebElement Employee;
@FindBy(id = "lab_12")        public WebElement EmployeeDetails;
@FindBy(id = "labmain")       public WebElement EmployeeCreation;
@FindBy(id = "BtnNew")        public WebElement NewEmployee;
@FindBy(id = "lst_Branch")    public WebElement Branchdropdown;
@FindBy(xpath = "//*[@id='DG_bankdetails']/tbody") public WebElement Branchtable;
public void Branch(ExtentTest Branches)
{
	Branches.log(LogStatus.INFO, "Branches  page is Loading");
	Branch.click();
	if(BranchDetails.isDisplayed()==true)
	{
		Branches.log(LogStatus.PASS, "Branches", "Branches Details page is opened successfully");
	}
	else{
		Branches.log(LogStatus.FAIL, "Branches", "Branches Details page is Not opened successfully");
	}
}
public void NewBranch(ExtentTest Branches)
{
	Branches.log(LogStatus.INFO, "New Branch page is Loading");
	Newbranch.click();
	if(BranchName.isDisplayed()==true)
	{
		Branches.log(LogStatus.PASS, "New Branch", "New Branch Creation page is opened successfully");
	}
	else{
		Branches.log(LogStatus.FAIL, "New Branch", "New Branch Creation page is Not opened successfully");
	}
}
public void BranchName(ExtentTest Branches,String Branch_Name)
{
	Branches.log(LogStatus.INFO, "Sending New  Branch Name");
	BranchName.sendKeys(Branch_Name);
	Branches.log(LogStatus.PASS, "New Branch", "Valid Branch Name Entered");
}
public void Address1(ExtentTest Branches,String Address_1)
{
	Branches.log(LogStatus.INFO, "Sending New Branch Address 1");
	Address1.sendKeys(Address_1);
	Branches.log(LogStatus.PASS, "New Branch", "Valid Address1 Entered");
}
public void Address2(ExtentTest Branches,String Address_2)
{
	Branches.log(LogStatus.INFO, "Sending New Branch  Address 2");
	Address2.sendKeys(Address_2);
	Branches.log(LogStatus.PASS, "New Branch", "Valid Address2 Entered");
}
public void Address3(ExtentTest Branches,String Address_3)
{
	Branches.log(LogStatus.INFO, "Sending valid Data to Address 3");
	Address3.sendKeys(Address_3);
	Branches.log(LogStatus.PASS, "New Branch", "Valid Address3 Entered");
}
public void Area(ExtentTest Branches,String Area_name)
{
	Branches.log(LogStatus.INFO, "Sending New Branch Area Name");
	Area.sendKeys(Area_name);
	Branches.log(LogStatus.PASS, "New Branch", "Valid Area Entered");
}
public void Zipcode(ExtentTest Branches,String zip_code)
{
	Branches.log(LogStatus.INFO, "Sending New Branch Area Zipcode");
	Zipcode.sendKeys(zip_code);
	Branches.log(LogStatus.PASS, "New Branch", "Valid Area zipcode Entered");
}
public void SelectCountry(ExtentTest Branches,String Select_Country)
{
	Branches.log(LogStatus.INFO, "Selecting  New Branch Country ");
	Select country = new Select(Country);
	country.selectByVisibleText(Select_Country);
	Branches.log(LogStatus.PASS, "New Branch", "New Branch Country selected");
}
public void SelectState(ExtentTest Branches,String Select_State)
{
	Branches.log(LogStatus.INFO, "Selecting  New Branch State ");
	Select States = new Select(State);
	States.selectByVisibleText(Select_State);
	Branches.log(LogStatus.PASS, "New Branch", "New Branch State selected");
}
public void SelectCity(ExtentTest Branches,String Select_City)
{
	Branches.log(LogStatus.INFO, "Selecting  New Branch City ");
	Select Cities = new Select(City);
	Cities.selectByVisibleText(Select_City);
	Branches.log(LogStatus.PASS, "New Branch", "New Branch City selected");
}
public void BranchwebTable(ExtentTest Branches,String Branchid)
{
	List<WebElement> rows_table = Branchtable.findElements(By.tagName("tr"));
	int rows_count = rows_table.size();
	List<WebElement> colums_table = driver.findElements(By.xpath(".//*[@id='DG_bankdetails']/tbody/tr[1]/td"));
	int colums_count = colums_table.size();
	Branches.log(LogStatus.INFO, "Number Rows in table "+rows_count+" Columns in table "+colums_count);	 
	int colindex = -1;
	for(int i=2;i<rows_count;i++)
	{
		WebElement id = driver.findElement(By.xpath(".//*[@id='DG_bankdetails']/tbody/tr["+i+"]/td[1]"));
		String idnumber = id.getText();
		if(idnumber.equals(Branchid)==true)
		{
			colindex=i;
			Branches.log(LogStatus.PASS, "New Branch id "+Branchid+"created successfully");
			break;
		}
		else{
			Branches.log(LogStatus.FAIL, "New Branch id "+Branchid+"Not created successfully");
		}
	}
}
public void Submit(ExtentTest Branches)
{
	Branches.log(LogStatus.INFO, "Submitting New Branch Details");
	Submit.click();
	try {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().getText();
		String Success = driver.switchTo().alert().getText();
		String[] words = Success.split(" ");
		String first = "New Branch with id";
		String Second = "created Sucessfully";
		String messae1 =words[0]+" "+words[1]+" "+words[2]+" "+words[3];
		String messae2 =words[5]+" "+words[6];
		if((messae1.equalsIgnoreCase(first)) && (messae2.equalsIgnoreCase(Second)))
		{
			driver.switchTo().alert().accept();
			Branches.log(LogStatus.PASS, "New Branch", "New Branch Created Succesfully");
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		String popup = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Branches.log(LogStatus.WARNING, "New Branch",popup);
	}	
}
public void InvalidSubmit(ExtentTest Branches)
{
	Branches.log(LogStatus.INFO, "Submitting New Branch Details");
	Submit.click();
	try {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().getText();
		String Success = driver.switchTo().alert().getText();
		String[] words = Success.split(" ");
		String first = "New Branch with id";
		String Second = "created Sucessfully";
		String messae1 =words[0]+" "+words[1]+" "+words[2]+" "+words[3];
		String messae2 =words[5]+" "+words[6];
		if((messae1.equalsIgnoreCase(first)) && (messae2.equalsIgnoreCase(Second)))
		{
			driver.switchTo().alert().accept();
			Branches.log(LogStatus.FAIL, "New Branch", "New Branch Created with Invalid Data Succesfully");
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		String popup = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Branches.log(LogStatus.WARNING, "New Branch",popup);
	}	
}
public void NewBranchCreationwithvalidData(ExtentTest Branches)
{
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	try{
	 Branch(Branches);
	 NewBranch(Branches);
	 BranchName(Branches,"prasanth");
	 Address1(Branches,"ulligaddarao");
	 Address2(Branches,"gajuwakastreeet");
	 Address3(Branches,"Anakapalli");
	 Area(Branches,"hyderabad");
	 Zipcode(Branches,"12345");
	 SelectCountry(Branches,"INDIA");
	 SelectState(Branches,"Andhra Pradesh"); 
	 SelectCity(Branches,"Hyderabad");
	 Submit(Branches);
	}
	catch(Exception hai){
		hai.printStackTrace();
		Branches.log(LogStatus.FAIL, "New Branch", hai);
	}
}
public void NewBranchCreationwithInvalidData(ExtentTest Branches)
{
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	try{
	 Branch(Branches);
	 NewBranch(Branches);
	 BranchName(Branches,"Hai");
	 Address1(Branches,"hgfgjvf");
	 Thread.sleep(2000);
	 driver.switchTo().alert().accept();
	 Thread.sleep(2000);
	 driver.switchTo().alert().accept();
	 Address2(Branches,"uyyfybfhfy");
	 Address3(Branches,"uyasgdyaghd");
	 Area(Branches,"hyderabad");
	 Zipcode(Branches,"12345");
	 SelectCountry(Branches,"INDIA");
	 SelectState(Branches,"Andhra Pradesh"); 
	 SelectCity(Branches,"Hyderabad");
	 InvalidSubmit(Branches);
	}
	catch(Exception hai){
		hai.printStackTrace();
		Branches.log(LogStatus.FAIL, "New Branch", hai);
	}
}


}
