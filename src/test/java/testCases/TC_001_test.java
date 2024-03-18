package testCases;

import java.io.IOException;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import pageObjects.LoginMBPage;
import testBase.BaseClass;
import testBase.BaseTest;
import utilities.ExcelUtility;
import utilities.UtilityCustomFunctions;

public class TC_001_test extends BaseTest {
	Logger	logger = LogManager.getLogger(this.getClass());
	
	BaseClass objBC = new BaseClass();
	@BeforeTest
	public void testName() {
		test = extent.createTest("TestToCheckCall");
	}
	@Test(alwaysRun = false,enabled=false)
	public void testLogin() throws Exception {
		
//		String sCompName =  objBC.rb.getString("ComName");
//		String sUserName =  objBC.rb.getString("UserName");
//		String sPassword =  objBC.rb.getString("Password");
//		node = test.createNode("testLogin");
//		System.out.println("comname:" + sCompName + "username:" + sUserName + "Password:" + sPassword);
//		Thread.sleep(1000);
//		Adriver.findElement(AppiumBy.xpath("//android.widget.EditText[1]")).click();
//		Adriver.findElement(AppiumBy.xpath("//android.widget.EditText[1]")).sendKeys("ASHOK");
////		Adriver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")).sendKeys("ASHOK");
//		Adriver.navigate().back();
//		Thread.sleep(1000);
//		Adriver.findElement(By.xpath("//android.widget.EditText[2]")).click();
//		Thread.sleep(1000);
//		Adriver.findElement(By.xpath("//android.widget.EditText[2]")).sendKeys("rsoft");
//		Adriver.navigate().back();
//		Thread.sleep(1000);
//		Adriver.findElement(By.xpath("//android.widget.EditText[3]")).click();
//		Thread.sleep(1000);
//		Adriver.navigate().back();
//		Adriver.findElement(By.xpath("//android.widget.EditText[3]/android.widget.Button")).click();
//		Thread.sleep(1000);
//		Adriver.findElement(By.xpath("//android.widget.EditText[3]")).sendKeys("RSoft!@345");
//		Thread.sleep(1000);
//		Adriver.findElement(By.xpath("//android.widget.Button[@content-desc='Login']")).click();
//		Thread.sleep(1000);
//		Adriver.findElement(By.xpath("//android.widget.CheckBox")).click();
//		Thread.sleep(1000);
//		Adriver.findElement(AppiumBy.accessibilityId("Agree")).click();
//		Thread.sleep(1000);
		}
	@Test(priority = 2,enabled = false)
		public void testCheckIVRStatus() throws InterruptedException {
			Thread.sleep(2000);
			Adriver.findElement(AppiumBy.accessibilityId("Open navigation menu")).click();
			Thread.sleep(2000);
			Adriver.findElement(AppiumBy.accessibilityId("Settings")).click();
			Thread.sleep(2000);
			Adriver.findElement(AppiumBy.accessibilityId("IVR & Caller Identification")).click();
			Thread.sleep(3000);
		}
	@Test(priority = 1, enabled = true)
	public void testCall() throws IOException, InterruptedException {
		Thread.sleep(5000);
		String sPath="";
	
//		if(objBC.rb.getString("env").equalsIgnoreCase("test")) {
		sPath=".\\testData\\" + "DialList_Test" + ".xlsx" ;
		
		ExcelUtility xlObj = new ExcelUtility(sPath);
		logger.info("Excel file Utility instance created");
	
		int iRowCount = xlObj.getRowCount("Sheet1");
		System.out.println("Total rows: " + iRowCount);
		logger.info("Row Count is: " + iRowCount);
		int iColCount = xlObj.getCellCount("Sheet1", iRowCount);
		System.out.println("Cols: " + iColCount);
		logger.info("Col Count is: " + iColCount);
		Thread.sleep(5000);
		int iCounter = 0;
		int iPhNumberCount = Integer.parseInt(xlObj.getCellData("Sheet1", 1, 3));
		System.out.println("iPhNumberCount:"+iPhNumberCount);
		for(int i=1;i<=iPhNumberCount;i++) {
		iCounter = iCounter + 1;
		xlObj.setCellData("Sheet1", i, 0, Integer.toString(iCounter));
		String sPhoneNumber = randomeNumber();
		xlObj.setCellData("Sheet1", i, 1, sPhoneNumber);
		System.out.println("Phone number:" + sPhoneNumber);
		xlObj.setCellData("Sheet1", i, 2, "");
		Thread.sleep(1000);
		
		Adriver.findElement(AppiumBy.id("com.samsung.android.dialer:id/digits")).sendKeys(sPhoneNumber);
		UtilityCustomFunctions.logWriteConsole("Phone Number Entered in DialPad");
		Thread.sleep(3000);
		UtilityCustomFunctions.logWriteConsole("3 seconds wait");
		//Open Dialer App
		Thread.sleep(3000);
		UtilityCustomFunctions.logWriteConsole("3 seconds wait");
		
		Adriver.findElement(AppiumBy.id("com.samsung.android.dialer:id/dialButtonImage")).click();
		UtilityCustomFunctions.logWriteConsole("Dial Button Clicked: " + sPhoneNumber);
		Thread.sleep(2000);
		Thread.sleep(5000);
//		Adriver.findElement(AppiumBy.id("com.samsung.android.incallui:id/voice_disconnect_button")).click();
		UtilityCustomFunctions.logWriteConsole("5 Secs wait  before disconnect: "+sPhoneNumber);
		if(Adriver.findElement(AppiumBy.accessibilityId("End call")).isDisplayed()) {
			Adriver.findElement(AppiumBy.accessibilityId("End call")).click();
		}
		UtilityCustomFunctions.logWriteConsole(sPhoneNumber+": Disconnected");
		
		Thread.sleep(7000);
//		UtilityCustomFunctions.logWriteConsole("5 Secs wait after disconnected: "+sPhoneNumber);
//		Adriver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.samsung.android.incallui:id/circle_button'])[1]")).click();
//		UtilityCustomFunctions.logWriteConsole("circle dial button clicked to open dial pad");
		}//for loop
		
	}
	
}
