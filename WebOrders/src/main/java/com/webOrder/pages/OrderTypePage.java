package com.webOrder.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webOrders.base.BaseClass;
import com.webOrders.resources.TestUtils;

public class OrderTypePage extends BaseClass{
By collection = By.id("collection_btn");

By Delivery = By.id("delivery_btn");

By postcode = By.id("postcode");

By radio_yes= By.xpath("//*[@id=\"order_type_display\"]/div[2]/div[2]/div[2]/div[1]/div/div[2]/label[1]/span");

By radio_no =  By.id("preorder_no_id");

By Browse_Menu = By.xpath("button[@class='one']");

By Calender = By.id("datepicker-12");
By date_enabled = By.cssSelector("td[data-handler='selectDay']");
By Proceed = By.xpath("//*[@id=\"order_type_display\"]/div[2]/div[4]/div/div/button[2]");
public OrderTypePage() throws IOException {
		super();
		
		PageFactory.initElements(driver, this);
		
	}
public void clickOnCollections() {
	 driver.findElement(collection).click();
}
public void clickOnDelivery() {
	WebElement delivery =  driver.findElement(Delivery);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click()", delivery);
	
}
public void enterPostCode(String Ps) {
	driver.findElement(postcode).sendKeys(Ps);
}
public void selectYes() {
	 driver.findElement(radio_yes).click();
}
public void clickOnCalender() {
	driver.findElement(Calender).click();
	List<WebElement> list = driver.findElements(date_enabled);
	System.out.println(list.size());
	for (int i=0; i<list.size(); i++) {
		System.out.println(list.get(i).getText());
		
		for(int j=i; j<=list.size(); j++) {
			list.get(i).click();
		WebElement calender =	driver.findElement(Calender);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(calender));
			System.out.println("click");
		}	
	}
}
public void selectNo() {
	 driver.findElement(radio_no).click();
}
public void clickOnBrowse() {
	driver.findElement(Browse_Menu).click();
}
public MenuWeb clickOnProceed() throws IOException, InterruptedException {
	
	driver.findElement(Proceed).click();
	Thread.sleep(10000);
	
	driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	return new MenuWeb();
}


}
