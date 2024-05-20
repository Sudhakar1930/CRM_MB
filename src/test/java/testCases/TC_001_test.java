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
import pageObjects.MainPage;
import testBase.BaseClass;
import testBase.BaseTest;
import utilities.CRM_Mobile_ReUsables;
import utilities.ExcelUtility;
import utilities.UtilityCustomFunctions;
import appium_flutter_driver.FlutterFinder;
import appium_flutter_driver.finder.FlutterElement;

public class TC_001_test extends BaseTest {
	Logger	logger = LogManager.getLogger(this.getClass());
	

	@BeforeTest
	public void testName() {
		test = extent.createTest("TestToCheckCall");
	}
	@Test(priority = 1,alwaysRun = true,enabled=true)
	public void testLogin() throws Exception {

		
		String sCompName =  rb.getString("ComName");
		String sUserName =  rb.getString("UserName");
		String sPassword =  rb.getString("Password");
		node = test.createNode("testLogin");
		System.out.println("CompName:" + sCompName + "username:" + sUserName + "Password:" + sPassword);
		CRM_Mobile_ReUsables objCRMRs = new CRM_Mobile_ReUsables();
		objCRMRs.LoginApp(sCompName,sUserName,sPassword);
		
//		Thread.sleep(5000);
//		Adriver.findElement(AppiumBy.xpath("//android.widget.EditText[1]")).click();
//		Adriver.findElement(AppiumBy.xpath("//android.widget.EditText[1]")).sendKeys("ASHOK");
////		Adriver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")).sendKeys(sCompName);
//		Adriver.navigate().back();
//		Thread.sleep(2000);
//		Adriver.findElement(By.xpath("//android.widget.EditText[2]")).click();
//		Thread.sleep(2000);
//		Adriver.findElement(By.xpath("//android.widget.EditText[2]")).sendKeys(sUserName);
//		Adriver.navigate().back();
//		Thread.sleep(2000);
//		Adriver.findElement(By.xpath("//android.widget.EditText[3]")).click();
//		Thread.sleep(2000);
//		Adriver.navigate().back();
//		Adriver.findElement(By.xpath("//android.widget.EditText[3]/android.widget.Button")).click();
//		Thread.sleep(2000);
//		Adriver.findElement(By.xpath("//android.widget.EditText[3]")).sendKeys(sPassword);
//		Thread.sleep(2000);
//		Adriver.findElement(By.xpath("//android.widget.Button[@content-desc='Login']")).click();
//		Thread.sleep(2000);
//		Adriver.findElement(By.xpath("//android.widget.CheckBox")).click();
//		Thread.sleep(2000);
//		Adriver.findElement(AppiumBy.accessibilityId("Agree")).click();
		Thread.sleep(2000);
//		Adriver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
//		Thread.sleep(5000);
//		Adriver.findElement(AppiumBy.accessibilityId("Open navigation menu")).click();
		
		
		
		}
	
	@Test(priority = 2,enabled=true)
	public void LeadNewData() throws Exception {

		MainPage objMNP = new MainPage(Adriver);
		Thread.sleep(3000);
		objMNP.clickAllMenu();
		Thread.sleep(3000);
		objMNP.NavigatetoMenu("Leads");
		objMNP.AddDatatoLeadModule("Live",1);
		
	}
	@Test(priority = 3,enabled=false)
	public void clickPermissions() throws Exception {
		 Set<String> fcontextNames = Adriver.getContextHandles();
		 System.out.println("Context Names: " +fcontextNames );
	        for (String strContextName : fcontextNames) {
	        	System.out.println("Context Name: " +strContextName );
	            if (strContextName.contains("NATIVE_APP")) {
	                Adriver.context("NATIVE_APP");
	                break;
	            }
	        }
	        
	        
		MainPage objMNP = new MainPage(Adriver);
		objMNP.clickPopupLink("AllowPic", node);
		objMNP.clickPopupLink("AllowLocation", node);
		objMNP.clickPopupLink("Allow Record Audio", node);
		objMNP.clickPopupAllow("Allow Phone Call  Logs", node);
		objMNP.clickPopupAllow("Allow Contacts", node);
		objMNP.clickPopupAllow("Allow Notifications", node);
		objMNP.clickPopupAllow("Allow Manage Calls", node);
		objMNP.clickPopupAllow("Allow Music&Audio", node);
		objMNP.clickPopupAllow("Allow photos&Video", node);
		
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
	@Test(priority = 1, enabled = false)
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
