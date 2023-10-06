package Assignment;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import GenericUtilities.GestureUtility;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class InstallHnM {
	@Test
	public void Install() throws Throwable {
		
		File f = new File("C:\\Users\\HI\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		 AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(f)
		.withIPAddress("127.0.0.1").usingPort(4723)
		.withTimeout(Duration.ofSeconds(300)).build();
		 
		 service.start();
		  
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Madhumitha jaganath");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability(MobileCapabilityType.UDID, "RZ8T31JR73N");
		
		//dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\HI\\Downloads\\HM_v22.15.1.apk");
		
		dc.setCapability("appPackage", "com.hm.goe");
		dc.setCapability("appActivity", ".app.home.HomeActivity");
		
		URL u=new URL("http://localhost:4723");
		AndroidDriver driver =new AndroidDriver(u,dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		

		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India/English\"));")).click();
		driver.findElement(AppiumBy.id("android:id/button2")).click();
		driver.findElement(AppiumBy.id("com.hm.goe:id/action_search_button")).click();
		driver.findElement(AppiumBy.className("android.widget.ScrollView")).click();
		driver.findElement(AppiumBy.id("com.hm.goe:id/searchEditText")).sendKeys("tops");
		driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Puff-sleeved cropped top']")).click();
		driver.findElement(AppiumBy.accessibilityId("pdp_add_to_bag_new")).click();
		driver.findElement(AppiumBy.xpath("(//android.view.View)[6]")).click();
		driver.findElement(AppiumBy.className("android.widget.Button")).click();
		driver.findElement(AppiumBy.id("com.hm.goe:id/hm_shoppingbag_count")).click();
		driver.findElement(AppiumBy.accessibilityId("Remove")).click();
		driver.navigate().back();
		driver.navigate().back();
		driver.findElement(AppiumBy.xpath("(//android.widget.ImageButton[@package='com.hm.goe'])[1]")).click();
		driver.findElement(AppiumBy.accessibilityId("logo")).click();
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Categories you might like\"));"));
	//driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Tops & T-shirts']"));
	Thread.sleep(4000);
	String text = "Shoes";
	for(int i=0;i<4;i++) {
			WebElement el = driver.findElement(AppiumBy
			                    .androidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.hm.goe:id/title2\"))"
			                    		+ ".setAsHorizontalList().scrollIntoView("
			                            + "new UiSelector().text(\""+text+"\"));"));
			
	}
	
//	boolean canSwipeMore=false;
//	
//	do {
//		canSwipeMore=(boolean)((JavascriptExecutor)driver).executeScript("mobile:swipeGesture",ImmutableMap.of
//				("elementId",((RemoteWebElement)element).getId(),"direction","left","percentage",0.75));
//		
		
//	while(canSwipeMore);


	
}
	}