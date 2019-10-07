package ScriptHelper;

import java.awt.Robot;
import java.awt.event.KeyEvent;

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
		
		Clickon(getwebelement(xml.getlocator("//locators/Currency"))); 
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
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select Router");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/router")));
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/routerValue")));
	//	Select(getwebelement(xml.getlocator("//locators/router")), Inputdata[25].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select Service Bandwidth");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/Billingtype")));
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/BillingtypeValue")));
	//	Select(getwebelement(xml.getlocator("//locators/Billingtype")), Inputdata[27].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select Billing Type");
		Thread.sleep(5000);
		
	
		//A end product customization  -  Customer Contact for Order/Technical Details*
		
		WaitforElementtobeclickable((xml.getlocator("//locators/AEndTechContSave")));
		Clickon(getwebelement(xml.getlocator("//locators/AEndTechContSave")));
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
		Thread.sleep(5000);
		
		
		Clickon(getwebelement(xml.getlocator("//locators/btnGenerateContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on generate contract button");
		Thread.sleep(5000);
		
		
		Clickon(getwebelement(xml.getlocator("//locators/Acceptpopbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on accept button");
		Thread.sleep(5000);
		
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on submit to Colt button");
		Clickon(getwebelement(xml.getlocator("//locators/btnSubmitToCot")));
		Thread.sleep(20000);


//	    SendKeys("newOrder" + ((String) genData).generateRandomAlphaNumeric(10)); // Here I'm randomly generating the Order, I need to retrieve what I type here in the next method
	    String createNewEOLOrder = getAttribute("value"); 
	   
	    Thread.sleep(3000);
	
	
	}
		
	private String getAttribute(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public void modTechOrder(Object[] Inputdata) throws Exception {
		
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
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter product name value");
		Thread.sleep(5000);
						
		Clickon(getwebelement(xml.getlocator("//locators/ModTechCurrency")));
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/ModTechCurrencyValue")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select currency");
		Thread.sleep(5000);
		
		Clickon(getwebelement(xml.getlocator("//locators/ModTechOrderNumber")));
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/ModTechOrderNumber")), Inputdata[31].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OrderNumber");
				
		Clickon(getwebelement(xml.getlocator("//locators/ModTechCurcuitReference")));
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/ModTechCurcuitReference")), Inputdata[32].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OrderNumber");
				
		
		Clickon(getwebelement(xml.getlocator("//locators/ModTechInstallCharges")));
		SendKeys(getwebelement(xml.getlocator("//locators/ModTechInstallCharges")), Inputdata[28].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Install Charges");
		Thread.sleep(3000);
		
		
		Clickon(getwebelement(xml.getlocator("//locators/ModTechMonthlyCharges")));
		SendKeys(getwebelement(xml.getlocator("//locators/ModTechMonthlyCharges")), Inputdata[29].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Monthly Chargese");
		Thread.sleep(3000);
		
		
		Clickon(getwebelement(xml.getlocator("//locators/ShowAddtnalCharges")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on additional charge icon");
		Thread.sleep(3000);
		
		
	//	selectCheckbox(getwebelement(xml.getlocator("//locators/FastTrack")),"CHECK");
		Clickon(getwebelement(xml.getlocator("//locators/FastTrack")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on FastTrack check box");
		Thread.sleep(3000);
		
		
		Clickon(getwebelement(xml.getlocator("//locators/FastTrackCharges")));
		SendKeys(getwebelement(xml.getlocator("//locators/FastTrackCharges")), Inputdata[30].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Fast Track Charges");
		Thread.sleep(5000);
		
		
		Clickon(getwebelement(xml.getlocator("//locators/btnSave")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on save button");
		Thread.sleep(5000);
		
			
		Clickon(getwebelement(xml.getlocator("//locators/btnSubmitToCot")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on submit to Colt button");
		Thread.sleep(20000);
	}
	
	
	public void modComOrder(Object[] Inputdata) throws Exception {
		
		Clickon(getwebelement(xml.getlocator("//locators/ModComOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Mod order button");
		Thread.sleep(5000);
		
			
		Clickon(getwebelement(xml.getlocator("//locators/OpportunityNumber")));
		SendKeys(getwebelement(xml.getlocator("//locators/OpportunityNumber")), Inputdata[0].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Opportunity Number value");

		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/COntractRenewalFlag")));
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/COntractRenewalFlagValue")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Contract renewal flag");
		
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/ProductName")));
		SendKeys(getwebelement(xml.getlocator("//locators/ProductName")), Inputdata[10].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter product name value");
		Thread.sleep(5000);				
		
		Clickon(getwebelement(xml.getlocator("//locators/ModComOCN")));
		SendKeys(getwebelement(xml.getlocator("//locators/ModComOCN")), Inputdata[1].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OCN value");
		Thread.sleep(5000);	
		
		Clickon(getwebelement(xml.getlocator("//locators/ModComLegalContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Legal Contact Details");
		
		Thread.sleep(3000);
		
		Clickon(getwebelement(xml.getlocator("//locators/ModComFirstName")));
		SendKeys(getwebelement(xml.getlocator("//locators/ModComFirstName")), Inputdata[2].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter First name value");
		Thread.sleep(3000);
		
		Clickon(getwebelement(xml.getlocator("//locators/ModComLastName")));
		SendKeys(getwebelement(xml.getlocator("//locators/ModComLastName")), Inputdata[3].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter last name value");
		Thread.sleep(3000);
		
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select title");
		Select(getwebelement(xml.getlocator("//locators/ModComTitle")), Inputdata[4].toString());
		Thread.sleep(3000);
		
		
		Clickon(getwebelement(xml.getlocator("//locators/ModComEmail")));
		SendKeys(getwebelement(xml.getlocator("//locators/ModComEmail")), Inputdata[5].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Email value");
		Thread.sleep(3000);
				
		Clickon(getwebelement(xml.getlocator("//locators/ModComTelephone")));	
		SendKeys(getwebelement(xml.getlocator("//locators/ModComTelephone")), Inputdata[6].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter telephone number value");
		Thread.sleep(3000);
		
		Clickon(getwebelement(xml.getlocator("//locators/ModComCOrespondanceLanguage")));
		Select(getwebelement(xml.getlocator("//locators/ModComCOrespondanceLanguage")), Inputdata[7].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: select corresponding language");
		Thread.sleep(3000);
	
		Clickon(getwebelement(xml.getlocator("//locators/ModComAddButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on add contact icon");
		
		Thread.sleep(5000);
				
		Clickon(getwebelement(xml.getlocator("//locators/ModComBCNChange")));
		Thread.sleep(1000);
		Clickon(getwebelement(xml.getlocator("//locators/ModComBCNChangeValue")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter BCN Change Value");
		
		Thread.sleep(1000);
		Clickon(getwebelement(xml.getlocator("//locators/ModComTariffChange")));
		Thread.sleep(1000);
		Clickon(getwebelement(xml.getlocator("//locators/ModComTariffChangeValue")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Tariff Chnge Value");
		Thread.sleep(1000);
		Clickon(getwebelement(xml.getlocator("//locators/ModComOneOffCharge")));
		Thread.sleep(1000);
		Clickon(getwebelement(xml.getlocator("//locators/ModComOneoffChargeValue")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter One Off Charge Value");
		Thread.sleep(1000);
		Clickon(getwebelement(xml.getlocator("//locators/ModComPriceChange")));
		Thread.sleep(1000);
		Clickon(getwebelement(xml.getlocator("//locators/ModComPriceChangeValue")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Price Change Value");
		Thread.sleep(1000);		
	
		Clickon(getwebelement(xml.getlocator("//locators/ModComEffectiveBCD")));
		Thread.sleep(1000);
		SendKeys(getwebelement(xml.getlocator("//locators/ModComEffectiveBCD")), Inputdata[33].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter Effective From BSD");
		
		//////// need to change data input
		
		
		Clickon(getwebelement(xml.getlocator("//locators/ModComOrderNumber")));
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/ModComOrderNumber")), Inputdata[31].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OrderNumber");
		
		
		Clickon(getwebelement(xml.getlocator("//locators/ModComCircuitreference")));
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/ModComCircuitreference")), Inputdata[32].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter OrderNumber");
				
		
		Clickon(getwebelement(xml.getlocator("//locators/ModComSavebutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on save button");
		Thread.sleep(5000);
	/*	
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on generate contract button");
		Clickon(getwebelement(xml.getlocator("//locators/btnGenerateContact")));
		Thread.sleep(5000);
		
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on accept button");
		Clickon(getwebelement(xml.getlocator("//locators/Acceptpopbutton")));
		Thread.sleep(5000);
		*/
		
		Clickon(getwebelement(xml.getlocator("//locators/ModComSubmittoCot")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click on submit to Colt button");
		Thread.sleep(20000);
	}	
	
	
	
}
