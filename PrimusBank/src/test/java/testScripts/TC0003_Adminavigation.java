package testScripts;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TC0003_Adminavigation {
	WebDriver driver= new ChromeDriver();
	ExtentReports myReports = new ExtentReports("C:\\Users\\mypc\\workspace\\PrimusBank\\Report.html",false);
	PageLibrary.Home.Navigate Navigation = new PageLibrary.Home.Navigate(driver);
	PageLibrary.Admin.AdminLogin Adminlog = new PageLibrary.Admin.AdminLogin(driver);
	PageLibrary.Admin.AdminHomepage AdminNavigate = new PageLibrary.Admin.AdminHomepage(driver);
	@Test
public void TC0003()
{
		ExtentTest Adminavigat = myReports.startTest("TC0003 Check Navigations of Admin Homepage");
		Navigation.Homepage(Adminavigat);
		Adminlog.AdminValiduserName(Adminavigat);
		Adminlog.AdminValidpassword(Adminavigat);
		Adminlog.Adminsignin(Adminavigat);
		AdminNavigate.AdminHomeNavigations(Adminavigat);
		Adminlog.Adminsignout(Adminavigat);
		 myReports.endTest(Adminavigat);
		 myReports.flush();	
	}
}

