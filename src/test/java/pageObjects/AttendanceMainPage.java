package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import testBase.BaseTest;

public class AttendanceMainPage extends BasePage{
	BaseTest objBST = new BaseTest();
	
	public AttendanceMainPage(AndroidDriver Adriver) {
		super(Adriver);
		// TODO Auto-generated constructor stub
	}
	@AndroidFindBy(xpath = "//android.view.View[@index=1]")
	WebElement lblUserName;
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]")
	WebElement lblAttendanceMainView;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Day In']")
	WebElement btnDayIn;
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource- id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]")
	WebElement lblHours;
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource- id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]")
	WebElement lblMinutes;
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource- id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]")
	WebElement lblSeconds;
	
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Break Start']")
	WebElement btnBreakStart;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Break End']")
	WebElement btnBreakEnd;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Day Out']")
	WebElement btnDayOut;
	
	@AndroidFindBy(accessibility = "Status")
	WebElement lblStatus;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Day In' and @index=4]")
	WebElement lblCurrentStatus;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Date' and @index=5]")
	WebElement lblDate;
	
	@AndroidFindBy(xpath = "//android.view.View[@index=6]")
	WebElement lblDayInbDate;
	
	@AndroidFindBy(xpath = "//android.view.View[@index=8]")
	WebElement lblTimeIn;
	
	@AndroidFindBy(xpath = "//android.view.View[@index=10]")
	WebElement lblTotalBreakTime;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='No']")
	WebElement btnClickNo;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Yes']")
	WebElement btnClickYes;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Closed']")
	WebElement lblClosed;
	
	
	//*************************** Click Methods **************************
	
	public void clickDayOutYes(ExtentTest node) throws IOException, InterruptedException {
		try{
			WebDriverWait wait = new WebDriverWait(Adriver,Duration.ofSeconds(3));
			wait.until(ExpectedConditions.visibilityOf(btnClickYes));
			objBST.freport("Confirmation Dayout Yes Button Present","pass", node);
			btnClickYes.click();

			}catch(Exception e) {
				objBST.freport("Confirmation Dayout button Yes not Present", "fail", node);
				e.getCause();
				
			}
	}
	public void clickDayOutNo(ExtentTest node) throws IOException, InterruptedException {
		try{
			WebDriverWait wait = new WebDriverWait(Adriver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(btnClickNo));
			objBST.freport("Confirmation  No Button Present","pass", node);
			btnClickNo.click();
			
			}catch(Exception e) {
				objBST.freport("Confirmation button No not Present", "fail", node);
				e.getCause();
				
			}
	}
	
	public void clickDayIn(ExtentTest node) throws IOException, InterruptedException {
		
		try{
			WebDriverWait wait = new WebDriverWait(Adriver,Duration.ofSeconds(3));
			wait.until(ExpectedConditions.visibilityOf(btnDayIn));
			objBST.freport(" DayIn Button Present","pass", node);
			btnDayIn.click();
			
			}catch(Exception e) {
				objBST.freport("Day In Not Present", "fail", node);
				e.getCause();
			}
	}
	public void clickDayOut(ExtentTest node) throws IOException, InterruptedException {
		try{
			WebDriverWait wait = new WebDriverWait(Adriver,Duration.ofSeconds(3));
			wait.until(ExpectedConditions.visibilityOf(btnDayOut));
			objBST.freport("DayOut Button Present","pass", node);
			btnDayOut.click();
			
			}catch(Exception e) {
				objBST.freport("Day Out Button Not Present", "fail", node);
				e.getCause();
			}
	}
	public void clickBreakStart(ExtentTest node) throws IOException, InterruptedException {
		try{
			WebDriverWait wait = new WebDriverWait(Adriver,Duration.ofSeconds(3));
			wait.until(ExpectedConditions.visibilityOf(btnBreakStart));
			objBST.freport(" BreakStart Button Present","pass", node);
			btnBreakStart.click();
			
			}catch(Exception e) {
				objBST.freport("Break Start Button Not Present", "fail", node);
				e.getCause();
			}
	}
	
	public void clickBreakEnd(ExtentTest node) throws IOException, InterruptedException {
		
		try{
			WebDriverWait wait = new WebDriverWait(Adriver,Duration.ofSeconds(3));
			wait.until(ExpectedConditions.visibilityOf(btnBreakEnd));
			objBST.freport(" BreakEnd Button Present","pass", node);
			btnBreakEnd.click();
			
			}catch(Exception e) {
				objBST.freport("Break End Button Not Present", "fail", node);
				e.getCause();
			}
	}
	
	//*********************************  get Methods ***********************************
	public void getAttenDanceDetails() {
		String sActCurrentStatus = lblCurrentStatus.getText();
		String sActCurrDate = lblDate.getText();
		String sActCurrentTimeIn = lblTimeIn.getText();
		System.out.println("Current Status:" + sActCurrentStatus);
		System.out.println("Current Date:" + sActCurrDate);
		System.out.println("Current Time:" + sActCurrentTimeIn);
		
	}
	
	public void fgetAttendMainText() {
		List<WebElement> lstAttendMainViews = lblAttendanceMainView.findElements(By.className("android.view.View"));
		System.out.println("List Attendance Size:" + lstAttendMainViews.size());
		for(int i = 0;i<lstAttendMainViews.size();i++) {
//			String sValue = lblAttendanceMainView.findElements(By.className("android.view.View")).get(i).getAttribute("content-desc");
			String sValue = lstAttendMainViews.get(i).getText();
			System.out.println("Index: " + i + "Value:" + sValue);
			
		}
		System.out.println("returned text: " + lblAttendanceMainView.getText());
	}
	
	//************************** Wait Methods *********************************************
	public void waitSecondsTillBreakStart(int iSeconds) {
		try{
		WebDriverWait wait = new WebDriverWait(Adriver,Duration.ofSeconds(iSeconds));
		wait.until(ExpectedConditions.visibilityOf(btnBreakStart));
		}catch(Exception e) {
			e.getCause();
		}
	}
	
	public void waitSecondsTillBreakStop(int iSeconds) {
		try{
		WebDriverWait wait = new WebDriverWait(Adriver,Duration.ofSeconds(iSeconds));
		wait.until(ExpectedConditions.visibilityOf(btnBreakEnd));
		}catch(Exception e) {
			e.getCause();
		}
	}
	
	// *************************************** IsPresent Methods *******************************
	public void IsClosedIconPresent(ExtentTest node) throws IOException, InterruptedException {
		try{
			WebDriverWait wait = new WebDriverWait(Adriver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(lblClosed));
			objBST.freport("Closed Icon Present","pass", node);
			}catch(Exception e) {
				objBST.freport("Closed Icon not Present","fail", node);
				e.getCause();
			}
		
		
	}
	
	
}
