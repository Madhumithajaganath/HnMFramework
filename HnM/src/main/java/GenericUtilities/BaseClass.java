package GenericUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.HnM.ObjectRepository.Cart;
import com.HnM.ObjectRepository.Filter;
import com.HnM.ObjectRepository.Inbox;
import com.HnM.ObjectRepository.Login;
import com.HnM.ObjectRepository.Magazine;
import com.HnM.ObjectRepository.Product;
import com.HnM.ObjectRepository.Search;
import com.HnM.ObjectRepository.StoreLocator;
import com.HnM.ObjectRepository.Whislist;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	
	public AndroidDriver driver;
	AppiumDriverLocalService service;
	public FileUtility fUtil = new FileUtility();
	public GestureUtility gutil;
	public DriverUtility dutil;
	public Login lp;
	public Product pp;
	public Search sp;
	public Cart cp;
	public Magazine mp;
	public Whislist wp;
	public Inbox ip;
	public Filter fp;
	public StoreLocator slp;
	
@BeforeSuite
 public void startServer() {
	File f = new File("C:\\Users\\HI\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\main.js");
	 service = new AppiumServiceBuilder().withAppiumJS(f).
			withIPAddress("127.0.0.1").usingPort(4723).
			withTimeout(Duration.ofSeconds(300)).build();
	
	service.start();
}

@BeforeMethod
public void startApp() throws Throwable {
	DesiredCapabilities dc = new DesiredCapabilities();
	
	String platform = fUtil.dataFromPropertyFile("PLATFORM_NAME");
	String device = fUtil.dataFromPropertyFile("DEVICE_NAME");
	String automation = fUtil.dataFromPropertyFile("AUTOMATION_NAME");
	String UDID = fUtil.dataFromPropertyFile("UDID");
	
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
	dc.setCapability(MobileCapabilityType.DEVICE_NAME, device);
	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, automation);
	dc.setCapability(MobileCapabilityType.UDID, UDID);
	 
	dc.setCapability("appPackage", "com.hm.goe");
	dc.setCapability("appActivity", ".app.home.HomeActivity");
	
	URL u = new URL("http://localhost:4723");
	driver = new AndroidDriver(u,dc);
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	gutil = new GestureUtility(driver);
	dutil = new DriverUtility(driver);
	lp = new Login(driver);
    pp = new Product(driver);
	sp = new Search(driver);
	cp = new Cart(driver);
	mp = new Magazine(driver);
	wp = new Whislist(driver);
	ip = new Inbox(driver);
	fp = new Filter(driver);
	slp = new StoreLocator(driver);
	
}

@AfterMethod
public void closeApp() {
	driver.quit();
}

@AfterSuite
public void endServer() {
	service.stop();
}

}
