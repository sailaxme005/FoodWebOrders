package com.epos.Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epos.Base.BaseClass;
import com.epos.resources.TestUtils;


public class LoginPage extends BaseClass{
	@FindBy(id = "userName")
	WebElement UserName;
	@FindBy(id = "rest_resp")
	WebElement ResturantName;
	@FindBy(id = "password")
	WebElement Password;
	@FindBy(xpath = "/label[@role='presentation']")
	WebElement Captcha;
	@FindBy(xpath="/html/body/div[1]/div/div/div")
	WebElement Image;
	@FindBy(id = "forgtbtn")
	WebElement ForgotPass;
	@FindBy(xpath = "//*[@id=\"loginForm\"]/div[1]/div[8]/button")
	WebElement Login;
	// create constructor for class
	public LoginPage() throws IOException {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	public String validatetilteofpage() {
		
		return driver.getTitle();
	}
	public boolean validateimage() {
		return Image.isDisplayed();
		
	}
	public void Login(String un, String pwd) {
		UserName.sendKeys(un);
		Password.sendKeys(pwd);
		
		}
	public void dpResturantName() {
		Select dropdown = new Select(ResturantName);
		dropdown.selectByVisibleText("Tandoori");
		
	}
	
	public void booleanCaptcha() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		  wait.until(ExpectedConditions.elementToBeClickable(Captcha));
		  Captcha.click();
		  System.out.println("Captcha Selected...");
//		  driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//		  Thread.sleep(60000);
//		  driver.manage().timeouts().implicitlyWait(TestUtils.CAPTCHA_IMPLICITY_WAIT, TimeUnit.SECONDS);
//		return Captcha;
	}
	public HomePage LoginButton() {
		Login.click();
		return new HomePage();
		
	}
	

}
