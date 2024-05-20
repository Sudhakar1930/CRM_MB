package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AttendanceMainPage;
import pageObjects.LeadsMainPage;
import pageObjects.MainPage;
import testBase.BaseTest;
import utilities.CRM_Mobile_ReUsables;
import utilities.UtilityCustomFunctions;

public class TC_002_LeadsClicks extends BaseTest{
	Logger	logger = LogManager.getLogger(this.getClass());
	@BeforeTest
	public void testName() {
		test = extent.createTest("TesttoCheckLeadsButtons");
	}
	@Test
	public void testLeadsClicks() throws Exception {
		try {  
			String sCompName = rb.getString("CompanyName");
			String sUserName = rb.getString("userName2");
			String sPassword = rb.getString("passWord2");
	
			System.out.println("beforepwd:"+sPassword+"afterpwd");
			
			node = test.createNode("testAttendance");
			System.out.println("After Node");
			CRM_Mobile_ReUsables objCRMRs = new CRM_Mobile_ReUsables();
			
			System.out.println("After CrM reusables isntance");
			MainPage objMNP = new MainPage(Adriver);
			System.out.println("After Main page instance");
			LeadsMainPage objLMP =new LeadsMainPage(Adriver);
			System.out.println("After leads main page");
			AttendanceMainPage objAMP = new AttendanceMainPage(Adriver); 
			System.out.println("After attendance ma in page");
			System.out.println("Before Login");
			objCRMRs.LoginApp(sCompName,sUserName,sPassword);
			System.out.println("After Login");
			UtilityCustomFunctions.logWriteConsole("Login Successfull: " + sUserName);
			Thread.sleep(3000);
			objMNP.clickAllMenu();
			Thread.sleep(3000);
			objMNP.NavigatAllMenus("Leads");
			Thread.sleep(1000);
			objMNP.NavigatetoLeads();
			Thread.sleep(15000);
			
			objLMP.clickButton(node, "Lead Edit Click", "Edit");
			objLMP.clickButton(node, "Lead Edit Save","Save");
			
			objLMP.clickButton(node, "Lead Information Button Click", "LeadInfo");
			objLMP.clickButton(node, "Lead Information Back","PreviousPage");
			
			objLMP.clickButton(node, "Lead Delete Button Click", "Delete");
			objAMP.clickDayOutNo(node);
			
			objLMP.clickButton(node, "Lead PushtoWeb Button Click", "PushtoWeb");
			
			objLMP.clickButton(node, "Lead Quick Edit Click", "QuickEdit");
			objLMP.clickButton(node, "Lead Quick Edit Save Button Click", "Save");
			Thread.sleep(15000);
			
			objLMP.scrollRight();
			
			Thread.sleep(10000);
			objLMP.clickButton(node, "Lead SMS Template Button Click", "SMSTemplate");
			objLMP.clickButton(node, "Lead SMS Template Previous Button", "Previous");
			
			objLMP.clickButton(node, "Lead Email Template Button Click", "EmailTemplate");
			objLMP.clickButton(node, "Lead Email Template Previous Button", "Previous");
			
			objLMP.clickButton(node, "Lead Comments Button Click", "Comments");
			objLMP.clickButton(node, "Lead Comments Previous Button", "PreviousOne");
			
			objLMP.clickButton(node, "Lead Update Button Click", "Updates");
			objLMP.clickButton(node, "Lead Updates Previous Button", "Previous");
			
			objLMP.clickButton(node, "Lead Calls Button Click", "Call");
			String sActCallPageMessage = objLMP.getCallMessage();
			String sExpCallPageMessage = "Not registered on network";
			fSoftAssert(sActCallPageMessage, sExpCallPageMessage, "Call Register Message", node);
			objLMP.clickCallNetworkOK(node, "OK Click on Call Register Message");
//			String sActDialNumber= objLMP.getDialNumber();
//			String sExpDialNumber="+917708674417";
//			fSoftAssert(sActDialNumber, sExpDialNumber, "Call Dialled Number", node);
			
			objLMP.clickButton(node, "Lead WhatsApp Click", "WhatsApp");
			objLMP.clickButton(node, "Lead WhatsApp Previous Button", "Previous");

			
		}catch(Exception e) {
			e.getCause();
		}//Try catch
}//Test
}//class
