package Utilities;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Util {
	public static WebDriver driver;
	static String eType = Configproperties.readvalue("executionType");
	static String bType = Configproperties.readvalue("browserType");
	
	public static WebDriver bringMyDriver()
	{
		if(eType.toLowerCase().equals("local"))
		{
			driver = bringMyLocalDriver();
		}
		else if(eType.toLowerCase().equals("remote"))
		{
			driver = bringMyRemoteDriver();
		}
		
		return driver;
	}
	
	public static WebDriver bringMyLocalDriver(){
		if (bType.equals("firefox") || bType.equals("FIREFOX")) {
			System.setProperty("chromedriver", "c:/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		} else if (bType.equals("chrome") || bType.equals("CHROME")) {
			System.setProperty("chromedriver", "c:/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		} else if (bType.equals("ie") || bType.equals("IE")) {
			System.setProperty("chromedriver", "c:/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			return driver;
		}
		  else if (bType.equals("opera") || bType.equals("OPERA")) {
			driver = new OperaDriver();
			driver.manage().window().maximize();
			return driver;
		}
		  else{
			return null;	
		}
	}
	public static WebDriver bringMyRemoteDriver()
	{
		DesiredCapabilities  capabilities = new DesiredCapabilities();		
        capabilities.setCapability("name", Configproperties.readvalue("ApplicationName"));
        capabilities.setCapability(CapabilityType.BROWSER_NAME, Configproperties.readvalue("browserType"));
        capabilities.setCapability(CapabilityType.VERSION, Configproperties.readvalue("BrowserVersion"));
        capabilities.setCapability(CapabilityType.PLATFORM, Configproperties.readvalue("OS"));
        capabilities.setCapability("screen-resolution", Configproperties.readvalue("ScreenResolution"));
        capabilities.setCapability("username", Configproperties.readvalue("SaucelabsUserName"));
        capabilities.setCapability("accessKey", Configproperties.readvalue("SaucelabsAccessKey"));
        // capabilities.SetCapability(CapabilityType.IsJavaScriptEnabled, true);
        try {
        	driver =  new RemoteWebDriver(new URL(Configproperties.readvalue("SaucelabsURL")), capabilities);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return driver;
	}
	public static void captureScreenshot(WebDriver driver, String screenshotName)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		try {
			File Screen =  new File("C://Users//96917466//workspace//PrimusBank2//src//test//java//ScreenShots"+screenshotName+".png");
			FileUtils.copyFile(source,Screen);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

}
