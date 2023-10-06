package GenericUtilities;

import java.security.PublicKey;
import java.time.Duration;
import java.util.Set;

import io.appium.java_client.android.AndroidDriver;

public class DriverUtility {
	
	AndroidDriver driver;
	
	public DriverUtility(AndroidDriver driver) {
		 driver=this.driver;
		 
		 
	
	}
	public void installApp() {
		driver.installApp(".apk file path");
		driver.isAppInstalled("package name");
		
	}
	
	public void unInstall() {
		driver.removeApp("package name");
		
	}
	
	public void hideKeyboard() {
		driver.hideKeyboard();
		
	}
	
	public void openNotification() {
		driver.openNotifications();
		
	}
	
	public void deviceLocked() {
		driver.isDeviceLocked();
		
	}

	public void appState() {
		driver.queryAppState("package name");
		
	}
	
	public void activateApp() {
		driver.activateApp("pacakge name");
		
	}
	
	public void appInBackground() {
		driver.runAppInBackground(Duration.ofSeconds(20));
	
	}
	
	public void context() {
		Set<String> ch = driver.getContextHandles();
		int count=ch.size();
		System.out.println(count);
		for (String allch : ch) {
			System.out.println(allch);	
		}
		
	}
	
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
}
