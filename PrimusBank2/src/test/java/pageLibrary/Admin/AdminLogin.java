package pageLibrary.Admin;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Utilities.Configproperties;
import Utilities.Excelreader;


public class AdminLogin {
	WebDriver driver;
	ExtentTest AdminLogin;
	pageLibrary.Home.Navigate Support = new pageLibrary.Home.Navigate(driver);
	public AdminLogin(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(id = "txtuId")                                               public WebElement AdminuserName;
	@FindBy(id = "txtPword")                                             public WebElement Adminpassword;
	@FindBy(id = "login")                                                public WebElement AccountLogin;
	@FindBy(xpath = "//a[contains(@href,'change_password')]//img[contains(@src,'images/admin_but_02')]")         public  WebElement Changepassword;
	@FindBy(xpath = "//img[contains(@src,'images/admin_but_03')]")       public WebElement AdminLogout;
	@FindBy(xpath = "//a[contains(@href,'home')]")                       public WebElement HomeButton;

	String Excelpath = Configproperties.readvalue("Excelpath");
	public void AdminValiduserName(ExtentTest AdminLogin)
	{
		AdminLogin.log(LogStatus.INFO, "Sending valid keys to Admin UserName");
		AdminuserName.clear();
		AdminuserName.sendKeys(Excelreader.getmycellvalue(Excelpath,"Admin", "UserName", 1));
		AdminLogin.log(LogStatus.PASS, "AdminValidLogin", "Admin valid UserName Entered");
	}
	public void AdminValidpassword(ExtentTest AdminLogin)
	{
		AdminLogin.log(LogStatus.INFO, "Sending valid keys to Admin password");
		Adminpassword.clear();
		Adminpassword.sendKeys(Excelreader.getmycellvalue(Excelpath,"Admin", "Password", 1));
		AdminLogin.log(LogStatus.PASS, "AdminValidLogin", "Admin valid password Entered");
	}
	public void Adminsignin(ExtentTest AdminLogin)
	{
		AdminLogin.log(LogStatus.INFO, "Signing into Admin Account");
		AccountLogin.click();
		if(Changepassword.isDisplayed())
		{
			AdminLogin.log(LogStatus.PASS, "AdminValidLogin", "Admin page Opened successfully");
		}
		else
		{//9951827875
			AdminLogin.log(LogStatus.FAIL, "AdminValidLogin", "Admin page Not Opened successfully");
		}
			
	}
	public void INvalidAdminsignin(ExtentTest AdminLogin)
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		AdminLogin.log(LogStatus.INFO, "Signing into Admin Account");
		AccountLogin.click();
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().getText();
			String Actual = driver.switchTo().alert().getText();
			String Expect = "InCorrect BankerName/Password";
			if(Actual.equalsIgnoreCase(Expect)==true){
				driver.switchTo().alert().accept();
				AdminLogin.log(LogStatus.PASS, "AdminINValidLogin", "Admin page Is Not Openeded successfully with Invalid Data");
			}
			else if(Changepassword.isDisplayed()==true){
				AdminLogin.log(LogStatus.FAIL, "AdminINValidLogin", "Admin page Is Openeded successfully with Invalid Data");
			}
			
		}
		catch (Exception e){
			e.printStackTrace();
			AdminLogin.log(LogStatus.FAIL, e);
		}
			
	}
	public void Adminsignout(ExtentTest AdminLogin)
	{
		AdminLogin.log(LogStatus.INFO, "Sign out in process");
		AdminLogout.click();
		if(HomeButton.isDisplayed())
		{
			AdminLogin.log(LogStatus.PASS, "Admin Sign out is  Success");
		}
		else
		{
			AdminLogin.log(LogStatus.FAIL, "Admin Sign out is Not Success");
		}
		
	}
	public void AdminINValiduserName(ExtentTest AdminLogin)
	{
		AdminLogin.log(LogStatus.INFO, "Sending Invalid  keys to Admin UserName");
		AdminuserName.clear();
		AdminuserName.sendKeys(Excelreader.getmycellvalue(Excelpath,"Admin", "UserName", 3));
		AdminLogin.log(LogStatus.PASS, "AdminInValidLogin", "Admin Invalid UserName Entered");
	}
	public void AdminINValidpassword(ExtentTest AdminLogin)
	{
		AdminLogin.log(LogStatus.INFO, "Sending Invalid keys to Admin password");
		Adminpassword.clear();
		Adminpassword.sendKeys(Excelreader.getmycellvalue(Excelpath,"Admin", "Password", 2));
		AdminLogin.log(LogStatus.PASS, "AdminValidLogin", "Admin Invalid password Entered");
    }
	public void AdminBlankuserName(ExtentTest AdminLogin)
	{
		AdminLogin.log(LogStatus.INFO, "Sending Blank  keys to Admin UserName");
		AdminuserName.clear();
		AdminuserName.sendKeys(Excelreader.getmycellvalue(Excelpath,"Admin", "UserName", 6));
		AdminLogin.log(LogStatus.PASS, "AdminInValidLogin", "Admin Blank UserName Entered");
	}
	public void AdminBlankpassword(ExtentTest AdminLogin)
	{
		AdminLogin.log(LogStatus.INFO, "Sending Blank keys to Admin password");
		Adminpassword.clear();
		Adminpassword.sendKeys(Excelreader.getmycellvalue(Excelpath,"Admin", "Password", 6));
		AdminLogin.log(LogStatus.PASS, "AdminValidLogin", "Admin Blank password Entered");
    }
public void AdminsigninwithValidData(ExtentTest AdminLogin)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try{
		AdminValiduserName(AdminLogin);
		AdminValidpassword(AdminLogin);
		Adminsignin(AdminLogin);
		Adminsignout(AdminLogin);
		}
		catch(Exception All){
			AdminLogin.log(LogStatus.FAIL, All);
		}	
	}
public void adminUrlaccess(ExtentTest AdminLogin)
{
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	try{
	AdminValiduserName(AdminLogin);
	AdminValidpassword(AdminLogin);
	Adminsignin(AdminLogin);
	String AdminUrl = driver.getCurrentUrl();
	Adminsignout(AdminLogin);
	driver.get(AdminUrl);
	if(Changepassword.isDisplayed()){
		//Adminsignout(AdminLogin);
		AdminLogin.log(LogStatus.FAIL, "Admin Access", "Admin Homepage is Accessed with Direct Url ");
		Utilities.Util.captureScreenshot(driver, "InvalidLogin");
		AdminLogin.log(LogStatus.INFO, "Snapshot below:", AdminLogin.addScreenCapture("C:\\Users\\mypc\\workspace\\PrimusBank\\src\\test\\java\\ScreenShots\\InvalidLogin.png"));
		
	}
	else{
		AdminLogin.log(LogStatus.PASS, "Admin Access","Admin Homepage is Not Accessed with Direct Url");
	}
	}
	catch(Exception All){
		All.printStackTrace();
		AdminLogin.log(LogStatus.FAIL, All);
	}
}
public void Adminsign_validuserName_Invalidpassword(ExtentTest AdminLogin)
{
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	AdminValiduserName(AdminLogin);
	AdminINValidpassword(AdminLogin);
	INvalidAdminsignin(AdminLogin);
}
public void Adminsign_INvaliduserName_validpassword(ExtentTest AdminLogin)
{
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	AdminINValiduserName(AdminLogin);
	AdminValidpassword(AdminLogin);
	INvalidAdminsignin(AdminLogin);	
}
public void Adminsign_INvaliduserName_Invalidpassword(ExtentTest AdminLogin)
{
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	AdminINValiduserName(AdminLogin);
	AdminINValidpassword(AdminLogin);
	INvalidAdminsignin(AdminLogin);	
}
public void Adminsign_BlankuserName_Blankpassword(ExtentTest AdminLogin)
{
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	AdminBlankuserName(AdminLogin);
	AdminBlankpassword(AdminLogin);
	INvalidAdminsignin(AdminLogin);	
	
}
public void AdminsigninwithINValidData(ExtentTest AdminLogin)
{try{
	AdminLogin.log(LogStatus.INFO, "Valid userName -----&&----- Invalid Password");
	Adminsign_validuserName_Invalidpassword(AdminLogin);
	AdminLogin.log(LogStatus.INFO, "*****************************************************************************************");
	AdminLogin.log(LogStatus.INFO, "INValid userName -----&&----- valid Password");
	Adminsign_INvaliduserName_validpassword(AdminLogin);
	AdminLogin.log(LogStatus.INFO, "*****************************************************************************************");
	AdminLogin.log(LogStatus.INFO, "INValid userName -----&&---- INvalid Password");
	Adminsign_INvaliduserName_Invalidpassword(AdminLogin);
	AdminLogin.log(LogStatus.INFO, "*****************************************************************************************");
	AdminLogin.log(LogStatus.INFO, "Blank userName -----&&----- Blank Password");
	Adminsign_BlankuserName_Blankpassword(AdminLogin);}
catch(Exception e){
	e.printStackTrace();
	AdminLogin.log(LogStatus.FAIL, e);
}
}
public void datadrivenlogin(ExtentTest AdminLogin)
{
	
	for(int i=1;i<Excelreader.getmyrowcount(Excelpath,"Admin");i++){
		try{
			String userName = "UserName :"+Excelreader.getmycellvalue(Excelpath,"Admin", "UserName", i);
			String Password = "Password : "+Excelreader.getmycellvalue(Excelpath,"Admin", "Password", i);
			String status = userName+" "+Password+" "+"Data Type :"+Excelreader.getmycellvalue(Excelpath,"Admin", "Data Type", i);
		AdminuserName.clear();
		AdminuserName.sendKeys(Excelreader.getmycellvalue(Excelpath,"Admin", "UserName", i));
		Adminpassword.clear();
		Adminpassword.sendKeys(Excelreader.getmycellvalue(Excelpath,"Admin", "Password", i));
		AccountLogin.click();
		String datatype = Excelreader.getmycellvalue(Excelpath,"Admin", "Data Type", i);
		if(datatype.equalsIgnoreCase("Valid")==true){
				WebDriverWait wait = new WebDriverWait(driver,10);
				wait.until(ExpectedConditions.visibilityOf(AdminLogout));
				AdminLogin.log(LogStatus.PASS,status);
				AdminLogout.click();}
		else if(driver.switchTo().alert().getText().equalsIgnoreCase("InCorrect BankerName/Password")==true){
			driver.switchTo().alert().accept();
			AdminLogin.log(LogStatus.PASS,status);
		}	
		}
		catch (Exception e){
			e.printStackTrace();
			AdminLogin.log(LogStatus.FAIL, e);
		}
	}
}
}
