package testBase;
import utilities.ExtentReportManager;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import io.appium.java_client.service.local.AppiumDriverLocalService;

import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import utilities.ExtentReportManager;
public class BaseTest extends ExtentReportManager {
	public AndroidDriver Adriver;
//	public ResourceBundle rb;
	public static SoftAssert sAssertinFn;
	protected static File file;
	public AppiumDriverLocalService service;
	public AppiumServiceBuilder builder;
	
	Logger logger = LogManager.getLogger(this.getClass());
@BeforeClass
public void configureAppium() throws MalformedURLException, InterruptedException {
		builder = new AppiumServiceBuilder();
		builder.withAppiumJS(new File("C:\\Users\\sudha\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
			.withIPAddress("127.0.0.1")
			.usingPort(4723)
			.withTimeout(Duration.ofSeconds(20)).build().start();
		service = AppiumDriverLocalService.buildService(builder);
		service.start();
		System.out.println("Appium Url:" + service.getUrl());
		System.out.println("Is Server Running:" + service.isRunning());
		Thread.sleep(3000);
//		rb = ResourceBundle.getBundle("config");//Read config.properties.
		sAssertinFn = new SoftAssert();
	UiAutomator2Options options = new UiAutomator2Options();

	options.setDeviceName("RZCWA1JJM5L");
	options.setPlatformVersion("14.0");
	options.setPlatformName("Android");
	options.noReset();
//	options.setApp(System.getProperty("user.dir")+"\\src\\test\\resources\\" + "TestingMB.apk");
//	options.setCapability("app", System.getProperty("user.dir")+"\\src\\test\\resources\\" + "TestingMB.apk");
	options.setCapability("appium:noReset", false);
	options.setCapability("appium:appWaitForLaunch", false);
//	options.setCapability("appPackage","com.rsoft.salezrobot");
//	options.setCapability("appActivity","com.rsoft.salezrobot.MainActivity");
//	options.setCapability("unicodeKeyboard", true);
//	options.setCapability("resetKeyboard", true);
	options.setCapability("appPackage", "com.samsung.android.dialer");
	options.setCapability("appActivity", "com.samsung.android.dialer.DialtactsActivity");
	options.setAutomationName("UiAutomator2");
	options.noSign();
//	options.autoGrantPermissions();
	
//	Adriver = new AndroidDriver(new URL("http:///127.0.0.1:4723"),options);
	Adriver = new AndroidDriver(new URL("http://0.0.0.0:4723"),options);
	Adriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	
	Thread.sleep(2000);
//	Adriver.findElement(AppiumBy.xpath("//android.widget.EditText[1]")).click();
//	Adriver.findElement(AppiumBy.xpath("//android.widget.EditText[1]")).sendKeys("ASHOK");
//	
	logger = LogManager.getLogger(this.getClass());
 }
@AfterClass
public void tearDown() {
//	Adriver.quit();
	service.stop();
}
 public void testname(String testname, String name) {
		test = extent.createTest(testname);
		node = test.createNode(name);
		extent.attachReporter(sparkReporter);
	}
 

	
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = "97123"+RandomStringUtils.randomNumeric(5);
		return (generatedString2);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+"@"+num);
	}
	
	
	
	
	public void freport(String dec, String status,ExtentTest node) throws IOException, InterruptedException {
		Media img = null;
		String filepath = "";
		
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		System.err.println(number);
		try {
		String date = new SimpleDateFormat("dd-MMM-yy").format(new Date());
		String date1 = new SimpleDateFormat("HH.mm").format(new Date());
		filepath= "./reports/Screenshots/"+date+"/"+ date1 +"_"+ number + ".jpg";
		Thread.sleep(1000);		
		file = new File(filepath);
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) Adriver;
		FileUtils.copyFile(takesScreenshot.getScreenshotAs(OutputType.FILE),
					file);
			
//		img = MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"/reports/Screenshots/"+date+"/"+date1+"_"+number+".jpg").build();
		img = MediaEntityBuilder.createScreenCaptureFromPath("./../Screenshots/"+date+"/"+date1+"_"+number+".jpg").build();
		
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if(status.equalsIgnoreCase("pass")) {
			System.err.println("Before node Pass");
			node.pass(dec, img);
			System.out.println(dec + " : " + "pass");

		}else if (status.equalsIgnoreCase("fail")) {
			System.err.println("Before node Fail");
			node.fail(dec, img);
			System.err.println(dec + " : After node Fail");
		}
		}

// public void tearDown() {
//	 Adriver.quit();
//     service.stop();
// }
}
