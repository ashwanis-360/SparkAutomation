package ScriptHelper;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.dom4j.DocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.relevantcodes.extentreports.LogStatus;

import Driver.DriverHelper;
import Driver.Log;
import Driver.XMLReader;
import Reporter.ExtentTestManager;

public class EOLorderCompletionHelper extends DriverHelper {
	

	String timeStamp = TimeStamp();
	
	public EOLorderCompletionHelper(WebDriver dr) 
	{
	super(dr);
	}

	WebElement el;
	XMLReader xml = new XMLReader("src\\Locators\\EOLOrder.xml");

	
	public void switchToSalesuserType() throws Exception {		
		
		System.out.println("Done2");
				
		Thread.sleep(10000);
		//WaitforElementtobeclickable(xml.getlocator("//locators/Switchrole"));
	//	Moveon(getwebelement(xml.getlocator("//locators/Switchrole")));
		Clickon(getwebelement(xml.getlocator("//locators/Switchrole")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Switch to Sales user type");
		//Thread.sleep(10000);
		
		//WaitforElementtobeclickable(xml.getlocator("//locators/Salesradio"));
	//  Clickon(getwebelement(xml.getlocator("//locators/Switchrole")));
  	Thread.sleep(5000);
  	   // javascriptexecutor(getwebelement(xml.getlocator("//locators/Salesradio")));
  	    switchtofram(getwebelement(xml.getlocator("//locators/SwitchIframe")));
		Clickon(getwebelement(xml.getlocator("//locators/Salesradio")));
		
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Sales user");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/Switchbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Switch to Sales user type");
		Thread.sleep(20000);
		/*
		Clickon(getwebelement(xml.getlocator("//locators/Neworderbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on New order button");
		Thread.sleep(5000);
		System.out.println("switch done"); */
	}

	
	
	public void createNewEOLOrder(Object[] Inputdata) throws Exception {
		
		Clickon(getwebelement(xml.getlocator("//locators/Neworderbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on New order button");
		Thread.sleep(5000);
		

		//fill contact details
		Clickon(getwebelement(xml.getlocator("//locators/AddContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/OpportunityNumber")));
		SendKeys(getwebelement(xml.getlocator("//locators/OpportunityNumber")), Inputdata[0].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Opportunity Number value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/EOLOCN")));
		SendKeys(getwebelement(xml.getlocator("//locators/EOLOCN")), Inputdata[1].toString());
		//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/EOLOCN")), Keys.TAB);
		
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OCN value");
		Thread.sleep(10000);
		
		Clickon(getwebelement(xml.getlocator("//locators/FirstNameLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/FirstNameLegal")), Inputdata[2].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter First name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/LastNameLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/LastNameLegal")), Inputdata[3].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter last name value");
		
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/TitleLegal")));
		Select(getwebelement(xml.getlocator("//locators/TitleLegal")), Inputdata[4].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/EmailLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/EmailLegal")), Inputdata[5].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Email value");
		
		Thread.sleep(3000);

		Clickon(getwebelement(xml.getlocator("//locators/TeleNumberLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/TeleNumberLegal")), Inputdata[6].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(3000);
		
		Clickon(getwebelement(xml.getlocator("//locators/CorrespondenceLangLegal")));
		//Select(getwebelement(xml.getlocator("//locators/CorrespondenceLangLegal")), "English");
		Select(getwebelement(xml.getlocator("//locators/CorrespondenceLangLegal")), Inputdata[7].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
		
		Thread.sleep(5000);
		/*
		Clickon(getwebelement(xml.getlocator("//locators/EOLBCN")));
		SendKeys(getwebelement(xml.getlocator("//locators/EOLBCN")), Inputdata[8].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(5000);
		
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000); */
		
		
		Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectContactbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact button");
		Thread.sleep(5000);
		//fill product customisation details
		
		Clickon(getwebelement(xml.getlocator("//locators/ProductName")));
		SendKeys(getwebelement(xml.getlocator("//locators/ProductName")), Inputdata[10].toString());
		Thread.sleep(5000);		
		Clickon(getwebelement(xml.getlocator("//locators/ProductNameClick")));
		//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ProductName")), Keys.ENTER);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter product name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/ContractRenewal")));
		//Select(getwebelement(xml.getlocator("//locators/ContractRenewal")), "1 Year");
		Select(getwebelement(xml.getlocator("//locators/ContractRenewal")), Inputdata[11].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select contract term");
		Thread.sleep(5000);
		
		//Clickon(getwebelement(xml.getlocator("//locators/Currency"))); 
		//Select(getwebelement(xml.getlocator("//locators/Currency")), "EUR – Euro");
		Select(getwebelement(xml.getlocator("//locators/Currency")), Inputdata[12].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select currency");
		Thread.sleep(10000);
		
		
		//Add A End Address
		
		Clickon(getwebelement(xml.getlocator("//locators/AddAEndAddr")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on Add A end address");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/OrganizationName")));
		SendKeys(getwebelement(xml.getlocator("//locators/OrganizationName")), Inputdata[13].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Organization name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/StreetName")));
		SendKeys(getwebelement(xml.getlocator("//locators/StreetName")), Inputdata[14].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Street name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Postalcode")));
		SendKeys(getwebelement(xml.getlocator("//locators/Postalcode")), Inputdata[15].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Postal code value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Country")));
		SendKeys(getwebelement(xml.getlocator("//locators/Country")), Inputdata[16].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter country");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Citytown")));
		SendKeys(getwebelement(xml.getlocator("//locators/Citytown")), Inputdata[17].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter City");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectAddress")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on Add address button");
		Thread.sleep(5000);
		
		
		//Add A End  contact details
		
		WaitforElementtobeclickable((xml.getlocator("//locators/AendTechContAddContact")));
		Clickon(getwebelement(xml.getlocator("//locators/AendTechContAddContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on Add A end contact detail icon");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/AendTechContFirstName")));
		SendKeys(getwebelement(xml.getlocator("//locators/AendTechContFirstName")), Inputdata[18].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter A end First name value");
		Thread.sleep(5000);
		
		WaitforElementtobeclickable(xml.getlocator("//locators/AendTechContLastName"));
		Clickon(getwebelement(xml.getlocator("//locators/AendTechContLastName")));
		SendKeys(getwebelement(xml.getlocator("//locators/AendTechContLastName")), Inputdata[19].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter A end last name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/AendTechContTitle")));
		Select(getwebelement(xml.getlocator("//locators/AendTechContTitle")), Inputdata[20].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/AendTechContEmail")));
		SendKeys(getwebelement(xml.getlocator("//locators/AendTechContEmail")), Inputdata[21].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter A end Email value");
		Thread.sleep(5000);

		Clickon(getwebelement(xml.getlocator("//locators/AendTechContTeleNumber")));
		SendKeys(getwebelement(xml.getlocator("//locators/AendTechContTeleNumber")), Inputdata[22].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/AendTechContCorrespondenceLang")));
		Select(getwebelement(xml.getlocator("//locators/AendTechContCorrespondenceLang")), Inputdata[23].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/AEndTechContSave")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
		Thread.sleep(5000);
		
		//A end product customization
		WaitforElementtobeclickable((xml.getlocator("//locators/AEndAccessT")));
		Clickon(getwebelement(xml.getlocator("//locators/AEndAccessT")));
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/AEndAccessTypeValue")));
	//	Select(getwebelement(xml.getlocator("//locators/AEndAccessT")), Inputdata[24].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select A End Access Type");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/ServcBand")));
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/ServcBandValue")));
	//	Select(getwebelement(xml.getlocator("//locators/ServcBand")), Inputdata[26].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select service bandwidth");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/router")));
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/routerValue")));
	//	Select(getwebelement(xml.getlocator("//locators/router")), Inputdata[25].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select router value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Billingtype")));
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/BillingtypeValue")));
	//	Select(getwebelement(xml.getlocator("//locators/Billingtype")), Inputdata[27].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select Billing Type");
		Thread.sleep(5000);
		
	
		//A end product customization  -  Customer Contact for Order/Technical Details*
		
//		WaitforElementtobeclickable((xml.getlocator("//locators/AEndTechContSave")));
//		Clickon(getwebelement(xml.getlocator("//locators/AEndTechContSave")));
		Clickon(getwebelement("//button[@id='AddContact']"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/FirstName")));
		SendKeys(getwebelement(xml.getlocator("//locators/FirstName")), Inputdata[2].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter First Name");
		Thread.sleep(5000);

		Clickon(getwebelement(xml.getlocator("//locators/LastName")));
		SendKeys(getwebelement(xml.getlocator("//locators/LastName")), Inputdata[3].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter last name");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Title")));
		Select(getwebelement(xml.getlocator("//locators/Title")), Inputdata[4].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Email")));
		SendKeys(getwebelement(xml.getlocator("//locators/Email")), Inputdata[5].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Email ");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/TeleNumber")));
		SendKeys(getwebelement(xml.getlocator("//locators/TeleNumber")), Inputdata[6].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(3000);
		
		Clickon(getwebelement(xml.getlocator("//locators/CorrespondenceLang"))); 
		Select(getwebelement(xml.getlocator("//locators/CorrespondenceLang")), "English");
		//Select(getwebelement(xml.getlocator("//locators/CorrespondenceLang")), Inputdata[7].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
		Thread.sleep(5000);
		
		
		Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
		Thread.sleep(5000);
		
		//Proceeding save operation:
		
		Clickon(getwebelement(xml.getlocator("//locators/InstallCharges")));
		SendKeys(getwebelement(xml.getlocator("//locators/InstallCharges")), Inputdata[28].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Install Charges");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/MonthlyCharges")));
		SendKeys(getwebelement(xml.getlocator("//locators/MonthlyCharges")), Inputdata[29].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Monthly Chargese");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/RouterCharges")));
		SendKeys(getwebelement(xml.getlocator("//locators/RouterCharges")), "3");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Monthly Chargese");
		Thread.sleep(5000);

		
		Clickon(getwebelement(xml.getlocator("//locators/RouterMonthlyCharges")));
		SendKeys(getwebelement(xml.getlocator("//locators/RouterMonthlyCharges")), "6");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Monthly Charges");
		Thread.sleep(5000);

		
		Clickon(getwebelement(xml.getlocator("//locators/ShowAddtnalCharges")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on additional charge icon");
		Thread.sleep(5000);
		
		
		//selectCheckbox(getwebelement(xml.getlocator("//locators/FastTrack")),"CHECK");
		Clickon(getwebelement(xml.getlocator("//locators/FastTrack")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on FastTrack check box");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/FastTrackCharges")));
		SendKeys(getwebelement(xml.getlocator("//locators/FastTrackCharges")), Inputdata[30].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Fast Track Charges");
		Thread.sleep(5000);
		
		
		Clickon(getwebelement(xml.getlocator("//locators/btnSave")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on save button");
		Thread.sleep(15000);
		
		
		Clickon(getwebelement(xml.getlocator("//locators/btnGenerateContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on generate contract button");
		Thread.sleep(5000);
		
		
		Clickon(getwebelement(xml.getlocator("//locators/Acceptpopbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on accept button");
		Thread.sleep(5000);
		
		
		Clickon(getwebelement(xml.getlocator("//locators/btnSubmitToCot")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on submit to Colt button");
     
		EOLGeneratingNumber.set(GetText(getwebelement(xml.getlocator("//locators/EOLNumberText"))));
		
		 ExtentTestManager.getTest().log(LogStatus.PASS," Step: Generated EOL Order Reference No: " + EOLGeneratingNumber.get());
			Log.info(EOLGeneratingNumber.get());


	
	
	}
	
		
	
	public void coltManagedFirewall(Object[]Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/Neworderbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on New order button");
		Thread.sleep(5000);
		
		//fill contact details
		Clickon(getwebelement(xml.getlocator("//locators/AddContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/OpportunityNumber")));
		SendKeys(getwebelement(xml.getlocator("//locators/OpportunityNumber")), Inputdata[0].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Opportunity Number value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/EOLOCN")));
		SendKeys(getwebelement(xml.getlocator("//locators/EOLOCN")), Inputdata[1].toString());
		//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/EOLOCN")), Keys.TAB);
		
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OCN value");
		Thread.sleep(10000);
		
		Clickon(getwebelement(xml.getlocator("//locators/FirstNameLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/FirstNameLegal")), Inputdata[2].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter First name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/LastNameLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/LastNameLegal")), Inputdata[3].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter last name value");
		
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/TitleLegal")));
		Select(getwebelement(xml.getlocator("//locators/TitleLegal")), Inputdata[4].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/EmailLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/EmailLegal")), Inputdata[5].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Email value");
		
		Thread.sleep(3000);

		Clickon(getwebelement(xml.getlocator("//locators/TeleNumberLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/TeleNumberLegal")), Inputdata[6].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(3000);
		
		Clickon(getwebelement(xml.getlocator("//locators/CorrespondenceLangLegal")));
		//Select(getwebelement(xml.getlocator("//locators/CorrespondenceLangLegal")), "English");
		Select(getwebelement(xml.getlocator("//locators/CorrespondenceLangLegal")), Inputdata[7].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
		
		Thread.sleep(5000);
		/*
		Clickon(getwebelement(xml.getlocator("//locators/EOLBCN")));
		SendKeys(getwebelement(xml.getlocator("//locators/EOLBCN")), Inputdata[8].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(5000);
		
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000); */
		
		
		Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectContactbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact button");
		Thread.sleep(5000);
		//fill product customisation details
		
		Clickon(getwebelement(xml.getlocator("//locators/ProductName")));
		SendKeys(getwebelement(xml.getlocator("//locators/ProductName")), Inputdata[10].toString());
		Thread.sleep(5000);		
		Clickon(getwebelement(xml.getlocator("//locators/ProductNameClick")));
		//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ProductName")), Keys.ENTER);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter product name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/ContractRenewal")));
		//Select(getwebelement(xml.getlocator("//locators/ContractRenewal")), "1 Year");
		Select(getwebelement(xml.getlocator("//locators/ContractRenewal")), Inputdata[11].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select contract term");
		Thread.sleep(5000);
		
		//Clickon(getwebelement(xml.getlocator("//locators/Currency"))); 
		//Select(getwebelement(xml.getlocator("//locators/Currency")), "EUR – Euro");
		Select(getwebelement(xml.getlocator("//locators/Currency")), Inputdata[12].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select currency");
		Thread.sleep(10000);
		
		
		SendKeys(getwebelement(xml.getlocator("//locators/ExistingIPAccess")), "2");
		
		Clickon(getwebelement("//button[@id='AddContact']"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/InstallCharges")));
		SendKeys(getwebelement(xml.getlocator("//locators/InstallCharges")), Inputdata[28].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Install Charges");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/MonthlyCharges")));
		SendKeys(getwebelement(xml.getlocator("//locators/MonthlyCharges")), Inputdata[29].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Monthly Chargese");
		Thread.sleep(5000);

		
		Clickon(getwebelement(xml.getlocator("//locators/FirstName")));
		SendKeys(getwebelement(xml.getlocator("//locators/FirstName")), Inputdata[2].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter First Name");
		Thread.sleep(5000);

		Clickon(getwebelement(xml.getlocator("//locators/LastName")));
		SendKeys(getwebelement(xml.getlocator("//locators/LastName")), Inputdata[3].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter last name");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Title")));
		Select(getwebelement(xml.getlocator("//locators/Title")), Inputdata[4].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Email")));
		SendKeys(getwebelement(xml.getlocator("//locators/Email")), Inputdata[5].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Email ");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/TeleNumber")));
		SendKeys(getwebelement(xml.getlocator("//locators/TeleNumber")), Inputdata[6].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(3000);
		
		Clickon(getwebelement(xml.getlocator("//locators/CorrespondenceLang"))); 
		Select(getwebelement(xml.getlocator("//locators/CorrespondenceLang")), "English");
		//Select(getwebelement(xml.getlocator("//locators/CorrespondenceLang")), Inputdata[7].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
		Thread.sleep(5000);
		
		
		Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/btnSave")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on save button");
		Thread.sleep(15000);
		
		Clickon(getwebelement(xml.getlocator("//locators/btnGenerateContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on generate contract button");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Acceptpopbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on accept button");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/btnSubmitToCot")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on submit to Colt button");

		EOLGeneratingNumber.set(GetText(getwebelement(xml.getlocator("//locators/EOLNumberText"))));
		
		 ExtentTestManager.getTest().log(LogStatus.PASS," Step: Generated EOL Order Reference No: " + EOLGeneratingNumber.get());
			Log.info(EOLGeneratingNumber.get());
		
	}
	public void ethernetVPN(Object[]Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/Neworderbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on New order button");
		Thread.sleep(5000);
		

		//fill contact details
		Clickon(getwebelement(xml.getlocator("//locators/AddContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/OpportunityNumber")));
		SendKeys(getwebelement(xml.getlocator("//locators/OpportunityNumber")), Inputdata[0].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Opportunity Number value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/EOLOCN")));
		SendKeys(getwebelement(xml.getlocator("//locators/EOLOCN")), Inputdata[1].toString());
		//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/EOLOCN")), Keys.TAB);
		
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OCN value");
		Thread.sleep(10000);
		
		Clickon(getwebelement(xml.getlocator("//locators/FirstNameLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/FirstNameLegal")), Inputdata[2].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter First name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/LastNameLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/LastNameLegal")), Inputdata[3].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter last name value");
		
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/TitleLegal")));
		Select(getwebelement(xml.getlocator("//locators/TitleLegal")), Inputdata[4].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/EmailLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/EmailLegal")), Inputdata[5].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Email value");
		
		Thread.sleep(3000);

		Clickon(getwebelement(xml.getlocator("//locators/TeleNumberLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/TeleNumberLegal")), Inputdata[6].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(3000);
		
		Clickon(getwebelement(xml.getlocator("//locators/CorrespondenceLangLegal")));
		//Select(getwebelement(xml.getlocator("//locators/CorrespondenceLangLegal")), "English");
		Select(getwebelement(xml.getlocator("//locators/CorrespondenceLangLegal")), Inputdata[7].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
		
		Thread.sleep(5000);
		/*
		Clickon(getwebelement(xml.getlocator("//locators/EOLBCN")));
		SendKeys(getwebelement(xml.getlocator("//locators/EOLBCN")), Inputdata[8].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(5000);
		
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000); */
		
		
		Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectContactbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact button");
		Thread.sleep(5000);
		//fill product customisation details
		
		Clickon(getwebelement(xml.getlocator("//locators/ProductName")));
		SendKeys(getwebelement(xml.getlocator("//locators/ProductName")), Inputdata[10].toString());
		Thread.sleep(5000);		
		Clickon(getwebelement(xml.getlocator("//locators/ProductNameClick")));
		//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ProductName")), Keys.ENTER);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter product name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/ContractRenewal")));
		//Select(getwebelement(xml.getlocator("//locators/ContractRenewal")), "1 Year");
		Select(getwebelement(xml.getlocator("//locators/ContractRenewal")), Inputdata[11].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select contract term");
		Thread.sleep(5000);
		
		//Clickon(getwebelement(xml.getlocator("//locators/Currency"))); 
		//Select(getwebelement(xml.getlocator("//locators/Currency")), "EUR – Euro");
		Select(getwebelement(xml.getlocator("//locators/Currency")), Inputdata[12].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select currency");
		Thread.sleep(10000);
		
		
		//Add A End Address
		
		Clickon(getwebelement(xml.getlocator("//locators/AddAEndAddr")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on Add A end address");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/OrganizationName")));
		SendKeys(getwebelement(xml.getlocator("//locators/OrganizationName")), Inputdata[13].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Organization name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/StreetName")));
		SendKeys(getwebelement(xml.getlocator("//locators/StreetName")), Inputdata[14].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Street name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Postalcode")));
		SendKeys(getwebelement(xml.getlocator("//locators/Postalcode")), Inputdata[15].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Postal code value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Country")));
		SendKeys(getwebelement(xml.getlocator("//locators/Country")), Inputdata[16].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter country");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Citytown")));
		SendKeys(getwebelement(xml.getlocator("//locators/Citytown")), Inputdata[17].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter City");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectAddress")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on Add address button");
		Thread.sleep(5000);
		
		WaitforElementtobeclickable((xml.getlocator("//locators/AEndAccessT")));
		Clickon(getwebelement(xml.getlocator("//locators/AEndAccessT")));
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/AEndAccessTypeValue")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select A End Access Type");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/ServcBand")));
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/ServcBandValue")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select Router");
		Thread.sleep(5000);
		
		Clickon(getwebelement("//button[@id='AddContact']"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
		Thread.sleep(5000);
		

		Clickon(getwebelement(xml.getlocator("//locators/InstallCharges")));
		SendKeys(getwebelement(xml.getlocator("//locators/InstallCharges")), Inputdata[28].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Install Charges");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/MonthlyCharges")));
		SendKeys(getwebelement(xml.getlocator("//locators/MonthlyCharges")), Inputdata[29].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Monthly Chargese");
		Thread.sleep(5000);
		
		
		Clickon(getwebelement(xml.getlocator("//locators/FirstName")));
		SendKeys(getwebelement(xml.getlocator("//locators/FirstName")), Inputdata[2].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter First Name");
		Thread.sleep(5000);

		Clickon(getwebelement(xml.getlocator("//locators/LastName")));
		SendKeys(getwebelement(xml.getlocator("//locators/LastName")), Inputdata[3].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter last name");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Title")));
		Select(getwebelement(xml.getlocator("//locators/Title")), Inputdata[4].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Email")));
		SendKeys(getwebelement(xml.getlocator("//locators/Email")), Inputdata[5].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Email ");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/TeleNumber")));
		SendKeys(getwebelement(xml.getlocator("//locators/TeleNumber")), Inputdata[6].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(3000);
		
		Clickon(getwebelement(xml.getlocator("//locators/CorrespondenceLang"))); 
		Select(getwebelement(xml.getlocator("//locators/CorrespondenceLang")), "English");
		//Select(getwebelement(xml.getlocator("//locators/CorrespondenceLang")), Inputdata[7].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
		Thread.sleep(5000);
		
		
		Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
		Thread.sleep(5000);
		

	
		
//		Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectContact")));
//		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
//		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/btnSave")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on save button");
		Thread.sleep(15000);
		
		Clickon(getwebelement(xml.getlocator("//locators/btnGenerateContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on generate contract button");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Acceptpopbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on accept button");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/btnSubmitToCot")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on submit to Colt button");
		
		EOLGeneratingNumber.set(GetText(getwebelement(xml.getlocator("//locators/EOLNumberText"))));
		
		 ExtentTestManager.getTest().log(LogStatus.PASS," Step: Generated EOL Order Reference No: " + EOLGeneratingNumber.get());
			Log.info(EOLGeneratingNumber.get());
	}
	
	public void ethernetLine(Object[]Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/Neworderbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on New order button");
		Thread.sleep(5000);
		

		//fill contact details
		Clickon(getwebelement(xml.getlocator("//locators/AddContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/OpportunityNumber")));
		SendKeys(getwebelement(xml.getlocator("//locators/OpportunityNumber")), Inputdata[0].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Opportunity Number value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/EOLOCN")));
		SendKeys(getwebelement(xml.getlocator("//locators/EOLOCN")), Inputdata[1].toString());
		//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/EOLOCN")), Keys.TAB);
		
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OCN value");
		Thread.sleep(10000);
		
		Clickon(getwebelement(xml.getlocator("//locators/FirstNameLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/FirstNameLegal")), Inputdata[2].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter First name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/LastNameLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/LastNameLegal")), Inputdata[3].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter last name value");
		
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/TitleLegal")));
		Select(getwebelement(xml.getlocator("//locators/TitleLegal")), Inputdata[4].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/EmailLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/EmailLegal")), Inputdata[5].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Email value");
		
		Thread.sleep(3000);

		Clickon(getwebelement(xml.getlocator("//locators/TeleNumberLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/TeleNumberLegal")), Inputdata[6].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(3000);
		
		Clickon(getwebelement(xml.getlocator("//locators/CorrespondenceLangLegal")));
		//Select(getwebelement(xml.getlocator("//locators/CorrespondenceLangLegal")), "English");
		Select(getwebelement(xml.getlocator("//locators/CorrespondenceLangLegal")), Inputdata[7].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
		
		Thread.sleep(5000);
		/*
		Clickon(getwebelement(xml.getlocator("//locators/EOLBCN")));
		SendKeys(getwebelement(xml.getlocator("//locators/EOLBCN")), Inputdata[8].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(5000);
		
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000); */
		
		
		Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectContactbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact button");
		Thread.sleep(5000);
		//fill product customisation details
		
		Clickon(getwebelement(xml.getlocator("//locators/ProductName")));
		SendKeys(getwebelement(xml.getlocator("//locators/ProductName")), Inputdata[10].toString());
		Thread.sleep(5000);		
		Clickon(getwebelement(xml.getlocator("//locators/ProductNameClick")));
		//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ProductName")), Keys.ENTER);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter product name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/ContractRenewal")));
		//Select(getwebelement(xml.getlocator("//locators/ContractRenewal")), "1 Year");
		Select(getwebelement(xml.getlocator("//locators/ContractRenewal")), Inputdata[11].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select contract term");
		Thread.sleep(5000);
		
		//Clickon(getwebelement(xml.getlocator("//locators/Currency"))); 
		//Select(getwebelement(xml.getlocator("//locators/Currency")), "EUR – Euro");
		Select(getwebelement(xml.getlocator("//locators/Currency")), Inputdata[12].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select currency");
		Thread.sleep(10000);
		
		
		//Add A End Address
		
		Clickon(getwebelement(xml.getlocator("//locators/AddAEndAddr")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on Add A end address");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/OrganizationName")));
		SendKeys(getwebelement(xml.getlocator("//locators/OrganizationName")), Inputdata[13].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Organization name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/StreetName")));
		SendKeys(getwebelement(xml.getlocator("//locators/StreetName")), Inputdata[14].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Street name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Postalcode")));
		SendKeys(getwebelement(xml.getlocator("//locators/Postalcode")), Inputdata[15].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Postal code value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Country")));
		SendKeys(getwebelement(xml.getlocator("//locators/Country")), Inputdata[16].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter country");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Citytown")));
		SendKeys(getwebelement(xml.getlocator("//locators/Citytown")), Inputdata[17].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter City");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectAddress")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on Add address button");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/AddBendaddress")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on Add b eNd address button");
		Thread.sleep(5000);
		
		
		
		
		
		
		Clickon(getwebelement(xml.getlocator("//locators/OrganisationBend")));
		SendKeys(getwebelement(xml.getlocator("//locators/OrganisationBend")), Inputdata[13].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Organization b end name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/StreetNameBENd")));
		SendKeys(getwebelement(xml.getlocator("//locators/StreetNameBENd")), Inputdata[14].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Street name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/PostalCodeBEnD")));
		SendKeys(getwebelement(xml.getlocator("//locators/PostalCodeBEnD")), Inputdata[15].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Postal code value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/CountryBEnd")));
		SendKeys(getwebelement(xml.getlocator("//locators/CountryBEnd")), Inputdata[16].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter country b end");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/CityBEnd")));
		SendKeys(getwebelement(xml.getlocator("//locators/CityBEnd")), Inputdata[17].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter b end City");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/BEndSaveContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on b end save button");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/AEndAccessTypeValue")));
		
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select A End Access Type");
			Thread.sleep(5000);
			
			
			Select(getwebelement(xml.getlocator("//locators/BendAccessType")), "Colt Fibre");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select b End Access Type");
			
			
			Clickon(getwebelement(xml.getlocator("//locators/ServcBand")));
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ServcBandValue")));
		
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select service bandwidth");
			Thread.sleep(5000);
			
			
			Clickon(getwebelement(xml.getlocator("//locators/InstallCharges")));
			SendKeys(getwebelement(xml.getlocator("//locators/InstallCharges")), Inputdata[28].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Install Charges");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/MonthlyCharges")));
			SendKeys(getwebelement(xml.getlocator("//locators/MonthlyCharges")), Inputdata[29].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Monthly Chargese");
			Thread.sleep(5000);
			
			Clickon(getwebelement("//button[@id='AddContact']"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/FirstName")));
			SendKeys(getwebelement(xml.getlocator("//locators/FirstName")), Inputdata[2].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter First Name");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/LastName")));
			SendKeys(getwebelement(xml.getlocator("//locators/LastName")), Inputdata[3].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter last name");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/Title")));
			Select(getwebelement(xml.getlocator("//locators/Title")), Inputdata[4].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/Email")));
			SendKeys(getwebelement(xml.getlocator("//locators/Email")), Inputdata[5].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Email ");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/TeleNumber")));
			SendKeys(getwebelement(xml.getlocator("//locators/TeleNumber")), Inputdata[6].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
			Thread.sleep(3000);
			
			Clickon(getwebelement(xml.getlocator("//locators/CorrespondenceLang"))); 
			Select(getwebelement(xml.getlocator("//locators/CorrespondenceLang")), "English");
			//Select(getwebelement(xml.getlocator("//locators/CorrespondenceLang")), Inputdata[7].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
			Thread.sleep(5000);
			
			
			Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectContact")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
			Thread.sleep(5000);

			
			Clickon(getwebelement(xml.getlocator("//locators/btnSave")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on save button");
			Thread.sleep(15000);
			
			Clickon(getwebelement(xml.getlocator("//locators/btnGenerateContact")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on generate contract button");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/Acceptpopbutton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on accept button");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/btnSubmitToCot")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on submit to Colt button");
			
			EOLGeneratingNumber.set(GetText(getwebelement(xml.getlocator("//locators/EOLNumberText"))));
			
			 ExtentTestManager.getTest().log(LogStatus.PASS," Step: Generated EOL Order Reference No: " + EOLGeneratingNumber.get());
				Log.info(EOLGeneratingNumber.get());
	}
	
	public void ethernetHub(Object[]Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/Neworderbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on New order button");
		Thread.sleep(5000);
		

		//fill contact details
		Clickon(getwebelement(xml.getlocator("//locators/AddContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/OpportunityNumber")));
		SendKeys(getwebelement(xml.getlocator("//locators/OpportunityNumber")), Inputdata[0].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Opportunity Number value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/EOLOCN")));
		SendKeys(getwebelement(xml.getlocator("//locators/EOLOCN")), Inputdata[1].toString());
		//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/EOLOCN")), Keys.TAB);
		
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OCN value");
		Thread.sleep(10000);
		
		Clickon(getwebelement(xml.getlocator("//locators/FirstNameLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/FirstNameLegal")), Inputdata[2].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter First name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/LastNameLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/LastNameLegal")), Inputdata[3].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter last name value");
		
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/TitleLegal")));
		Select(getwebelement(xml.getlocator("//locators/TitleLegal")), Inputdata[4].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/EmailLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/EmailLegal")), Inputdata[5].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Email value");
		
		Thread.sleep(3000);

		Clickon(getwebelement(xml.getlocator("//locators/TeleNumberLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/TeleNumberLegal")), Inputdata[6].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(3000);
		
		Clickon(getwebelement(xml.getlocator("//locators/CorrespondenceLangLegal")));
		//Select(getwebelement(xml.getlocator("//locators/CorrespondenceLangLegal")), "English");
		Select(getwebelement(xml.getlocator("//locators/CorrespondenceLangLegal")), Inputdata[7].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
		
		Thread.sleep(5000);
		/*
		Clickon(getwebelement(xml.getlocator("//locators/EOLBCN")));
		SendKeys(getwebelement(xml.getlocator("//locators/EOLBCN")), Inputdata[8].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(5000);
		
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000); */
		
		
		Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectContactbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact button");
		Thread.sleep(5000);
		//fill product customisation details
		
		Clickon(getwebelement(xml.getlocator("//locators/ProductName")));
		SendKeys(getwebelement(xml.getlocator("//locators/ProductName")), Inputdata[10].toString());
		Thread.sleep(5000);		
		Clickon(getwebelement(xml.getlocator("//locators/ProductNameClick")));
		//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ProductName")), Keys.ENTER);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter product name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/ContractRenewal")));
		//Select(getwebelement(xml.getlocator("//locators/ContractRenewal")), "1 Year");
		Select(getwebelement(xml.getlocator("//locators/ContractRenewal")), Inputdata[11].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select contract term");
		Thread.sleep(5000);
		
		//Clickon(getwebelement(xml.getlocator("//locators/Currency"))); 
		//Select(getwebelement(xml.getlocator("//locators/Currency")), "EUR – Euro");
		Select(getwebelement(xml.getlocator("//locators/Currency")), Inputdata[12].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select currency");
		Thread.sleep(10000);
		
		
		//Add A End Address
		
		Clickon(getwebelement(xml.getlocator("//locators/AddAEndAddr")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on Add A end address");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/OrganizationName")));
		SendKeys(getwebelement(xml.getlocator("//locators/OrganizationName")), Inputdata[13].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Organization name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/StreetName")));
		SendKeys(getwebelement(xml.getlocator("//locators/StreetName")), Inputdata[14].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Street name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Postalcode")));
		SendKeys(getwebelement(xml.getlocator("//locators/Postalcode")), Inputdata[15].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Postal code value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Country")));
		SendKeys(getwebelement(xml.getlocator("//locators/Country")), Inputdata[16].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter country");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Citytown")));
		SendKeys(getwebelement(xml.getlocator("//locators/Citytown")), Inputdata[17].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter City");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectAddress")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on Add address button");
		Thread.sleep(5000);
		
		
		//Add A End  contact details
		
		WaitforElementtobeclickable((xml.getlocator("//locators/AendTechContAddContact")));
		Clickon(getwebelement(xml.getlocator("//locators/AendTechContAddContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on Add A end contact detail icon");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/AendTechContFirstName")));
		SendKeys(getwebelement(xml.getlocator("//locators/AendTechContFirstName")), Inputdata[18].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter A end First name value");
		Thread.sleep(5000);
		
		WaitforElementtobeclickable(xml.getlocator("//locators/AendTechContLastName"));
		Clickon(getwebelement(xml.getlocator("//locators/AendTechContLastName")));
		SendKeys(getwebelement(xml.getlocator("//locators/AendTechContLastName")), Inputdata[19].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter A end last name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/AendTechContTitle")));
		Select(getwebelement(xml.getlocator("//locators/AendTechContTitle")), Inputdata[20].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/AendTechContEmail")));
		SendKeys(getwebelement(xml.getlocator("//locators/AendTechContEmail")), Inputdata[21].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter A end Email value");
		Thread.sleep(5000);

		Clickon(getwebelement(xml.getlocator("//locators/AendTechContTeleNumber")));
		SendKeys(getwebelement(xml.getlocator("//locators/AendTechContTeleNumber")), Inputdata[22].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/AendTechContCorrespondenceLang")));
		Select(getwebelement(xml.getlocator("//locators/AendTechContCorrespondenceLang")), Inputdata[23].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/AEndTechContSave")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
		Thread.sleep(5000);
		
		//A end product customization
		WaitforElementtobeclickable((xml.getlocator("//locators/AEndAccessT")));
		Clickon(getwebelement(xml.getlocator("//locators/AEndAccessT")));
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/AEndAccessTypeValue")));
	//	Select(getwebelement(xml.getlocator("//locators/AEndAccessT")), Inputdata[24].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select A End Access Type");
		Thread.sleep(5000);
		
		
		Select(getwebelement(xml.getlocator("//locators/ServcBand")),"10 Gbps");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select service bandwidth");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/InstallCharges")));
		SendKeys(getwebelement(xml.getlocator("//locators/InstallCharges")), Inputdata[28].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Install Charges");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/MonthlyCharges")));
		SendKeys(getwebelement(xml.getlocator("//locators/MonthlyCharges")), Inputdata[29].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Monthly Chargese");
		Thread.sleep(5000);
		
		Clickon(getwebelement("//button[@id='AddContact']"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/FirstName")));
		SendKeys(getwebelement(xml.getlocator("//locators/FirstName")), Inputdata[2].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter First Name");
		Thread.sleep(5000);

		Clickon(getwebelement(xml.getlocator("//locators/LastName")));
		SendKeys(getwebelement(xml.getlocator("//locators/LastName")), Inputdata[3].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter last name");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Title")));
		Select(getwebelement(xml.getlocator("//locators/Title")), Inputdata[4].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Email")));
		SendKeys(getwebelement(xml.getlocator("//locators/Email")), Inputdata[5].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Email ");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/TeleNumber")));
		SendKeys(getwebelement(xml.getlocator("//locators/TeleNumber")), Inputdata[6].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(3000);
		
		Clickon(getwebelement(xml.getlocator("//locators/CorrespondenceLang"))); 
		Select(getwebelement(xml.getlocator("//locators/CorrespondenceLang")), "English");
		//Select(getwebelement(xml.getlocator("//locators/CorrespondenceLang")), Inputdata[7].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
		Thread.sleep(5000);
		
		
		Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
		Thread.sleep(5000);

		
		Clickon(getwebelement(xml.getlocator("//locators/btnSave")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on save button");
		Thread.sleep(15000);
		
		Clickon(getwebelement(xml.getlocator("//locators/btnGenerateContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on generate contract button");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Acceptpopbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on accept button");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/btnSubmitToCot")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on submit to Colt button");
		 EOLGeneratingNumber.set(GetText(getwebelement(xml.getlocator("//locators/EOLNumberText"))));
			
		 ExtentTestManager.getTest().log(LogStatus.PASS," Step: Generated EOL Order Reference No: " + EOLGeneratingNumber.get());
			Log.info(EOLGeneratingNumber.get());
	
	}
	
	public void ethernetWave(Object[]Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/Neworderbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on New order button");
		Thread.sleep(5000);
		

		//fill contact details
		Clickon(getwebelement(xml.getlocator("//locators/AddContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/OpportunityNumber")));
		SendKeys(getwebelement(xml.getlocator("//locators/OpportunityNumber")), Inputdata[0].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Opportunity Number value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/EOLOCN")));
		SendKeys(getwebelement(xml.getlocator("//locators/EOLOCN")), Inputdata[1].toString());
		//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/EOLOCN")), Keys.TAB);
		
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OCN value");
		Thread.sleep(10000);
		
		Clickon(getwebelement(xml.getlocator("//locators/FirstNameLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/FirstNameLegal")), Inputdata[2].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter First name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/LastNameLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/LastNameLegal")), Inputdata[3].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter last name value");
		
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/TitleLegal")));
		Select(getwebelement(xml.getlocator("//locators/TitleLegal")), Inputdata[4].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/EmailLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/EmailLegal")), Inputdata[5].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Email value");
		
		Thread.sleep(3000);

		Clickon(getwebelement(xml.getlocator("//locators/TeleNumberLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/TeleNumberLegal")), Inputdata[6].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(3000);
		
		Clickon(getwebelement(xml.getlocator("//locators/CorrespondenceLangLegal")));
		//Select(getwebelement(xml.getlocator("//locators/CorrespondenceLangLegal")), "English");
		Select(getwebelement(xml.getlocator("//locators/CorrespondenceLangLegal")), Inputdata[7].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
		
		Thread.sleep(5000);
		/*
		Clickon(getwebelement(xml.getlocator("//locators/EOLBCN")));
		SendKeys(getwebelement(xml.getlocator("//locators/EOLBCN")), Inputdata[8].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(5000);
		
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000); */
		
		
		Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectContactbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact button");
		Thread.sleep(5000);
		//fill product customisation details
		
		Clickon(getwebelement(xml.getlocator("//locators/ProductName")));
		SendKeys(getwebelement(xml.getlocator("//locators/ProductName")), Inputdata[10].toString());
		Thread.sleep(5000);		
		Clickon(getwebelement(xml.getlocator("//locators/ProductNameClick")));
		//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ProductName")), Keys.ENTER);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter product name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/ContractRenewal")));
		//Select(getwebelement(xml.getlocator("//locators/ContractRenewal")), "1 Year");
		Select(getwebelement(xml.getlocator("//locators/ContractRenewal")), Inputdata[11].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select contract term");
		Thread.sleep(5000);
		
		//Clickon(getwebelement(xml.getlocator("//locators/Currency"))); 
		//Select(getwebelement(xml.getlocator("//locators/Currency")), "EUR – Euro");
		Select(getwebelement(xml.getlocator("//locators/Currency")), Inputdata[12].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select currency");
		Thread.sleep(10000);
		
		
		//Add A End Address
		
		Clickon(getwebelement(xml.getlocator("//locators/AddAEndAddr")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on Add A end address");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/OrganizationName")));
		SendKeys(getwebelement(xml.getlocator("//locators/OrganizationName")), Inputdata[13].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Organization name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/StreetName")));
		SendKeys(getwebelement(xml.getlocator("//locators/StreetName")), Inputdata[14].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Street name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Postalcode")));
		SendKeys(getwebelement(xml.getlocator("//locators/Postalcode")), Inputdata[15].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Postal code value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Country")));
		SendKeys(getwebelement(xml.getlocator("//locators/Country")), Inputdata[16].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter country");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Citytown")));
		SendKeys(getwebelement(xml.getlocator("//locators/Citytown")), Inputdata[17].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter City");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectAddress")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on Add address button");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/AddBendaddress")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on Add b eNd address button");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/OrganisationBend")));
		SendKeys(getwebelement(xml.getlocator("//locators/OrganisationBend")), Inputdata[13].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Organization b end name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/StreetNameBENd")));
		SendKeys(getwebelement(xml.getlocator("//locators/StreetNameBENd")), Inputdata[14].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Street name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/PostalCodeBEnD")));
		SendKeys(getwebelement(xml.getlocator("//locators/PostalCodeBEnD")), Inputdata[15].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Postal code value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/CountryBEnd")));
		SendKeys(getwebelement(xml.getlocator("//locators/CountryBEnd")), Inputdata[16].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter country b end");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/CityBEnd")));
		SendKeys(getwebelement(xml.getlocator("//locators/CityBEnd")), Inputdata[17].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter b end City");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/BEndSaveContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on b end save button");
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/AEndAccessT")));
		Clickon(getwebelement(xml.getlocator("//locators/AEndAccessTypeValue")));
		
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select A End Access Type");
			Thread.sleep(5000);
			
			
			Select(getwebelement(xml.getlocator("//locators/BendAccessType")), "Colt Fibre");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select b End Access Type");
			
			Select(getwebelement(xml.getlocator("locators/ServiceType")), Inputdata[41].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select service type");
			
			Select(getwebelement(xml.getlocator("locators/ServcBand")), Inputdata[42].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select service bandwidth");
			
			Select(getwebelement(xml.getlocator("locators/WorkerPath")), "NA");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select service bandwidth");
			
			Clickon(getwebelement(xml.getlocator("//locators/InstallCharges")));
			SendKeys(getwebelement(xml.getlocator("//locators/InstallCharges")), Inputdata[28].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Install Charges");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/MonthlyCharges")));
			SendKeys(getwebelement(xml.getlocator("//locators/MonthlyCharges")), Inputdata[29].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Monthly Chargese");
			Thread.sleep(5000);
			
			SendKeys(getwebelement(xml.getlocator("//locators/CustomerContactField")), "Colt fibre");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter value in customer contact field");
			Thread.sleep(5000);
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/CustomerContactField")), Keys.TAB);
			
			Clickon(getwebelement("//button[@id='AddContact']"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/FirstName")));
			SendKeys(getwebelement(xml.getlocator("//locators/FirstName")), Inputdata[2].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter First Name");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/LastName")));
			SendKeys(getwebelement(xml.getlocator("//locators/LastName")), Inputdata[3].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter last name");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/Title")));
			Select(getwebelement(xml.getlocator("//locators/Title")), Inputdata[4].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/Email")));
			SendKeys(getwebelement(xml.getlocator("//locators/Email")), Inputdata[5].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Email ");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/TeleNumber")));
			SendKeys(getwebelement(xml.getlocator("//locators/TeleNumber")), Inputdata[6].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
			Thread.sleep(3000);
			
			Clickon(getwebelement(xml.getlocator("//locators/CorrespondenceLang"))); 
			Select(getwebelement(xml.getlocator("//locators/CorrespondenceLang")), "English");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
			Thread.sleep(5000);
			
			
			Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectContact")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/btnSave")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on save button");
			Thread.sleep(15000);
			
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/btnGenerateContact")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on generate contract button");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/Acceptpopbutton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on accept button");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/btnSubmitToCot")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on submit to Colt button");
			
			 EOLGeneratingNumber.set(GetText(getwebelement(xml.getlocator("//locators/EOLNumberText"))));
				
			 ExtentTestManager.getTest().log(LogStatus.PASS," Step: Generated EOL Order Reference No: " + EOLGeneratingNumber.get());
				Log.info(EOLGeneratingNumber.get());
			
	}
	public void ethernetSpoke(Object[]Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/Neworderbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on New order button");
		Thread.sleep(5000);
		

		//fill contact details
		Clickon(getwebelement(xml.getlocator("//locators/AddContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/OpportunityNumber")));
		SendKeys(getwebelement(xml.getlocator("//locators/OpportunityNumber")), Inputdata[0].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Opportunity Number value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/EOLOCN")));
		SendKeys(getwebelement(xml.getlocator("//locators/EOLOCN")), Inputdata[1].toString());
		
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OCN value");
		Thread.sleep(10000);
		
		Clickon(getwebelement(xml.getlocator("//locators/FirstNameLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/FirstNameLegal")), Inputdata[2].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter First name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/LastNameLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/LastNameLegal")), Inputdata[3].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter last name value");
		
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/TitleLegal")));
		Select(getwebelement(xml.getlocator("//locators/TitleLegal")), Inputdata[4].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/EmailLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/EmailLegal")), Inputdata[5].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Email value");
		
		Thread.sleep(3000);

		Clickon(getwebelement(xml.getlocator("//locators/TeleNumberLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/TeleNumberLegal")), Inputdata[6].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(3000);
		
		Clickon(getwebelement(xml.getlocator("//locators/CorrespondenceLangLegal")));
		//Select(getwebelement(xml.getlocator("//locators/CorrespondenceLangLegal")), "English");
		Select(getwebelement(xml.getlocator("//locators/CorrespondenceLangLegal")), Inputdata[7].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
		
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectContactbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact button");
		Thread.sleep(5000);
		//fill product customisation details
		
		Clickon(getwebelement(xml.getlocator("//locators/ProductName")));
		SendKeys(getwebelement(xml.getlocator("//locators/ProductName")), Inputdata[10].toString());
		Thread.sleep(5000);		
		Clickon(getwebelement(xml.getlocator("//locators/ProductNameClick")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter product name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/ContractRenewal")));
		
		Select(getwebelement(xml.getlocator("//locators/ContractRenewal")), Inputdata[11].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select contract term");
		Thread.sleep(5000);
		
	
		Select(getwebelement(xml.getlocator("//locators/Currency")), Inputdata[12].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select currency");
		Thread.sleep(10000);
		
		SendKeys(getwebelement(xml.getlocator("//locators/HubReference")),"IPC-10135");
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/HubReference")), Keys.TAB);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter hub reference");
		
		Select(getwebelement(xml.getlocator("//locators/HubCountry")), "Australia");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select hub city");
		
		
		// Add B end address//
		
		
		Clickon(getwebelement(xml.getlocator("//locators/AddBendaddress")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on Add b eNd address button");
		Thread.sleep(5000);
		
		
		Clickon(getwebelement(xml.getlocator("//locators/OrganisationSpoke")));
		SendKeys(getwebelement(xml.getlocator("//locators/OrganisationSpoke")), Inputdata[13].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Organization b end name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/StreetSpoke")));
		SendKeys(getwebelement(xml.getlocator("//locators/StreetSpoke")), Inputdata[14].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Street name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/PostalCodeSpoke")));
		SendKeys(getwebelement(xml.getlocator("//locators/PostalCodeSpoke")), Inputdata[15].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Postal code value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/CountrySpoke")));
		SendKeys(getwebelement(xml.getlocator("//locators/CountrySpoke")), Inputdata[16].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter country b end");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/CitySpoke")));
		SendKeys(getwebelement(xml.getlocator("//locators/CitySpoke")), Inputdata[17].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter b end City");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/SaveBEndSpoke")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on b end save button");
		Thread.sleep(5000);
		
		
		Select(getwebelement(xml.getlocator("//locators/BendAccessType")), "Colt Fibre");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select b End Access Type");
		
		
		Clickon(getwebelement(xml.getlocator("//locators/ServcBand")));
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/ServcBandValue")));
	
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select service bandwidth");
		Thread.sleep(5000);
		
		
		Clickon(getwebelement(xml.getlocator("//locators/InstallCharges")));
		SendKeys(getwebelement(xml.getlocator("//locators/InstallCharges")), Inputdata[28].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Install Charges");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/MonthlyCharges")));
		SendKeys(getwebelement(xml.getlocator("//locators/MonthlyCharges")), Inputdata[29].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Monthly Chargese");
		Thread.sleep(5000);
		
		Clickon(getwebelement("//button[@id='AddContact']"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/FirstName")));
		SendKeys(getwebelement(xml.getlocator("//locators/FirstName")), Inputdata[2].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter First Name");
		Thread.sleep(5000);

		Clickon(getwebelement(xml.getlocator("//locators/LastName")));
		SendKeys(getwebelement(xml.getlocator("//locators/LastName")), Inputdata[3].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter last name");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Title")));
		Select(getwebelement(xml.getlocator("//locators/Title")), Inputdata[4].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Email")));
		SendKeys(getwebelement(xml.getlocator("//locators/Email")), Inputdata[5].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Email ");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/TeleNumber")));
		SendKeys(getwebelement(xml.getlocator("//locators/TeleNumber")), Inputdata[6].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(3000);
		
		Clickon(getwebelement(xml.getlocator("//locators/CorrespondenceLang"))); 
		Select(getwebelement(xml.getlocator("//locators/CorrespondenceLang")), "English");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
		Thread.sleep(5000);
		
		
		Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
		Thread.sleep(5000);

		Clickon(getwebelement(xml.getlocator("//locators/btnSave")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on save button");
		Thread.sleep(15000);
		
		safeJavaScriptClick(getwebelement(xml.getlocator("//locators/btnGenerateContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on generate contract button");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Acceptpopbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on accept button");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/btnSubmitToCot")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on submit to Colt button");
		 EOLGeneratingNumber.set(GetText(getwebelement(xml.getlocator("//locators/EOLNumberText"))));
			
		 ExtentTestManager.getTest().log(LogStatus.PASS," Step: Generated EOL Order Reference No: " + EOLGeneratingNumber.get());
			Log.info(EOLGeneratingNumber.get());
	
	}
	
	public void ipDomain(Object[]Inputdata)throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/Neworderbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on New order button");
		Thread.sleep(5000);
		

		//fill contact details
		Clickon(getwebelement(xml.getlocator("//locators/AddContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/OpportunityNumber")));
		SendKeys(getwebelement(xml.getlocator("//locators/OpportunityNumber")), Inputdata[0].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Opportunity Number value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/EOLOCN")));
		SendKeys(getwebelement(xml.getlocator("//locators/EOLOCN")), Inputdata[1].toString());
		//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/EOLOCN")), Keys.TAB);
		
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OCN value");
		Thread.sleep(10000);
		
		Clickon(getwebelement(xml.getlocator("//locators/FirstNameLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/FirstNameLegal")), Inputdata[2].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter First name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/LastNameLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/LastNameLegal")), Inputdata[3].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter last name value");
		
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/TitleLegal")));
		Select(getwebelement(xml.getlocator("//locators/TitleLegal")), Inputdata[4].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/EmailLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/EmailLegal")), Inputdata[5].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Email value");
		
		Thread.sleep(3000);

		Clickon(getwebelement(xml.getlocator("//locators/TeleNumberLegal")));
		SendKeys(getwebelement(xml.getlocator("//locators/TeleNumberLegal")), Inputdata[6].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(3000);
		
		Clickon(getwebelement(xml.getlocator("//locators/CorrespondenceLangLegal")));
		//Select(getwebelement(xml.getlocator("//locators/CorrespondenceLangLegal")), "English");
		Select(getwebelement(xml.getlocator("//locators/CorrespondenceLangLegal")), Inputdata[7].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
		
		Thread.sleep(5000);
		/*
		Clickon(getwebelement(xml.getlocator("//locators/EOLBCN")));
		SendKeys(getwebelement(xml.getlocator("//locators/EOLBCN")), Inputdata[8].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(5000);
		
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000); */
		
		
		Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectContactbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact button");
		Thread.sleep(5000);
		//fill product customisation details
		
		Clickon(getwebelement(xml.getlocator("//locators/ProductName")));
		SendKeys(getwebelement(xml.getlocator("//locators/ProductName")), Inputdata[10].toString());
		Thread.sleep(5000);		
		Clickon(getwebelement(xml.getlocator("//locators/ProductNameClick")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter product name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/ContractRenewal")));
		Select(getwebelement(xml.getlocator("//locators/ContractRenewal")), Inputdata[11].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select contract term");
		Thread.sleep(5000);
		
		Select(getwebelement(xml.getlocator("//locators/Currency")), Inputdata[12].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select currency");
		Thread.sleep(5000);
		
		SendKeys(getwebelement(xml.getlocator("//locators/ExistingReference")), "Automation");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter capacity reference");
		
		
		Clickon(getwebelement("//button[@id='AddContact']"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/FirstName")));
		SendKeys(getwebelement(xml.getlocator("//locators/FirstName")), Inputdata[2].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter First Name");
		Thread.sleep(5000);

		Clickon(getwebelement(xml.getlocator("//locators/LastName")));
		SendKeys(getwebelement(xml.getlocator("//locators/LastName")), Inputdata[3].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter last name");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Title")));
		Select(getwebelement(xml.getlocator("//locators/Title")), Inputdata[4].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Email")));
		SendKeys(getwebelement(xml.getlocator("//locators/Email")), Inputdata[5].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Email ");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/TeleNumber")));
		SendKeys(getwebelement(xml.getlocator("//locators/TeleNumber")), Inputdata[6].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(3000);
		
		Clickon(getwebelement(xml.getlocator("//locators/CorrespondenceLang"))); 
		Select(getwebelement(xml.getlocator("//locators/CorrespondenceLang")), "English");
		//Select(getwebelement(xml.getlocator("//locators/CorrespondenceLang")), Inputdata[7].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
		Thread.sleep(5000);
		
		
		Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
		Thread.sleep(5000);
		
		//Proceeding save operation:
		
		Clickon(getwebelement(xml.getlocator("//locators/InstallCharges")));
		SendKeys(getwebelement(xml.getlocator("//locators/InstallCharges")), Inputdata[28].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Install Charges");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/MonthlyCharges")));
		SendKeys(getwebelement(xml.getlocator("//locators/MonthlyCharges")), Inputdata[29].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Monthly Chargese");
		Thread.sleep(5000);

		
		Clickon(getwebelement(xml.getlocator("//locators/btnSave")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on save button");
		Thread.sleep(15000);
		
		safeJavaScriptClick(getwebelement(xml.getlocator("//locators/btnGenerateContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on generate contract button");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Acceptpopbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on accept button");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/btnSubmitToCot")));
       
		
	 EOLGeneratingNumber.set(GetText(getwebelement(xml.getlocator("//locators/EOLNumberText"))));
		
	 ExtentTestManager.getTest().log(LogStatus.PASS," Step: Generated EOL Order Reference No: " + EOLGeneratingNumber.get());
		Log.info(EOLGeneratingNumber.get());

	}
	
	public void serviceTab() throws InterruptedException, DocumentException, IOException
	{
		// Thread.sleep(15000);
		 do {
				Pagerefresh();
				System.out.println("Page to be refresed");
				Thread.sleep(20000);
			} while (!isElementPresent("//a[text()='My Orders']"));
			waitforPagetobeenable();
			Thread.sleep(10000);
		//Service Tab Click
		try
		{
		Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Service Order Tab");
		}
		catch (Exception e)
		{
		try
		{
		safeJavaScriptClick(getwebelement(xml.getlocator("//locators/ServiceOrderTab")));
		}
		catch (Exception e1)
		{
		e1.printStackTrace();
		}
		}
		waitforPagetobeenable();
		waitForpageload();
		Clickon(getwebelement(xml.getlocator("//locators/SearchSiebel")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on search button");
		waitforPagetobeenable();
		
		Clickon(getwebelement(xml.getlocator("//locators/OrderReference")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on order reference field");
		waitforPagetobeenable();
		
		SendKeys(getwebelement(xml.getlocator("//locators/OrderReferenceField")), EOLGeneratingNumber.get());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter EOL number");
		for(int i=0;i<3;i++)
		{
			Thread.sleep(120000);
		}
		SendkeyusingAction(Keys.ENTER);
	}
	
public void modComOrderEOL(Object[] Inputdata) throws Exception {
		
		System.out.println("Done ModCom Tab");
		Thread.sleep(12000);
		WaitforElementtobeclickable((xml.getlocator("//locators/ModComOrder")));
		Clickon(getwebelement(xml.getlocator("//locators/ModComOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Mod order button");
		Thread.sleep(5000);		
			
		Clickon(getwebelement(xml.getlocator("//locators/ModComOCN")));
		SendKeys(getwebelement(xml.getlocator("//locators/ModComOCN")), Inputdata[1].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OCN value");
		Thread.sleep(5000);		
		
		Clickon(getwebelement(xml.getlocator("//locators/ProductName")));
		SendKeys(getwebelement(xml.getlocator("//locators/ProductName")), Inputdata[34].toString());
		Thread.sleep(5000);		
		Clickon(getwebelement(xml.getlocator("//locators/ModComProductClick")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter product name value");
		Thread.sleep(5000);	
		
		if (Inputdata[10].toString().equalsIgnoreCase("Colt Managed Virtual Firewall")
				|| Inputdata[10].toString().equalsIgnoreCase("Colt Managed Dedicated Firewall")
				|| Inputdata[10].toString().equalsIgnoreCase("Colt Ethernet VPN")
				|| Inputdata[10].toString().equalsIgnoreCase("Colt IP Access")
				|| Inputdata[10].toString().equalsIgnoreCase("Colt Ethernet Line")
				|| Inputdata[10].toString().equalsIgnoreCase("Colt Ethernet Hub")
				|| Inputdata[10].toString().equalsIgnoreCase("Colt Ethernet Spoke")
				|| Inputdata[10].toString().equalsIgnoreCase("Colt Wave") 
			    || Inputdata[10].toString().equalsIgnoreCase("Colt IP Domain")
                || Inputdata[10].toString().equalsIgnoreCase("Colt IP Guardian"))
			
		{
				
		WaitforElementtobeclickable(xml.getlocator("//locators/ModComContractRenewal"));
		Clickon(getwebelement(xml.getlocator("//locators/ModComContractRenewal")));
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/ModComContractRenewalvalue")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Contract renewal flag");
		
		Thread.sleep(5000);	
		
		Clickon(getwebelement(xml.getlocator("//locators/ModComOppNum")));
		SendKeys(getwebelement(xml.getlocator("//locators/ModComOppNum")), Inputdata[0].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Opportunity Number value");
		Thread.sleep(5000);	
				
		Clickon(getwebelement(xml.getlocator("//locators/ModComLegalContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Legal Contact Details");
		
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/ModComFirstName")));
		SendKeys(getwebelement(xml.getlocator("//locators/ModComFirstName")), Inputdata[2].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter First name value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/ModComLastName")));
		SendKeys(getwebelement(xml.getlocator("//locators/ModComLastName")), Inputdata[3].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter last name value");
		Thread.sleep(5000);
				
		Clickon(getwebelement(xml.getlocator("//locators/ModComTitle")));
		Select(getwebelement(xml.getlocator("//locators/ModComTitle")), Inputdata[4].toString());
	//	SendKeys(getwebelement(xml.getlocator("//locators/ModComTitle")), Inputdata[4].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
		Thread.sleep(5000);		
		
		Clickon(getwebelement(xml.getlocator("//locators/ModComEmail")));
		SendKeys(getwebelement(xml.getlocator("//locators/ModComEmail")), Inputdata[5].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Email value");
		Thread.sleep(5000);
				
		Clickon(getwebelement(xml.getlocator("//locators/ModComTelephone")));	
		SendKeys(getwebelement(xml.getlocator("//locators/ModComTelephone")), Inputdata[6].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/ModComCOrespondanceLanguage")));
		Select(getwebelement(xml.getlocator("//locators/ModComCOrespondanceLanguage")), Inputdata[7].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
		Thread.sleep(5000);
	
		Clickon(getwebelement(xml.getlocator("//locators/ModComAddButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
		
		Thread.sleep(5000);
				
		Clickon(getwebelement(xml.getlocator("//locators/ModComBCNChange")));
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/ModComBCNChangeValue")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter BCN Change Value");
		
		
		Clickon(getwebelement(xml.getlocator("//locators/ModComNewBCN")));
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/ModComNewBCN")), Inputdata[36].toString());
	//	Clickon(getwebelement(xml.getlocator("//locators/ModComNewBCNSelect")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(5000);
						
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/ModComTariffChange")));
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/ModComTariffChangeValue")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Tariff Chnge Value");
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/ModComOneOffCharge")));
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/ModComOneoffChargeValue")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter One Off Charge Value");
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/ModComPriceChange")));
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/ModComPriceChangeValue")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Price Change Value");
		Thread.sleep(5000);		
	
		Clickon(getwebelement(xml.getlocator("//locators/ModComEffectiveBSD")));
		Thread.sleep(2000);
		SendkeaboardKeys((getwebelement(xml.getlocator("//locators/ModComEffectiveBSD"))), Keys.ENTER);
	//	Clickon(getwebelement(xml.getlocator("//locators/ModComEffectiveBSD")));
	//	SendKeys(getwebelement(xml.getlocator("//locators/ModComEffectiveBSD")), Inputdata[35].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Effective From BSD");
		Thread.sleep(5000);			
		
		Clickon(getwebelement(xml.getlocator("//locators/ModComOrderNumber")));
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/ModComOrderNumber")), Inputdata[31].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OrderNumber");
		
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/ModComCircuitreference")));
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/ModComCircuitreference")), Inputdata[32].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OrderNumber");
		Thread.sleep(5000);	
		
		Clickon(getwebelement(xml.getlocator("//locators/ModComSavebutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on save button");
		Thread.sleep(15000);	
		
		Clickon(getwebelement(xml.getlocator("//locators/ModComSubmittoCot")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on submit to Colt button");
	
	 
		System.out.println("ModCom Execution successfully run");
		EOLGeneratingNumber.set(GetText(getwebelement(xml.getlocator("//locators/EOLNumberText"))));
		
		 ExtentTestManager.getTest().log(LogStatus.PASS," Step: Generated EOL Order Reference No: " + EOLGeneratingNumber.get());
			Log.info(EOLGeneratingNumber.get());
		
	}	
		
  }
   public void eolMOdTech(Object[] Inputdata) throws Exception
   {
	 
			Clickon(getwebelement(xml.getlocator("//locators/ModTechTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on New order button");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechOCN")));
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechOCN")), Inputdata[1].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OCN value");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechLegalContactDetails")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
			Thread.sleep(3000);
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechFirstName")));
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechFirstName")), Inputdata[2].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter First name value");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ModTechLastName")));
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechLastName")), Inputdata[3].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter last name value");
			Thread.sleep(3000);
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechTitle")));
			Thread.sleep(3000);
			Select(getwebelement(xml.getlocator("//locators/ModTechTitle")), Inputdata[4].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/ModTechEmail")));
			Thread.sleep(3000);
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechEmail")), Inputdata[5].toString());		
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Email value");
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/ModTechTelephoneNumber")));
			Thread.sleep(3000);
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechTelephoneNumber")), Inputdata[6].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/ModTechCorrespondentLanguage")));
			Select(getwebelement(xml.getlocator("//locators/ModTechCorrespondentLanguage")), Inputdata[7].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
			Thread.sleep(3000);
						
			Clickon(getwebelement(xml.getlocator("//locators/ModTechAddButton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact button");
			Thread.sleep(5000);			
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechProductName")));
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechProductName")), Inputdata[10].toString());
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ProductNameClick")));
			//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ProductName")), Keys.ENTER);
		
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter product name value");
			Thread.sleep(5000);
			
			
			// Added If Condition for MVF And MDF Ethernet VPN
			
			
			if (Inputdata[10].toString().equals("Colt Managed Virtual Firewall")
					|| Inputdata[10].toString().equals("Colt Managed Dedicated Firewall"))
				
			{
				//System.out.println("Print product");
				WaitforElementtobeclickable(xml.getlocator("//locators/ModTechContractRenewal"));
				Clickon(getwebelement(xml.getlocator("//locators/ModTechContractRenewal")));
				Thread.sleep(5000);
				Clickon(getwebelement(xml.getlocator("//locators/ModTechContactRenewalDropDownValue")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Contract renewal flag");
				Thread.sleep(5000);
				
				Clickon(getwebelement(xml.getlocator("//locators/ModTechCurrency")));
				Thread.sleep(3000);
				Clickon(getwebelement(xml.getlocator("//locators/ModTechCurrencyValue")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select currency");
				Thread.sleep(5000);
				
				Clickon(getwebelement(xml.getlocator("//locators/ModTechChangeOtherCheckbox")));
				Thread.sleep(5000);	
							
				Clickon(getwebelement(xml.getlocator("//locators/ModTechOrderNumber")));
				Thread.sleep(5000);
				SendKeys(getwebelement(xml.getlocator("//locators/ModTechOrderNumber")), Inputdata[31].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OrderNumber");
				Thread.sleep(5000);		
				Clickon(getwebelement(xml.getlocator("//locators/ModTechCurcuitReference")));
				Thread.sleep(5000);
				SendKeys(getwebelement(xml.getlocator("//locators/ModTechCurcuitReference")), Inputdata[32].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OrderNumber");
				Thread.sleep(5000);	
				
				Clickon(getwebelement(xml.getlocator("//locators/ModTechInstallCharges")));
				Thread.sleep(3000);
				SendKeys(getwebelement(xml.getlocator("//locators/ModTechInstallCharges")), Inputdata[28].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Install Charges");
				Thread.sleep(5000);
				
				Clickon(getwebelement(xml.getlocator("//locators/ModTechMonthlyCharges")));
				Thread.sleep(3000);
				SendKeys(getwebelement(xml.getlocator("//locators/ModTechMonthlyCharges")), Inputdata[29].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Monthly Chargese");
				Thread.sleep(5000);
						
			/*	Clickon(getwebelement(xml.getlocator("//locators/ModTechFastTrackChkBox")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on FastTrack check box");
				Thread.sleep(3000);
				
				
				Clickon(getwebelement(xml.getlocator("//locators/ModTechFastTrackInstallCharges")));
				SendKeys(getwebelement(xml.getlocator("//locators/ModTechFastTrackInstallCharges")), Inputdata[30].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Fast Track Charges");
				Thread.sleep(5000);
				*/
								
				Clickon(getwebelement(xml.getlocator("//locators/btnSave")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on save button");
				Thread.sleep(15000);
						
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on submit to Colt button");
				Clickon(getwebelement(xml.getlocator("//locators/btnSubmitToCot")));
				Thread.sleep(4000);
				
			  
			}	
			
			//Start of elseif for Ethernet Hub
			else if (Inputdata[10].toString().equals("Colt Ethernet Hub"))
			{		
					
			// Need to add code for Contract renewAL
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechContractRenewal")));
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ModTechContactRenewalDropDownValue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Contract renewal flag");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechCurrency")));
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/ModTechCurrencyValue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select currency");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechChangeType")));
			Thread.sleep(5000);		
			
			// A end access type

			WaitforElementtobeclickable((xml.getlocator("//locators/AEndAccessT")));
			Clickon(getwebelement(xml.getlocator("//locators/AEndAccessT")));
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/AEndAccessTypeValue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select A End Access Type");
			Thread.sleep(5000);		
			
			// Service BandWidth
			
			Clickon(getwebelement(xml.getlocator("//locators/ServcBand")));
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ServcBandValueHub")));
		//	Select(getwebelement(xml.getlocator("//locators/ServcBand")), Inputdata[26].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select Router");
			Thread.sleep(5000);			
			
			// A end product customization - Customer Contact for Order/Technical
			// Details*

			WaitforElementtobeclickable((xml.getlocator("//locators/AddContactDetails")));
			Clickon(getwebelement(xml.getlocator("//locators/AddContactDetails")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/FirstName")));
			SendKeys(getwebelement(xml.getlocator("//locators/FirstName")), Inputdata[2].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter First Name");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/LastName")));
			SendKeys(getwebelement(xml.getlocator("//locators/LastName")), Inputdata[3].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter last name");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/Title")));
			Select(getwebelement(xml.getlocator("//locators/Title")), Inputdata[4].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/Email")));
			SendKeys(getwebelement(xml.getlocator("//locators/Email")), Inputdata[5].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Email ");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/TeleNumber")));
			SendKeys(getwebelement(xml.getlocator("//locators/TeleNumber")), Inputdata[6].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
			Thread.sleep(3000);

			Clickon(getwebelement(xml.getlocator("//locators/CorrespondenceLang")));
			Select(getwebelement(xml.getlocator("//locators/CorrespondenceLang")), "English");
			// Select(getwebelement(xml.getlocator("//locators/CorrespondenceLang")),
			// Inputdata[7].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectContact")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
			Thread.sleep(5000);

			// End of Customer contact Tecnical details
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechOrderNumber")));
			Thread.sleep(5000);
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechOrderNumber")), Inputdata[31].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OrderNumber");
			Thread.sleep(5000);		
			Clickon(getwebelement(xml.getlocator("//locators/ModTechCurcuitReference")));
			Thread.sleep(5000);
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechCurcuitReference")), Inputdata[32].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OrderNumber");
			Thread.sleep(5000);		
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechInstallCharges")));
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechInstallCharges")), Inputdata[28].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Install Charges");
			Thread.sleep(3000);
			
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechMonthlyCharges")));
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechMonthlyCharges")), Inputdata[29].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Monthly Chargese");
			Thread.sleep(3000);
			
			
		//	Clickon(getwebelement(xml.getlocator("//locators/ShowAddtnalCharges")));
		//	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on additional charge icon");
		//	Thread.sleep(3000);
			
			
		//	selectCheckbox(getwebelement(xml.getlocator("//locators/FastTrack")),"CHECK");
			Clickon(getwebelement(xml.getlocator("//locators/ModTechFastTrackChkBox")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on FastTrack check box");
			Thread.sleep(3000);
			
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechFastTrackInstallCharges")));
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechFastTrackInstallCharges")), Inputdata[30].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Fast Track Charges");
			Thread.sleep(5000);
			
			
			Clickon(getwebelement(xml.getlocator("//locators/btnSave")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on save button");
			Thread.sleep(15000);
			
				
			Clickon(getwebelement(xml.getlocator("//locators/btnSubmitToCot")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on submit to Colt button");
		Thread.sleep(4000);
			}

			//End of elseif for Ethernet Hub
			
			//Start of elseif for Ethernet Line 
			
			else if (Inputdata[10].toString().equals("Colt Ethernet Line"))
			{		
					
			Clickon(getwebelement(xml.getlocator("//locators/ModTechContractRenewal")));
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ModTechContactRenewalDropDownValue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Contract renewal flag");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechCurrency")));
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/ModTechCurrencyValue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select currency");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechChangeType")));
			Thread.sleep(5000);		
			
			// A end access type

			WaitforElementtobeclickable((xml.getlocator("//locators/AEndAccessT")));
			Clickon(getwebelement(xml.getlocator("//locators/AEndAccessT")));
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/AEndAccessTypeValue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select A End Access Type");
			Thread.sleep(10000);		
			
			WaitforElementtobeclickable((xml.getlocator("//locators/BEndAccessT")));
			Clickon(getwebelement(xml.getlocator("//locators/BEndAccessT")));
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/BEndAccessTypeValue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select B End Access Type");
			Thread.sleep(5000);	
			
			// Service BandWidth
			
			Clickon(getwebelement(xml.getlocator("//locators/ServcBand")));
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ServcBandValue")));
		//	Select(getwebelement(xml.getlocator("//locators/ServcBand")), Inputdata[26].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select Router");
			Thread.sleep(5000);			
			
			
			
			
			// A end product customization - Customer Contact for Order/Technical
			// Details*

			WaitforElementtobeclickable((xml.getlocator("//locators/AddContactDetails")));
			Clickon(getwebelement(xml.getlocator("//locators/AddContactDetails")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/FirstName")));
			SendKeys(getwebelement(xml.getlocator("//locators/FirstName")), Inputdata[2].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter First Name");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/LastName")));
			SendKeys(getwebelement(xml.getlocator("//locators/LastName")), Inputdata[3].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter last name");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/Title")));
			Select(getwebelement(xml.getlocator("//locators/Title")), Inputdata[4].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/Email")));
			SendKeys(getwebelement(xml.getlocator("//locators/Email")), Inputdata[5].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Email ");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/TeleNumber")));
			SendKeys(getwebelement(xml.getlocator("//locators/TeleNumber")), Inputdata[6].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
			Thread.sleep(3000);

			Clickon(getwebelement(xml.getlocator("//locators/CorrespondenceLang")));
			Select(getwebelement(xml.getlocator("//locators/CorrespondenceLang")), "English");
			// Select(getwebelement(xml.getlocator("//locators/CorrespondenceLang")),
			// Inputdata[7].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectContact")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
			Thread.sleep(5000);

			// End of Customer contact Tecnical details
			
			
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechOrderNumber")));
			Thread.sleep(5000);
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechOrderNumber")), Inputdata[31].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OrderNumber");
			Thread.sleep(5000);		
			Clickon(getwebelement(xml.getlocator("//locators/ModTechCurcuitReference")));
			Thread.sleep(5000);
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechCurcuitReference")), Inputdata[32].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OrderNumber");
			Thread.sleep(5000);		
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechInstallCharges")));
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechInstallCharges")), Inputdata[28].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Install Charges");
			Thread.sleep(3000);
			
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechMonthlyCharges")));
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechMonthlyCharges")), Inputdata[29].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Monthly Chargese");
			Thread.sleep(3000);
			
			
		//	Clickon(getwebelement(xml.getlocator("//locators/ShowAddtnalCharges")));
		//	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on additional charge icon");
		//	Thread.sleep(3000);
			
			
		//	selectCheckbox(getwebelement(xml.getlocator("//locators/FastTrack")),"CHECK");
			Clickon(getwebelement(xml.getlocator("//locators/ModTechFastTrackChkBox")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on FastTrack check box");
			Thread.sleep(3000);
			
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechFastTrackInstallCharges")));
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechFastTrackInstallCharges")), Inputdata[30].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Fast Track Charges");
			Thread.sleep(5000);
			
			
			Clickon(getwebelement(xml.getlocator("//locators/btnSave")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on save button");
			Thread.sleep(15000);
			
				
			Clickon(getwebelement(xml.getlocator("//locators/btnSubmitToCot")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on submit to Colt button");
	       Thread.sleep(4000);
			}
			
			//End of elseif for Ethernet Line
			
			//Start of Colt wave
			else if (Inputdata[10].toString().equals("Colt Wave"))
				
			{		
				
				Clickon(getwebelement(xml.getlocator("//locators/ModTechContractRenewal")));
				Thread.sleep(5000);
				Clickon(getwebelement(xml.getlocator("//locators/ModTechContactRenewalDropDownValue")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Contract renewal flag");
				Thread.sleep(5000);
				
				Clickon(getwebelement(xml.getlocator("//locators/ModTechCurrency")));
				Thread.sleep(3000);
				Clickon(getwebelement(xml.getlocator("//locators/ModTechCurrencyValue")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select currency");
				Thread.sleep(5000);
				
				Clickon(getwebelement(xml.getlocator("//locators/ModTechChangeType")));
				Thread.sleep(5000);		
				
				// A end access type

				WaitforElementtobeclickable((xml.getlocator("//locators/AEndAccessT")));
				Clickon(getwebelement(xml.getlocator("//locators/AEndAccessT")));
				Thread.sleep(5000);
				Clickon(getwebelement(xml.getlocator("//locators/AEndAccessTypeValue")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select A End Access Type");
				Thread.sleep(10000);		
				
				WaitforElementtobeclickable((xml.getlocator("//locators/BEndAccessT")));
				Clickon(getwebelement(xml.getlocator("//locators/BEndAccessT")));
				Thread.sleep(5000);
				Clickon(getwebelement(xml.getlocator("//locators/BEndAccessTypeValue")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select B End Access Type");
				Thread.sleep(5000);	
				
				// Service BandWidth
				
				Clickon(getwebelement(xml.getlocator("//locators/ServcBand")));
				Thread.sleep(5000);
				Clickon(getwebelement(xml.getlocator("//locators/ServcBandValueEthernetWave")));
			//	Select(getwebelement(xml.getlocator("//locators/ServcBand")), Inputdata[26].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select Router");
				Thread.sleep(5000);			
				
				
				
				
				// A end product customization - Customer Contact for Order/Technical
				// Details*

				WaitforElementtobeclickable((xml.getlocator("//locators/AddContactDetails")));
				Clickon(getwebelement(xml.getlocator("//locators/AddContactDetails")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
				Thread.sleep(5000);

				Clickon(getwebelement(xml.getlocator("//locators/FirstName")));
				SendKeys(getwebelement(xml.getlocator("//locators/FirstName")), Inputdata[2].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter First Name");
				Thread.sleep(5000);

				Clickon(getwebelement(xml.getlocator("//locators/LastName")));
				SendKeys(getwebelement(xml.getlocator("//locators/LastName")), Inputdata[3].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter last name");
				Thread.sleep(5000);

				Clickon(getwebelement(xml.getlocator("//locators/Title")));
				Select(getwebelement(xml.getlocator("//locators/Title")), Inputdata[4].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
				Thread.sleep(5000);

				Clickon(getwebelement(xml.getlocator("//locators/Email")));
				SendKeys(getwebelement(xml.getlocator("//locators/Email")), Inputdata[5].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Email ");
				Thread.sleep(5000);

				Clickon(getwebelement(xml.getlocator("//locators/TeleNumber")));
				SendKeys(getwebelement(xml.getlocator("//locators/TeleNumber")), Inputdata[6].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
				Thread.sleep(3000);

				Clickon(getwebelement(xml.getlocator("//locators/CorrespondenceLang")));
				Select(getwebelement(xml.getlocator("//locators/CorrespondenceLang")), "English");
				// Select(getwebelement(xml.getlocator("//locators/CorrespondenceLang")),
				// Inputdata[7].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
				Thread.sleep(5000);

				Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectContact")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
				Thread.sleep(5000);

				// End of Customer contact Tecnical details
				
				
				
				Clickon(getwebelement(xml.getlocator("//locators/ModTechOrderNumber")));
				Thread.sleep(5000);
				SendKeys(getwebelement(xml.getlocator("//locators/ModTechOrderNumber")), Inputdata[31].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OrderNumber");
				Thread.sleep(5000);		
				Clickon(getwebelement(xml.getlocator("//locators/ModTechCurcuitReference")));
				Thread.sleep(5000);
				SendKeys(getwebelement(xml.getlocator("//locators/ModTechCurcuitReference")), Inputdata[32].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OrderNumber");
				Thread.sleep(5000);		
				
				Clickon(getwebelement(xml.getlocator("//locators/ModTechInstallCharges")));
				SendKeys(getwebelement(xml.getlocator("//locators/ModTechInstallCharges")), Inputdata[28].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Install Charges");
				Thread.sleep(3000);
				
				
				Clickon(getwebelement(xml.getlocator("//locators/ModTechMonthlyCharges")));
				SendKeys(getwebelement(xml.getlocator("//locators/ModTechMonthlyCharges")), Inputdata[29].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Monthly Chargese");
				Thread.sleep(3000);
				
				
			//	Clickon(getwebelement(xml.getlocator("//locators/ShowAddtnalCharges")));
			//	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on additional charge icon");
			//	Thread.sleep(3000);
				
				
			//	selectCheckbox(getwebelement(xml.getlocator("//locators/FastTrack")),"CHECK");
				Clickon(getwebelement(xml.getlocator("//locators/ModTechFastTrackChkBox")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on FastTrack check box");
				Thread.sleep(3000);
				
				
				Clickon(getwebelement(xml.getlocator("//locators/ModTechFastTrackInstallCharges")));
				SendKeys(getwebelement(xml.getlocator("//locators/ModTechFastTrackInstallCharges")), Inputdata[30].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Fast Track Charges");
				Thread.sleep(5000);
				
				
				Clickon(getwebelement(xml.getlocator("//locators/btnSave")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on save button");
				Thread.sleep(15000);
				
					
				Clickon(getwebelement(xml.getlocator("//locators/btnSubmitToCot")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on submit to Colt button");
				Thread.sleep(4000);
				}
			
				//End of Colt wave
				
			//Start of elseif for Ethernet Spoke
			else if (Inputdata[10].toString().equals("Colt Ethernet Spoke"))
			{		
					
			Clickon(getwebelement(xml.getlocator("//locators/ModTechContractRenewal")));
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ModTechContactRenewalDropDownValue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Contract renewal flag");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechCurrency")));
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/ModTechCurrencyValue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select currency");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechChangeType")));
			Thread.sleep(5000);		
			
			// A end access type
	/*
			WaitforElementtobeclickable((xml.getlocator("//locators/AEndAccessT")));
			Clickon(getwebelement(xml.getlocator("//locators/AEndAccessT")));
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/AEndAccessTypeValue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select A End Access Type");
			Thread.sleep(10000);		*/
			
			WaitforElementtobeclickable((xml.getlocator("//locators/BEndAccessT")));
			Clickon(getwebelement(xml.getlocator("//locators/BEndAccessT")));
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/BEndAccessTypeValue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select B End Access Type");
			Thread.sleep(5000);	
			
			// Service BandWidth
			
			Clickon(getwebelement(xml.getlocator("//locators/ServcBand")));
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ServcBandValue")));
		//	Select(getwebelement(xml.getlocator("//locators/ServcBand")), Inputdata[26].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select Router");
			Thread.sleep(5000);			
			
			// A end product customization - Customer Contact for Order/Technical
			// Details*

			WaitforElementtobeclickable((xml.getlocator("//locators/AddContactDetails")));
			Clickon(getwebelement(xml.getlocator("//locators/AddContactDetails")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/FirstName")));
			SendKeys(getwebelement(xml.getlocator("//locators/FirstName")), Inputdata[2].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter First Name");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/LastName")));
			SendKeys(getwebelement(xml.getlocator("//locators/LastName")), Inputdata[3].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter last name");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/Title")));
			Select(getwebelement(xml.getlocator("//locators/Title")), Inputdata[4].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/Email")));
			SendKeys(getwebelement(xml.getlocator("//locators/Email")), Inputdata[5].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Email ");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/TeleNumber")));
			SendKeys(getwebelement(xml.getlocator("//locators/TeleNumber")), Inputdata[6].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
			Thread.sleep(3000);

			Clickon(getwebelement(xml.getlocator("//locators/CorrespondenceLang")));
			Select(getwebelement(xml.getlocator("//locators/CorrespondenceLang")), "English");
			// Select(getwebelement(xml.getlocator("//locators/CorrespondenceLang")),
			// Inputdata[7].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectContact")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
			Thread.sleep(5000);

			// End of Customer contact Tecnical details
					
			Clickon(getwebelement(xml.getlocator("//locators/ModTechOrderNumber")));
			Thread.sleep(5000);
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechOrderNumber")), Inputdata[31].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OrderNumber");
			Thread.sleep(5000);		
			Clickon(getwebelement(xml.getlocator("//locators/ModTechCurcuitReference")));
			Thread.sleep(5000);
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechCurcuitReference")), Inputdata[32].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OrderNumber");
			Thread.sleep(5000);		
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechInstallCharges")));
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechInstallCharges")), Inputdata[28].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Install Charges");
			Thread.sleep(3000);
			
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechMonthlyCharges")));
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechMonthlyCharges")), Inputdata[29].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Monthly Chargese");
			Thread.sleep(3000);
			
			
		//	Clickon(getwebelement(xml.getlocator("//locators/ShowAddtnalCharges")));
		//	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on additional charge icon");
		//	Thread.sleep(3000);
			
			
		//	selectCheckbox(getwebelement(xml.getlocator("//locators/FastTrack")),"CHECK");
			Clickon(getwebelement(xml.getlocator("//locators/ModTechFastTrackChkBox")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on FastTrack check box");
			Thread.sleep(3000);
			
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechFastTrackInstallCharges")));
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechFastTrackInstallCharges")), Inputdata[30].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Fast Track Charges");
			Thread.sleep(5000);
			
			
			Clickon(getwebelement(xml.getlocator("//locators/btnSave")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on save button");
			Thread.sleep(15000);
			
				
			Clickon(getwebelement(xml.getlocator("//locators/btnSubmitToCot")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on submit to Colt button");
		Thread.sleep(4000);
			}

			//End of elseif for Ethernet Spoke
			else if(Inputdata[10].toString().equalsIgnoreCase("Colt IP Domain") ||
					Inputdata[10].toString().equalsIgnoreCase("Colt IP Guardian"))
			{
				Clickon(getwebelement(xml.getlocator("//locators/ModTechContractRenewal")));
				Thread.sleep(5000);
				Clickon(getwebelement(xml.getlocator("//locators/ModTechContactRenewalDropDownValue")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Contract renewal flag");
				Thread.sleep(5000);
				
				Clickon(getwebelement(xml.getlocator("//locators/ModTechCurrency")));
				Thread.sleep(3000);
				Clickon(getwebelement(xml.getlocator("//locators/ModTechCurrencyValue")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select currency");
				Thread.sleep(5000);
				
				Clickon(getwebelement(xml.getlocator("//locators/ModtechOtherCheckBox")));
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select other checkbox");
				Thread.sleep(3000);
				
				
				Clickon(getwebelement(xml.getlocator("//locators/ModTechOrderNumber")));
				Thread.sleep(5000);
				SendKeys(getwebelement(xml.getlocator("//locators/ModTechOrderNumber")), Inputdata[31].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OrderNumber");
				Thread.sleep(5000);		
				Clickon(getwebelement(xml.getlocator("//locators/ModTechCurcuitReference")));
				Thread.sleep(5000);
				SendKeys(getwebelement(xml.getlocator("//locators/ModTechCurcuitReference")), Inputdata[32].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OrderNumber");
				Thread.sleep(5000);		
				
				Clickon(getwebelement(xml.getlocator("//locators/ModTechInstallCharges")));
				SendKeys(getwebelement(xml.getlocator("//locators/ModTechInstallCharges")), Inputdata[28].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Install Charges");
				Thread.sleep(3000);
				
				
				Clickon(getwebelement(xml.getlocator("//locators/ModTechMonthlyCharges")));
				SendKeys(getwebelement(xml.getlocator("//locators/ModTechMonthlyCharges")), Inputdata[29].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Monthly Chargese");
				Thread.sleep(3000);
				
				
				
				Clickon(getwebelement(xml.getlocator("//locators/btnSave")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on save button");
				Thread.sleep(15000);
				
					
				Clickon(getwebelement(xml.getlocator("//locators/btnSubmitToCot")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on submit to Colt button");
			Thread.sleep(4000);
			} 
			// end of else-if loop of domain and guardian
			else
			{		
					
			// Need to add code for Contract renewAL
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechContractRenewal")));
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ModTechContactRenewalDropDownValue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Contract renewal flag");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechCurrency")));
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/ModTechCurrencyValue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select currency");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechChangeType")));
			Thread.sleep(5000);		
			
			// A end access type

			WaitforElementtobeclickable((xml.getlocator("//locators/AEndAccessT")));
			Clickon(getwebelement(xml.getlocator("//locators/AEndAccessT")));
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/AEndAccessTypeValue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select A End Access Type");
			Thread.sleep(5000);		
			
			// Service BandWidth
			
			Clickon(getwebelement(xml.getlocator("//locators/ServcBand")));
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ServcBandValue")));
		//	Select(getwebelement(xml.getlocator("//locators/ServcBand")), Inputdata[26].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select Router");
			Thread.sleep(5000);			
			
			
			
			
			// A end product customization - Customer Contact for Order/Technical
			// Details*

			WaitforElementtobeclickable((xml.getlocator("//locators/AddContactDetails")));
			Clickon(getwebelement(xml.getlocator("//locators/AddContactDetails")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/FirstName")));
			SendKeys(getwebelement(xml.getlocator("//locators/FirstName")), Inputdata[2].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter First Name");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/LastName")));
			SendKeys(getwebelement(xml.getlocator("//locators/LastName")), Inputdata[3].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter last name");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/Title")));
			Select(getwebelement(xml.getlocator("//locators/Title")), Inputdata[4].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/Email")));
			SendKeys(getwebelement(xml.getlocator("//locators/Email")), Inputdata[5].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Email ");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/TeleNumber")));
			SendKeys(getwebelement(xml.getlocator("//locators/TeleNumber")), Inputdata[6].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
			Thread.sleep(3000);

			Clickon(getwebelement(xml.getlocator("//locators/CorrespondenceLang")));
			Select(getwebelement(xml.getlocator("//locators/CorrespondenceLang")), "English");
			// Select(getwebelement(xml.getlocator("//locators/CorrespondenceLang")),
			// Inputdata[7].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/SaveAndSelectContact")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
			Thread.sleep(5000);

			// End of Customer contact Tecnical details
			
			
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechOrderNumber")));
			Thread.sleep(5000);
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechOrderNumber")), Inputdata[31].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OrderNumber");
			Thread.sleep(5000);		
			Clickon(getwebelement(xml.getlocator("//locators/ModTechCurcuitReference")));
			Thread.sleep(5000);
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechCurcuitReference")), Inputdata[32].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OrderNumber");
			Thread.sleep(5000);		
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechInstallCharges")));
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechInstallCharges")), Inputdata[28].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Install Charges");
			Thread.sleep(3000);
			
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechMonthlyCharges")));
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechMonthlyCharges")), Inputdata[29].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Monthly Chargese");
			Thread.sleep(3000);
			
			
		//	Clickon(getwebelement(xml.getlocator("//locators/ShowAddtnalCharges")));
		//	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on additional charge icon");
		//	Thread.sleep(3000);
			
			
		//	selectCheckbox(getwebelement(xml.getlocator("//locators/FastTrack")),"CHECK");
			Clickon(getwebelement(xml.getlocator("//locators/ModTechFastTrackChkBox")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on FastTrack check box");
			Thread.sleep(3000);
			
			
			Clickon(getwebelement(xml.getlocator("//locators/ModTechFastTrackInstallCharges")));
			SendKeys(getwebelement(xml.getlocator("//locators/ModTechFastTrackInstallCharges")), Inputdata[30].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Fast Track Charges");
			Thread.sleep(5000);
			
			
			Clickon(getwebelement(xml.getlocator("//locators/btnSave")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on save button");
			Thread.sleep(15000);
			
				
			Clickon(getwebelement(xml.getlocator("//locators/btnSubmitToCot")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on submit to Colt button");
			Thread.sleep(4000);
			
			
			}
	}	
   }

