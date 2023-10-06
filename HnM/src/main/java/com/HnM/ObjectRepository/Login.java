package com.HnM.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v109.input.model.GestureSourceType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.GestureUtility;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Login {
	AndroidDriver driver;
	
	@FindBy(xpath = "//android.widget.TextView[@text='India/English']")
	private WebElement country;
	
	@FindBy(id="android:id/button2")
	private WebElement alert;
//	
//	public AndroidDriver getDriver() {
//		return driver;
//	}


	public WebElement getAlert() {
		return alert;
	}


	public Login(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver, this);
	}
	
	public void loginSetup(GestureUtility gutil, String value) {
	gutil.scroll(value);
	country.click();
	alert.click();
	}

}