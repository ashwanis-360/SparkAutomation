package ScriptHelper;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import Driver.DriverHelper;
import Driver.XMLReader;

import Reporter.ExtentTestManager;



public class CancelHelper extends DriverHelper{
	
	
	
	WebElement el;
	XMLReader xml=new XMLReader("src\\Locators\\SiebelOrder.xml");
	
	public CancelHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}
	
	public void statusReason(Object[] InputData) throws Exception
	{
		waitForpageload();
		waitforPagetobeenable();
		Thread.sleep(4000);
	//Waitforvisibilityofelement(xml.getlocator("//locators/StatusReasonDropdown"));
	WaitforElementtobeclickable(xml.getlocator("//locators/StatusReasonDropdown"));
	Clickon(getwebelement(xml.getlocator("//locators/StatusReasonDropdown")));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on status reason dropdown");
	Thread.sleep(10000);
	Clickon(getwebelement(xml.getlocator("//locators/StatusReasonValue").replace("value","Requirements change"/*InputData[74].toString()*/)));
	Thread.sleep(4000);
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Cancel status reason");
	
	//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/StatusReasonAbandoned")), Keys.ENTER);
	// Thread.sleep(4000);
	SendkeaboardKeys(getwebelement(xml.getlocator("//locators/StatusReasonAbandoned")), Keys.ENTER);
	Thread.sleep(2000);
	SendkeaboardKeys(getwebelement(xml.getlocator("//locators/StatusReasonAbandoned")), Keys.TAB);
	

	savePage();
	}
	
	public void CancelOrder(Object[] Inputdata) throws Exception {
		waitForpageload();
		waitforPagetobeenable();
		Thread.sleep(4000);
	WaitforElementtobeclickable(xml.getlocator("//locators/OrderStatusDropdown"));
	Thread.sleep(4000);
	Clickon(getwebelement(xml.getlocator("//locators/OrderStatusDropdown")));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order Status dropdown");


	clickUsingAction(getwebelement(xml.getlocator("//locators/OrderStatusCancelled"))); //these do all move and click//
	// WaitforElementtobeclickable(xml.getlocator("//locators/AbandonYes"));
	// Clickon(getwebelement(xml.getlocator("//locators/AbandonYes")));
    Thread.sleep(5000);
	Clickon(getwebelement(xml.getlocator("//locators/OrderComplete")));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Order Complete");
	waitforPagetobeenable();
	Thread.sleep(5000);
	savePage();
	waitforPagetobeenable();
	Thread.sleep(7000);
	savePage();
	waitforPagetobeenable();
	Thread.sleep(5000);
	
	if (isElementPresent((xml.getlocator("//locators/AlertAccept")))) {
		WaitforElementtobeclickable((xml.getlocator("//locators/AlertAccept")));
		Clickon(getwebelement(xml.getlocator("//locators/AlertAccept")));
	}
	Thread.sleep(3000);
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Ordered Cancelled");
	
	
	}

	
	public void verifyOrderCancelled() throws Exception
	{
waitForpageload();
waitforPagetobeenable();
	WaitforElementtobeclickable(xml.getlocator("//locators/ServiceTab"));
	safeJavaScriptClick(getwebelement(xml.getlocator("//locators/ServiceTab")));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on service tab");
	Thread.sleep(5000);
	WaitforElementtobeclickable(xml.getlocator("//locators/ServiceOrderSearch"));
	Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderSearch")));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on service order search field");

	SendKeys(getwebelement(xml.getlocator("//locators/ServiceOrderSearch")), ServiceOrder.get());
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter value in servie field");
	WaitforElementtobeclickable(xml.getlocator("//locators/ServiceOrderArrow"));
	Thread.sleep(8000);
	Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderArrow")));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on service order arrow");
	Thread.sleep(8000);
	String expected = Gettext(getwebelement(xml.getlocator("//locators/VerifyCancelled")));
	System.out.println(expected);
	String actual="Cancelled";
	    Assert.assertEquals(expected, actual);  
	    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order Cancel is Complete");

	}

}
