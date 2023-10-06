package com.HnM.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Inbox {
	
	AndroidDriver driver;

	@FindBy(xpath  = "//android.widget.TextView[@text='Inbox']")
	private WebElement inbox;
	
	@FindBy(xpath = "//android.widget.TextView[@text='No messages']")
	private WebElement message;
	
	@FindBy(xpath = "(//android.widget.ImageButton[@package='com.hm.goe'])[1]")
	private WebElement options;
	
	public Inbox(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
		
	}

	public AndroidDriver getDriver() {
		return driver;
	}

	public WebElement getInbox() {
		return inbox;
	}

	public WebElement getMessage() {
		return message;
	}
	
	public void inboxSetup() {
		options.click();
		inbox.click();
		String msg = message.getText();
		System.out.println(msg);
		
	}
}
