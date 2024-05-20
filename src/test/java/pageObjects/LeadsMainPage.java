package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import testBase.BaseTest;

public class LeadsMainPage extends BasePage{
	BaseTest objBST = new BaseTest();
	public LeadsMainPage(AndroidDriver Adriver) {
		super(Adriver);
		// TODO Auto-generated constructor stub
	}
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Madhan Mohan')]//android.view.View[2]")
	WebElement btnEdit;
	
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Madhan Mohan')]//android.view.View[2]")
	WebElement btnLeadSMSTemplate;
	
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Madhan Mohan')]//android.view.View[3]")
	WebElement btnLeadInfo;
	
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Madhan Mohan')]//android.view.View[3]")
	WebElement btnLeadEmailTemplate;
	
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Madhan Mohan')]//android.view.View[4]")
	WebElement btnLeadDelete;
	
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Madhan Mohan')]//android.view.View[4]")
	WebElement btnLeadComments;
	
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Madhan Mohan')]//android.view.View[5]")
	WebElement btnLeadPushRecord;
	
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Madhan Mohan')]//android.view.View[5]")
	WebElement btnLeadUpdates;
	
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Madhan Mohan')]//android.view.View[6]")
	WebElement btnQuickEdit;
	
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Madhan Mohan')]//android.view.View[6]")
	WebElement btnQuickCall;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView")
	WebElement btnWhatsApp;
//	
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Madhan Mohan')]/android.view.View")
	WebElement eleFirstRow;
//	
	
//	RemoteWebElement slider = (RemoteWebElement) Adriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc,'Madhan Mohan')]/android.view.View"));
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Madhan Mohan')]/android.view.View")
	WebElement eleSlider ;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Save']")
	WebElement btnSave ;
	
	@AndroidFindBy(accessibility = "Lead Informations")
	WebElement lblLeadInfoTitle ;
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[1]")
	WebElement lnkPreviousPage ;
	
	@AndroidFindBy(xpath = "//android.widget.Button")
	WebElement btnPreviousPage ;
	
	@AndroidFindBy(xpath = "(//android.widget.Button)[1]")
	WebElement btnPrevious ;
	
	@AndroidFindBy(id = "android:id/message")
	WebElement lblCallRegisterMsg ;
	
	@AndroidFindBy(id = "android:id/button1")
	WebElement btnCallOk ;
	
	@AndroidFindBy(id = "com.samsung.android.incallui:id/name")
	WebElement lblDialledNumber ;
	
	public void scrollRight() {
		System.out.println("Within Swipe gesture");
		//fail forbtnLeadPushRecord & eleSlider for mobile: scrollGesture
//		((JavascriptExecutor)Adriver).executeScript("mobile: scrollGesture", ImmutableMap.of("elementId", ((RemoteWebElement)eleSlider).getId(),"percentage",50,"direction","left"));
		//fail for btnLeadPushRecord & btnQuickEdit for "mobile: swipeGesture
//		((JavascriptExecutor)Adriver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement)btnLeadPushRecord).getId(),"percentage",10,"direction","left"));
//		((JavascriptExecutor)Adriver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement)btnLeadPushRecord).getId(),"percentage",10,"direction","left"));
		Adriver.executeScript("gesture: swipe",Map.of("elementId",((RemoteWebElement) btnLeadPushRecord).getId(),"percentage",1,"direction","left"));
//		Adriver.executeScript("gesture: scroll",Map.of("elementId",((RemoteWebElement) eleSlider).getId(),"percentage",1,"direction","left"));
//		boolean canScrollMore;
//		do {
//		 canScrollMore = (Boolean) ((JavascriptExecutor) Adriver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//			    "left", 200, "top", 800, "width", 100, "height", 100,
//			    "direction", "left",
//			    "percent", 1.0
//			));
//		}while(canScrollMore);
//		

//		swipeGesture
// 		mobile: swipeGesture - checked
//		gesture: swipe - checked
// not working ((JavascriptExecutor)Adriver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement)btnLeadPushRecord).getId(),"percentage",1,"direction","left"));		
// not working ((JavascriptExecutor)Adriver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement)btnLeadPushRecord).getId(),"percentage",1,"direction","right"));
// not working	Adriver.executeScript("gesture: swipe",Map.of("elementId",((RemoteWebElement) btnLeadPushRecord).getId(),"percentage",50,"direction","left"));
//	Adriver.executeScript("gesture: swipe",Map.of("elementId",((RemoteWebElement) eleSlider).getId(),"percentage",10,"direction","left"));
// not working	((JavascriptExecutor)Adriver).executeScript("gesture: swipe", ImmutableMap.of("elementId", ((RemoteWebElement)btnLeadPushRecord).getId(),"percentage",1,"direction","left"));
//swipeGesture
// not working		((JavascriptExecutor)Adriver).executeScript("swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement)btnLeadPushRecord).getId(),"percentage",1,"direction","left"));
// Not working		Adriver.executeScript("mobile: swipeGesture",Map.of("elementId",((RemoteWebElement) eleSlider).getId(),"percentage",50,"direction","left"));
// not working		((JavascriptExecutor)Adriver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement)btnLeadPushRecord).getId(),"percentage",1,"direction","left"));		
// Not working		Adriver.executeScript("mobile: swipeGesture",Map.of("elementId",((RemoteWebElement) btnLeadPushRecord).getId(),"percentage",1,"direction","left"));		
	}
	
	public void scrollIntoView() {
//		WebDrive;rWait wait = new WebDriverWait(Adriver,Duration.ofSeconds(3));
////		RemoteWebElement scrollView = (RemoteWebElement) wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.ImageView")));
//		RemoteWebElement scrollView = (RemoteWebElement) wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.ImageView")));
//		Adriver.executeScript("gesture: scrollElementIntoView", Map.of("scrollableView", scrollView.getId(),
//			    "strategy", "xpath",
//			    "selector", "xpath",
//			    "percentage", 50,
//			    "direction", "left",
//			    "maxCount", 3));
		
		JavascriptExecutor js = (JavascriptExecutor) Adriver;
		Map<String, Object> params = new HashMap<>();
		params.put("elementId", ((RemoteWebElement) eleSlider).getId());
		params.put("direction", "left");
//		js.executeScript("mobile: swipeGesture", params);
		js.executeScript("gesture: swipe", params);

	}
	//********************************* get Methods **********************************************
	public String getCallMessage() {
		String sValue ="";
		try {
		sValue = lblCallRegisterMsg.getText();
		}catch(Exception e) {
			e.getCause();
		}
		return sValue;
	}
	public String getDialNumber() {
		String sValue ="";
		try {
		sValue = lblDialledNumber.getText();
		}catch(Exception e) {
			e.getCause();
		}
		return sValue;
	}
	
	
	
	//******************************** click Methods ***************************************
	public void clickButton(ExtentTest node, String sMessage, String sControlName) throws IOException, InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(Adriver,Duration.ofSeconds(25));
			switch (sControlName) {
			case "PushtoWeb":
				wait.until(ExpectedConditions.visibilityOf(btnLeadPushRecord));
				btnLeadPushRecord.click();
				objBST.freport(sMessage + "  Present","pass", node);
				break;
			case "Delete":
				wait.until(ExpectedConditions.visibilityOf(btnLeadDelete));
				objBST.freport(sMessage + "  Present","pass", node);
				btnLeadDelete.click();
				break;
			case "LeadInfo":
				wait.until(ExpectedConditions.visibilityOf(btnLeadInfo));
				objBST.freport(sMessage + "  Present","pass", node);
				btnLeadInfo.click();
				break;
			case "QuickEdit":
				wait.until(ExpectedConditions.visibilityOf(btnQuickEdit));
				objBST.freport(sMessage + "  Present","pass", node);
				btnQuickEdit.click();
				break;	
			case "Edit":
				wait.until(ExpectedConditions.visibilityOf(btnEdit));
				objBST.freport(sMessage + "  Present","pass", node);
				btnEdit.click();
				break;
			case "Save":
				wait.until(ExpectedConditions.visibilityOf(btnSave));
				objBST.freport(sMessage + "  Present","pass", node);
				btnSave.click();
				break;
			case "SMSTemplate":
				wait.until(ExpectedConditions.visibilityOf(btnLeadSMSTemplate));
				objBST.freport(sMessage + "  Present","pass", node);
				btnLeadSMSTemplate.click();
				break;
			case "EmailTemplate":
				wait.until(ExpectedConditions.visibilityOf(btnLeadEmailTemplate));
				objBST.freport(sMessage + "  Present","pass", node);
				btnLeadEmailTemplate.click();
				break;
			case "Comments":
				wait.until(ExpectedConditions.visibilityOf(btnLeadComments));
				objBST.freport(sMessage + "  Present","pass", node);
				btnLeadComments.click();
				break;
			case "Updates":
				wait.until(ExpectedConditions.visibilityOf(btnLeadUpdates));
				objBST.freport(sMessage + "  Present","pass", node);
				btnLeadUpdates.click();
				break;
			case "Previous":
				wait.until(ExpectedConditions.visibilityOf(btnPreviousPage));
				objBST.freport(sMessage + "  Present","pass", node);
				btnPreviousPage.click();
				break;	
			case "PreviousPage":
				wait.until(ExpectedConditions.visibilityOf(lnkPreviousPage));
				objBST.freport(sMessage + "  Present","pass", node);
				lnkPreviousPage.click();
				break;
			case "PreviousOne":
				wait.until(ExpectedConditions.visibilityOf(btnPreviousPage));
				objBST.freport(sMessage + "  Present","pass", node);
				btnPrevious.click();
				break;
			case "Call":
				wait.until(ExpectedConditions.visibilityOf(btnQuickCall));
				objBST.freport(sMessage + "  Present","pass", node);
				btnQuickCall.click();
				break;
			case "WhatsApp":
				wait.until(ExpectedConditions.visibilityOf(btnWhatsApp));
				objBST.freport(sMessage + "  Present","pass", node);
				btnWhatsApp.click();
				break;
				
			}
		}catch(Exception e) {
			objBST.freport(sMessage + "  Present","fail", node);
			e.getCause();
		}
	}
	
	
	public void clickCallNetworkOK(ExtentTest node,String  sMessage) throws IOException, InterruptedException {
		try{
			WebDriverWait wait = new WebDriverWait(Adriver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(btnCallOk));
			objBST.freport(sMessage + "  Present","pass", node);
			btnCallOk.click();

			}catch(Exception e) {
				objBST.freport(sMessage + "  Present","fail", node);
				e.getCause();
				
			}
	}
	
	
	public void clickPreviousPage(ExtentTest node,String  sMessage) throws IOException, InterruptedException {
		try{
			WebDriverWait wait = new WebDriverWait(Adriver,Duration.ofSeconds(25));
			wait.until(ExpectedConditions.visibilityOf(lnkPreviousPage));
			objBST.freport(sMessage + "  Present","pass", node);
			lnkPreviousPage.click();

			}catch(Exception e) {
				objBST.freport(sMessage + "  Present","fail", node);
				e.getCause();
				
			}
	}
	public void clickPreviousButton(ExtentTest node,String  sMessage) throws IOException, InterruptedException {
		try{
			WebDriverWait wait = new WebDriverWait(Adriver,Duration.ofSeconds(25));
			wait.until(ExpectedConditions.visibilityOf(btnPreviousPage));
			objBST.freport(sMessage + "  Present","pass", node);
			btnPreviousPage.click();

			}catch(Exception e) {
				objBST.freport(sMessage + "  Present","fail", node);
				e.getCause();
				
			}
	}
	
	public void clickPrevButtonOne(ExtentTest node,String  sMessage) throws IOException, InterruptedException {
		try{
			WebDriverWait wait = new WebDriverWait(Adriver,Duration.ofSeconds(25));
			wait.until(ExpectedConditions.visibilityOf(btnPrevious));
			objBST.freport(sMessage + "  Present","pass", node);
			btnPrevious.click();

			}catch(Exception e) {
				objBST.freport(sMessage + "  Present","fail", node);
				e.getCause();
				
			}
	}
	public void clickSMSTemplate(ExtentTest node,String  sMessage) throws IOException, InterruptedException {
		try{
			WebDriverWait wait = new WebDriverWait(Adriver,Duration.ofSeconds(25));
			wait.until(ExpectedConditions.visibilityOf(btnLeadSMSTemplate));
			objBST.freport(sMessage + "  Present","pass", node);
			btnLeadSMSTemplate.click();

			}catch(Exception e) {
				objBST.freport(sMessage + "  Present","fail", node);
				e.getCause();
				
			}
	}
	
	public void clickEmailTemplate(ExtentTest node,String  sMessage) throws IOException, InterruptedException {
		try{
			WebDriverWait wait = new WebDriverWait(Adriver,Duration.ofSeconds(25));
			wait.until(ExpectedConditions.visibilityOf(btnLeadEmailTemplate));
			objBST.freport(sMessage + "  Present","pass", node);
			btnLeadEmailTemplate.click();

			}catch(Exception e) {
				objBST.freport(sMessage + "  Present","fail", node);
				e.getCause();
				
			}
	}
	
	public void clickComments(ExtentTest node,String sMessage) throws IOException, InterruptedException {
		
		try{
			WebDriverWait wait = new WebDriverWait(Adriver,Duration.ofSeconds(25));
			wait.until(ExpectedConditions.visibilityOf(btnLeadComments));
			objBST.freport(sMessage + " Button Present","pass", node);
			btnLeadComments.click();

			}catch(Exception e) {
				objBST.freport(sMessage + " Icon&Button Missing","fail", node);
				e.getCause();
				
			}
	}
	public void clickSave(ExtentTest node,String sMessage) throws IOException, InterruptedException {
		
		try{
			WebDriverWait wait = new WebDriverWait(Adriver,Duration.ofSeconds(25));
			wait.until(ExpectedConditions.visibilityOf(btnSave));
			objBST.freport(sMessage + " Save Button Present","pass", node);
			btnSave.click();

			}catch(Exception e) {
				objBST.freport(sMessage + " Save Icon&Button Missing","fail", node);
				e.getCause();
				
			}
	}
	
	public void clickLeadInfo(ExtentTest node) throws InterruptedException, IOException {
		try{
			WebDriverWait wait = new WebDriverWait(Adriver,Duration.ofSeconds(25));
			wait.until(ExpectedConditions.visibilityOf(btnLeadInfo));
			objBST.freport("LeadInfo Button Present","pass", node);
			btnLeadInfo.click();

			}catch(Exception e) {
				objBST.freport("LeadInfo Icon&Button Missing","fail", node);
				e.getCause();
				
			}
		
	}
	
	 public void clickLeadEdit(ExtentTest node) throws InterruptedException, IOException {
		try{
			WebDriverWait wait = new WebDriverWait(Adriver,Duration.ofSeconds(25));
			wait.until(ExpectedConditions.visibilityOf(btnEdit));
			objBST.freport("Lead Edit Button Present","pass", node);
			btnEdit.click();

			}catch(Exception e) {
				objBST.freport("Lead Edit Icon&Button Missing","fail", node);
				e.getCause();
				
			}
		
	}
	
	 public void clickLeadDelete(ExtentTest node) throws InterruptedException, IOException {
			try{
				WebDriverWait wait = new WebDriverWait(Adriver,Duration.ofSeconds(25));
				wait.until(ExpectedConditions.visibilityOf(btnLeadDelete));
				objBST.freport("Lead Delete Button Present","pass", node);
				btnLeadDelete.click();

				}catch(Exception e) {
					objBST.freport("Lead Delete Icon&Button Missing","fail", node);
					e.getCause();
					
				}
			
		}
	 
	 public void clickLeadPushtoWeb(ExtentTest node) throws InterruptedException, IOException {
			try{
				WebDriverWait wait = new WebDriverWait(Adriver,Duration.ofSeconds(3));
				wait.until(ExpectedConditions.visibilityOf(btnLeadPushRecord));
				objBST.freport("Lead PushtoWeb Button Present","pass", node);
				btnLeadPushRecord.click();

				}catch(Exception e) {
					objBST.freport("Lead PushtoWeb Icon&Button Missing","fail", node);
					e.getCause();
					
				}
			
		}
	
	 public void clickLeadQuickEdit(ExtentTest node) throws InterruptedException, IOException {
			try{
				WebDriverWait wait = new WebDriverWait(Adriver,Duration.ofSeconds(15));
				wait.until(ExpectedConditions.visibilityOf( btnQuickEdit));
				objBST.freport("Lead QuickEdit Button Present","pass", node);
				 btnQuickEdit.click();

				}catch(Exception e) {
					objBST.freport("Lead QuickEdit Icon&Button Missing","fail", node);
					e.getCause();
					
				}
			
		}
	 
	 
	
}
