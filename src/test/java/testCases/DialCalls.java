package testCases;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DialCalls {
	
	public static void main(String[] args) throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();

		options.setDeviceName("RZCWA1JJM5L");
		options.setPlatformVersion("14.0");
		options.setPlatformName("Android");
		options.noReset();
//		options.setCapability("app", System.getProperty("user.dir")+"\\src\\test\\resources\\" + "TestingMB.apk");
//		options.setCapability("appium:noReset", false);
//		options.setCapability("appium:appWaitForLaunch", false);
//		options.setCapability("unicodeKeyboard", true);
//		options.setCapability("resetKeyboard", true);
		options.setCapability("androidPackage", "com.samsung.android.dialer");
		options.setCapability("appActivity", "com.samsung.android.dialer.DialtactsActivity");
		options.setAutomationName("UiAutomator2");
		options.noSign();
		options.autoGrantPermissions();
//		driver = new AndroidDriver(new URL("http:///127.0.0.1:4723"),options);
//		driver = new AndroidDriver(new URL("http://0.0.0.0:4723"),options);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
//		
//		Thread.sleep(2000);
////		driver.findElement(AppiumBy.xpath("//android.widget.EditText[1]")).click();
////		driver.findElement(AppiumBy.xpath("//android.widget.EditText[1]")).sendKeys("ASHOK");
//	//	
//		logger = LogManager.getLogger(this.getClass());

	}

}
