package Main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class NewTest {
	 WebDriver driver= Utilities.Util.bringMyDriver();
	String reportFilePath = Utilities.Configproperties.readvalue("reportFilePath");
	ExtentReports myReports = new ExtentReports(reportFilePath);
	pageLibrary.Home.Navigate Navigation = new pageLibrary.Home.Navigate(driver);
	pageLibrary.Admin.AdminLogin Adminlog = new pageLibrary.Admin.AdminLogin(driver);
	pageLibrary.Admin.AdminHomepage AdminNavigate = new pageLibrary.Admin.AdminHomepage(driver);
	pageLibrary.Admin.Branches BranchCreation = new pageLibrary.Admin.Branches(driver);
	ExtentTest mytest = myReports.startTest("PrimusBank HomePage : "+Utilities.Configproperties.readvalue("browserType"));
  
  @Test
  public void PrimusBankNavigations()
	{
	ExtentTest Home = myReports.startTest("TC0001 Check Navigation of PrimusBank Homepage");
	mytest.appendChild(Home);
	Navigation.NavigationofprimusBankPage(Home);
	myReports.endTest(mytest);
	myReports.flush();
	}
  @Test
  public void AdminloginwithValidData()
  {
  	ExtentTest Admin = myReports.startTest("TC0002 Check Admin Login With Valid Data");
  	mytest.appendChild(Admin);
  	Navigation.Homepage(Admin);
      Adminlog.AdminsigninwithValidData(Admin);
      Admin.log(LogStatus.PASS, "Admin Login Success");
      myReports.endTest(mytest);
      myReports.flush();
  }
  @Test
  public void AdminNavigations()
  {
  	ExtentTest AdminHome = myReports.startTest("TC0003 Check Navigations of Admin Homepage");
  	mytest.appendChild(AdminHome);
  	Navigation.Homepage(AdminHome);
  	Adminlog.AdminValiduserName(AdminHome);
  	Adminlog.AdminValidpassword(AdminHome);
  	Adminlog.Adminsignin(AdminHome);
  	AdminNavigate.AdminHomeNavigations(AdminHome);
  	Adminlog.Adminsignout(AdminHome);
  	 myReports.endTest(mytest);
  	 myReports.flush();	
  }
  @Test
  public void AdminDirectUrlAccess()
  {
  	ExtentTest Url = myReports.startTest("TC0004 Check Direct URL Access for Admin Homepage");
  	mytest.appendChild(Url);
  	Navigation.Homepage(Url);
  	Adminlog.adminUrlaccess(Url);
  	myReports.endTest(mytest);
      myReports.flush();
  }	
  @Test
  public void NewBranch()
  {
  	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  	ExtentTest NewBranch = myReports.startTest("TC0005 Check New Branch Creation with Valid Data");
  	mytest.appendChild(NewBranch);
  	Navigation.Homepage(NewBranch);
  	Adminlog.AdminValiduserName(NewBranch);
  	Adminlog.AdminValidpassword(NewBranch);
  	Adminlog.Adminsignin(NewBranch);
  	BranchCreation.NewBranchCreationwithvalidData(NewBranch);
  	myReports.endTest(mytest);
      myReports.flush();
  	
  }
  @Test
  public void InvalidNewBranch()
  {
  	ExtentTest InvalidNewBranch = myReports.startTest("TC0006 Check New Branch Creation with InValid Data");
  	mytest.appendChild(InvalidNewBranch);
  	Navigation.Homepage(InvalidNewBranch);
  	Adminlog.AdminValiduserName(InvalidNewBranch);
  	Adminlog.AdminValidpassword(InvalidNewBranch);
  	Adminlog.Adminsignin(InvalidNewBranch);
  	BranchCreation.NewBranchCreationwithInvalidData(InvalidNewBranch);
  	myReports.endTest(mytest);
      myReports.flush();
  }
  @Test
  public void Adminlogin_InvalidData()
  {
  	ExtentTest Invalidlog = myReports.startTest("TC0007 Check Admin Login with Invalid Data");
  	mytest.appendChild(Invalidlog);
  	Navigation.Homepage(Invalidlog);
  	Adminlog.AdminsigninwithINValidData(Invalidlog);
  	myReports.endTest(mytest);
      myReports.flush();
  }
  @Test
  public void datadrivenAdminlogin()
  {
  	ExtentTest Data = myReports.startTest("TC0008 Data Driven from Excel  for Admin Login");
  	mytest.appendChild(Data);
  	Navigation.Homepage(Data);
  	Adminlog.datadrivenlogin(Data);
  	myReports.endTest(mytest);
      myReports.flush();
  }
}
