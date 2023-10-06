package com.HnM.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.GestureUtility;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Product {

	AndroidDriver driver;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Puff-sleeved cropped top']")
	private WebElement product;
	
	@FindBy(xpath = "//android.widget.TextView[@text='XL']")
	private WebElement size;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Add']")
	private WebElement add;
	
	@FindBy(className = "android.widget.Button")
	private WebElement addToCart;

	public AndroidDriver getDriver() {
		return driver;
	}

	public WebElement getProduct() {
		return product;
	}

	public WebElement getSize() {
		return size;
	}

	public WebElement getAdd() {
		return add;
	}
	
	public Product(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void productSetup() throws InterruptedException {
	
		product.click();
		add.click();
		size.click();
		addToCart.click();
		
	}
}
