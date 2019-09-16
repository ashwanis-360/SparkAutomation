package ScriptHelper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Driver.DriverHelper;
import Driver.XMLReader;
import Reporter.ExtentTestManager;

public class OMPScriptHelper extends DriverHelper
{
	public OMPScriptHelper(WebDriver dr) 
	{
		super(dr);

	}

	WebElement el;
	XMLReader xml = new XMLReader("src\\Locators\\OMPLocators.xml");

	public void verficationOfProduct (Object[] Inputdata) throws Exception {
	  Thread.sleep(4000);
	  Clickon(getwebelement(xml.getlocator("//locators/InputOrderNumber")));
	  
		//SendKeys(getwebelement(xml.getlocator("//locators/InputOrderNumber")), Inputdata[0].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/InputOrderNumber")), ServiceOrder.get().toString());//Inputdata[0].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Order Number");
		Clickon(getwebelement(xml.getlocator("//locators/SearchServiceButton")));
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on service search");
		//Reference Click
		Clickon(getwebelement(xml.getlocator("//locators/ClickOrderReferance")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on service Referance");
		Thread.sleep(10000);
		
		Switchtotab();
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/CloseVideoPopup")));
		
		//Expand All Click
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/ExpandAllButton")));
		
		
		//Order No Verification
		String OmpText=Gettext(getwebelement(xml.getlocator("//locators/OrderNumberBold")));
		//Assert.assertTrue(OmpOrderNo.equals(Inputdata[0].toString()),"Search Order No : "+ Inputdata[0].toString() + "not matched with Opened Order No :"+OmpOrderNo);
		Assert.assertTrue(OmpText.equals("871563292/190830-0102"),"Search Order No : 871563292/190830-0102 not matched with Opened Order No :"+OmpText);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order No 871563292/190830-0102 Verified in OMP Portal");
		
		
		//Product Name Verification
		OmpText=Gettext(getwebelement(xml.getlocator("//locators/ProductName")));
		//Assert.assertTrue(ProductName.equals(Inputdata[1].toString()),"Product Name : "+ Inputdata[1].toString() + "not matched with Opened Product Name :"+ProductName);
		Assert.assertTrue(OmpText.contains("Number Hosting"),"Product Name : Number Hosting not matched with Opened Product Name :"+OmpText);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Product Name("+OmpText+") Verified in OMP Portal");

		//Order Status Verification
		OmpText=Gettext(getwebelement(xml.getlocator("//locators/OrderStatus")));
		//Assert.assertTrue(OrderState.equals(Inputdata[2].toString()),"Order State : "+ Inputdata[2].toString() + "not matched with Opened Order State :"+OrderState);
		Assert.assertTrue(OmpText.contains("Completed"),"Order Status : Complete not matched with Opened Order State :"+OmpText);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order Status("+OmpText+") Verified in OMP Portal");	

		//Order State Verification
		OmpText=Gettext(getwebelement(xml.getlocator("//locators/OrderType")));
		//Assert.assertTrue(OrderState.equals(Inputdata[2].toString()),"Order State : "+ Inputdata[2].toString() + "not matched with Opened Order State :"+OrderState);
		Assert.assertTrue(OmpText.contains("New"),"Order Type New  not matched with Opened Order State :"+OmpText);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order Type("+OmpText+") Verified in OMP Portal");		
		
		/**************/
		//Order BCN Verification
		OmpText=Gettext(getwebelement(xml.getlocator("//locators/BCNNumber")));
		//Assert.assertTrue(OrderState.equals(Inputdata[2].toString()),"Order State : "+ Inputdata[2].toString() + "not matched with Opened Order State :"+OrderState);
		Assert.assertTrue(OmpText.equals("151808"),"Order BCN Number  not matched with Opened Order State :"+OmpText);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order BCN Number("+OmpText+") Verified in OMP Portal");	

		//Order OCN Verification
		OmpText=Gettext(getwebelement(xml.getlocator("//locators/OCNNumber")));
		//Assert.assertTrue(OrderState.equals(Inputdata[2].toString()),"Order State : "+ Inputdata[2].toString() + "not matched with Opened Order State :"+OrderState);
		Assert.assertTrue(OmpText.equals("4159381"),"Order OCN Number not matched with Opened Order State :"+OmpText);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order OCN Number("+OmpText+") Verified in OMP Portal");		
	}	
}
