package com.HnM.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.GestureUtility;
import io.appium.java_client.android.AndroidDriver;

public class Search {
	
	AndroidDriver driver;
	
	@FindBy(id="com.hm.goe:id/action_search_button")
	private WebElement srcbtn;
	
	@FindBy(className ="android.widget.ScrollView")
	private WebElement scanCode;
	
	@FindBy(id = "com.hm.goe:id/searchEditText")
	private WebElement search;

	public Search(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	public AndroidDriver getDriver() {
		return driver;
	}

	public WebElement getSrcbtn() {
		return srcbtn;
	}

	public WebElement getScanCode() {
		return scanCode;
	}

	public WebElement getSearch() {
		return search;
	}
	
	public void searchSetup(GestureUtility gutil, String value) {
	srcbtn.click();
	scanCode.click();
	search.sendKeys(value);
	gutil.searchAction();
	}

}
