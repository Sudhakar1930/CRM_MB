package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import testBase.BaseTest;
import utilities.ExcelUtility;
import utilities.UtilityCustomFunctions;

public class MainPage extends BasePage {
	public MainPage(AndroidDriver Adriver) {
		super(Adriver);
		// TODO Auto-generated constructor stub
	}

	BaseTest objBT = new BaseTest();
	
	 @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	 WebElement lnkAllowPermission;
	 
	 @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	 WebElement lnkAllow;
	
	 @AndroidFindBy(accessibility = "Open navigation menu")
	 WebElement mnuAll;
	 
	 @AndroidFindBy(accessibility = "Leads")
	 WebElement mnuItemLeads;
	 
	 @AndroidFindBy(accessibility = "Attendances")
	 WebElement mnuItemAttendances;
	 
	 @AndroidFindBy(className = "android.widget.EditText")
	 WebElement txtSearchMenus;
	 
	 @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button[2]")
	 WebElement btnAddLead;
	 
	 @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc='Select An Option'])[1]")
	 WebElement dropDownPickyOne;
	 
	 @AndroidFindBy(xpath = "//android.widget.EditText[@index=2 and @hint='Curency']")
	 WebElement txtCurrency1;
	 
	 @AndroidFindBy(accessibility = "Mr.")
	 WebElement drpDownNamePrefix;
	 
	 @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Curency')]/android.widget.EditText[2]")
	 WebElement txtName;
	 

	  
	 
	 public void setNamePrefix(String sValue) {
		 drpDownNamePrefix.click();
		 String sXpath="//android.widget.Button[@content-desc='"+ sValue +"']";
		 WebElement lstNamePrefix = Adriver.findElement(AppiumBy.xpath(sXpath));
		 lstNamePrefix.click();
		 
		 
	 }
	 public void setName(String sValue) {
		 txtName.sendKeys(sValue);
		 
	 }
	 public void setPickyOne(String sValue) {
		 dropDownPickyOne.click();
		 String sXpath="//android.widget.Button[@content-desc='"+ sValue +"']";
		 WebElement lstPickyOne = Adriver.findElement(AppiumBy.xpath(sXpath));
		 lstPickyOne.click();
	 }
	 public void setCurrency1(String sValue) throws InterruptedException {
//		 txtCurrency1.clear();
		 Thread.sleep(5000);
		 txtCurrency1.sendKeys("1");
	 }
	 
	 //ClickMethods
	 public void clickAllMenu() throws Exception {
		 mnuAll.click();
//		 UtilityCustomFunctions.doClick(Adriver, mnuAll);
	 }
	 public void NavigatetoMenu(String sValue) throws InterruptedException {
		 txtSearchMenus.clear();
		 Thread.sleep(1000);
		 txtSearchMenus.sendKeys(sValue);
		 Thread.sleep(1000);
		 txtSearchMenus.sendKeys(Keys.ENTER);
		 Thread.sleep(1000);
//		 btnAddLead.click();
//		 Thread.sleep(3000);
	 }
	 public void NavigatAllMenus(String sValue) throws InterruptedException {
		 txtSearchMenus.clear();
		 Thread.sleep(1000);
		 txtSearchMenus.sendKeys(sValue);
		 Thread.sleep(1000);
		 txtSearchMenus.sendKeys(Keys.ENTER);
		 Thread.sleep(1000);
	 }
	public void NavigatetoAttendance() throws InterruptedException {
		Thread.sleep(1000);
		 mnuItemAttendances.click();
		 Thread.sleep(1000);
	}
	
	public void NavigatetoLeads() throws InterruptedException {
		Thread.sleep(2000);
		 mnuItemLeads.click();
		 Thread.sleep(2000);
	}
	
	 public void AddDatatoLeadModule(String sEnv,int iRow) throws Exception {
		 
		 String sPath=".\\testData\\Lead_Details_"+sEnv + ".xlsx" ;
		 ExcelUtility xlObj = new ExcelUtility(sPath);
		 UtilityCustomFunctions.logWriteConsole("Excel file Utility instance created");
		
		 int iRowCount = xlObj.getRowCount("Sheet1");
		 UtilityCustomFunctions.logWriteConsole("Total rows: " + iRowCount);
			
		 int iColCount = xlObj.getCellCount("Sheet1", iRowCount);
		 UtilityCustomFunctions.logWriteConsole("Cols Count: " + iColCount);
		 
		 String sPickyOne = xlObj.getCellData("Sheet1", iRow, 0);
		 String sCurrency1 = xlObj.getCellData("Sheet1", iRow, 1);
		 String sNamePrefix=xlObj.getCellData("Sheet1", iRow, 2);
		 String sCurrency2=xlObj.getCellData("Sheet1", iRow, 3);
		 String sMobilePrefix=xlObj.getCellData("Sheet1", iRow, 4);
		 String sMobileNumber=xlObj.getCellData("Sheet1", iRow, 5);
		 String sLeadSource=xlObj.getCellData("Sheet1", iRow, 6);
		 String sLeadMedium =xlObj.getCellData("Sheet1", iRow, 7);
		 String sCustName= xlObj.getCellData("Sheet1", iRow, 8);
		 String sEmail = xlObj.getCellData("Sheet1", iRow, 9);
		 String sLeadStatus=xlObj.getCellData("Sheet1", iRow, 10);
		 String sFollowUpDate=xlObj.getCellData("Sheet1", iRow, 11);
		 String sReasonforLost=xlObj.getCellData("Sheet1", iRow, 12);
		 String sAssignedTo=xlObj.getCellData("Sheet1", iRow, 13);
		 String sSpecifyReason=xlObj.getCellData("Sheet1", iRow, 14);
		 String sCheckInStatus =xlObj.getCellData("Sheet1", iRow, 15);	
		 String sReEngageMent=xlObj.getCellData("Sheet1", iRow, 16);
		 String sCheckBox=xlObj.getCellData("Sheet1", iRow, 17);
		 String sURL=xlObj.getCellData("Sheet1", iRow, 18);
		 String sMulti=xlObj.getCellData("Sheet1", iRow, 19);
		 String sNumber=xlObj.getCellData("Sheet1", iRow, 20);
		 String sPropertyType =xlObj.getCellData("Sheet2", iRow, 0);
		 String sBudget=xlObj.getCellData("Sheet2", iRow, 1);
		 String sBHK =xlObj.getCellData("Sheet2", iRow, 2);
		 String sFacing=xlObj.getCellData("Sheet2", iRow, 3);
		 String sLocation =xlObj.getCellData("Sheet2", iRow, 4);
		 String sCountry =xlObj.getCellData("Sheet3", iRow, 0);
		 String sAddress=xlObj.getCellData("Sheet3", iRow, 1);
		 String sState =xlObj.getCellData("Sheet3", iRow, 2);
		 String sPostalCode=xlObj.getCellData("Sheet3", iRow, 3);
		 String sDescription =xlObj.getCellData("Sheet4", iRow, 0);
		 String sPhonePrefix=xlObj.getCellData("Sheet4", iRow, 1);
		 String sPhoneNumber =xlObj.getCellData("Sheet4", iRow, 2);
		 
		 setPickyOne(sPickyOne);
		 Thread.sleep(3000);
		 setCurrency1(sCurrency1);
		 setNamePrefix(sNamePrefix);
		 setName(sCustName);
		 
		 
		 
		 
		 
	 }
 
	 public void clickPopupLink(String sMessage,ExtentTest node) throws Exception {
		 System.out.println("Inside clickpopup method");
		 boolean bFlag = false;
		 try {
		 bFlag = UtilityCustomFunctions.IsElementVisible(Adriver, lnkAllowPermission);
		 if(bFlag==true) {
			 objBT.freport(sMessage + " Link Clicked", "pass", node);
			 UtilityCustomFunctions.doClick(Adriver, lnkAllowPermission);
		 }
		 }catch(Exception e) {
			 e.getCause();
		 }
	 }
	 
	 public void clickPopupAllow(String sMessage,ExtentTest node) throws Exception {
		 boolean bFlag = false;
		 try {
		 bFlag = UtilityCustomFunctions.IsElementVisible(Adriver, lnkAllow);
		 if(bFlag==true) {
			 objBT.freport(sMessage + " Link Clicked", "pass", node);
			 UtilityCustomFunctions.doClick(Adriver, lnkAllow);
		 }
		 }catch(Exception e) {
			 e.getCause();
		 }
	 }
	 
	 

}

