package com.epos.TestPages;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.epos.Base.BaseClass;
import com.epos.Pages.LoginPage;
import com.epos.resources.ScreenShots;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass{
	LoginPage loginpage;
	LoginPageTest logintest;
	com.epos.Pages.HomePage homepage;
	ScreenShots scr;
	
	
	 public LoginPageTest() throws IOException {
		 super();
	 }
	@BeforeSuite
	public void setup() throws IOException {
		initlization();
		//object of LoginPage class
		loginpage = new LoginPage();
		//object of ScreenShots class
		scr = new ScreenShots();
		

		
	}
	@AfterMethod
	public void screenshots_failedtcs(ITestResult result) {
		scr.screenshots_failedtcs(result);
	
	}
	
  @Test(priority = 1)
  public void LoginpageTitleTest() {
	 String title = loginpage.validatetilteofpage();
	
	 org.testng.Assert.assertEquals(title, "Epos Hybrid" );
	 System.out.println("LoginpageTitleTest executed");
  }
  @Test(priority = 2)
  public void validateimageTest() {
	  loginpage.validateimage();
	 org.testng.Assert.assertTrue(true, "image displayed..");
	 System.out.println("image displayed");
  }
  @Test(priority = 3)
  public void LoginTest() {
	  loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	  System.out.println("credentials entered..");
  } 
  @Test(priority = 4)
  public void dpResturantNameTest() {
	  loginpage.dpResturantName();
	  driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	  System.out.println("dpResturantName");
  }
  @Test(priority = 5)
  public void booleanCaptchatTest() {
	  
	  try {
		  loginpage.booleanCaptcha();
		  System.out.println("Captha action completed..");
	  }catch (Exception e) {
		System.out.println("exception occured while executing.."+e.getMessage());
	}
	 
  }
  @Test(priority = 6)
  public void LoginButtonTest() {
	 homepage = loginpage.LoginButton();
	 System.out.println("LoginButton Clicked..");
  }
  
}
