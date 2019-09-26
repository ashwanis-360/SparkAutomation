package ScriptHelper;

import java.io.IOException;
import java.util.Random;

import org.dom4j.DocumentException;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import Driver.DriverHelper;
import Driver.Log;
import Driver.XMLReader;
import Reporter.ExtentTestManager;

public class NewOrderOnnetHelper extends DriverHelper {

	String timeStamp = TimeStamp();

	public NewOrderOnnetHelper(WebDriver dr) {
		super(dr);

	}

	WebElement el;

	XMLReader xml = new XMLReader("src\\Locators\\SiebelOrder.xml");
	XMLReader xml2 = new XMLReader("src\\Locators\\CloudUc.xml");
	XMLReader xmlIP = new XMLReader("src\\Locators\\IPVoiceSolution.xml");
	XMLReader xml3 = new XMLReader("src\\Locators\\SiebelOrderEtherline.xml"); // added by shivananda
	XMLReader xmlHns = new XMLReader("src\\Locators\\EtherNetHubSpoke.xml");

	public void accountTabDetails(Object[] Inputdata) throws Exception {

		Thread.sleep(8000);
		System.out.println("Page to be refresed");

		do {
			Pagerefresh();
			System.out.println("Page to be refresed");
			Thread.sleep(20000);
		} while (!isElementPresent("//a[text()='My Orders']"));
		waitforPagetobeenable();
		Thread.sleep(10000);
		try {
			Clickon(getwebelement(xml.getlocator("//locators/Accounts")));
		} catch (Exception e) {
			try {
				safeJavaScriptClick(getwebelement(xml.getlocator("//locators/Accounts")));
			} catch (Exception e1) {

				e1.printStackTrace();
			}
		}
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Accounts");
		System.out.println(Inputdata[0].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/OCNfield")), Inputdata[0].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter OCN field");
		Clickon(getwebelement(xml.getlocator("//locators/GoButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on GoButton");
		waitforPagetobeenable();
		Thread.sleep(5000);

		Clickon(getwebelement(xml.getlocator("//locators/AccountName").replace("OCN", Inputdata[0].toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on AccountName");
		waitforPagetobeenable();
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/InstalledAssetNew")));
		waitforPagetobeenable();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Installed Asset New");

	}

	public void createCustomerOrder(Object[] Inputdata) throws Exception {

		System.out.println("enter into new order loop");
		SendKeys(getwebelement(xml.getlocator("//locators/OpportunityNo")), Inputdata[1].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Opportunity No");

		SendKeys(getwebelement(xml.getlocator("//locators/RequestReceivedDate")), CurrentDate());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Request Received Date");
		SendKeys(getwebelement(xml.getlocator("//locators/DeliveryChannel")), Inputdata[3].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Delivery Channel");

		WaitforElementtobeclickable(xml.getlocator("//locators/OrderingPartySearch"));
		Clickon(getwebelement(xml.getlocator("//locators/OrderingPartySearch")));
		waitforPagetobeenable();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Ordering Party Search");
		WaitforElementtobeclickable(xml.getlocator("//locators/PartySearchPopupDropdown"));
		Clickon(getwebelement(xml.getlocator("//locators/PartySearchPopupDropdown")));

		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Party Search Popup Dropdown");
		WaitforElementtobeclickable(xml.getlocator("//locators/PartyName"));
		Clickon(getwebelement(xml.getlocator("//locators/PartyName")));

		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Party Name");
		SendKeys(getwebelement(xml.getlocator("//locators/InputPartyname")), Inputdata[4].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Party Name");
		WaitforElementtobeclickable(xml.getlocator("//locators/PickAccntOk"));
		Clickon(getwebelement(xml.getlocator("//locators/PickAccntOk")));

		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Account Ok");
		waitforPagetobeenable();
		WaitforElementtobeclickable(xml.getlocator("//locators/OrderingPartyAddrSearch"));
		Clickon(getwebelement(xml.getlocator("//locators/OrderingPartyAddrSearch")));
		waitforPagetobeenable();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Odering Party Address Search");
		WaitforElementtobeclickable(xml.getlocator("//locators/OrderingPartyAddrSearchDropdown"));
		Clickon(getwebelement(xml.getlocator("//locators/OrderingPartyAddrSearchDropdown")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Ordering Party Address Search Dropdown");
		WaitforElementtobeclickable(xml.getlocator("//locators/PartyAddr"));
		Clickon(getwebelement(xml.getlocator("//locators/PartyAddr")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Ordering Party Address");
		SendKeys(getwebelement(xml.getlocator("//locators/InputPartyAddr")), Inputdata[5].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Input Party Address");
		Thread.sleep(3000);
		WaitforElementtobeclickable(xml.getlocator("//locators/PickAddrSearch"));
		Clickon(getwebelement(xml.getlocator("//locators/PickAddrSearch")));
		waitforPagetobeenable();
		Thread.sleep(2000);
		WaitforElementtobeclickable(xml.getlocator("//locators/PickAddrSubmit1"));
		Clickon(getwebelement(xml.getlocator("//locators/PickAddrSubmit1")));

		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Address Submit");
		Thread.sleep(2000);
		WaitforElementtobeclickable(xml.getlocator("//locators/OrderingPartyContactSearch"));
		Clickon(getwebelement(xml.getlocator("//locators/OrderingPartyContactSearch")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Ordering Party Contact Search");
		WaitforElementtobeclickable(xml.getlocator("//locators/PartyContactPopupDropdown"));
		Clickon(getwebelement(xml.getlocator("//locators/PartyContactPopupDropdown")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Party Contact Popup Dropdown");
		waitforPagetobeenable();
		waitForpageload();
		System.out.println("page load successfully of party contact");

		WaitforElementtobeclickable(xml.getlocator("//locators/LastName"));

		safeJavaScriptClick(getwebelement(xml.getlocator("//locators/LastName")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on First Name");
		SendKeys(getwebelement(xml.getlocator("//locators/InputFirstname")), Inputdata[6].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Input First Name");
		Clickon(getwebelement(xml.getlocator("//locators/PickContactSearch")));
		WaitforElementtobeclickable(xml.getlocator("//locators/FirstnameSubmit"));
		Clickon(getwebelement(xml.getlocator("//locators/FirstnameSubmit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on First Name Submit");
		System.out.println("Sales Channel Print");
		Thread.sleep(4000);
		SendKeys(getwebelement(xml.getlocator("//locators/SalesChannel")), Inputdata[7].toString());

		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Sales Channel");
		Thread.sleep(5000);
		WaitforElementtobeclickable(xml.getlocator("//locators/NewServiceOrder"));
		Clickon(getwebelement(xml.getlocator("//locators/NewServiceOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on New Service Order");
		waitForpageload();
		waitforPagetobeenable();
	}

	public void productSelectionHelper(Object[] Inputdata) throws InterruptedException, DocumentException {

		try {
			Clickon(getwebelement(
					xml.getlocator("//locators/ProductSelection").replace("ProductName", Inputdata[8].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add " + Inputdata[8].toString());

		} catch (Exception e) {
			Clickon(getwebelement(xml.getlocator("//locators/ProductSelectionArrow")));
			Clickon(getwebelement(
					xml.getlocator("//locators/ProductSelection").replace("ProductName", Inputdata[8].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add " + Inputdata[8].toString());

		}

	}

	public void openServiceOrderNumber() throws Exception {
		ServiceOrder.set(Gettext(getwebelement(xml.getlocator("//locators/ServiceOrderReferenceNo"))));
		ExtentTestManager.getTest().log(LogStatus.PASS,
				" Step: Generated Service Order Reference No: " + ServiceOrder.get());
		Log.info(ServiceOrder.get());

		Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderReferenceNo")));
		waitForpageload(); // added by Ayush
		waitforPagetobeenable();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Service Order Reference No");
		Thread.sleep(5000);
	}

	public void enterMandatoryFieldsInHeader(Object[] Inputdata) throws Exception {

		waitForpageload();			//as per Aman
		waitforPagetobeenable();	//as per Aman
		WaitforElementtobeclickable(xml.getlocator("//locators/OrderSubTypeSearch"));
		Clickon(getwebelement(xml.getlocator("//locators/OrderSubTypeSearch")));
		System.out.println("Enter New Order");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order Sub Type Search");

		WaitforElementtobeclickable(xml.getlocator("//locators/AddOrderSubType"));
		Clickon(getwebelement(xml.getlocator("//locators/AddOrderSubType")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Order Sub Type");
		SendKeys(getwebelement(xml.getlocator("//locators/InputOrderSubType")), Inputdata[9].toString());
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/InputOrderSubType")), Keys.ENTER);
		Thread.sleep(2000);

		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order Sub Type DropDown");

		WaitforElementtobeclickable(xml.getlocator("//locators/SubmitSubOrderType"));
		Clickon(getwebelement(xml.getlocator("//locators/SubmitSubOrderType")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Submit Sub Order Type");
		waitforPagetobeenable();
		WaitforElementtobeclickable(xml.getlocator("//locators/ContractSearch"));
		Clickon(getwebelement(xml.getlocator("//locators/ContractSearch")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Contract Search");
		WaitforElementtobeclickable(xml.getlocator("//locators/InputContractId")); // new added by ayush
		SendKeys(getwebelement(xml.getlocator("//locators/InputContractId")), Inputdata[10].toString());
		WaitforElementtobeclickable((xml.getlocator("//locators/ContractIdSearch"))); // add by ayush for abandoned
		Clickon(getwebelement(xml.getlocator("//locators/ContractIdSearch")));
		waitforPagetobeenable();
		// Clickon(getwebelement(xml.getlocator("//locators/ContractIdSubmit")));

		// Clickon(getwebelement(
		// "//table[@summary='Pick Contract']//tr//td[text()='" + Inputdata[52 +
		// 12].toString() + "']"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step:  Select Contract");
		// Clickon(getwebelement(xml.getlocator("//locators/SubmitContract")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Submit Contract");
		Thread.sleep(5000);
		/*
		 * added by-Vikram for Hub product to store Ntwrk reference in a variable for
		 * Spoke to take Hub Ntwrk Refrn nmbr
		 */
		if (Inputdata[8].toString().equals("Ethernet Hub")) {
			Clickon(getwebelement(xml.getlocator("//locators/NetworkReferenceSearch")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Network Reference Search");
			Clickon(getwebelement(xml.getlocator("//locators/AddNetworkReferenceSearch")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Network Reference Search");
			Thread.sleep(3000);
			HubNetworkReference.set(Gettext(getwebelement(xml.getlocator("//locators/TextNetworkReference"))));
			ExtentTestManager.getTest().log(LogStatus.PASS,
					" Step: Generated Hub Network Reference No: " + HubNetworkReference.get());
			Log.info(HubNetworkReference.get());
			Clickon(getwebelement(xml.getlocator("//locators/SubmitNetworkReference")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Submit Network Reference");
			waitforPagetobeenable();
			Thread.sleep(3000);
		} else if (Inputdata[8].toString().equals("Ethernet Spoke")|| Inputdata[8].toString().equals("Dark Fibre")
				 || Inputdata[8].toString().equals("Private Wave Node"))  {
			Clickon(getwebelement(xml.getlocator("//locators/NetworkReferenceSearch")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Network Reference Search");
			Thread.sleep(1000);
			SendKeys(getwebelement(xml.getlocator("//locators/InputNetworkReference")), Inputdata[121].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Network reference from Existing Hub");
			Thread.sleep(1000);
			Clickon(getwebelement(xml.getlocator("//locators/SearchNetworkReference")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Network Reference");
			Thread.sleep(1000);

			Clickon(getwebelement(xml.getlocator("//locators/SubmitNetworkReference")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Submit Network Reference");
			waitforPagetobeenable();
			Thread.sleep(3000);

		} else if (Inputdata[8].toString().equals("HNS")) {
			SendKeys(getwebelement(xml.getlocator("//locators/InputNetworkReference")), HubNetworkReference.get());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Network reference from New Hub");

		}
		else if(Inputdata[8].toString().equals("IP VPN Site"))
		{
			WaitforElementtobeclickable(xml.getlocator("//locators/NetworkReferenceSearch"));
			Clickon(getwebelement(xml.getlocator("//locators/NetworkReferenceSearch")));
			SendKeys(getwebelement(xml.getlocator("//locators/IPVPNSite/NetworkReferenceInput")),NetworkReferenceIPVPN.get().toString());
			Thread.sleep(2000);
			Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/NetworkReferenceSearchin")));
			waitforPagetobeenable();
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/NetworkReferenceGo")));
			Thread.sleep(3000);
		}
		if (!Inputdata[8].toString().equals("Cloud Unified Communications")
				&& !Inputdata[8].toString().equals("IP Voice Solutions")
				&& !Inputdata[8].toString().equals("Professional Services")
				&& (!Inputdata[8].toString().equalsIgnoreCase("Wave")
						&& !Inputdata[8].toString().equalsIgnoreCase("Ethernet Line")
						&& !Inputdata[8].toString().equals("Ethernet Spoke")
						&& !Inputdata[8].toString().equals("Ethernet Hub")
						&& !Inputdata[8].toString().equals("Private Ethernet")&& !Inputdata[8].toString().equals("DCA Ethernet") && !Inputdata[8].toString().equals("Ultra Low Latency"))) {
			WaitforElementtobeclickable(xml.getlocator("//locators/NetworkReferenceSearch"));
			Clickon(getwebelement(xml.getlocator("//locators/NetworkReferenceSearch")));
			Clickon(getwebelement(xml.getlocator("//locators/NetworkPlusSign")));
			Clickon(getwebelement(xml.getlocator("//locators/SelectNetworkReference")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Network Reference Search");
			// SendKeys(getwebelement(xml.getlocator("//locators/InputNetworkReference")),
			// HubNetworkReference.get());
			// SendKeys(getwebelement(xml.getlocator("//locators/InputNetworkReference")),"HNS-871331328");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Input Network Reference");
			// Clickon(getwebelement(xml.getlocator("//locators/SearchNetworkReference")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Network Reference");
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/SubmitNetworkReference")));
			waitforPagetobeenable();
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Submit Network Reference");
		}
		Thread.sleep(5000);
		savePage();
		Thread.sleep(10000);
		if (!Inputdata[8].toString().equals("Voice Line V")) {
			WaitforElementtobeclickable(xml.getlocator("//locators/ExistingCapacityLeadTimePrimary"));
			SendKeys(getwebelement(xml.getlocator("//locators/ExistingCapacityLeadTimePrimary")),
					Inputdata[12].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Existing Capacity Lead Time Primary");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ExistingCapacityLeadTimePrimary")), Keys.ENTER);
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ExistingCapacityLeadTimePrimary")), Keys.TAB);
			waitforPagetobeenable();
			// savePage();
			// Thread.sleep(10000);
			Thread.sleep(5000);
			if (!Inputdata[8].toString().equalsIgnoreCase("Wave")
					&& !Inputdata[8].toString().equalsIgnoreCase("Ethernet Spoke")
					&& !Inputdata[8].toString().equalsIgnoreCase("Ethernet Hub")) // added shivananda
			{

				WaitforElementtobeclickable(xml.getlocator("//locators/MaintenancePartySearch"));
				waitforPagetobeenable();

				Clickon(getwebelement(xml.getlocator("//locators/MaintenancePartySearch")));
				WaitforElementtobeclickable(xml.getlocator("//locators/MaintenancePartyPopupDropdown")); // add by ayush
				Clickon(getwebelement(xml.getlocator("//locators/MaintenancePartyPopupDropdown")));
				safeJavaScriptClick(getwebelement(xml.getlocator("//locators/AccountStatus")));
				WaitforElementtobeclickable(xml.getlocator("//locators/InputAccountStatus"));
				SendKeys(getwebelement(xml.getlocator("//locators/InputAccountStatus")), Inputdata[13].toString());
				WaitforElementtobeclickable(xml.getlocator("//locators/AccountStatusSearch")); // add by ayush
				Clickon(getwebelement(xml.getlocator("//locators/AccountStatusSearch")));
				waitforPagetobeenable();
				Thread.sleep(4000);
				WaitforElementtobeclickable(xml.getlocator("//locators/AccountStatusSubmit"));
				Clickon(getwebelement(xml.getlocator("//locators/AccountStatusSubmit")));
				Thread.sleep(3000);

				WaitforElementtobeclickable(xml.getlocator("//locators/MaintenancePartyContact"));
				Clickon(getwebelement(xml.getlocator("//locators/MaintenancePartyContact")));
				waitforPagetobeenable();
				WaitforElementtobeclickable(xml.getlocator("//locators/MaintenancePartyContactPopupDropdown")); // add
																												// by
																												// ayush
				Clickon(getwebelement(xml.getlocator("//locators/MaintenancePartyContactPopupDropdown")));
				waitandForElementDisplay((xml.getlocator("//locators/MaintenanceLastName")), 5);
				safeJavaScriptClick(getwebelement(xml.getlocator("//locators/MaintenanceLastName")));
				WaitforElementtobeclickable(xml.getlocator("//locators/InputMaintenanceLastName"));
				SendKeys(getwebelement(xml.getlocator("//locators/InputMaintenanceLastName")),
						Inputdata[14].toString()); // add by ayush
				WaitforElementtobeclickable(xml.getlocator("//locators/InputMaintenanceLastNameSearch"));
				Clickon(getwebelement(xml.getlocator("//locators/InputMaintenanceLastNameSearch")));
				waitforPagetobeenable();
				Thread.sleep(2000);
				WaitforElementtobeclickable(xml.getlocator("//locators/MaintenancePartyContactSubmit"));
				Clickon(getwebelement(xml.getlocator("//locators/MaintenancePartyContactSubmit")));
				Thread.sleep(3000);

				WaitforElementtobeclickable(xml.getlocator("//locators/MaintenancePartyAddress"));
				Clickon(getwebelement(xml.getlocator("//locators/MaintenancePartyAddress")));
				waitforPagetobeenable();
				WaitforElementtobeclickable(xml.getlocator("//locators/MaintenancePartyAddresPopupDropdown"));// add by
																												// ayush
				Clickon(getwebelement(xml.getlocator("//locators/MaintenancePartyAddresPopupDropdown")));
				WaitforElementtobeclickable(xml.getlocator("//locators/PartyAddresStreetName")); // add by ayush
				safeJavaScriptClick(getwebelement(xml.getlocator("//locators/PartyAddresStreetName")));
				WaitforElementtobeclickable(xml.getlocator("//locators/InputPartyAddresStreetName")); // add by ayush
				SendKeys(getwebelement(xml.getlocator("//locators/InputPartyAddresStreetName")),
						Inputdata[15].toString());
				WaitforElementtobeclickable(xml.getlocator("//locators/InputPartyAddresStreetNameSearch"));
				Clickon(getwebelement(xml.getlocator("//locators/InputPartyAddresStreetNameSearch")));
				waitforPagetobeenable();
				Thread.sleep(2000);
				WaitforElementtobeclickable(xml.getlocator("//locators/MaintenancePartyAddressSubmit")); // add by ayush
				Clickon(getwebelement(xml.getlocator("//locators/MaintenancePartyAddressSubmit")));
				waitforPagetobeenable();
				Thread.sleep(3000);
				savePage();
				waitforPagetobeenable();
				Thread.sleep(8000);
				if (isElementPresent(xml.getlocator("//locators/SaveOrderChanges"))) {
					WaitforElementtobeclickable(xml.getlocator("//locators/SaveOrderChanges"));
					Clickon(getwebelement(xml.getlocator("//locators/SaveOrderChanges")));
					waitForpageload();
					System.out.println("page load succesfuuly now come to middle applet");
					waitforPagetobeenable();
				}
			}
		}
	}

	public void VoiceFeatureTab(Object[] Inputdata) throws Exception {
		if (Inputdata[8].toString().equals("Voice Line V")) {
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/VoicefeaturesTab")));
			Thread.sleep(5000);
			WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on SaveAccess");
			waitforPagetobeenable();
			Thread.sleep(30000);
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/showfullinfo")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Show full Info");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ByPassNumber")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on BypassNumber");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/CallBarring")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on CallBarring");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/CallBarringDropDown"));
			Clickon(getwebelement(xml.getlocator("//locators/CallBarringDropDown")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on CallBarringDropDown");
			// Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/Callbarringvalue"));
			Clickon(getwebelement(xml.getlocator("//locators/Callbarringvalue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on CallBarringValue");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/Connectivity"));
			Clickon(getwebelement(xml.getlocator("//locators/Connectivity")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Connectivity");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/carrierHotel"));
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/carrierHotel")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on carrierHotel");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/FastTrack"));
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/FastTrack")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on FastTrack");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/InternalCabling"));
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/InternalCabling")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on InternalCabling");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/LOngLining"));
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/LOngLining")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on LongLining");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/DisasterRecovery"));
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/DisasterRecovery")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on DisasterRecovery");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/NumberOfDrPlans"));
			Clickon(getwebelement(xml.getlocator("//locators/NumberOfDrPlans")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on NumberOfDRPlans");
			// Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/NumberofDRplansValue"));
			Clickon(getwebelement(xml.getlocator("//locators/NumberofDRplansValue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on NoofDrValues");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/InboundCallRerouting"));
			Clickon(getwebelement(xml.getlocator("//locators/InboundCallRerouting")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on InboundCallRerouting");
			Thread.sleep(5000);
			// WaitforElementtobeclickable(xml.getlocator("//locators/DestinationNumberforRerouting"));
			Clickon(getwebelement(xml.getlocator("//locators/DestinationNumberforRerouting")));
			SendKeys(getwebelement(xml.getlocator("//locators/DestinationNumberforRerouting")), "1234");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on DestinationNumberforRerouting");
			Thread.sleep(5000);
			// WaitforElementtobeclickable(xml.getlocator("//locators/MinimumSpendCommitment"));
			Clickon(getwebelement(xml.getlocator("//locators/MinimumSpendCommitment")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on MinimumSpendCommitment");
			Thread.sleep(5000);
			// WaitforElementtobeclickable(xml.getlocator("//locators/PartialNumberReplacement"));
			Clickon(getwebelement(xml.getlocator("//locators/PartialNumberReplacement")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on PartialNumberReplacement");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/internationalCode")));
			SendKeys(getwebelement(xml.getlocator("//locators/internationalCode")), "1");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on InternationalCode");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/LOcalAreaCode")));
			SendKeys(getwebelement(xml.getlocator("//locators/LOcalAreaCode")), "1");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on LOcalAreaCode");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/NUmberRangeStart")));
			SendKeys(getwebelement(xml.getlocator("//locators/NUmberRangeStart")), "1");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on NUmberRangeStart");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/NumberRangeEnd")));
			SendKeys(getwebelement(xml.getlocator("//locators/NumberRangeEnd")), "1");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on NumberRangeEnd");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ReplacementLOcalAreaCode")));
			SendKeys(getwebelement(xml.getlocator("//locators/ReplacementLOcalAreaCode")), "1");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on ReplacementLOcalAreaCode");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ReplacementMainNumber")));
			SendKeys(getwebelement(xml.getlocator("//locators/ReplacementMainNumber")), "1");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on ReplacementMainNumber");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ReplacementNumberRangeStart")));
			SendKeys(getwebelement(xml.getlocator("//locators/ReplacementNumberRangeStart")), "1");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on ReplacementNumberRangeStart");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ReplacementNumberRangeEnd")));
			SendKeys(getwebelement(xml.getlocator("//locators/ReplacementNumberRangeEnd")), "1");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on ReplacementNumberRangeEnd");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/PartialNumberConfiguration")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on PartialNumberConfiguration");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/internationalCode1")));
			SendKeys(getwebelement(xml.getlocator("//locators/internationalCode1")), "2");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on internationalCode1");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/LOcalAreaCode1")));
			SendKeys(getwebelement(xml.getlocator("//locators/LOcalAreaCode1")), "2");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on LOcalAreaCode1");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/NUmberRangeStart1")));
			SendKeys(getwebelement(xml.getlocator("//locators/NUmberRangeStart1")), "2");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on NUmberRangeStart1");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/NumberRangeEnd1")));
			SendKeys(getwebelement(xml.getlocator("//locators/NumberRangeEnd1")), "2");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on NumberRangeEnd1");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ReplacementLOcalAreaCode1")));
			SendKeys(getwebelement(xml.getlocator("//locators/ReplacementLOcalAreaCode1")), "2");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on ReplacementLOcalAreaCode1");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ReplacementMainNumber1")));
			SendKeys(getwebelement(xml.getlocator("//locators/ReplacementMainNumber1")), "2");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on ReplacementMainNumber1");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ReplacementNumberRangeStart1")));
			SendKeys(getwebelement(xml.getlocator("//locators/ReplacementNumberRangeStart1")), "2");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on ReplacementNumberRangeStart1");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ReplacementNumberRangeEnd1")));
			SendKeys(getwebelement(xml.getlocator("//locators/ReplacementNumberRangeEnd1")), "2");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on ReplacementNumberRangeEnd1");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ServiceActivationSupport")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on ServiceActivationSupport");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/LanguageDropDown"));
			Clickon(getwebelement(xml.getlocator("//locators/LanguageDropDown")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on LanguageDropDown");
			// Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/LanguageValue"));
			Clickon(getwebelement(xml.getlocator("//locators/LanguageValue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on LanguageValue");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/TelephoneDirectoryServices")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on TelephoneDirectoryServices");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/CrossButton1")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on CrossButton");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/DisasterRecoveryContact")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on DisasterRecoveryContact");
			Thread.sleep(5000);
			WaitforElementtobeclickable((xml.getlocator("//locators/ClickSaveConfig")));
			Clickon(getwebelement(xml.getlocator("//locators/ClickSaveConfig")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on ClickSaveConfig");
			waitforPagetobeenable();
			Thread.sleep(30000);
			Clickon(getwebelement(xml.getlocator("//locators/DisasterRecoveryContact")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on DisasterRecoveryContact");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/DisasterRecoveryAdd")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on DisasterRecoveryAdd");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/DisasterAdd2")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on DisasterAdd2");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/DisasterRecoveryAdd")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on DisasterRecoveryAdd");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/DisasterRecoveryOk")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on DisasterRecoveryOk");
			Thread.sleep(5000);
		}
	}

	public void MandatoryFields(Object[] Inputdata) throws Exception {
		if (Inputdata[8].toString().equals("Voice Line V")) {

			Clickon(getwebelement(xml.getlocator("//locators/NumberManagementTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on NumberManagementTab");
			Thread.sleep(15000);
			Clickon(getwebelement(xml.getlocator("//locators/NumberRangeStatus")));
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/NumberRangeStatusDropDown"));
			Clickon(getwebelement(xml.getlocator("//locators/NumberRangeStatusDropDown")));
			// Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/NumberRangeStatusValueActive"));
			Clickon(getwebelement(xml.getlocator("//locators/NumberRangeStatusValueActive")));
			Thread.sleep(5000);
			waitforPagetobeenable();
			/*
			 * Clickon(getwebelement(xml.getlocator("//locators/ManualValidation")));
			 * ExtentTestManager.getTest().log(LogStatus.PASS,
			 * " Step: Click Manual Validation Button"); waitforPagetobeenable();
			 */
			Thread.sleep(10000);
		}
	}

	public void OperationAttribute(Object[] Inputdata) throws Exception {
		if (Inputdata[8].toString().equals("Voice Line V")) {
			Clickon(getwebelement(xml.getlocator("//locators/Voiceconfigtab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Voiceconfigtab");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/OperationAttribute"));
			Clickon(getwebelement(xml.getlocator("//locators/OperationAttribute")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on OperationAttribute");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/AttributeNew")));
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/AttributeNameDropDown"));
			Clickon(getwebelement(xml.getlocator("//locators/AttributeNameDropDown")));
			Clickon(getwebelement(xml.getlocator("//locators/AttributeName")));
			// SendKeys(getwebelement(xml.getlocator("//locators/AttributeName")),"Scenario");
			// SendkeaboardKeys(getwebelement(xml.getlocator("//locators/AttributeName")),Keys.ENTER);
			Thread.sleep(5000);
			/*
			 * Clickon(getwebelement(xml.getlocator("//locators/AttributeValue")));
			 * Thread.sleep(5000); WaitforElementtobeclickable(xml.getlocator(
			 * "//locators/AttributeValueDropDown"));
			 * Clickon(getwebelement(xml.getlocator("//locators/AttributeValueDropDown")));
			 * Thread.sleep(5000);
			 * Clickon(getwebelement(xml.getlocator("//locators/AttributeValue")));
			 */
			// SendKeys(getwebelement(xml.getlocator("//locators/AttributeValue")),"Scenario
			// 1");
			// SendkeaboardKeys(getwebelement(xml.getlocator("//locators/AttributeValue")),Keys.ENTER);
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/OperationAttributeSubmit")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Submit ");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/OtherTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on OtherTab");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/OperationAttribute1"));
			Clickon(getwebelement(xml.getlocator("//locators/OperationAttribute1")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on OperationAttribute");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/AttributeValue1")));
			SendKeys(getwebelement(xml.getlocator("//locators/AttributeValue1")), "test");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/OperationAttributeSubmit")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Submit ");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/OperationAttribute2"));
			Clickon(getwebelement(xml.getlocator("//locators/OperationAttribute2")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on OperationAttribute");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/AttributeValue1")));
			SendKeys(getwebelement(xml.getlocator("//locators/AttributeValue1")), "test");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/OperationAttributeSubmit")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Submit ");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/OperationAttribute"));
			Clickon(getwebelement(xml.getlocator("//locators/OperationAttribute")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on OperationAttribute");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/AttributeValueDropDown"));
			Clickon(getwebelement(xml.getlocator("//locators/AttributeValueDropDown")));
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/AttributeValue")));
			// SendKeys(getwebelement(xml.getlocator("//locators/AttributeValue")),"Scenario
			// 1");
			// SendkeaboardKeys(getwebelement(xml.getlocator("//locators/AttributeValue")),Keys.ENTER);
			Thread.sleep(5000);
		}
	}

	public void SelectServiceGroupTab(Object[] Inputdata) throws Exception {
		if (Inputdata[8].toString().equals("Voice Line V")) {
			waitforPagetobeenable();
			Clickon(getwebelement(xml.getlocator("//locators/DropDown")));
//	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Drop down");
//	Clickon(getwebelement(xml.getlocator("//locators/InstallationAndTestTab")));
			Select(getwebelement(xml.getlocator("//locators/DropDown")), "Service Group");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Service Group Tab");
			Clickon(getwebelement(xml.getlocator("//locators/ServiceGroupNew")));
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/serviceGrouplookup"));
			Clickon(getwebelement(xml.getlocator("//locators/serviceGrouplookup")));
			// Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ServiceGroupOk")));
			Thread.sleep(5000);
			/*
			 * Clickon(getwebelement(xml.getlocator("//locators/ServiceGroupItemNew")));
			 * Thread.sleep(5000); WaitforElementtobeclickable(xml.getlocator(
			 * "//locators/ServiceGroupItemlookup"));
			 * Clickon(getwebelement(xml.getlocator("//locators/ServiceGroupItemlookup")));
			 * Thread.sleep(5000);
			 * //Clickon(getwebelement(xml.getlocator("//locators/selectitem")));
			 * //Thread.sleep(5000);
			 * Clickon(getwebelement(xml.getlocator("//locators/ServiceorderOk")));
			 * Thread.sleep(5000); savePage();
			 */
		}
	}

	public void NumberManagementTab(Object[] Inputdata) throws Exception {
		if (Inputdata[8].toString().equals("Voice Line V")) {
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/NumberManagementTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on NumberManagementTab");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/PortGroupTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on PortGroupTab");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/PortGroupNew")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on PortGroupNew");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/CallDistribution")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on CallDistribution");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/callDistributioninput")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on callDistributioninput");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/CallDistributionDropDown"));
			Clickon(getwebelement(xml.getlocator("//locators/CallDistributionDropDown")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on CallDistributionDropDown");
			// Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/CallDistributionValue"));
			Clickon(getwebelement(xml.getlocator("//locators/CallDistributionValue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on CallDistributionValue");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/AssignedPortNew")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on AssignedPortNew");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/Unassignedport")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Unassignedport");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderListTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on ServiceOrderListTab");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on ServiceOrderLink");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/NumberManagementTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on NumberManagementTab");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/PortGroupTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on PortGroupTab");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/AssignedPortNew")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on AssignedPortNew");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/Unassignedport")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Unassignedport");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/NumberRangeTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on NumberRangeTab");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/NumberRangeListNew")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on NumberRangeListNew");
			Thread.sleep(10000);
			Clickon(getwebelement(xml.getlocator("//locators/NumberPlan")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on NumberPlan");
			Thread.sleep(5000);
			// safeJavaScriptClick(getwebelement(xml.getlocator("//locators/NumberPlaninput")));
			// Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/NumberpLanDropDown"));
			Clickon(getwebelement(xml.getlocator("//locators/NumberpLanDropDown")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on NumberpLanDropDown");
			// Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/NumberPlanValue"));
			Clickon(getwebelement(xml.getlocator("//locators/NumberPlanValue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on NumberPlanValue");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ColtREservationRef")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on ColtREservationRef");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ColtNumberReservatioRefinput")));
			SendKeys(getwebelement(xml.getlocator("//locators/ColtNumberReservatioRefinput")), "123");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on ColtNumberReservatioRefinput");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/MainNumber")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on MainNumber");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/MainnumberField")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on MainnumberField");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/MainNumberInput")));
			SendKeys(getwebelement(xml.getlocator("//locators/MainNumberInput")), "12");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on MainNumberInput");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/LocalAreaCode")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on LocalAreaCode");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/LocalAreaValue")));
			SendKeys(getwebelement(xml.getlocator("//locators/LocalAreaValue")), "12");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on LocalAreaValue");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/NumberrangeStart")));
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/NumberRangeStartValue")));
			SendKeys(getwebelement(xml.getlocator("//locators/NumberRangeStartValue")), "12");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/NumberRangeEnd2")));
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/NumberRangeinput")));
			SendKeys(getwebelement(xml.getlocator("//locators/NumberRangeinput")), "15");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/NumberRangeStatus")));
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/NumberRangeStatusDropDown"));
			Clickon(getwebelement(xml.getlocator("//locators/NumberRangeStatusDropDown")));
			// Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/NumberRangeStatusValue"));
			Clickon(getwebelement(xml.getlocator("//locators/NumberRangeStatusValue")));
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/PortGroupId")));
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/PortGroupIdLookup"));
			Clickon(getwebelement(xml.getlocator("//locators/PortGroupIdLookup")));
			// Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/PortGroupOk")));
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/addressUid")));
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/addressUidLookup"));
			Clickon(getwebelement(xml.getlocator("//locators/addressUidLookup")));
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/StreetNameAccess"));
			SendKeys(getwebelement(xml.getlocator("//locators/StreetNameAccess")), "parker");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Street Name");
			WaitforElementtobeclickable(xml.getlocator("//locators/CountryAccess"));
			SendKeys(getwebelement(xml.getlocator("//locators/CountryAccess")), Inputdata[62].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Country");
			SendKeys(getwebelement(xml.getlocator("//locators/CityTownAccess")), Inputdata[63].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter City");
			SendKeys(getwebelement(xml.getlocator("//locators/PostalCodeAccess")), "*");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Postal Code");
			SendKeys(getwebelement(xml.getlocator("//locators/PremisesAccess")), "*");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Premises");
			Clickon(getwebelement(xml.getlocator("//locators/SearchButtonAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search");
			Thread.sleep(3000);
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/SelectPickAddressAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Address for Site");
			Clickon(getwebelement(xml.getlocator("//locators/PickAddressButtonAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Submit Address for Site");
			Clickon(getwebelement(xml.getlocator("//locators/BCN")));
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/BCNLookup"));
			Clickon(getwebelement(xml.getlocator("//locators/BCNLookup")));
			// Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/BillingProfileOK")));
			Thread.sleep(5000);
		}
	}

	public void VoiceConfigTab(Object[] Inputdata) throws Exception {
		if (Inputdata[8].toString().equals("Voice Line V")) {
			Clickon(getwebelement(xml.getlocator("//locators/TrunkName")));
			SendKeys(getwebelement(xml.getlocator("//locators/TrunkName")), "Trunk" + timeStamp + "");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on TrunkName");
			WaitforElementtobeclickable(xml.getlocator("//locators/AccessLineTypeDropDown"));
			Clickon(getwebelement(xml.getlocator("//locators/AccessLineTypeDropDown")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on AccessLineDropDown");
			// Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/AccessLineType"));
			Clickon(getwebelement(xml.getlocator("//locators/AccessLineType")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on AccessLineTypw");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/AccessServiceIdlookup")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access ServiceId Search");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/PickServiceSubmit")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  Submit Pick Service");
			Thread.sleep(5000);
			waitforPagetobeenable();
			Clickon(getwebelement(xml.getlocator("//locators/showfullinfo")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Show full info");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/TrunkConfigurationplus")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Trunk Configuration Plus");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/outsidebuissnesshourinstallation")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on outside buissness hour installation");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/Crossbutton")));
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/SaveButtonClick")));
			Thread.sleep(5000);
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/TrunckConfigplus")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Trunk Configuration Plus");
			Thread.sleep(5000);
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/OtherTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  Other Tab");
			Thread.sleep(5000);
			// Thread.sleep(5000);
			// WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			// Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));

			// waitforPagetobeenable();
			// Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/SelectSiteSearchAccess"));
			// Moveon(getwebelement(xml.getlocator("//locators/SelectSiteSearchAccess")));
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/SelectSiteSearchAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search Site");
			WaitforElementtobeclickable(xml.getlocator("//locators/StreetNameAccess"));
			SendKeys(getwebelement(xml.getlocator("//locators/StreetNameAccess")), "parker");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Street Name");
			WaitforElementtobeclickable(xml.getlocator("//locators/CountryAccess"));
			SendKeys(getwebelement(xml.getlocator("//locators/CountryAccess")), Inputdata[62].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Country");
			SendKeys(getwebelement(xml.getlocator("//locators/CityTownAccess")), Inputdata[63].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter City");
			SendKeys(getwebelement(xml.getlocator("//locators/PostalCodeAccess")), "*");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Postal Code");
			SendKeys(getwebelement(xml.getlocator("//locators/PremisesAccess")), "*");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Premises");
			Clickon(getwebelement(xml.getlocator("//locators/SearchButtonAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search");
			Thread.sleep(3000);
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/SelectPickAddressAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Address for Site");
			Clickon(getwebelement(xml.getlocator("//locators/PickAddressButtonAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Submit Address for Site");
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/SelectPickBuildingAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Buiding for Site");
			Clickon(getwebelement(xml.getlocator("//locators/PickBuildingButtonAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Submit Buiding for Site");
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/SelectPickSiteAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Site");
			Clickon(getwebelement(xml.getlocator("//locators/PickSiteButtonAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Submit Site");
			Thread.sleep(10000);

			WaitforElementtobeclickable(xml.getlocator("//locators/PortIDDropDown"));
			Clickon(getwebelement(xml.getlocator("//locators/PortIDDropDown")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click ON Port ID Drop Down");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/PortId"));
			Clickon(getwebelement(xml.getlocator("//locators/PortId")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Port ID");
			Thread.sleep(5000);

			WaitforElementtobeclickable(xml.getlocator("//locators/TrafficDirectionDropDown"));
			Clickon(getwebelement(xml.getlocator("//locators/TrafficDirectionDropDown")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Traffic Direction DropDown");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/TrafficDirection"));
			Clickon(getwebelement(xml.getlocator("//locators/TrafficDirection")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Traffic Direction");
			Thread.sleep(5000);

			WaitforElementtobeclickable(xml.getlocator("//locators/CabinetTypeDropDown"));
			Clickon(getwebelement(xml.getlocator("//locators/CabinetTypeDropDown")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Cabinet DropDown");
			// Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/Cabinet_Type"));
			Clickon(getwebelement(xml.getlocator("//locators/Cabinet_Type")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Cabinet Type");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/Cabinet_Id")));
			SendKeys(getwebelement(xml.getlocator("//locators/Cabinet_Id")), "Test");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Cabinet ID");
			Clickon(getwebelement(xml.getlocator("//locators/Shelf_ID")));
			SendKeys(getwebelement(xml.getlocator("//locators/Shelf_ID")), "Test");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Shelf ID");
			Clickon(getwebelement(xml.getlocator("//locators/SIPShowfullinfo")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Show full info");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/Isdnport"));
			Clickon(getwebelement(xml.getlocator("//locators/Isdnport")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on IsdnPort");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/PortIDDropDownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/PortIDDropDownAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on POrtID DropDown Access");
			// Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/PortIDDropDownAccessValue"));
			Clickon(getwebelement(xml.getlocator("//locators/PortIDDropDownAccessValue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on PortID DropDown Access Value");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/Isdnport"));
			Clickon(getwebelement(xml.getlocator("//locators/Isdnport")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Isdn Port");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/PortIDDropDownAccess2"));
			Clickon(getwebelement(xml.getlocator("//locators/PortIDDropDownAccess2")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Port ID DropDown");
			// Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/PortIDDropDownAccessValue2"));
			Clickon(getwebelement(xml.getlocator("//locators/PortIDDropDownAccessValue2")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on POrtID Value");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/TrafficDirectionDropDown2"));
			Clickon(getwebelement(xml.getlocator("//locators/TrafficDirectionDropDown2")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Traffic Direction DropDown");
			// Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/TrafficDirection1"));
			Clickon(getwebelement(xml.getlocator("//locators/TrafficDirection1")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on TRaffic Direction Value");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/SipTDMGateway"));
			Clickon(getwebelement(xml.getlocator("//locators/SipTDMGateway")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on sip TDM Gateway");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/PortIDDropDownAccess3"));
			Clickon(getwebelement(xml.getlocator("//locators/PortIDDropDownAccess3")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on PortId DropDown");
			// Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/PortIDDropDownAccessValue3"));
			Clickon(getwebelement(xml.getlocator("//locators/PortIDDropDownAccessValue3")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on PortId Value");
			Thread.sleep(5000);

			// WaitforElementtobeclickable(xml.getlocator("//locators/TrafficDirectionDropDown"));
			// Clickon(getwebelement(xml.getlocator("//locators/TrafficDirectionDropDown")));
			// Thread.sleep(5000);
			// WaitforElementtobeclickable(xml.getlocator("//locators/TrafficDirection"));
			// Clickon(getwebelement(xml.getlocator("//locators/TrafficDirection")));
			// Thread.sleep(5000);

			WaitforElementtobeclickable(xml.getlocator("//locators/CabinetTypeDropDown2"));
			Clickon(getwebelement(xml.getlocator("//locators/CabinetTypeDropDown2")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Cabinet DropDown");
			// Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/CabinetType1"));
			Clickon(getwebelement(xml.getlocator("//locators/CabinetType1")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Cabinet Type");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/Cabinet_Id1")));
			SendKeys(getwebelement(xml.getlocator("//locators/Cabinet_Id1")), "Test");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Cabinet ID");
			Clickon(getwebelement(xml.getlocator("//locators/ShelfID1")));
			SendKeys(getwebelement(xml.getlocator("//locators/ShelfID1")), "Test");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on ShelfID");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/Crossbutton")));
			Thread.sleep(5000);
			WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Save");
			waitforPagetobeenable();
			Thread.sleep(30000);
			WaitforElementtobeclickable(xml.getlocator("//locators/SelectSiteSearchAccess"));
			// Moveon(getwebelement(xml.getlocator("//locators/SelectSiteSearchAccess")));
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/SelectSiteSearchAccess")));
			Thread.sleep(3000);
			// WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			// Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
			// Thread.sleep(3000);
			// WaitforElementtobeclickable(xml.getlocator("//locators/SelectSiteSearchAccess"));
			// Moveon(getwebelement(xml.getlocator("//locators/SelectSiteSearchAccess")));
			// safeJavaScriptClick(getwebelement(xml.getlocator("//locators/SelectSiteSearchAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search Site");
			WaitforElementtobeclickable(xml.getlocator("//locators/StreetNameAccess"));
			SendKeys(getwebelement(xml.getlocator("//locators/StreetNameAccess")), "parker");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Street Name");
			WaitforElementtobeclickable(xml.getlocator("//locators/CountryAccess"));
			SendKeys(getwebelement(xml.getlocator("//locators/CountryAccess")), Inputdata[62].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Country");
			SendKeys(getwebelement(xml.getlocator("//locators/CityTownAccess")), Inputdata[63].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter City");
			SendKeys(getwebelement(xml.getlocator("//locators/PostalCodeAccess")), "*");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Postal Code");
			SendKeys(getwebelement(xml.getlocator("//locators/PremisesAccess")), "*");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Premises");
			Clickon(getwebelement(xml.getlocator("//locators/SearchButtonAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search");
			Thread.sleep(3000);
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/SelectPickAddressAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Address for Site");
			Clickon(getwebelement(xml.getlocator("//locators/PickAddressButtonAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Submit Address for Site");
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/SelectPickBuildingAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Buiding for Site");
			Clickon(getwebelement(xml.getlocator("//locators/PickBuildingButtonAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Submit Buiding for Site");
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/SelectPickSiteAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Site");
			Clickon(getwebelement(xml.getlocator("//locators/PickSiteButtonAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Submit Site");
			Thread.sleep(10000);
			// Thread.sleep(30000);

			Thread.sleep(10000);

			WaitforElementtobeclickable(xml.getlocator("//locators/TypeoflineDropDown"));
			Clickon(getwebelement(xml.getlocator("//locators/TypeoflineDropDown")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on TypeofLine DropDown");
			// Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/TypeofLinevalue"));
			Clickon(getwebelement(xml.getlocator("//locators/TypeofLinevalue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on typeOfLineValue");
			Thread.sleep(5000);

			// Clickon(getwebelement(xml.getlocator("//locators/NumberOfLines")));
			// clear();
			// SendKeys(getwebelement(xml.getlocator("//locators/NumberOfLines")),"2");
			// Thread.sleep(5000);

			WaitforElementtobeclickable(xml.getlocator("//locators/NumberOfLines"));
			Clear(getwebelement(xml.getlocator("//locators/NumberOfLines")));
			SendKeys(getwebelement(xml.getlocator("//locators/NumberOfLines")), "2");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on NumberOfLines");
			// SendkeaboardKeys((getwebelement(xml.getlocator("//locators/CabinetID"))),
			// Keys.TAB);
			Thread.sleep(4000);

			WaitforElementtobeclickable(xml.getlocator("//locators/CRC4DropDown"));
			Clickon(getwebelement(xml.getlocator("//locators/CRC4DropDown")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on CRC4 DropDown");

			WaitforElementtobeclickable(xml.getlocator("//locators/CRC4Value"));
			Clickon(getwebelement(xml.getlocator("//locators/CRC4Value")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on CRC4 Value");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/MaxChannelDropDown"));
			Clickon(getwebelement(xml.getlocator("//locators/MaxChannelDropDown")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on MaxChannel DropDown");
			// Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/MaxChannelvalue"));
			Clickon(getwebelement(xml.getlocator("//locators/MaxChannelvalue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on MaxChannelValue");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/VoiceOptionshowinfo")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Show full info");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/ColtDDIRanges")));
			Thread.sleep(5000);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on ColtDDIRanges");
			WaitforElementtobeclickable(xml.getlocator("//locators/POrtInDDIRanges"));
			Clickon(getwebelement(xml.getlocator("//locators/POrtInDDIRanges")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on PortInDDIRanges");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/ResellerConfiguration"));
			Clickon(getwebelement(xml.getlocator("//locators/ResellerConfiguration")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on ResellerConfiguration");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/UnratedCDRs"));
			Clickon(getwebelement(xml.getlocator("//locators/UnratedCDRs")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on UnratedCRD's");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/NOofsingleColtDDIs")));
			Clear(getwebelement(xml.getlocator("//locators/NOofsingleColtDDIs")));
			SendKeys(getwebelement(xml.getlocator("//locators/NOofsingleColtDDIs")), "1");
			SendkeaboardKeys((getwebelement(xml.getlocator("//locators/NOofsingleColtDDIs"))), Keys.TAB);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on NoofsingleColtDDI's");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/Noof10ColtDDIs")));
			Clear(getwebelement(xml.getlocator("//locators/Noof10ColtDDIs")));
			SendKeys(getwebelement(xml.getlocator("//locators/Noof10ColtDDIs")), "1");
			SendkeaboardKeys((getwebelement(xml.getlocator("//locators/Noof10ColtDDIs"))), Keys.TAB);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Noof10ColtDDIs");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/Noof100coltDDIs")));
			Clear(getwebelement(xml.getlocator("//locators/Noof100coltDDIs")));
			SendKeys(getwebelement(xml.getlocator("//locators/Noof100coltDDIs")), "1");
			SendkeaboardKeys((getwebelement(xml.getlocator("//locators/Noof100coltDDIs"))), Keys.TAB);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Noof100coltDDIs");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/Noof1000coldDDIs")));
			Clear(getwebelement(xml.getlocator("//locators/Noof1000coldDDIs")));
			SendKeys(getwebelement(xml.getlocator("//locators/Noof1000coldDDIs")), "1");
			SendkeaboardKeys((getwebelement(xml.getlocator("//locators/Noof1000coldDDIs"))), Keys.TAB);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Noof1000coldDDIs");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/NoOfsinglePOrtedDDIs")));
			Clear(getwebelement(xml.getlocator("//locators/NoOfsinglePOrtedDDIs")));
			SendKeys(getwebelement(xml.getlocator("//locators/NoOfsinglePOrtedDDIs")), "1");
			SendkeaboardKeys((getwebelement(xml.getlocator("//locators/NoOfsinglePOrtedDDIs"))), Keys.TAB);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on NoOfsinglePOrtedDDIs");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/Noof10PortedDDIs")));
			Clear(getwebelement(xml.getlocator("//locators/Noof10PortedDDIs")));
			SendKeys(getwebelement(xml.getlocator("//locators/Noof10PortedDDIs")), "1");
			SendkeaboardKeys((getwebelement(xml.getlocator("//locators/Noof10PortedDDIs"))), Keys.TAB);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Noof10PortedDDIs");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/NOof100PortedDDIs")));
			Clear(getwebelement(xml.getlocator("//locators/NOof100PortedDDIs")));
			SendKeys(getwebelement(xml.getlocator("//locators/NOof100PortedDDIs")), "1");
			SendkeaboardKeys((getwebelement(xml.getlocator("//locators/NOof100PortedDDIs"))), Keys.TAB);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on NOof100PortedDDIs");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/Noof1000PortedDDIs")));
			Clickon(getwebelement(xml.getlocator("//locators/Noof1000PortedDDIs")));
			Clear(getwebelement(xml.getlocator("//locators/Noof1000PortedDDIs")));
			SendKeys(getwebelement(xml.getlocator("//locators/Noof1000PortedDDIs")), "1");
			// SendkeaboardKeys((getwebelement(xml.getlocator("//locators/Noof1000PortedDDIs"))),
			// Keys.TAB);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on NOof1000PortedDDIs");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/CrossButton1")));
			Thread.sleep(5000);
		}
	}

	public void middleApplet(Object Inputdata[]) throws InterruptedException, DocumentException, IOException {
		System.out.println("middle applet start");
		waitforPagetobeenable();
		WaitforElementtobeclickable(xml2.getlocator("//locators/SupportStarDate"));
		// Clear(getwebelement(xml2.getlocator("//locators/SupportStarDate")));
		System.out.println("dhoni");
		// getwebelement(xml2.getlocator("//locators/SupportStarDate")).clear();
		// ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Date");
		Clickon(getwebelement(xml2.getlocator("//locators/SupportStarDate")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter  SupportStarDate");
		SendKeys(getwebelement(xml2.getlocator("//locators/SupportStarDate")), Inputdata[78].toString());

		System.out.println("middle applet start1");
		WaitforElementtobeclickable(xml2.getlocator("//locators/SupprtEndDate"));
		// Clear(getwebelement(xml2.getlocator("//locators/SupprtEndDate")));
		System.out.println("dhoni");
		// getwebelement(xml2.getlocator("//locators/SupprtEndDate")).clear();
		// ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Date");

		Clickon(getwebelement(xml2.getlocator("//locators/SupprtEndDate")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter  SupprtEndDate");
		System.out.println("the End date value is" + Inputdata[79].toString());

		SendKeys(getwebelement(xml2.getlocator("//locators/SupprtEndDate")), Inputdata[79].toString());
		System.out.println("dhoni");

		Clickon(getwebelement(xml2.getlocator("//locators/SaveButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on BCN Recurring Charge MRC Search");
		Thread.sleep(10000);

		System.out.println("middle applet end");
	}

	public void enterMandatoryDetailsInMiddleApplet(Object[] Inputdata) throws Exception {
		switch (Inputdata[8].toString()) {
		case  "Private Wave Node": {				//Added by Aman
			middleAppletPrivateWaveNode(Inputdata);
			settingPrivateWaveNode(Inputdata);
			SiteAServiceParty(Inputdata);
			PickServiceParty(Inputdata);
			SiteASiteContact(Inputdata);
			PickSiteContactParty(Inputdata);
			Save();
			SearchSiteA(Inputdata);
			SearchSiteAEntry(Inputdata);
			AEndSitePUD(Inputdata);
			SiteAInstallationTimePUD(Inputdata);
			SiteATerminationTimePUD(Inputdata);
			ClickHereSave();
		break;
		}
		case "Ultra Low Latency": {
			middleUltraLowLatency(Inputdata);

			ShowfullInfo();
			DiversityCircuitEntry(Inputdata);
			Save();
			SiteAServiceParty(Inputdata);
			PickServiceParty(Inputdata);
			SiteBServiceParty(Inputdata);
			PickServiceParty(Inputdata);
			SiteASiteContact(Inputdata);
			PickSiteContactParty(Inputdata);
			SiteBSiteContact(Inputdata);
			PickSiteContactParty(Inputdata);
			Save();
			SearchSiteA(Inputdata);
			SearchSiteAEntry(Inputdata);
			SearchSiteB(Inputdata);
			SearchSiteBEntry(Inputdata);
			AEndSitePUD(Inputdata);
			BEndSitePUD(Inputdata);
			SiteAInstallationTimePUD(Inputdata);
			SiteBInstallationTimePUD(Inputdata);
			SiteATerminationTimePUD(Inputdata);
			SiteBTerminationTimePUD(Inputdata);
			SiteAAccessPortPUD(Inputdata);
			SiteBAccessPortPUD(Inputdata);
			ClickHereSave();
			break;
			}
		case "Cloud Unified Communications": {
			middleApplet(Inputdata);
			break;
		}
		case "IP Voice Solutions": {
			middleApplet(Inputdata);
			break;
		}
		case "Managed Dedicated Firewall": {		//Added by Aman
			middleAppletManagedDedicatedFirewall(Inputdata);
		break;
		}
		case "Dark Fibre": {
			middleAppletDarkFibre(Inputdata);
			ShowfullInfo();
			//PrivateEthernetEntry(Inputdata);//as per Aman's
			DiversityCircuitEntry(Inputdata);
			Save();
			SiteAServiceParty(Inputdata);
			PickServiceParty(Inputdata);
			SiteBServiceParty(Inputdata);
			PickServiceParty(Inputdata);
			SiteASiteContact(Inputdata);
			PickSiteContactParty(Inputdata);
			SiteBSiteContact(Inputdata);
			PickSiteContactParty(Inputdata);
			ClickHereSave();
			SearchSiteA(Inputdata);
			SearchSiteAEntry(Inputdata);
			SearchSiteB(Inputdata);
			SearchSiteBEntry(Inputdata);

			//ClickHereSave();//as per Aman's
			//savePage();//as per Aman's
			//waitforPagetobeenable();//as per Aman's
			AEndSitePUD(Inputdata);
			//as per Aman's ClickHereSave();
			//as per Aman's savePage();
			//as per Aman's waitforPagetobeenable();
			BEndSitePUD(Inputdata);
			//as per Aman's ClickHereSave();
			SiteAInstallationTimePUD(Inputdata); //as per Aman's
			SiteBInstallationTimePUD(Inputdata);
			//as per Aman's ClickHereSave();
			SiteATerminationTimePUD(Inputdata);
			//as per Aman's ClickHereSave();
			SiteBTerminationTimePUD(Inputdata);
			//as per Aman's ClickHereSave();
			SiteAAccessPortPUD(Inputdata);
			//as per Aman's ClickHereSave();
			SiteBAccessPortPUD(Inputdata);
			ClickHereSave();
			break;
		}
		case "Private Ethernet": {
			PrivateEthernetMiddleAplet(Inputdata);
			ShowfullInfo();
			PrivateEthernetEntry(Inputdata);
			DiversityCircuitEntry(Inputdata);
			Save();
			GetReference();
			Save();
			SiteAServiceParty(Inputdata);
			PickServiceParty(Inputdata);
			SiteBServiceParty(Inputdata);
			PickServiceParty(Inputdata);
			SiteASiteContact(Inputdata);
			PickSiteContactParty(Inputdata);
			SiteBSiteContact(Inputdata);
			PickSiteContactParty(Inputdata);
			ClickHereSave();
			SearchSiteA(Inputdata);
			SearchSiteAEntry(Inputdata);
			SearchSiteB(Inputdata);
			SearchSiteBEntry(Inputdata);
			savePage();
			System.out.println("Sites Search and Entered");
			AEndSite(Inputdata);
			BEndSite(Inputdata);
			System.out.println("Site A & B Filled");
			savePage();
			SiteAInstallationTime(Inputdata);
			SiteBInstallationTime(Inputdata);
			ClickHereSave();
			SiteATerminationTime(Inputdata);
			SiteBTerminationTime(Inputdata);
			ClickHereSave();
			SiteAAccessPort(Inputdata);
			SiteBAccessPort(Inputdata);
			ClickHereSave();
			GetReference();
			ClickHereSave();
			break;
		}
		case "DCA Ethernet": {
			PrivateEthernetMiddleAplet(Inputdata);
			ShowfullInfo();
			PrivateEthernetEntry(Inputdata);
			DiversityCircuitEntry(Inputdata);
			Save();
			GetReference();
			Save();
			SiteAServiceParty(Inputdata);
			PickServiceParty(Inputdata);
			SiteBServiceParty(Inputdata);
			PickServiceParty(Inputdata);
			SiteASiteContact(Inputdata);
			PickSiteContactParty(Inputdata);
			SiteBSiteContact(Inputdata);
			PickSiteContactParty(Inputdata);
			ClickHereSave();
			SearchSiteA(Inputdata);
			SearchSiteAEntry(Inputdata);
			SearchSiteB(Inputdata);
			SearchSiteBEntry(Inputdata);
			System.out.println("Site A Starting");
			AEndSite(Inputdata);
			System.out.println("Site A Entred");
			System.out.println("Site B Starting");
			BEndSite(Inputdata);
			System.out.println("Site B Entrede");
		/*	SiteADiversityCircuitConfig(Inputdata);
			SiteBDiversityCircuitConfig(Inputdata);
			ClickHereSave();*/
			SiteAInstallationTime(Inputdata);
			SiteBInstallationTime(Inputdata);
			ClickHereSave();
			SiteATerminationTime(Inputdata);
			SiteBTerminationTime(Inputdata);
			ClickHereSave();
			SiteAAccessPort(Inputdata);
			SiteBAccessPort(Inputdata);
			ClickHereSave();
			SiteAVLan(Inputdata);
			SiteBVLan(Inputdata);
			ClickHereSave();
			SiteBDedicatedCloudAccess(Inputdata);
			ClickHereSave();
			break;
		}
		/* Start Of SIP  Gauri Update Trunking*/
		case "SIP Trunking": {

			System.out.println("Enter SIP information Middle Applet");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter SIP Trunking information Middle Applet");
						
			WaitforElementtobeclickable(xml.getlocator("//locators/VoiceServiceCountryDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/VoiceServiceCountryDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/VoiceServiceCountry"));
			Clickon(getwebelement(xml.getlocator("//locators/NewVoiceServiceCountry")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Voice Service Country Selected");
						
			WaitforElementtobeclickable(xml.getlocator("//locators/CallAdmissionControl"));	
			Clickon(getwebelement(xml.getlocator("//locators/CallAdmissionControl")));
			Clear(getwebelement(xml.getlocator("//locators/CallAdmissionControl")));
			SendKeys(getwebelement(xml.getlocator("//locators/CallAdmissionControl")),"12" );
			
			Thread.sleep(5000);
					
			WaitforElementtobeclickable(xml.getlocator("//locators/NumberOfSignallingTrunks"));		
			Clickon(getwebelement(xml.getlocator("//locators/NumberOfSignallingTrunks")));
			Clear(getwebelement(xml.getlocator("//locators/NumberOfSignallingTrunks")));
			SendKeys(getwebelement(xml.getlocator("//locators/NumberOfSignallingTrunks")),"1");
					 
		    ExtentTestManager.getTest().log(LogStatus.PASS, " Input Number of Signalling Trunks");
		    
		
		    Thread.sleep(4000);
			WaitforElementtobeclickable(xml.getlocator("//locators/EgressNumberFormatDropDownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/EgressNumberFormatDropDownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/EgreeNUmberFormat"));
			Clickon(getwebelement(xml.getlocator("//locators/EgreeNUmberFormat")));
			//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/EgreeNUmberFormat")), Keys.TAB);
			
		    Thread.sleep(8000);
		    
		    WaitforElementtobeclickable(xml.getlocator("//locators/InvlidCLITreatmet"));
		    Clickon(getwebelement(xml.getlocator("//locators/InvlidCLITreatmet")));
		    Clear(getwebelement(xml.getlocator("//locators/InvlidCLITreatmet")));
		    SendKeys(getwebelement(xml.getlocator("//locators/InvlidCLITreatmet")),"Allow");
		
			Thread.sleep(8000);
	 			   
		    WaitforElementtobeclickable(xml.getlocator("//locators/TotalNumberDDIs"));
		    Clickon(getwebelement(xml.getlocator("//locators/TotalNumberDDIs")));
		    Clear(getwebelement(xml.getlocator("//locators/TotalNumberDDIs")));		   
		    SendKeys(getwebelement(xml.getlocator("//locators/TotalNumberDDIs")),"1");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Provide Value to Total Number of DDI");
			Thread.sleep(7000);
			
		    WaitforElementtobeclickable(xml.getlocator("//locators/IncomingDDIs"));
		    Clickon(getwebelement(xml.getlocator("//locators/IncomingDDIs")));
			Clear(getwebelement(xml.getlocator("//locators/IncomingDDIs")));
			SendKeys(getwebelement(xml.getlocator("//locators/IncomingDDIs")), "10");
		
			Thread.sleep(5000);
					
			WaitforElementtobeclickable(xml.getlocator("//locators/RoutingSequence"));
			Clickon(getwebelement(xml.getlocator("//locators/RoutingSequence")));
			Clear(getwebelement(xml.getlocator("//locators/RoutingSequence")));
			SendKeys(getwebelement(xml.getlocator("//locators/RoutingSequence")), "Sequential");
			
			Thread.sleep(8000);
			
			//Clickon(getwebelement(xml.getlocator("//locators/CLIBillingChkBox")));
		   // Thread.sleep(5000);
						
			Clickon(getwebelement(xml.getlocator("//locators/FirstCodec")));
			
			WaitforElementtobeclickable(xml.getlocator("//locators/FirstCodec"));		
			Clear(getwebelement(xml.getlocator("//locators/FirstCodec")));
			SendKeys(getwebelement(xml.getlocator("//locators/FirstCodec")), "G.711alaw");
			
			Thread.sleep(5000);
			

								 
			Clickon(getwebelement(xml.getlocator("//locators/ClickToShowFullInfo")));
			Thread.sleep(8000);
		//	Clickon(getwebelement(xml.getlocator("//locators/TextBoxSiteContact")));
			
		//	Thread.sleep(3000);	
			Clickon(getwebelement(xml.getlocator("//locators/SIPSiteContact")));
			
			Thread.sleep(10000);
		//	Clickon(getwebelement(xml.getlocator("//locators/FirstRecordSelection")));
		//	Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ClickOK")));
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ServiceParty")));
			Thread.sleep(5000);
		//	Clickon(getwebelement(xml.getlocator("//locators/ServicePartyRecordSelect")));
		//	Thread.sleep(5000);
		
			WaitforElementtobeclickable(xml.getlocator("//locators/OKSelection"));
			Clickon(getwebelement(xml.getlocator("//locators/OKSelection")));
			Thread.sleep(8000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPDeliveryTeamNewCountry"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPDeliveryTeamNewCountry")));
		    SendKeys(getwebelement(xml.getlocator("//locators/SIPDeliveryTeamNewCountry")),"United Kingdom");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Delivery  Team Country ");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/SIPDeliveryTeamNewCity")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPDeliveryTeamNewCity")),"London");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/SIPDeliveryTeamNewCity")),Keys.ENTER);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Delivery Team City ");
			Thread.sleep(5000);
		
			//WaitforElementtobeclickable(xml.getlocator("//locators/WLECInvoicingRadioButton"));
			//Clickon(getwebelement(xml.getlocator("//locator/WLECInvoicingRadioButton")));
			//ExtentTestManager.getTest().log(LogStatus.PASS, " WLEC Radio Button");
			
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/CloseSymbol")));
			Thread.sleep(5000); 
						 
		
			Clickon(getwebelement(xml.getlocator("//locators/SIPShowMore")));
			Thread.sleep(3000);
			
			Clickon(getwebelement(xml.getlocator("//locators/SecondCodec")));
			Clear(getwebelement(xml.getlocator("//locators/SecondCodec")));
			SendKeys(getwebelement(xml.getlocator("//locators/SecondCodec")), "G.729");
			Thread.sleep(2000);
			Clickon(getwebelement(xml.getlocator("//locators/ThirdCodec")));
			Clear(getwebelement(xml.getlocator("//locators/ThirdCodec")));
			SendKeys(getwebelement(xml.getlocator("//locators/ThirdCodec")), "G.722.1");
			Thread.sleep(2000);
			Clickon(getwebelement(xml.getlocator("//locators/FourthCodec")));
			Clear(getwebelement(xml.getlocator("//locators/FourthCodec")));
			SendKeys(getwebelement(xml.getlocator("//locators/FourthCodec")), "G.726");
			Thread.sleep(2000);
			
			
		//	Clickon(getwebelement(xml.getlocator("//locators/FourthCodecValue")));
		
			Clickon(getwebelement(xml.getlocator("//locators/FifthCodecTextBox")));
			Clear(getwebelement(xml.getlocator("//locators/FifthCodecTextBox")));
			SendKeys(getwebelement(xml.getlocator("//locators/FifthCodecTextBox")), "G.729a");
			
		//Clickon(getwebelement(xml.getlocator("//locators/FifthCodec")));
			
			Thread.sleep(3000);
		
			
			Clickon(getwebelement(xml.getlocator("//locators/SixhCodecTextBox")));
			Clear(getwebelement(xml.getlocator("//locators/SixhCodecTextBox")));
			SendKeys(getwebelement(xml.getlocator("//locators/SixhCodecTextBox")), "iLBC end to end IP only");
			Thread.sleep(3000);
		//  Clickon(getwebelement(xml.getlocator("//locators/SixthCodecValue")));
		    
		  			
			Clickon(getwebelement(xml.getlocator("//locators/Save")));
			Thread.sleep(10000);
			
			//Assert.assertTrue("SIP Trunking", true);
			ExtentTestManager.getTest().log(LogStatus.PASS, " SIP Trunking Middle Applet Success ");
		      //	assert equals("SIP Trunking");
			
			/*-------------Voice Config with Trunk 1--------*/
									
					
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPVoiceConfigExpandSymbol"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPVoiceConfigExpandSymbol")));
			
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/SIPTrunkSequence")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPTrunkSequence")),"1");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Trunk Sequence ");
			
			Thread.sleep(5000);
			
			
			Clickon(getwebelement(xml.getlocator("//locators/SIPTrunkName")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPTrunkName")),"Trunk2");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Trunk Name");
			Thread.sleep(3000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/AccessLineTypeDropDown"));
			Clickon(getwebelement(xml.getlocator("//locators/AccessLineTypeDropDown")));
			Thread.sleep(1000);
			WaitforElementtobeclickable(xml.getlocator("//locators/AccessLineType"));
			Clickon(getwebelement(xml.getlocator("//locators/AccessLineType")));
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/AccessServiceIdlookup"));
			Clickon(getwebelement(xml.getlocator("//locators/AccessServiceIdlookup")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Access Service Idlookup ");
			
		
			Thread.sleep(10000);
			WaitforElementtobeclickable(xml.getlocator("//locators/SearchServiceIDbox"));
			Clear(getwebelement(xml.getlocator("//locators/SearchServiceIDbox")));
			Clickon(getwebelement(xml.getlocator("//locators/SearchServiceIDbox")));
			SendKeys(getwebelement(xml.getlocator("//locators/SearchServiceIDbox")), "Product");	
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/SearchText"));
			Clickon(getwebelement(xml.getlocator("//locators/SearchText")));
			SendKeys(getwebelement(xml.getlocator("//locators/SearchText")), "IP Access");
			Thread.sleep(3000);
			WaitforElementtobeclickable(xml.getlocator("//locators/SearchButtonProcess"));
			Clickon(getwebelement(xml.getlocator("//locators/SearchButtonProcess")));
			Thread.sleep(10000);
			WaitforElementtobeclickable(xml.getlocator("//locators/SearchServiceIdOKButton"));
			Clickon(getwebelement(xml.getlocator("//locators/SearchServiceIdOKButton")));
			Thread.sleep(5000);
			
			
		//	SendKeys(getwebelement(xml.getlocator("//locators/ExternalAccessServiceRef")),Inputdata[11].toString());		
		//	ExtentTestManager.getTest().log(LogStatus.PASS, "Enter external access Service reference");
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPCustomerOriginatingIPv4"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPCustomerOriginatingIPv4")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPCustomerOriginatingIPv4")),"10.7.235.29/24");	
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Customer Originating IPv4");
			Thread.sleep(5000);
		
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPCustomerOriginatingIPv6"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPCustomerOriginatingIPv6")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPCustomerOriginatingIPv6")),"10.7.235.29/24");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Customer Originating IPv6");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPCustomerTerminatingIPv4"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPCustomerTerminatingIPv4")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPCustomerTerminatingIPv4")),"10.7.235.2/24");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Customer Terminating IPv4");
			
			Thread.sleep(3000);
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPCustomerTerminatingIPv6"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPCustomerTerminatingIPv6")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPCustomerTerminatingIPv6")),"10.7.235.2/24");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Customer Terminating IPv6 ");
			Thread.sleep(5000);
		
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPSignalingTransportProtocol"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPSignalingTransportProtocol")));
			Thread.sleep(2000);
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPSignalingTransportProtocolDropdown"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPSignalingTransportProtocolDropdown")));
			Thread.sleep(5000);
				
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPvoIPProtocol"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPvoIPProtocol")));
			Thread.sleep(2000);
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPvoIPProtocolDropDown"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPvoIPProtocolDropDown")));
			Thread.sleep(5000);
			
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter SIPvoIPProtocol");
			//	Clickon(getwebelement(xml.getlocator("//locators/SIPvoIPProtocol")));
			Thread.sleep(5000);
		
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPEncryptionType"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPEncryptionType")));
			Clear(getwebelement(xml.getlocator("//locators/SIPEncryptionType")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPEncryptionType")), "TLS on, SRTP off");	
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter SIPEncryptionType");

			Thread.sleep(5000);
							
		//	Clickon(getwebelement(xml.getlocator("//locators/SIPEncryptionDropdownValue")));
			//Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPProportionPercent"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPProportionPercent")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPProportionPercent")),"12");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter SIPProportionPercent");
			Thread.sleep(5000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPTrunkSiteNameAlias"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPTrunkSiteNameAlias")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPTrunkSiteNameAlias")),"Alias1");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter SIPTrunkSiteNameAlias");
			Thread.sleep(5000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPTLSCipherSuiteDropdown"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPTLSCipherSuiteDropdown")));
			Clear(getwebelement(xml.getlocator("//locators/SIPTLSCipherSuiteDropdown")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPTLSCipherSuiteDropdown")),"TLS_RSA_WITH_AES_128_CBC_SHA (Priority 1)");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter SIPTLSCipherSuite");
			Thread.sleep(5000);
					
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPTLSCertifiedSupplier"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPTLSCertifiedSupplier")));	
			Clear(getwebelement(xml.getlocator("//locators/SIPTLSCertifiedSupplier")));
		    SendKeys(getwebelement(xml.getlocator("//locators/SIPTLSCertifiedSupplier")),"NA"); 
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter SIPTLSCertifiedSupplier");		
			Thread.sleep(5000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPNATRequired"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPNATRequired")));					
		    Clear(getwebelement(xml.getlocator("//locators/SIPNATRequired")));
		    SendKeys(getwebelement(xml.getlocator("//locators/SIPNATRequired")),"N");
		 	ExtentTestManager.getTest().log(LogStatus.PASS, "Enter SIPNATRequired");			
			Thread.sleep(5000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPNNIWANIPv4Address"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPNNIWANIPv4Address")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPNNIWANIPv4Address")),"10.7.235.24/2");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter NNI WAN IPv4");			
			Thread.sleep(5000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPNNIWANIPv6Address"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPNNIWANIPv6Address")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPNNIWANIPv6Address")),"10.7.235.24/2");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter NNI WAN IPv6 ");			
			Thread.sleep(5000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPIPv4AddressRangeNAT"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPIPv4AddressRangeNAT")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPIPv4AddressRangeNAT")),"2");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter SIPSignalingTransportProtocol ");
			Thread.sleep(5000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPVLANStartEndRange"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPVLANStartEndRange")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPVLANStartEndRange")),"2");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter VLAN StartEnd Range ");
			Thread.sleep(5000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPVLANID"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPVLANID")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPVLANID")),"2");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter VLANID ");
			Thread.sleep(5000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPASNumber"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPASNumber")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPASNumber")),"1");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter ASNumber ");
			Thread.sleep(5000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPColtHostEquipmentIPv4Address"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPColtHostEquipmentIPv4Address")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPColtHostEquipmentIPv4Address")),"10.7.235.24/2");
			ExtentTestManager.getTest().log(LogStatus.PASS, "EnterColtHostEquipmentIPv4Address ");
			Thread.sleep(5000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPColtHostEquipmentIPv6Address"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPColtHostEquipmentIPv6Address")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPColtHostEquipmentIPv6Address")),"10.7.235.24/2");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter ColtHostEquipmentIPv6Address ");			
			Thread.sleep(5000);
		
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPTrunkMaxNumberofSimoultaniousCalls"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPTrunkMaxNumberofSimoultaniousCalls")));
			Clear(getwebelement(xml.getlocator("//locators/SIPTrunkMaxNumberofSimoultaniousCalls")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPTrunkMaxNumberofSimoultaniousCalls")),"4");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Trunk Max Number of Simoultanious Calls ");
			Thread.sleep(5000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPTrunkInboundOutboundSplit"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPTrunkInboundOutboundSplit")));
			Clear(getwebelement(xml.getlocator("//locators/SIPTrunkInboundOutboundSplit")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPTrunkInboundOutboundSplit")),"No");			
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Trunk Inbound Outbound Split ");
			Thread.sleep(5000);

			WaitforElementtobeclickable(xml.getlocator("//locators/SIPTrunkMaxInboundCalls"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPTrunkMaxInboundCalls")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPTrunkMaxInboundCalls")),"1");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Trunk Max InboundCalls ");
			Thread.sleep(5000);		
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPTrunkOverCallLimitForTrunk"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPTrunkOverCallLimitForTrunk")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPTrunkOverCallLimitForTrunk")),"1");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Trunk Over Call Limit For Trunk ");
			Thread.sleep(5000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPTrunkIncallLimitForTrunk"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPTrunkIncallLimitForTrunk")));		
			SendKeys(getwebelement(xml.getlocator("//locators/SIPTrunkIncallLimitForTrunk")),"10");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Trunk Incall Limit For Trunk ");
			Thread.sleep(5000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPTrunkOutCallLimitForTrunk"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPTrunkOutCallLimitForTrunk")));				
			SendKeys(getwebelement(xml.getlocator("//locators/SIPTrunkOutCallLimitForTrunk")),"1");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Trunk Out Call Limit For Trunk");
			Thread.sleep(5000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPTrunkTypeofCAC"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPTrunkTypeofCAC")));		
			Clear(getwebelement(xml.getlocator("//locators/SIPTrunkTypeofCAC")));
		//	Clickon(getwebelement(xml.getlocator("//locators/SIPTrunkTypeofCACDropDown")));	
		//	Clickon(getwebelement(xml.getlocator("//locators/SIPTrunkTypeofCACDropDownSelect")));	
			SendKeys(getwebelement(xml.getlocator("//locators/SIPTrunkTypeofCAC")),"Individual Trunk CAC");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Trunk Type of CAC ");
			Thread.sleep(10000);
			
					
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPCustomerIPPbxIdTab"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPCustomerIPPbxIdTab")));
			
			Thread.sleep(5000);
	
			Clickon(getwebelement(xml.getlocator("//locators/SIPAddrecordSymbolIPPBX")));
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPIPPBXAliasName"));					
			Clickon(getwebelement(xml.getlocator("//locators/SIPIPPBXAliasName")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click IPPBX Alias Name Field");
			Thread.sleep(5000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPIPPBXAliasNameInputField"));			
			Clickon(getwebelement(xml.getlocator("//locators/SIPIPPBXAliasNameInputField")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPIPPBXAliasNameInputField")),"test1");
		//	SendkeaboardKeys(getwebelement(xml.getlocator("//locators/SIPIPPBXAliasNameInputField")), Keys.TAB);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter IPPBX Alias Name Field");
			Thread.sleep(5000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPIPPBXModel"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPIPPBXModel")));
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/SIPIPPBXModelInput")));
		
			SendKeys(getwebelement(xml.getlocator("//locators/SIPIPPBXModelInput")),"SWE Lite7.0");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click IPPBX Model");
	
			Thread.sleep(5000);
		
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPIPPBXVendor"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPIPPBXVendor")));
			Thread.sleep(2000);
			Clickon(getwebelement(xml.getlocator("//locators/SIPIPPBXVendorInput")));
			
			SendKeys(getwebelement(xml.getlocator("//locators/SIPIPPBXVendorInput")),"Sonus");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click IPPBX Vendor");
			Thread.sleep(5000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPSOftwareVersionField"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPSOftwareVersionField")));
			Thread.sleep(1000);
			Clickon(getwebelement(xml.getlocator("//locators/SIPSoftwareVersionInput")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPSoftwareVersionInput")),"1");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click IPPBX Version");
			Thread.sleep(5000);
				
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPIPPBXAddressUID"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPIPPBXAddressUID")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Address UID");			
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPIPPBXLookupoptionClick"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPIPPBXLookupoptionClick"))); 
			
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPIPPBXAddressUIDStreetName"));		
			Clickon(getwebelement(xml.getlocator("//locators/SIPIPPBXAddressUIDStreetName")));
		//	Thread.sleep(3000);		
			SendKeys(getwebelement(xml.getlocator("//locators/SIPIPPBXAddressUIDStreetName")),"Parker");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Street Name ");
			Thread.sleep(5000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPIPPBXAddressUIDCountryName"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPIPPBXAddressUIDCountryName")));
		//	Thread.sleep(3000);
			SendKeys(getwebelement(xml.getlocator("//locators/SIPIPPBXAddressUIDCountryName")),"United Kingdom");
	//		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/SIPIPPBXAddressUIDCountryName")), Keys.TAB);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Country");
			Thread.sleep(5000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPIPPBXAddressUIDCityName"));		
			Clickon(getwebelement(xml.getlocator("//locators/SIPIPPBXAddressUIDCityName")));
		//	Thread.sleep(3000);
			SendKeys(getwebelement(xml.getlocator("//locators/SIPIPPBXAddressUIDCityName")),"London");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter City");
			Thread.sleep(3000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPIPPBXAddressUIDPostalCode"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPIPPBXAddressUIDPostalCode")));
		//	Thread.sleep(2000);
			SendKeys(getwebelement(xml.getlocator("//locators/SIPIPPBXAddressUIDPostalCode")),"*");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Postal Code");
			Thread.sleep(3000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPIPPBXAddressUIDPremiseCode"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPIPPBXAddressUIDPremiseCode")));
		//	Thread.sleep(2000);
			SendKeys(getwebelement(xml.getlocator("//locators/SIPIPPBXAddressUIDPremiseCode")),"*");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Premise Code");
			Thread.sleep(3000);
			
			//Click Address search button
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPAddressUIDSearchButton"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPAddressUIDSearchButton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, "Click on Address Search button ");
			Thread.sleep(5000);
			
			//Select address record
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPSelectAddressRecord"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPSelectAddressRecord")));
			ExtentTestManager.getTest().log(LogStatus.PASS, "Select Address record ");
			Thread.sleep(5000);
			
			//Click Pick address button
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPPickAddressButtonForUID"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPPickAddressButtonForUID")));
			ExtentTestManager.getTest().log(LogStatus.PASS, "Click Pick Address button ");
			Thread.sleep(5000);
			
		    //IPBX Technical Contact
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPPBXTechnicalContact"));	
			Clickon(getwebelement(xml.getlocator("//locators/SIPPBXTechnicalContact")));
		//	ExtentTestManager.getTest().log(LogStatus.PASS, "Click IP PBX Technical Contact ");
		//	Thread.sleep(3000);			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPPBXTecnicalContactLookup"));	
			Clickon(getwebelement(xml.getlocator("//locators/SIPPBXTecnicalContactLookup")));
		//	ExtentTestManager.getTest().log(LogStatus.PASS, "Click Lookup ");
			Thread.sleep(5000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPPBXTechnicalContactLookupOKButton"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPPBXTechnicalContactLookupOKButton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, "Click OK ");
			
			Thread.sleep(10000);
			
			savePage();  //saving IP PBX details
			
			//click on Voice Config tab to enter the IP PBX details
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPVoiceConfigTab"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPVoiceConfigTab"))); 
			Thread.sleep(10000);
			// Selection of IP PBX in TRUNK --
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPVoiceConfigExpandSymbolIPPBXSelewction"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPVoiceConfigExpandSymbolIPPBXSelewction"))); 
			Thread.sleep(5000);
						
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPReClickToIPPBXLookUp"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPReClickToIPPBXLookUp")));
			ExtentTestManager.getTest().log(LogStatus.PASS, "Click ");
			
			Thread.sleep(5000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPOKSelectionButton"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPOKSelectionButton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, "Click ");
			
			Thread.sleep(5000);
			/* ABove code for Trunk including IPPBX code*/
					
			//Other Tab in Voice Config 		
		
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/SIPOtherTab")));
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPOtherTab"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPOtherTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  Other Tab");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPVoiceConfigOthersTabShowFullInfo"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPVoiceConfigOthersTabShowFullInfo")));
			Thread.sleep(10000);
			//Select Colt DDI Ranges
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPVoiceConfigOthersTabColtDDIRanges"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPVoiceConfigOthersTabColtDDIRanges")));
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPNumberOfSingleColtDDIs"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPNumberOfSingleColtDDIs")));
			Clear(getwebelement(xml.getlocator("//locators/SIPNumberOfSingleColtDDIs")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPNumberOfSingleColtDDIs")),"1");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Number Of single Colt DDI ");
			Thread.sleep(5000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPNumberOf10ColtDDIRanges"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPNumberOf10ColtDDIRanges")));
			Clear(getwebelement(xml.getlocator("//locators/SIPNumberOf10ColtDDIRanges")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPNumberOf10ColtDDIRanges")),"1");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Number Of Colt DDI Range ");
			Thread.sleep(5000);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPNumberOf100ColtDDIRanges"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPNumberOf100ColtDDIRanges")));
			Clear(getwebelement(xml.getlocator("//locators/SIPNumberOf100ColtDDIRanges")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPNumberOf100ColtDDIRanges")),"1");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Number of COlt DDI Ranges");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPNumberOf1000ColtDDIRanges"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPNumberOf1000ColtDDIRanges")));
			Clear(getwebelement(xml.getlocator("//locators/SIPNumberOf1000ColtDDIRanges")));
			SendKeys(getwebelement(xml.getlocator("//locators/SIPNumberOf1000ColtDDIRanges")),"1");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Number of Colt Ranges ");
			Thread.sleep(3000);
			WaitforElementtobeclickable(xml.getlocator("//locators/SIPVoiceConfigOthersTabColtDDIRangesCloseWindow"));
			Clickon(getwebelement(xml.getlocator("//locators/SIPVoiceConfigOthersTabColtDDIRangesCloseWindow")));
			ExtentTestManager.getTest().log(LogStatus.PASS, "Colt DDI Ranges window closed");
			Thread.sleep(5000);
			savePage();
		}

		/* End Of SIP  Gauri Update Trunking*/

		case "Voice Line V": {

			WaitforElementtobeclickable(xml.getlocator("//locators/VoiceServiceCountryDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/VoiceServiceCountryDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/VoiceServiceInputValue"));
			Clickon(getwebelement(xml.getlocator("//locators/VoiceServiceInputValue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Voice Service Country");
			Thread.sleep(5000);
			
				
			WaitforElementtobeclickable(xml.getlocator("//locators/EgressNumberFormatDropDownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/EgressNumberFormatDropDownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/EgreeNUmberFormat"));
			Clickon(getwebelement(xml.getlocator("//locators/EgreeNUmberFormat")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on EgreeNumberFormat");

			WaitforElementtobeclickable(xml.getlocator("//locators/TopologyDropDown"));
			Clickon(getwebelement(xml.getlocator("//locators/TopologyDropDown")));
			// Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/Topology"));
			Clickon(getwebelement(xml.getlocator("//locators/Topology")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Topology");

			WaitforElementtobeclickable(xml.getlocator("//locators/TotalDDi"));
			Clickon(getwebelement(xml.getlocator("//locators/TotalDDi")));
			SendKeys(getwebelement(xml.getlocator("//locators/TotalDDi")), "4");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/TotalDDi")), Keys.ENTER);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Total DDI");
			Thread.sleep(5000);
			
			
			WaitforElementtobeclickable(xml.getlocator("//locators/CustomerdefaultNumber"));
			Clickon(getwebelement(xml.getlocator("//locators/CustomerdefaultNumber")));
			Clear(getwebelement(xml.getlocator("//locators/CustomerdefaultNumber")));
			SendKeys(getwebelement(xml.getlocator("//locators/CustomerdefaultNumber")), "1234");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/CustomerdefaultNumber")), Keys.ENTER);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on CustomerdefaultNumber");
			Thread.sleep(5000);

			WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			// WaitforElementtobeclickable(xml.getlocator("//locators/IpGurdianSave"));
			Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
			// Pagerefresh();
			// Thread.sleep(8000);
			waitforPagetobeenable();
			Clickon(getwebelement(xml.getlocator("//locators/Clicktoshowfullinfo")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Show full infor");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/SiteContactlookup")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Site Contact Search");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/Site_Contact")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Submit Site Contact");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ServicePartsearch")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Site Contact Search");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/PickAccntOk")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Submit Service party");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/DeliveryTeamDropDown"));
			Clickon(getwebelement(xml.getlocator("//locators/DeliveryTeamDropDown")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Delivery Tram drop down");
			// Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/DeliveryTeamCountry"));
			Clickon(getwebelement(xml.getlocator("//locators/DeliveryTeamCountry")));
			SendKeys(getwebelement(xml.getlocator("//locators/DeliveryTeamCountry")), Inputdata[78].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Delivery Team Country");
			Thread.sleep(10000);

			WaitforElementtobeclickable(xml.getlocator("//locators/DeliveryTeamCity"));
			Clickon(getwebelement(xml.getlocator("//locators/DeliveryTeamCity")));
			SendKeys(getwebelement(xml.getlocator("//locators/DeliveryTeamCity")), "Vienna");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/DeliveryTeamCity")), Keys.ENTER);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Delivery Team City");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/PerformanceReporting"));
			Clickon(getwebelement(xml.getlocator("//locators/PerformanceReporting")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Performance Reporting");
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/WLECInvoicing"));
			Clickon(getwebelement(xml.getlocator("//locators/WLECInvoicing")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on WLECInvoicing");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/Crossbutton")));
			Thread.sleep(5000);
			WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on save");

			waitforPagetobeenable();
			Thread.sleep(30000);

			break;
		}
		case "Interconnect": {

			WaitforElementtobeclickable(xml.getlocator("//locators/VoiceServiceCountry"));
			Clickon(getwebelement(xml.getlocator("//locators/VoiceServiceCountry")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on voice service country");
			Clickon(getwebelement(
					xml.getlocator("//locators/VoiceServiceCountryValue").replace("value", Inputdata[76].toString())));

			System.out.println("go to if loop of call admission control");
			Clear(getwebelement(xml.getlocator("//locators/CallAdmissionControl")));
			Thread.sleep(6000);
			SendKeys(getwebelement(xml.getlocator("//locators/CallAdmissionControl")), "8");
			Thread.sleep(3000);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter call admission control");

			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/CallAdmissionControl")), Keys.TAB);

			Clear(getwebelement(xml.getlocator("//locators/NumberOfSignallingTrunks")));
			Thread.sleep(4000);
			SendKeys(getwebelement(xml.getlocator("//locators/NumberOfSignallingTrunks")), "4");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter number of signalling trunks");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/NumberOfSignallingTrunks")), Keys.TAB);

			Clear(getwebelement(xml.getlocator("//locators/VoiceConfigurationReference")));
			Thread.sleep(4000);
			SendKeys(getwebelement(xml.getlocator("//locators/VoiceConfigurationReference")), "yes");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter voice configuration reference");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/VoiceConfigurationReference")), Keys.TAB);

			WaitforElementtobeclickable(xml.getlocator("//locators/TrafficDirection"));
			Clickon(getwebelement(xml.getlocator("//locators/TrafficDirection")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on traffic direction");
			Clickon(getwebelement(
					xml.getlocator("//locators/VoiceServiceCountryValue").replace("value", Inputdata[77].toString())));

			Clickon(getwebelement(xml.getlocator("//locators/ClickDropdown").replace("Value", "First Codec")));
			Clickon(getwebelement(xml.getlocator("//locators/SelectValueDropdown").replace("Value", "G.722.1")));

			Clickon(getwebelement(xml.getlocator("//locators/ClickLink").replace("Value", "Show More")));
			Thread.sleep(3000);

			Clickon(getwebelement(xml.getlocator("//locators/ClickDropdown").replace("Value", "Second Codec")));

			// System.out.println(xml.getlocator("//locators/SelectValueDropdown").replace("Value",
			// "G.722.1")+"[2]");
			Clickon(getwebelement(
					xml.getlocator("//locators/SelectValueDropdown").replace("Value", "G.722.1") + "[2]"));

			Clickon(getwebelement(xml.getlocator("//locators/ClickDropdown").replace("Value", "Third Codec")));
			Thread.sleep(2000);
			Clickon(getwebelement(
					xml.getlocator("//locators/SelectValueDropdown").replace("Value", "G.722.1") + "[3]"));

			Clear(getwebelement(xml.getlocator("//locators/TextInput").replace("Value", "Fourth Codec")));
			SendKeys(getwebelement(xml.getlocator("//locators/TextInput").replace("Value", "Fourth Codec")), "G.729");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/TextInput").replace("Value", "Fourth Codec")),
					Keys.ENTER);

			Clear(getwebelement(xml.getlocator("//locators/TextInput").replace("Value", "Fifth Codec")));
			SendKeys(getwebelement(xml.getlocator("//locators/TextInput").replace("Value", "Fifth Codec")), "G.729");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/TextInput").replace("Value", "Fifth Codec")),
					Keys.ENTER);

			Clear(getwebelement(xml.getlocator("//locators/TextInput").replace("Value", "Sixth Codec")));
			SendKeys(getwebelement(xml.getlocator("//locators/TextInput").replace("Value", "Sixth Codec")), "G.729");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/TextInput").replace("Value", "Sixth Codec")),
					Keys.ENTER);
			Thread.sleep(5000);

			WaitforElementtobeclickable(xml.getlocator("//locators/SaveButton"));
			Clickon(getwebelement(xml.getlocator("//locators/SaveButton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on save button");
			waitforPagetobeenable();
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/ShowMore"));
			Clickon(getwebelement(xml.getlocator("//locators/ShowMore")));

			WaitforElementtobeclickable(xml.getlocator("//locators/ClickToShowFullInfo"));
			Clickon(getwebelement(xml.getlocator("//locators/ClickToShowFullInfo")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on click to show full info");
			waitforPagetobeenable();

			WaitforElementtobeclickable(xml.getlocator("//locators/SiteContact"));
			Clickon(getwebelement(xml.getlocator("//locators/SiteContact")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on site contact");
			waitforPagetobeenable();
			WaitforElementtobeclickable(xml.getlocator("//locators/OkButton"));
			Clickon(getwebelement(xml.getlocator("//locators/OkButton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on ok button of site contact");
			waitforPagetobeenable();

			WaitforElementtobeclickable(xml.getlocator("//locators/ServiceParty"));
			Clickon(getwebelement(xml.getlocator("//locators/ServiceParty")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on service party");
			waitforPagetobeenable();
			WaitforElementtobeclickable(xml.getlocator("//locators/OkButtonService"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on ok button of service party");
			Clickon(getwebelement(xml.getlocator("//locators/OkButtonService")));
			waitforPagetobeenable();

			WaitforElementtobeclickable(xml.getlocator("//locators/DelieveryTeamCountry"));
			Clickon(getwebelement(xml.getlocator("//locators/DelieveryTeamCountry")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on deleiver team country");
			Clickon(getwebelement(
					xml.getlocator("//locators/VoiceServiceCountryValue").replace("value", Inputdata[80].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter value in deleiver team country");

			SendKeys(getwebelement(xml.getlocator("//locators/DeliveryTeamCity")), "Shanghai");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter value in deleiver team city");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/DeliveryTeamCity")), Keys.TAB);

			WaitforElementtobeclickable(xml.getlocator("//locators/CrossButtonTrunk"));
			Clickon(getwebelement(xml.getlocator("//locators/CrossButtonTrunk")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on cross button");
			waitforPagetobeenable();

			WaitforElementtobeclickable(xml.getlocator("//locators/SaveButton"));
			Clickon(getwebelement(xml.getlocator("//locators/SaveButton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on save button");
			waitforPagetobeenable();

			javascriptexecutor(getwebelement(xml.getlocator("//locators/TrunkConfiguration")));
			SendKeys(getwebelement(xml.getlocator("//locators/TrunkSequence")), "1");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter value in trunk sequence");

			SendKeys(getwebelement(xml.getlocator("//locators/TrunkName")), "Trunk1");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter value in trunk name");

			WaitforElementtobeclickable(xml.getlocator("//locators/AccessLineType"));
			Clickon(getwebelement(xml.getlocator("//locators/AccessLineType")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on access line type");
			Clickon(getwebelement(
					xml.getlocator("//locators/VoiceServiceCountryValue").replace("value", Inputdata[81].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter value in access line type");

			WaitforElementtobeclickable(xml.getlocator("//locators/AccessServiceID"));
			Clickon(getwebelement(xml.getlocator("//locators/AccessServiceID")));

			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on access service id");
			waitForpageload();
			System.out.println("page load successfully for service id in middle applet");
			WaitforElementtobeclickable(xml.getlocator("//locators/OkButtonAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/OkButtonAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on ok button");

			if (isElementPresent(xml.getlocator("//locators/ShowFullInfoTrunk"))) {
				System.out.println("full trunk info is available");
				WaitforElementtobeclickable(xml.getlocator("//locators/ShowFullInfoTrunk"));
				Clickon(getwebelement(xml.getlocator("//locators/ShowFullInfoTrunk")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on ShowFullInfoTrunk");

			}

			WaitforElementtobeclickable(xml.getlocator("//locators/AddButtonTrunk"));
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/AddButtonTrunk")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on plus button");

			WaitforElementtobeclickable(xml.getlocator("//locators/CustomerOriginatingIP4Address"));
			SendKeys(getwebelement(xml.getlocator("//locators/CustomerOriginatingIP4Address")), "192.168.1.1");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter value in customer originating IPV4 address");
			Thread.sleep(3000);
			SendKeys(getwebelement(xml.getlocator("//locators/CustomerOriginatingIP6Address")), "192.18.1.1");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter value in customer originating IPV6 address");

			SendKeys(getwebelement(xml.getlocator("//locators/CustomerTerminatingIP4Address")), "38.168.1.1");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter value in customer terminating IPV4 address");

			SendKeys(getwebelement(xml.getlocator("//locators/CustomerTerminatingIP6Address")), "38.168.1.1");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter value in customer terminating IPV6 address");

			WaitforElementtobeclickable(xml.getlocator("//locators/SignallingTransportProtocol"));
			Clickon(getwebelement(xml.getlocator("//locators/SignallingTransportProtocol")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on signalling transport protocol");
			Clickon(getwebelement(
					xml.getlocator("//locators/VoiceServiceCountryValue").replace("value", Inputdata[82].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter value in signalling transport protocol");

			WaitforElementtobeclickable(xml.getlocator("//locators/VoipProtocol"));
			Clickon(getwebelement(xml.getlocator("//locators/VoipProtocol")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on voip protocol");
			Clickon(getwebelement(
					xml.getlocator("//locators/VoiceServiceCountryValue").replace("value", Inputdata[83].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter value in Voip protocol");

			WaitforElementtobeclickable(xml.getlocator("//locators/EncryptionProtocol"));
			Clickon(getwebelement(xml.getlocator("//locators/EncryptionProtocol")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on encryption protocol");
			Clickon(getwebelement(
					xml.getlocator("//locators/VoiceServiceCountryValue").replace("value", Inputdata[84].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter value in encryption protocol");

			WaitforElementtobeclickable(xml.getlocator("//locators/TLSCipherSuite"));
			Clickon(getwebelement(xml.getlocator("//locators/TLSCipherSuite")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on TLSCipherSuite");
			Clickon(getwebelement(
					xml.getlocator("//locators/VoiceServiceCountryValue").replace("value", Inputdata[85].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter value in TLSCipherSuite");

			WaitforElementtobeclickable(xml.getlocator("//locators/TLSCertificateSupplier"));
			Clickon(getwebelement(xml.getlocator("//locators/TLSCertificateSupplier")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on TLSCertificateSupplier");
			Clickon(getwebelement(
					xml.getlocator("//locators/VoiceServiceCountryValue2").replace("value", Inputdata[86].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter value in TLSCertificateSupplier");

			Clear(getwebelement(xml.getlocator("//locators/NATRequired")));
			SendKeys(getwebelement(xml.getlocator("//locators/NATRequired")), "N");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter value in NATR");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/NATRequired")), Keys.TAB);

			javascriptexecutor(getwebelement(xml.getlocator("//locators/CallAdmissionControl")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Scroll down ");
			WaitforElementtobeclickable(xml.getlocator("//locators/InboundOutboundSplit"));
			Clear(getwebelement(xml.getlocator("//locators/InboundOutboundSplit")));
			SendKeys(getwebelement(xml.getlocator("//locators/InboundOutboundSplit")), "No");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter value in InboundOutboundSplit field");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/InboundOutboundSplit")), Keys.TAB);

			WaitforElementtobeclickable(xml.getlocator("//locators/TypeOfCAC"));
			Clickon(getwebelement(xml.getlocator("//locators/TypeOfCAC")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on voip protocol");
			Clickon(getwebelement(
					xml.getlocator("//locators/VoiceServiceCountryValue").replace("value", Inputdata[87].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter value in TypeOfCAC field");

			WaitforElementtobeclickable(xml.getlocator("//locators/CrossButtonTrunk"));
			Clickon(getwebelement(xml.getlocator("//locators/CrossButtonTrunk")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on cross button");
			waitforPagetobeenable();

			WaitforElementtobeclickable(xml.getlocator("//locators/SaveButton"));
			Clickon(getwebelement(xml.getlocator("//locators/SaveButton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on save button");
			waitforPagetobeenable();

			WaitforElementtobeclickable(xml.getlocator("//locators/VoiceTab"));
			Clickon(getwebelement(xml.getlocator("//locators/VoiceTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on voice feature tab");

			WaitforElementtobeclickable(xml.getlocator("//locators/VoiceTab"));
			Clickon(getwebelement(xml.getlocator("//locators/VoiceTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on voice feature tab");
			waitforPagetobeenable();
			waitForpageload();

			WaitforElementtobeclickable(xml.getlocator("//locators/Resillence"));
			Clickon(getwebelement(xml.getlocator("//locators/Resillence")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on resillence dropdown");
			Clickon(getwebelement(
					xml.getlocator("//locators/VoiceServiceCountryValue").replace("value", Inputdata[88].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on resillence value ");

			WaitforElementtobeclickable(xml.getlocator("//locators/SaveButton"));
			Clickon(getwebelement(xml.getlocator("//locators/SaveButton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on save button");
			waitforPagetobeenable();
			waitForpageload();

//		WaitforElementtobeclickable(xml.getlocator("//locators/ServiceGroupTab"));
//		Clickon(getwebelement(xml.getlocator("//locators/ServiceGroupTab")));
//		ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on service tab");

			Select(getwebelement(xml.getlocator("//locators/InstalltionDropdown")), "Service Group");
			ExtentTestManager.getTest().log(LogStatus.PASS,
					" Step: Click on Installation Dropdown button and Select Installation and Test");

			waitforPagetobeenable();
			waitForpageload();
			waitandForElementDisplay(xml.getlocator("//locators/ClickOnPlusButtonService"), 5);
			WaitforElementtobeclickable(xml.getlocator("//locators/ClickOnPlusButtonService"));
			Clickon(getwebelement(xml.getlocator("//locators/ClickOnPlusButtonService")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on plus button");
			waitforPagetobeenable();

			waitandForElementDisplay(xml.getlocator("//locators/ServiceGroupReference"), 5);
			WaitforElementtobeclickable(xml.getlocator("//locators/ServiceGroupReference"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on service reference");
			Clickon(getwebelement(xml.getlocator("//locators/ServiceGroupReference")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on plus button");
			waitforPagetobeenable();

			WaitforElementtobeclickable(xml.getlocator("//locators/ClickOkButton"));
			Clickon(getwebelement(xml.getlocator("//locators/ClickOkButton")));
			waitforPagetobeenable();
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on ok button");

			break;

		}
		case "IP Access": {

			WaitforElementtobeclickable(xml.getlocator("//locators/capacitycheckreference"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: wait on Capicityreference");
			getwebelement(xml.getlocator("//locators/capacitycheckreference")).clear();
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear capicity check reference");
			Clickon(getwebelement(xml.getlocator("//locators/capacitycheckreference")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:  click on Capicityreference");
			SendKeys(getwebelement(xml.getlocator("//locators/capacitycheckreference")), Inputdata[36].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:  Input on Capicityreference");
			// Thread.sleep(4000);

			WaitforElementtobeclickable(xml.getlocator("//locators/Inputossplatformflag"));
			Clickon(getwebelement(xml.getlocator("//locators/Inputossplatformflag")));
			SendKeys(getwebelement(xml.getlocator("//locators/Inputossplatformflag")), Inputdata[38].toString());
			// SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Inputossplatformflag")),Keys.TAB);

			// Thread.sleep(4000);

			WaitforElementtobeclickable(xml.getlocator("//locators/RouterTypeDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/RouterTypeDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/SelectRouterTypeDropDownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/SelectRouterTypeDropDownAccess")));
			// Thread.sleep(4000);
			// getwebelement(xml.getlocator("//locators/Routertype")).clear();
			// SendKeys(getwebelement(xml.getlocator("//locators/Routertype")),Inputdata[37].toString());
			// SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Routertype")),Keys.TAB);

			// WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			// WaitforElementtobeclickable(xml.getlocator("//locators/IpGurdianSave"));
			// Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));

			// Thread.sleep(6000);

			// Pagerefresh();
			// Thread.sleep(6000);

			WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			// WaitforElementtobeclickable(xml.getlocator("//locators/IpGurdianSave"));
			Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));

			waitforPagetobeenable();

			WaitforElementtobeclickable(xml.getlocator("//locators/Layer3ResillanceDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/Layer3ResillanceDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/Layer3ResillanceSelectDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/Layer3ResillanceSelectDropdownAccess")));
			// getwebelement(xml.getlocator("//locators/Layer3ResillanceDropdownAccess")).clear();
			// SendKeys(getwebelement(xml.getlocator("//locators/Inputlayer3resillence")),Inputdata[39].toString());
			// SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Inputlayer3resillence")),Keys.ENTER);
			// SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Inputlayer3resillence")),Keys.TAB);
			// Thread.sleep(4000);

			WaitforElementtobeclickable(xml.getlocator("//locators/ServiceBandwidthDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/ServiceBandwidthDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/ServiceBandwidthSelectAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/ServiceBandwidthSelectAccess")));
			// getwebelement(xml.getlocator("//locators/ServiceBandwidthIPAccess")).clear();
			// SendKeys(getwebelement(xml.getlocator("//locators/ServiceBandwidthIPAccess")),Inputdata[40].toString());
			// EnterText(xml.getlocator("//locators/ServiceBandwidthIPAccess"),Inputdata[40].toString());
			// SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ServiceBandwidthIPAccess")),Keys.ENTER);
			// SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ServiceBandwidthIPAccess")),Keys.TAB);
			// Thread.sleep(4000);
			// Pagerefresh();

			WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			// WaitforElementtobeclickable(xml.getlocator("//locators/IpGurdianSave"));
			Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));

			waitforPagetobeenable();

			// Pagerefresh();
			// Thread.sleep(6000);

			// getwebelement(xml.getlocator("//locators/RouterTechnologyAccess")).clear();
			// SendKeys(getwebelement(xml.getlocator("//locators/RouterTechnologyAccess")),Inputdata[41].toString());
			// Thread.sleep(2000);

			WaitforElementtobeclickable(xml.getlocator("//locators/SelectSiteSearchAccess"));
			Moveon(getwebelement(xml.getlocator("//locators/SelectSiteSearchAccess")));
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/SelectSiteSearchAccess")));
			System.out.println("Enter Search ");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search Site");
			WaitforElementtobeclickable(xml.getlocator("//locators/StreetNameAccess"));
			SendKeys(getwebelement(xml.getlocator("//locators/StreetNameAccess")), Inputdata[61].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Street Name");
			WaitforElementtobeclickable(xml.getlocator("//locators/CountryAccess"));
			SendKeys(getwebelement(xml.getlocator("//locators/CountryAccess")), Inputdata[62].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Country");
			SendKeys(getwebelement(xml.getlocator("//locators/CityTownAccess")), Inputdata[63].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter City");
			SendKeys(getwebelement(xml.getlocator("//locators/PostalCodeAccess")), Inputdata[64].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Postal Code");
			SendKeys(getwebelement(xml.getlocator("//locators/PremisesAccess")), Inputdata[65].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Premises");
			Clickon(getwebelement(xml.getlocator("//locators/SearchButtonAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search");
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/SelectPickAddressAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Address for Site");
			Clickon(getwebelement(xml.getlocator("//locators/PickAddressButtonAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Submit Address for Site");
			Clickon(getwebelement(xml.getlocator("//locators/SelectPickBuildingAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Buiding for Site");
			Clickon(getwebelement(xml.getlocator("//locators/PickBuildingButtonAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Submit Buiding for Site");
			Clickon(getwebelement(xml.getlocator("//locators/SelectPickSiteAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Site");
			Clickon(getwebelement(xml.getlocator("//locators/PickSiteButtonAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Submit Site");
			Thread.sleep(10000);

			WaitforElementtobeclickable(xml.getlocator("//locators/IpGurdianSave"));
			Clickon(getwebelement(xml.getlocator("//locators/IpGurdianSave")));
			// Thread.sleep(8000);

			waitforPagetobeenable();

			WaitforElementtobeclickable(xml.getlocator("//locators/ServicePartySearchAccess"));
			Moveon(getwebelement(xml.getlocator("//locators/ServicePartySearchAccess")));
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/ServicePartySearchAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Search Service Party");

			// System.out.println("EnterService");
			waitandForElementDisplay((xml.getlocator("//locators/ServicePartyDropdownAccess")), 8);

			WaitforElementtobeclickable(xml.getlocator("//locators/ServicePartyDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/ServicePartyDropdownAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Service Party Dropdown");

			Clickon(getwebelement(xml.getlocator("//locators/PartyNameAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Party Name");

			SendKeys(getwebelement(xml.getlocator("//locators/InputPartyNameAccess")), Inputdata[69].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Party Name");

			Clickon(getwebelement(xml.getlocator("//locators/PartyNameSearchAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click On Search");

			Thread.sleep(2000);
			Clickon(getwebelement(xml.getlocator("//locators/PartyNameSubmitAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click On Submit");

			WaitforElementtobeclickable(xml.getlocator("//locators/SiteContactSearchAccess"));
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/SiteContactSearchAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Search Site Contact");

			waitandForElementDisplay((xml.getlocator("//locators/SiteContactDropdownAccess")), 8);
			WaitforElementtobeclickable(xml.getlocator("//locators/SiteContactDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/SiteContactDropdownAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Site Name Dropdown");

			// waitandForElementDisplay((xml.getlocator("//locators/SiteLastNameAccess")),8);
			// WaitforElementtobeclickable(xml.getlocator("//locators/SiteLastNameAccess"));
			// Thread.sleep(8000);
			// Clickon(getwebelement(xml.getlocator("//locators/SiteLastNameAccess")));
			// System.out.println("Last Name Click");
			// ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Last Name");

			WaitforElementtobeclickable(xml.getlocator("//locators/InputSiteNameAccess"));
			SendKeys(getwebelement(xml.getlocator("//locators/InputSiteNameAccess")), Inputdata[70].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Site Name");

			WaitforElementtobeclickable(xml.getlocator("//locators/LastNameSiteSearchAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/LastNameSiteSearchAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click On Search");

			WaitforElementtobeclickable(xml.getlocator("//locators/LastNameSiteSubmitAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/LastNameSiteSubmitAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click On Submit");

			WaitforElementtobeclickable(xml.getlocator("//locators/IpGurdianSave"));
			Clickon(getwebelement(xml.getlocator("//locators/IpGurdianSave")));
			// Thread.sleep(8000);

			waitforPagetobeenable();

			WaitforElementtobeclickable(xml.getlocator("//locators/AccessTypeDropdownAccess"));
			// Clear(getwebelement(xml.getlocator("//locators/Accesstype")));
			// SendKeys(getwebelement(xml.getlocator("//locators/Accesstype")),Inputdata[42].toString());
			// SendkeaboardKeys((getwebelement(xml.getlocator("//locators/Accesstype"))),
			// Keys.TAB);
			Clickon(getwebelement(xml.getlocator("//locators/AccessTypeDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/AccessTypeSelectAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/AccessTypeSelectAccess")));
			// Thread.sleep(4000);

			WaitforElementtobeclickable(xml.getlocator("//locators/AccesstechnologyDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/AccesstechnologyDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/AccesstechnologySelectAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/AccesstechnologySelectAccess")));
			// getwebelement(xml.getlocator("//locators/Accesstechnology")).clear();
			// SendKeys(getwebelement(xml.getlocator("//locators/Accesstechnology")),Inputdata[43].toString());
			// SendkeaboardKeys((getwebelement(xml.getlocator("//locators/Accesstechnology"))),
			// Keys.TAB);
			// Thread.sleep(4000);

			// WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			// WaitforElementtobeclickable(xml.getlocator("//locators/IpGurdianSave"));
			// Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
			// Thread.sleep(8000);
			// Pagerefresh();
			// Thread.sleep(8000);
			// getwebelement(xml.getlocator("//locators/Thirdpartyaccessprovider")).clear();
			// SendKeys(getwebelement(xml.getlocator("//locators/Thirdpartyaccessprovider")),Inputdata[0].toString());
			// SendKeys(getwebelement(xml.getlocator("//locators/relayfibre")),Inputdata[0].toString());
			// WaitforElementtobeclickable(xml.getlocator("//locators/Thirdpartyconectionreference"));
			// getwebelement(xml.getlocator("//locators/Thirdpartyconectionreference")).clear();
			// SendKeys(getwebelement(xml.getlocator("//locators/Thirdpartyconectionreference")),Inputdata[44].toString());
			// SendkeaboardKeys((getwebelement(xml.getlocator("//locators/Thirdpartyconectionreference"))),
			// Keys.TAB);
			// Thread.sleep(4000);

			// Pagerefresh();
			// Thread.sleep(8000);

			// Clear(getwebelement(xml.getlocator("//locators/Thirdpartyslrtier")));
			// SendKeys(getwebelement(xml.getlocator("//locators/Thirdpartyslrtier")),Inputdata[0].toString());

			WaitforElementtobeclickable(xml.getlocator("//locators/BuildingTypeDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/BuildingTypeDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/BuildingTypeSelectAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/BuildingTypeSelectAccess")));
			// Clear(getwebelement(xml.getlocator("//locators/Buildingtype")));
			// SendKeys(getwebelement(xml.getlocator("//locators/Buildingtype")),Inputdata[45].toString());
			// SendkeaboardKeys((getwebelement(xml.getlocator("//locators/Buildingtype"))),
			// Keys.TAB);
			// Thread.sleep(4000);

			WaitforElementtobeclickable(xml.getlocator("//locators/CustomerSitePopStatusDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/CustomerSitePopStatusDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/CustomerSitePopStatusSelectAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/CustomerSitePopStatusSelectAccess")));
			// getwebelement(xml.getlocator("//locators/CustomerSitePopStatus")).clear();
			// SendKeys(getwebelement(xml.getlocator("//locators/CustomerSitePopStatus")),Inputdata[46].toString());
			// SendkeaboardKeys((getwebelement(xml.getlocator("//locators/CustomerSitePopStatus"))),
			// Keys.TAB);
			// Thread.sleep(4000);

			WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			// WaitforElementtobeclickable(xml.getlocator("//locators/IpGurdianSave"));
			Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));

			waitforPagetobeenable();
			WaitforElementtobeclickable((xml.getlocator("//locators/AlertAccept")));
			Clickon(getwebelement(xml.getlocator("//locators/AlertAccept")));

			// AcceptJavaScriptMethod();
			Thread.sleep(3000);
			// Pagerefresh();
			// Thread.sleep(8000);
			// WaitforElementtobeclickable(xml.getlocator("//locators/BCPReference"));
			// getwebelement(xml.getlocator("//locators/BCPReference")).clear();
			// SendKeys(getwebelement(xml.getlocator("//locators/BCPReference")),Inputdata[47].toString());
			// SendkeaboardKeys((getwebelement(xml.getlocator("//locators/BCPReference"))),
			// Keys.TAB);
			// Thread.sleep(4000);

			// WaitforElementtobeclickable(xml.getlocator("//locators/IpGurdianSave"));
			// Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
			// Pagerefresh();
			// Thread.sleep(8000);
			// Clear(getwebelement(xml.getlocator("//locators/relayfibre")));
			// SendKeys(getwebelement(xml.getlocator("//locators/relayfibre")),Inputdata[0].toString());
			WaitforElementtobeclickable(xml.getlocator("//locators/CabinetTypeDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/CabinetTypeDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/CabinetTypeSelectAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/CabinetTypeSelectAccess")));
			// Clear(getwebelement(xml.getlocator("//locators/cabinettype")));
			// SendKeys(getwebelement(xml.getlocator("//locators/cabinettype")),
			// Inputdata[48].toString());
			// SendkeaboardKeys(getwebelement(xml.getlocator("//locators/cabinettype")),
			// Keys.TAB);
			// Thread.sleep(4000);

			WaitforElementtobeclickable(xml.getlocator("//locators/CabinetID"));
			Clear(getwebelement(xml.getlocator("//locators/CabinetID")));
			SendKeys(getwebelement(xml.getlocator("//locators/CabinetID")), Inputdata[49].toString());
			SendkeaboardKeys((getwebelement(xml.getlocator("//locators/CabinetID"))), Keys.TAB);
			Thread.sleep(4000);

			WaitforElementtobeclickable(xml.getlocator("//locators/shelfid"));
			Clear(getwebelement(xml.getlocator("//locators/shelfid")));
			SendKeys(getwebelement(xml.getlocator("//locators/shelfid")), Inputdata[50].toString());
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/shelfid")), Keys.TAB);

			// waitandForElementDisplay((xml.getlocator("//locators/ClickheretoSaveAccess")),8);
			// WaitforElementtobeclickable(xml.getlocator("//locators/IpGurdianSave"));
			// Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
			// Pagerefresh();
			// Thread.sleep(8000);

			WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			// WaitforElementtobeclickable(xml.getlocator("//locators/IpGurdianSave"));
			Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));

			waitforPagetobeenable();

			WaitforElementtobeclickable(xml.getlocator("//locators/Slotid"));
			Clear(getwebelement(xml.getlocator("//locators/Slotid")));
			SendKeys(getwebelement(xml.getlocator("//locators/Slotid")), Inputdata[51].toString());
			SendkeaboardKeys((getwebelement(xml.getlocator("//locators/Slotid"))), Keys.TAB);
			// Thread.sleep(4000);

			WaitforElementtobeclickable(xml.getlocator("//locators/Physicalportid"));
			Clear(getwebelement(xml.getlocator("//locators/Physicalportid")));
			SendKeys(getwebelement(xml.getlocator("//locators/Physicalportid")), Inputdata[52].toString());
			SendkeaboardKeys((getwebelement(xml.getlocator("//locators/Physicalportid"))), Keys.TAB);
			// Thread.sleep(4000);

			WaitforElementtobeclickable(xml.getlocator("//locators/PresentationInterfaceDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/PresentationInterfaceDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/PresentationInterfaceSelectAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/PresentationInterfaceSelectAccess")));
			// Clear(getwebelement(xml.getlocator("//locators/PhysicalInterface")));
			// SendKeys(getwebelement(xml.getlocator("//locators/PhysicalInterface")),
			// Inputdata[53].toString());
			// SendkeaboardKeys((getwebelement(xml.getlocator("//locators/PhysicalInterface"))),
			// Keys.TAB);
			// Thread.sleep(4000);

			WaitforElementtobeclickable(xml.getlocator("//locators/ConnectorTypeDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/ConnectorTypeDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/ConnectorTypeSelectAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/ConnectorTypeSelectAccess")));
			// Clear(getwebelement(xml.getlocator("//locators/Connectortype")));
			// SendKeys(getwebelement(xml.getlocator("//locators/Connectortype")),
			// Inputdata[54].toString());
			// SendkeaboardKeys((getwebelement(xml.getlocator("//locators/Connectortype"))),
			// Keys.TAB);
			// Thread.sleep(4000);

			// Pagerefresh();
			// Thread.sleep(8000);
			// WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			// WaitforElementtobeclickable(xml.getlocator("//locators/IpGurdianSave"));
			// Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
			// Thread.sleep(8000);
			// Pagerefresh();
			// Thread.sleep(8000);
			WaitforElementtobeclickable(xml.getlocator("//locators/FibreTypeDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/FibreTypeDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/FibreTypeSelectAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/FibreTypeSelectAccess")));
			// Clickon(getwebelement(xml.getlocator("//locators/Fibretype")));
			// Clear(getwebelement(xml.getlocator("//locators/Fibretype")));
			// SendKeys(getwebelement(xml.getlocator("//locators/Fibretype")),
			// Inputdata[55].toString());
			/// SendkeaboardKeys((getwebelement(xml.getlocator("//locators/Fibretype"))),
			// Keys.TAB);
			// Thread.sleep(4000);
			WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			// WaitforElementtobeclickable(xml.getlocator("//locators/IpGurdianSave"));
			Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
			// Pagerefresh();
			// Thread.sleep(8000);
			waitforPagetobeenable();
			// Clear(getwebelement(xml.getlocator("//locators/Portrole")));
			// SendKeys(getwebelement(xml.getlocator("//locators/Portrole")),
			// Inputdata[0].toString());

			// Clear(getwebelement(xml.getlocator("//locators/Dualcustomerpowersource")));
			// SendKeys(getwebelement(xml.getlocator("//locators/Dualcustomerpowersource")),
			// Inputdata[0].toString());
			// Clear(getwebelement(xml.getlocator("//locators/Diversitytype")));
			// SendKeys(getwebelement(xml.getlocator("//locators/Diversitytype")),
			// Inputdata[0].toString());
			// Clear(getwebelement(xml.getlocator("//locators/Customerdedicatedaccessring")));
			// SendKeys(getwebelement(xml.getlocator("//locators/Customerdedicatedaccessring")),Inputdata[0].toString());

			WaitforElementtobeclickable(xml.getlocator("//locators/InstallTimeDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/InstallTimeDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/InstallTimeSelectAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/InstallTimeSelectAccess")));
			// Clear(getwebelement(xml.getlocator("//locators/installtime")));
			// SendKeys(getwebelement(xml.getlocator("//locators/installtime")),
			// Inputdata[56].toString());
			// SendkeaboardKeys((getwebelement(xml.getlocator("//locators/installtime"))),
			// Keys.TAB);
			// Thread.sleep(4000);

			WaitforElementtobeclickable(xml.getlocator("//locators/Accesstimewindow"));
			Clear(getwebelement(xml.getlocator("//locators/Accesstimewindow")));
			SendKeys(getwebelement(xml.getlocator("//locators/Accesstimewindow")), Inputdata[57].toString());
			SendkeaboardKeys((getwebelement(xml.getlocator("//locators/Accesstimewindow"))), Keys.TAB);
			// Thread.sleep(4000);
			WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			// WaitforElementtobeclickable(xml.getlocator("//locators/IpGurdianSave"));
			Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
			// Pagerefresh();
			// Thread.sleep(8000);
			waitforPagetobeenable();

			// Clear(getwebelement(xml.getlocator("//locators/Coltcpeid")));
			// SendKeys(getwebelement(xml.getlocator("//locators/Coltcpeid")),
			// Inputdata[0].toString());
			// Clear(getwebelement(xml.getlocator("//locators/Routerspecification")));
			// SendKeys(getwebelement(xml.getlocator("//locators/Routerspecification")),
			// Inputdata[0].toString());

			WaitforElementtobeclickable(xml.getlocator("//locators/RouterCountryAccess"));
			Clear(getwebelement(xml.getlocator("//locators/RouterCountryAccess")));
			SendKeys(getwebelement(xml.getlocator("//locators/RouterCountryAccess")), Inputdata[58].toString());
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/RouterCountryAccess")), Keys.TAB);
			Thread.sleep(10000);
			WaitforElementtobeclickable(xml.getlocator("//locators/routermodel"));
			Clear(getwebelement(xml.getlocator("//locators/routermodel")));
			SendKeys(getwebelement(xml.getlocator("//locators/routermodel")), Inputdata[59].toString());
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/routermodel")), Keys.TAB);

//					WaitforElementtobeclickable(xml.getlocator("//locators/RouterSiteNameAccess"));
//					Clear(getwebelement(xml.getlocator("//locators/RouterSiteNameAccess")));
//					SendKeys(getwebelement(xml.getlocator("//locators/RouterSiteNameAccess")), Inputdata[60].toString());
//					Thread.sleep(10000);
//					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/RouterSiteNameAccess")), Keys.TAB);
//					Thread.sleep(4000);

			WaitforElementtobeclickable(xml.getlocator("//locators/RouterSiteNameDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/RouterSiteNameDropdownAccess")));
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/RouterSiteNameSelectAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/RouterSiteNameSelectAccess")));
			Thread.sleep(5000);

			WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			// WaitforElementtobeclickable(xml.getlocator("//locators/IpGurdianSave"));
			Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
			// Pagerefresh();
			// Thread.sleep(8000);
			waitforPagetobeenable();

			Clickon(getwebelement(xml.getlocator("//locators/ClickShowFullInfoAccess")));
			Thread.sleep(5000);
			WaitforElementtobeclickable((xml.getlocator("//locators/IPAdressingFormatDropdownAccess")));
			Clickon(getwebelement(xml.getlocator("//locators/IPAdressingFormatDropdownAccess")));
			WaitforElementtobeclickable((xml.getlocator("//locators/IPAdressingFormatSelectAccess")));
			Clickon(getwebelement(xml.getlocator("//locators/IPAdressingFormatSelectAccess")));
			Thread.sleep(5000);
			// Clear(getwebelement(xml.getlocator("//locators/IPAdressingFormatAccess")));
			// SendKeys(getwebelement(xml.getlocator("//locators/IPAdressingFormatAccess")),
			// Inputdata[66].toString());
			// Thread.sleep(8000);

			// Clear(getwebelement(xml.getlocator("//locators/IPV4AdressingTypeAccess")));
			// SendKeys(getwebelement(xml.getlocator("//locators/IPV4AdressingTypeAccess")),
			// Inputdata[67].toString());
			// Thread.sleep(8000);
			WaitforElementtobeclickable((xml.getlocator("//locators/IPV4AdressingTypeDropdownAccess")));
			Clickon(getwebelement(xml.getlocator("//locators/IPV4AdressingTypeDropdownAccess")));
			WaitforElementtobeclickable((xml.getlocator("//locators/IPV4AdressingTypeSelectAccess")));
			Clickon(getwebelement(xml.getlocator("//locators/IPV4AdressingTypeSelectAccess")));
			Thread.sleep(5000);
			// Clear(getwebelement(xml.getlocator("//locators/NumberIPV4AdressAccess")));
			// SendKeys(getwebelement(xml.getlocator("//locators/NumberIPV4AdressAccess")),
			// Inputdata[68].toString());
			// Thread.sleep(8000);
			// getwebelement(xml.getlocator("//locators/IPaddressingtype")).clear();
			// SendKeys(getwebelement(xml.getlocator("//locators/IPaddressingtype")),
			// Inputdata[0].toString());
			Clickon(getwebelement(xml.getlocator("//locators/Crossbuttonforipaccess")));
			Thread.sleep(6000);
			// Clickon(getwebelement(xml.getlocator("//locators/SaveButtonClick")));
			// Thread.sleep(8000);

			WaitforElementtobeclickable(xml.getlocator("//locators/IpGurdianSave"));
			Clickon(getwebelement(xml.getlocator("//locators/IpGurdianSave")));
			// Thread.sleep(8000);

			waitforPagetobeenable();

			// accepTaLLERT(GetText(getwebelement(xml.getlocator("Locator of the message
			// area"))),getwebelement(xml.getlocator("locator of button")));

			// Clickon(getwebelement(xml.getlocator("//locators/SearchAddressSiteB")));

			WaitforElementtobeclickable(xml.getlocator("//locators/RouterTechnologyDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/RouterTechnologyDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/SelectRouterTechnologyDropDownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/SelectRouterTechnologyDropDownAccess")));

			WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			// WaitforElementtobeclickable(xml.getlocator("//locators/IpGurdianSave"));
			Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));

			waitforPagetobeenable();

			WaitforElementtobeclickable((xml.getlocator("//locators/CircuitReferenceAccess")));
			Clickon(getwebelement(xml.getlocator("//locators/CircuitReferenceAccess")));
			Thread.sleep(25000);

			savePage();
			waitforPagetobeenable();
			Thread.sleep(8000);

//					Circuitreferencenumber.set(Gettext(getwebelement(xml.getlocator("//locators/CircuitReferenceAccess']"))));
//							ExtentTestManager.getTest().log(LogStatus.PASS,
//									" Step: Generated Service Order Reference No: " + Circuitreferencenumber.get());

			break;
		}
		case "IP Domain": {

			System.out.println("Enter Middle Applet");
			Thread.sleep(2000);
			// Moveon(getwebelement("//a[text()='Click to Show Full info']"));
			// Moveon(getwebelement(xml.getlocator("//locators/Clicktoshowfullinfomiddle")));
			System.out.println("Move Performed");

			Clickon(getwebelement(xml.getlocator("//locators/Clicktoshowfullinfomiddle")));
			Thread.sleep(3000);

			SendKeys(getwebelement(xml.getlocator("//locators/Domainname")), Inputdata[16].toString());
			Clickon(getwebelement(xml.getlocator("//locators/Domainordertype")));
			Thread.sleep(4000);
			Clickon(getwebelement(xml.getlocator("//locators/DomainordertypeData")));
			// WaitforElementtobeclickable(xml.getlocator("//locators/DNStype"));
			Clickon(getwebelement(xml.getlocator("//locators/DNStype")));
			Thread.sleep(2000);
			Clickon(getwebelement(xml.getlocator("//locators/DNSTypeInput")));
			// getwebelement(xml.getlocator("//locators/DNStypeinput")).clear();
			// Thread.sleep(3000);
			// SendKeys(getwebelement(xml.getlocator("//locators/DNStypeinput")),
			// Inputdata[17].toString());
			// Clickon(getwebelement(xml.getlocator("//locators/DNStypeinput")));
			Thread.sleep(6000);
			// savePage();

			Clickon(getwebelement(xml.getlocator("//locators/Crossbutton")));
			Thread.sleep(6000);
			Clickon(getwebelement(xml.getlocator("//locators/SaveButtonClick")));
			Thread.sleep(10000);

			System.out.println("Middle Complete");
			break;
		}

		case "IP Guardian": {

			System.out.println("Enter Gurdian Middle Applet");

			getwebelement(xml.getlocator("//locators/AlertingNotification")).clear();
			SendKeys(getwebelement(xml.getlocator("//locators/AlertingNotification")), Inputdata[27].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter AlertingNotification");

			getwebelement(xml.getlocator("//locators/Automigration")).clear();
			SendKeys(getwebelement(xml.getlocator("//locators/Automigration")), Inputdata[28].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter Automigration");
			Thread.sleep(2000);
			// SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Automigration")),
			// Keys.TAB);

			getwebelement(xml.getlocator("//locators/Customerdnsresolve")).clear();
			SendKeys(getwebelement(xml.getlocator("//locators/Customerdnsresolve")), Inputdata[29].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter Customer dns resolve");

			getwebelement(xml.getlocator("//locators/IpguardianVariant")).clear();
			SendKeys(getwebelement(xml.getlocator("//locators/IpguardianVariant")), Inputdata[30].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter IP guardiant variant");

			getwebelement(xml.getlocator("//locators/Colttechnicaltestcalls")).clear();
			SendKeys(getwebelement(xml.getlocator("//locators/Colttechnicaltestcalls")), Inputdata[31].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter Enter Colt technical cells");
			Thread.sleep(2000);

			getwebelement(xml.getlocator("//locators/servicebandwidth")).clear();
			SendKeys(getwebelement(xml.getlocator("//locators/servicebandwidth")), Inputdata[32].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter service bandwidth");

			SendKeys(getwebelement(xml.getlocator("//locators/Testwindowipaccess")), Inputdata[33].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter Test Window");

			Clickon(getwebelement(xml.getlocator("//locators/IpGurdianSave")));
			Thread.sleep(8000);

			Moveon(getwebelement(xml.getlocator("//locators/CircuitipaddressClick")));
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/CircuitipaddressClick")));
			// System.out.println("Click Full");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:click on circuit ip address");
			Thread.sleep(3000);

			Clickon(getwebelement(xml.getlocator("//locators/CircuitIPAddressInput")));
			getwebelement(xml.getlocator("//locators/CircuitIPAddressInput")).clear();
			SendKeys(getwebelement(xml.getlocator("//locators/CircuitIPAddressInput")), Inputdata[34].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:click on circuit ip address");

			SendKeys(getwebelement(xml.getlocator("//locators/IpRange")), Inputdata[35].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Input IP Range");

			Clickon(getwebelement(xml.getlocator("//locators/CrossButtonGurdian")));
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/IpGurdianSave")));
			Thread.sleep(10000);

			break;
		}

		case "Number Hosting": {

			Clickon(getwebelement(
					xml.getlocator("//locators/ClickDropdown").replace("Value", "Voice Service Country")));
			Clickon(getwebelement(xml.getlocator("//locators/SelectValueDropdown").replace("Value", "France")));
			Clear(getwebelement(xml.getlocator("//locators/TextInput").replace("Value",
					"Call Admission Control (Number of Channels)")));
			SendKeys(getwebelement(xml.getlocator("//locators/TextInput").replace("Value",
					"Call Admission Control (Number of Channels)")), "2");
			Thread.sleep(2000);
			Clear(getwebelement(
					xml.getlocator("//locators/TextInput").replace("Value", "Number of Signalling Trunks")));
			SendKeys(
					getwebelement(
							xml.getlocator("//locators/TextInput").replace("Value", "Number of Signalling Trunks")),
					"1");
			Thread.sleep(2000);
			Clear(getwebelement(
					xml.getlocator("//locators/TextInput").replace("Value", "Voice Configuration Reference")));
			Thread.sleep(2000);
			SendKeys(
					getwebelement(
							xml.getlocator("//locators/TextInput").replace("Value", "Voice Configuration Reference")),
					"12");
			Thread.sleep(2000);
			Clickon(getwebelement(xml.getlocator("//locators/ClickDropdown").replace("Value", "Traffic Direction")));
			Clickon(getwebelement(xml.getlocator("//locators/SelectValueDropdown").replace("Value", "Incoming")));
			Thread.sleep(2000);

			Clickon(getwebelement(xml.getlocator("//locators/ClickDropdown").replace("Value", "First Codec")));
			Clickon(getwebelement(xml.getlocator("//locators/SelectValueDropdown").replace("Value", "G.722.1")));

			Clickon(getwebelement(xml.getlocator("//locators/ClickLink").replace("Value", "Show More")));
			Thread.sleep(3000);

			Clickon(getwebelement(xml.getlocator("//locators/ClickDropdown").replace("Value", "Second Codec")));

			// System.out.println(xml.getlocator("//locators/SelectValueDropdown").replace("Value",
			// "G.722.1")+"[2]");
			Clickon(getwebelement(
					xml.getlocator("//locators/SelectValueDropdown").replace("Value", "G.722.1") + "[2]"));

			Clickon(getwebelement(xml.getlocator("//locators/ClickDropdown").replace("Value", "Third Codec")));
			Thread.sleep(2000);
			Clickon(getwebelement(
					xml.getlocator("//locators/SelectValueDropdown").replace("Value", "G.722.1") + "[3]"));

			Clear(getwebelement(xml.getlocator("//locators/TextInput").replace("Value", "Fourth Codec")));
			SendKeys(getwebelement(xml.getlocator("//locators/TextInput").replace("Value", "Fourth Codec")), "G.729");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/TextInput").replace("Value", "Fourth Codec")),
					Keys.ENTER);

			Clear(getwebelement(xml.getlocator("//locators/TextInput").replace("Value", "Fifth Codec")));
			SendKeys(getwebelement(xml.getlocator("//locators/TextInput").replace("Value", "Fifth Codec")), "G.729");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/TextInput").replace("Value", "Fifth Codec")),
					Keys.ENTER);

			Clear(getwebelement(xml.getlocator("//locators/TextInput").replace("Value", "Sixth Codec")));
			SendKeys(getwebelement(xml.getlocator("//locators/TextInput").replace("Value", "Sixth Codec")), "G.729");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/TextInput").replace("Value", "Sixth Codec")),
					Keys.ENTER);
			Thread.sleep(2000);

//			Clickon(getwebelement(xml.getlocator("//locators/ClickDropdown").replace("Value", "Fourth Codec")));
//			Thread.sleep(2000);
//			
//			System.out.println(xml.getlocator("//locators/SelectValueDropdown").replace("Value", "G.722.1")+"[4]");
//			Clickon(getwebelement(xml.getlocator("//locators/SelectValueDropdown").replace("Value", "G.722.1")+"[3]"));
//			
//			Clickon(getwebelement(xml.getlocator("//locators/ClickDropdown").replace("Value", "Fifth Codec")));
//			Thread.sleep(2000);
//			System.out.println(xml.getlocator("//locators/SelectValueDropdown").replace("Value", "G.722.1")+"[5]");
//			Clickon(getwebelement(xml.getlocator("//locators/SelectValueDropdown").replace("Value", "G.722.1")+"[3]"));
//			
//			Clickon(getwebelement(xml.getlocator("//locators/ClickDropdown").replace("Value", "Sixth Codec")));
//			Thread.sleep(2000);
//			System.out.println(xml.getlocator("//locators/SelectValueDropdown").replace("Value", "G.722.1")+"[6]");
//			Clickon(getwebelement(xml.getlocator("//locators/SelectValueDropdown").replace("Value", "G.722.1")+"[3]"));
//			
			WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
			waitforPagetobeenable();

			Clickon(getwebelement(xml.getlocator("//locators/ClickShowFullInfoAccess")));
			Thread.sleep(3000);

			Clickon(getwebelement(xml.getlocator("//locators/SearchInput").replace("Value", "Service Party")));
			waitforPagetobeenable();

			Clickon(getwebelement(xml.getlocator("//locators/PopUpDropdown")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Service Party Dropdown");

			Clickon(getwebelement(xml.getlocator("//locators/SelectValueDropdown").replace("Value", "Party Name")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Party Name");

			SendKeys(getwebelement(xml.getlocator("//locators/PopUpInput")), "Colt");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Party Name");

			Clickon(getwebelement(xml.getlocator("//locators/PopUpSearch")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click On Search");
			waitforPagetobeenable();
			Thread.sleep(2000);
			Clickon(getwebelement(xml.getlocator("//locators/PopUpSubmit")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click On Submit");
			waitforPagetobeenable();

			Clickon(getwebelement(xml.getlocator("//locators/SearchInput").replace("Value", "Site Contact")));
			waitforPagetobeenable();

			Clickon(getwebelement(xml.getlocator("//locators/PopUpDropdown")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Site Contact Dropdown");

			safeJavaScriptClick(
					getwebelement(xml.getlocator("//locators/SelectValueDropdown").replace("Value", "Last Name")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select First  Name");

			SendKeys(getwebelement(xml.getlocator("//locators/PopUpInput")), "Chambial");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Last Name");

//		Clickon(getwebelement(xml.getlocator("//locators/PopUpSearch")));			
//		ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click On Search");
//		waitforPagetobeenable();

			Clickon(getwebelement(xml.getlocator("//locators/PopUpSubmit")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click On Submit");
			waitforPagetobeenable();

			// System.out.println(xml.getlocator("//locators/ClickDropdown").replace("Value","Delivery
			// Team Country"));

			Clickon(getwebelement(
					xml.getlocator("//locators/ClickDropdown").replace("Value", "Delivery Team Country")));
			Clickon(getwebelement(xml.getlocator("//locators/SelectValueDropdown").replace("Value", "France")));
			waitforPagetobeenable();

			Clickon(getwebelement(xml.getlocator("//locators/ClickDropdown").replace("Value", "Delivery Team City")));
			Clickon(getwebelement(xml.getlocator("//locators/SelectValueDropdown").replace("Value", "Paris")));

			Clickon(getwebelement(xml.getlocator("//locators/CrossforHosting")));
			waitforPagetobeenable();

			WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
			waitforPagetobeenable();

			SendKeys(getwebelement(xml.getlocator("//locators/TextInput").replace("Value", "Trunk Sequence")), "1");

			SendKeys(getwebelement(xml.getlocator("//locators/TextInput").replace("Value", "Trunk Name")), "ABC");

			SendKeys(getwebelement(
					xml.getlocator("//locators/TextInput").replace("Value", "External Access Service Reference")),
					"12");

			SendKeys(getwebelement(
					xml.getlocator("//locators/TextInput").replace("Value", "Customer Originating IPv4 Address Range")),
					"24.12.5");

			SendKeys(getwebelement(
					xml.getlocator("//locators/TextInput").replace("Value", "Customer Originating IPv6 Address Range")),
					"21.25.69");

			Clickon(getwebelement(xml.getlocator("//locators/ClickDropdown").replace("Value", "Access Line Type")));
			Thread.sleep(2000);
			Clickon(getwebelement(xml.getlocator("//locators/SelectValueDropdown").replace("Value", "Colt Access")));
			waitforPagetobeenable();

			Clickon(getwebelement(xml.getlocator("//locators/SearchInput").replace("Value", "Access Service ID")));
			waitforPagetobeenable();

			Clickon(getwebelement(xml.getlocator("//locators/PopUpDropdown")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Service Dropdown");

			Clickon(getwebelement(xml.getlocator("//locators/SelectValueDropdown").replace("Value", "Status")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Status");

			SendKeys(getwebelement(xml.getlocator("//locators/PopUpInput")), "Completed");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Status");

			Clickon(getwebelement(xml.getlocator("//locators/PopUpSearch")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click On Search");
			waitforPagetobeenable();

			Clickon(getwebelement(xml.getlocator("//locators/PopUpSubmit")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click On Submit");
			waitforPagetobeenable();

			Clickon(getwebelement(xml.getlocator("//locators/ClickLink").replace("Value", "Show full info")));
			Thread.sleep(3000);

//		WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
//		Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
			waitforPagetobeenable();

			Clickon(getwebelement(xml.getlocator("//locators/ClickPlus")));
			Thread.sleep(3000);
			SendKeys(getwebelement(
					xml.getlocator("//locators/TextInput").replace("Value", "Customer Terminating IPv4 Address")),
					"22.65");
			SendKeys(getwebelement(
					xml.getlocator("//locators/TextInput").replace("Value", "Customer Terminating IPv6 Address")),
					"29.62");

			Clickon(getwebelement(
					xml.getlocator("//locators/NewPageDropdown").replace("Value", "Signalling Transport Protocol")));
			Clickon(getwebelement(xml.getlocator("//locators/SelectValueDropdown").replace("Value", "TCP")));

			Clickon(getwebelement(xml.getlocator("//locators/NewPageDropdown").replace("Value", "VoIP Protocol")));
			Clickon(getwebelement(xml.getlocator("//locators/SelectValueDropdown").replace("Value", "SIP")));

			Clickon(getwebelement(
					xml.getlocator("//locators/NewPageDropdown").replace("Value", "TLS Certificate Supplier")));
			Clickon(getwebelement(xml.getlocator("//locators/SelectValueDropdown").replace("Value", " Colt")));

			Clickon(getwebelement(xml.getlocator("//locators/NewPageDropdown").replace("Value", "TLS Cipher Suite")));
			Clickon(getwebelement(xml.getlocator("//locators/SelectValueDropdown").replace("Value",
					"TLS_RSA_WITH_AES_128_CBC_SHA (Priority 1)")));

			Clickon(getwebelement(xml.getlocator("//locators/NewPageDropdown").replace("Value", "Encryption Type")));
			Clickon(getwebelement(
					xml.getlocator("//locators/SelectValueDropdown").replace("Value", "TLS on, SRTP off")));

			Clickon(getwebelement(xml.getlocator("//locators/NewPageDropdown").replace("Value", "NAT Required?")));
			Clickon(getwebelement(xml.getlocator("//locators/SelectValueDropdown").replace("Value", "Y")));

			Clickon(getwebelement(
					xml.getlocator("//locators/NewPageDropdown").replace("Value", "Inbound Outbound Split")));
			Clickon(getwebelement(xml.getlocator("//locators/SelectValueDropdown").replace("Value", "Yes")));

			Clickon(getwebelement(xml.getlocator("//locators/NewPageDropdown").replace("Value", "Type of CAC")));
			Clickon(getwebelement(xml.getlocator("//locators/SelectValueDropdown").replace("Value",
					"Both ways CAC with individual Trunk CAC")));
			Thread.sleep(2000);

			Clickon(getwebelement(xml.getlocator("//locators/CrossButtonTrunk")));

			WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
			waitforPagetobeenable();

			Clickon(getwebelement(xml.getlocator("//locators/OtherTabClick")));
			waitforPagetobeenable();

			SendKeys(getwebelement(xml.getlocator("//locators/TextInput").replace("Value", "Internal Routing Prefix")),
					"45");

			SendKeys(getwebelement(xml.getlocator("//locators/TextInput").replace("Value", "Reseller Profile")), "Ab");

			Clickon(getwebelement(xml.getlocator("//locators/ClickLink").replace("Value", "Service Group")));
			waitforPagetobeenable();
			Clickon(getwebelement(xml.getlocator("//locators/ServiceGroupPlus")));
			waitforPagetobeenable();
			Clickon(getwebelement(xml.getlocator("//locators/ServiceGroupSearch")));
			waitforPagetobeenable();
			Clickon(getwebelement(xml.getlocator("//locators/PopUpSubmit")));
			waitforPagetobeenable();

			Clickon(getwebelement(xml.getlocator("//locators/ClickLink").replace("Value", "Voice Features")));
			waitforPagetobeenable();

//			for(int i=0; i<2;i++) {
//				Clickon(getwebelement(xml.getlocator("//locators/BCNFilling").replace("value","'+i+'" )));
//			}

			break;
		}
		/* Managed Virtual Firewall Start */
		case "Managed Virtual Firewall":
		{
			
			
			    WaitforElementtobeclickable(xml.getlocator("//locators/MVFBillingTab"));		
			    Clickon(getwebelement(xml.getlocator("//locators/MVFBillingTab")));
			    Thread.sleep(5000);		
				
				WaitforElementtobeclickable(xml.getlocator("//locators/MVFShowfullInfo"));		
				Clickon(getwebelement(xml.getlocator("//locators/MVFShowfullInfo")));
				Thread.sleep(5000);
				
				WaitforElementtobeclickable(xml.getlocator("//locators/MVFSecurityPolicyAttachmentlink"));
				Clickon(getwebelement(xml.getlocator("//locators/MVFSecurityPolicyAttachmentlink")));
		//		Clear(getwebelement(xml.getlocator("//locators/MVFSecurityPolicyAttachmentlink")));
				SendKeys(getwebelement(xml.getlocator("//locators/MVFSecurityPolicyAttachmentlink")),"1234");
				ExtentTestManager.getTest().log(LogStatus.PASS, "Click  ManagedVirtualFirewall ShowfullInfo link ");
			    Thread.sleep(3000);
			    WaitforElementtobeclickable(xml.getlocator("//locators/MVFAddbutton"));
				Clickon(getwebelement(xml.getlocator("//locators/MVFAddbutton")));
			    Thread.sleep(3000);
			    
			    WaitforElementtobeclickable(xml.getlocator("//locators/MVFClosebutton"));
				Clickon(getwebelement(xml.getlocator("//locators/MVFClosebutton")));
			    Thread.sleep(3000);
			    
			    WaitforElementtobeclickable(xml.getlocator("//locators/MVFSavebutton"));
				Clickon(getwebelement(xml.getlocator("//locators/MVFSavebutton")));
			    Thread.sleep(10000);
			    
			    break;
			}	
		/* Managed Virtual Firewall End   */
		/* below case added as per Rekha */
		case "Ethernet VPN Access": {
			Thread.sleep(10000);

			WaitforElementtobeclickable(xml.getlocator("//locators/LinkTypeDropDown"));
			Clickon(getwebelement(xml.getlocator("//locators/LinkTypeDropDown")));
			WaitforElementtobeclickable(xml.getlocator("//locators/LinkTYpeValue"));
			Clickon(getwebelement(xml.getlocator("//locators/LinkTYpeValue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on LinkTYpeValue");
			Thread.sleep(5000);

			WaitforElementtobeclickable(xml.getlocator("//locators/ServiceBandwidthDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/ServiceBandwidthDropdownAccess")));

			WaitforElementtobeclickable(xml.getlocator("//locators/ServiceBandwidthSelect"));
			Clickon(getwebelement(xml.getlocator("//locators/ServiceBandwidthSelect")));

			WaitforElementtobeclickable(xml.getlocator("//locators/ResilenceOptionDropDown"));
			Clickon(getwebelement(xml.getlocator("//locators/ResilenceOptionDropDown")));
			WaitforElementtobeclickable(xml.getlocator("//locators/ResilienceValue"));
			Clickon(getwebelement(xml.getlocator("//locators/ResilienceValue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Resilience Value");
			Thread.sleep(5000);

			WaitforElementtobeclickable(xml.getlocator("//locators/OSSPlatformDropDown"));
			Clickon(getwebelement(xml.getlocator("//locators/OSSPlatformDropDown")));
			WaitforElementtobeclickable(xml.getlocator("//locators/OSSplatformValue"));
			Clickon(getwebelement(xml.getlocator("//locators/OSSplatformValue")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on OSSplatformValue");
			Thread.sleep(5000);

			WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
			waitforPagetobeenable();
			Thread.sleep(10000);

			WaitforElementtobeclickable(xml.getlocator("//locators/SelectSiteSearchAccess"));
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/SelectSiteSearchAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search Site");
			WaitforElementtobeclickable(xml.getlocator("//locators/StreetNameAccess"));
			SendKeys(getwebelement(xml.getlocator("//locators/StreetNameAccess")), Inputdata[61].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Street Name");
			WaitforElementtobeclickable(xml.getlocator("//locators/CountryAccess"));
			SendKeys(getwebelement(xml.getlocator("//locators/CountryAccess")), Inputdata[62].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Country");
			SendKeys(getwebelement(xml.getlocator("//locators/CityTownAccess")), Inputdata[63].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter City");
			SendKeys(getwebelement(xml.getlocator("//locators/PostalCodeAccess")), Inputdata[64].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Postal Code");
			SendKeys(getwebelement(xml.getlocator("//locators/PremisesAccess")), Inputdata[65].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Premises");
			Clickon(getwebelement(xml.getlocator("//locators/SearchButtonAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search");
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/SelectPickAddressAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Address for Site");
			Clickon(getwebelement(xml.getlocator("//locators/PickAddressButtonAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Submit Address for Site");
			Clickon(getwebelement(xml.getlocator("//locators/SelectPickBuildingAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Buiding for Site");
			Clickon(getwebelement(xml.getlocator("//locators/PickBuildingButtonAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Submit Buiding for Site");
			Clickon(getwebelement(xml.getlocator("//locators/SelectPickSiteAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Site");
			Clickon(getwebelement(xml.getlocator("//locators/PickSiteButtonAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Submit Site");
			Thread.sleep(10000);
			WaitforElementtobeclickable(xml.getlocator("//locators/ServicePartySearchAccess"));
			Moveon(getwebelement(xml.getlocator("//locators/ServicePartySearchAccess")));
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/ServicePartySearchAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Search Service Party");

			waitandForElementDisplay((xml.getlocator("//locators/ServicePartyDropdownAccess")), 8);

			WaitforElementtobeclickable(xml.getlocator("//locators/ServicePartyDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/ServicePartyDropdownAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Service Party Dropdown");

			Clickon(getwebelement(xml.getlocator("//locators/PartyNameAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Party Name");

			SendKeys(getwebelement(xml.getlocator("//locators/InputPartyNameAccess")), Inputdata[69].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Party Name");

			Clickon(getwebelement(xml.getlocator("//locators/PartyNameSearchAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click On Search");

			Thread.sleep(2000);
			Clickon(getwebelement(xml.getlocator("//locators/PartyNameSubmitAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click On Submit");

			WaitforElementtobeclickable(xml.getlocator("//locators/SiteContactSearchAccess"));
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/SiteContactSearchAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Search Site Contact");

			waitandForElementDisplay((xml.getlocator("//locators/SiteContactDropdownAccess")), 8);
			WaitforElementtobeclickable(xml.getlocator("//locators/SiteContactDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/SiteContactDropdownAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Site Name Dropdown");

			WaitforElementtobeclickable(xml.getlocator("//locators/InputSiteNameAccess"));
			SendKeys(getwebelement(xml.getlocator("//locators/InputSiteNameAccess")), Inputdata[70].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Site Name");

			WaitforElementtobeclickable(xml.getlocator("//locators/LastNameSiteSearchAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/LastNameSiteSearchAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click On Search");

			WaitforElementtobeclickable(xml.getlocator("//locators/LastNameSiteSubmitAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/LastNameSiteSubmitAccess")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click On Submit");

			WaitforElementtobeclickable(xml.getlocator("//locators/IpGurdianSave"));
			Clickon(getwebelement(xml.getlocator("//locators/IpGurdianSave")));
			waitforPagetobeenable();

			WaitforElementtobeclickable(xml.getlocator("//locators/AccessTypeDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/AccessTypeDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/AccessTypeSelectAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/AccessTypeSelectAccess")));

			WaitforElementtobeclickable(xml.getlocator("//locators/AccesstechnologyDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/AccesstechnologyDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/AccesstechnologySelectAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/AccesstechnologySelectAccess")));

			WaitforElementtobeclickable(xml.getlocator("//locators/BuildingTypeDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/BuildingTypeDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/BuildingTypeSelectAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/BuildingTypeSelectAccess")));

			WaitforElementtobeclickable(xml.getlocator("//locators/CustomerSitePopStatusDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/CustomerSitePopStatusDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/CustomerSitePopStatusSelectAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/CustomerSitePopStatusSelectAccess")));

			WaitforElementtobeclickable(xml.getlocator("//locators/BCPReference"));
			Clickon(getwebelement(xml.getlocator("//locators/BCPReference")));
			Clear(getwebelement(xml.getlocator("//locators/BCPReference")));
			SendKeys(getwebelement(xml.getlocator("//locators/BCPReference")), Inputdata[47].toString());
			Thread.sleep(5000);

			WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/IpGurdianSave"));
			Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));

			waitforPagetobeenable();

			WaitforElementtobeclickable(xml.getlocator("//locators/CabinetTypeDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/CabinetTypeDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/CabinetTypeSelectAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/CabinetTypeSelectAccess")));

			WaitforElementtobeclickable(xml.getlocator("//locators/CabinetID"));
			Clear(getwebelement(xml.getlocator("//locators/CabinetID")));
			SendKeys(getwebelement(xml.getlocator("//locators/CabinetID")), Inputdata[49].toString());
			SendkeaboardKeys((getwebelement(xml.getlocator("//locators/CabinetID"))), Keys.TAB);

			WaitforElementtobeclickable(xml.getlocator("//locators/shelfid"));
			Clear(getwebelement(xml.getlocator("//locators/shelfid")));
			SendKeys(getwebelement(xml.getlocator("//locators/shelfid")), Inputdata[50].toString());
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/shelfid")), Keys.TAB);

			WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/IpGurdianSave"));
			Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));

			waitforPagetobeenable();

			WaitforElementtobeclickable(xml.getlocator("//locators/Slotid"));
			Clear(getwebelement(xml.getlocator("//locators/Slotid")));
			SendKeys(getwebelement(xml.getlocator("//locators/Slotid")), Inputdata[51].toString());
			SendkeaboardKeys((getwebelement(xml.getlocator("//locators/Slotid"))), Keys.TAB);

			WaitforElementtobeclickable(xml.getlocator("//locators/Physicalportid"));
			Clear(getwebelement(xml.getlocator("//locators/Physicalportid")));
			SendKeys(getwebelement(xml.getlocator("//locators/Physicalportid")), Inputdata[52].toString());
			SendkeaboardKeys((getwebelement(xml.getlocator("//locators/Physicalportid"))), Keys.TAB);

			WaitforElementtobeclickable(xml.getlocator("//locators/PresentationInterfaceDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/PresentationInterfaceDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/PresentationInterfaceSelect"));
			Clickon(getwebelement(xml.getlocator("//locators/PresentationInterfaceSelect")));

			WaitforElementtobeclickable(xml.getlocator("//locators/ConnectorTypeDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/ConnectorTypeDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/ConnectorTypeSelect"));
			Clickon(getwebelement(xml.getlocator("//locators/ConnectorTypeSelect")));

			WaitforElementtobeclickable(xml.getlocator("//locators/FibreTypeDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/FibreTypeDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/FibreTypeSelect"));
			Clickon(getwebelement(xml.getlocator("//locators/FibreTypeSelect")));

			WaitforElementtobeclickable(xml.getlocator("//locators/PortRoleDropDown"));
			Clickon(getwebelement(xml.getlocator("//locators/PortRoleDropDown")));
			WaitforElementtobeclickable(xml.getlocator("//locators/PortValue"));
			Clickon(getwebelement(xml.getlocator("//locators/PortValue")));

			WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/IpGurdianSave"));
			Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
			waitforPagetobeenable();

			WaitforElementtobeclickable(xml.getlocator("//locators/InstallTimeDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/InstallTimeDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/InstallTimeSelectAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/InstallTimeSelectAccess")));

			WaitforElementtobeclickable(xml.getlocator("//locators/Diversitytype"));
			Clickon(getwebelement(xml.getlocator("//locators/Diversitytype")));
			Clear(getwebelement(xml.getlocator("//locators/Diversitytype")));
			SendKeys(getwebelement(xml.getlocator("//locators/Diversitytype")), Inputdata[57].toString());
			SendkeaboardKeys((getwebelement(xml.getlocator("//locators/Diversitytype"))), Keys.ENTER);
			Thread.sleep(5000);

			WaitforElementtobeclickable(xml.getlocator("//locators/RouterSiteNameDropdownAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/RouterSiteNameDropdownAccess")));
			WaitforElementtobeclickable(xml.getlocator("//locators/sitenamevalue"));
			Clickon(getwebelement(xml.getlocator("//locators/sitenamevalue")));

			WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
			waitforPagetobeenable();

			WaitforElementtobeclickable((xml.getlocator("//locators/CircuitReferenceAccess")));
			Clickon(getwebelement(xml.getlocator("//locators/CircuitReferenceAccess")));
			Thread.sleep(25000);

			savePage();
			waitforPagetobeenable();
			Thread.sleep(8000);

			Circuitreferencenumber.set(Gettext(getwebelement(xml.getlocator("//locators/CircuitReferenceValue']"))));
			ExtentTestManager.getTest().log(LogStatus.PASS,
					" Step: Generated Service Order Reference No: " + Circuitreferencenumber.get());

			break;
		}
		case "IP VPN Service": {
			if(Inputdata[11].toString().equalsIgnoreCase("IP VPN Plus")||Inputdata[11].toString().equalsIgnoreCase("IP VPN Access"))
			{
			IPVPNServicePlusAccess(Inputdata);
			IPVPNServicePlusAccess1(Inputdata);
			IPVPNServiceNetworkReference(Inputdata);
			}
			else if(Inputdata[11].toString().equalsIgnoreCase("IP VPN Wholesale"))
			{
			IPVPNServicePlusAccess(Inputdata);
			IPVPNServiceNetworkReference(Inputdata);
			}

			break;
			}



		default:
			System.out.println("Above product is not exist in current list");
			break;
		}
	}

	public void EnterDateInFooter(Object Inputdata[]) throws Exception {

		//////// ORDER DATE
		// System.out.println("Enter Domain Footer");
		Moveon(getwebelement(xml.getlocator("//locators/OrderDates")));
		// System.out.println("Moved Mouse");
		Clickon(getwebelement(xml.getlocator("//locators/OrderDates")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order Dates");
		Thread.sleep(3000);
		waitForpageload();
		waitforPagetobeenable();
		WaitforElementtobeclickable((xml.getlocator("//locators/CustomerRequestedDate")));
		Clear(getwebelement(xml.getlocator("//locators/CustomerRequestedDate")));
		SendKeys(getwebelement(xml.getlocator("//locators/CustomerRequestedDate")), CurrentDate());
		WaitforElementtobeclickable(xml.getlocator("//locators/OrderSignedDate"));
		SendKeys(getwebelement(xml.getlocator("//locators/OrderSignedDate")), Inputdata[18].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Order Signed Date");
		WaitforElementtobeclickable(xml.getlocator("//locators/ColtActualDate"));
		SendKeys(getwebelement(xml.getlocator("//locators/ColtActualDate")), Inputdata[19].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Colt Actual Date");
		WaitforElementtobeclickable(xml.getlocator("//locators/OrderReceivedDate"));
		SendKeys(getwebelement(xml.getlocator("//locators/OrderReceivedDate")), Inputdata[20].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Order Received Date");// savePage();

//
//		System.out.println("Order Date Complete");
//		Thread.sleep(3000);
	}
	/////////// BILLING DATE

	public void EnterBillingDateInFooter(Object Inputdata[]) throws Exception {

		Clickon(getwebelement(xml.getlocator("//locators/Billing")));
		waitforPagetobeenable();
		// System.out.println("BILLING TAB");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Billing");

		Thread.sleep(3000);
		if (isElementPresent(xml.getlocator("//locators/ClickheretoSaveAccess"))) {
			WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
			waitforPagetobeenable();
		}

		Clear(getwebelement(xml.getlocator("//locators/ContractRenewalFlag")));
		SendKeys(getwebelement(xml.getlocator("//locators/ContractRenewalFlag")), Inputdata[22].toString());
		// System.out.println("contract renewal flag");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Contract Renewal Flag");
		// SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ContractRenewalFlag")),
		// Keys.TAB);
		Thread.sleep(4000);

		Clear(getwebelement(xml.getlocator("//locators/ContractTerm")));
		SendKeys(getwebelement(xml.getlocator("//locators/ContractTerm")), Inputdata[21].toString());
		Clickon(getwebelement(xml.getlocator("//locators/SelectContractTerm")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Contract Term");
		Thread.sleep(8000);

		WaitforElementtobeclickable((xml.getlocator("//locators/BillingStartDateAccess")));
		Clear(getwebelement(xml.getlocator("//locators/BillingStartDateAccess")));
		SendKeys(getwebelement(xml.getlocator("//locators/BillingStartDateAccess")), CurrentDate());

		WaitforElementtobeclickable((xml.getlocator("//locators/POStartDateAccess")));
		Clear(getwebelement(xml.getlocator("//locators/POStartDateAccess")));
		SendKeys(getwebelement(xml.getlocator("//locators/POStartDateAccess")), CurrentDate());

		WaitforElementtobeclickable((xml.getlocator("//locators/POEndDateAccess")));
		Clear(getwebelement(xml.getlocator("//locators/POEndDateAccess")));
		SendKeys(getwebelement(xml.getlocator("//locators/POEndDateAccess")), CurrentDate());

		Thread.sleep(5000);

		// System.out.println("Billing Date Done!");
	}

	///////////// SERVICE CHARGE
	public void EnterServiceChargeInFooter(Object[] Inputdata, String Amount) throws Exception {
		if (!Inputdata[8].toString().equalsIgnoreCase("IP VPN Service")) {
			WaitforElementtobeclickable(xml.getlocator("//locators/ExpandAllButton"));
			Clickon(getwebelement(xml.getlocator("//locators/ExpandAllButton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Expand All Button");
			Thread.sleep(3000);
			// if(!Inputdata[8].toString().equalsIgnoreCase("Wave") &&
			// !Inputdata[8].toString().equalsIgnoreCase("Ethernet Line"))
			// {
			while (!Getattribute(getwebelement(xml.getlocator("//locators/BillingLastRow")), "class")
					.contains("highlight")) {

				int RowCount = getwebelementscount((xml.getlocator("//locators/BillingRow"))) - 1;
				System.out.println(RowCount);

				for (int i = 1; i <= RowCount; i++) {

					Clickon(getwebelement(
							xml.getlocator("//locators/BillingRowAmount").replace("Value", String.valueOf(i))));
					waitforPagetobeenable();
					if (!Getattribute(
							getwebelement(
									xml.getlocator("//locators/BillingRowAmount").replace("Value", String.valueOf(i))),
							"class").contains("disabled")) {

						Clear(getwebelement(xml.getlocator("//locators/BillingRowAmountInput").replace("Value",
								String.valueOf(i))));
						SendKeys(getwebelement(
								xml.getlocator("//locators/BillingRowAmountInput").replace("Value", String.valueOf(i))),
								Amount);
						waitforPagetobeenable();
					} else {
						System.out.println("Not Required to fill");
					}

					Clickon(getwebelement(
							xml.getlocator("//locators/BillingRowBCN").replace("Value", String.valueOf(i))));
					waitforPagetobeenable();
					if (!Getattribute(
							getwebelement(
									xml.getlocator("//locators/BillingRowBCN").replace("Value", String.valueOf(i))),
							"class").contains("disabled")) {

						Clickon(getwebelement(xml.getlocator("//locators/BCNSearchClick")));
						waitforPagetobeenable();
						SendKeys(getwebelement(xml.getlocator("//locators/BCNInstallationChargeNRCInput")),
								Inputdata[25].toString());
						Thread.sleep(3000);
						Clickon(getwebelement(xml.getlocator("//locators/BCNNRCSearch")));
						waitforPagetobeenable();
						Thread.sleep(3000);
						Clickon(getwebelement(xml.getlocator("//locators/BCNNRCSubmit")));// Should add in BSW
																							// enviroment
						waitforPagetobeenable();
					} else {
						System.out.println("Not Required to fill");
					}
				}
				Clickon(getwebelement(xml.getlocator("//locators/FirstLineitem")));
				Thread.sleep(5000);
				Clickon(getwebelement(xml.getlocator("//locators/ClickNextPage")));
				waitforPagetobeenable();
				Thread.sleep(5000);
			}
		}
		// }
		/*
		 * if(Inputdata[8].toString().equalsIgnoreCase("Wave") ||
		 * Inputdata[8].toString().equalsIgnoreCase("Ethernet Line"))//Added by shiva
		 * for Wave and Ethernet Line product specific. {
		 * Clickon(getwebelement(xml3.getlocator("//locators/InstallationChargeNRC")));
		 * ExtentTestManager.getTest().log(LogStatus.PASS,
		 * " Step: Click on Installation Charge NRC");
		 * getwebelement(xml3.getlocator("//locators/InputinstallationChargeNRC")).clear
		 * (); SendKeys(getwebelement(xml3.getlocator(
		 * "//locators/InputinstallationChargeNRC")),Inputdata[23].toString());
		 * ExtentTestManager.getTest().log(LogStatus.PASS,
		 * " Step: Enter Installation Charge NRC");
		 * Clickon(getwebelement(xml3.getlocator("//locators/RecurringChargeMRC")));
		 * ExtentTestManager.getTest().log(LogStatus.PASS,
		 * " Step: Click on Recurring Charge MRC");
		 * getwebelement(xml3.getlocator("//locators/InputRecurringChargeMRC")).clear();
		 * SendKeys(getwebelement(xml3.getlocator("//locators/InputRecurringChargeMRC"))
		 * ,Inputdata[24].toString()); ExtentTestManager.getTest().log(LogStatus.PASS,
		 * " Step: Enter Recurring Charge MRC");
		 * Clickon(getwebelement(xml3.getlocator("//locators/BCNInstallationChargeNRC"))
		 * ); ExtentTestManager.getTest().log(LogStatus.PASS,
		 * " Step: Click on BCN Installation Charge NRC"); Thread.sleep(1000);
		 * safeJavaScriptClick(getwebelement(xml3.getlocator(
		 * "//locators/BCNInstallationChargeNRCSearch")));
		 * ExtentTestManager.getTest().log(LogStatus.PASS,
		 * " Step: Click on BCN Installation Charge NRC Search");
		 * 
		 * SendKeys(getwebelement(xml3.getlocator(
		 * "//locators/BCNInstallationChargeNRCInput")),Inputdata[25].toString());
		 * ExtentTestManager.getTest().log(LogStatus.PASS,
		 * " Step: Enter BCN Installation Charge NRC Input");
		 * Clickon(getwebelement(xml3.getlocator("//locators/BCNNRCSubmit")));
		 * ExtentTestManager.getTest().log(LogStatus.PASS,
		 * " Step: Click on BCN NRC Submit");
		 * Clickon(getwebelement(xml3.getlocator("//locators/BCNRecurringChargeMRC")));
		 * ExtentTestManager.getTest().log(LogStatus.PASS,
		 * " Step: Click on BCN Recurring Charge MRC"); Thread.sleep(1000);
		 * safeJavaScriptClick(getwebelement(xml3.getlocator(
		 * "//locators/BCNRecurringChargeMRCSearch")));
		 * ExtentTestManager.getTest().log(LogStatus.PASS,
		 * " Step: Click on BCN Recurring Charge MRC Search");
		 * SendKeys(getwebelement(xml3.getlocator(
		 * "//locators/BCNRecurringChargeMRCInput")),Inputdata[26].toString());
		 * ExtentTestManager.getTest().log(LogStatus.PASS,
		 * " Step: Enter BCN Recurring Charge MRC Input");
		 * Clickon(getwebelement(xml3.getlocator("//locators/BCNNRCSubmit")));
		 * ExtentTestManager.getTest().log(LogStatus.PASS,
		 * " Step: Click on BCN NRC Submit"); Thread.sleep(5000); }
		 */

	}

	public void EnterInstallationChargeInFooter(Object Inputdata[]) throws Exception {
		if (!Inputdata[8].toString().equals("Cloud UC")) {
			Select(getwebelement(xml.getlocator("//locators/InstalltionDropdown")), "Installation and Test");
			ExtentTestManager.getTest().log(LogStatus.PASS,
					" Step: Click on Installation Dropdown button and Select Installation and Test");

			Thread.sleep(5000);
			Clear(getwebelement(xml.getlocator("//locators/PrimaryTestingMethod")));
			SendKeys(getwebelement(xml.getlocator("//locators/PrimaryTestingMethod")), "Not Required");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/PrimaryTestingMethod")), Keys.TAB);
			savePage();
			Thread.sleep(3000);
			if (!Inputdata[8].toString().equalsIgnoreCase("Wave")
					&& !Inputdata[8].toString().equalsIgnoreCase("Ethernet Line")) {
				Clickon(getwebelement(xml.getlocator("//locators/SaveOrderContinue")));
				waitforPagetobeenable();
				Thread.sleep(3000);
			}
		}
	}

	public void CommercialValidation(Object[] Inputdata) throws Exception {

		getwebelement(xml.getlocator("//locators/OrderStatus")).clear();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Order Status");
		SendKeys(getwebelement(xml.getlocator("//locators/OrderStatus")), "Commercial Validation");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Entered Order Status Commercial Validation");
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/OrderStatus")), Keys.ENTER);
		// Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/OrderStatus")), Keys.TAB);
		waitforPagetobeenable();
		Thread.sleep(2000);
		waitforPagetobeenable();

	}

	public void SelectAttachmentTab(Object[] Inputdata) throws IOException, InterruptedException, DocumentException {
		if (Inputdata[8].toString().equals("IP Voice Solutions") || Inputdata[8].toString().equals("Voice Line V") || Inputdata[8].toString().equals("Managed Virtual Firewall")) {
			Select(getwebelement(xmlIP.getlocator("//locators/tabDropdown")), "Attachments");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Attachments Tab Selected");
			Clickon(getwebelement(xmlIP.getlocator("//locators/AttachmentTabSelection")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Attachments Tab Clicked");
			Thread.sleep(10000);
		}
	}

	public void UploadDocument(Object[] Inputdata) throws Exception {
		if (Inputdata[8].toString().equals("IP Voice Solutions")) {
			UploadSOWTypeDocument(Inputdata, "SOW");
		} else if (Inputdata[8].toString().equals("Voice Line V")) {
			UploadSOWTypeDocument(Inputdata, "Call Barring Form");
			//UploadSOWTypeDocument(Inputdata, "Disaster Recovery Documents");
		}
		else if(Inputdata[8].toString().equals("Managed Virtual Firewall"))
	    {
	    	UploadSOWTypeDocument(Inputdata, "Security Policy");
	    	//UploadSOWTypeDocument(Inputdata, "Documents");
	    }
	}

	public void UploadSOWTypeDocument(Object[] Inputdata, String Filetype) throws Exception {

		if(Inputdata[8].toString().equals("Voice Line V"))	//Added by Rekha
		{
           	System.out.println(xml.getlocator("//locators//FileUpload"));
	    	//WaitforElementtobeclickable(xmlIP.getlocator("//locators//FileUpload"));
	    	uploadafile(xml.getlocator("//locators//FileUpload"),"test.txt");
	    	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Test File Uploaded");
	    	Thread.sleep(10000);
	    	Clickon(getwebelement(xml.getlocator("//locators/DocumnetTypeOther")));
	    	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Other File Type Clicked");
	    	Clickon(getwebelement(xml.getlocator("//locators/DownArrow")));
	    	Clickon(getwebelement(xml.getlocator("//locators/DocumentTypeCallBaringForm")));
	    	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: CallBarring Form File Type Selected");
	    	System.out.println(xml.getlocator("//locators//FileUpload"));
	    	//WaitforElementtobeclickable(xmlIP.getlocator("//locators//FileUpload"));
	    	uploadafile(xml.getlocator("//locators//FileUpload"),"test1.txt");
	    	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Test File Uploaded");
	    	Thread.sleep(10000);
	    	Clickon(getwebelement(xml.getlocator("//locators/DocumnetTypeOther")));
	    	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Other File Type Clicked");
	    	Clickon(getwebelement(xml.getlocator("//locators/DownArrow")));
	    	Clickon(getwebelement(xml.getlocator("//locators/DocumentTypeDisaster")));
	    	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Disaster File Type Selected");
	    
	}
		else {
		
			System.out.println(xmlIP.getlocator("//locators//FileUpload"));
			
					// WaitforElementtobeclickable(xmlIP.getlocator("//locators//FileUpload"));
					uploadafile(xmlIP.getlocator("//locators//FileUpload"), "test.txt");
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Test File Uploaded");
					Thread.sleep(10000);
					Clickon(getwebelement(xmlIP.getlocator("//locators/DocumnetTypeOther")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Other File Type Clicked");
					Clickon(getwebelement(xmlIP.getlocator("//locators/DownArrow")));
					Clickon(getwebelement(xmlIP.getlocator("//locators/DoucmentTypeSelection").replace("Filetype", Filetype)));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: SOW File Type Selected");

			}
		//--> end of Rekha's code
		

	}

	public void TechnicalValidation(Object[] Inputdata) throws Exception {
		// System.out.println("Aman,");
		// Thread.sleep(10000);
		waitforPagetobeenable(); //as per Aman
		WaitforElementtobeclickable(xml.getlocator("//locators/OrderStatusDropdown"));
		Clickon(getwebelement(xml.getlocator("//locators/OrderStatusDropdown")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Entered Order Status Technical Validation");
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/SelectTechnicalValidation")));
		waitforPagetobeenable();
		// savePage();
		Thread.sleep(2000);
		waitforPagetobeenable();
		savePage();
		Thread.sleep(5000);
		if (isDisplayed((xml.getlocator("//locators/AlertAccept")))) {
			WaitforElementtobeclickable((xml.getlocator("//locators/AlertAccept")));
			Clickon(getwebelement(xml.getlocator("//locators/AlertAccept")));
		}
		if (Inputdata[8].toString().equalsIgnoreCase("Wave")
				|| Inputdata[8].toString().equalsIgnoreCase("Private Ethernet")
				|| Inputdata[8].toString().equalsIgnoreCase("Ethernet Line")
				|| Inputdata[8].toString().equalsIgnoreCase("Ethernet Hub")
				|| Inputdata[8].toString().equalsIgnoreCase("Ethernet Spoke") 
				|| Inputdata[8].toString().equalsIgnoreCase("Ultra Low Latency")
				|| Inputdata[8].toString().equalsIgnoreCase("Dark Fibre")) {
			Thread.sleep(5000);
			// as per Aman added try catch
			try
			{
				WaitforElementtobeclickable((xml.getlocator("//locators/TriggerTRButton")));
			Clickon(getwebelement(xml.getlocator("//locators/TriggerTRButton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Trigger TR Button");
			Thread.sleep(10000);
			}
			catch(Exception ex) 
			{
				WaitforElementtobeclickable(xml.getlocator("//locators/BDWREVW_CheckBox"));
				Clickon(getwebelement(xml.getlocator("//locators/BDWREVW_CheckBox")));
				WaitforElementtobeclickable(xml.getlocator("//locators/TriggerTRButton"));
				Clickon(getwebelement(xml.getlocator("//locators/TriggerTRButton")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Trigger TR Button");
				Thread.sleep(10000);
			}
		}
		if (Inputdata[8].toString().equalsIgnoreCase("IP Domain"))	//Added by Rekha
		{
			Thread.sleep(5000);
	        Clickon(getwebelement(xml.getlocator("//locators/TriggerTRButtonCheckbox")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Check Box");
			Clickon(getwebelement(xml.getlocator("//locators/TriggerTRButton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Trigger TR Button");
			Thread.sleep(10000);
		}
	}

	public void DeliveryValidation(Object[] Inputdata) throws Exception {
		waitforPagetobeenable(); //as per Aman
		Thread.sleep(5000);
		WaitforElementtobeclickable(xml.getlocator("//locators/OrderStatusDropdown"));
		Clickon(getwebelement(xml.getlocator("//locators/OrderStatusDropdown")));
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/SelectDeliveryValidation")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Entered Order Status Delivery");
		waitforPagetobeenable();
		Thread.sleep(5000);

//			SendKeys(getwebelement(xml.getlocator("//locators/primarytestingmethod")), "Not Required");
//			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter value in primary test method");
//			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/primarytestingmethod")), Keys.TAB);
//			Thread.sleep(3000);
//			savePage();

	}

	public void TriggerPopup(Object[] Inputdata) throws Exception {
		// waitforPagetobeenable();
		if ((isProductValid(Inputdata[8].toString()))) {
			// System.out.println("DHONI");

			Clickon(getwebelement(xml.getlocator("//locators/TriggerTRButtonCheckbox")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Check Box");
			Clickon(getwebelement(xml.getlocator("//locators/TriggerTRButton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Trigger TR Button");
			Thread.sleep(10000);
			javascriptexecutor(getwebelement(xml.getlocator("//locators/InstallationDropdown")));
			Select(getwebelement(xml.getlocator("//locators/InstallationDropdown")), "Installation and Test");
			ExtentTestManager.getTest().log(LogStatus.PASS,
					" Step: Click on Installation Dropdown button and Select Installation and Test");

			SendKeys(getwebelement(xml.getlocator("//locators/primarytestingmethod")), "Not Required");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter value in primary test method");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/primarytestingmethod")), Keys.TAB);
			Thread.sleep(5000);
		}

	}

	public void clickOnManualValidationA() throws Exception {
		if (isDisplayed(xml.getlocator("//locators/manualvalidation1"))) {

			// Waitforvisibilityofelement(xml.getlocator("//locators/manualvalidation"));
			WaitforElementtobeclickable(xml.getlocator("//locators/manualvalidation1"));
			Clickon(getwebelement(xml.getlocator("//locators/manualvalidation1")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Manual Validation Button");
			waitforPagetobeenable();

			Thread.sleep(5000);
		}
	}

	public void clickOnManualValidationB() throws Exception {
		if (isDisplayed(xml.getlocator("//locators/manualvalidation2"))) {

			// Waitforvisibilityofelement(xml.getlocator("//locators/manualvalidation"));
			WaitforElementtobeclickable(xml.getlocator("//locators/manualvalidation2"));
			Clickon(getwebelement(xml.getlocator("//locators/manualvalidation2")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Manual Validation Button");
			waitforPagetobeenable();

			Thread.sleep(5000);
		}
	}

	public void CompletedValidation(Object[] Inputdata) throws Exception {
		waitforPagetobeenable();
		WaitforElementtobeclickable(xml.getlocator("//locators/OrderStatusDropdown"));
		Clickon(getwebelement(xml.getlocator("//locators/OrderStatusDropdown")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order status drop down");
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/SelectCompleted")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Completed Status");
		waitforPagetobeenable();

		Thread.sleep(5000);
		// savePage();
		// Thread.sleep(6000);
		Clickon(getwebelement(xml.getlocator("//locators/OrderComplete")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Order Complete");
		waitforPagetobeenable();
		Thread.sleep(5000);
		savePage();
		Thread.sleep(10000);
		savePage();
		Thread.sleep(10000);
		if (isDisplayed(xml.getlocator("//locators/AlertAccept"))) {
			System.out.println("");
			System.out.println("Alert Present");
			WaitforElementtobeclickable((xml.getlocator("//locators/AlertAccept")));
			Clickon(getwebelement(xml.getlocator("//locators/AlertAccept")));
		}
		
		// Pagerefresh();
		 Thread.sleep(5000);
		//=======================Added by Rekha ==================== difft pop up was arriving for Ethernet VPN Access=====================
			if(isElementPresent(xml.getlocator("//locators/SubnetworkPopUP")))
			{
			System.out.println("");
			System.out.println("Alert Present");
			WaitforElementtobeclickable((xml.getlocator("//locators/SubnetworkPopUP")));
			Clickon(getwebelement(xml.getlocator("//locators/SubnetworkPopUP")));
			}
		//============================================================================================================
			System.out.println("Order complete");
			Thread.sleep(5000);
		

	}

	public void ServiceTab(Object[] Inputdata) throws Exception {
		Thread.sleep(10000);
		try {
			Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderTab")));
		} catch (Exception e) {
			try {
				safeJavaScriptClick(getwebelement(xml.getlocator("//locators/ServiceOrderTab")));
			} catch (Exception e1) {

				e1.printStackTrace();
			}
		}
		waitforPagetobeenable();
		waitForpageload();
		waitandForElementDisplay(xml.getlocator("//locators/InputServiceOrder"), 5);
		// String x= ServiceOrder.get();
		// System.out.println(x);
		// String string = "004-034556";
		// String[] parts = x.split("/");
		// String part1 = parts[0];
		// String part2 = parts[1];
		// System.out.println(part1);
		// System.out.println(part2);
		Clickon(getwebelement(xml.getlocator("//locators/InputServiceOrder")));
		SendKeys(getwebelement(xml.getlocator("//locators/InputServiceOrder")), ServiceOrder.get().toString());
		Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderGo")));
		waitforPagetobeenable();
		Thread.sleep(6000);
		//================= added Rekha=======Need Modification as endless loop
		do {
			Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderGo")));
			Thread.sleep(20000);
			} while (!isElementPresent("//*[text()='COMPLETE']"));
		//------------end of Rekha code============
		Clickon(getwebelement(xml.getlocator("//locators/ModifyButtonClick")));
		waitforPagetobeenable();
		Thread.sleep(3000);
		SendKeys(getwebelement(xml.getlocator("//locators/OpportunityNo")), Inputdata[1].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Opportunity No");
		SendKeys(getwebelement(xml.getlocator("//locators/RequestReceivedDate")), CurrentDate());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Request Received Date");
		Thread.sleep(3000);
		ModifiedServiceOrder.set(Gettext(getwebelement(xml.getlocator("//locators/ModifyOrderNumber"))));//Added by Rekha
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Generated Modify Order Reference No: " + ModifiedServiceOrder.get());//Added by Rekha
		Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderClickOn")));
		waitforPagetobeenable();
		WaitforElementtobeclickable(xml.getlocator("//locators/OrderSubTypeSearch"));
		Clickon(getwebelement(xml.getlocator("//locators/OrderSubTypeSearch")));
		// System.out.println("Enter New Order");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order Sub Type Search");
		Clickon(getwebelement(xml.getlocator("//locators/AddOrderSubType")));
		waitforPagetobeenable();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Order Sub Type");
		// ---> Condition need to be added for mod com and mod tech

		if (Inputdata[Inputdata.length - 1].toString().contains("Com")|| Inputdata[Inputdata.length - 1].toString().contains("Carnor") ) // Added by Dipesh
			
		{
			SendKeys(getwebelement(xml.getlocator("//locators/InputOrderSubType")), "BCN Change");// Specific for mod
																									// com
		} else if (Inputdata[Inputdata.length - 1].toString().contains("Tech")) {
			SendKeys(getwebelement(xml.getlocator("//locators/InputOrderSubType")), "Upgrade Bandwith"); // specific for
																											// mod tech
		}
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/InputOrderSubType")), Keys.ENTER);

		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order Sub Type DropDown");

		Clickon(getwebelement(xml.getlocator("//locators/SubmitSubOrderType")));
		waitforPagetobeenable();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Submit Sub Order Type");
		Thread.sleep(2000);

//				Clickon(getwebelement(xml.getlocator("//locators/ClickDropdown").replace("Value","Voice Service Country")));
//				Clickon(getwebelement(xml.getlocator("//locators/SelectValueDropdown").replace("Value","Belgium")));
//				
//				Clickon(getwebelement(xml.getlocator("//locators/ClickDropdown").replace("Value","First Codec")));
//				Clickon(getwebelement(xml.getlocator("//locators/SelectValueDropdown").replace("Value", "G.729")));
//				Thread.sleep(2000);
		// WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
		// Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
		if (!Inputdata[8].toString().equalsIgnoreCase("Wave")
				&& !Inputdata[8].toString().equalsIgnoreCase("Ether Line")) // added shivananda
		{
			WaitforElementtobeclickable(xml.getlocator("//locators/MaintenancePartySearch"));
			waitforPagetobeenable();
			Clickon(getwebelement(xml.getlocator("//locators/MaintenancePartySearch")));
			Clickon(getwebelement(xml.getlocator("//locators/MaintenancePartyPopupDropdown")));
			Clickon(getwebelement(xml.getlocator("//locators/SelectValueDropdown").replace("Value", "Party Name")));
			SendKeys(getwebelement(xml.getlocator("//locators/InputAccountStatus")), "Colt");
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/AccountStatusSearch")));
			Thread.sleep(2000);
			Clickon(getwebelement(xml.getlocator("//locators/AccountStatusSearch")));
			waitforPagetobeenable();
			Thread.sleep(4000);
			waitforPagetobeenable();
			Clickon(getwebelement(xml.getlocator("//locators/AccountStatusSubmit")));
			Thread.sleep(3000);
		}
		savePage();
		waitforPagetobeenable();
	}

	public void Check1(Object[] Inputdata) throws Exception {
		ServiceOrder.get();
		System.out.println(ServiceOrder.get());
		String x = ServiceOrder.get();
		// String string = "004-034556";
		String[] parts = x.split("/");
		String part1 = parts[0];
		String part2 = parts[1];
		System.out.println(part1);
		System.out.println(part2);
		Clickon(getwebelement(xml.getlocator("//locators/ClickLink").replace("Value", "Customer Orders")));
		waitforPagetobeenable();
		SendKeys(getwebelement(xml.getlocator("//locators/CustomerOrderInput")), part2);
		Thread.sleep(2000);
		Clickon(getwebelement(xml.getlocator("//locators/CustomerOrderSearch")));

	}

	public void statusReason(Object[] InputData) throws Exception {
		Thread.sleep(4000);
		// Waitforvisibilityofelement(xml.getlocator("//locators/StatusReasonDropdown"));
		WaitforElementtobeclickable(xml.getlocator("//locators/StatusReasonDropdown"));
		Clickon(getwebelement(xml.getlocator("//locators/StatusReasonDropdown")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on status reason dropdown");

		Clickon(getwebelement(
				xml.getlocator("//locators/StatusReasonValue").replace("value", "Abandoned, Order replaced")));
		System.out.println(InputData[90].toString());
		// SendKeys(getwebelement(xml.getlocator("//locators/StatusReasonAbandoned")),
		// InputData[75].toString());
		System.out.println("status reason");
		// ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on abandonked
		// status popup");
		Thread.sleep(4000);
		// SendkeaboardKeys(getwebelement(xml.getlocator("//locators/StatusReasonAbandoned")),
		// Keys.ENTER);
//		Thread.sleep(4000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/StatusReasonAbandoned")), Keys.ENTER);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/StatusReasonAbandoned")), Keys.TAB);
		System.out.println("enter tab");

		savePage();
	}

	public void AbandonedOrder(Object[] Inputdata) throws Exception {

		WaitforElementtobeclickable(xml.getlocator("//locators/OrderStatusDropdown"));
		Clickon(getwebelement(xml.getlocator("//locators/OrderStatusDropdown")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clcik on Order Status dropdown");

		Moveon(getwebelement(xml.getlocator("//locators/OrderStatusAbandoned")));
		waitforPagetobeenable();
		System.out.println("1st page enable of order status abandon");
		waitForpageload();
		System.out.println("page load successfully of abandon");
//		WaitforElementtobeclickable(xml.getlocator("//locators/AbandonYes"));
//		Clickon(getwebelement(xml.getlocator("//locators/AbandonYes")));

		savePage();
		waitForpageload();
		waitandForElementDisplay(xml.getlocator("//locators/ServiceTab"), 5);

	}

	public void verifyOrderAbandoned() throws Exception {

		WaitforElementtobeclickable(xml.getlocator("//locators/ServicTab"));
		safeJavaScriptClick(getwebelement(xml.getlocator("//locators/ServiceTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on service tab");
		Thread.sleep(3000);
		WaitforElementtobeclickable(xml.getlocator("//locators/ServiceOrderSearch"));
		Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderSearch")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on service order search field");

		SendKeys(getwebelement(xml.getlocator("//locators/ServiceOrderSearch")), ServiceOrder.get());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter value in servie field");
		WaitforElementtobeclickable(xml.getlocator("//locators/ServiceOderArrow"));
		Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderArrow")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on service order arrow");

		String expected = Gettext(getwebelement(xml.getlocator("//locators/VerifyAbandoned")));
		System.out.println(expected);
		String actual = "Abandoned";
		Assert.assertEquals(expected, actual);
		Reporter.log("Test has been passed", true);

	}

	public void addSiteADetails(Object[] Inputdata) throws Exception {
		if (Inputdata[8].toString().equalsIgnoreCase("Wave")
				|| Inputdata[8].toString().equalsIgnoreCase("Ethernet Line")) {
			safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/SearchAddressSiteA")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search Address SiteA");
			SendKeys(getwebelement(xml3.getlocator("//locators/StreetNamerfs")), Inputdata[86].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Street Name");
			SendKeys(getwebelement(xml3.getlocator("//locators/Country")), Inputdata[87].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Country");
			SendKeys(getwebelement(xml3.getlocator("//locators/City")), Inputdata[88].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter City");
			SendKeys(getwebelement(xml3.getlocator("//locators/PostalCode")), Inputdata[89].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Postal Code");
			SendKeys(getwebelement(xml3.getlocator("//locators/Premises")), Inputdata[90].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Premises");
			Clickon(getwebelement(xml3.getlocator("//locators/Search")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search");
			Clickon(getwebelement(xml3.getlocator("//locators/pickAddress")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Address");
			Clickon(getwebelement(xml3.getlocator("//locators/Pick")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick");
			Clickon(getwebelement(
					"//table[@id='address_table']//tr//td[contains(text(),'" + Inputdata[91].toString() + "')]"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Building");
			Thread.sleep(20000);
			Clickon(getwebelement(xml3.getlocator("//locators/Pick")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick");
			Clickon(getwebelement(
					"//table[@id='address_table']//tr//td[contains(text(),'" + Inputdata[92].toString() + "')]"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Site");
			Clickon(getwebelement(xml3.getlocator("//locators/Pick")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick");
			Thread.sleep(10000);
			safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/ServicePartySearchSiteA")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Service Party Search SiteA");
			Select(getwebelement(xml3.getlocator("//locators/SelectServiceParty")), "Party Name");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Service Party");
			Thread.sleep(5000);
			SendKeys(getwebelement(xml3.getlocator("//locators/InputServicePartyName")), Inputdata[16].toString());// Domain
																													// Name
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Service Party Name");
			Clickon(getwebelement(xml3.getlocator("//locators/SearchServicePartyName")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search Service Party Name");
			Clickon(getwebelement(xml3.getlocator("//locators/pickServiceParty")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Service Party");
			Clickon(getwebelement(xml3.getlocator("//locators/PickButton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Button");
			safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/SiteContactSearchSiteA")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Site Contact Search SiteA");
			SendKeys(getwebelement(xml3.getlocator("//locators/InputContactName")), Inputdata[17].toString());// DNS
																												// Type
																												// Input
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Contact Name");
			safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/SearchContactName")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search Contact Name");
			Clickon(getwebelement(xml3.getlocator("//locators/pickContactName")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Contact Name");
			Clickon(getwebelement(xml3.getlocator("//locators/PickContact")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Contact");
			Thread.sleep(10000);
		}
	}

	/*
	 * created by : shivananda Rai Date : 12/09/2019 purpose : adding Site B details
	 * based on the city details checked
	 */
	public void addSiteBDetails(Object[] Inputdata) throws Exception {
		if (Inputdata[8].toString().equals("Wave") || Inputdata[8].toString().equalsIgnoreCase("Ethernet Line")) {
			safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/SearchAddressSiteB")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search Address SiteB");
			SendKeys(getwebelement(xml3.getlocator("//locators/StreetNamerfs")), Inputdata[103].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Street Name");
			SendKeys(getwebelement(xml3.getlocator("//locators/Country")), Inputdata[104].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Country");
			SendKeys(getwebelement(xml3.getlocator("//locators/City")), Inputdata[105].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter City");
			SendKeys(getwebelement(xml3.getlocator("//locators/PostalCode")), Inputdata[106].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Postal Code");
			SendKeys(getwebelement(xml3.getlocator("//locators/Premises")), Inputdata[107].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Premises");
			Clickon(getwebelement(xml3.getlocator("//locators/Search")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search");
			Clickon(getwebelement(xml3.getlocator("//locators/pickAddress")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Address");
			Clickon(getwebelement(xml3.getlocator("//locators/Pick")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick");
			Clickon(getwebelement(
					"//table[@id='address_table']//tr//td[contains(text(),'" + Inputdata[108].toString() + "')]"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Building");
			Thread.sleep(20000);
			Clickon(getwebelement(xml3.getlocator("//locators/Pick")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick");
			Clickon(getwebelement(
					"//table[@id='address_table']//tr//td[contains(text(),'" + Inputdata[109].toString() + "')]"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Site");
			Clickon(getwebelement(xml3.getlocator("//locators/Pick")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick");
			Thread.sleep(10000);
			safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/ServicePartySearchSiteB")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Service Party Search SiteB");
			Select(getwebelement(xml3.getlocator("//locators/SelectServiceParty")), "Party Name");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Service Party");
			SendKeys(getwebelement(xml3.getlocator("//locators/InputServicePartyName")), Inputdata[16].toString()); // Domain
																													// Name
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Service Party Name");
			Thread.sleep(10000);
			safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/SearchServicePartyName")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search Service Party Name");
			Clickon(getwebelement(xml3.getlocator("//locators/pickServiceParty")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Service Party");
			Clickon(getwebelement(xml3.getlocator("//locators/PickButton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Button");
			safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/SiteContactSearchSiteB")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Site Contact Search SiteB");
			Thread.sleep(10000);
			SendKeys(getwebelement(xml3.getlocator("//locators/InputContactName")), Inputdata[17].toString()); // DNS
																												// Type
																												// Input
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Contact Name");
			safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/SearchContactName")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search Contact Name");
			Clickon(getwebelement(xml3.getlocator("//locators/pickContactName")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Contact Name");
			Clickon(getwebelement(xml3.getlocator("//locators/PickContact")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Contact");
			Thread.sleep(10000);
		}
	}

	/*
	 * created by : shivananda Rai Date : 12/09/2019 purpose : customize the Site A
	 * details checked
	 */
	public void ASiteCustomize(Object[] Inputdata) throws Exception {
		if (Inputdata[8].toString().equalsIgnoreCase("Ethernet Line")
				|| Inputdata[8].toString().equalsIgnoreCase("Wave")) {
			safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/CustomizeButton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Customize Button");
			Select(getwebelement(xml3.getlocator("//locators/Coverage")), Inputdata[77].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Coverage");
			Thread.sleep(8000);
			Select(getwebelement(xml3.getlocator("//locators/ServiceBandwidth")), Inputdata[78].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Service Bandwidth");
			Thread.sleep(8000);
			Select(getwebelement(xml3.getlocator("//locators/AEndResilienceOption")), Inputdata[75].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select AEnd Resilience Option");
			Thread.sleep(2000);
			Select(getwebelement(xml3.getlocator("//locators/BEndResilienceOption")), Inputdata[76].toString());
			SendkeaboardKeys(getwebelement(xml3.getlocator("//locators/BEndResilienceOption")), Keys.TAB);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select BEnd Resilience Option");
			Thread.sleep(2000);

			if (Inputdata[8].toString().equalsIgnoreCase("Wave")) {
				Select(getwebelement(xml3.getlocator("//locators/subseaWorkerpath")), Inputdata[13].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS,
						" Step: Select Sub Sea Cable System (Worker Path) Option");
				Thread.sleep(2000);

				Select(getwebelement(xml3.getlocator("//locators/subseaprotectedpath")), Inputdata[14].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS,
						" Step: Select Sub Sea Cable System (Protected Path) Option");
				Thread.sleep(2000);
				SendkeaboardKeys(getwebelement(xml3.getlocator("//locators/subseaprotectedpath")), Keys.TAB);
				Thread.sleep(10000);
				// if(isElementPresent((xml3.getlocator("//locators/proceedbotton"))))
				// {
				// WaitforElementtobeclickable((xml3.getlocator("//locators/proceedbotton")));
				// Clickon(getwebelement(xml3.getlocator("//locators/proceedbotton")));
				// ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Proceed
				// button");
				// }
			}

			// savePage();
			safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/Connectionlink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Ethernet Connection Link");
			Clickon(getwebelement(xml3.getlocator("//locators/AEndSite")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on AEnd Site");
			Thread.sleep(10000);
			safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/AccessTechnologySearch")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Technology Search");
			Thread.sleep(20000);
			safeJavaScriptClick(getwebelement(
					"(//table[@summary='Select Access Technology']//tr//td[text()='Colt Fibre']/following-sibling::td[text()='"
							+ Inputdata[119].toString() + "'])[1]"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Access Technology value");
			Clickon(getwebelement(xml3.getlocator("//locators/AccessTechnologySubmit")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Technology Submit");
			Thread.sleep(5000);

			Select(getwebelement(xml3.getlocator("//locators/CustomerSitePopStatusselect")), Inputdata[94].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Customer Site Pop Status");
			Thread.sleep(5000);
			Select(getwebelement(xml3.getlocator("//locators/Buildingtyperfs")), Inputdata[93].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Building");
			Thread.sleep(10000);

			// if(Inputdata[98].toString().equalsIgnoreCase("Ethernet over NGN"))
			// {

			// }
			// else
			// {
			// Clickon(getwebelement(xml3.getlocator("//locators/ThirdPartyAccessProviderSearch")));
			// ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Third Party
			// Access Provider Search");
			// Clickon(getwebelement(xml3.getlocator("//locators/ThirdPartyAccessProviderSelect")));
			// ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Third Party
			// Access Provider Select");
			// Clickon(getwebelement(xml3.getlocator("//locators/ThirdPartyAccessProviderSubmit")));
			// Thread.sleep(10000);
			// Select(getwebelement(xml3.getlocator("//locators/Siebel/ThirdPartyAccessProvider")),Inputdata[45].toString());
			// ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Third Party
			// Access Provider");

			// safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/ThirdPartyConnecRef")));
			// Clear(getwebelement(xml3.getlocator("//locators/ThirdPartyConnecRef")));
			// Thread.sleep(500);
			// SendKeys(getwebelement(xml3.getlocator("//locators/ThirdPartyConnecRef")),Inputdata[65].toString());
			// ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Provide Third Party
			// Connection Reference");
			// Thread.sleep(5000);
			//
			// Select(getwebelement(xml3.getlocator("//locators/ThirdPartySlaTier")),Inputdata[66].toString());
			// ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Third Party
			// SLA Tier");
			// Thread.sleep(5000);
			// }

			if (Inputdata[8].toString().equalsIgnoreCase("Ethernet Line")) {
				safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/CPEInformationLink")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on CPE Information Link");

				Select(getwebelement(xml3.getlocator("//locators/CabinetType")), Inputdata[96].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Cabinet Type");
				Thread.sleep(10000);
				getwebelement(xml3.getlocator("//locators/CabinetId")).clear();
				Thread.sleep(500);
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Cabinet Id");
				SendKeys(getwebelement(xml3.getlocator("//locators/CabinetId")), Inputdata[97].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Enter Cabinet Id");
				// Clickon(getwebelement(xml3.getlocator("//locators/ShelfID")));
				getwebelement(xml3.getlocator("//locators/ShelfID")).clear();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Shelf Id");
				SendKeys(getwebelement(xml3.getlocator("//locators/ShelfID")), "1234");
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Shelf ID");
				SendkeaboardKeys(getwebelement(xml3.getlocator("//locators/ShelfID")), Keys.TAB);
				Thread.sleep(10000);
				savePage();

				safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/AccessPortLink")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Port Link");
				Thread.sleep(10000);
				safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/PresentationInterfaceSearch")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Presentation Interface Search");
				Clickon(getwebelement(
						"//table[@summary='Select Presentation Interface-Connector Type']//tr//td[text()='"
								+ Inputdata[99].toString() + "']"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Select Presentation Interface");
				Clickon(getwebelement(xml3.getlocator("//locators/SubmitPresentationInterface")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Submit Presentation Interface");
				Thread.sleep(10000);
				// Clickon(getwebelement(xml3.getlocator("//locators/Proceed")));
				// Thread.sleep(5000);
				Select(getwebelement(xml3.getlocator("//locators/PortRole")), Inputdata[98].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Port Role");
				Thread.sleep(10000);

				getwebelement(xml3.getlocator("//locators/SlotID")).clear();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Slot Id");
				SendKeys(getwebelement(xml3.getlocator("//locators/SlotID")), "1234");
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Slot Id");
				Thread.sleep(1000);
				getwebelement(xml3.getlocator("//locators/PhysicalPortID")).clear();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Physical Port Id");
				SendKeys(getwebelement(xml3.getlocator("//locators/PhysicalPortID")), "1234");
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Physical Port Id");
				Thread.sleep(500);
				SendkeaboardKeys(getwebelement(xml3.getlocator("//locators/PhysicalPortID")), Keys.TAB);
				Thread.sleep(10000);
				if (Inputdata[98].toString().equalsIgnoreCase("Physical Port")) {
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: No VLan Tagging mode required");
				} else {
					Clickon(getwebelement(xml3.getlocator("//locators/VLANTaggingMode")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on VLAN Tagging Mode");
					Select(getwebelement(xml3.getlocator("//locators/VLANTaggingMode")), Inputdata[100].toString());
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update VLAN Tagging Mode");
					Thread.sleep(10000);
					safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/Vlannew")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on VLAN link");
					Thread.sleep(5000);
					getwebelement(xml3.getlocator("//locators/VlanTagId")).clear();
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Tag Id");
					SendKeys(getwebelement(xml3.getlocator("//locators/VlanTagId")), Inputdata[101].toString());
					SendkeaboardKeys(getwebelement(xml3.getlocator("//locators/VlanTagId")), Keys.ENTER);
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Vlan Tag Id");
					savePage();
					Thread.sleep(5000);
				}
			}

			if (Inputdata[8].toString().equalsIgnoreCase("Wave")) {
				safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/Terminationinformation")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Termination link");

				Select(getwebelement(xml3.getlocator("//locators/CabinetType")), Inputdata[96].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Cabinet Type");
				Thread.sleep(10000);
				getwebelement(xml3.getlocator("//locators/CabinetId")).clear();
				Thread.sleep(500);
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Cabinet Id");
				SendKeys(getwebelement(xml3.getlocator("//locators/CabinetId")), Inputdata[97].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Enter Cabinet Id");
				// Clickon(getwebelement(xml3.getlocator("//locators/ShelfID")));
				getwebelement(xml3.getlocator("//locators/ShelfID")).clear();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Shelf Id");
				SendKeys(getwebelement(xml3.getlocator("//locators/ShelfID")), "1234");
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Shelf ID");
				SendkeaboardKeys(getwebelement(xml3.getlocator("//locators/ShelfID")), Keys.TAB);
				Thread.sleep(10000);
				savePage();

				safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/AccessPortLink")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Port Link");
				Thread.sleep(10000);

				getwebelement(xml3.getlocator("//locators/SlotID")).clear();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Slot Id");
				SendKeys(getwebelement(xml3.getlocator("//locators/SlotID")), "1234");
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Slot Id");
				Thread.sleep(1000);
				getwebelement(xml3.getlocator("//locators/PhysicalPortID")).clear();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Physical Port Id");
				SendKeys(getwebelement(xml3.getlocator("//locators/PhysicalPortID")), "1234");
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Physical Port Id");
				Thread.sleep(500);
				SendkeaboardKeys(getwebelement(xml3.getlocator("//locators/PhysicalPortID")), Keys.TAB);
				Thread.sleep(10000);
				savePage();
			}

			Thread.sleep(10000);
			safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/AEndSite")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on A End Site");
			safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/InstallationTimeLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Installation Time Link");
			Select(getwebelement(xml3.getlocator("//locators/InstallTime")), Inputdata[95].toString());
			SendkeaboardKeys(getwebelement(xml3.getlocator("//locators/InstallTime")), Keys.TAB);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Install Time");
			Thread.sleep(2000);
			safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/Connectionlink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Ethernet Connection Link");
		}
	}

	/*
	 * created by : shivananda Rai Date : 12/09/2019 purpose : customize the Site B
	 * details checked
	 */
	public void BSiteCustomize(Object[] Inputdata) throws Exception {
		if (Inputdata[8].toString().equals("Ethernet Line") || Inputdata[8].toString().equals("Wave")) {
			Clickon(getwebelement(xml3.getlocator("//locators/BEndSite")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on B End Site");

			safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/AccessTechnologySearch")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Technology Search");
			Thread.sleep(10000);

			safeJavaScriptClick(getwebelement(
					"(//table[@summary='Select Access Technology']//tr//td[text()='Colt Fibre']/following-sibling::td[text()='"
							+ Inputdata[120].toString() + "'])[1]"));

			// Clickon(getwebelement("//table[@summary='Select Access
			// Technology']//tr//td[text()='"+Inputdata[28+64].toString()+"']"));
			// SendKeys(getwebelement(xml3.getlocator("//locators/AccessTechnologyInput")),Inputdata[28+64].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Technology Select");
			Clickon(getwebelement(xml3.getlocator("//locators/AccessTechnologySubmit")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Technology Submit");
			Thread.sleep(5000);

			Select(getwebelement(xml3.getlocator("//locators/CustomerSitePopStatusBEnd")), Inputdata[111].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Customer Site Pop Status B End");
			Thread.sleep(5000);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Building type BEnd");
			Thread.sleep(5000);

			Select(getwebelement(xml.getlocator("//locators/BuildingtypeBEnd")), Inputdata[110].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Building type BEnd");
			Thread.sleep(5000);

			// if(Inputdata[28+63].toString().equalsIgnoreCase("Ethernet over NGN"))
			// {
			// Select(getwebelement(xml3.getlocator("//locators/CustomerSitePopStatusBEnd")),Inputdata[28+55].toString());
			// ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Customer Site
			// Pop Status B End");
			// Thread.sleep(5000);
			// Select(getwebelement(xml3.getlocator("//locators/BuildingtypeBEnd")),Inputdata[28+54].toString());
			// ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Building type
			// BEnd");
			// Thread.sleep(5000);
			// }
			// else
			// {
			// Clickon(getwebelement(xml3.getlocator("//locators/ThirdPartyAccessProviderSearch")));
			// ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Third Party
			// Access Provider Search");
			// Clickon(getwebelement(xml3.getlocator("//locators/ThirdPartyAccessProviderSelect")));
			// ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Third Party
			// Access Provider Select");
			// Clickon(getwebelement(xml3.getlocator("//locators/ThirdPartyAccessProviderSubmit")));
			// Thread.sleep(10000);
			// Select(getwebelement(xml3.getlocator("//locators/Siebel/ThirdPartyAccessProvider")),Inputdata[45].toString());
			// ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Third Party
			// Access Provider"

			// safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/ThirdPartyConnecRef")));
			// Clear(getwebelement(xml3.getlocator("//locators/ThirdPartyConnecRef")));
			// Thread.sleep(500);
			// SendKeys(getwebelement(xml3.getlocator("//locators/ThirdPartyConnecRef")),Inputdata[65].toString());
			// ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Provide Third Party
			// Connection Reference");
			// Thread.sleep(5000);
			//
			// Select(getwebelement(xml3.getlocator("//locators/ThirdPartySlaTier")),Inputdata[68].toString());
			// ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Third Party
			// SLA Tier");
			// Thread.sleep(5000);

			// }

			if (Inputdata[8].toString().equalsIgnoreCase("Ethernet Line")) {
				safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/CPEInformationLink")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on CPE Information Link");
				Select(getwebelement(xml3.getlocator("//locators/CabinetTypeBEnd")), Inputdata[113].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Cabinet Type B End");
				safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/CabinetIdBEnd")));
				Thread.sleep(500);
				getwebelement(xml3.getlocator("//locators/CabinetIdBEnd")).clear();
				Thread.sleep(500);
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Cabinet Id BEnd");
				SendKeys(getwebelement(xml3.getlocator("//locators/CabinetIdBEnd")), Inputdata[114].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Cabinet Id BEnd");
				getwebelement(xml3.getlocator("//locators/ShelfID")).clear();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Cabinet Id");
				SendKeys(getwebelement(xml3.getlocator("//locators/ShelfID")), "1234");
				Thread.sleep(10000);
				SendkeaboardKeys(getwebelement(xml3.getlocator("//locators/ShelfID")), Keys.TAB);
				Thread.sleep(5000);
				safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/AccessPortLink")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Port Link");
				Thread.sleep(5000);
				safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/PresentationInterfaceSearch")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Presentation Interface Search");
				Clickon(getwebelement(
						"//table[@summary='Select Presentation Interface-Connector Type']//tr//td[text()='"
								+ Inputdata[116].toString() + "']"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Select Presentation Interface");
				Clickon(getwebelement(xml3.getlocator("//locators/SubmitPresentationInterface")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Submit Presentation Interface");
				Thread.sleep(5000);
				// Clickon(getwebelement(xml3.getlocator("//locators/Proceed")));
				// Thread.sleep(5000);
				Select(getwebelement(xml3.getlocator("//locators/PortRoleBEnd")), Inputdata[115].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Port Role B End");
				Thread.sleep(5000);

				getwebelement(xml3.getlocator("//locators/SlotID")).clear();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Slot Id");
				SendKeys(getwebelement(xml3.getlocator("//locators/SlotID")), "1234");
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Slot Id");
				Thread.sleep(1000);
				getwebelement(xml3.getlocator("//locators/PhysicalPortID")).clear();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Physical Port Id");
				SendKeys(getwebelement(xml3.getlocator("//locators/PhysicalPortID")), "1234");
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Physical Port Id");
				Thread.sleep(500);
				SendkeaboardKeys(getwebelement(xml3.getlocator("//locators/PhysicalPortID")), Keys.TAB);
				Thread.sleep(10000);

				if (Inputdata[115].toString().equalsIgnoreCase("Physical Port")) {
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: No VLan Tagging mode required");
				} else {
					Clickon(getwebelement(xml3.getlocator("//locators/VLANTaggingMode")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on VLAN Tagging Mode");
					Select(getwebelement(xml3.getlocator("//locators/VLANTaggingMode")), Inputdata[117].toString());
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update VLAN Tagging Mode");
					Thread.sleep(10000);
					Clickon(getwebelement(xml3.getlocator("//locators/VLAN")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on VLAN link");
					Thread.sleep(2000);
					getwebelement(xml3.getlocator("//locators/VlanTagId")).clear();
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Tag Id");
					SendKeys(getwebelement(xml3.getlocator("//locators/VlanTagId")), Inputdata[118].toString());
					SendkeaboardKeys(getwebelement(xml3.getlocator("//locators/VlanTagId")), Keys.ENTER);
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Vlan Tag Id");
					savePage();
					Thread.sleep(5000);
				}
			}
			if (Inputdata[8].toString().equalsIgnoreCase("Wave")) {
				safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/Terminationinformation")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Termination link");
				Thread.sleep(2000);

				Select(getwebelement(xml3.getlocator("//locators/CabinetTypeBEnd")), Inputdata[113].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Cabinet Type B End");
				safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/CabinetIdBEnd")));
				Thread.sleep(500);
				getwebelement(xml3.getlocator("//locators/CabinetIdBEnd")).clear();
				Thread.sleep(500);
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Cabinet Id BEnd");
				SendKeys(getwebelement(xml3.getlocator("//locators/CabinetIdBEnd")), Inputdata[114].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Cabinet Id BEnd");
				getwebelement(xml3.getlocator("//locators/ShelfID")).clear();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Cabinet Id");
				SendKeys(getwebelement(xml3.getlocator("//locators/ShelfID")), "1234");
				Thread.sleep(10000);
				SendkeaboardKeys(getwebelement(xml3.getlocator("//locators/ShelfID")), Keys.TAB);
				Thread.sleep(5000);

				safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/AccessPortLink")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Port Link");
				Thread.sleep(10000);

				getwebelement(xml3.getlocator("//locators/SlotID")).clear();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Slot Id");
				SendKeys(getwebelement(xml3.getlocator("//locators/SlotID")), "1234");
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Slot Id");
				Thread.sleep(1000);
				getwebelement(xml3.getlocator("//locators/PhysicalPortID")).clear();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Physical Port Id");
				SendKeys(getwebelement(xml3.getlocator("//locators/PhysicalPortID")), "1234");
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Physical Port Id");
				Thread.sleep(500);
				SendkeaboardKeys(getwebelement(xml3.getlocator("//locators/PhysicalPortID")), Keys.TAB);
				Thread.sleep(10000);
				savePage();
			}
			safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/BEndSite")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on B End Site");
			safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/InstallationTimeLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Installation Time Link");
			Select(getwebelement(xml3.getlocator("//locators/InstallTimeBEnd")), Inputdata[112].toString());
			SendkeaboardKeys(getwebelement(xml3.getlocator("//locators/InstallTimeBEnd")), Keys.TAB);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Install Time BEnd");
			Thread.sleep(2000);
			safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/DoneEthernetConnection")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Done Ethernet Connection");
			// AcceptJavaScriptMethod();
			Thread.sleep(20000);
		}
	}

	/*
	 * created by : shivananda Rai Date : 14/09/2019 purpose : customize se the OOS
	 * platform as legacy and get refernce no checked
	 */
	public void getReferenceNo(Object[] Inputdata) throws Exception, Exception {
		if (Inputdata[8].toString().equalsIgnoreCase("Wave")
				|| Inputdata[8].toString().equalsIgnoreCase("Ethernet Line")) {
			Select(getwebelement(xml3.getlocator("//locators/OSSPlatformFlag")), "Legacy");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select OSS Platform Flag");
			Thread.sleep(30000);

			Clickon(getwebelement(xml3.getlocator("//locators/Getreferencebutton")));
			Thread.sleep(20000);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Get Reference button");
			Thread.sleep(10000);
			Circuitreferencenumber
					.set(Getattribute(getwebelement(xml3.getlocator("//locators/ReferenceInput")), "value"));
			ExtentTestManager.getTest().log(LogStatus.PASS,
					" Step: Reference Input No: " + Circuitreferencenumber.get());
			Log.info("Reference Input value: " + Circuitreferencenumber.get());
		}
		//===================== Rekha==================
				if(Inputdata[8].toString().equalsIgnoreCase("Ethernet VPN Access"))
				{
				WaitforElementtobeclickable((xml.getlocator("//locators/CircuitReferenceAccess")));
				Clickon(getwebelement(xml.getlocator("//locators/CircuitReferenceAccess")));
				Thread.sleep(25000);

				savePage();
				waitforPagetobeenable();
				Thread.sleep(8000);

				Circuitreferencenumber.set(Gettext(getwebelement(xml.getlocator("//locators/CircuitReferenceValue']"))));
				ExtentTestManager.getTest().log(LogStatus.PASS,
				" Step: Generated Service Order Reference No: " + Circuitreferencenumber.get());



				}

	}

	/*
	 * added by-Vikram for Hub product to store Ntwrk reference in a variable for
	 * Spoke to take Hub Ntwrk Refrn nmbr
	 */
	public void addEthernetSiteHub(Object[] Inputdata) throws Exception {
		if (Inputdata[8].toString().equalsIgnoreCase("Ethernet Hub")
				|| Inputdata[8].toString().equalsIgnoreCase("Ethernet Spoke")) {

			safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/Searchbutton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search Button");
			Thread.sleep(3000);
			SendKeys(getwebelement(xmlHns.getlocator("//locators/StreetName")), Inputdata[86].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Street Name");
			SendKeys(getwebelement(xmlHns.getlocator("//locators/Country")), Inputdata[87].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Country");
			SendKeys(getwebelement(xmlHns.getlocator("//locators/City")), Inputdata[88].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter City");
			SendKeys(getwebelement(xmlHns.getlocator("//locators/PostalCode")), Inputdata[89].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Postal Code");
			SendKeys(getwebelement(xmlHns.getlocator("//locators/Premises")), Inputdata[90].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Premises");
			Clickon(getwebelement(xmlHns.getlocator("//locators/Search")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search");
			Clickon(getwebelement(xmlHns.getlocator("//locators/pickAddress")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Address");
			Clickon(getwebelement(xmlHns.getlocator("//locators/Pick")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick");
			Clickon(getwebelement(
					"//table[@id='address_table']//tr//td[contains(text(),'" + Inputdata[91].toString() + "')]"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Building");
			Clickon(getwebelement(xmlHns.getlocator("//locators/Pick")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick");
			Clickon(getwebelement(
					"//table[@id='address_table']//tr//td[contains(text(),'" + Inputdata[92].toString() + "')]"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Site");
			Clickon(getwebelement(xmlHns.getlocator("//locators/Pick")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick");
			Thread.sleep(10000);
			safeJavaScriptClick(getwebelement(xmlHns.getlocator("locators/ServicePartySearch")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Service Party Search");
			Select(getwebelement(xmlHns.getlocator("//locators/SelectServiceParty")), "Party Name");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Service Party Search");

			SendKeys(getwebelement(xmlHns.getlocator("//locators/InputServicePartyName")), Inputdata[16].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Service Party Name");
			Clickon(getwebelement(xmlHns.getlocator("//locators/SearchServicePartyName")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Service Party Name");
			Clickon(getwebelement(xmlHns.getlocator("//locators/pickServiceParty")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Service Party");
			Clickon(getwebelement(xmlHns.getlocator("//locators/PickButton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Button");
			safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/SiteContactSearch")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Site Contact Search");
			SendKeys(getwebelement(xmlHns.getlocator("//locators/InputContactName")), Inputdata[17].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Contact Name");
			safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/SearchContactName")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Contact Name");
			Clickon(getwebelement(xmlHns.getlocator("//locators/pickContactName")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Contact Name");
			Clickon(getwebelement(xmlHns.getlocator("//locators/PickContact")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Contact");
			Thread.sleep(10000);
		}
	}

	/*
	 * added by-Vikram for Hub product for Spoke
	 */
	public void hubSiteCustomize(Object[] Inputdata) throws Exception {
		if (Inputdata[8].toString().equalsIgnoreCase("Ethernet Hub")) {

			Clickon(getwebelement(xmlHns.getlocator("//locators/CustomizeButton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Customize Button");
			Thread.sleep(5000);
			Select(getwebelement(xmlHns.getlocator("//locators/ServiceBandwidth")), Inputdata[32].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Service Bandwidth");
			Thread.sleep(5000);
			Select(getwebelement(xmlHns.getlocator("//locators/SelectResilienceOption")), Inputdata[75].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select ResilienceOption");
			savePage();
			Thread.sleep(5000);
			safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/EthernetConnectionLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Ethernet Connection Link");
			safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/HubSiteLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Hub Site Link");
			safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/AccessTechnologySearch")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Technology Search");
			Clickon(getwebelement("//table[@summary='Select Access Technology']//tr//td[text()='"
					+ Inputdata[119].toString() + "']"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Technology");
			Clickon(getwebelement(xmlHns.getlocator("//locators/SubmitAccessTechnology")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Submit Technology Search");
			Thread.sleep(10000);
			Select(getwebelement(xmlHns.getlocator("//locators/CustomerSitePopStatusselect")),
					Inputdata[94].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Customer Site Pop Status");
			Thread.sleep(5000);

			Select(getwebelement(xmlHns.getlocator("//locators/BuildingType")), Inputdata[93].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Building Type");
			safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/CPEInformationLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on CPE Information Link");
			Select(getwebelement(xmlHns.getlocator("//locators/CabinetType")), Inputdata[96].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Cabinet Type");
			Thread.sleep(1000);
			getwebelement(xmlHns.getlocator("//locators/CabinetId")).clear();
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Cabinet ID");
			SendKeys(getwebelement(xmlHns.getlocator("//locators/CabinetId")), Inputdata[97].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Cabinet ID");
			Thread.sleep(1000);
			getwebelement(xmlHns.getlocator("//locators/ShelfID")).clear();
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Shelf ID");
			SendKeys(getwebelement(xmlHns.getlocator("//locators/ShelfID")), "1234");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Shelf ID");
			savePage();
			Thread.sleep(5000);
			safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/AccessPortLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Port Link");
			Thread.sleep(5000);

			safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/PresentationInterfaceSearch")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Presentation Interface Search");
			Clickon(getwebelement("//table[@summary='Select Presentation Interface-Connector Type']//tr//td[text()='"
					+ Inputdata[99].toString() + "']"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Presentation Interface Hub");
			Clickon(getwebelement(xmlHns.getlocator("//locators/SubmitPresentationInterface")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Submit Presentation Interface");
			Thread.sleep(5000);
//	Clickon(getwebelement(xmlHns.getlocator("//locators/Proceed")));
//	Thread.sleep(5000);
			Select(getwebelement(xmlHns.getlocator("//locators/PortRole")), Inputdata[98].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Port Role");
			Thread.sleep(1000);
			getwebelement(xmlHns.getlocator("//locators/SlotID")).clear();
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Slot Id");
			SendKeys(getwebelement(xmlHns.getlocator("//locators/SlotID")), "1234");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Slot Id");
			Thread.sleep(1000);
			getwebelement(xmlHns.getlocator("//locators/PhysicalPortID")).clear();
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Physical Port Id");
			SendKeys(getwebelement(xmlHns.getlocator("//locators/PhysicalPortID")), "1234");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Physical Port Id");
			Thread.sleep(500);
			SendkeaboardKeys(getwebelement(xmlHns.getlocator("//locators/PhysicalPortID")), Keys.TAB);
			Thread.sleep(10000);
			if (Inputdata[98].toString().equalsIgnoreCase("Physical Port")) {
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: No VLan Tagging mode required");
			} else {
				Clickon(getwebelement(xmlHns.getlocator("//locators/VLANTaggingMode")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on VLAN Tagging Mode");
				Select(getwebelement(xmlHns.getlocator("//locators/VLANTaggingMode")), Inputdata[100].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update VLAN Tagging Mode");
				Thread.sleep(10000);
				safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/Vlannew")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on VLAN link");
				Thread.sleep(5000);
				getwebelement(xmlHns.getlocator("//locators/VlanTagId")).clear();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Tag Id");
				SendKeys(getwebelement(xmlHns.getlocator("//locators/VlanTagId")), Inputdata[101].toString());
				SendkeaboardKeys(getwebelement(xmlHns.getlocator("//locators/VlanTagId")), Keys.ENTER);
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Vlan Tag Id");
				savePage();
				Thread.sleep(5000);
			}

			Thread.sleep(10000);

			safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/HubSiteLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Hub Site Link");
			Clickon(getwebelement(xmlHns.getlocator("//locators/InstallationTimeLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Installation Time Link");
			Select(getwebelement(xmlHns.getlocator("//locators/InstallTime")), Inputdata[95].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Install Time");
			Clickon(getwebelement(xmlHns.getlocator("//locators/DoneEthernetConnection")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Ethernet Connection");
			Thread.sleep(30000);
		}
	}
	/*
	 * added by-Vikram for Hub product for Spoke
	 */

	public void addEthernetSiteSpoke(Object[] Inputdata) throws Exception {
		safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/SearchAddressSiteB")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search Address SiteB");
		SendKeys(getwebelement(xmlHns.getlocator("//locators/StreetName")), Inputdata[103].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Street Name");
		SendKeys(getwebelement(xmlHns.getlocator("//locators/Country")), Inputdata[104].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Country");
		SendKeys(getwebelement(xmlHns.getlocator("//locators/City")), Inputdata[105].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter City");
		SendKeys(getwebelement(xmlHns.getlocator("//locators/PostalCode")), Inputdata[106].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Postal Code");
		SendKeys(getwebelement(xmlHns.getlocator("//locators/Premises")), Inputdata[107].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Premises");
		Clickon(getwebelement(xmlHns.getlocator("//locators/Search")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search");
		Clickon(getwebelement(xmlHns.getlocator("//locators/pickAddress")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Address");
		Clickon(getwebelement(xmlHns.getlocator("//locators/Pick")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick");
		Clickon(getwebelement(
				"//table[@id='address_table']//tr//td[contains(text(),'" + Inputdata[108].toString() + "')]"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Building");
		Thread.sleep(20000);
		Clickon(getwebelement(xmlHns.getlocator("//locators/Pick")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick");
		Clickon(getwebelement(
				"//table[@id='address_table']//tr//td[contains(text(),'" + Inputdata[109].toString() + "')]"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Site");
		Clickon(getwebelement(xmlHns.getlocator("//locators/Pick")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick");
		Thread.sleep(10000);
		safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/ServicePartySearchSiteB")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Service Party Search SiteB");
		Select(getwebelement(xmlHns.getlocator("//locators/SelectServiceParty")), "Party Name");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Service Party");
		SendKeys(getwebelement(xmlHns.getlocator("//locators/InputServicePartyName")), Inputdata[16].toString()); // Domain
																													// Name
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Service Party Name");
		Thread.sleep(10000);
		safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/SearchServicePartyName")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search Service Party Name");
		Clickon(getwebelement(xmlHns.getlocator("//locators/pickServiceParty")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Service Party");
		Clickon(getwebelement(xmlHns.getlocator("//locators/PickButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Button");
		safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/SiteContactSearchSiteB")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Site Contact Search SiteB");
		Thread.sleep(10000);
		SendKeys(getwebelement(xmlHns.getlocator("//locators/InputContactName")), Inputdata[17].toString()); // DNS Type
																												// Input
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Contact Name");
		safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/SearchContactName")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search Contact Name");
		Clickon(getwebelement(xmlHns.getlocator("//locators/pickContactName")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Contact Name");
		Clickon(getwebelement(xmlHns.getlocator("//locators/PickContact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Contact");
		Thread.sleep(10000);
	}

	/*
	 * added by-Vikram for Hub product for Spoke
	 */
	public void spokeSiteCustomize(Object[] Inputdata) throws Exception {

		Clickon(getwebelement(xmlHns.getlocator("//locators/CustomizeButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Customize Button");
		Thread.sleep(5000);
		Select(getwebelement(xmlHns.getlocator("//locators/Coverage")), Inputdata[77].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Coverage");
		Thread.sleep(3000);
		Select(getwebelement(xmlHns.getlocator("//locators/ServiceBandwidth")), Inputdata[78].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Service Bandwidth");
		Thread.sleep(2000);
		Select(getwebelement(xmlHns.getlocator("//locators/Resilience")), Inputdata[76].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Resilience Option");
		Thread.sleep(3000);
		savePage();
		Thread.sleep(5000);
		safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/EthernetConnectionLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Ethernet Connection Link");
		safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/SpokeSiteLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Spoke Site Link");

		safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/AccessTechnologySearch")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Technology Search");
		Clickon(getwebelement(
				"//table[@summary='Select Access Technology']//tr//td[text()='" + Inputdata[120].toString() + "']"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Technology Select");
		Clickon(getwebelement(xmlHns.getlocator("//locators/AccessTechnologySubmit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Technology Submit");
		Thread.sleep(3000);
		Select(getwebelement(xmlHns.getlocator("//locators/CustomerSitePopStatusselect")), Inputdata[111].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Customer Site Pop Status");
		Thread.sleep(5000);
		Select(getwebelement(xmlHns.getlocator("//locators/BuildingType")), Inputdata[110].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Building");
		Thread.sleep(5000);
		safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/CPEInformationLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on CPE Information Link");
		Thread.sleep(1000);
		Select(getwebelement(xmlHns.getlocator("//locators/CabinetType")), Inputdata[113].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Cabinet Type");

		Thread.sleep(1000);
		getwebelement(xmlHns.getlocator("//locators/CabinetId")).clear();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Cabinet Id");
		SendKeys(getwebelement(xmlHns.getlocator("//locators/CabinetId")), Inputdata[114].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Enter Cabinet Id");
		getwebelement(xmlHns.getlocator("//locators/ShelfID")).clear();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Shelf Id");
		SendKeys(getwebelement(xmlHns.getlocator("//locators/ShelfID")), "1234");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Shelf ID");
		savePage();
		Thread.sleep(5000);
		safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/AccessPortLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Port Link");
		Thread.sleep(5000);

		safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/PresentationInterfaceSearch")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Presentation Interface Search");
		Clickon(getwebelement("//table[@summary='Select Presentation Interface-Connector Type']//tr//td[text()='"
				+ Inputdata[116].toString() + "']"));
		// Clickon(getwebelement("//table[@summary='Select Presentation
		// Interface-Connector Type']//tr//td[text()='"+Inputdata[41].toString()+"']"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Select Presentation Interface");
		Clickon(getwebelement(xmlHns.getlocator("//locators/SubmitPresentationInterface")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Submit Presentation Interface");
		Thread.sleep(5000);
//	Clickon(getwebelement(xmlHns.getlocator("//locators/Proceed")));
//	Thread.sleep(5000);

		Select(getwebelement(xmlHns.getlocator("//locators/PortRole")), Inputdata[115].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Port Role");
		Thread.sleep(1000);
		getwebelement(xmlHns.getlocator("//locators/SlotID")).clear();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Slot Id");
		Thread.sleep(1000);
		SendKeys(getwebelement(xmlHns.getlocator("//locators/SlotID")), "1234");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Slot Id");
		Thread.sleep(1000);
		getwebelement(xmlHns.getlocator("//locators/PhysicalPortID")).clear();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Physical Port Id");
		SendKeys(getwebelement(xmlHns.getlocator("//locators/PhysicalPortID")), "1234");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Physical Port Id");
		Thread.sleep(3000);
		SendkeaboardKeys(getwebelement(xmlHns.getlocator("//locators/PhysicalPortID")), Keys.TAB);
		Thread.sleep(10000);
		if (Inputdata[115].toString().equalsIgnoreCase("Physical Port")) {
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: No VLan Tagging mode required");
		} else {
			Clickon(getwebelement(xmlHns.getlocator("//locators/VLANTaggingMode")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on VLAN Tagging Mode");
			Select(getwebelement(xmlHns.getlocator("//locators/VLANTaggingMode")), Inputdata[117].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update VLAN Tagging Mode");
		}
		Thread.sleep(10000);
		safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/Vlannew")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on VLAN link");
		Thread.sleep(2000);
		getwebelement(xmlHns.getlocator("//locators/VlanTagId")).clear();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Tag Id");
		SendKeys(getwebelement(xmlHns.getlocator("//locators/VlanTagId")), Inputdata[118].toString());
		SendkeaboardKeys(getwebelement(xmlHns.getlocator("//locators/VlanTagId")), Keys.ENTER);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Vlan Tag Id");
		savePage();
		Thread.sleep(5000);
		safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/SpokeSiteLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Spoke Site Link");
		Clickon(getwebelement(xmlHns.getlocator("//locators/InstallationTimeLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Installation Time Link");
		Select(getwebelement(xmlHns.getlocator("//locators/InstallTime")), Inputdata[112].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Install Time");
		Clickon(getwebelement(xmlHns.getlocator("//locators/DoneEthernetConnection")));
		Thread.sleep(20000);

	}
	/*
	 * added by-Vikram for Hub product for Spoke
	 */

	public void OrderCompleteEthernetHubSpoke(Object[] Inputdata) throws Exception, Exception {
		Select(getwebelement(xmlHns.getlocator("//locators/OSSPlatformFlag")), "Legacy");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select OSS Platform Flag");
		Thread.sleep(30000);
		Clickon(getwebelement(xmlHns.getlocator("//locators/Getreferencebutton")));
		Thread.sleep(20000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Get Reference button");
		Thread.sleep(10000);

		Circuitreferencenumber
				.set(Getattribute(getwebelement(xmlHns.getlocator("//locators/ReferenceInput")), "value"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Reference Input No: " + Circuitreferencenumber.get());
		Log.info("Reference Input value: " + Circuitreferencenumber.get());
		Clickon(getwebelement(xmlHns.getlocator("//locators/ServiceOrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Service Order Tab");
		Thread.sleep(5000);

		SendKeys(getwebelement(xmlHns.getlocator("//locators/InputOrderNo")), ServiceOrder.get());
		// SendKeys(getwebelement(xmlHns.getlocator("//locators/InputOrderNo")),"871600916/190915-0033");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Hub Order to Complete: " + ServiceOrder.get());
		Thread.sleep(10000);

		Clickon(getwebelement(xmlHns.getlocator("//locators/SearchOrderNo")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search Order No");
		Clickon(getwebelement(xmlHns.getlocator("//locators/ClickOrderNo")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order No");
		Thread.sleep(30000);
		Select(getwebelement(xmlHns.getlocator("//locators/DropDown")), "Installation and Test");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Installation And Test Tab");
		Thread.sleep(10000);
		SendKeys(getwebelement(xmlHns.getlocator("//locators/PrimaryTestingMethod")), "Not Required");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Primary Testing Method");
		Thread.sleep(5000);
		savePage();
		Thread.sleep(5000);

		Clickon(getwebelement(xmlHns.getlocator("//locators/ManualValidation")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Manual Validation");
		Thread.sleep(5000);
		safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/OrderStatus")));
		getwebelement(xmlHns.getlocator("//locators/OrderStatus")).clear();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Order Status");
//		Clickon(getwebelement(xmlHns.getlocator("//locators/WarningOk")));
//		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Ok in displayed Warning");
		Thread.sleep(10000);
		safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/OrderStatusDropdown")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order status drop down");
		Thread.sleep(3000);
		Clickon(getwebelement(xmlHns.getlocator("//locators/SelectCompleted")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Completed Status");
		Thread.sleep(10000);
		Clickon(getwebelement(xmlHns.getlocator("//locators/OrderComplete")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Order Complete");
		Thread.sleep(50000);
	}

	/*
	 * added by-Vikram for Hub product for Spoke
	 */
	public void installationCharges(Object Inputdata[]) throws Exception {

		if (Inputdata[8].toString().equalsIgnoreCase("Ethernet Hub")
				|| (Inputdata[8].toString().equalsIgnoreCase("Ethernet Spoke"))) {

			Clickon(getwebelement(xmlHns.getlocator("//locators/ExpandAllButton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Expand All Button");
			Thread.sleep(3000);
			Clickon(getwebelement(xmlHns.getlocator("//locators/InstallationChargeNRC")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Installation Charge NRC");
			getwebelement(xmlHns.getlocator("//locators/InputinstallationChargeNRC")).clear();
			SendKeys(getwebelement(xmlHns.getlocator("//locators/InputinstallationChargeNRC")),
					Inputdata[23].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Installation Charge NRC");
			Clickon(getwebelement(xmlHns.getlocator("//locators/RecurringChargeMRC")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Recurring Charge MRC");
			getwebelement(xmlHns.getlocator("//locators/InputRecurringChargeMRC")).clear();
			SendKeys(getwebelement(xmlHns.getlocator("//locators/InputRecurringChargeMRC")), Inputdata[24].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Recurring Charge MRC");
			Clickon(getwebelement(xmlHns.getlocator("//locators/BCNInstallationChargeNRC")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on BCN Installation Charge NRC");
			Thread.sleep(1000);
			safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/BCNInstallationChargeNRCSearch")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on BCN Installation Charge NRC Search");
			SendKeys(getwebelement(xmlHns.getlocator("//locators/BCNInstallationChargeNRCInput")),
					Inputdata[25].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter BCN Installation Charge NRC Input");
			Clickon(getwebelement(xmlHns.getlocator("//locators/BCNNRCSubmit")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on BCN NRC Submit");
			Clickon(getwebelement(xmlHns.getlocator("//locators/BCNRecurringChargeMRC")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on BCN Recurring Charge MRC");
			Thread.sleep(1000);
			safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/BCNRecurringChargeMRCSearch")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on BCN Recurring Charge MRC Search");
			SendKeys(getwebelement(xmlHns.getlocator("//locators/BCNRecurringChargeMRCInput")),
					Inputdata[26].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter BCN Recurring Charge MRC Input");
			Clickon(getwebelement(xmlHns.getlocator("//locators/BCNNRCSubmit")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on BCN NRC Submit");
			Thread.sleep(5000);
		}
	}

	/* Added by Abhay for IPVPNSITEMiddleApplet */
	public void IPVPNSITEMiddleApplet(Object[] Inputdata) throws Exception {

		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "Site Type")));
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/SelectValueDropdown").replace("Value", "IP VPN")));
		waitforPagetobeenable();

		Clickon(getwebelement(
				xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "Service Bandwidth (Primary)")));
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/SelectValueDropdown").replace("Value", "1 Mbps")));
		waitforPagetobeenable();

//		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value","Layer 3 Resilience")));
//		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/SelectValueDropdown").replace("Value",Inputdata[39].toString())));
//		waitforPagetobeenable();

		Clear(getwebelement(
				xml.getlocator("//locators/IPVPNSite/TextInput").replace("Value", "Capacity Check Reference")));
		SendKeys(
				getwebelement(
						xml.getlocator("//locators/IPVPNSite/TextInput").replace("Value", "Capacity Check Reference")),
				"12");
		SendkeaboardKeys(
				getwebelement(
						xml.getlocator("//locators/IPVPNSite/TextInput").replace("Value", "Capacity Check Reference")),
				Keys.ENTER);
		Thread.sleep(2000);

		Clickon(getwebelement(
				xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "Hard Modify Flag")));
		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/SelectValueDropdown").replace("Value", "N")));
		Thread.sleep(2000);
		waitforPagetobeenable();

		Clickon(getwebelement(
				xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "OSS Platform Flag (Primary)")));
		Clickon(getwebelement(
				xml.getlocator("//locators/IPVPNSite/SelectValueDropdown").replace("Value", Inputdata[38].toString())));
		waitforPagetobeenable();

		WaitforElementtobeclickable((xml.getlocator("//locators/IPVPNSite/ClickheretoSaveAccess")));
		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/ClickheretoSaveAccess")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on save");
		waitforPagetobeenable();
		Thread.sleep(4000);

		WaitforElementtobeclickable(xml.getlocator("//locators/SelectSiteSearchAccess"));
		Moveon(getwebelement(xml.getlocator("//locators/SelectSiteSearchAccess")));
		safeJavaScriptClick(getwebelement(xml.getlocator("//locators/SelectSiteSearchAccess")));

		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search Site");
		WaitforElementtobeclickable(xml.getlocator("//locators/StreetNameAccess"));
		SendKeys(getwebelement(xml.getlocator("//locators/StreetNameAccess")), Inputdata[61].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Street Name");
		WaitforElementtobeclickable(xml.getlocator("//locators/CountryAccess"));
		SendKeys(getwebelement(xml.getlocator("//locators/CountryAccess")), Inputdata[62].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Country");
		SendKeys(getwebelement(xml.getlocator("//locators/CityTownAccess")), Inputdata[63].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter City");
		SendKeys(getwebelement(xml.getlocator("//locators/PostalCodeAccess")), Inputdata[64].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Postal Code");
		SendKeys(getwebelement(xml.getlocator("//locators/PremisesAccess")), Inputdata[65].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Premises");
		Clickon(getwebelement(xml.getlocator("//locators/SearchButtonAccess")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search");
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/SelectPickAddressAccess")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Address for Site");
		Clickon(getwebelement(xml.getlocator("//locators/PickAddressButtonAccess")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Submit Address for Site");
		Clickon(getwebelement(xml.getlocator("//locators/SelectPickBuildingAccess")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Buiding for Site");
		Clickon(getwebelement(xml.getlocator("//locators/PickBuildingButtonAccess")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Submit Buiding for Site");
		Clickon(getwebelement(xml.getlocator("//locators/SelectPickSiteAccess")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Site");
		Clickon(getwebelement(xml.getlocator("//locators/PickSiteButtonAccess")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Submit Site");
		waitforPagetobeenable();
		Thread.sleep(5000);

		WaitforElementtobeclickable(xml.getlocator("//locators/IPVPNSite/IpGurdianSave"));
		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/IpGurdianSave")));
		// Thread.sleep(8000);

		waitforPagetobeenable();

		WaitforElementtobeclickable(xml.getlocator("//locators/ServicePartySearchAccess"));
		Moveon(getwebelement(xml.getlocator("//locators/ServicePartySearchAccess")));
		safeJavaScriptClick(getwebelement(xml.getlocator("//locators/ServicePartySearchAccess")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Search Service Party");

		// System.out.println("EnterService");
		waitandForElementDisplay((xml.getlocator("//locators/ServicePartyDropdownAccess")), 8);

		WaitforElementtobeclickable(xml.getlocator("//locators/ServicePartyDropdownAccess"));
		Clickon(getwebelement(xml.getlocator("//locators/ServicePartyDropdownAccess")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Service Party Dropdown");

		Clickon(getwebelement(xml.getlocator("//locators/PartyNameAccess")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Party Name");

		SendKeys(getwebelement(xml.getlocator("//locators/InputPartyNameAccess")), Inputdata[69].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Party Name");

		Clickon(getwebelement(xml.getlocator("//locators/PartyNameSearchAccess")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click On Search");
		waitforPagetobeenable();

		Thread.sleep(2000);
		Clickon(getwebelement(xml.getlocator("//locators/PartyNameSubmitAccess")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click On Submit");

		WaitforElementtobeclickable(xml.getlocator("//locators/SiteContactSearchAccess"));
		safeJavaScriptClick(getwebelement(xml.getlocator("//locators/SiteContactSearchAccess")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Search Site Contact");

		waitandForElementDisplay((xml.getlocator("//locators/SiteContactDropdownAccess")), 8);
		WaitforElementtobeclickable(xml.getlocator("//locators/SiteContactDropdownAccess"));
		Clickon(getwebelement(xml.getlocator("//locators/SiteContactDropdownAccess")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Site Name Dropdown");

		// waitandForElementDisplay((xml.getlocator("//locators/SiteLastNameAccess")),8);
		// WaitforElementtobeclickable(xml.getlocator("//locators/SiteLastNameAccess"));
		// Thread.sleep(8000);
		// Clickon(getwebelement(xml.getlocator("//locators/SiteLastNameAccess")));
		// System.out.println("Last Name Click");
		// ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Last Name");

		WaitforElementtobeclickable(xml.getlocator("//locators/InputSiteNameAccess"));
		SendKeys(getwebelement(xml.getlocator("//locators/InputSiteNameAccess")), Inputdata[70].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Site Name");

		WaitforElementtobeclickable(xml.getlocator("//locators/LastNameSiteSearchAccess"));
		Clickon(getwebelement(xml.getlocator("//locators/LastNameSiteSearchAccess")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click On Search");
		waitforPagetobeenable();
		Thread.sleep(3000);

		WaitforElementtobeclickable(xml.getlocator("//locators/LastNameSiteSubmitAccess"));
		Clickon(getwebelement(xml.getlocator("//locators/LastNameSiteSubmitAccess")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click On Submit");

		WaitforElementtobeclickable(xml.getlocator("//locators/IPVPNSite/IpGurdianSave"));
		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/IpGurdianSave")));
		// Thread.sleep(8000);

		waitforPagetobeenable();

		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "Access Type")));
		Clickon(getwebelement(
				xml.getlocator("//locators/IPVPNSite/SelectValueDropdown").replace("Value", Inputdata[42].toString())));
		waitforPagetobeenable();

		Clickon(getwebelement(
				xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "Access Technology")));
		Clickon(getwebelement(
				xml.getlocator("//locators/IPVPNSite/SelectValueDropdown").replace("Value", "Ethernet over MSP")));
		waitforPagetobeenable();

		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "Building Type")));
		Clickon(getwebelement(
				xml.getlocator("//locators/IPVPNSite/SelectValueDropdown").replace("Value", Inputdata[45].toString())));
		waitforPagetobeenable();

		Clickon(getwebelement(
				xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "Customer Site Pop Status")));
		Clickon(getwebelement(
				xml.getlocator("//locators/IPVPNSite/SelectValueDropdown").replace("Value", Inputdata[46].toString())));
		waitforPagetobeenable();

		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "Cabinet Type")));
		Clickon(getwebelement(
				xml.getlocator("//locators/IPVPNSite/SelectValueDropdown").replace("Value", Inputdata[48].toString())));
		waitforPagetobeenable();

		Clear(getwebelement(xml.getlocator("//locators/IPVPNSite/TextInput").replace("Value", "Cabinet ID")));
		SendKeys(getwebelement(xml.getlocator("//locators/IPVPNSite/TextInput").replace("Value", "Cabinet ID")), "12");
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/IPVPNSite/TextInput").replace("Value", "Cabinet ID")),
				Keys.ENTER);
		Thread.sleep(2000);

		Clear(getwebelement(xml.getlocator("//locators/IPVPNSite/TextInput").replace("Value", "Shelf ID")));
		SendKeys(getwebelement(xml.getlocator("//locators/IPVPNSite/TextInput").replace("Value", "Shelf ID")), "12");
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/IPVPNSite/TextInput").replace("Value", "Shelf ID")),
				Keys.ENTER);
		Thread.sleep(2000);

		Clear(getwebelement(xml.getlocator("//locators/IPVPNSite/TextInput").replace("Value", "Slot ID")));
		SendKeys(getwebelement(xml.getlocator("//locators/IPVPNSite/TextInput").replace("Value", "Slot ID")), "12");
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/IPVPNSite/TextInput").replace("Value", "Slot ID")),
				Keys.ENTER);
		Thread.sleep(2000);

		Clear(getwebelement(xml.getlocator("//locators/IPVPNSite/TextInput").replace("Value", "Physical Port ID")));
		SendKeys(getwebelement(xml.getlocator("//locators/IPVPNSite/TextInput").replace("Value", "Physical Port ID")),
				"12");
		SendkeaboardKeys(
				getwebelement(xml.getlocator("//locators/IPVPNSite/TextInput").replace("Value", "Physical Port ID")),
				Keys.ENTER);
		Thread.sleep(2000);

		Clickon(getwebelement(
				xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "Presentation Interface")));
		Clickon(getwebelement(
				xml.getlocator("//locators/IPVPNSite/SelectValueDropdown").replace("Value", Inputdata[53].toString())));
		waitforPagetobeenable();

		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "Connector Type")));
		Clickon(getwebelement(
				xml.getlocator("//locators/IPVPNSite/SelectValueDropdown").replace("Value", Inputdata[54].toString())));
		waitforPagetobeenable();

		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "Fibre Type")));
		Clickon(getwebelement(
				xml.getlocator("//locators/IPVPNSite/SelectValueDropdown").replace("Value", Inputdata[55].toString())));
		waitforPagetobeenable();

		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "Diversity Type")));
		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/SelectValueDropdown").replace("Value", "Type 1")));
		waitforPagetobeenable();

		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "Install Time")));
		Clickon(getwebelement(
				xml.getlocator("//locators/IPVPNSite/SelectValueDropdown").replace("Value", Inputdata[56].toString())));
		waitforPagetobeenable();

		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "Router Model")));
		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/SelectValueDropdown").replace("Value", "NA")));
		waitforPagetobeenable();

		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "Site Name")));
		Clickon(getwebelement(
				xml.getlocator("//locators/IPVPNSite/SelectValueDropdown").replace("Value", Inputdata[60].toString())));
		waitforPagetobeenable();

		WaitforElementtobeclickable((xml.getlocator("//locators/IPVPNSite/ClickheretoSaveAccess")));
		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/ClickheretoSaveAccess")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on save");
		waitforPagetobeenable();

		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/ClickLink").replace("Value", "IP Details")));
		waitforPagetobeenable();

		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/ClickLink").replace("Value", "End Point VPN")));
		waitforPagetobeenable();

		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/IPDetailsPlus")));
		Thread.sleep(3000);

		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "VPN Bandwidth")));
		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/SelectValueDropdown").replace("Value", "1 Mbps")));
		waitforPagetobeenable();

		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/SubVPNID")));
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/SelectSubVPNList")));
		Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/SubmitSubVPNList")));
		Thread.sleep(3000);

	}

	
	

	public void serviceGroupReference() throws Exception {

		if (isElementPresent(xml.getlocator("//locators/ServiceGroupTab"))) {
			System.out.println("go to if loop of service group tab");
			WaitforElementtobeclickable(xml.getlocator("//locators/ServiceGroupTab"));
			Clickon(getwebelement(xml.getlocator("//locators/ServiceGroupTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on service tab");
		} else {
			System.out.println("service group tab present in dropdown");
			Select(getwebelement(xml.getlocator("//locators/InstalltionDropdown")), "Service Group");
			ExtentTestManager.getTest().log(LogStatus.PASS,
					" Step: Click on Installation Dropdown button and Select Installation and Test");

			waitforPagetobeenable();
			waitForpageload();
		}
		Thread.sleep(2000);
		if (isElementPresent(xml.getlocator("//locators/ServiceOrderCheck"))) {

			System.out.println("Element is present");
			Boolean t = isElementPresent(xml.getlocator("//locators/ServiceOrderCheck"));
			System.out.println(t);
			if (t == true) {
				System.out.println("Service Record already exist!");
			}
		} else {
			System.out.println("Service Record not exist!");
			waitandForElementDisplay(xml.getlocator("//locators/ClickOnPlusButtonService"), 5);
			WaitforElementtobeclickable(xml.getlocator("//locators/ClickOnPlusButtonService"));
			Clickon(getwebelement(xml.getlocator("//locators/ClickOnPlusButtonService")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on plus button");
			waitforPagetobeenable();

			waitandForElementDisplay(xml.getlocator("//locators/ServiceGroupReference"), 5);
			WaitforElementtobeclickable(xml.getlocator("//locators/ServiceGroupReference"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on service reference");
			Clickon(getwebelement(xml.getlocator("//locators/ServiceGroupReference")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on plus button");
			waitforPagetobeenable();

			WaitforElementtobeclickable(xml.getlocator("//locators/ClickOkButton"));
			Clickon(getwebelement(xml.getlocator("//locators/ClickOkButton")));
			waitforPagetobeenable();
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on ok button");
		}

	}



	/* Added by Devesh for R4 Products */
	public void ShowfullInfo() throws InterruptedException, DocumentException {
		WaitforElementtobeclickable(xml.getlocator("//locators/R4/ShowFullinfo"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/ShowFullinfo")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On : Show Full info");
		waitforPagetobeenable();
	}

	/* Added by Devesh for R4 Products */
	public void Save() throws InterruptedException, DocumentException {
		WaitforElementtobeclickable(xml.getlocator("//locators/R4/Save"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/Save")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click  on Save");
		waitforPagetobeenable();
	}

	/* Added by Devesh for R4 Products */
	public void PrivateEthernetEntry(Object[] InputData) throws InterruptedException, DocumentException {
		WaitforElementtobeclickable(
				xml.getlocator("//locators/R4/PopDropdownClick").replace("Value", "Service Bandwidth"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/PopDropdownClick").replace("Value", "Service Bandwidth")));
		Clickon(getwebelement(
				xml.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[32].toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS,
				" Step: Private Ehternet >> Service Bandwidth Select : " + InputData[32].toString());

		WaitforElementtobeclickable(
				xml.getlocator("//locators/R4/PopDropdownClick").replace("Value", "A End Resilience Option"));
		Clickon(getwebelement(
				xml.getlocator("//locators/R4/PopDropdownClick").replace("Value", "A End Resilience Option")));
		Clickon(getwebelement(
				xml.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[75].toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS,
				" Step: Private Ehternet >> A End Resilience Option Select : " + InputData[75].toString());

		WaitforElementtobeclickable(
				xml.getlocator("//locators/R4/PopDropdownClick").replace("Value", "B End Resilience Option"));
		Clickon(getwebelement(
				xml.getlocator("//locators/R4/PopDropdownClick").replace("Value", "B End Resilience Option")));
		Clickon(getwebelement(
				xml.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[76].toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS,
				" Step: Private Ehternet >> B End Resilience Option Select : " + InputData[32].toString());
	}

	/* Added by Devesh for R4 Products */
	public void DiversityCircuitEntry(Object[] InputData) throws InterruptedException, DocumentException, IOException {

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/PopInput").replace("Value", "Attachment Link"));
		Clear(getwebelement(xml.getlocator("//locators/R4/PopInput").replace("Value", "Attachment Link")));
		SendKeys(getwebelement(xml.getlocator("//locators/R4/PopInput").replace("Value", "Attachment Link")),
				InputData[33].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS,
				" Step: Diversity Circuit >> Attachment Link Entered : " + InputData[33].toString());

		WaitforElementtobeclickable(
				xml.getlocator("//locators/R4/PopInput").replace("Value", "Diverse From Service Reference"));
		Clear(getwebelement(
				xml.getlocator("//locators/R4/PopInput").replace("Value", "Diverse From Service Reference")));
		SendKeys(
				getwebelement(
						xml.getlocator("//locators/R4/PopInput").replace("Value", "Diverse From Service Reference")),
				InputData[34].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS,
				" Step: Diversity Circuit >> Diverse From Service Reference: " + InputData[34].toString());

		Clickon(getwebelement(xml.getlocator("//locators/R4/PopClose")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click  on Close");
	}

	/* Added by Devesh for R4 Products */
	public void SearchSiteA(Object[] InputData) throws InterruptedException, DocumentException {
		WaitforElementtobeclickable(xml.getlocator("//locators/R4/LeftSiteSearch"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/LeftSiteSearch")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Search Site A ");

	}

	/* Added by Devesh for R4 Products */
	public void SearchSiteB(Object[] InputData) throws InterruptedException, DocumentException {
		WaitforElementtobeclickable(xml.getlocator("//locators/R4/RightSiteSearch"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/RightSiteSearch")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Search Site B ");
	}

	/* Added by Devesh for R4 Products */
	public void AEndSite(Object[] InputData) throws InterruptedException, DocumentException, IOException {
		waitForpageload();
		waitforPagetobeenable();
		String ProductName = InputData[8].toString();
		if (ProductName.equalsIgnoreCase("DCA Ethernet")) 
		{
			//Access Type
			WaitforElementtobeclickable(
					xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "Access Type"));
			Clickon(getwebelement(
					xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "Access Type")));

			WaitforElementtobeclickable(
					xml.getlocator("//locators/DarkFiber/AList").replace("Value", "Colt Fibre"));
			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AList").replace("Value","Colt Fibre" /* InputData[93].toString()*/)));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Access Type : " + "Colt Fibre" /* InputData[93].toString()*/);
			
			//Access Tech
			WaitforElementtobeclickable(
					xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "Access Technology"));
			Clickon(getwebelement(
					xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "Access Technology")));

			WaitforElementtobeclickable(
					xml.getlocator("//locators/DarkFiber/AList").replace("Value", "NA"));
			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AList").replace("Value","NA" /* InputData[93].toString()*/)));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Access Technology : " + "NA" /* InputData[93].toString()*/);
			
			//EFM
			WaitforElementtobeclickable(
					xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "EFM Enhanced Bandwidth Availability"));
			Clickon(getwebelement(
					xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "EFM Enhanced Bandwidth Availability")));

			WaitforElementtobeclickable(
					xml.getlocator("//locators/DarkFiber/AList").replace("Value", "No"));
			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AList").replace("Value","No" /* InputData[93].toString()*/)));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select EFM Enhanced Bandwidth Availability : " + "No" /* InputData[93].toString()*/);
			
			//Demarcation Device
			WaitforElementtobeclickable(
					xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "Demarcation Device Required"));
			Clickon(getwebelement(
					xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "Demarcation Device Required")));

			WaitforElementtobeclickable(
					xml.getlocator("//locators/DarkFiber/AList").replace("Value", "No"));
			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AList").replace("Value","No" /* InputData[93].toString()*/)));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Demarcation Device Required : " + "No" /* InputData[93].toString()*/);
		}
		
		WaitforElementtobeclickable(
				xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "Building Type"));
		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "Building Type")));

		WaitforElementtobeclickable(
				xml.getlocator("//locators/DarkFiber/AList").replace("Value", InputData[93].toString()));
		Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AList").replace("Value", InputData[93].toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Building Type : " + InputData[93].toString());

		WaitforElementtobeclickable(
				xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "BCP Reference"));
		Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "BCP Reference")));
		Clear(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "BCP Reference")));
		SendKeys(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "BCP Reference")),
				InputData[47].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS,
				" Step: enter  on  BCP Reference : " + InputData[47].toString());
		waitforPagetobeenable();

		WaitforElementtobeclickable(
				xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "Customer Site Pop Status"));
		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "Customer Site Pop Status")));
		Thread.sleep(3000);
		WaitforElementtobeclickable(
				xml.getlocator("//locators/DarkFiber/AList").replace("Value", InputData[94].toString()));
		Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AList").replace("Value", InputData[94].toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS,
				" Step: Select Customer Site Pop Status Type : " + InputData[94].toString());

		WaitforElementtobeclickable(
				xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "DSL SLA Class"));
		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "DSL SLA Class")));
		WaitforElementtobeclickable(
				xml.getlocator("//locators/DarkFiber/AList").replace("Value", InputData[44].toString()));
		Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AList").replace("Value", InputData[44].toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS,
				" Step: Select DSL SLA Class Type :" + InputData[44].toString());

		WaitforElementtobeclickable(
				xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "Site Name Alias"));
		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "Site Name Alias")));
		Clear(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "Site Name Alias")));
		SendKeys(
				getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "Site Name Alias")),
				InputData[148].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS,
				" Step: enter  on Site Name Alias : " + InputData[148].toString());
	}


	/* Added by Devesh for R4 Products */
	public void BEndSite(Object[] InputData) throws InterruptedException, DocumentException, IOException {
		String ProductName = InputData[8].toString();
		if (ProductName.equalsIgnoreCase("DCA Ethernet")) 
		{
			//Access Type
	        //WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "Access Type"));
			//Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "Access Type")));

			//WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/AList").replace("Value", "Colt Fibre"));
			//Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AList").replace("Value","Colt Fibre" /* InputData[93].toString()*/)));
			//ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Access Type : " + "Colt Fibre" /* InputData[93].toString()*/);
			
			//Access Tech
			WaitforElementtobeclickable(
					xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "Access Technology"));
			Clickon(getwebelement(
					xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "Access Technology")));

			WaitforElementtobeclickable(
					xml.getlocator("//locators/DarkFiber/AList").replace("Value", "NA"));
			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AList").replace("Value","NA" /* InputData[93].toString()*/)));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Access Technology : " + "NA" /* InputData[93].toString()*/);
			
			//EFM
			WaitforElementtobeclickable(
					xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "EFM Enhanced Bandwidth Availability"));
			Clickon(getwebelement(
					xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "EFM Enhanced Bandwidth Availability")));

			WaitforElementtobeclickable(
					xml.getlocator("//locators/DarkFiber/AList").replace("Value", "No"));
			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AList").replace("Value","No" /* InputData[93].toString()*/)));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select EFM Enhanced Bandwidth Availability : " + "No" /* InputData[93].toString()*/);
			
			//Demarcation Device
			WaitforElementtobeclickable(
					xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "Demarcation Device Required"));
			Clickon(getwebelement(
					xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "Demarcation Device Required")));

			WaitforElementtobeclickable(
					xml.getlocator("//locators/DarkFiber/AList").replace("Value", "No"));
			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AList").replace("Value","No" /* InputData[93].toString()*/)));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Demarcation Device Required : " + "No" /* InputData[93].toString()*/);
		}
		
		WaitforElementtobeclickable(
				xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "Building Type"));
		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "Building Type")));
		WaitforElementtobeclickable(
				xml.getlocator("//locators/DarkFiber/BList").replace("Value", InputData[110].toString()));
		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/BList").replace("Value", InputData[110].toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Building Type : " + InputData[110].toString());

		WaitforElementtobeclickable(
				xml.getlocator("//locators/DarkFiber/BEndSiteInput").replace("Value", "BCP Reference"));
		Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/BEndSiteInput").replace("Value", "BCP Reference")));
		Clear(getwebelement(xml.getlocator("//locators/DarkFiber/BEndSiteInput").replace("Value", "BCP Reference")));
		SendKeys(getwebelement(xml.getlocator("//locators/DarkFiber/BEndSiteInput").replace("Value", "BCP Reference")),
				"NA"/* InputData[180].toString() */);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter  on  BCP Reference : NA");
		waitforPagetobeenable();

		WaitforElementtobeclickable(
				xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "Customer Site Pop Status"));
		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "Customer Site Pop Status")));
		WaitforElementtobeclickable(
				xml.getlocator("//locators/DarkFiber/BList").replace("Value", InputData[111].toString()));
		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/BList").replace("Value", InputData[111].toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS,
				" Step: Select Customer Site Pop Status Type : " + InputData[111].toString());

		WaitforElementtobeclickable(
				xml.getlocator("//locators/DarkFiber/BEndSiteInput").replace("Value", "Site Name Alias"));
		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/BEndSiteInput").replace("Value", "Site Name Alias")));
		Clear(getwebelement(xml.getlocator("//locators/DarkFiber/BEndSiteInput").replace("Value", "Site Name Alias")));
		SendKeys(
				getwebelement(xml.getlocator("//locators/DarkFiber/BEndSiteInput").replace("Value", "Site Name Alias")),
				InputData[149].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS,
				" Step: enter  on Site Name Alias : " + InputData[149].toString());

		WaitforElementtobeclickable(
				xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "DSL SLA Class"));
		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "DSL SLA Class")));

		WaitforElementtobeclickable(
				xml.getlocator("//locators/DarkFiber/BList").replace("Value", InputData[150].toString()));
		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/BList").replace("Value", InputData[150].toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS,
				" Step: Select DSL SLA Class Type :" + InputData[150].toString());
	}
	/* Added by Devesh for R4 Products */
	public void SearchSiteAEntry(Object[] InputData) throws InterruptedException, DocumentException, IOException {
		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SearchInput").replace("Value", "Street Name"));
		Clear(getwebelement(xml.getlocator("//locators/R4/SearchInput").replace("Value", "Street Name")));
		SendKeys(getwebelement(xml.getlocator("//locators/R4/SearchInput").replace("Value", "Street Name")),
				InputData[86].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Street: " + InputData[86].toString());

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SearchDropdown").replace("Value", "Country"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SearchDropdown").replace("Value", "Country")));
		Clickon(getwebelement(
				xml.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[87].toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Country: " + InputData[87].toString());

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SearchInput").replace("Value", "City / Town"));
		Clear(getwebelement(xml.getlocator("//locators/R4/SearchInput").replace("Value", "City / Town")));
		SendKeys(getwebelement(xml.getlocator("//locators/R4/SearchInput").replace("Value", "City / Town")),
				InputData[88].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter City/Town : " + InputData[88].toString());

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SearchInput").replace("Value", "Postal Code"));
		Clear(getwebelement(xml.getlocator("//locators/R4/SearchInput").replace("Value", "Postal Code")));
		SendKeys(getwebelement(xml.getlocator("//locators/R4/SearchInput").replace("Value", "Postal Code")),
				InputData[89].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Postal Code : " + InputData[89].toString());

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SearchInput").replace("Value", "Premises"));
		Clear(getwebelement(xml.getlocator("//locators/R4/SearchInput").replace("Value", "Premises")));
		SendKeys(getwebelement(xml.getlocator("//locators/R4/SearchInput").replace("Value", "Premises")),
				InputData[90].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Premises : " + InputData[90].toString());

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SearchButton"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SearchButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search");

		waitforPagetobeenable();

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SearchAddressRowSelection"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SearchAddressRowSelection")));

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/PickAddress"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/PickAddress")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Row and Pick Address");
		waitforPagetobeenable();

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SearchAddressRowSelection"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SearchAddressRowSelection")));

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/PickBuilding"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/PickBuilding")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Row and Pick Building");

		waitforPagetobeenable();
		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SearchAddressRowSelection"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SearchAddressRowSelection")));

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/PickSite"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/PickSite")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Row and Pick Site");
		waitforPagetobeenable();
	}

	/* Added by Devesh for R4 Products */
	public void SiteAServiceParty(Object[] InputData) throws Exception {
		WaitforElementtobeclickable(
				xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value", "Service Party"));
		safeJavaScriptClick(
				getwebelement(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value", "Service Party")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Search Service Party");
		waitforPagetobeenable();
		Thread.sleep(5000);
	}

	/* Added by Devesh for R4 Products */
	public void SiteBServiceParty(Object[] InputData) throws Exception {
		WaitforElementtobeclickable(
				xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value", "Service Party"));
		safeJavaScriptClick(
				getwebelement(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value", "Service Party")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Search Service Party");
		waitforPagetobeenable();
		Thread.sleep(5000);
	}

	/* Added by Devesh for R4 Products */
	public void SiteASiteContact(Object[] InputData) throws Exception {
		WaitforElementtobeclickable(
				xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value", "Site Contact"));
		safeJavaScriptClick(
				getwebelement(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value", "Site Contact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Search Site Contact");
		waitforPagetobeenable();
		Thread.sleep(5000);
	}

	/* Added by Devesh for R4 Products */
	public void SiteBSiteContact(Object[] InputData) throws Exception {
		WaitforElementtobeclickable(
				xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value", "Site Contact"));
		safeJavaScriptClick(
				getwebelement(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value", "Site Contact")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Search Site Contact");
		waitforPagetobeenable();
		Thread.sleep(5000);
	}

	/* Added by Devesh for R4 Products */
	public void PickServiceParty(Object[] InputData) throws InterruptedException, DocumentException, IOException {
		WaitforElementtobeclickable(xml.getlocator("//locators/R4/PickAccountDropdown"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/PickAccountDropdown")));
		Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AList").replace("Value", InputData[68].toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Field : " + InputData[68].toString());

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/PickAccountValue"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/PickAccountValue")));
		Clear(getwebelement(xml.getlocator("//locators/R4/PickAccountValue")));
		SendKeys(getwebelement(xml.getlocator("//locators/R4/PickAccountValue")), InputData[69].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter value : " + InputData[69].toString());

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/PickAccountGo"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/PickAccountGo")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Go");

		/*
		 * WaitforElementtobeclickable(xml.getlocator("//locators/R4/PickAccountOk"));
		 * Clickon(getwebelement(xml.getlocator("//locators/R4/PickAccountOk")));
		 * ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Ok");
		 */
		waitforPagetobeenable();
		Thread.sleep(7000);
	}

	/* Added by Devesh for R4 Products */
	public void PickSiteContactParty(Object[] InputData) throws InterruptedException, DocumentException, IOException {
		WaitforElementtobeclickable(xml.getlocator("//locators/R4/PickAccountDropdown"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/PickAccountDropdown")));
		Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AList").replace("Value", InputData[30].toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Field : " + InputData[30].toString());

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/PickAccountValue"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/PickAccountValue")));
		Clear(getwebelement(xml.getlocator("//locators/R4/PickAccountValue")));
		SendKeys(getwebelement(xml.getlocator("//locators/R4/PickAccountValue")), InputData[31].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter value :" + InputData[31].toString());

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/PickContactGo"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/PickContactGo")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Go");
		waitforPagetobeenable();
		Thread.sleep(5000);

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/PickContactOk"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/PickContactOk")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Ok");
		waitforPagetobeenable();
		Thread.sleep(5000);
	}

	/* Added by Devesh for R4 Products */
	public void ClickHereSave() throws InterruptedException, DocumentException {
		WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
		Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on SaveAccess");
		waitforPagetobeenable();
	}
	/* Added by Devesh for R4 Products */
	public void SiteBInstallationTime(Object[] InputData) throws InterruptedException, DocumentException, IOException {
		String ProductName = InputData[8].toString();
		if (ProductName.equalsIgnoreCase("Private Ethernet")||ProductName.equalsIgnoreCase("DCA Ethernet")) {
			// Entering Install Time
			WaitforElementtobeclickable(
					xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value", "Install Time"));
			Clickon(getwebelement(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value", "Install Time")));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[112].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS,
					" Step: Select Install Time : " + InputData[112].toString());
			Thread.sleep(7000);
			waitforPagetobeenable();
		}
	}

	/* Added by Devesh for R4 Products */
	public void SiteATerminationTime(Object[] InputData) throws InterruptedException, DocumentException, IOException {
		String ProductName = InputData[8].toString();
		Random rand = new Random();
		if (ProductName.equalsIgnoreCase("Private Ethernet")||ProductName.equalsIgnoreCase("DCA Ethernet")) {
			// CabinetID
			int rand_int1 = rand.nextInt(1000);
			WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteAInput").replace("Value", "Cabinet ID"));
			Clear(getwebelement(xml.getlocator("//locators/R4/SiteAInput").replace("Value", "Cabinet ID")));
			if (InputData[97].toString() == "") {
				SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteAInput").replace("Value", "Cabinet ID")),
						Integer.toString(rand_int1));
				ExtentTestManager.getTest().log(LogStatus.PASS,
						" Step: Enter Cabinet ID  : " + Integer.toString(rand_int1));
			} else {
				SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteAInput").replace("Value", "Cabinet ID")),
						InputData[97].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS,
						" Step: Enter Cabinet ID  : " + InputData[97].toString());
			}
			waitforPagetobeenable();

			// CabinetType
			WaitforElementtobeclickable(
					xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value", "Cabinet Type"));
			Clickon(getwebelement(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value", "Cabinet Type")));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[97].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Cabinet Type : " + InputData[97].toString());
			waitforPagetobeenable();

			// LinkAggregationRequired

			WaitforElementtobeclickable(
					xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value", "Link Aggregation Required"));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value", "Link Aggregation Required")));
			Clickon(getwebelement(xml.getlocator("//locators/R4/SiteABSelection").replace("Value", "No")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Link Aggregation Required : No");
			waitforPagetobeenable();

			// Shelf ID
			rand_int1 = rand.nextInt(1000);
			WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteAInput").replace("Value", "Shelf ID"));
			Clear(getwebelement(xml.getlocator("//locators/R4/SiteAInput").replace("Value", "Shelf ID")));
			if (InputData[50].toString() == "") {
				SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteAInput").replace("Value", "Shelf ID")),
						Integer.toString(rand_int1));
				ExtentTestManager.getTest().log(LogStatus.PASS,
						" Step: Enter Shelf ID  : " + Integer.toString(rand_int1));
			} else {
				SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteAInput").replace("Value", "Shelf ID")),
						InputData[50].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Shelf ID  : " + InputData[50].toString());
			}
			waitforPagetobeenable();
		}
	}

	/* Added by Devesh for R4 Products */
	public void SiteBTerminationTime(Object[] InputData) throws InterruptedException, DocumentException, IOException {
		Random rand = new Random();
		String ProductName = InputData[8].toString();
		if (ProductName.equalsIgnoreCase("Private Ethernet")||ProductName.equalsIgnoreCase("DCA Ethernet")) {
			// CabinetID
			int rand_int1 = rand.nextInt(1000);
			WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "Cabinet ID"));
			Clear(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "Cabinet ID")));
			if (InputData[114].toString() == "") {
				SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "Cabinet ID")),
						Integer.toString(rand_int1));
				ExtentTestManager.getTest().log(LogStatus.PASS,
						" Step: Enter Cabinet ID  : " + Integer.toString(rand_int1));
			} else {
				SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "Cabinet ID")),
						InputData[114].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS,
						" Step: Enter Cabinet ID  : " + InputData[114].toString());
			}
			waitforPagetobeenable();

			// CabinetType
			WaitforElementtobeclickable(
					xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value", "Cabinet Type"));
			Clickon(getwebelement(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value", "Cabinet Type")));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[113].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS,
					" Step: Select Cabinet Type : " + InputData[113].toString());
			waitforPagetobeenable();

			// LinkAggregationRequired
			WaitforElementtobeclickable(
					xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value", "Link Aggregation Required"));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value", "Link Aggregation Required")));
			Clickon(getwebelement(xml.getlocator("//locators/R4/SiteABSelection").replace("Value", "No")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Link Aggregation Required : No");
			waitforPagetobeenable();

			// Shelf ID
			WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "Shelf ID"));
			Clear(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "Shelf ID")));
			if (InputData[51].toString() == "") {
				SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "Shelf ID")),
						Integer.toString(rand_int1));
				ExtentTestManager.getTest().log(LogStatus.PASS,
						" Step: Enter Shelf ID  : " + Integer.toString(rand_int1));
			} else {
				SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "Shelf ID")),
						InputData[51].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Shelf ID  : " + InputData[51].toString());
			}
			waitforPagetobeenable();
		}
	}

	/* Added by Devesh for R4 Products */
	public void SearchSiteBEntry(Object[] InputData) throws InterruptedException, DocumentException, IOException {
		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SearchInput").replace("Value", "Street Name"));
		Clear(getwebelement(xml.getlocator("//locators/R4/SearchInput").replace("Value", "Street Name")));
		SendKeys(getwebelement(xml.getlocator("//locators/R4/SearchInput").replace("Value", "Street Name")),
				InputData[103].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Street: " + InputData[103].toString());

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SearchDropdown").replace("Value", "Country"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SearchDropdown").replace("Value", "Country")));
		Clickon(getwebelement(
				xml.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[104].toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Country: " + InputData[104].toString());

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SearchInput").replace("Value", "City / Town"));
		Clear(getwebelement(xml.getlocator("//locators/R4/SearchInput").replace("Value", "City / Town")));
		SendKeys(getwebelement(xml.getlocator("//locators/R4/SearchInput").replace("Value", "City / Town")),
				InputData[105].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter City/Town : " + InputData[105].toString());

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SearchInput").replace("Value", "Postal Code"));
		Clear(getwebelement(xml.getlocator("//locators/R4/SearchInput").replace("Value", "Postal Code")));
		SendKeys(getwebelement(xml.getlocator("//locators/R4/SearchInput").replace("Value", "Postal Code")),
				InputData[106].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Postal Code : " + InputData[106].toString());

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SearchInput").replace("Value", "Premises"));
		Clear(getwebelement(xml.getlocator("//locators/R4/SearchInput").replace("Value", "Premises")));
		SendKeys(getwebelement(xml.getlocator("//locators/R4/SearchInput").replace("Value", "Premises")), "1");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Premises : 1");

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SearchButton"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SearchButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search");

		waitforPagetobeenable();

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SearchAddressRowSelection"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SearchAddressRowSelection")));

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/PickAddress"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/PickAddress")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Row and Pick Address");
		waitforPagetobeenable();

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SearchAddressRowSelection"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SearchAddressRowSelection")));

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/PickBuilding"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/PickBuilding")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Row and Pick Building");

		waitforPagetobeenable();
		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SearchAddressRowSelection"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SearchAddressRowSelection")));

		WaitforElementtobeclickable(xml.getlocator("//locators/R4/PickSite"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/PickSite")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Row and Pick Site");
		waitforPagetobeenable();
	}

	/* Added by Devesh for R4 Products */
	public void SiteADiversityCircuitConfig(Object[] InputData)
			throws InterruptedException, DocumentException, IOException {

		String ProductName = InputData[8].toString();
		if (ProductName.equalsIgnoreCase("Private Ethernet")) {
			// Entering Customer Dedicated Access Ring
			WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value",
					"Customer Dedicated Access Ring"));
			Clickon(getwebelement(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value",
					"Customer Dedicated Access Ring")));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[151].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS,
					" Step: Select Customer Dedicated Access Ring : " + InputData[151].toString());
			waitforPagetobeenable();

			// Diversity Type
			/*WaitforElementtobeclickable(
					xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value", "Diversity Type"));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value", "Diversity Type")));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[152].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS,
					" Step: Select Diversity Type : " + InputData[152].toString());
			waitforPagetobeenable();*/

			// Entering Customer Dedicated Access Ring
			WaitforElementtobeclickable(
					xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value", "Dual Customer Power Source"));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value", "Dual Customer Power Source")));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[152].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS,
					" Step: Select Dual Customer Power Source : " + InputData[152].toString());
			waitforPagetobeenable();

		}
	}

	/* Added by Devesh for R4 Products */
	public void SiteBDiversityCircuitConfig(Object[] InputData)
			throws InterruptedException, DocumentException, IOException {

		String ProductName = InputData[8].toString();
		if (ProductName == "Private Ethernet") {
			// Entering Customer Dedicated Access Ring
			WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value",
					"Customer Dedicated Access Ring"));
			Clickon(getwebelement(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value",
					"Customer Dedicated Access Ring")));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[154].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS,
					" Step: Select Customer Dedicated Access Ring : " + InputData[154].toString());
			waitforPagetobeenable();

			// Diversity Type
			/*WaitforElementtobeclickable(
					xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value", "Diversity Type"));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value", "Diversity Type")));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[155].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS,
					" Step: Select Diversity Type : " + InputData[155].toString());
			waitforPagetobeenable();*/

			// Entering Customer Dedicated Access Ring
			WaitforElementtobeclickable(
					xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value", "Dual Customer Power Source"));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value", "Dual Customer Power Source")));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[156].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS,
					" Step: Select Dual Customer Power Source : " + InputData[156].toString());
			waitforPagetobeenable();
		}
	}

	/* Added by Devesh for R4 Products */
	public void PrivateEthernetMiddleAplet(Object[] InputData) throws InterruptedException, DocumentException {
		String ProductName = InputData[8].toString();
		if(ProductName.equalsIgnoreCase("DCA Ethernet"))
				{
			WaitforElementtobeclickable(
					xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Coverage"));
			Clickon(getwebelement(
					xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Coverage")));
			Clickon(getwebelement(
					xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "Metro")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Connection Type : Metro" );
				}
		
		WaitforElementtobeclickable(
				xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Connection Type"));
		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Connection Type")));
		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", InputData[27].toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Connection Type : " + InputData[27].toString());

		WaitforElementtobeclickable(
				xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Service Bandwidth"));
		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Service Bandwidth")));
		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", InputData[32].toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS,
				" Step: Select Service Bandwidth : " + InputData[32].toString());

		WaitforElementtobeclickable(
				xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "A End Resilience Option"));
		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "A End Resilience Option")));
		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", InputData[75].toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS,
				" Step: Select A End Resilience Option : " + InputData[75].toString());

		waitForpageload();
		Thread.sleep(7000);
		WaitforElementtobeclickable(
				xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "B End Resilience Option"));
		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "B End Resilience Option")));

		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", InputData[76].toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS,
				" Step: Select B End Resilience Option : " + InputData[76].toString());

		waitForpageload();
		WaitforElementtobeclickable(
				xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "OSS Platform Flag"));
		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "OSS Platform Flag")));
		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", InputData[38].toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS,
				" Step: Select OSS Platform Flag : " + InputData[38].toString());

		waitForpageload();
		WaitforElementtobeclickable(
				xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Bandwidth Type"));
		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Bandwidth Type")));
		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", InputData[28].toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Bandwidth Type : " + InputData[28].toString());

		WaitforElementtobeclickable(
				xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Hard Modify Flag"));
		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Hard Modify Flag")));
		Clickon(getwebelement(
				xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", InputData[29].toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS,
				" Step: Select Hard Modify Flag Type : " + InputData[29].toString());
	}

	/* Added by Devesh for R4 Products */
	public void SiteAInstallationTime(Object[] InputData) throws InterruptedException, DocumentException, IOException {
		String ProductName = InputData[8].toString();
		if (ProductName.equalsIgnoreCase("Private Ethernet")||ProductName.equalsIgnoreCase("DCA Ethernet")) {
			// Entering Install Time

			WaitforElementtobeclickable(
					xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value", "Install Time"));
			Clickon(getwebelement(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value", "Install Time")));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[95].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Install Time : " + InputData[95].toString());
			Thread.sleep(7000);
			waitforPagetobeenable();

		}
	}

	/* Added by Devesh for R4 Products */
	public void GetReference() throws InterruptedException, DocumentException {
		WaitforElementtobeclickable(xml.getlocator("//locators/R4/GetReference"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/GetReference")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click  on GetReference");
		waitforPagetobeenable();
	}

	/* Added by Devesh for R4 Products */
	public void SiteAAccessPort(Object[] InputData) throws InterruptedException, DocumentException, IOException {
		Random rand = new Random();
		String ProductName = InputData[8].toString();
		if (ProductName.equalsIgnoreCase("Private Ethernet")||ProductName.equalsIgnoreCase("DCA Ethernet")) {
			int rand_int1 = rand.nextInt(1000);
			// Presentation Interface
			WaitforElementtobeclickable(
					xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value", "Presentation Interface"));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value", "Presentation Interface")));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[99].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS,
					" Step: Select Presentation Interface: " + InputData[99].toString());
			waitforPagetobeenable();

			// Connector Type
			WaitforElementtobeclickable(
					xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value", "Connector Type"));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value", "Connector Type")));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[54].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS,
					" Step: Select Connector Type : " + InputData[54].toString());
			waitforPagetobeenable();

			// Fibre Type
			WaitforElementtobeclickable(
					xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value", "Fibre Type"));
			Clickon(getwebelement(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value", "Fibre Type")));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[55].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Fibre Type : " + InputData[55].toString());
			waitforPagetobeenable();

			// VLAN Tagging Mode
			WaitforElementtobeclickable(
					xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value", "VLAN Tagging Mode"));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value", "VLAN Tagging Mode")));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[100].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS,
					" Step: Select VLAN Tagging Mode : " + InputData[100].toString());
			waitforPagetobeenable();

			// Physical Port ID
			WaitforElementtobeclickable(
					xml.getlocator("//locators/R4/SiteAInput").replace("Value", "Physical Port ID"));
			Clear(getwebelement(xml.getlocator("//locators/R4/SiteAInput").replace("Value", "Physical Port ID")));
			if (InputData[101].toString() == "") {
				SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteAInput").replace("Value", "Physical Port ID")),
						Integer.toString(rand_int1));
				ExtentTestManager.getTest().log(LogStatus.PASS,
						" Step: Physical Port ID : " + Integer.toString(rand_int1));
			} else {
				SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteAInput").replace("Value", "Physical Port ID")),
						InputData[101].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS,
						" Step: Physical Port ID : " + InputData[101].toString());
			}
			waitforPagetobeenable();

			// Slot ID
			rand_int1 = rand.nextInt(1000);
			WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteAInput").replace("Value", "Slot ID"));
			Clear(getwebelement(xml.getlocator("//locators/R4/SiteAInput").replace("Value", "Slot ID")));
			if (InputData[66].toString() == "") {
				SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteAInput").replace("Value", "Slot ID")),
						Integer.toString(rand_int1));
				ExtentTestManager.getTest().log(LogStatus.PASS,
						" Step: Enter Slot ID : " + Integer.toString(rand_int1));
			} else {
				SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteAInput").replace("Value", "Slot ID")),
						InputData[66].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Slot ID : " + InputData[66].toString());
			}
			waitforPagetobeenable();
		}
	}

	/* Added by Devesh for R4 Products */
	public void SiteBAccessPort(Object[] InputData) throws InterruptedException, DocumentException, IOException {
		Random rand = new Random();
		String ProductName = InputData[8].toString();
		if (ProductName.equalsIgnoreCase("Private Ethernet")||ProductName.equalsIgnoreCase("DCA Ethernet")) {
			// Presentation Interface
			WaitforElementtobeclickable(
					xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value", "Presentation Interface"));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value", "Presentation Interface")));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[116].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS,
					" Step: Select Presentation Interface: " + InputData[116].toString());
			waitforPagetobeenable();

			// Connector Type
			WaitforElementtobeclickable(
					xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value", "Connector Type"));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value", "Connector Type")));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[54].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS,
					" Step: Select Connector Type : " + InputData[54].toString());
			waitforPagetobeenable();

			// Fibre Type
			WaitforElementtobeclickable(
					xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value", "Fibre Type"));
			Clickon(getwebelement(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value", "Fibre Type")));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[121].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Fibre Type :  " + InputData[121].toString());
			waitforPagetobeenable();

			// VLAN Tagging Mode
			WaitforElementtobeclickable(
					xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value", "VLAN Tagging Mode"));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value", "VLAN Tagging Mode")));
			Clickon(getwebelement(
					xml.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[100].toString())));
			ExtentTestManager.getTest().log(LogStatus.PASS,
					" Step: Select VLAN Tagging Mode : " + InputData[100].toString());
			waitforPagetobeenable();

			// Physical Port ID
			int rand_int1 = rand.nextInt(1000);
			WaitforElementtobeclickable(
					xml.getlocator("//locators/R4/SiteBInput").replace("Value", "Physical Port ID"));
			Clear(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "Physical Port ID")));
			if (InputData[101].toString() == "") {
				SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "Physical Port ID")),
						Integer.toString(rand_int1));
				ExtentTestManager.getTest().log(LogStatus.PASS,
						" Step: Physical Port ID : " + Integer.toString(rand_int1));
			} else {
				SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "Physical Port ID")),
						InputData[101].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS,
						" Step: Physical Port ID : " + InputData[101].toString());
			}
			waitforPagetobeenable();

			// Slot ID
			rand_int1 = rand.nextInt(1000);
			WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "Slot ID"));
			Clear(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "Slot ID")));
			if (InputData[66].toString() == "") {
				SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "Slot ID")),
						Integer.toString(rand_int1));
				ExtentTestManager.getTest().log(LogStatus.PASS,
						" Step: Enter Slot ID : " + Integer.toString(rand_int1));
			} else {
				SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "Slot ID")),
						InputData[66].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Slot ID : " + InputData[66].toString());
			}
			waitforPagetobeenable();
		}
	}

	/* Added by Devesh for R4 Products */
    public void SiteAVLan(Object[] InputData) throws InterruptedException, DocumentException, IOException
    {
    	String ProductName = InputData[8].toString();
    	if(ProductName.equalsIgnoreCase("DCA Ethernet"))
    	{
    	WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "Ethertype"));
		Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "Ethertype")));
		Clear(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "Ethertype")));
		SendKeys(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "Ethertype")),"NA"/*InputData[47].toString()*/);
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: enter  on  Ethertype : NA" /*+ InputData[47].toString()*/);
		
		WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "VLAN Tag ID"));
		Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "VLAN Tag ID")));
		Clear(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "VLAN Tag ID")));
		SendKeys(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "VLAN Tag ID")),"NA"/*InputData[47].toString()*/);
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: enter  on  VLAN Tag ID : NA"/* + InputData[47].toString()*/);
    	}
    }
   
    /* Added by Devesh for R4 Products */    
    public void SiteBVLan(Object[] InputData) throws InterruptedException, DocumentException, IOException
    {
    	WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/BEndSiteInput").replace("Value", "Ethertype"));
		Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/BEndSiteInput").replace("Value", "Ethertype")));
		Clear(getwebelement(xml.getlocator("//locators/DarkFiber/BEndSiteInput").replace("Value", "Ethertype")));
		SendKeys(getwebelement(xml.getlocator("//locators/DarkFiber/BEndSiteInput").replace("Value", "Ethertype")),"NA"/*InputData[47].toString()*/);
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: enter  on  Ethertype : NA" /*+ InputData[47].toString()*/);
		
		WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/BEndSiteInput").replace("Value", "VLAN Tag ID"));
		Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/BEndSiteInput").replace("Value", "VLAN Tag ID")));
		Clear(getwebelement(xml.getlocator("//locators/DarkFiber/BEndSiteInput").replace("Value", "VLAN Tag ID")));
		SendKeys(getwebelement(xml.getlocator("//locators/DarkFiber/BEndSiteInput").replace("Value", "VLAN Tag ID")),"NA"/*InputData[47].toString()*/);
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: enter  on  VLAN Tag ID : NA" /*+ InputData[47].toString()*/);
    }
   
    /* Added by Devesh for R4 Products */
    public void SiteBDedicatedCloudAccess(Object[] InputData) throws InterruptedException, DocumentException, IOException
    {
    	WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "AWS Account Number"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "AWS Account Number")));
		Clear(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "AWS Account Number")));
		SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "AWS Account Number")),InputData[47].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: enter  on  AWS Account Number : " + InputData[47].toString());
		
		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "CSP PoP (Primary)"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "CSP PoP (Primary)")));
		Clear(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "CSP PoP (Primary)")));
		SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "CSP PoP (Primary)")),InputData[47].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: enter  on  CSP PoP (Primary) : " + InputData[47].toString());
		
		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "CSP Region"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "CSP Region")));
		Clear(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "CSP Region")));
		SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "CSP Region")),InputData[47].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: enter  on  CSP Region : " + InputData[47].toString());
		
		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "Connection Alias"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "Connection Alias")));
		Clear(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "Connection Alias")));
		SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "Connection Alias")),InputData[47].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: enter  on  Connection Alias : " + InputData[47].toString());
		
		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "Service Key"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "Service Key")));
		Clear(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "Service Key")));
		SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "Service Key")),InputData[47].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: enter  on  Service Key : " + InputData[47].toString());
		
		
		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "CSP NNI Reference Primary"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "CSP NNI Reference Primary")));
		Clear(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "CSP NNI Reference Primary")));
		SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "CSP NNI Reference Primary")),InputData[47].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: enter  on  CSP NNI Reference Primary : " + InputData[47].toString());
		
		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "CSP NNI Reference Secondary"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "CSP NNI Reference Secondary")));
		Clear(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "CSP NNI Reference Secondary")));
		SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "CSP NNI Reference Secondary")),InputData[47].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: enter  on  CSP NNI Reference Secondary : " + InputData[47].toString());
		
		
		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "S VLAN Tag ID"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "S VLAN Tag ID")));
		Clear(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "S VLAN Tag ID")));
		SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value", "S VLAN Tag ID")),InputData[47].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: enter  on  S VLAN Tag ID : " + InputData[47].toString());
		
		
		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value","CSP Bandwidth"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value","CSP Bandwidth")));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SiteABSelection").replace("Value", "50 Mbps"/*InputData[154].toString()*/)));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select CSP Bandwidth : 50 Mbps " /* + InputData[154].toString()*/);
		waitforPagetobeenable();
		
		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value","NAT Range Required"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value","NAT Range Required")));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SiteABSelection").replace("Value", "N"/*InputData[154].toString()*/)));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select NAT Range Required : N " /* + InputData[154].toString()*/);
		waitforPagetobeenable();
		
		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value","Routing Domain"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value","Routing Domain")));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SiteABSelection").replace("Value", "Private"/*InputData[154].toString()*/)));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select NAT Range Required : Private " /* + InputData[154].toString()*/);
		
		waitforPagetobeenable();
		
		WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value","CSP Name"));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value","CSP Name")));
		Clickon(getwebelement(xml.getlocator("//locators/R4/SiteABSelection").replace("Value", "NA"/*InputData[154].toString()*/)));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select CSP Name : NA " /* + InputData[154].toString()*/); }
   
    /*
    * created by : Shivananda Rai
    * Date : 14/09/2019
    * purpose : in order to create car-nor order we should update install time on modify car-nor order 
    * based on product please update the code in case 
    * checked
    */
    public void installationTimeUpdate(Object[] Inputdata) throws Exception
    {
    switch(Inputdata[8].toString())
    {
    case "Ethernet Spoke":
    {
    Clickon(getwebelement(xmlHns.getlocator("//locators/CustomizeButton")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Customize Button");
    Thread.sleep(5000);
    safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/EthernetConnectionLink")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Ethernet Connection Link");

    safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/SpokeSiteLink")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Spoke Site Link");

    Clickon(getwebelement(xmlHns.getlocator("//locators/InstallationTimeLink")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Installation Time Link");

    Select(getwebelement(xmlHns.getlocator("//locators/InstallTime")),Inputdata[112].toString());
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Install Time");
    Clickon(getwebelement(xmlHns.getlocator("//locators/DoneEthernetConnection")));
    Thread.sleep(20000);
    break;
    }
    case "Ethernet Hub":
    {
    Clickon(getwebelement(xmlHns.getlocator("//locators/CustomizeButton")));
    Thread.sleep(30000);
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Customize button");
    Thread.sleep(5000);

    safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/EthernetConnectionLink")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Ethernet Connection link");
    Thread.sleep(10000);
    safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/HubSiteLink")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Aend Site link");
    Thread.sleep(10000);
    Clickon(getwebelement(xmlHns.getlocator("//locators/InstallationTimeLink")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Installation Time link");
    SendKeys(getwebelement(xmlHns.getlocator("//locators/InstallTime")),Inputdata[95].toString());
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update the Installation time");
    safeJavaScriptClick(getwebelement(xmlHns.getlocator("//locators/DoneEthernetConnection")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Ethernet Connection link");
    Thread.sleep(10000);
    break;
    }
    case "Ethernet Line":
    {
    Clickon(getwebelement(xml3.getlocator("//locators/CustomizeButton")));
    Thread.sleep(30000);
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Customize button");
    Thread.sleep(5000);
    safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/Connectionlink")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Ethernet Connection link");
    Thread.sleep(10000);
    safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/AendSiteLink")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Aend Site link");
    Thread.sleep(10000);
    Clickon(getwebelement(xml3.getlocator("//locators/InstallationTimeLink")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Installation Time link");
    SendKeys(getwebelement(xml3.getlocator("//locators/InstallTime")),Inputdata[95].toString());
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update the Installation time");
    safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/Connectionlink")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Ethernet Connection link");
    Thread.sleep(10000);
    safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/BendSiteLink")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Aend Site link");
    Thread.sleep(10000);
    Clickon(getwebelement(xml3.getlocator("//locators/InstallationTimeLink")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Installation Time link");
    SendKeys(getwebelement(xml3.getlocator("//locators/InstallTime")),Inputdata[112].toString());
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update Installation time");
    Thread.sleep(10000);
    savePage();
    Clickon(getwebelement(xml3.getlocator("//locators/DoneEthernetConnection")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Done Ethernet Connection");
    Thread.sleep(60000);
    break;
    }
    case "Wave": {
    Clickon(getwebelement(xml3.getlocator("//locators/CustomizeButton")));
    Thread.sleep(30000);
    safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/Connectionlink")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Ethernet Connection link");
    Thread.sleep(10000);
    safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/AendSiteLink")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Aend Site link");
    Thread.sleep(10000);
    Clickon(getwebelement(xml3.getlocator("//locators/InstallationTimeLink")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Installation Time link");
    SendKeys(getwebelement(xml3.getlocator("//locators/InstallTime")),Inputdata[95].toString());
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update the Installation time");
    safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/Connectionlink")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Ethernet Connection link");
    Thread.sleep(10000);
    safeJavaScriptClick(getwebelement(xml3.getlocator("//locators/BendSiteLink")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Aend Site link");
    Thread.sleep(10000);
    Clickon(getwebelement(xml3.getlocator("//locators/InstallationTimeLink")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Installation Time link");
    SendKeys(getwebelement(xml3.getlocator("//locators/InstallTime")),Inputdata[112].toString());
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update Installation time");
    Thread.sleep(10000);
    savePage();
    Clickon(getwebelement(xml3.getlocator("//locators/DoneEthernetConnection")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Done Ethernet Connection");
    Thread.sleep(60000);
    break;
    }
    default:
    {
    break;
    }
    }
  }
    //Added by Rekha
    public void Carnor(Object[] Inputdata) throws Exception
    {
    WaitforElementtobeclickable(xml.getlocator("//locators/CarReason"));
    Clickon(getwebelement(xml.getlocator("//locators/CarReason")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on cease reason field");
    SendKeys(getwebelement(xml.getlocator("//locators/CarReason")), "Access Line Change");
    SendkeaboardKeys(getwebelement(xml.getlocator("//locators/CarReason")), Keys.TAB);
    Thread.sleep(10000);
    Clickon(getwebelement(xml.getlocator("//locators/CarNorRunFlag")));
    Thread.sleep(5000);
    Clickon(getwebelement(xml.getlocator("//locators/CarNorRunFlagValue")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Entered carnorFlag Value");
    Thread.sleep(10000);
    WaitforElementtobeclickable(xml.getlocator("//locators/ExistingCapacityLeadTimePrimary"));
    SendKeys(getwebelement(xml.getlocator("//locators/ExistingCapacityLeadTimePrimary")),Inputdata[12].toString());
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Existing Capacity Lead Time Primary");
    SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ExistingCapacityLeadTimePrimary")), Keys.ENTER);
    SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ExistingCapacityLeadTimePrimary")), Keys.TAB);
    waitforPagetobeenable();
    savePage();
    Thread.sleep(10000);
    Clickon(getwebelement(xml.getlocator("//locators/CarNorButton")));
    Thread.sleep(5000);
    Thread.sleep(20000);
    SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ExistingCapacityLeadTimePrimary")), Keys.F5);
    waitforPagetobeenable();
    savePage();

    //below lines of code will work based on  product / please update the as per your product
    if(Inputdata[8].toString().equalsIgnoreCase("Wave") || Inputdata[8].toString().equalsIgnoreCase("Ethernet Line")) {
    CarNorOrderNumber.set(Getattribute(getwebelement(xml.getlocator("//locators/carnorOrderReferencevalue")), "title"));
    ExtentTestManager.getTest().log(LogStatus.PASS,
    " Step: Generated Service Order Reference No: " + CarNorOrderNumber.get());
    Log.info("Carnor order No:"+CarNorOrderNumber.get());
    }
     if(Inputdata[8].toString().equalsIgnoreCase("Ethernet VPN Access") || Inputdata[8].toString().equalsIgnoreCase("IP Guardian")||Inputdata[8].toString().equals("CPE Solutions Service")||Inputdata[8].toString().equals("Managed Dedicated Firewall")||Inputdata[8].toString().equalsIgnoreCase("IP Domain")|| Inputdata[8].toString().equalsIgnoreCase("Managed Virtual Firewall"))
     {
     CarNorOrderNumber.set(Gettext(getwebelement(xml.getlocator("//locators/Carnororder"))));
     ExtentTestManager.getTest().log(LogStatus.PASS,
       " Step: Generated Cornor Order Number: " + CarNorOrderNumber.get());
     }  
      }
    //Created by Abhay
    public void IPVPNServicePlusAccess(Object[] Inputdata) throws Exception 
    {
    WaitforElementtobeclickable(xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "Service Type"));
    Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "Service Type")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on service type dropdown");


    Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/SelectValueDropdown").replace("Value", Inputdata[11].toString())));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Select value from service type dropdown");

    WaitforElementtobeclickable((xml.getlocator("//locators/IPVPNSite/ClickheretoSaveAccess")));
    Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/ClickheretoSaveAccess")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on save"); 
    waitforPagetobeenable();

    SendKeys(getwebelement(xml.getlocator("//locators/IPVPNSite/TextInput").replace("Value","Customer Alias")), "Abhay");
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Enter value in customer alias");
    Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "IP Addressing Format")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Click on dropdown IP Addressing format");

    Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/SelectValueDropdown").replace("Value", Inputdata[28].toString())));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select value from IP Addressing format dropdown");

    WaitforElementtobeclickable((xml.getlocator("//locators/IPVPNSite/ClickheretoSaveAccess")));
    Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/ClickheretoSaveAccess")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on save"); 
    waitforPagetobeenable();
    Thread.sleep(4000);


    }
    //Created by Abhay
    public void IPVPNServicePlusAccess1(Object[] Inputdata) throws Exception 
    {

    WaitforElementtobeclickable(xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "Network Topology"));
    Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "Service Type")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Network Topology Dropdown");

    Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/SelectValueDropdown").replace("Value", Inputdata[27].toString())));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Select value from network topology");

    WaitforElementtobeclickable(xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "Contains Wholesale NNIs"));
    Clear(getwebelement(xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "Contains Wholesale NNIs")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear service type value from contains NNIs wholesale field");

    SendKeys(getwebelement(xml.getlocator("//locators/IPVPNSite/ClickDropdown").replace("Value", "Contains Wholesale NNIs")), "No");
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter value in contains NNIs wholesale");

    WaitforElementtobeclickable((xml.getlocator("//locators/IPVPNSite/ClickheretoSaveAccess")));
    Clickon(getwebelement(xml.getlocator("//locators/IPVPNSite/ClickheretoSaveAccess")));
    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on save"); 
    waitforPagetobeenable();
    Thread.sleep(4000);


    }
    //************************Sub vpn configuration**********************//
    // Created By: Abhay

    public void IPVPNServiceNetworkReference(Object[] inputData) throws Exception
    {

    System.out.println(xml.getlocator("//locators/IPVPNSite/NetworkReference"));
    Thread.sleep(5000);


    String NetworkReference=null;
    String NetworkReference2 = null;
    try 
    {
    NetworkReference =getwebelement2(xml.getlocator("//locators/IPVPNSite/NetworkReference")).getAttribute("value") ;
    System.out.println("try block using value"+NetworkReference);
    }
    catch (Exception e)
    {
    System.out.println("Catch block using value"+NetworkReference);
    e.printStackTrace();

    }
    try {
    NetworkReference2 =getwebelement2(xml.getlocator("//locators/IPVPNSite/NetworkReference")).getAttribute("innerHTML");
    System.out.println("try using inner html"+NetworkReference2); 
    }
    catch (Exception e)
    {
    e.printStackTrace();
    System.out.println("Catch using inner html"+NetworkReference2);
    }



    System.out.println(NetworkReference);
    NetworkReferenceIPVPN.set(NetworkReference);
    System.out.println("Final Value"+NetworkReferenceIPVPN.get().toString());

    }
   /*
    * Created by: Aman Gupta
    * Purpose:  Specific for middle applet of Managed Dedicated Firewall
    */
    public void middleAppletManagedDedicatedFirewall(Object[] Inputdata) throws Exception
	{
		waitForpageload();
		waitforPagetobeenable();
		System.out.println("valu of 178="+Inputdata[179].toString());
		System.out.println("valu of 178="+Inputdata[177].toString());
		WaitforElementtobeclickable(xml.getlocator("//locators/ManagedDedicatedFirewall/CPECombinationIDGeneric").replace("Value", "CPE Combination ID"));
		Clickon(getwebelement(xml.getlocator("//locators/ManagedDedicatedFirewall/CPECombinationIDGeneric").replace("Value", "CPE Combination ID")));
		System.out.println("valu of 180="+Inputdata[180].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/ManagedDedicatedFirewall/CPECombinationIDGeneric").replace("Value", "CPE Combination ID")),Inputdata[179].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click  CPE Combination ID");
		WaitforElementtobeclickable(xml.getlocator("//locators/ManagedDedicatedFirewall/HighAvailabilityRequired").replace("Value", "High Availability Required"));
		Clickon(getwebelement(xml.getlocator("//locators/ManagedDedicatedFirewall/HighAvailabilityRequired").replace("Value", "High Availability Required")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  High Avilabilty");
		WaitforElementtobeclickable(xml.getlocator("//locators/ManagedDedicatedFirewall/HighAvailabilityRequiredli"));
		Clickon(getwebelement(xml.getlocator("//locators/ManagedDedicatedFirewall/HighAvailabilityRequiredli")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  Yes");
		WaitforElementtobeclickable(xml.getlocator("//locators/ManagedDedicatedFirewall/CPECombinationIDGeneric").replace("Value", "Security Policy Attachment Link"));
		Clickon(getwebelement(xml.getlocator("//locators/ManagedDedicatedFirewall/CPECombinationIDGeneric").replace("Value", "Security Policy Attachment Link")));
		SendKeys(getwebelement(xml.getlocator("//locators/ManagedDedicatedFirewall/CPECombinationIDGeneric").replace("Value", "Security Policy Attachment Link")),Inputdata[180].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click  on  Security");
		WaitforElementtobeclickable(xml.getlocator("//locators/ManagedDedicatedFirewall/SaveButton"));
		Clickon(getwebelement(xml.getlocator("//locators/ManagedDedicatedFirewall/SaveButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  Yes");
		waitForpageload();
	}
    /*
     * By Aman
     */
    public void middleAppletPrivateWaveNode(Object[] Inputdata) throws Exception
	{
		waitForpageload();
		waitforPagetobeenable();
		WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Network Topology"));
		Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Network Topology")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  Network Topology");
		WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "Point to Point Single Node"));
		Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "Point to Point Single Node")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  Point to Point Single Node");
		WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/SaveButton"));
		Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/SaveButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  Save Button ");
	}
    
   	 /*
     * By Aman
     */
	public void middleUltraLowLatency(Object[] Inputdata) throws Exception
	{
		middleAppletDarkFibre(Inputdata);
	}
	 /*
     * By Aman
     */
	public void AEndSitePUD(Object[] InputData) throws InterruptedException, DocumentException, IOException
	   {
		   waitForpageload();
		   waitforPagetobeenable();
		   if(InputData[8].toString().contains("Ultra Low Latency") || (InputData[8].toString().contains("Private Wave Node"))  )
		   {
		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "Access Technology"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "Access Technology")));
		 
		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/AList").replace("Value", "NA"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AList").replace("Value", "NA")));
		   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Access Technology : NA ");
		   
		   
		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "Access Type"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "Access Type")));
		 
		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/AList").replace("Value", "Colt Fibre"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AList").replace("Value", "Colt Fibre")));
		   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Colt Fibre ");
		   
		   
		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "Demarcation Device Required"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "Demarcation Device Required")));
		 
		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/AList").replace("Value", "No"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AList").replace("Value", "No")));
		   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select No ");
		   
		   }

		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "Building Type"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "Building Type")));
		 
		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/AList").replace("Value", "NA"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AList").replace("Value", "NA")));
		   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Building Type : NA ");


		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "BCP Reference"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "BCP Reference")));
		   Clear(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "BCP Reference")));
		   SendKeys(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "BCP Reference")),"NA"/*InputData[180].toString()*/);
		   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter  on  BCP Reference : NA");
		   waitforPagetobeenable();
		   
		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "Customer Site Pop Status"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "Customer Site Pop Status")));
		   Thread.sleep(3000);
		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/AList").replace("Value", "NA"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AList").replace("Value", "NA")));
		   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Customer Site Pop Status Type : NA ");
		   

		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "DSL SLA Class"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteDropDown").replace("Value", "DSL SLA Class")));
		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/AList").replace("Value", "N/A"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AList").replace("Value", "N/A")));
		   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select DSL SLA Class Type : N/A ");

		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "Site Name Alias"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "Site Name Alias")));
		   Clear(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "Site Name Alias")));
		   SendKeys(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "Site Name Alias")),"NA"/*InputData[180].toString()*/);
		   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter  on Site Name Alias : NA");
		   
		   if(InputData[8].toString().contains("Private Wave Node"))  {
		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "Node Site Name"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "Node Site Name")));
		   Clear(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "Node Site Name")));
		   SendKeys(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "Node Site Name")),"NA"/*InputData[180].toString()*/);
		   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter  onNode Site Name: NA");
		   }
	   }
	   
	   public void BEndSitePUD(Object[] InputData) throws InterruptedException, DocumentException, IOException
	   {
		   if(InputData[8].toString().contains("Ultra Low Latency"))
		   {
		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "Access Technology"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "Access Technology")));
		 
		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/BList").replace("Value", "NA"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/BList").replace("Value", "NA")));
		   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Access Technology : NA ");
		   
		   
		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "Access Type"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "Access Type")));
		 
		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/BList").replace("Value", "Colt Fibre"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/BList").replace("Value", "Colt Fibre")));
		   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Colt Fibre ");
		   
		   
		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "Demarcation Device Required"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "Demarcation Device Required")));
		 
		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/BList").replace("Value", "No"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/BList").replace("Value", "No")));
		   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select No ");
		   
		   }
		   
		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "Building Type"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "Building Type")));
		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/BList").replace("Value", "NA"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/BList").replace("Value", "NA")));
		   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Building Type : NA ");


		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/BEndSiteInput").replace("Value", "BCP Reference"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/BEndSiteInput").replace("Value", "BCP Reference")));
		   Clear(getwebelement(xml.getlocator("//locators/DarkFiber/BEndSiteInput").replace("Value", "BCP Reference")));
		   SendKeys(getwebelement(xml.getlocator("//locators/DarkFiber/BEndSiteInput").replace("Value", "BCP Reference")),"NA"/*InputData[180].toString()*/);
		   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter  on  BCP Reference : NA");
		   waitforPagetobeenable();
		   
		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "Customer Site Pop Status"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "Customer Site Pop Status")));
		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/BList").replace("Value", "NA"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/BList").replace("Value", "NA")));
		   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Customer Site Pop Status Type : NA ");

		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/BEndSiteInput").replace("Value", "Site Name Alias"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/BEndSiteInput").replace("Value", "Site Name Alias")));
		   Clear(getwebelement(xml.getlocator("//locators/DarkFiber/BEndSiteInput").replace("Value", "Site Name Alias")));
		   SendKeys(getwebelement(xml.getlocator("//locators/DarkFiber/BEndSiteInput").replace("Value", "Site Name Alias")),"NA"/*InputData[180].toString()*/);
		   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter  on Site Name Alias : NA");

		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "DSL SLA Class"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/BEndSiteDropDown").replace("Value", "DSL SLA Class")));
		   
		   WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/BList").replace("Value", "N/A"));
		   Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/BList").replace("Value", "N/A")));
		   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select DSL SLA Class Type : N/A ");	 
	   }
	/*
	 * Aman created
	 */
	
	   public void SiteATerminationTimePUD(Object[] InputData) throws InterruptedException, DocumentException, IOException
	   {
		   String ProductName;
		    ProductName=InputData[8].toString();
		   //InputData[2].toString();
		   Random rand = new Random(); 


		   if((ProductName.equalsIgnoreCase("Private Ethernet")) || (ProductName.equalsIgnoreCase("Dark Fibre")) 
				   || (ProductName.equalsIgnoreCase("Ultra Low Latency")) || (ProductName.equalsIgnoreCase("Private Wave Node")) )	
			{
				//CabinetID
				int rand_int1 = rand.nextInt(1000); 
				WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteAInput").replace("Value","Cabinet ID" ));
				Clear(getwebelement(xml.getlocator("//locators/R4/SiteAInput").replace("Value","Cabinet ID" )));
				SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteAInput").replace("Value","Cabinet ID" )), Integer.toString(rand_int1));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Cabinet ID  : "+ Integer.toString(rand_int1));
				
				waitforPagetobeenable();
				
				//CabinetType
				WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value","Cabinet Type" ));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value","Cabinet Type" )));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteABSelection").replace("Value","Customer Cabinet" )));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Cabinet Type : Customer Cabinet");
				waitforPagetobeenable();
				
				//LinkAggregationRequired  
				
				if(!(InputData[8].toString().contains("Ultra Low Latency"))  && !(InputData[8].toString().contains("Dark Fibre")) &&
						
						!(InputData[8].toString().contains("Private Wave Node")))
				{
				WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value","Link Aggregation Required" ));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value","Link Aggregation Required" )));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteABSelection").replace("Value","No" )));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Link Aggregation Required : No");
				waitforPagetobeenable();
				}
				//Shelf ID
				rand_int1 = rand.nextInt(1000); 
				WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteAInput").replace("Value","Shelf ID" ));
				Clear(getwebelement(xml.getlocator("//locators/R4/SiteAInput").replace("Value","Shelf ID" )));
				SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteAInput").replace("Value","Shelf ID" )), Integer.toString(rand_int1));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Shelf ID  : "+ Integer.toString(rand_int1));
				waitforPagetobeenable();
			}
		}
/*
 * Created by Aman
 */
	   public void SiteBTerminationTimePUD(Object[] InputData) throws InterruptedException, DocumentException, IOException
	   {
		   Random rand = new Random(); 
		   String ProductName=InputData[8].toString();
		   if((ProductName.equalsIgnoreCase("Private Ethernet")) || (ProductName.equalsIgnoreCase("Dark Fibre"))  || (ProductName.equalsIgnoreCase("Ultra Low Latency")) )	
			{
				//CabinetID
				int rand_int1 = rand.nextInt(1000); 
				WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBInput").replace("Value","Cabinet ID" ));
				Clear(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value","Cabinet ID" )));
				SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value","Cabinet ID" )), Integer.toString(rand_int1));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Cabinet ID  : "+ Integer.toString(rand_int1));
				waitforPagetobeenable();
				
				//CabinetType
				WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value","Cabinet Type" ));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value","Cabinet Type" )));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteABSelection").replace("Value","Customer Cabinet" )));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Cabinet Type : Customer Cabinet");
				waitforPagetobeenable();
				
				if(!(InputData[8].toString().contains("Ultra Low Latency"))  && !(InputData[8].toString().contains("Dark Fibre")))
				{
				//LinkAggregationRequired
				WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value","Link Aggregation Required" ));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value","Link Aggregation Required" )));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteABSelection").replace("Value","No" )));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Link Aggregation Required : No");
				waitforPagetobeenable();
				}
				
				//Shelf ID
				WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBInput").replace("Value","Shelf ID" ));
				Clear(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value","Shelf ID" )));
				SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value","Shelf ID" )), Integer.toString(rand_int1));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Shelf ID  : "+ Integer.toString(rand_int1));
				waitforPagetobeenable();
			}
		}
	   
/*
 * Created by Aman
 * 
 */
	   public void SiteBInstallationTimePUD(Object[] InputData) throws InterruptedException, DocumentException, IOException
		{
			String ProductName=InputData[8].toString();
			 System.out.print(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value","Install Time" ));
			 if((ProductName.equalsIgnoreCase("Private Ethernet")) || (ProductName.equalsIgnoreCase("Dark Fibre"))  || (ProductName.equalsIgnoreCase("Ultra Low Latency")) )	
			{ System.out.print(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value","Install Time" ));
				//Entering Install Time
				WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value","Install Time" ));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value","Install Time" )));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteABSelection").replace("Value",InputData[112].toString())));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Install Time : "+InputData[112].toString());
				Thread.sleep(7000);
				waitforPagetobeenable();
			}	
		}
	 
/*
 * Created by Aman
 */

	   public void SiteAInstallationTimePUD(Object[] InputData) throws InterruptedException, DocumentException, IOException
		{
		   System.out.print(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value","Install Time" ));
			String ProductName=InputData[8].toString();
			
				if((ProductName.equalsIgnoreCase("Private Ethernet")) || (ProductName.equalsIgnoreCase("Dark Fibre"))  
						|| (ProductName.equalsIgnoreCase("Ultra Low Latency")) || (ProductName.equalsIgnoreCase("Private Wave Node"))  )	
			{
				//Entering Install Time
				 System.out.print(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value","Install Time" ));
				WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value","Install Time" ));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value","Install Time" )));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteABSelection").replace("Value",InputData[95].toString() )));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Install Time : "+InputData[95].toString());
				Thread.sleep(7000);
				waitforPagetobeenable();
				
				
			}	
		}
/*
 * Created by Aman
 */
	   public void SiteAAccessPortPUD(Object[] InputData) throws InterruptedException, DocumentException, IOException
	   {
		   Random rand = new Random(); 
		   String ProductName=InputData[8].toString();
		   if((ProductName.equalsIgnoreCase("Private Ethernet"))  || (ProductName.equalsIgnoreCase("Ultra Low Latency"))  )	
			{
				int rand_int1 = rand.nextInt(1000); 
				//Presentation Interface
				WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value","Presentation Interface" ));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value","Presentation Interface" )));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteABSelection").replace("Value",InputData[99].toString() )));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Presentation Interface: "+InputData[99].toString());
				waitforPagetobeenable();
				  if((ProductName.equalsIgnoreCase("Private Ethernet")))
						  {
				//VLAN Tagging Mode
				WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value","VLAN Tagging Mode" ));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value","VLAN Tagging Mode" )));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteABSelection").replace("Value",InputData[100].toString() )));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select VLAN Tagging Mode : "+InputData[100].toString());
				waitforPagetobeenable();
						  }
			}
		   if((ProductName.equalsIgnoreCase("Dark Fibre"))||(ProductName.equalsIgnoreCase("Private Ethernet"))  || (ProductName.equalsIgnoreCase("Ultra Low Latency")))
		   {
			   int rand_int1 = rand.nextInt(1000); 
				//Connector Type
				WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value","Connector Type" ) );
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value","Connector Type" )));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteABSelection").replace("Value",InputData[54].toString() )));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Connector Type : "+InputData[54].toString());
				waitforPagetobeenable();
				
				//Fibre Type
				WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value","Fibre Type" ));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteADropdownClick").replace("Value","Fibre Type" )));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteABSelection").replace("Value",InputData[55].toString() )));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Fibre Type : "+InputData[55].toString());
				waitforPagetobeenable();
				//Physical Port ID
				WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteAInput").replace("Value","Physical Port ID" ));
				Clear(getwebelement(xml.getlocator("//locators/R4/SiteAInput").replace("Value","Physical Port ID" )));
				if(InputData[101].toString()=="")
				{
					SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteAInput").replace("Value","Physical Port ID" )), Integer.toString(rand_int1));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Physical Port ID : "+Integer.toString(rand_int1));
				}
				else
				{
					SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteAInput").replace("Value","Physical Port ID" )), InputData[101].toString());
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Physical Port ID : "+InputData[101].toString());
				}
				waitforPagetobeenable();
				
				//Slot ID
				rand_int1 = rand.nextInt(1000); 
				WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteAInput").replace("Value","Slot ID" ));
				Clear(getwebelement(xml.getlocator("//locators/R4/SiteAInput").replace("Value","Slot ID" )));
				if(InputData[66].toString()=="")
				{
					SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteAInput").replace("Value","Slot ID" )), Integer.toString(rand_int1));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Slot ID : "+Integer.toString(rand_int1));
				}
				else
				{
					SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteAInput").replace("Value","Slot ID" )), InputData[66].toString());
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Slot ID : "+InputData[66].toString());
				}
				waitforPagetobeenable();
		   }
		   
		}
	   public void SiteBAccessPortPUD(Object[] InputData) throws InterruptedException, DocumentException, IOException
	   {
		   Random rand = new Random(); 
		   String ProductName=InputData[8].toString();
		   
		   
		   if((ProductName.equalsIgnoreCase("Private Ethernet")) || (ProductName.equalsIgnoreCase("Dark Fibre")) || (ProductName.equalsIgnoreCase("Ultra Low Latency")) )
			{
				//Connector Type
				WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value","Connector Type" ));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value","Connector Type" )));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteABSelection").replace("Value",InputData[54].toString() )));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Connector Type : "+InputData[54].toString());
				waitforPagetobeenable();
				
				//Fibre Type
				WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value","Fibre Type" ));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value","Fibre Type" )));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteABSelection").replace("Value",InputData[55].toString() )));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Fibre Type : "+InputData[55].toString());
				waitforPagetobeenable();
				
				//Physical Port ID
				int rand_int1 = rand.nextInt(1000); 
				WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBInput").replace("Value","Physical Port ID" ));
				Clear(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value","Physical Port ID" )));
				if(InputData[115].toString()=="")
				{
				SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value","Physical Port ID" )), Integer.toString(rand_int1));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Physical Port ID : "+Integer.toString(rand_int1));
				}
				else
				{
					SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value","Physical Port ID" )), InputData[101].toString());
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Physical Port ID : "+InputData[115].toString());
				}
				waitforPagetobeenable();
				
				//Slot ID
				rand_int1 = rand.nextInt(1000); 
				WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBInput").replace("Value","Slot ID" ));
				Clear(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value","Slot ID" )));
				if(InputData[67].toString()=="")
				{
					SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value","Slot ID" )), Integer.toString(rand_int1));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Slot ID : "+Integer.toString(rand_int1));
				}
				else
				{
					SendKeys(getwebelement(xml.getlocator("//locators/R4/SiteBInput").replace("Value","Slot ID" )), InputData[67].toString());
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Slot ID : "+InputData[66].toString());
				}
				waitforPagetobeenable();
			}
		   
		   
		   if((ProductName.equalsIgnoreCase("Private Ethernet")) || (ProductName.equalsIgnoreCase("Ultra Low Latency"))  )	
			{
				//Presentation Interface
				WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value","Presentation Interface" ));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value","Presentation Interface" )));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteABSelection").replace("Value",InputData[116].toString() )));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Presentation Interface: "+InputData[116].toString());
				waitforPagetobeenable();
				
			
				if((ProductName.equalsIgnoreCase("Private Ethernet")))
				{
				//VLAN Tagging Mode
				WaitforElementtobeclickable(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value","VLAN Tagging Mode" ));
				Clickon(getwebelement(xml.getlocator("//locators/R4/SiteBDropdownClick").replace("Value","VLAN Tagging Mode" )));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select VLAN Tagging Mode : "+InputData[121].toString());
				waitforPagetobeenable();
				}
				
				
			}
		}
/*
 * Created by Aman
 */
	   public void middleAppletDarkFibre(Object[] Inputdata) throws Exception
		{
			waitForpageload();
			waitforPagetobeenable();
			
			
			
			if(Inputdata[8].toString().contains("Ultra Low Latency") ||Inputdata[8].toString().contains("Private Wave Service"))
			{
			WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Service Bandwidth"));
			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Service Bandwidth")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  Service Bandwidth");
			
			WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "4 Mbps"));
			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "4 Mbps")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  4 Mbps");
			
			
			WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Bandwidth Type"));
			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Bandwidth Type")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  Bandwidth Type");
			
			WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "Layer 1"));
			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "Layer 1")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  Layer 1");
			
			}
		
			if((Inputdata[8].toString().contains("Dark Fibre")) || (Inputdata[8].toString().contains("Ultra Low Latency")) )
			{
			WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Coverage"));
			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Coverage")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  Coverage");
			
			WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "Metro"));
			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "Metro")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  Metro");
			}
			

			WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "A End Resilience Option"));
			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "A End Resilience Option")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  A End Resilience Option");
			if(!(Inputdata[8].toString().contains("Ultra Low Latency")) && !(Inputdata[8].toString().contains("Private Wave Service")) ) {
			WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "Single Pair"));
			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "Single Pair")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  Single pair");
			}
			if(Inputdata[8].toString().contains("Ultra Low Latency") || (Inputdata[8].toString().contains("Private Wave Service")))
			{
				WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "Protected"));
				Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "Protected")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  Protected");	
			}
			
			


			WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "B End Resilience Option"));
			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "B End Resilience Option")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  B End Resilience Option");
			if(!(Inputdata[8].toString().contains("Ultra Low Latency")) && !(Inputdata[8].toString().contains("Private Wave Service"))) {
			WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "Single Pair"));
			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "Single Pair")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  Single pair");
			}
			if((Inputdata[8].toString().contains("Ultra Low Latency") ||  (Inputdata[8].toString().contains("Private Wave Service")))) {
				WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "Protected"));
				Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "Protected")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Protected");
				}
			


			WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "OSS Platform Flag"));
			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "OSS Platform Flag")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on OSS Platform Flag ");
					
			
			WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "Legacy"));
			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "Legacy")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  Metro");
			

			

			WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Hard Modify Flag"));
			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Hard Modify Flag")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  Hard Modify Flag");
			
			WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "Y"));
			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "Y")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  yes");
			
			if((Inputdata[8].toString().contains("Private Wave Service")))
			{
				WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Circuit Category"));
				Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Circuit Category")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  Hard Modify Flag");
				
				WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "LANLINK"));
				Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "LANLINK")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  LANLINK");
				
				WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Service Type"));
				Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Service Type")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  Service Type");
				
				WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "100 Gbps Ethernet"));
				Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "100 Gbps Ethernet")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  100 Gbps Ethernet");
				
				WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Circuit Prefix"));
				Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Circuit Prefix")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  Circuit Prefix");
				
				WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "LE-"));
				Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/MiddleLi").replace("Value", "LE-")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  LE-");
			}
			
			
//			WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/ClicktoShowFulls"));
//			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/ClicktoShowFulls")));
//			
	//
//			WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "Attachment Link"));
//			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "Attachment Link")));
//			SendKeys(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "Attachment Link")),Inputdata[187].toString());
//			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter  on Attachment Link");
//			
	//
//			WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "Diverse From Service Reference"));
//			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "Diverse From Service Reference")));
//			SendKeys(getwebelement(xml.getlocator("//locators/DarkFiber/AEndSiteInput").replace("Value", "Diverse From Service Reference")),Inputdata[187].toString());
//			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: enter  on Site Name Alias");
	//
////			WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/MiddleDropDown").replace("Value", "Circuit Reference"));
////			Clickon(getwebelement(xml.getlocator("//locators/ManagedDedicatedFirewall/MiddleDropDown").replace("Value", "Circuit Reference")));
////			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  Coverage");
			
			WaitforElementtobeclickable(xml.getlocator("//locators/DarkFiber/SaveButton"));
			Clickon(getwebelement(xml.getlocator("//locators/DarkFiber/SaveButton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on  Save Button ");
			waitForpageload();
			waitforPagetobeenable();
			
			
		}
/*
 * Created by Aman
 */
	   
	   public void settingPrivateWaveNode(Object[] Inputdata) throws Exception
	    {
	    	waitForpageload();
	    	waitforPagetobeenable();
	    	WaitforElementtobeclickable(xml.getlocator("//locators/PrivateWaveNode/SettingsButton"));
	    	 safeJavaScriptClick(getwebelement(xml.getlocator("//locators/PrivateWaveNode/SettingsButton")));
			  // waitforPagetobeenable();
			   Thread.sleep(10000); 
			   
	    	WaitforElementtobeclickable(xml.getlocator("//locators/PrivateWaveNode/InputValuesVendor"));
	    	 Clickon(getwebelement(xml.getlocator("//locators/PrivateWaveNode/InputValuesVendor")));
	    	SendKeys(getwebelement2(xml.getlocator("//locators/PrivateWaveNode/InputValuesVendor")), "ADVA");
	    	SendkeaboardKeys(getwebelement(xml.getlocator("//locators/PrivateWaveNode/InputValuesVendor")),Keys.TAB);
	    	
	    	
	    	WaitforElementtobeclickable(xml.getlocator("//locators/PrivateWaveNode/InputvaluesTechonolgy"));
	    	 Clickon(getwebelement(xml.getlocator("//locators/PrivateWaveNode/InputvaluesTechonolgy")));
	    	 SendKeys(getwebelement2(xml.getlocator("//locators/PrivateWaveNode/InputvaluesTechonolgy")), "CWDM");
	    	 SendkeaboardKeys(getwebelement(xml.getlocator("//locators/PrivateWaveNode/InputvaluesTechonolgy")),Keys.TAB);
	
	    	
	    	 WaitforElementtobeclickable(xml.getlocator("//locators/PrivateWaveNode/OKButton"));
	    	 Clickon(getwebelement(xml.getlocator("//locators/PrivateWaveNode/OKButton")));
		}	   
	 
}