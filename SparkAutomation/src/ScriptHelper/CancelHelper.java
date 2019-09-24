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
	Thread.sleep(4000);
	//Waitforvisibilityofelement(xml.getlocator("//locators/StatusReasonDropdown"));
	WaitforElementtobeclickable(xml.getlocator("//locators/StatusReasonDropdown"));
	Clickon(getwebelement(xml.getlocator("//locators/StatusReasonDropdown")));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on status reason dropdown");

	Clickon(getwebelement(xml.getlocator("//locators/StatusReasonValue").replace("value",InputData[90].toString())));
	System.out.println(InputData[90].toString());
	//SendKeys(getwebelement(xml.getlocator("//locators/StatusReasonAbandoned")), InputData[75].toString());
	System.out.println("status reason");
	//ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on abandoned status popup");
	Thread.sleep(4000);
	//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/StatusReasonAbandoned")), Keys.ENTER);
	// Thread.sleep(4000);
	SendkeaboardKeys(getwebelement(xml.getlocator("//locators/StatusReasonAbandoned")), Keys.ENTER);
	SendkeaboardKeys(getwebelement(xml.getlocator("//locators/StatusReasonAbandoned")), Keys.TAB);
	System.out.println("enter tab");

	savePage();
	}
	
	public void AbandonedOrder(Object[] Inputdata) throws Exception {

	WaitforElementtobeclickable(xml.getlocator("//locators/OrderStatusDropdown"));
	Clickon(getwebelement(xml.getlocator("//locators/OrderStatusDropdown")));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clcik on Order Status dropdown");


	clickUsingAction(getwebelement(xml.getlocator("//locators/OrderStatusAbandoned"))); //these do all move and click//
	waitforPagetobeenable();
	System.out.println("1st page enable of order status abandon");
	waitForpageload();
	System.out.println("page load successfully of abandon");
	// WaitforElementtobeclickable(xml.getlocator("//locators/AbandonYes"));
	// Clickon(getwebelement(xml.getlocator("//locators/AbandonYes")));

	savePage();
	waitForpageload();
	waitandForElementDisplay(xml.getlocator("//locators/ServiceTab"), 5);

	}

	
	public void verifyOrderAbandoned() throws Exception
	{

	WaitforElementtobeclickable(xml.getlocator("//locators/ServiceTab"));
	safeJavaScriptClick(getwebelement(xml.getlocator("//locators/ServiceTab")));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on service tab");
	Thread.sleep(3000);
	WaitforElementtobeclickable(xml.getlocator("//locators/ServiceOrderSearch"));
	Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderSearch")));//yha click o tha
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on service order search field");

	SendKeys(getwebelement(xml.getlocator("//locators/ServiceOrderSearch")), ServiceOrder.get());
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter value in servie field");
	WaitforElementtobeclickable(xml.getlocator("//locators/ServiceOrderArrow"));
	Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderArrow")));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on service order arrow");

	String expected = Gettext(getwebelement(xml.getlocator("//locators/VerifyAbandoned")));
	System.out.println(expected);
	String actual="Abandoned";
	    Assert.assertEquals(expected, actual);
	   // Reporter.log("Test has been passed", true);

	}




}
