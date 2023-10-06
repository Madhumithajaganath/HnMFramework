package com.HnM.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.GestureUtility;
import io.appium.java_client.android.AndroidDriver;

public class Magazine {
	
	AndroidDriver driver;
	
	@FindBy(id = "com.hm.goe:id/text_underline")
	private WebElement readMagzine;
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Read the story\"]")
	private WebElement readStory;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Introducing Rabanne H&M']")
	private WebElement heading;
	
	public AndroidDriver getDriver() {
		return driver;
	}

	public WebElement getReadMagzine() {
		return readMagzine;
	}

	public WebElement getReadStory() {
		return readStory;
	}

	public WebElement getHeading() {
		return heading;
	}
	
	public Magazine(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}


	public void magazineSetup(GestureUtility gutil, String text) {
		gutil.scroll(text);
		readMagzine.click();
		readStory.click();
		String headings = heading.getText();
		System.out.println(headings);
		
	}
	

}
