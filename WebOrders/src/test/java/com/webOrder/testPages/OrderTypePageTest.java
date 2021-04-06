package com.webOrder.testPages;

import org.testng.annotations.Test;

import com.webOrder.pages.MenuWeb;
import com.webOrder.pages.OrderTypePage;
import com.webOrders.base.BaseClass;
import com.webOrders.resources.ScreenShots;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class OrderTypePageTest extends BaseClass  {
	OrderTypePage ordertype;
	ScreenShots scr;
	MenuWeb menuweb;
  public OrderTypePageTest() throws IOException {
		super();
		ordertype = new OrderTypePage();
		scr = new ScreenShots();
		menuweb = new MenuWeb();
	}
//@Test(priority = 1)
//  public void Verify_clickOnCollections() {
//	ordertype.clickOnCollections();
//	System.out.println("Verify_clickOnCollection executed..");
//	
//  }
@Test(priority = 1)
public void verifty_clickOnDelivery() {
	ordertype.clickOnDelivery();
	ordertype.enterPostCode(prop.getProperty("Postcode"));
}

//@Test(priority = 2)
//public void radioButton_selectNo() {
//	 ordertype.selectNo();
//	 System.out.println("radioButton_selectNo executed..");
//}
@Test(priority = 2)
public void radioButton_selectYes() {
	 ordertype.selectYes();
}
@Test(priority = 3)
public void verify_clickOnCalender() {
	ordertype.clickOnCalender();
}
//@Test(priority = 4)
//public void verify_Proceed() throws IOException, InterruptedException{ 
//	
//		menuweb = ordertype.clickOnProceed();
//		 System.out.println("verify_Proceed executed..");
//		
//	}
//@Test(priority = 3)
//	public void Verify_Browse() {
//		ordertype.clickOnBrowse();
//		
//	}
  @BeforeClass()
  public void beforeClass() {
	  initlization();
	  System.out.println("Browser Opened..");
  }
  @AfterMethod()
	public void screenshots_failedtcs(ITestResult result) {
		scr.screenshots_failedtcs(result);
	
	}
//  @AfterClass
//  public void afterClass() {
//  }

}
