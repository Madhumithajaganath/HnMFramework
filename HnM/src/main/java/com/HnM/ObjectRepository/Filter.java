package com.HnM.ObjectRepository;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.DriverUtility;
import GenericUtilities.GestureUtility;
import io.appium.java_client.android.AndroidDriver;

public class Filter {
	
	AndroidDriver driver;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Tops & T-shirts']")
	private WebElement item;
	
	@FindBy(id = "com.hm.goe:id/filterSortIcon")
	private WebElement filter;
	
	@FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"plp_filter_item\"])[2]")
	private WebElement color;
	
	@FindBy(xpath = "(//android.widget.CheckBox[@content-desc=\"plp_filters_colour_checkbox\"])[2]")
	private WebElement clrblack;
	
	@FindBy(id = "com.hm.goe:id/applyFilters")
	private WebElement showItem;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Rib-knit top']")
	private WebElement newItem;
	
	@FindBy(id = "com.hm.goe:id/colorName")
	private WebElement newColor;

	public Filter(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}

	public AndroidDriver getDriver() {
		return driver;
	}

	public WebElement getItem() {
		return item;
	}

	public WebElement getFilter() {
		return filter;
	}

	public WebElement getColor() {
		return color;
	}

	public WebElement getClrblack() {
		return clrblack;
	}

	public WebElement getShowItem() {
		return showItem;
	}

	public WebElement getNewItem() {
		return newItem;
	}

	public WebElement getNewColor() {
		return newColor;
	}
	
	public void filterSetup(GestureUtility gutil,String clr, DriverUtility dutil) {
		
		gutil.scroll(clr);
		item.click();
		filter.click();
		color.click();
		clrblack.click();
		String eclr = clrblack.getText();
		dutil.implicitWait();
		showItem.click();
		newItem.click();
		String aclr = newColor.getText();
		
		assertEquals(eclr, aclr);
		
	}
}
