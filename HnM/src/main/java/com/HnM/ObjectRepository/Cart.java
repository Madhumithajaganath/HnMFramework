package com.HnM.ObjectRepository;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Cart {
	
	AndroidDriver driver;
	
	@FindBy(id = "com.hm.goe:id/hm_shoppingbag_count")
	private WebElement cart;
	
	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Remove\"]")
	private WebElement remove;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Your shopping bag is empty']")
	private WebElement text;
	
	public Cart(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver, this);
	}

	public AndroidDriver getDriver() {
		return driver;
	}

	public WebElement getCart() {
		return cart;
	}

	public WebElement getRemove() {
		return remove;
	}

	public void cartSetup() throws InterruptedException {
		cart.click();
		remove.click();
		String atxt= text.getText();
		String etxt = "Your shopping bag is empty";
	
		assertEquals(atxt, etxt);
		
		System.out.println(atxt);
		
	}
}
