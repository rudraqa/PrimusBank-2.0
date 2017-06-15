package com.jenkins;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class jenkintest {
	
	WebDriver driver;
  @Test
  public void Testcase1() {
	  driver.get("http://demo.guru99.com/selenium/guru99home/");  
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Demo Guru99 Page"));
  }
  @Test
  public void Testcase2() {
	  driver.get("https://www.google.co.in");  
		String title = driver.getTitle();	
		System.out.println(title);
		Assert.assertTrue(title.contains("Google"));
  }
  @Test
  public void Testcase3() {
	  driver.get("https://in.yahoo.com/");  
		String title = driver.getTitle();	
		System.out.println(title);
		Assert.assertTrue(title.contains("Yahoo"));
  }
  @Test
  public void Testcase4() {
	  driver.get("http://www.grabcad.com/");  
		String title = driver.getTitle();	
		System.out.println(title);
		Assert.assertTrue(title.contains("GrabCAD"));
  }
  @Test
  public void Testcase5() {
	  driver.get("https://www.facebook.com/");  
		String title = driver.getTitle();	
		System.out.println(title);
		Assert.assertTrue(title.contains("Facebook – log in or sign up"));
  }
  @Test
  public void Testcase6() {
	  driver.get("https://traffup.net/");  
		String title = driver.getTitle();	
		System.out.println(title);
		Assert.assertTrue(title.contains("Get Free Traffic to Your Website or Blog | Traffup"));
  }
  @Test
  public void Testcase7() {
	  driver.get("https://hitleap.com/");  
		String title = driver.getTitle();	
		System.out.println(title);
		Assert.assertTrue(title.contains("HitLeap Traffic Exchange – Get Free Website Traffic"));
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("chromedriver", "C://chromedriver.exe");
	  driver = new ChromeDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  
  }

}
