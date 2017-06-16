package pageLibrary.Home;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.Configproperties;
import Utilities.Excelreader;

public class Navigate {
	WebDriver driver;
	ExtentTest Navig;
public Navigate(WebDriver driver)
{
	this.driver = driver;
	PageFactory.initElements(driver, this);	
}
@FindBy(xpath = "//a[contains(@href,'home')]")                    public WebElement HomeButton;
@FindBy(xpath = "//*[@id='IMG3']")                                public WebElement PersonalBankingButton;
@FindBy(xpath = "//a[contains(@href,'Corporate Banking')]")       public WebElement CorporateBankingButton;
@FindBy(xpath = "//a[contains(@href,'International Banking')]")   public WebElement InternationalBankingButton;
@FindBy(xpath = "//a[contains(@href,'aboutus')]")                 public WebElement AboutUS;
@FindBy(linkText = "Customer Service")                            public WebElement CustomerService;
@FindBy(linkText = "Internet BankingFAQ's")                       public WebElement InternetBankingFAQs;
@FindBy(linkText = "Privacy")                                     public WebElement Privacy;
@FindBy(linkText = "Terms and Conditions")                        public WebElement TermsandConditions;
@FindBy(linkText = "Disclaimer")                                  public WebElement Disclaimer;
@FindBy(linkText = "Site Map")                                    public WebElement SiteMap;
@FindBy(xpath = "//a[contains(@href,'savings_account')]")         public WebElement SavingsAccount;
@FindBy(xpath = "//a[contains(@href,'chome')]")                   public WebElement personalHome;
@FindBy(linkText = "Home")                                        public WebElement primusHome;
@FindBy(id = "personal")                                          public WebElement PersonalBanking;
String Excelpath = Configproperties.readvalue("Excelpath");
public void Homepage(ExtentTest Navig)                    
{
	Navig.log(LogStatus.INFO, "Homepage is Opening");
	driver.get(Excelreader.getmycellvalue(Excelpath,"Home", "Url", 1));
	if(driver.getTitle().equalsIgnoreCase("Primus BANK"))
	{
		Navig.log(LogStatus.PASS, "Homepage", "primus Bank Homepage is Displayed ");
	}
	else
	{
		Navig.log(LogStatus.FAIL, "Homepage", "primus Bank Homepage is Not Displayed ");
	}
}
public void PersonalBankingpage(ExtentTest Navig)	
{
	Navig.log(LogStatus.INFO, "Personal Banking Page is Opening");
	PersonalBankingButton.click();
	if(SavingsAccount.isDisplayed())
	{
		Navig.log(LogStatus.PASS, "Personal Banking", "Primus Bank PersonalBanking Page is Displayed ");
	}
	else
	{
		Navig.log(LogStatus.FAIL, "Personal Banking", "Primus Bank PersonalBanking Page is Not  Displayed ");
	}
}
public void CorporateBankingpage(ExtentTest Navig)	
{
	Navig.log(LogStatus.INFO, "Corporate Banking Page is Opening");
	CorporateBankingButton.click();
	Navig.log(LogStatus.PASS, "Corporate Banking", "Primus Bank CorporateBanking Page is Displayed ");
}
public void InternationalBanking(ExtentTest Navig)	
{
	Navig.log(LogStatus.INFO, "International Banking Page is Opening");
	InternationalBankingButton.click();
	Navig.log(LogStatus.PASS, "International Banking", "Primus Bank InternationalBanking Page is Displayed ");
}
public void AboutUS(ExtentTest Navig)	
{
	Navig.log(LogStatus.INFO, "AboutUS Page is Opening");
	AboutUS.click();
	Navig.log(LogStatus.PASS, "AboutUS Page", "Primus Bank AboutUS Page is Displayed ");
}
public void CustomerService(ExtentTest Navig)	
{
	Navig.log(LogStatus.INFO, "CustomerService Page is Opening");
	CustomerService.click();
	Navig.log(LogStatus.PASS, "CustomerService Page", "Primus Bank CustomerService Page is Displayed ");
}
public void InternetBankingFAQs(ExtentTest Navig)	
{
	Navig.log(LogStatus.INFO, "InternetBankingFAQs Page is Opening");
	InternetBankingFAQs.click();
	Navig.log(LogStatus.PASS, "InternetBankingFAQs Page", "Primus Bank InternetBankingFAQs Page is Displayed ");
}
public void Privacy(ExtentTest Navig)	
{
	Navig.log(LogStatus.INFO, "Privacy Page is Opening");
	Privacy.click();
	Navig.log(LogStatus.PASS, "Privacy Page", "Primus Bank Privacy Page is Displayed ");
}
public void TermsandConditions(ExtentTest Navig)	
{
	Navig.log(LogStatus.INFO, "TermsandConditions Page is Opening");
	TermsandConditions.click();
	Navig.log(LogStatus.PASS, "TermsandConditions Page", "Primus Bank TermsandConditions Page is Displayed ");
}
public void Disclaimer(ExtentTest Navig)	
{
	Navig.log(LogStatus.INFO, "Disclaimer Page is Opening");
	Disclaimer.click();
	Navig.log(LogStatus.PASS, "Disclaimer Page", "Primus Bank Disclaimer Page is Displayed ");
}
public void SiteMap(ExtentTest Navig)	
{
	Navig.log(LogStatus.INFO, "SiteMap Page is Opening");
	SiteMap.click();
	Navig.log(LogStatus.PASS, "SiteMap Page", "Primus Bank SiteMap Page is Displayed ");
}
public void personalHome(ExtentTest Navig)
{
	Navig.log(LogStatus.INFO, "PersonalBanking Home Page is Opening");
	personalHome.click();
	Navig.log(LogStatus.PASS, "PersonalBanking Page", "Primus Bank PersonalBanking Page is Displayed ");
}
public void primusHome(ExtentTest Navig)
{
	Navig.log(LogStatus.INFO, "primusHome Page is Opening");
	primusHome.click();
	if(PersonalBanking.isDisplayed())
	{
		Navig.log(LogStatus.PASS, "primusHome Page", "Primus Bank primusHome Page is Displayed ");
	}
	else
	{
		Navig.log(LogStatus.FAIL, "primusHome Page", "Primus Bank primusHome Page is Not Displayed ");
	}
	
}
public void NavigationofprimusBankPage(ExtentTest Navig)
{
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	try{
	Homepage(Navig);
	PersonalBankingpage(Navig);
	CorporateBankingpage(Navig);
	InternationalBanking(Navig);
	AboutUS(Navig);
	CustomerService(Navig);
	InternetBankingFAQs(Navig);
	Privacy(Navig);
	TermsandConditions(Navig);
	Disclaimer(Navig);
	SiteMap(Navig);
	personalHome(Navig);
	primusHome(Navig);
	}
	catch(Exception hello){
		hello.printStackTrace();
		Navig.log(LogStatus.FAIL,hello);
	}
	}
}


