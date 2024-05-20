package testCases;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import pageObjects.AttendanceMainPage;
import pageObjects.MainPage;
import testBase.BaseTest;
import utilities.CRM_Mobile_ReUsables;
import utilities.UtilityCustomFunctions;

public class TC_001_Attendances extends BaseTest{
	Logger	logger = LogManager.getLogger(this.getClass());
	@BeforeTest
	public void testName() {
		test = extent.createTest("TesttoCheckLogin");
	}
	@Test
	public void testAttenDance() throws Exception {
		try {  
		String sCompName = rb.getString("CompanyName");
		String sUserName = rb.getString("userName2");
		String sPassword = rb.getString("passWord2");

		System.out.println("beforepwd:"+sPassword+"afterpwd");
		
		node = test.createNode("testAttendance");
		CRM_Mobile_ReUsables objCRMRs = new CRM_Mobile_ReUsables();
		MainPage objMNP = new MainPage(Adriver);
		AttendanceMainPage objAMP = new AttendanceMainPage(Adriver); 
		objCRMRs.LoginApp(sCompName,sUserName,sPassword);
		
		UtilityCustomFunctions.logWriteConsole("Login Successfull: " + sUserName);
		Thread.sleep(3000);
		objMNP.clickAllMenu();
		Thread.sleep(3000);
		objMNP.NavigatAllMenus("Attendances");
		objMNP.NavigatetoAttendance();
		objAMP.fgetAttendMainText();
		Thread.sleep(2000);
		objAMP.clickDayIn(node);
		Thread.sleep(2000);
		objAMP.getAttenDanceDetails();
		Thread.sleep(1000);
		objAMP.clickBreakStart(node);
		objAMP.waitSecondsTillBreakStart(110);
//		TimeUnit.MINUTES.sleep(1);
//		Thread.sleep(120000);
		objAMP.clickBreakEnd(node);
		objAMP.waitSecondsTillBreakStop(110);
		objAMP.clickDayOut(node);
		Thread.sleep(5000);
		objAMP.clickDayOutNo(node);
		Thread.sleep(2000);
		objAMP.clickDayOut(node);
		Thread.sleep(2000);
		objAMP.clickDayOutYes(node);
		objAMP.IsClosedIconPresent(node);
//		UtilityCustomFunctions.logWriteConsole("Value Selected: " + sValue);
		
		}catch(Exception e) {
			freport("Attendance Functionality Failed","fail",node);
			Assert.fail("Attendance failed");
		}
		
		
	}
}
