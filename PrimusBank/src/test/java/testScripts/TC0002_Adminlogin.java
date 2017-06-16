package testScripts;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TC0002_Adminlogin {
	WebDriver driver=new ChromeDriver();
	ExtentReports myReports = new ExtentReports("C:\\Users\\mypc\\workspace\\PrimusBank\\src\\test\\java\\TestReports\\TestReports.html",false);
	PageLibrary.Home.Navigate Navigation = new PageLibrary.Home.Navigate(driver);
	PageLibrary.Admin.AdminLogin Adminlog = new PageLibrary.Admin.AdminLogin(driver);
	@Test
	public void TC0002()
	{
		ExtentTest login = myReports.startTest("TC0002 Check Admin Login With Valid Data");
		Navigation.Homepage(login);
		Adminlog.AdminsigninwithValidData(login);
		Adminlog.Adminsignout(login);
		myReports.endTest(login);
		myReports.flush();
		driver.quit();
	}

}
