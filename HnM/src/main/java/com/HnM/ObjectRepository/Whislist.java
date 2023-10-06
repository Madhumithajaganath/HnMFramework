package com.HnM.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.GestureUtility;
import io.appium.java_client.android.AndroidDriver;

public class Whislist {
	
	AndroidDriver driver;
	
	@FindBy(xpath = "(//android.widget.ImageButton[@package='com.hm.goe'])[1]")
	private WebElement options;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Baby'] ")
	private WebElement category;
	
	@FindBy(xpath = "//android.widget.TextView[@text='3-pack cotton jersey tops']")
	private WebElement tshirt;
	
	@FindBy(id = "com.hm.goe:id/add_to_favourite_heart")
	private WebElement fav;
	
	@FindBy(id="com.hm.goe:id/action_feed_favourite")
	private WebElement whishlist;
	
	@FindBy(id = "com.hm.goe:id/articlePrice")
	private WebElement price;
	
	public Whislist(AndroidDriver driver) {
	this.driver=driver;
	PageFactory.initElements( driver,this);
	
	}

	public AndroidDriver getDriver() {
		return driver;
	}

	public WebElement getOptions() {
		return options;
	}

	public WebElement getCategory() {
		return category;
	}

	public WebElement getTshirt() {
		return tshirt;
	}

	public WebElement getFav() {
		return fav;
	}

	public WebElement getWhishlist() {
		return whishlist;
	}

	public WebElement getPrice() {
		return price;
	}
	
	public void whishlistSetup(GestureUtility gutil, String text) throws InterruptedException {
		
		options.click();
		category.click();
		Thread.sleep(3000);
		gutil.scroll(text);
		tshirt.click();
		fav.click();
		driver.navigate().back();
		whishlist.click();
		String cost = price.getText();
		System.out.println(cost);
	}
	

}
