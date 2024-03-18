package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.UtilityCustomFunctions;

import io.appium.java_client.android.AndroidDriver;
import testBase.BaseTest;

public class LoginMBPage extends BaseTest{
	AndroidDriver driver;
	public LoginMBPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	Logger	logger = LogManager.getLogger(this.getClass());
	
	@FindBy(xpath="//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")
	WebElement txtCompanyName;
	
	@FindBy(xpath="//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")
	WebElement txtUserId;
	
	@FindBy(xpath="android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[3]")
	WebElement txtPassword;
	
	@FindBy(xpath="//android.widget.Button[@content-desc=\"Login\"]")
	WebElement btnLogin;
	
	public void fLoginApp(String sCompName,String sUserName, String sPassword) throws Exception {
		System.out.println(sCompName);
		System.out.println(sUserName);
		System.out.println(sPassword);
		Thread.sleep(2000);
		txtUserId.sendKeys(sUserName);
		Thread.sleep(2000);
		txtCompanyName.sendKeys(sCompName);
		Thread.sleep(2000);
//		UtilityCustomFunctions.sendKeys(driver, txtCompanyName,sCompName );
//		UtilityCustomFunctions.sendKeys(driver, txtUserId,sUserName );
//		UtilityCustomFunctions.sendKeys(driver, txtPassword,sPassword );
//		UtilityCustomFunctions.doClick(driver, btnLogin);
	}
	
	
}
