package ScriptHelper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Driver.DriverHelper;
import Driver.XMLReader;
import Reporter.ExtentTestManager;

public class OMPScriptHelper extends DriverHelper {
	public OMPScriptHelper(WebDriver dr) {
		super(dr);

	}

	WebElement el;
	XMLReader xml = new XMLReader("src\\Locators\\OMPLocators.xml");

	public void verficationOfProduct(Object[] Inputdata) throws Exception {
	
		
		Thread.sleep(10000);
		
		
//		for(int i=0;i<5;i++)
//		{
//			Clickon(getwebelement(xml.getlocator("//locators/InputOrderNumber")));
//			Clear(getwebelement(xml.getlocator("//locators/InputOrderNumber")));// Inputdata[0].toString());
//			SendKeys(getwebelement(xml.getlocator("//locators/InputOrderNumber")), ServiceOrder.get().toString());// Inputdata[0].toString());
//			Clickon(getwebelement(xml.getlocator("//locators/SearchServiceButton")));
//			Thread.sleep(1000*60*2);
//				
//		}
		
		for(int i=0;i<5;i++)
		{
			
			Clickon(getwebelement(xml.getlocator("//locators/InputOrderNumber")));
			Clear(getwebelement(xml.getlocator("//locators/InputOrderNumber")));// Inputdata[0].toString());
			SendKeys(getwebelement(xml.getlocator("//locators/InputOrderNumber")), ServiceOrder.get().toString());// Inputdata[0].toString());
			
			Clickon(getwebelement(xml.getlocator("//locators/SearchServiceButton")));
			Thread.sleep(5000);
			if(isDisplayed(xml.getlocator("//locators/ClickOrderReferance")))//&& isDisplayed("//td[text()='Completed']"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Order Number");
				break;
				
			}
			else
				Thread.sleep(1000*60*2);
			Thread.sleep(1000*30);
			
		}
		

//SendKeys(getwebelement(xml.getlocator("//locators/InputOrderNumber")), Inputdata[0].toString());
		/*SendKeys(getwebelement(xml.getlocator("//locators/InputOrderNumber")), ServiceOrder.get().toString());// Inputdata[0].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Order Number");
		Clickon(getwebelement(xml.getlocator("//locators/SearchServiceButton")));
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on service search");*/
//Reference Click
		Clickon(getwebelement(xml.getlocator("//locators/ClickOrderReferance")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on service Referance");
		Thread.sleep(10000);

		Switchtotab();
		Thread.sleep(10000);
//Clickon(getwebelement(xml.getlocator("//locators/CloseVideoPopup")));

//Expand All Click
		//Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/ExpandAllButton")));

//Order No Verification
		String OmpText = Gettext(getwebelement(xml.getlocator("//locators/OrderNumberBold")));
		Assert.assertTrue(OmpText.equals(ServiceOrder.get().toString()),
				"Search Order No : " + ServiceOrder.get().toString() + "not matched with Opened Order No :" + OmpText);
//Assert.assertTrue(OmpText.equals("871563292/190830-0102"),"Search Order No : 871563292/190830-0102 not matched with Opened Order No :"+OmpText);
		ExtentTestManager.getTest().log(LogStatus.PASS,
				" Step: Order No " + ServiceOrder.get().toString() + "Verified in OMP Portal");

//Product Name Verification
		OmpText = Gettext(getwebelement(xml.getlocator("//locators/ProductName")));
		if (!Inputdata[8].toString().equalsIgnoreCase("IP VPN Service")) {
			String ProdName = Inputdata[8].toString();
			String[] parts = ProdName.split(" ");
			//String part1 = parts[0];
			//String part2 = parts[1];
			//System.out.println(part1);
			System.out.println(parts.length);
		
			
			for (int i = 0; i < parts.length; i++) {
				Assert.assertTrue(OmpText.contains(parts[i]),
						"Product Name : " + parts[i] + " not matched with Opened Product Name :" + OmpText);
				ExtentTestManager.getTest().log(LogStatus.PASS,
						" Step: Product Name(" + parts[i] + ") Verified in OMP Portal");
			
			}
		} else {
			String ProdName = Inputdata[8].toString();
			String[] parts = ProdName.split(" ");
			
			
			for (int i = 0; i < parts.length; i++) {
				Assert.assertTrue(OmpText.contains(parts[i]),
						"Product Name : " + parts[i] + " not matched with Opened Product Name :" + OmpText);
				ExtentTestManager.getTest().log(LogStatus.PASS,
						" Step: Product Name(" + parts[i] + ") Verified in OMP Portal");
			}
		}
//Assert.assertTrue(ProductName.equals(Inputdata[1].toString()),"Product Name : "+ Inputdata[1].toString() + "not matched with Opened Product Name :"+ProductName);
// Assert.assertTrue(OmpText.contains("Number Hosting"),"Product Name : Number Hosting not matched with Opened Product Name :"+OmpText);
// ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Product Name("+OmpText+") Verified in OMP Portal");

//Order Status Verification
		//OmpText = Gettext(getwebelement(xml.getlocator("//locators/OrderStatus")));
//Assert.assertTrue(OrderState.equals(Inputdata[2].toString()),"Order State : "+ Inputdata[2].toString() + "not matched with Opened Order State :"+OrderState);
		//Assert.assertTrue(OmpText.contains("Completed"),
				//"Order Status : Complete not matched with Opened Order State :" + OmpText);
		//ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order Status(" + OmpText + ") Verified in OMP Portal");

//Order State Verification
		OmpText = Gettext(getwebelement(xml.getlocator("//locators/OrderType")));

		Assert.assertTrue(OmpText.equals(Inputdata[9].toString()),
				"Order State : " + Inputdata[9].toString() + "not matched with Opened Order State :" + OmpText);
//Assert.assertTrue(OmpText.contains("New"),"Order Type New  not matched with Opened Order State :"+OmpText);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order Type(" + OmpText + ") Verified in OMP Portal");

		/**************/
//Order BCN Verification
// OmpText=Gettext(getwebelement(xml.getlocator("//locators/BCNNumber")));
// //Assert.assertTrue(OrderState.equals(Inputdata[2].toString()),"Order State : "+ Inputdata[2].toString() + "not matched with Opened Order State :"+OrderState);
// Assert.assertTrue(OmpText.equals("151808"),"Order BCN Number  not matched with Opened Order State :"+OmpText);
// ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order BCN Number("+OmpText+") Verified in OMP Portal"); 

//Order OCN Verification
		OmpText = Gettext(getwebelement(xml.getlocator("//locators/OCNNumber")));
		Assert.assertTrue(OmpText.equals(Inputdata[0].toString()),
				"Order State : " + Inputdata[0].toString() + "not matched with Opened Order State :" + OmpText);
//Assert.assertTrue(OmpText.equals("4159381"),"Order OCN Number not matched with Opened Order State :"+OmpText);
		ExtentTestManager.getTest().log(LogStatus.PASS,
				" Step: Order OCN Number(" + OmpText + ") Verified in OMP Portal");
	}
}

