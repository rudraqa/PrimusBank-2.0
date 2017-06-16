package testScripts;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TC0001_Navigation {
	WebDriver driver = Utilities.Util.bringMyDriver();
	ExtentReports myReports = new ExtentReports("C:\\Users\\mypc\\workspace\\PrimusBank\\Report.html");
	PageLibrary.Home.Navigate Navigation = new PageLibrary.Home.Navigate(driver);
	
	@Test
	public void TC0001()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ExtentTest Home = myReports.startTest("TC0001 Check Navigation of PrimusBank Homepage");
		Navigation.NavigationofprimusBankPage(Home);
		myReports.endTest(Home);
		myReports.flush();
	}
	
}
