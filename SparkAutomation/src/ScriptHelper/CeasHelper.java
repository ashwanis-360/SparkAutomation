
package ScriptHelper;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import Driver.DriverHelper;
import Driver.XMLReader;

import org.dom4j.DocumentException;

import Reporter.ExtentTestManager;



public class CeasHelper extends DriverHelper{
	
	
	
	WebElement el;
	XMLReader xml=new XMLReader("src\\Locators\\SiebelOrder.xml");
	
	public CeasHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}
	public void Cease(Object[] InputData) throws Exception
	{
	Thread.sleep(15000);
	Pagerefresh();
	try {
	WaitforElementtobeclickable(xml.getlocator("//locators/ServiceTab"));
	Clickon(getwebelement(xml.getlocator("//locators/ServiceTab")));
	System.out.println("Service tab clickon");
	} catch (Exception e) {
	try {
	safeJavaScriptClick(getwebelement(xml.getlocator("//locators/ServiceTab")));
	System.out.println("Service tab javascript");
	} catch (Exception e1) {

	e1.printStackTrace();
	}
	}
	waitforPagetobeenable();
	waitForpageload();
	Thread.sleep(4000);
	//ServiceOrder.set(InputData[187].toString());
	Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderSearchForAll")));	//as per Ayush
	System.out.println("click service order search field");
	if(InputData[8].toString().equalsIgnoreCase("IP VPN Service"))
	{
		SendKeys(getwebelement(xml.getlocator("//locators/ServiceOrderSearchForAll")),ServiceOrder2.get().toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Search Service Order No :"+ServiceOrder2.get().toString());
	}
	else
	{
	SendKeys(getwebelement(xml.getlocator("//locators/ServiceOrderSearchForAll")),ServiceOrder.get().toString());
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Search Service Order No :"+ServiceOrder.get().toString());
	}
	System.out.println("enter data order search field");
	WaitforElementtobeclickable(xml.getlocator("//locators/ServiceOrderArrow"));
	Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderArrow")));
	//Need some modification 
	boolean billing=false;
	for (int i=0;i<5;i++) {
		Thread.sleep(3*10000);
		WaitforElementtobeclickable(xml.getlocator("//locators/ServiceOrderArrow"));
		Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderArrow")));
		if(isElementPresent(xml.getlocator("//locators/BillingComplete")))
		{
			billing=true;
			break;
		}
		if(isElementPresent(xml.getlocator("//locators/BillingError")))
		{
			billing=false;
			break;
		}
	}
	if(!billing)
	{
		//Internal cease functionality 
		WaitforElementtobeclickable(xml.getlocator("//locators/ServiceOrderReferenceNo"));
		Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderReferenceNo")));
		waitForpageload(); // added by Ayush
		waitforPagetobeenable();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Service Order Reference No");
		Thread.sleep(5000);
		
		//internal cease click
		WaitforElementtobeclickable(xml.getlocator("//locators/CeaseInternal"));
		Clickon(getwebelement(xml.getlocator("//locators/CeaseInternal")));
		waitForpageload(); // added by Ayush
		waitforPagetobeenable();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Service Order Reference No");
		Thread.sleep(5000);
	}
	else
	{
		safeJavaScriptClick(getwebelement(xml.getlocator("//locators/CeaseOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on cease order number");
	}
	/*Assert.assertTrue(billing, "Billing for Service Order No :"+ServiceOrder.get().toString()+"Not completed");
	Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderArrow")));
	System.out.println("service order click");*/
    
	waitForpageload();
	waitforPagetobeenable();
	SiebelCeaseOrdernumber.set(Gettext(getwebelement(xml.getlocator("//locators/ServiceOrderModifyNumber']"))));
	ExtentTestManager.getTest().log(LogStatus.PASS,
	" Step: Generated Service Order Reference No: " + SiebelCeaseOrdernumber.get());
	SendKeys(getwebelement(xml.getlocator("//locators/RequestReceivedDate")), CurrentDate());
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Request Received Date");

	Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderReferenceNo")));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Service Order Reference No");

	waitforPagetobeenable();
	waitForpageload();
	Thread.sleep(7000);
	WaitforElementtobeclickable(xml.getlocator("//locators/OrderSubTypeSearch"));
	Clickon(getwebelement(xml.getlocator("//locators/OrderSubTypeSearch")));
	System.out.println("Enter New Order");
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order Sub Type Search");

	WaitforElementtobeclickable(xml.getlocator("//locators/AddOrderSubType"));
	Clickon(getwebelement(xml.getlocator("//locators/AddOrderSubType")));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Order Sub Type");

	SendKeys(getwebelement(xml.getlocator("//locators/InputOrderSubType")),"All");
	SendkeaboardKeys(getwebelement(xml.getlocator("//locators/InputOrderSubType")), Keys.ENTER);
	SendkeaboardKeys(getwebelement(xml.getlocator("//locators/InputOrderSubType")), Keys.TAB);
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order Sub Type DropDown");
	
	Thread.sleep(10000);
	alertPopUp();
	
	WaitforElementtobeclickable(xml.getlocator("//locators/SubmitSubOrderType"));
	Clickon(getwebelement(xml.getlocator("//locators/SubmitSubOrderType")));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Submit Sub Order Type");
	waitforPagetobeenable();

	WaitforElementtobeclickable(xml.getlocator("//locators/CeaseReason"));
	Clickon(getwebelement(xml.getlocator("//locators/CeaseReason")));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on cease reason field");
	SendKeys(getwebelement(xml.getlocator("//locators/CeaseReason")), "Cease Initiated by Colt");
	SendkeaboardKeys(getwebelement(xml.getlocator("//locators/CeaseReason")), Keys.TAB);

	if(isElementPresent(xml.getlocator("//locators/SaveOrderChanges")))
	{
	WaitforElementtobeclickable(xml.getlocator("//locators/SaveOrderChanges"));
	Clickon(getwebelement(xml.getlocator("//locators/SaveOrderChanges")));
	waitForpageload();
	System.out.println("page load succesfuuly now come to middle applet");
	waitforPagetobeenable();
	}
	System.out.println("Enter Domain Footer");
	Moveon(getwebelement(xml.getlocator("//locators/OrderDates")));
	System.out.println("Moved Mouse");
	Clickon(getwebelement(xml.getlocator("//locators/OrderDates")));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order Dates");

	SendKeys(getwebelement(xml.getlocator("//locators/OrderSignedDate")),CurrentDate());
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Order Signed Date");

	SendKeys(getwebelement(xml.getlocator("//locators/OrderReceivedDate")), CurrentDate());
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Order Received Date");


	SendKeys(getwebelement(xml.getlocator("//locators/CustomerRequestedDate")), CurrentDate());
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Order Received Date");

	WaitforElementtobeclickable(xml.getlocator("//locators/Billing"));
	Clickon(getwebelement(xml.getlocator("//locators/Billing")));
	System.out.println("BILLING TAB");
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Billing");
	Thread.sleep(10000);
	waitForpageload();
	waitForpageload();
	System.out.println("Current Date : "+CurrentDate());
	String fDate=FutureDate(15);
	System.out.println("Future Date : "+fDate);
	SendKeys(getwebelement(xml.getlocator("//locators/BillingEndDate")), fDate);
	Thread.sleep(10000);
	//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/BillingEndDate")), Keys.TAB);
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Billing End Date : "+ fDate); 
	//ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Contract Term"); 
	SendkeaboardKeys(getwebelement(xml.getlocator("//locators/BillingEndDate")), Keys.TAB);
	Clickon(getwebelement(xml.getlocator("//locators/POStartDateAccess")));
	try {
	if(isElementPresent(xml.getlocator("//locators/SaveOrderChanges")))
	{
	WaitforElementtobeclickable(xml.getlocator("//locators/SaveOrderChanges"));
	Clickon(getwebelement(xml.getlocator("//locators/SaveOrderChanges")));
	waitForpageload();
	System.out.println("page load succesfuuly now come to middle applet");
	waitforPagetobeenable();
	Thread.sleep(5000);
	}
	}
	catch(Exception e)
	{
	savePage();
	waitforPagetobeenable();
	waitForpageload();
		System.out.println("save button comes");
	}

	}
	public void alertPopUp() throws DocumentException, InterruptedException
	{
		if (isDisplayed((xml.getlocator("//locators/AlertAccept")))) {
			WaitforElementtobeclickable((xml.getlocator("//locators/AlertAccept")));
			Clickon(getwebelement(xml.getlocator("//locators/AlertAccept")));
		}
	}
	public void CeaseCompletedValidation(Object[] Inputdata) throws Exception {
		waitforPagetobeenable();
		savePage();
		waitforPagetobeenable();
		Thread.sleep(10000);
	
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
		waitforPagetobeenable();
		Thread.sleep(10000);
		savePage();
		waitforPagetobeenable();
		Thread.sleep(10000);
		if (isDisplayed(xml.getlocator("//locators/AlertAccept"))) {
			System.out.println("");
			System.out.println("Alert Present");
			WaitforElementtobeclickable((xml.getlocator("//locators/AlertAccept")));
			Clickon(getwebelement(xml.getlocator("//locators/AlertAccept")));
		}
		Thread.sleep(5000);
		try
		{
		if (isElementPresent(xml.getlocator("//locators/SubnetworkPopUP"))) {
			System.out.println("");
			System.out.println("Alert Present");
			WaitforElementtobeclickable((xml.getlocator("//locators/SubnetworkPopUP")));
			Clickon(getwebelement(xml.getlocator("//locators/SubnetworkPopUP")));
		}
		}
		catch(Exception e)
		{
				System.out.println(e.toString());
		}
		System.out.println("Order complete");
		Thread.sleep(5000);
		// Added by Abhay
		String CompValidation= null;
		CompValidation = getwebelement2(xml.getlocator("//locators/IPVPNSite/OrderStatusInput"))
				.getAttribute("value");
		System.out.println(CompValidation);
		
		Assert.assertTrue(CompValidation.contains("Comp")," Order status failed to Complete. It is displayed as : " + CompValidation);
		ExtentTestManager.getTest().log(LogStatus.PASS,
				" Step: Order Staus Verified in as Completed");


	}

	public void CeaseCommercialValidation(Object[] Inputdata) throws Exception {

		getwebelement(xml.getlocator("//locators/OrderStatus")).clear();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Order Status");
		SendKeys(getwebelement(xml.getlocator("//locators/OrderStatus")), "Commercial Validation");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Entered Order Status Commercial Validation");
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/OrderStatus")), Keys.ENTER);
		 Thread.sleep(5000);
		if(!Inputdata[8].toString().equalsIgnoreCase("Ethernet Hub" ))
		   SendkeaboardKeys(getwebelement(xml.getlocator("//locators/OrderStatus")), Keys.TAB);
		
		Thread.sleep(2000);
		if(Inputdata[8].toString().equalsIgnoreCase("Ethernet Hub" ))
		{
			try 
				{
				if(isElementPresent(xml.getlocator("//locators/PopupYes")))
					{
						WaitforElementtobeclickable(xml.getlocator("//locators/PopupYes"));
						safeJavaScriptClick(getwebelement(xml.getlocator("//locators/PopupYes")));
						waitForpageload();
						System.out.println("Pop Up Yes Clicked");
						waitforPagetobeenable();
						Thread.sleep(5000);
					}
				}
			catch(Exception e)
			{
				System.out.println("Pop Up Yes Clicked");
			}
		}
		waitforPagetobeenable();
		try
		{
		if (isElementPresent(xml.getlocator("//locators/SubnetworkPopUP"))) {
			System.out.println("");
			System.out.println("Alert Present");
			WaitforElementtobeclickable((xml.getlocator("//locators/SubnetworkPopUP")));
			Clickon(getwebelement(xml.getlocator("//locators/SubnetworkPopUP")));
			
		}
		}
		catch(Exception e)
		{
				System.out.println(e.toString());
		}
		waitforPagetobeenable();
		Thread.sleep(10000);
	}

	public void DeliveryValidation(Object[] Inputdata) throws Exception {
		waitforPagetobeenable(); // as per Aman
		Thread.sleep(5000);
		WaitforElementtobeclickable(xml.getlocator("//locators/OrderStatusDropdown"));
		Clickon(getwebelement(xml.getlocator("//locators/OrderStatusDropdown")));
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/SelectDeliveryValidation")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Entered Order Status Delivery");	
		if(!Inputdata[8].toString().equalsIgnoreCase("Ethernet Hub" ))
		{
			waitforPagetobeenable();
			Thread.sleep(5000);
		}
		if (Inputdata[11].toString().equalsIgnoreCase("IP VPN Wholesale")) // Added by Abhay
		{
			ClickContinue();
			waitforPagetobeenable();
			Thread.sleep(3000);
		}
		Thread.sleep(5000);
		if(Inputdata[8].toString().equalsIgnoreCase("Ethernet Hub" ))
			{
			try 
			{
				if(isElementPresent(xml.getlocator("//locators/PopupYes")))
				{
					WaitforElementtobeclickable(xml.getlocator("//locators/PopupYes"));
					safeJavaScriptClick(getwebelement(xml.getlocator("//locators/PopupYes")));
					waitForpageload();
					System.out.println("Pop Up Yes Clicked");
					waitforPagetobeenable();
					Thread.sleep(5000);
				}
			}
			catch(Exception e)
				{
					System.out.println("Pop Up Yes Clicked");
				}
			}
//			SendKeys(getwebelement(xml.getlocator("//locators/primarytestingmethod")), "Not Required");
//			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter value in primary test method");
//			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/primarytestingmethod")), Keys.TAB);
//			Thread.sleep(3000);
//			savePage();
		try
		{
		if (isElementPresent(xml.getlocator("//locators/SubnetworkPopUP"))) 
			{
			System.out.println("");
			System.out.println("Alert Present");
			WaitforElementtobeclickable((xml.getlocator("//locators/SubnetworkPopUP")));
			Clickon(getwebelement(xml.getlocator("//locators/SubnetworkPopUP")));
			
			}
		}
		catch(Exception e)
		{
				System.out.println(e.toString());
		}
		waitforPagetobeenable();
	}
	
	public void ClickContinue() throws DocumentException, InterruptedException {
		if (isElementPresent((xml.getlocator("//locators/IPVPNSite/BlankPriceContinue")))) {
			WaitforElementtobeclickable((xml.getlocator("//locators/IPVPNSite/BlankPriceContinue")));
			Clickon(getwebelement(xml.getlocator("//locators//IPVPNSite/BlankPriceContinue")));
		}
		Thread.sleep(3000);
	}
}
