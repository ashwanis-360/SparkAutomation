package ScriptHelper;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import Driver.DriverHelper;
import Driver.XMLReader;

import Reporter.ExtentTestManager;



public class ModHelper extends DriverHelper{
	
	
	
	WebElement el;
	XMLReader xml=new XMLReader("src\\Locators\\SiebelOrder.xml");
	XMLReader xml2= new XMLReader("src\\Locators\\VLV.xml");
	public ModHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}

	

		public void ModTechforcommanproduct(Object[] Inputdata) throws Exception
		{System.out.println("middle applet start");
		Waitforvisibilityofelement(xml2.getlocator("//locators/SupportStarDate"));
		WaitforElementtobeclickable(xml2.getlocator("//locators/SupportStarDate"));
		Clear(getwebelement(xml2.getlocator("//locators/SupportStarDate")));
		
		//getwebelement(xml2.getlocator("//locators/SupportStarDate")).clear();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Date");
		Clickon(getwebelement(xml2.getlocator("//locators/SupportStarDate")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter  SupportStarDate");
		SendKeys(getwebelement(xml2.getlocator("//locators/SupportStarDate")),Inputdata[78].toString());
		
		
		WaitforElementtobeclickable(xml2.getlocator("//locators/SupprtEndDate"));
		Clear(getwebelement(xml2.getlocator("//locators/SupprtEndDate")));
		
		//getwebelement(xml2.getlocator("//locators/SupprtEndDate")).clear();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Date");
		Clickon(getwebelement(xml2.getlocator("//locators/SupprtEndDate")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter  SupprtEndDate");
		System.out.println("the End date value is"+Inputdata[79].toString());
		
		SendKeys(getwebelement(xml2.getlocator("//locators/SupprtEndDate")),Inputdata[79].toString());
		
		
		
		
		Clickon(getwebelement(xml2.getlocator("//locators/SaveButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on BCN Recurring Charge MRC Search");
		Thread.sleep(10000);
		
		System.out.println("middle applet end");
				
		}
		public void ModTech(Object[] Inputdata) throws Exception
		{
			switch(Inputdata[8].toString())
			{
			case "IP Guardian": {

				javascriptexecutor(getwebelement(xml.getlocator("//locators/IPGuardianText")));
				WaitforElementtobeclickable((xml.getlocator("//locators/AlertingNotification")));
				getwebelement(xml.getlocator("//locators/AlertingNotification")).clear();
				SendKeys(getwebelement(xml.getlocator("//locators/AlertingNotification")), Inputdata[5].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter AlertingNotification");

//				getwebelement(xml.getlocator("//locators/Automigration")).clear();
//				SendKeys(getwebelement(xml.getlocator("//locators/Automigration")),Inputdata[28].toString());
//				ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter Automigration");
//				Thread.sleep(2000);
				// SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Automigration")),
				// Keys.TAB);

				getwebelement(xml.getlocator("//locators/Customerdnsresolve")).clear();
				
				SendKeys(getwebelement(xml.getlocator("//locators/Customerdnsresolve")), Inputdata[6].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter Customer dns resolve");

//				getwebelement(xml.getlocator("//locators/IpguardianVariant")).clear();
//				SendKeys(getwebelement(xml.getlocator("//locators/IpguardianVariant")), Inputdata[30].toString());
//				ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter IP guardiant variant");

//				getwebelement(xml.getlocator("//locators/Colttechnicaltestcalls")).clear();
//				SendKeys(getwebelement(xml.getlocator("//locators/Colttechnicaltestcalls")), Inputdata[31].toString());
//				ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter Enter Colt technical cells");
//				Thread.sleep(2000);

				getwebelement(xml.getlocator("//locators/servicebandwidth")).clear();
				SendKeys(getwebelement(xml.getlocator("//locators/servicebandwidth")), Inputdata[7].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter service bandwidth");

				getwebelement(xml.getlocator("//locators/Testwindowipaccess")).clear();
				SendKeys(getwebelement(xml.getlocator("//locators/Testwindowipaccess")), Inputdata[8].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter Test Window");

				
				WaitforElementtobeclickable(xml.getlocator("//locators/IpGurdianSave"));
				Clickon(getwebelement(xml.getlocator("//locators/IpGurdianSave")));
				waitforPagetobeenable();
				Thread.sleep(8000);

//				Moveon(getwebelement(xml.getlocator("//locators/CircuitipaddressClick")));
//				Thread.sleep(3000);
//				Clickon(getwebelement(xml.getlocator("//locators/CircuitipaddressClick")));
				
				
//				try {
//					waitandForElementDisplay("//locators/Enablefeature", 15);
//					Clickon(getwebelement(xml.getlocator("//locators/Enablefeature")));
//					System.out.println("Circuit ip address field clickon");
//				} catch (Exception e) {
//					try {
						//safeJavaScriptClick(getwebelement(xml.getlocator("//locators/Enablefeature")));
//						System.out.println("Circuit ip address field javascript");
//					} catch (Exception e1) {
	//
//						e1.printStackTrace();
//					}
//				}
//				Moveon(getwebelement(xml.getlocator("//locators/Enablefeature")));
//				System.out.println("move on");
//				WaitforElementtobeclickable("//locators/Enablefeature");
//				Clickon(getwebelement(xml.getlocator("//locators/Enablefeature")));
//				System.out.println("java script");
				WaitforElementtobeclickable(xml.getlocator("//locators/Clicktoshowfullinfomiddle"));
				Clickon(getwebelement(xml.getlocator("//locators/Clicktoshowfullinfomiddle")));
				Thread.sleep(3000);
				
				
				Clickon(getwebelement(xml.getlocator("//locators/CircuitIPAddressInputInnerField")));
				getwebelement(xml.getlocator("//locators/CircuitIPAddressInputInnerField")).clear();
				SendKeys(getwebelement(xml.getlocator("//locators/CircuitIPAddressInputInnerField")),Inputdata[9].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter value in circuit ip address");

				getwebelement(xml.getlocator("//locators/IpRange")).clear();
				SendKeys(getwebelement(xml.getlocator("//locators/IpRange")), Inputdata[10].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter value in IP Range");

				WaitforElementtobeclickable(xml.getlocator("//locators/CrossButtonGurdian"));
				Clickon(getwebelement(xml.getlocator("//locators/CrossButtonGurdian")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on cross button popup");
				WaitforElementtobeclickable(xml.getlocator("//locators/IpGurdianSave"));
				Clickon(getwebelement(xml.getlocator("//locators/IpGurdianSave")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on save button");
				waitforPagetobeenable();
				break;
			}
			case "Voice Line V":
			{
				WaitforElementtobeclickable(xml2.getlocator("//locators/TotalDDi"));
				Clickon(getwebelement(xml2.getlocator("//locators/TotalDDi")));
				SendKeys(getwebelement(xml2.getlocator("//locators/TotalDDi")),"6");
				SendkeaboardKeys(getwebelement(xml2.getlocator("//locators/TotalDDi")),Keys.ENTER);
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Total DDI");
				Thread.sleep(5000);
				Clickon(getwebelement(xml2.getlocator("//locators/SaveButton")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on BCN Recurring Charge MRC Search");
				Thread.sleep(10000);
				System.out.println("middle applet end");
			}
			case "SIP Trunking":
			{
				WaitforElementtobeclickable(xml2.getlocator("//locators/CallAdmissionControl"));	
				Clickon(getwebelement(xml2.getlocator("//locators/CallAdmissionControl")));
				Clear(getwebelement(xml2.getlocator("//locators/CallAdmissionControl")));
				SendKeys(getwebelement(xml2.getlocator("//locators/CallAdmissionControl")),"12" );
				
				 WaitforElementtobeclickable(xml2.getlocator("//locators/TotalNumberDDIs"));
				    Clickon(getwebelement(xml2.getlocator("//locators/TotalNumberDDIs")));
				    Clear(getwebelement(xml2.getlocator("//locators/TotalNumberDDIs")));
				   
				    SendKeys(getwebelement(xml2.getlocator("//locators/TotalNumberDDIs")),"1");
					ExtentTestManager.getTest().log(LogStatus.PASS, " Provide Value to Total Number of DDI");
					Thread.sleep(10000);
				
				Thread.sleep(5000);

				
				
				Clickon(getwebelement(xml2.getlocator("//locators/SaveButton")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on BCN Recurring Charge MRC Search");
				Thread.sleep(10000);
				
				System.out.println("middle applet end");
				
				break;
			}
			case "IP Access": {

				
				
				getwebelement(xml.getlocator("//locators/capacitycheckreference")).clear();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear capicity check reference");
				Clickon(getwebelement(xml.getlocator("//locators/capacitycheckreference")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step:  click on Capicityreference");
				SendKeys(getwebelement(xml.getlocator("//locators/capacitycheckreference")),Inputdata[34].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step:  Input on Capicityreference");
				
				Thread.sleep(4000);
				
				//Router type//
			//	if(Newvalue is not equesl to blank) {
				WaitforElementtobeclickable(xml.getlocator("//locators/RouterTypeDropdownAccess"));
				Clickon(getwebelement(xml.getlocator("//locators/RouterTypeDropdownAccess")));
				
//				else do nothis
				
				//WaitforElementtobeclickable(xml.getlocator("//locators/SelectRouterTypeDropDownAccess"));
				Thread.sleep(3000);
				Clickon(getwebelement(xml.getlocator("//locators/RouterTypeValue").replace("value", Inputdata[35].toString())));
				
				
				waitforPagetobeenable();
				
				WaitforElementtobeclickable((xml.getlocator("//locators/IpGurdianSave")));
				Clickon(getwebelement(xml.getlocator("//locators/IpGurdianSave")));
				WaitforElementtobeclickable(xml.getlocator("//locators/Layer3ResillanceDropdownAccess"));
				Clickon(getwebelement(xml.getlocator("//locators/Layer3ResillanceDropdownAccess")));
				Thread.sleep(3000);
				//WaitforElementtobeclickable(xml.getlocator("//locators/Layer3ResillanceSelectDropdownAccess"));
				Clickon(getwebelement(xml.getlocator("//locators/RouterTypeValue").replace("value", Inputdata[36].toString())));
				
				waitforPagetobeenable();
				
				waitandForElementDisplay(xml.getlocator("//locators/IpGurdianSave"), 5);
				Clickon(getwebelement(xml.getlocator("//locators/IpGurdianSave")));
				waitforPagetobeenable();
				
				WaitforElementtobeclickable(xml.getlocator("//locators/ServiceBandwidthDropdownAccess"));
				Clickon(getwebelement(xml.getlocator("//locators/ServiceBandwidthDropdownAccess")));
				WaitforElementtobeclickable(xml.getlocator("//locators/ServiceBandwidthSelectAccess"));
				Clickon(getwebelement(xml.getlocator("//locators/ServiceBandwidthSelectAccess")));

				waitforPagetobeenable();
				waitandForElementDisplay(xml.getlocator("//locators/IpGurdianSave"), 5);
				Clickon(getwebelement(xml.getlocator("//locators/IpGurdianSave")));
				waitforPagetobeenable();
				Clear(getwebelement(xml.getlocator("//locators/Accesstype")));
				SendKeys(getwebelement(xml.getlocator("//locators/Accesstype")), Inputdata[0].toString());
				Clear(getwebelement(xml.getlocator("//locators/Buildingtype")));
				SendKeys(getwebelement(xml.getlocator("//locators/Buildingtype")), Inputdata[0].toString());
				Clear(getwebelement(xml.getlocator("//locators/relayfibre")));
				SendKeys(getwebelement(xml.getlocator("//locators/relayfibre")), Inputdata[0].toString());
				Clear(getwebelement(xml.getlocator("//locators/Dualcustomerpowersource")));
//				SendKeys(getwebelement(xml.getlocator("//locators/Dualcustomerpowersource")), Inputdata[0].toString());
//				Clear(getwebelement(xml.getlocator("//locators/Diversitytype")));
//				SendKeys(getwebelement(xml.getlocator("//locators/Diversitytype")), Inputdata[0].toString());
//				Clear(getwebelement(xml.getlocator("//locators/Customerdedicatedaccessring")));
//				SendKeys(getwebelement(xml.getlocator("//locators/Customerdedicatedaccessring")),Inputdata[0].toString());
				Clear(getwebelement(xml.getlocator("//locators/cabinettype")));
//				SendKeys(getwebelement(xml.getlocator("//locators/cabinettype")), Inputdata[0].toString());
//				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/cabinettype")), Keys.TAB);
//				Clear(getwebelement(xml.getlocator("//locators/CabinetID")));
//				SendKeys(getwebelement(xml.getlocator("//locators/CabinetID")), Inputdata[0].toString());
//				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/CabinetID")), Keys.TAB);
//				Clear(getwebelement(xml.getlocator("//locators/shelfid")));
//				SendKeys(getwebelement(xml.getlocator("//locators/shelfid")), Inputdata[0].toString());
//				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/shelfid")), Keys.TAB);
				Clear(getwebelement(xml.getlocator("//locators/Slotid")));
//				SendKeys(getwebelement(xml.getlocator("//locators/Slotid")), Inputdata[0].toString());
//				Clear(getwebelement(xml.getlocator("//locators/Physicalportid")));
//				SendKeys(getwebelement(xml.getlocator("//locators/Physicalportid")), Inputdata[0].toString());
//				Clear(getwebelement(xml.getlocator("//locators/PhysicalInterface")));
//				SendKeys(getwebelement(xml.getlocator("//locators/PhysicalInterface")), Inputdata[0].toString());
//				Clear(getwebelement(xml.getlocator("//locators/Fibretype")));
//				SendKeys(getwebelement(xml.getlocator("//locators/Fibretype")), Inputdata[0].toString());
//				Clear(getwebelement(xml.getlocator("//locators/Portrole")));
//				SendKeys(getwebelement(xml.getlocator("//locators/Portrole")), Inputdata[0].toString());
//				Clear(getwebelement(xml.getlocator("//locators/Connectortype")));
//				SendKeys(getwebelement(xml.getlocator("//locators/Connectortype")), Inputdata[0].toString());
				Clear(getwebelement(xml.getlocator("//locators/Coltcpeid")));
//				SendKeys(getwebelement(xml.getlocator("//locators/Coltcpeid")), Inputdata[0].toString());
//				Clear(getwebelement(xml.getlocator("//locators/Routerspecification")));
//				SendKeys(getwebelement(xml.getlocator("//locators/Routerspecification")), Inputdata[0].toString());
				Clear(getwebelement(xml.getlocator("//locators/installtime")));
//				SendKeys(getwebelement(xml.getlocator("//locators/installtime")), Inputdata[0].toString());
//				Clear(getwebelement(xml.getlocator("//locators/Accesstypewindow")));
//				SendKeys(getwebelement(xml.getlocator("//locators/Accesstypewindow")), Inputdata[0].toString());
				Clear(getwebelement(xml.getlocator("//locators/routermodel")));
//				SendKeys(getwebelement(xml.getlocator("//locators/routermodel")), Inputdata[0].toString());
//				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/routermodel")), Keys.TAB);
//				Clear(getwebelement(xml.getlocator("//locators/Sitename")));
//				SendKeys(getwebelement(xml.getlocator("//locators/Sitename")), Inputdata[0].toString());
//				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Sitename")), Keys.TAB);
//				Clickon(getwebelement(xml.getlocator("//locators/savebutton")));
				Clickon(getwebelement(xml.getlocator("//locators/Enabledfeatures")));
////			getwebelement(xml.getlocator("//locators/Enabledfeatures")).clear();
////			SendKeys(getwebelement(xml.getlocator("//locators/Enabledfeatures")), Inputdata[0].toString());
//			getwebelement(xml.getlocator("//locators/IPaddressingtype")).clear();
//			SendKeys(getwebelement(xml.getlocator("//locators/IPaddressingtype")), Inputdata[0].toString());
//			Clickon(getwebelement(xml.getlocator("//locators/Crossbuttonforipaccess")));
//			Clickon(getwebelement(xml.getlocator("//locators/savebutton")));
				break;
			}
			case "Interconnect": {

				System.out.println("go to else loop of call admission control");
				Clear(getwebelement(xml.getlocator("//locators/CallAdmissionControl")));
				Thread.sleep(6000);
				SendKeys(getwebelement(xml.getlocator("//locators/CallAdmissionControl")), "3");
				Thread.sleep(3000);
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter call admission control");
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/CallAdmissionControl")), Keys.TAB);
				
				Clear(getwebelement(xml.getlocator("//locators/NumberOfSignallingTrunks")));
				Thread.sleep(4000);
				SendKeys(getwebelement(xml.getlocator("//locators/NumberOfSignallingTrunks")), "9");
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter number of signalling trunks");
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/NumberOfSignallingTrunks")), Keys.TAB);
				

				WaitforElementtobeclickable(xml.getlocator("//locators/SaveButton"));
				Clickon(getwebelement(xml.getlocator("//locators/SaveButton")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on save button");
				waitForpageload();
				waitforPagetobeenable();
				break;

				

			}
			case "Cloud Unified Communications":
				
			{
				ModTechforcommanproduct(Inputdata);
				
				break;
			}
			case "Professional Services":
				
			{
				ModTechforcommanproduct(Inputdata);
				
				break;
			}
			case "IP Voice Solutions":
	
			{
				ModTechforcommanproduct(Inputdata);
	
				break;
			}
			case "Number Hosting":
			{
				break;
			}
				default:
				{
					break;
				}
			}
			
		}


}
