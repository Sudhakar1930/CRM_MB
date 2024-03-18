package testCases;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AllListPage;
import pageObjects.CallsPage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.ExcelUtility;
import utilities.UtilityCustomFunctions;

public class TC_001_ValidateCalls extends BaseClass{
	@BeforeTest()
	public void testName() {
		System.out.println("Before Test Method");
		test = extent.createTest("TC_001_ValidateCalls");
		System.out.println("Bfore test");
	}
	@Test
	public void testCallLogs() throws InterruptedException, Exception {
		node = test.createNode("CallHistoryLog");
		System.out.println("In test");
		logger.info("******starting TC_001_ValidateCalls ****");
		String sBrowserName=UtilityCustomFunctions.getBrowserName(driver);
		UtilityCustomFunctions.logWriteConsole("Browser:" + sBrowserName);
		String sPath="";
		
			if(rb.getString("env").equalsIgnoreCase("test")) {
				sPath=".\\testData\\" + "DialList" + "_Test.xlsx";
			}else {
				sPath="";
			}
			
			ExcelUtility xlObj = new ExcelUtility(sPath);
			logger.info("Excel file Utility instance created");
		
			int iRowCount = xlObj.getRowCount("Sheet1");
			System.out.println("Total rows: " + iRowCount);
			logger.info("Row Count is: " + iRowCount);
			
		
			int iColCount = xlObj.getCellCount("Sheet1", iRowCount);
			System.out.println("Cols: " + iColCount);
			logger.info("Col Count is: " + iColCount);
			
			
			
			String sAppUrl = rb.getString("appURL");
			driver.get(sAppUrl);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			String sCompName =  rb.getString("CompanyName");
			String sUserName =  rb.getString("userName1");
			String sPassword =  rb.getString("passWord1");
			
			LoginPage objLP = new LoginPage(driver);
			AllListPage objALP = new AllListPage(driver);
			CallsPage objCP = new CallsPage(driver);
			
			
			if(objLP.isLoginPageDisplayed(sAppUrl)) {
				objLP.setCompanyName(sCompName);
				objLP.setUserName(sUserName);
				objLP.setPassword(sPassword);
				objLP.clickLoginSubmit();
				logger.info("CRM Login Success with:" + sUserName);
				System.out.println("CRM Login Success with:" + sUserName);
				UtilityCustomFunctions.fSoftAssert("Login Success", "Login Success","User: " + sUserName , node);
			}
			else {
				logger.info("CRM Login failed");
				System.out.println("Login Page Not Displayed");
				UtilityCustomFunctions.fSoftAssert("Login Fail", "Login Success","User: " + sUserName , node);
				Assert.fail("Login Page not displayed");
				
			}
			Thread.sleep(2000);
			objALP.clickAllList();
			Thread.sleep(3000);
			objALP.clickModuleOnListAll(driver, "Calls");
			Thread.sleep(2000);
			
			
				boolean bFlag = false; 
				UtilityCustomFunctions.logWriteConsole("Phone Numbers Extracted...");
							
				
				
				
				for (int i = 1;i<=iRowCount ;i++) {
					
					String sSNo = xlObj.getCellData("Sheet1", i, 0);
					String sExpPhoneNumber = xlObj.getCellData("Sheet1", i, 1);
										
					objCP.setCallerNumber(sExpPhoneNumber);
					objCP.clickSearch();
					Thread.sleep(2000);
					
					String sPagination = objCP.getPagination();
					
					String[] aPageArray = sPagination.split("\\s+"); 
					System.out.println("split array 0 " + aPageArray[0]);
					System.out.println("split array 1 " + aPageArray[1]);
					System.out.println("split array 2 " + aPageArray[2]);
					System.out.println("split array 3 " + aPageArray[3]);
					System.out.println("split array 4 " + aPageArray[4]);
					Thread.sleep(5000);
					
					
					int iCallsCount = objCP.getCallsRowcount();
					Thread.sleep(2000);
					System.out.println("Calls Row Count: " + iCallsCount);
					if(Integer.parseInt(aPageArray[0])==0) {
						freport("Failed: Call not captured after call dialled -"+ sExpPhoneNumber, "fail",node);
						UtilityCustomFunctions.logWriteConsole("Failed: Call not captured after call dialled -"+ sExpPhoneNumber);
						sAssertinFn.assertEquals("Call not captured", sExpPhoneNumber+ " Call captured");
						xlObj.setCellData("Sheet1", i, 2, "Fail");
					}//if count zero pagination
					else if(Integer.parseInt(aPageArray[0])>=1) {
						List<WebElement> tRowCount = driver.findElements(By.xpath("//tbody/tr"));
						
						List<WebElement> tColCount = tRowCount.get(2).findElements(By.tagName("td"));
						String sCallSource = UtilityCustomFunctions.getText(driver, tColCount.get(1));
						String sCallerNumber = UtilityCustomFunctions.getText(driver, tColCount.get(2));
						String sCreatedTime = UtilityCustomFunctions.getText(driver, tColCount.get(3));
						String sCallDirection = UtilityCustomFunctions.getText(driver, tColCount.get(4));
						String sCallStatus = UtilityCustomFunctions.getText(driver, tColCount.get(5));
						String sAssignedTo = UtilityCustomFunctions.getText(driver, tColCount.get(7));
						
						if(sExpPhoneNumber.contentEquals(sCallerNumber)) {
							freport("Validation of Phone Log, Actual:"+sCallerNumber+" and Expected: "+sExpPhoneNumber + " Call Direction:"+sCallDirection+" Status:"+sCallStatus, "pass", node);
							xlObj.setCellData("Sheet1", i, 2, "Pass");
						}
						else {
							freport("Validation of Phone Log" + sExpPhoneNumber,"fail",node);
							xlObj.setCellData("Sheet1", i, 2, "Fail");
						}
					
					}//else if pagination count >= 1
					
					}// for Excel Table row count
					
//					SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//					Date dateTime1 = dateformat.parse(sActCallStartTime);
//					Date dateTime2 = dateformat.parse(sActCallEndTime);
//					long duration = dateTime2.getTime() - dateTime1.getTime();
//					long diffSeconds = duration / 1000 % 60;
//					if(sActPhoneNumber.trim().equalsIgnoreCase(sExpPhoneNumber)) {
//						System.out.println("Current Row Number: " + j);
//						freport("Validation of Phone Log, Actual:"+sActPhoneNumber+" and Expected:"+sExpPhoneNumber + "Time duration in Seconds:" + diffSeconds + "Call Direction:"+sActCallDirection+"Status:"+sActCallStatus, "pass", node);
//						bFlag = true;
//						break;
//					}
				}//Test Method
//				if(bFlag==false) {
//					freport("Validation of Phone Log, Expected Phone Number :"+sExpPhoneNumber + " not Captured", "fail", node);
//				}
//			}
	}//Class
