package ScriptHelper;

import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.security.auth.Refreshable;

import org.dom4j.DocumentException;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import com.gargoylesoftware.htmlunit.Page;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;

import Driver.DriverHelper;
import Driver.XMLReader;
import Reporter.ExtentTestManager;
import org.apache.log4j.Logger;
import org.apache.pdfbox.contentstream.operator.state.Save;
import org.apache.poi.xssf.streaming.examples.SavePasswordProtectedXlsx;

public class InFlightOrderHelper extends DriverHelper {

	
	
	
	public InFlightOrderHelper(WebDriver dr) {
		super(dr);

	}

	WebElement el;
	
	
	XMLReader xml = new XMLReader("src\\Locators\\InFlightOrder.xml");
	
	public void ServiceTabInFlight(Object[] Inputdata) throws Exception {
		String Product_Name=Inputdata[8].toString();
		
		String Product_Name1=Inputdata[11].toString();

		
		        Thread.sleep(15000);
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
				//******
				
				//Search Service Order
				waitandForElementDisplay(xml.getlocator("//locators/InputServiceOrder"), 5);
				Clickon(getwebelement(xml.getlocator("//locators/InputServiceOrder")));
				SendKeys(getwebelement(xml.getlocator("//locators/InputServiceOrder")),ServiceOrder.get().toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Send Service Order2 Number");
				Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderGo")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Service Go");
				waitforPagetobeenable();
				Thread.sleep(20000);
				//*******
				
				//Open Reference No
				Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderReferenceNo")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on ServiceOrderReferenceNo");
				waitforPagetobeenable();
				//******
				
				//Open Worflow Tab
				WaitforElementtobeclickable(xml.getlocator("//locators/ClickLink").replace("Value", "Workflows"));
				Clickon(getwebelement(xml.getlocator("//locators/ClickLink").replace("Value","Workflows")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Workflows");
				waitforPagetobeenable();
				//Click  Plus Sign, select dropdown and select option 
				Clickon(getwebelement(xml.getlocator("//locators/InflightPlusSign")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on InFightPlusSign");
				waitforPagetobeenable();
				Moveon(getwebelement(xml.getlocator("//locators/WorkflowDropdown")));
				Clickon(getwebelement(xml.getlocator("//locators/WorkflowDropdown")));
				Thread.sleep(4000);
				clickUsingAction(getwebelement(xml.getlocator("//locators/SelectValueDropdown").replace("Value", "In-Flight Change")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Value from Dropdown");
				waitforPagetobeenable();
				
				switch(Product_Name)
				{
				case "Number Hosting":
				{
				WaitforElementtobeclickable(xml.getlocator("//locators/InflightVoiceSelection"));
				Clickon(getwebelement2(xml.getlocator("//locators/InflightVoiceSelection")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Voice");
				waitforPagetobeenable();
				break;
				}
				case "Interconnect":
				{
				WaitforElementtobeclickable(xml.getlocator("//locators/InflightVoiceSelection"));
				Clickon(getwebelement(xml.getlocator("//locators/InflightVoiceSelection")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Voice");
				waitforPagetobeenable();
				break;
				}
				case "SIP Trunking":
				{
				WaitforElementtobeclickable(xml.getlocator("//locators/InflightVoiceSelection"));
				Clickon(getwebelement(xml.getlocator("//locators/InflightVoiceSelection")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Voice");
				waitforPagetobeenable();
				break;
				}
				case "Voice Line V":
				{
				WaitforElementtobeclickable(xml.getlocator("//locators/InflightVoiceSelection"));
				Clickon(getwebelement(xml.getlocator("//locators/InflightVoiceSelection")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Voice");
				waitforPagetobeenable();
				break;
				}
				
				case "IP Access":
				{
				WaitforElementtobeclickable(xml.getlocator("//locators/BandwidthIPAccess"));
				Clickon(getwebelement(xml.getlocator("//locators/BandwidthIPAccess")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Bandwidth");
				waitforPagetobeenable();
				break;
				}
				case "Ethernet Spoke":
				{
				WaitforElementtobeclickable(xml.getlocator("//locators/BandwidthIPAccess"));
				Clickon(getwebelement(xml.getlocator("//locators/BandwidthIPAccess")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Bandwidth");
				waitforPagetobeenable();
				break;
				}
				case "Ethernet Hub":
				{
				WaitforElementtobeclickable(xml.getlocator("//locators/BandwidthIPAccess"));
				Clickon(getwebelement(xml.getlocator("//locators/BandwidthIPAccess")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Bandwidth");
				waitforPagetobeenable();
				break;
				}
				
				case "Etherline":
				{
				WaitforElementtobeclickable(xml.getlocator("//locators/BandwidthIPAccess"));
				Clickon(getwebelement(xml.getlocator("//locators/BandwidthIPAccess")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Bandwidth");
				waitforPagetobeenable();
				break;
				}
				case "Wave":
				{
				WaitforElementtobeclickable(xml.getlocator("//locators/BandwidthIPAccess"));
				Clickon(getwebelement(xml.getlocator("//locators/BandwidthIPAccess")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Bandwidth");
				waitforPagetobeenable();
				break;
				}
				
				case "Private Ethernet":
				{
				WaitforElementtobeclickable(xml.getlocator("//locators/BandwidthIPAccess"));
				Clickon(getwebelement(xml.getlocator("//locators/BandwidthIPAccess")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Bandwidth A end primary");
				waitforPagetobeenable();
				//for selecting B end primary//
				WaitforElementtobeclickable(xml.getlocator("//locators/BandwidthBend"));
				Clickon(getwebelement(xml.getlocator("//locators/BandwidthBend")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Bandwidth B end primary");
				waitforPagetobeenable();
				break;
				
				}
				case "Dark Fibre":
				{
				WaitforElementtobeclickable(xml.getlocator("//locators/BandwidthIPAccess"));
				Clickon(getwebelement(xml.getlocator("//locators/BandwidthIPAccess")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Bandwidth A end primary");
				waitforPagetobeenable();
				//for selecting B end primary//
				WaitforElementtobeclickable(xml.getlocator("//locators/BandwidthBend"));
				Clickon(getwebelement(xml.getlocator("//locators/BandwidthBend")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Bandwidth B end primary");
				waitforPagetobeenable();
				break;
				
				}
				case "DCA Ethernet":
				{
				WaitforElementtobeclickable(xml.getlocator("//locators/BandwidthIPAccess"));
				Clickon(getwebelement(xml.getlocator("//locators/BandwidthIPAccess")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Bandwidth A end primary");
				waitforPagetobeenable();
				//for selecting B end primary//
				WaitforElementtobeclickable(xml.getlocator("//locators/BandwidthBend"));
				Clickon(getwebelement(xml.getlocator("//locators/BandwidthBend")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Bandwidth B end primary");
				waitforPagetobeenable();
				break;
				}
				
				case "Ultra Low Latency":
				{
				WaitforElementtobeclickable(xml.getlocator("//locators/BandwidthIPAccess"));
				Clickon(getwebelement(xml.getlocator("//locators/BandwidthIPAccess")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Bandwidth A end primary");
				waitforPagetobeenable();
				//for selecting B end primary//
				WaitforElementtobeclickable(xml.getlocator("//locators/BandwidthBend"));
				Clickon(getwebelement(xml.getlocator("//locators/BandwidthBend")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Bandwidth B end primary");
				waitforPagetobeenable();
				break;
				
				}
				
				case "Private Wave Node":
				{
				WaitforElementtobeclickable(xml.getlocator("//locators/BandwidthIPAccess"));
				Clickon(getwebelement(xml.getlocator("//locators/BandwidthIPAccess")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Bandwidth A end primary");
				waitforPagetobeenable();
				//for selecting B end primary//
				WaitforElementtobeclickable(xml.getlocator("//locators/BandwidthBend"));
				Clickon(getwebelement(xml.getlocator("//locators/BandwidthBend")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Bandwidth B end primary");
				waitforPagetobeenable();
				break;
				
				}
				
				case "Private Wave Service":
				{
				WaitforElementtobeclickable(xml.getlocator("//locators/BandwidthIPAccess"));
				Clickon(getwebelement(xml.getlocator("//locators/BandwidthIPAccess")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Bandwidth A end primary");
				waitforPagetobeenable();
				//for selecting B end primary//
				WaitforElementtobeclickable(xml.getlocator("//locators/BandwidthBend"));
				Clickon(getwebelement(xml.getlocator("//locators/BandwidthBend")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Bandwidth B end primary");
				waitforPagetobeenable();
				break;
				
				}
				
				case "Ethernet Access":
				{
				WaitforElementtobeclickable(xml.getlocator("//locators/BandwidthIPAccess"));
				Clickon(getwebelement(xml.getlocator("//locators/BandwidthIPAccess")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Bandwidth A end primary");
				waitforPagetobeenable();
				//for selecting B end primary//
				WaitforElementtobeclickable(xml.getlocator("//locators/BandwidthBend"));
				Clickon(getwebelement(xml.getlocator("//locators/BandwidthBend")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Bandwidth B end primary");
				waitforPagetobeenable();
				break;
				
				}
				
				case "Ethernet VPN Access":
				{
				WaitforElementtobeclickable(xml.getlocator("//locators/BandwidthIPAccess"));
				Clickon(getwebelement(xml.getlocator("//locators/BandwidthIPAccess")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Bandwidth A end primary");
				waitforPagetobeenable();
				break;
				
				}
				
				case "IP VPN Service":
				{
					if(Product_Name1.equalsIgnoreCase("IP VPN Plus"))
					{
						System.out.println("enter into else-if loop of vpn plus");
					}
					else if(Product_Name1.equalsIgnoreCase("IP VPN Access"))
					{
						System.out.println("enter into else-if loop of vpn access");
					}
                
					else if(Product_Name1.equalsIgnoreCase("IP VPN Wholesale"))
					{
						System.out.println("enter into else-if loop of vpn wholesale");
					}
				
					else if(Product_Name1.equalsIgnoreCase("Swiftnet"))
					{
						System.out.println("enter into else-if loop of swiftnet");	
					}
				
					else if(Product_Name1.equalsIgnoreCase("Prizmnet"))
					{
						System.out.println("enter into else-if loop of prizmnet");
					}
					break;
				
				}
				

				
				}	
				//Workflow save
				WaitforElementtobeclickable(xml.getlocator("//locators/WorkflowSave"));
				Clickon(getwebelement(xml.getlocator("//locators/WorkflowSave")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Workflows Save");
				  waitForpageload();
				waitforPagetobeenable();
	         				
				switch(Product_Name)
				{
				case "Number Hosting":
				{
					NumberHostingInflight(Inputdata);
					break;
				}
				case "SIP Trunking":
				{
					SIPTrunkingInflight(Inputdata);
					break;
				}
				case "Interconnect":
				{
					NumberHostingInflight(Inputdata);
					break;
				}
				case "Voice Line V":
				{
					VoiceLineVInflight(Inputdata);
					break;
				}
			
				case "Ethernet Spoke":
				{
					ethernetSpoke(Inputdata);
					break;
				}
				case "Ethernet Hub":
				{
					ethernetSpoke(Inputdata);
					break;
				}
				case "Etherline":
				{
					ethernetLine(Inputdata);
					break;
				}
				case "Wave":
				{
					ethernetLine(Inputdata);
					break;
				}
				case "IP Access":
				{
					ipAccess(Inputdata);
					break;
				}
				
				case "Private Ethernet":
				{
					privateEthernet(Inputdata);
					break;
				}
				
				case "Dark Fibre":
				{
					privateEthernet(Inputdata);
					break;
				}
				
				case "DCA Ethernet":
				{
					privateEthernet(Inputdata);
					break;
				}
				
				case "Ultra Low Latency":
				{
					privateEthernet(Inputdata);
					break;
				}
				
				case "Private Wave Node":
				{
					privateWaveNode(Inputdata);
					break;
				}
				
				case "Private Wave Service":
				{
					privateWaveNode(Inputdata);
					break;
				}
				
				case "Ethernet Access":
				{
					privateWaveNode(Inputdata);
					break;
				}
				
				case "Ethernet VPN Access":
				{
					privateEthernet(Inputdata);
					break;
				}
				
				case "IP VPN Service":
				{
					if(Product_Name1.equalsIgnoreCase("IP VPN Plus"))
					{
						PlusAccessWHSwifPrizm();
						
					}
					else if(Product_Name1.equalsIgnoreCase("IP VPN Access"))
					{
						PlusAccessWHSwifPrizm();
					}
                
					else if(Product_Name1.equalsIgnoreCase("IP VPN Wholesale"))
					{
						PlusAccessWHSwifPrizm();
					}
				
					else if(Product_Name1.equalsIgnoreCase("SWIFTNet"))
					{
						PlusAccessWHSwifPrizm();	
					}
				
					else if(Product_Name1.equalsIgnoreCase("PrizmNet"))
					{
						PlusAccessWHSwifPrizm();
					}
					break;
				}
						
				default:
					System.out.println("Above product is not exist in current list");
					break;
				}	
	   }
	
	public void PlusAccessWHSwifPrizm() throws Exception
	{
	     //Open IP Details
			Thread.sleep(6000);
			WaitforElementtobeclickable(xml.getlocator("//locators/ClickLink").replace("Value", "IP Details"));
			Clickon(getwebelement(xml.getlocator("//locators/ClickLink").replace("Value", "IP Details")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on IP details tab");
			waitforPagetobeenable();
				//********
				
			//Update customer alias// 
			Thread.sleep(6000);
			
			String Fieldtitle1=Getattribute(getwebelement2(xml.getlocator("//locators/FieldLabelSwift").replace("ChangeFieldName","Customer Alias")), "title");
			Assert.assertTrue("Before Change In- Flight apprear for control", !Fieldtitle1.contains("flight"));
			Clickon(getwebelement(xml.getlocator("//locators/TextInputSwift").replace("Value","Customer Alias")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Customer Alias");
			Clear(getwebelement(xml.getlocator("//locators/TextInputSwift").replace("Value","Customer Alias")));
		    Thread.sleep(5000);
			SendKeys(getwebelement(xml.getlocator("//locators/TextInputSwift").replace("Value","Customer Alias")), "Ayush Moudgil");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Customer Alias");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/TextInputSwift").replace("Value","Customer Alias")), Keys.TAB);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/ClickheretoSaveAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
			waitforPagetobeenable();
		
			Fieldtitle1=Getattribute(getwebelement(xml.getlocator("//locators/FieldLabelSwift").replace("ChangeFieldName","Customer Alias")), "title");
			Assert.assertTrue("After Change to In- Flight title not appear for field", Fieldtitle1.contains("flight"));
	
	}
	

	public void privateEthernet(Object[] Inputdata) throws Exception
	{
		
		    //Open Sites Tab
			Thread.sleep(6000);
			WaitforElementtobeclickable(xml.getlocator("//locators/ClickLink").replace("Value", "Sites"));
			Clickon(getwebelement(xml.getlocator("//locators/ClickLink").replace("Value", "Sites")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on sites tab");
			waitforPagetobeenable();
				//********
				
			//Update physical port ID// 
			Thread.sleep(6000);
	
			javascriptexecutor(getwebelement(xml.getlocator("//locators/AccessPortAend")));
			String Fieldtitle1=Getattribute(getwebelement2(xml.getlocator("//locators/FieldLabelR4").replace("ChangeFieldName","Physical Port ID")), "title");
			Assert.assertTrue("Before Change In- Flight apprear for control", !Fieldtitle1.contains("flight"));
			Clickon(getwebelement(xml.getlocator("//locators/TextInputR4").replace("Value","Physical Port ID")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Physical port id");
			Clear(getwebelement(xml.getlocator("//locators/TextInputR4").replace("Value","Physical Port ID")));
				
			SendKeys(getwebelement(xml.getlocator("//locators/TextInputR4").replace("Value","Physical Port ID")), "98743");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Physical port id");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/TextInputR4").replace("Value","Physical Port ID")), Keys.TAB);
			WaitforElementtobeclickable((xml.getlocator("//locators/ClickheretoSaveAccess")));
			Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
			waitforPagetobeenable();
				
			Fieldtitle1=Getattribute(getwebelement(xml.getlocator("//locators/FieldLabelR4").replace("ChangeFieldName","Physical Port ID")), "title");
			Assert.assertTrue("After Change to In- Flight title not appear for field", Fieldtitle1.contains("flight"));
	}
	
	
	public void privateWaveNode(Object[] Inputdata) throws Exception
	{
		
		    //Open Sites Tab
			Thread.sleep(6000);
			WaitforElementtobeclickable(xml.getlocator("//locators/ClickLink").replace("Value", "Sites"));
			Clickon(getwebelement(xml.getlocator("//locators/ClickLink").replace("Value", "Sites")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on sites tab");
			waitforPagetobeenable();
				//********
				
			//Update shelf ID// 
			Thread.sleep(6000);
			javascriptexecutor(getwebelement(xml.getlocator("//locators/TerminationInformationAEnd")));
			String Fieldtitle1=Getattribute(getwebelement2(xml.getlocator("//locators/FieldLabelR4").replace("ChangeFieldName","Shelf ID")), "title");
			Assert.assertTrue("Before Change In- Flight apprear for control", !Fieldtitle1.contains("flight"));
			
			Clickon(getwebelement(xml.getlocator("//locators/TextInputR4").replace("Value","Shelf ID")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on shelf id");
			Clear(getwebelement(xml.getlocator("//locators/TextInputR4").replace("Value","Shelf ID")));
			Thread.sleep(4000);
			SendKeys(getwebelement(xml.getlocator("//locators/TextInputR4").replace("Value","Shelf ID")), "42");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Physical port id");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/TextInputR4").replace("Value","Shelf ID")), Keys.TAB);
			WaitforElementtobeclickable(xml.getlocator("//locators/ClickheretoSaveAccess"));
			Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
			waitforPagetobeenable();
				
			Fieldtitle1=Getattribute(getwebelement(xml.getlocator("//locators/FieldLabelR4").replace("ChangeFieldName","Shelf ID")), "title");
			Assert.assertTrue("After Change to In- Flight title not appear for field", Fieldtitle1.contains("flight"));
	}
	
	
	public void ethernetSpoke(Object[] Inputdata) throws Exception
	{
		
		String Fieldtitle1=Getattribute(getwebelement2(xml.getlocator("//locators/FieldLabelR1").replace("ChangeFieldName","Resilience Option")), "class");
		Assert.assertTrue("Before Change In- Flight apprear for control", !Fieldtitle1.contains("flight"));
		
		Select(getwebelement2(xml.getlocator("//locators/ResillienceOptionSpoke")), Inputdata[75].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Resilience Option");
		
		WaitforElementtobeclickable(xml.getlocator("//locators/ApplyChangesSpoke"));
		Clickon(getwebelement(xml.getlocator("//locators/ApplyChangesSpoke")));
		waitforPagetobeenable();
		
		Fieldtitle1=Getattribute(getwebelement(xml.getlocator("//locators/FieldLabelR1").replace("ChangeFieldName","Trunk Name")), "class");
		Assert.assertTrue("After Change to In- Flight title not appear for field", Fieldtitle1.contains("flight"));
		
	}
	
	public void ethernetLine(Object[] Inputdata) throws Exception
	{
		
		String Fieldtitle1=Getattribute(getwebelement2(xml.getlocator("//locators/FieldLabelR1").replace("ChangeFieldName","A End Resilience Option")), "class");
		Assert.assertTrue("Before Change In- Flight apprear for control", !Fieldtitle1.contains("flight"));
		
		Select(getwebelement2(xml.getlocator("//locators/ResillienceOptionLine")), Inputdata[75].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Resilience Option");
		
		WaitforElementtobeclickable(xml.getlocator("//locators/ApplyChangesSpoke"));
		Clickon(getwebelement(xml.getlocator("//locators/ApplyChangesSpoke")));
		waitforPagetobeenable();
		
		Fieldtitle1=Getattribute(getwebelement(xml.getlocator("//locators/FieldLabelR1").replace("ChangeFieldName","Trunk Name")), "class");
		Assert.assertTrue("After Change to In- Flight title not appear for field", Fieldtitle1.contains("flight"));
		
	}
	
	public void ipAccess( Object[] Inputdata) throws InterruptedException, DocumentException, IOException
	{
		//Open Sites Tab
		Thread.sleep(6000);
		WaitforElementtobeclickable(xml.getlocator("//locators/ClickLink").replace("Value", "Sites"));
		Clickon(getwebelement(xml.getlocator("//locators/ClickLink").replace("Value","Sites")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on sites tab");
		
		waitforPagetobeenable();
		//********
		
		//Update Tcapacity check reference and verified icon 
		Thread.sleep(6000);
		String Fieldtitle1=Getattribute(getwebelement2(xml.getlocator("//locators/FieldLabel").replace("ChangeFieldName","Capacity Check Reference")), "title");
		Assert.assertTrue("Before Change In- Flight apprear for control", !Fieldtitle1.contains("flight"));
		Clickon(getwebelement(xml.getlocator("//locators/TextInput").replace("Value","Capacity Check Reference")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Capacity Check Reference");
		Clear(getwebelement(xml.getlocator("//locators/TextInput").replace("Value","Capacity Check Reference")));
		
		SendKeys(getwebelement(xml.getlocator("//locators/TextInput").replace("Value","Capacity Check Reference")), "1234");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Capacity Check Reference");
		WaitforElementtobeclickable(xml.getlocator("//locators/ClickheretoSaveAccess"));
		Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
		waitforPagetobeenable();
		
		Fieldtitle1=Getattribute(getwebelement(xml.getlocator("//locators/FieldLabel").replace("ChangeFieldName","Capacity Check Reference")), "title");
		Assert.assertTrue("After Change to In- Flight title not appear for field", Fieldtitle1.contains("flight"));
	}

	
	

	public void NumberHostingInflight( Object[] Inputdata) throws InterruptedException, DocumentException, IOException
	{
		//Open Voice Tab
		Thread.sleep(6000);
		WaitforElementtobeclickable(xml.getlocator("//locators/ClickLink").replace("Value", "Voice Config"));
		Clickon(getwebelement(xml.getlocator("//locators/ClickLink").replace("Value","Voice Config")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Voice Config");
		waitforPagetobeenable();
		//********
		
		//Update Trunk Name and verified icon 
		Thread.sleep(6000);
		String Fieldtitle1=Getattribute(getwebelement2(xml.getlocator("//locators/FieldLabel").replace("ChangeFieldName","Trunk Name")), "Title");
		Assert.assertTrue("Before Change In- Flight apprear for control", !Fieldtitle1.contains("flight"));
		Clickon(getwebelement(xml.getlocator("//locators/TextInput").replace("Value","Trunk Name")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Trunk Name");
		Clear(getwebelement(xml.getlocator("//locators/TextInput").replace("Value","Trunk Name")));
		
		SendKeys(getwebelement(xml.getlocator("//locators/TextInput").replace("Value","Trunk Name")), "abcd");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Send Trunk Name");
		WaitforElementtobeclickable(xml.getlocator("//locators/ClickheretoSaveAccess"));
		Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
		waitforPagetobeenable();
		
		Fieldtitle1=Getattribute(getwebelement(xml.getlocator("//locators/FieldLabel").replace("ChangeFieldName","Trunk Name")), "Title");
		Assert.assertTrue("After Change to In- Flight title not appear for field", Fieldtitle1.contains("flight"));
	}
	

	public void SIPTrunkingInflight( Object[] Inputdata) throws InterruptedException, DocumentException, IOException
	{
		Thread.sleep(6000);
		WaitforElementtobeclickable(xml.getlocator("//locators/ClickLink").replace("Value", "Voice Config"));
		Clickon(getwebelement(xml.getlocator("//locators/ClickLink").replace("Value","Voice Config")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Voice Config");
		waitforPagetobeenable();
		
		String Fieldtitle1=Getattribute(getwebelement2(xml.getlocator("//locators/FieldLabel").replace("ChangeFieldName","Call Admission Control (Number of Channels)")), "title");
		Assert.assertTrue("Before Change In- Flight apprear for control", !Fieldtitle1.contains("flight"));
		WaitforElementtobeclickable(xml.getlocator("//locators/CallAdmissionControl"));	
		Clickon(getwebelement(xml.getlocator("//locators/CallAdmissionControl")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on CallAdmissionControl");
		Clear(getwebelement(xml.getlocator("//locators/CallAdmissionControl")));
		SendKeys(getwebelement(xml.getlocator("//locators/CallAdmissionControl")),"128" );
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Send value for CallAdmissionControl");
		
		WaitforElementtobeclickable(xml.getlocator("//locators/ClickheretoSaveAccess"));
		Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
		waitforPagetobeenable();
		
		Fieldtitle1=Getattribute(getwebelement(xml.getlocator("//locators/FieldLabel").replace("ChangeFieldName","Call Admission Control (Number of Channels)")), "title");
		Assert.assertTrue("After Change to In- Flight title not appear for field", Fieldtitle1.contains("flight"));
		
		 
		
	}
	public void VoiceLineVInflight( Object[] Inputdata) throws InterruptedException, DocumentException, IOException
	{
		//Open voice tab//
		Thread.sleep(6000);
		WaitforElementtobeclickable(xml.getlocator("//locators/ClickLink").replace("Value", "Voice Config"));
		Clickon(getwebelement(xml.getlocator("//locators/ClickLink").replace("Value","Voice Config")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Voice Config");
		waitforPagetobeenable();
		
		
		//Update DDIs and verified icon 
		
		String Fieldtitle1=Getattribute(getwebelement2(xml.getlocator("//locators/FieldLabel").replace("ChangeFieldName","Total Number of DDIs")), "Title");
		Assert.assertTrue("Before Change In- Flight apprear for control", !Fieldtitle1.contains("flight"));
		WaitforElementtobeclickable(xml.getlocator("//locators/TotalDDi"));
		Clickon(getwebelement(xml.getlocator("//locators/TotalDDi")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on TotalDDi");
		SendKeys(getwebelement(xml.getlocator("//locators/TotalDDi")),"6");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Send  TotalDDi");
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/TotalDDi")),Keys.ENTER);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Total DDI");
		Thread.sleep(5000);
		
		WaitforElementtobeclickable(xml.getlocator("//locators/ClickheretoSaveAccess"));
		Clickon(getwebelement(xml.getlocator("//locators/ClickheretoSaveAccess")));
		waitforPagetobeenable();
		
		Fieldtitle1=Getattribute(getwebelement(xml.getlocator("//locators/FieldLabel").replace("ChangeFieldName","Total Number of DDIs")), "Title");
		Assert.assertTrue("After Change to In- Flight title not appear for field", Fieldtitle1.contains("flight"));
	}
}

	
