package com.HnM.ObjectRepository;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.GestureUtility;
import io.appium.java_client.android.AndroidDriver;

public class StoreLocator {
	
	AndroidDriver driver;
	
	public WebElement getOptions() {
		return options;
	}

	@FindBy(xpath = "(//android.widget.ImageButton[@package='com.hm.goe'])[1]")
	private WebElement options;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Store Locator']")
	private WebElement storeLocator;
	
	@FindBy(id="com.hm.goe:id/search_src_text")
	private WebElement locsearch;
	
	@FindBy(xpath  = "//android.widget.TextView[@resource-id='com.hm.goe:id/store_list_store_name']")
	private List<WebElement> stores;
	
	@FindBy(id = "com.hm.goe:id/storeLocatorActionButton")
	private WebElement loc;
	
	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
	private WebElement permission;
	
	public StoreLocator(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver, this);
	}

	public AndroidDriver getDriver() {
		return driver;
	}

	public WebElement getStoreLocator() {
		return storeLocator;
	}

	public WebElement getLocsearch() {
		return locsearch;
	}
	
	public WebElement getLoc() {
		return loc;
	}

	public List<WebElement> getStores() {
		return stores;
	}
	
	public void storeLocatorSetup(GestureUtility gutil) throws InterruptedException {
		options.click();
		storeLocator.click();
		locsearch.sendKeys("bangalore");
		//Thread.sleep(3000);
		loc.click();
		permission.click();
		//gutil.searchAction();
		int count = stores.size();
		System.out.println(count);
		for(int i=0;i<count;i++) {
			String txt = stores.get(i).getText();
			System.out.println(txt);
			
		}
		
		
	}
}
