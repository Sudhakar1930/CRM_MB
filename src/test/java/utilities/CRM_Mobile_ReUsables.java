package utilities;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import testBase.BaseTest;

@SuppressWarnings("unused")
public class CRM_Mobile_ReUsables extends BaseTest{
	
	public void LoginApp(String compName, String UserName, String Password) throws InterruptedException, IOException {
		
		Set<String> contextNames = Adriver.getContextHandles();
		for (String context : contextNames) {
			UtilityCustomFunctions.logWriteConsole("flutter automation:"+context);
		}
		try {
		System.out.println("CompName:" + compName + "username:" + UserName + "Password:" + Password);
		Thread.sleep(5000);
		Adriver.findElement(AppiumBy.xpath("//android.widget.EditText[1]")).click();
		Adriver.findElement(AppiumBy.xpath("//android.widget.EditText[1]")).sendKeys(compName);
		Adriver.navigate().back();
		Thread.sleep(2000);
		Adriver.findElement(By.xpath("//android.widget.EditText[2]")).click();
		Thread.sleep(2000);
		Adriver.findElement(By.xpath("//android.widget.EditText[2]")).sendKeys(UserName);
		Adriver.navigate().back();
		Thread.sleep(2000);
		WebElement elePassword = Adriver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.EditText[3]"));
		Thread.sleep(2000);
		Adriver.navigate().back();
		WebElement eleEyeIcon = Adriver.findElement(By.xpath("//android.widget.EditText[3]/android.widget.Button"));
		Thread.sleep(2000);
		longPressAction(eleEyeIcon);
		Thread.sleep(3000);
		Adriver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.EditText[3]")).sendKeys(Password);
		Thread.sleep(2000);
		Adriver.findElement(By.xpath("//android.widget.Button[@content-desc='Login']")).click();
		Thread.sleep(2000);
		Adriver.findElement(By.xpath("//android.widget.CheckBox")).click();
		Thread.sleep(2000);
		Adriver.findElement(AppiumBy.accessibilityId("Agree")).click();
		Thread.sleep(2000);
		Set<String> aftlogincontextNames = Adriver.getContextHandles();
		for (String context : aftlogincontextNames) {
			UtilityCustomFunctions.logWriteConsole("flutter automation:"+context);
		}
		}catch(Exception e) {
			freport("Login Failed","fail",node);
			Assert.fail("Login Failed");
		}
	}
	
	public void longPressAction(WebElement ele) {
		((JavascriptExecutor)Adriver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId()));
	}
	
	public static void swipeHorizontal(AndroidDriver Adriver, double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception {
        Dimension size = Adriver.manage().window().getSize();
        int anchor = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * finalPercentage);
        new TouchAction(Adriver).press(PointOption.point(startPoint,anchor)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(endPoint, anchor)).release().perform();
    }
	
	
}
