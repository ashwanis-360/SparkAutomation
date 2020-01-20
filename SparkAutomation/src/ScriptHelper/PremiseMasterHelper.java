package ScriptHelper;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import Driver.DriverHelper;
import Driver.XMLReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Reporter.ExtentTestManager;
import java.util.Random;

public class PremiseMasterHelper extends DriverHelper
{
	Random rnd =new Random();
	WebElement el;
	String temp;
	XMLReader xml = new XMLReader("src\\Locators\\PremiseMaster.xml");
	XMLReader xmlS = new XMLReader("src\\Locators\\SiebelOrder.xml");
	String BuildingID=null;
	public PremiseMasterHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}
	private char RandomChar()
	{
		String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char block = abc.charAt(rnd.nextInt(abc.length()));
		return block;
	}
	private String RandomName()
	{
		String[] BuildNames= {"TestBuilding","Kenwood","RiverLine","CrossRoad","WalkStreet","TechWorld","WindBall"};
		int index=rnd.nextInt(BuildNames.length);
		return BuildNames[index];
	}
	private String  HouseNoGeneration ()
	{
		int HNo=rnd.nextInt(1000); 
		String temp=  String.valueOf(RandomChar())+"-"+String.valueOf(HNo);
		System.out.println("Flat Number Genrated : "+ temp);
		return temp;
	}
	private String  BuildingGeneration ()
	{
		int flatNo=rnd.nextInt(1000); 
		temp=  RandomName()+"-"+String.valueOf(RandomChar())+"-"+String.valueOf(flatNo);
		System.out.println("Building Name Genrated : "+ temp);
		return temp;
	}
	
	public void ClickIcon() throws Exception
	{
		WaitforElementtobeclickable((xml.getlocator("//locators/HomePage/Image")));
		Clickon(getwebelement(xml.getlocator("//locators/HomePage/Image")));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Click on Main Icon ");
		
	}
	public void ClickTopMeu(String menuItem ) throws Exception
	{
		WaitforElementtobeclickable((xml.getlocator("//locators/HomePage/MainMenu").replace("Menu", menuItem)));
		Clickon(getwebelement(xml.getlocator("//locators/HomePage/MainMenu").replace("Menu", menuItem)));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Click on Menu >> "+menuItem);
	}
	public void SearchSite(Object[] InputData) throws IOException, InterruptedException, DocumentException
	{
		//Country selection 
		WaitforElementtobeclickable(xml.getlocator("//locators/SearchLocation/Country"));		
		Select(getwebelement(xml.getlocator("//locators/SearchLocation/Country")), InputData[16].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select on country >> "+InputData[16].toString());
		waitforPagetobeenable();
		
		//Enter City
		ClearSendKeys(getwebelement(xml.getlocator("//locators/SearchLocation/City")), InputData[17].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Enter on City >> "+InputData[17].toString());
		waitforPagetobeenable();
		
		//House Number
		if(InputData[18].toString().equals(null)||InputData[18].toString().equals("")) 
		{
			temp=HouseNoGeneration();
			ExtentTestManager.getTest().log(LogStatus.PASS," Step: House Number Generated >> "+temp);
		}
		else
		{
			temp=InputData[18].toString()+"-"+ String.valueOf(rnd.nextInt(1000));
		}
		ClearSendKeys(getwebelement(xml.getlocator("//locators/SearchLocation/HouseNo")), temp);
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: House Number Entered >> "+temp);
		waitforPagetobeenable();
		
		//Building  Name
		if(InputData[20].toString().equals(null)||InputData[20].toString().equals("")) 
		{
			temp=BuildingGeneration();
			ExtentTestManager.getTest().log(LogStatus.PASS," Step: Building Name Generated >> "+temp);
		}
		else
		{
			temp=InputData[20].toString()+"-"+ String.valueOf(rnd.nextInt(1000));
		}
			
		ClearSendKeys(getwebelement(xml.getlocator("//locators/SearchLocation/BuildingName")), temp);
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Building Name Entered >> "+temp);
		waitforPagetobeenable();	
		
		//Street Entry
		ClearSendKeys(getwebelement(xml.getlocator("//locators/SearchLocation/StreetName")), InputData[19].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Street Name Entered >> "+InputData[19].toString());
		waitforPagetobeenable();
		
		//Postal Entry	
		ClearSendKeys(getwebelement(xml.getlocator("//locators/SearchLocation/PostalCode")), InputData[21].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Postal Code Entered >> "+InputData[21].toString());
		waitforPagetobeenable();
		
		//State Entry	
		ClearSendKeys(getwebelement(xml.getlocator("//locators/SearchLocation/State")), InputData[22].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: State Name Entered >> "+InputData[22].toString());
		waitforPagetobeenable();
				
	}
	
	public void SearchBuildingAndEdit(String BulidingID,Object[] InputData) throws Exception
	{
		waitForpageload();
		ClickTopMeu("Search");
		
		waitForpageload();
		System.out.println(BulidingID);
		
		WaitforElementtobeclickable(xml.getlocator("//locators/SearchSite/SearchType"));		
		Select2(getwebelement(xml.getlocator("//locators/SearchSite/SearchType")), "BUILDING");
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select Search Type >> Building");
		
		ClearSendKeys(getwebelement(xml.getlocator("//locators/SearchSite/SearchValue")), BulidingID);
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Enter Search Value >> "+BulidingID);
		
		WaitforElementtobeclickable(xml.getlocator("//locators/SearchSite/Submit"));		
		Clickon(getwebelement(xml.getlocator("//locators/SearchSite/Submit")));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Click On Search ");
		
		waitForpageload();
		
		WaitforElementtobeclickable(xml.getlocator("//locators/EditSite/EditBuilding"));		
		Clickon(getwebelement(xml.getlocator("//locators/EditSite/EditBuilding")));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Click On Edit Link ");
		waitforPagetobeenable();
		waitForpageload();
		
		//Updating Building Type
		WaitforElementtobeclickable(xml.getlocator("//locators/CreateSite/BuildingType"));		
		Select2(getwebelement(xml.getlocator("//locators/CreateSite/BuildingType")), InputData[23].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select Building Type >> "+InputData[23].toString());
		waitforPagetobeenable();
		
		// Status 
		System.out.println(InputData[24].toString());
		WaitforElementtobeclickable(xml.getlocator("//locators/CreateSite/BuildingStatus"));		
		Select2(getwebelement(xml.getlocator("//locators/CreateSite/BuildingStatus")), InputData[24].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select Building Status Type >> "+InputData[24].toString());
		waitforPagetobeenable();
				
		//Access Type
		System.out.println(InputData[25].toString());
		WaitforElementtobeclickable(xml.getlocator("//locators/CreateSite/AccessType"));		
		Select2(getwebelement(xml.getlocator("//locators/CreateSite/AccessType")), InputData[25].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select Access Type >> "+InputData[25].toString());
		waitforPagetobeenable();
		
		//Building Category
		System.out.println(InputData[26].toString());
		WaitforElementtobeclickable(xml.getlocator("//locators/CreateSite/BuildingCategory"));		
		Select2(getwebelement(xml.getlocator("//locators/CreateSite/BuildingCategory")), InputData[26].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select Building Category Type >> "+InputData[26].toString());
		waitforPagetobeenable();
		
		WaitforElementtobeclickable(xml.getlocator("//locators/CreateSite/Submit"));		
		Clickon(getwebelement(xml.getlocator("//locators/CreateSite/Submit")));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Click On Update Bulding");
		
		waitForpageload();
		waitforPagetobeenable();
		
		String Message=GetText(getwebelement(xml.getlocator("//locators/EditSite/BuildingUpdateMessage")));
		Message=Message.toUpperCase();
		System.out.println("Building Updated Message : "+Message);
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Bulding Update : "+Message);
		Assert.assertTrue(Message.contains("BUILDING UPDATED SUCCESSFULLY WITH ID")&& Message.contains(BulidingID), "Error in Building Updation");
	
	}
	public void SearchSiteAndEdit(String SiteID,Object[] InputData) throws Exception
	{
		
		waitForpageload();
		ClickTopMeu("Search");
		
		waitForpageload();
		System.out.println(SiteID);
		
		WaitforElementtobeclickable(xml.getlocator("//locators/SearchSite/SearchType"));		
		Select2(getwebelement(xml.getlocator("//locators/SearchSite/SearchType")), "SITE");
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select Search Type >> Site");
		
		ClearSendKeys(getwebelement(xml.getlocator("//locators/SearchSite/SearchValue")), SiteID);
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Enter Search Site Value >> "+SiteID);
		
		WaitforElementtobeclickable(xml.getlocator("//locators/SearchSite/Submit"));		
		Clickon(getwebelement(xml.getlocator("//locators/SearchSite/Submit")));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Click On Create Bulding and Site ");
		
		waitForpageload();
		
		WaitforElementtobeclickable(xml.getlocator("//locators/EditSite/EditBuilding"));		
		Clickon(getwebelement(xml.getlocator("//locators/EditSite/EditBuilding")));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Click On Edit Link ");
		waitforPagetobeenable();
		waitForpageload();
		
		//Site Type
		System.out.println(InputData[27].toString());
		WaitforElementtobeclickable(xml.getlocator("//locators/EditSite/SiteType"));		
		Select2(getwebelement(xml.getlocator("//locators/EditSite/SiteType")), InputData[27].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select Site Type >> "+InputData[27].toString());
		waitForpageload();
		waitforPagetobeenable();
		
		//Man City Code
		System.out.println(InputData[32].toString());
		WaitforElementtobeclickable(xml.getlocator("//locators/CreateSite/CityID"));		
		Select(getwebelement(xml.getlocator("//locators/CreateSite/CityID")), InputData[32].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select CityID >> "+InputData[32].toString());
		waitforPagetobeenable();
		
		//Status 
		System.out.println(InputData[28].toString());
		WaitforElementtobeclickable(xml.getlocator("//locators/EditSite/Status"));		
		Select2(getwebelement(xml.getlocator("//locators/EditSite/Status")), InputData[28].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select Status Type >> "+InputData[28].toString());
		waitforPagetobeenable();
		
		WaitforElementtobeclickable(xml.getlocator("//locators/EditSite/UpdateSite"));		
		Clickon(getwebelement(xml.getlocator("//locators/EditSite/UpdateSite")));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Click On Update Site info");
		
		waitForpageload();
		waitforPagetobeenable();
	
	}
	
	public String GetUpdateSiteId(String BulidingID) throws Exception 
	{
		waitForpageload();
		ClickTopMeu("Search");
		
		waitForpageload();
		System.out.println(BulidingID);
		
		WaitforElementtobeclickable(xml.getlocator("//locators/SearchSite/SearchType"));		
		Select2(getwebelement(xml.getlocator("//locators/SearchSite/SearchType")), "BUILDING");
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select Search Type >> Building");
		
		ClearSendKeys(getwebelement(xml.getlocator("//locators/SearchSite/SearchValue")), BulidingID);
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Enter Search Value >> "+BulidingID);
		
		WaitforElementtobeclickable(xml.getlocator("//locators/SearchSite/Submit"));		
		Clickon(getwebelement(xml.getlocator("//locators/SearchSite/Submit")));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Click On Search ");
		
		waitForpageload();
		
		WaitforElementtobeclickable(xml.getlocator("//locators/EditSite/EditBuilding"));		
		Clickon(getwebelement(xml.getlocator("//locators/EditSite/EditBuilding")));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Click On Edit Link ");
		waitforPagetobeenable();
		waitForpageload();
		
		String Id=Gettext(getwebelement2(xml.getlocator("//locators/EditSite/UpdateSiteId"))).trim();
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Updated Site ID Fetched : "+ Id);
		return Id;
		
	} 
	
	public HashMap<String, String> AddSiteAndBuilding(Object[] InputData) throws InterruptedException, DocumentException, IOException {
		
		HashMap<String, String> SiteValues=new HashMap<>();
		String ProductName = InputData[8].toString();
		/*if(ProductName.equalsIgnoreCase("Ethernet Spoke")||ProductName.equalsIgnoreCase("Ethernet Hub")||ProductName.equalsIgnoreCase("Ethernet Line")||ProductName.equalsIgnoreCase("Wave"))
		{
			WaitforElementtobeclickable(xml.getlocator("//locators/Hub/Street"));
			ClearSendKeys(getwebelement(xml.getlocator("//locators/Hub/Street")),InputData[19].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Street: " + InputData[19].toString());
			waitforPagetobeenable();
			
			WaitforElementtobeclickable(xml.getlocator("//locators/Hub/Country"));
			Select(getwebelement(xml.getlocator("//locators/Hub/Country")), InputData[16].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Country: " + InputData[16].toString());
			waitforPagetobeenable();
			
			WaitforElementtobeclickable(xml.getlocator("//locators/Hub/City"));
			ClearSendKeys(getwebelement(xml.getlocator("//locators/Hub/City")),InputData[17].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter City/Town : " + InputData[17].toString());
			waitforPagetobeenable();
			
			WaitforElementtobeclickable(xml.getlocator("//locators/Hub/Postal"));
			ClearSendKeys(getwebelement(xml.getlocator("//locators/Hub/Postal")),InputData[21].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Postal Code : " + InputData[21].toString());
			waitforPagetobeenable();
			
			WaitforElementtobeclickable(xml.getlocator("//locators/Hub/Premises"));
			ClearSendKeys(getwebelement(xml.getlocator("//locators/Hub/Premises")),InputData[22].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Premises : " + InputData[22].toString());
			waitforPagetobeenable();
			
			WaitforElementtobeclickable(xml.getlocator("//locators/Hub/Search"));
			Clickon(getwebelement(xml.getlocator("//locators/Hub/Search")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search");
			waitforPagetobeenable();

			WaitforElementtobeclickable(xml.getlocator("//locators/Hub/AddressRow"));
			Clickon(getwebelement(xml.getlocator("//locators/Hub/AddressRow")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selcet Row");
			waitforPagetobeenable();
			waitForpageload();
			
			WaitforElementtobeclickable(xml.getlocator("//locators/Hub/Pick"));
			Clickon(getwebelement(xml.getlocator("//locators/Hub/Pick")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick");
			waitforPagetobeenable();
			
			WaitforElementtobeclickable(xml.getlocator("//locators/Hub/Addbuilding"));
			Clickon(getwebelement(xml.getlocator("//locators/Hub/Addbuilding")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Building");
			waitforPagetobeenable();
			
			//Building  Name
			if(InputData[20].toString().equals(null)||InputData[20].toString().equals("")) 
			{
				temp=BuildingGeneration();
				ExtentTestManager.getTest().log(LogStatus.PASS," Step: Building Name Generated >> "+temp);
			}
			else
			{
				temp=InputData[20].toString()+"-"+ String.valueOf(rnd.nextInt(1000));
			}
			SiteValues.put("BuildingName", temp);
			ClearSendKeys(getwebelement(xml.getlocator("//locators/Hub/BuildingName")), temp);
			ExtentTestManager.getTest().log(LogStatus.PASS," Step: Building Name Entered >> "+temp);
			waitforPagetobeenable();
			
			WaitforElementtobeclickable(xml.getlocator("//locators/Hub/SaveBuilding"));
			Clickon(getwebelement(xml.getlocator("//locators/Hub/SaveBuilding")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Save");
			waitforPagetobeenable();
		
			//Fill Building Details
			//House Number
			if(InputData[18].toString().equals(null)||InputData[18].toString().equals("")) 
			{
				temp=HouseNoGeneration();
				ExtentTestManager.getTest().log(LogStatus.PASS," Step: House Number Generated >> "+temp);
			}
			else
			{
				temp=InputData[18].toString()+"-"+ String.valueOf(rnd.nextInt(1000));
			}
			ClearSendKeys(getwebelement(xml.getlocator("//locators/Hub/RoomNo")), temp);
			ExtentTestManager.getTest().log(LogStatus.PASS," Step: Room Name Entered >> "+temp);
			waitforPagetobeenable();
			SiteValues.put("Room", temp);
			
			//Floor 
			int floor =rnd.nextInt((20 - 1) + 1) + 1;
			System.out.println(String.valueOf(floor));
			WaitforElementtobeclickable(xml.getlocator("//locators/Hub/Floor"));		
			ClearSendKeys(getwebelement(xml.getlocator("//locators/Hub/Floor")), String.valueOf(floor));
			ExtentTestManager.getTest().log(LogStatus.PASS," Step: Floor Entered >> "+String.valueOf(floor));
			waitforPagetobeenable();
			SiteValues.put("Floor", temp);
			
			WaitforElementtobeclickable(xml.getlocator("//locators/Hub/SaveSite"));
			Clickon(getwebelement(xml.getlocator("//locators/Hub/SaveSite")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Save");
			Thread.sleep(10000);
			waitforPagetobeenable();
			
			return SiteValues;
					
		}
		else
		{*/
		WaitforElementtobeclickable(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "Street Name"));
		Clear(getwebelement(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "Street Name")));
		SendKeys(getwebelement(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "Street Name")),
				InputData[19].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Street: " + InputData[19].toString());

		WaitforElementtobeclickable(xmlS.getlocator("//locators/R4/SearchDropdown").replace("Value", "Country"));
		Clickon(getwebelement(xmlS.getlocator("//locators/R4/SearchDropdown").replace("Value", "Country")));
		Clickon(getwebelement(
				xmlS.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[16].toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Country: " + InputData[16].toString());

		WaitforElementtobeclickable(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "City / Town"));
		Clear(getwebelement(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "City / Town")));
		SendKeys(getwebelement(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "City / Town")),
				InputData[17].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter City/Town : " + InputData[17].toString());

		WaitforElementtobeclickable(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "Postal Code"));
		Clear(getwebelement(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "Postal Code")));
		SendKeys(getwebelement(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "Postal Code")),
				InputData[21].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Postal Code : " + InputData[21].toString());

		WaitforElementtobeclickable(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "Premises"));
		Clear(getwebelement(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "Premises")));
		SendKeys(getwebelement(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "Premises")),
				InputData[22].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Premises : " + InputData[22].toString());

		WaitforElementtobeclickable(xmlS.getlocator("//locators/R4/SearchButton"));
		Clickon(getwebelement(xmlS.getlocator("//locators/R4/SearchButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search");
		waitforPagetobeenable();

		WaitforElementtobeclickable(xml.getlocator("//locators/Siebel/AddressNotFound"));
		Clickon(getwebelement(xml.getlocator("//locators/Siebel/AddressNotFound")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Address Not Found? Search Address Doctor");
		waitforPagetobeenable();
		waitForpageload();
		
		WaitforElementtobeclickable(xml.getlocator("//locators/Siebel/Addaddress"));
		Clickon(getwebelement(xml.getlocator("//locators/Siebel/Addaddress")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Address Not Found? Create a new Address");
		waitforPagetobeenable();
		
		WaitforElementtobeclickable(xml.getlocator("//locators/Siebel/SaveAddress"));
		Clickon(getwebelement(xml.getlocator("//locators/Siebel/SaveAddress")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Save Address");
		waitforPagetobeenable();
		
		WaitforElementtobeclickable(xml.getlocator("//locators/Siebel/Addaddress"));
		Clickon(getwebelement(xml.getlocator("//locators/Siebel/Addaddress")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Building Not Found? Create a new Building");
		waitforPagetobeenable();
		
		
		//Fill Building Details
		
		//Building  Name
				if(InputData[20].toString().equals(null)||InputData[20].toString().equals("")) 
				{
					temp=BuildingGeneration();
					ExtentTestManager.getTest().log(LogStatus.PASS," Step: Building Name Generated >> "+temp);
				}
				else
				{
					temp=InputData[20].toString()+"-"+ String.valueOf(rnd.nextInt(1000));
				}
				SiteValues.put("BuildingName", temp);
				ClearSendKeys(getwebelement(xml.getlocator("//locators/Siebel/BuildingName")), temp);
				ExtentTestManager.getTest().log(LogStatus.PASS," Step: Building Name Entered >> "+temp);
				waitforPagetobeenable();
		
				//House Number
				if(InputData[18].toString().equals(null)||InputData[18].toString().equals("")) 
				{
					temp=HouseNoGeneration();
					ExtentTestManager.getTest().log(LogStatus.PASS," Step: House Number Generated >> "+temp);
				}
				else
				{
					temp=InputData[18].toString()+"-"+ String.valueOf(rnd.nextInt(1000));
				}
				ClearSendKeys(getwebelement(xml.getlocator("//locators/Siebel/RoomName")), temp);
				ExtentTestManager.getTest().log(LogStatus.PASS," Step: Room Name Entered >> "+temp);
				waitforPagetobeenable();
				SiteValues.put("Room", temp);
				
				//Floor 
				int floor =rnd.nextInt((20 - 1) + 1) + 1;
				System.out.println(String.valueOf(floor));
				WaitforElementtobeclickable(xml.getlocator("//locators/Siebel/Floor"));		
				ClearSendKeys(getwebelement(xml.getlocator("//locators/Siebel/Floor")), String.valueOf(floor));
				ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select Floor >> "+String.valueOf(floor));
				waitforPagetobeenable();
				SiteValues.put("Floor", temp);
				
				WaitforElementtobeclickable(xml.getlocator("//locators/Siebel/SaveAddress"));
				Clickon(getwebelement(xml.getlocator("//locators/Siebel/SaveAddress")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Save New Building & Site");
				Thread.sleep(10000);
				waitforPagetobeenable();
				
				return SiteValues;
		//}
				
	}
	//NewWith Hub And Spoke
	public HashMap<String, String> AddSiteAndBuildingNew(Object[] InputData) throws InterruptedException, DocumentException, IOException {
		
		HashMap<String, String> SiteValues=new HashMap<>();
		String StreetName=InputData[19].toString();
		String ProductName=InputData[8].toString();
		if(ProductName.equals("IP Voice Solutions")||ProductName.equals("IP Voice Solutions"))
		{
			return SiteValues;
		}
		else
		{
		WaitforElementtobeclickable(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "Street Name"));
		if(StreetName.equals(null)||StreetName.equals(""))
		{
			
		}
		ClearSendKeys(getwebelement(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "Street Name")),
				InputData[19].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Street: " + InputData[19].toString());

		WaitforElementtobeclickable(xmlS.getlocator("//locators/R4/SearchDropdown").replace("Value", "Country"));
		Clickon(getwebelement(xmlS.getlocator("//locators/R4/SearchDropdown").replace("Value", "Country")));
		Clickon(getwebelement(
				xmlS.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[16].toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Country: " + InputData[16].toString());

		WaitforElementtobeclickable(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "City / Town"));
		ClearSendKeys(getwebelement(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "City / Town")),
				InputData[17].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter City/Town : " + InputData[17].toString());

		WaitforElementtobeclickable(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "Postal Code"));
		ClearSendKeys(getwebelement(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "Postal Code")),
				InputData[21].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Postal Code : " + InputData[21].toString());

		WaitforElementtobeclickable(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "Premises"));
		ClearSendKeys(getwebelement(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "Premises")),
				InputData[22].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Premises : " + InputData[22].toString());

		WaitforElementtobeclickable(xmlS.getlocator("//locators/R4/SearchButton"));
		Clickon(getwebelement(xmlS.getlocator("//locators/R4/SearchButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search");
		waitforPagetobeenable();

		WaitforElementtobeclickable(xml.getlocator("//locators/Siebel/AddressNotFound"));
		Clickon(getwebelement(xml.getlocator("//locators/Siebel/AddressNotFound")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Address Not Found? Search Address Doctor");
		waitforPagetobeenable();
		waitForpageload();
		
		WaitforElementtobeclickable(xml.getlocator("//locators/Siebel/Addaddress"));
		Clickon(getwebelement(xml.getlocator("//locators/Siebel/Addaddress")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Address Not Found? Create a new Address");
		waitforPagetobeenable();
		
		WaitforElementtobeclickable(xml.getlocator("//locators/Siebel/SaveAddress"));
		Clickon(getwebelement(xml.getlocator("//locators/Siebel/SaveAddress")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Save Address");
		waitforPagetobeenable();
		
		WaitforElementtobeclickable(xml.getlocator("//locators/Siebel/Addaddress"));
		Clickon(getwebelement(xml.getlocator("//locators/Siebel/Addaddress")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Building Not Found? Create a new Building");
		waitforPagetobeenable();
		
		
		//Fill Building Details
		
		//Building  Name
				if(InputData[20].toString().equals(null)||InputData[20].toString().equals("")) 
				{
					temp=BuildingGeneration();
					ExtentTestManager.getTest().log(LogStatus.PASS," Step: Building Name Generated >> "+temp);
				}
				else
				{
					temp=InputData[20].toString()+"-"+ String.valueOf(rnd.nextInt(1000));
				}
				SiteValues.put("BuildingName", temp);
				ClearSendKeys(getwebelement(xml.getlocator("//locators/Siebel/BuildingName")), temp);
				ExtentTestManager.getTest().log(LogStatus.PASS," Step: Building Name Entered >> "+temp);
				waitforPagetobeenable();
		
				//House Number
				if(InputData[18].toString().equals(null)||InputData[18].toString().equals("")) 
				{
					temp=HouseNoGeneration();
					ExtentTestManager.getTest().log(LogStatus.PASS," Step: House Number Generated >> "+temp);
				}
				else
				{
					temp=InputData[18].toString()+"-"+ String.valueOf(rnd.nextInt(1000));
				}
				ClearSendKeys(getwebelement(xml.getlocator("//locators/Siebel/RoomName")), temp);
				ExtentTestManager.getTest().log(LogStatus.PASS," Step: Room Name Entered >> "+temp);
				waitforPagetobeenable();
				SiteValues.put("Room", temp);
				
				//Floor 
				int floor =rnd.nextInt((20 - 1) + 1) + 1;
				System.out.println(String.valueOf(floor));
				WaitforElementtobeclickable(xml.getlocator("//locators/Siebel/Floor"));		
				ClearSendKeys(getwebelement(xml.getlocator("//locators/Siebel/Floor")), String.valueOf(floor));
				ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select Floor >> "+String.valueOf(floor));
				waitforPagetobeenable();
				SiteValues.put("Floor", temp);
				
				WaitforElementtobeclickable(xml.getlocator("//locators/Siebel/SaveAddress"));
				Clickon(getwebelement(xml.getlocator("//locators/Siebel/SaveAddress")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Save New Building & Site");
				waitforPagetobeenable();
				waitForpageload();
				Thread.sleep(10000);
				return SiteValues;
		}	
	}

	public void BuildingVerificationInSiebel(HashMap<String, String> sitedetails,Object[] InputData) throws InterruptedException, DocumentException, IOException
	{
		String ProductName = InputData[8].toString();
		
		/*if(ProductName.equalsIgnoreCase("Ethernet Spoke")||ProductName.equalsIgnoreCase("Ethernet Hub")||ProductName.equalsIgnoreCase("Ethernet Line")||ProductName.equalsIgnoreCase("Wave"))
		{
			WaitforElementtobeclickable(xml.getlocator("//locators/Hub/Street"));
			ClearSendKeys(getwebelement(xml.getlocator("//locators/Hub/Street")),InputData[19].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Street: " + InputData[19].toString());
			waitforPagetobeenable();

			WaitforElementtobeclickable(xml.getlocator("//locators/Hub/Country"));
			Select(getwebelement(xml.getlocator("//locators/Hub/Country")), InputData[16].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Country: " + InputData[16].toString());
			waitforPagetobeenable();

			WaitforElementtobeclickable(xml.getlocator("//locators/Hub/City"));
			ClearSendKeys(getwebelement(xml.getlocator("//locators/Hub/City")),InputData[17].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter City/Town : " + InputData[17].toString());
			waitforPagetobeenable();

			WaitforElementtobeclickable(xml.getlocator("//locators/Hub/Postal"));
			ClearSendKeys(getwebelement(xml.getlocator("//locators/Hub/Postal")),InputData[21].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Postal Code : " + InputData[21].toString());
			waitforPagetobeenable();

			WaitforElementtobeclickable(xml.getlocator("//locators/Hub/Premises"));
			ClearSendKeys(getwebelement(xml.getlocator("//locators/Hub/Premises")),InputData[22].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Premises : " + InputData[22].toString());
			waitforPagetobeenable();

			WaitforElementtobeclickable(xml.getlocator("//locators/Hub/Search"));
			Clickon(getwebelement(xml.getlocator("//locators/Hub/Search")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search");
			waitforPagetobeenable();
			// Pick Row
			 List<WebElement> HeaderList=GetWebElements(xml.getlocator("//locators/Hub/GridRowHeader"));
			  
			  int BuidingNameIndex=-1;
			  int i=0;
			  for(WebElement ele :HeaderList)
			  {
				 String ColText=ele.getText();
				  if(ColText.equalsIgnoreCase("Building Name"))
				 {
					 BuidingNameIndex=i;
					 break;
				 }
				 i++;
			  }
			  Assert.assertTrue(BuidingNameIndex>-1, "Column Name 'Building ID' and 'Building Name' not found");
			  String BuildingNameAssigned=sitedetails.get("BuildingName");
			  String BuildingNameFetched=null;
			  int count=getwebelementscount(xml.getlocator("//locators/Hub/TotalRow"));
			
			  Boolean flag=false;
			 
			  for(int j=count-1;j>=0;j--) 
			  {
				  i=j+1; 
				  temp=xml.getlocator("//locators/Hub/GridBuildingRow").replace("-100", String.valueOf(j+1)).replace("-200", String.valueOf(BuidingNameIndex+1));
				  BuildingNameFetched=Gettext(getwebelement(temp));
				  System.out.println("Building Name : "+BuildingNameFetched);
				  
				  if( BuildingNameFetched.equalsIgnoreCase(BuildingNameAssigned))
				  {
					  flag=true;
					  break;
				  }
			  }
			//
			temp=xml.getlocator("//locators/Hub/BuildingRow").replace("-100", String.valueOf(i+1));
			WaitforElementtobeclickable(temp);
			Clickon(getwebelement(temp));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selcet Row");
			waitforPagetobeenable();
			waitForpageload();
			
			WaitforElementtobeclickable(xml.getlocator("//locators/Hub/Pick"));
			Clickon(getwebelement(xml.getlocator("//locators/Hub/Pick")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick");
			waitforPagetobeenable();
			
			// Building ID and Buidling Name
			HeaderList=GetWebElements(xml.getlocator("//locators/Hub/GridRowHeader"));
			int BuidingIDIndex=-1;
			BuidingNameIndex=-1;
			i=0;
			  for(WebElement ele :HeaderList)
			  {
				 String ColText=ele.getText();
				 if(ColText.equalsIgnoreCase("Building ID"))
				 {
					 BuidingIDIndex=i;
				 }
				 else if(ColText.equalsIgnoreCase("Building Name"))
				 {
					 BuidingNameIndex=i;
				 }
				 if(BuidingIDIndex>-1&&BuidingNameIndex>-1)
					 break;
				 i++;
			  }
			  Assert.assertTrue(BuidingIDIndex>-1&&BuidingNameIndex>-1, "Column Name 'Building ID' and 'Building Name' not found");
			  String BuildingIdAssigned=sitedetails.get("BuildingID");
			  BuildingNameAssigned=sitedetails.get("BuildingName");
			  
			  String BuildingIdFetched=null;
			  BuildingNameFetched=null;
			  
			  count=getwebelementscount(xml.getlocator("//locators/Hub/TotalRow"));
			
			  flag=false;
			  i=0;
			  for(int j=count-1;j>=0;j--) 
			  {
				  i=j+1;
				  String temp=xml.getlocator("//locators/Hub/GridBuildingRow").replace("-100", String.valueOf(j+1)).replace("-200", String.valueOf(BuidingIDIndex+1));
				  BuildingIdFetched=Gettext(getwebelement(temp));
				  System.out.println("Building ID : "+BuildingIdFetched);
				  
				  temp=xml.getlocator("//locators/Hub/GridBuildingRow").replace("-100", String.valueOf(j+1)).replace("-200", String.valueOf(BuidingNameIndex+1));
				  BuildingNameFetched=Gettext(getwebelement(temp));
				  System.out.println("Building Name : "+BuildingNameFetched);
				  
				  if((BuildingIdFetched.equalsIgnoreCase(BuildingIdAssigned))&& (BuildingNameFetched.equalsIgnoreCase(BuildingNameAssigned)))
				  {
					  flag=true;
					  break;
				  }
			  }
			  Assert.assertTrue(flag,"Building ID : "+BuildingIdAssigned+ " not verified in siebel" );
			  ExtentTestManager.getTest().log(LogStatus.PASS, "Newly Created Site("+BuildingIdAssigned+","+BuildingNameAssigned+" verified in siebel");
			 	
			  String temp=xml.getlocator("//locators/Hub/BuildingRow").replace("-100", String.valueOf(i));
			  Clickon(getwebelement(temp));
			//
			
			WaitforElementtobeclickable(xml.getlocator("//locators/Hub/PickBuilding"));
			Clickon(getwebelement(xml.getlocator("//locators/Hub/PickBuilding")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick");
			waitforPagetobeenable();
		
		}
		else
		{*/
		/*WaitforElementtobeclickable(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "Street Name"));
		Clear(getwebelement(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "Street Name")));
		SendKeys(getwebelement(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "Street Name")),
				InputData[19].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Street: " + InputData[19].toString());

		WaitforElementtobeclickable(xmlS.getlocator("//locators/R4/SearchDropdown").replace("Value", "Country"));
		Clickon(getwebelement(xmlS.getlocator("//locators/R4/SearchDropdown").replace("Value", "Country")));
		Clickon(getwebelement(
				xmlS.getlocator("//locators/R4/SiteABSelection").replace("Value", InputData[16].toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Country: " + InputData[16].toString());

		WaitforElementtobeclickable(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "City / Town"));
		Clear(getwebelement(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "City / Town")));
		SendKeys(getwebelement(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "City / Town")),
				InputData[17].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter City/Town : " + InputData[17].toString());

		WaitforElementtobeclickable(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "Postal Code"));
		Clear(getwebelement(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "Postal Code")));
		SendKeys(getwebelement(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "Postal Code")),
				InputData[21].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Postal Code : " + InputData[21].toString());

		WaitforElementtobeclickable(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "Premises"));
		Clear(getwebelement(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "Premises")));
		SendKeys(getwebelement(xmlS.getlocator("//locators/R4/SearchInput").replace("Value", "Premises")),
				InputData[22].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Premises : " + InputData[22].toString());	
		 */
		WaitforElementtobeclickable(xmlS.getlocator("//locators/R4/SearchButton"));
		Clickon(getwebelement(xmlS.getlocator("//locators/R4/SearchButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search");
		waitforPagetobeenable();
		
		waitforPagetobeenable();

		WaitforElementtobeclickable(xmlS.getlocator("//locators/R4/SearchAddressRowSelection"));
		Clickon(getwebelement(xmlS.getlocator("//locators/R4/SearchAddressRowSelection")));

		WaitforElementtobeclickable(xmlS.getlocator("//locators/R4/PickAddress"));
		Clickon(getwebelement(xmlS.getlocator("//locators/R4/PickAddress")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Row and Pick Address");
		waitforPagetobeenable();
		
		
	  List<WebElement> HeaderList=GetWebElements(xml.getlocator("//locators/Siebel/SiteGridHeader"));
	  int BuidingIDIndex=-1;
	  int BuidingNameIndex=-1;
	  int i=0;
	  for(WebElement ele :HeaderList)
	  {
		 String ColText=ele.getText();
		 if(ColText.equalsIgnoreCase("Building ID"))
		 {
			 BuidingIDIndex=i;
		 }
		 else if(ColText.equalsIgnoreCase("Building Name"))
		 {
			 BuidingNameIndex=i;
		 }
		 if(BuidingIDIndex>-1&&BuidingNameIndex>-1)
			 break;
		 i++;
	  }
	  Assert.assertTrue(BuidingIDIndex>-1&&BuidingNameIndex>-1, "Column Name 'Building ID' and 'Building Name' not found");
	  String BuildingIdAssigned=sitedetails.get("BuildingID");
	  String BuildingNameAssigned=sitedetails.get("BuildingName");
	  
	  String BuildingIdFetched=null;
	  String BuildingNameFetched=null;
	  
	  int count=getwebelementscount(xml.getlocator("//locators/Siebel/SiteGridDataRow"));
	
	  Boolean flag=false;
	 
	  for(int j=count-1;j>=0;j--) 
	  {
		  i=j+1;
		  String temp=xml.getlocator("//locators/Siebel/SiteGridTD").replace("-100", String.valueOf(j+1)).replace("-200", String.valueOf(BuidingIDIndex+1));
		  BuildingIdFetched=Gettext(getwebelement(temp));
		  System.out.println("Building ID : "+BuildingIdFetched);
		  
		  temp=xml.getlocator("//locators/Siebel/SiteGridTD").replace("-100", String.valueOf(j+1)).replace("-200", String.valueOf(BuidingNameIndex+1));
		  BuildingNameFetched=Gettext(getwebelement(temp));
		  System.out.println("Building Name : "+BuildingNameFetched);
		  
		  if((BuildingIdFetched.equalsIgnoreCase(BuildingIdAssigned))&& (BuildingNameFetched.equalsIgnoreCase(BuildingNameAssigned)))
		  {
			  flag=true;
			  break;
		  }
	  }
	  Assert.assertTrue(flag,"Building ID : "+BuildingIdAssigned+ " not verified in siebel" );
	  ExtentTestManager.getTest().log(LogStatus.PASS, "Newly Created Site("+BuildingIdAssigned+","+BuildingNameAssigned+" verified in siebel");
	 	
	  String temp=xml.getlocator("//locators/Siebel/SiteGridRow").replace("-100", String.valueOf(i));
	  Clickon(getwebelement(temp));
	  
	  WaitforElementtobeclickable(xml.getlocator("//locators/Siebel/SaveAddress"));
	  Clickon(getwebelement(xml.getlocator("//locators/Siebel/SaveAddress")));
	  ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Address");
	  waitforPagetobeenable();
		
	  ExtentTestManager.getTest().log(LogStatus.PASS, "Buidling Verfication Done");
	  System.out.println("Buidling Verfication Done");
		//}
	}
	public void ClickSitesSearch(Object[] InputData) throws InterruptedException, DocumentException {
	
		waitForpageload();
		waitforPagetobeenable();
		System.out.println(gettitle());
		String ProductName = InputData[8].toString();
			if(ProductName.equalsIgnoreCase("Ethernet Spoke"))
			{
				WaitforElementtobeclickable(xml.getlocator("//locators/Hub/HubSiteB"));
				Clickon(getwebelement(xml.getlocator("//locators/Hub/HubSiteB")));
			}
			/*else if(ProductName.equalsIgnoreCase("Ethernet Hub")||ProductName.equalsIgnoreCase("Wave")||ProductName.equalsIgnoreCase("Ethernet Line"))
			{
			WaitforElementtobeclickable(xml.getlocator("//locators/Hub/HubSiteA"));
			Clickon(getwebelement(xml.getlocator("//locators/Hub/HubSiteA")));
			}*/
			else if(ProductName.equalsIgnoreCase("Voice Line V"))
			{
				Clickon(getwebelement(xmlS.getlocator("//locators/OtherTab")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on OtherTab");
				Thread.sleep(5000);
				
				WaitforElementtobeclickable(xmlS.getlocator("//locators/R4/RightSiteSearch"));
				Clickon(getwebelement(xmlS.getlocator("//locators/R4/RightSiteSearch")));
			}
			else
			{
			WaitforElementtobeclickable(xmlS.getlocator("//locators/R4/LeftSiteSearch"));
			Clickon(getwebelement(xmlS.getlocator("//locators/R4/LeftSiteSearch")));
			}
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Search Site");
			waitforPagetobeenable(); 
	}
	public void SearchSiteHubSpoke(Object[] InputData) throws InterruptedException, DocumentException {
		waitForpageload();
		waitforPagetobeenable();
		System.out.println(gettitle());
		String ProductName = InputData[8].toString();
		if(ProductName.equalsIgnoreCase("Ethernet Hub"))
		{
			WaitforElementtobeclickable(xml.getlocator("//locators/Hub/HubSiteA"));
			Clickon(getwebelement(xml.getlocator("//locators/Hub/HubSiteA")));
		}
		else
		{
		WaitforElementtobeclickable(xml.getlocator("//locators/Hub/HubSiteB"));
		Clickon(getwebelement(xml.getlocator("//locators/Hub/HubSiteB")));
		}
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Search Site");
		waitforPagetobeenable(); // added by Ayush
	}

	public void SiteVerifcationInSibel(Object[] InputData,String SiteID) throws DocumentException, InterruptedException, IOException 
	{
		String ProductName = InputData[8].toString();
		if(ProductName.equalsIgnoreCase("Ethernet Spoke")||ProductName.equalsIgnoreCase("Ethernet Hub")||ProductName.equalsIgnoreCase("Ethernet Line")||ProductName.equalsIgnoreCase("Wave"))
		{
			WaitforElementtobeclickable(xml.getlocator("//locators/Hub/AddressRow"));
			Clickon(getwebelement(xml.getlocator("//locators/Hub/AddressRow")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Row");
			waitforPagetobeenable();
			
			WaitforElementtobeclickable(xml.getlocator("//locators/Hub/PickSite"));
			Clickon(getwebelement(xml.getlocator("//locators/Hub/PickSite")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick");
			waitforPagetobeenable();
		}
		else
		{
		  System.out.println("Site Verfication Started");
		  ExtentTestManager.getTest().log(LogStatus.PASS, "Site Verfication Started");
		  List<WebElement> HeaderList=GetWebElements(xml.getlocator("//locators/Siebel/SiteGridHeader"));
		  int SiteIDIndex=-1;
		  int SiteStatusIndex=-1;
		  int i=0;
		  for(WebElement ele :HeaderList)
		  {
			 String ColText=ele.getText();
			 if(ColText.equalsIgnoreCase("Site ID"))
			 {
				 SiteIDIndex=i;
			 }
			 else if(ColText.equalsIgnoreCase("Site Status"))
			 {
				 SiteStatusIndex=i;
			 }
			 if(SiteIDIndex>-1&&SiteStatusIndex>-1)
				 break;
			 i++;
		  }
		  System.out.println("Site ID Index : "+SiteIDIndex);
		  System.out.println("Site Status Index : "+SiteStatusIndex);
		  
		  Assert.assertTrue(SiteIDIndex>-1&&SiteStatusIndex>-1, "Column Name 'Building ID' and 'Building Name' not found");
		  String SiteStatus=InputData[28].toString();
		  
		  String SiteIdFetched=null;
		  String SiteStatusFetched=null;
		  
		  int count=getwebelementscount(xml.getlocator("//locators/Siebel/SiteGridDataRow"));
			
		  Boolean flag=false;
		 
		  for(int j=count-1;j>=0;j--) 
		  {
			  i=j+1;
			  String temp=xml.getlocator("//locators/Siebel/SiteGridTD").replace("-100", String.valueOf(j+1)).replace("-200", String.valueOf(SiteIDIndex+1));
			  SiteIdFetched=Gettext(getwebelement(temp));
			  System.out.println("Building ID : "+SiteIdFetched);
			  
			  temp=xml.getlocator("//locators/Siebel/SiteGridTD").replace("-100", String.valueOf(j+1)).replace("-200", String.valueOf(SiteStatusIndex+1));
			  SiteStatusFetched=Gettext(getwebelement(temp));
			  System.out.println("Building Name : "+SiteStatusFetched);
			  
			  if((SiteIdFetched.equalsIgnoreCase(SiteID))&& (SiteStatusFetched.equalsIgnoreCase(SiteStatus)))
			  {
				  flag=true;
				  break;
			  }
		  }
		  Assert.assertTrue(flag,"Building ID : "+SiteID+ " not verified in siebel" );
		  ExtentTestManager.getTest().log(LogStatus.PASS, "Newly Created Site("+SiteID+","+SiteStatus+" verified in siebel");
		  
		  String temp=xml.getlocator("//locators/Siebel/SiteGridRow").replace("-100", String.valueOf(i));
		  Clickon(getwebelement(temp));
		  
		  WaitforElementtobeclickable(xml.getlocator("//locators/Siebel/SaveAddress"));
		  Clickon(getwebelement(xml.getlocator("//locators/Siebel/SaveAddress")));
		  ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Pick Address");
		  waitForpageload();
		  waitforPagetobeenable();
		  Thread.sleep(10000);
		}
		  
	}
	
	public void SiteUpdateVerification(String PreSiteID, String SblSiteID)
	{
		Assert.assertTrue(PreSiteID.equalsIgnoreCase(SblSiteID)," PremiseMaster SiteID: "+PreSiteID+ " not matched With Update  in siebel Site ID : "+SblSiteID );
		ExtentTestManager.getTest().log(LogStatus.PASS, "Verified Updated PremiseMaster SiteID: "+PreSiteID+ " matched With Update  in siebel Site ID : "+SblSiteID );
		
	}
	
	
	public String SiteidReference(Object[] InputData) throws IOException, InterruptedException, DocumentException
	{
		waitForpageload();
		waitforPagetobeenable();
		Thread.sleep(10000);
		String SiteId=null;
		String ProductName = InputData[8].toString();
		if(ProductName.equalsIgnoreCase("Ethernet Spoke"))
		{
			SiteId=Getattribute(getwebelement(xml.getlocator("//locators/Hub/SiteIDB")),"innerHTML");
			System.out.println("Site Id : " + SiteId);
		}
		else if(ProductName.equalsIgnoreCase("Ethernet Hub")||ProductName.equalsIgnoreCase("Ethernet Line")||ProductName.equalsIgnoreCase("Wave"))
		{
			SiteId=Getattribute(getwebelement(xml.getlocator("//locators/Hub/SiteIDA")),"title");
			System.out.println("Site Id : " + SiteId);
		}
		else if(ProductName.equalsIgnoreCase("Voice Line V"))
		{
			SiteId=Getattribute(getwebelement(xml.getlocator("//locators/Siebel/SiteIDB")),"innerHTML");
			System.out.println("Site Id : " + SiteId);
		}
		else
		{
		SiteId=Getattribute(getwebelement(xml.getlocator("//locators/Siebel/SiteID")),"innerHTML");
		System.out.println("Site Id : " + SiteId);
		}
		String[] parts=SiteId.split("<");
		System.out.println("Site Id : "+ parts[0]);
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Site Reference ID Generated :"+parts[0]);
		return parts[0];
		}
	
	public void PremiseMasterAppOpen()
	{
		ExtentTestManager.getTest().log(LogStatus.PASS,"<----------------------------- PremiseMaster Application Open----------------------------->");	
	}
	public void PremiseMasterAppClosed()
	{
		ExtentTestManager.getTest().log(LogStatus.PASS,"<----------------------------- PremiseMaster Application Closed----------------------------->");	
	}
	
	public void ClickSearch() throws InterruptedException, DocumentException
	{
		String attribute=null;
		WaitforElementtobeclickable(xml.getlocator("//locators/SearchLocation/SearchButton"));
		Clickon(getwebelement(xml.getlocator("//locators/SearchLocation/SearchButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Click on Search");
		int loop=1;
		do
		{
			Thread.sleep(3000);
			Moveon(getwebelement(xml.getlocator("//locators/SearchLocation/State")));
			waitForpageload();
			loop++;
			if(Getattribute(getwebelement(xml.getlocator("//locators/SearchLocation/SearchAgain")), "value").equalsIgnoreCase("Submit"))
				break;
			else
			{
				Clickon(getwebelement(xml.getlocator("//locators/SearchLocation/SearchAgain")));
				ExtentTestManager.getTest().log(LogStatus.PASS," Step: Click on Search Again");
			}
			attribute=Getattribute(getwebelement(xml.getlocator("//locators/SearchLocation/SearchAgain")), "value");
		}while(!attribute.equalsIgnoreCase("Submit") && loop<5);
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Attribute Verified : "+attribute);
		
		Clickon(getwebelement(xml.getlocator("//locators/SearchLocation/SearchAgain")));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Click on Submit button ");
	}
	public void CreateSite() throws InterruptedException, DocumentException
	{
		waitForpageload();
		WaitforElementtobeclickable(xml.getlocator("//locators/CreateSite/Create"));
		Clickon(getwebelement(xml.getlocator("//locators/CreateSite/Create")));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Click on Create Site Link ");
	}
	public void EnterSiteDetails(Object[] InputData) throws InterruptedException, IOException, DocumentException
	{
		// Building Type
		System.out.println(InputData[23].toString());
		
		String BuildingType=InputData[23].toString();
		
		WaitforElementtobeclickable(xml.getlocator("//locators/CreateSite/BuildingType"));		
		Select2(getwebelement(xml.getlocator("//locators/CreateSite/BuildingType")), InputData[23].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select Building Type >> "+InputData[23].toString());
		waitforPagetobeenable();
		
		// Status 
		System.out.println(InputData[24].toString());
		WaitforElementtobeclickable(xml.getlocator("//locators/CreateSite/BuildingStatus"));		
		Select2(getwebelement(xml.getlocator("//locators/CreateSite/BuildingStatus")), InputData[24].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select Building Status Type >> "+InputData[24].toString());
		waitforPagetobeenable();
		
		//Access Type
		System.out.println(InputData[25].toString());
		WaitforElementtobeclickable(xml.getlocator("//locators/CreateSite/AccessType"));		
		Select2(getwebelement(xml.getlocator("//locators/CreateSite/AccessType")), InputData[25].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select Access Type >> "+InputData[25].toString());
		waitforPagetobeenable();
		
		//Building Category
		System.out.println(InputData[26].toString());
		WaitforElementtobeclickable(xml.getlocator("//locators/CreateSite/BuildingCategory"));		
		Select2(getwebelement(xml.getlocator("//locators/CreateSite/BuildingCategory")), InputData[26].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select Building Category Type >> "+InputData[26].toString());
		waitforPagetobeenable();
		
		if(BuildingType.equalsIgnoreCase("On Net"))
		{   
			//Schema
			System.out.println(InputData[29].toString());
			WaitforElementtobeclickable(xml.getlocator("//locators/CreateSite/Schema"));		
			Select2(getwebelement(xml.getlocator("//locators/CreateSite/Schema")), InputData[29].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select CNMT Schema Type >> "+InputData[29].toString());
			waitforPagetobeenable();
			
			//Existing Street
			System.out.println(InputData[30].toString());
			WaitforElementtobeclickable(xml.getlocator("//locators/CreateSite/StreetName"));		
			Select(getwebelement(xml.getlocator("//locators/CreateSite/StreetName")), InputData[30].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select CNMT Street Name >> "+InputData[30].toString());
			waitforPagetobeenable();
			
			//CNMT Settlement
			System.out.println(InputData[26].toString());
			ClearSendKeys(getwebelement(xml.getlocator("//locators/CreateSite/SettlementName")), InputData[31].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select CNMT Street Name >> "+InputData[31].toString());
			waitforPagetobeenable();
		}
		
		//Site Type
		System.out.println(InputData[27].toString());
		WaitforElementtobeclickable(xml.getlocator("//locators/CreateSite/SiteType"));		
		Select2(getwebelement(xml.getlocator("//locators/CreateSite/SiteType")), InputData[27].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select Site Type >> "+InputData[27].toString());
		waitforPagetobeenable();
		
		//Floor 
		int floor =rnd.nextInt((20 - 1) + 1) + 1;
		System.out.println(String.valueOf(floor));
		WaitforElementtobeclickable(xml.getlocator("//locators/CreateSite/Floor"));		
		Select2(getwebelement(xml.getlocator("//locators/CreateSite/Floor")), String.valueOf(floor));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select Floor >> "+String.valueOf(floor));
		waitforPagetobeenable();
		
		if(BuildingType.equalsIgnoreCase("On Net"))
		{
		//Man City Code
			System.out.println(InputData[32].toString());
			WaitforElementtobeclickable(xml.getlocator("//locators/CreateSite/CityID"));		
			Select(getwebelement(xml.getlocator("//locators/CreateSite/CityID")), InputData[32].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select CityID >> "+InputData[32].toString());
			waitforPagetobeenable();
		
			//OCN
			System.out.println(InputData[33].toString());
			ClearSendKeys(getwebelement(xml.getlocator("//locators/CreateSite/OCN")), InputData[33].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select OCN >> "+InputData[33].toString());
			waitforPagetobeenable();
			
			//AccessID
			/*System.out.println(InputData[32].toString());
			WaitforElementtobeclickable(xml.getlocator("//locators/CreateSite/AccessID"));		
			Select(getwebelement(xml.getlocator("//locators/CreateSite/AccessID")), InputData[34].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select CityID >> "+InputData[34].toString());
			waitforPagetobeenable();*/
		}
	//	else if(BuildingType.equalsIgnoreCase("NearNet"))
	//	{
		//Status 
		System.out.println(InputData[28].toString());
		WaitforElementtobeclickable(xml.getlocator("//locators/CreateSite/Status"));		
		Select2(getwebelement(xml.getlocator("//locators/CreateSite/Status")), InputData[28].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select Status Type >> "+InputData[28].toString());
		waitforPagetobeenable();
	//	}
		int Room =rnd.nextInt((50 - 1) + 1) + 1;
		System.out.println(String.valueOf(Room));
		Waitforvisibilityofelement(xml.getlocator("//locators/CreateSite/roomId"));		
		ClearSendKeys(getwebelement(xml.getlocator("//locators/CreateSite/roomId")),String.valueOf(Room));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Entered Room  >> "+Room);
		//waitforPagetobeenable();
		
		WaitforElementtobeclickable(xml.getlocator("//locators/CreateSite/Submit"));		
		Clickon(getwebelement(xml.getlocator("//locators/CreateSite/Submit")));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Click On Create Bulding and Site ");
		
		waitForpageload();
		BuildingID=	Gettext(getwebelement(xml.getlocator("//locators/CreateSite/BuildingID")));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Genrated Site/Building ID : " +BuildingID);
		System.out.println(BuildingID);
		
	}
	
	public void SearchSiteAndVerified(Object[] InputData) throws Exception
	{
		waitForpageload();
		ClickTopMeu("Search");
		
		waitForpageload();
		System.out.println(InputData[34].toString());
		
		WaitforElementtobeclickable(xml.getlocator("//locators/SearchSite/SearchType"));		
		Select2(getwebelement(xml.getlocator("//locators/SearchSite/SearchType")), InputData[34].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select Search Type >> "+InputData[34].toString());
		
		ClearSendKeys(getwebelement(xml.getlocator("//locators/SearchSite/SearchValue")), BuildingID);
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Enter Search Value >> "+BuildingID);
		
		WaitforElementtobeclickable(xml.getlocator("//locators/SearchSite/Submit"));		
		Clickon(getwebelement(xml.getlocator("//locators/SearchSite/Submit")));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Click On Create Bulding and Site ");
		
		waitForpageload();
		
		String Id=Gettext(getwebelement(xml.getlocator("//locators/SearchSite/SearchResultId")));
		assertTrue(BuildingID.equalsIgnoreCase(Id), "Search ID : "+BuildingID+"!="+Id);
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Verified Search ID :"+BuildingID+"=="+Id );
		waitForpageload();
		
	}
	
	public String SearchSiteAndVerified(String SiteID) throws Exception
	{
		waitForpageload();
		ClickTopMeu("Search");
		
		waitForpageload();
		System.out.println(SiteID);
		
		WaitforElementtobeclickable(xml.getlocator("//locators/SearchSite/SearchType"));		
		Select2(getwebelement(xml.getlocator("//locators/SearchSite/SearchType")), "SITE");
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select Search Type >> Site");
		
		ClearSendKeys(getwebelement(xml.getlocator("//locators/SearchSite/SearchValue")), SiteID);
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Enter Search Value >> "+SiteID);
		
		WaitforElementtobeclickable(xml.getlocator("//locators/SearchSite/Submit"));		
		Clickon(getwebelement(xml.getlocator("//locators/SearchSite/Submit")));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Click On Create Bulding and Site ");
		
		waitForpageload();
		
		String Id=Gettext(getwebelement(xml.getlocator("//locators/SearchSite/SearchResultId")));
		assertTrue(SiteID.equalsIgnoreCase(Id), "Search ID : "+BuildingID+"!="+Id);
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Verified Search ID :"+SiteID+"=="+Id );
		
		Clickon(getwebelement(xml.getlocator("//locators/SearchSite/SearchResultId")));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Click on Site ID " );
		
		waitForpageload();
		waitforPagetobeenable();
		Waitforvisibilityofelement(xml.getlocator("//locators/SearchSite/BuildingId"));
		String BuildingId=Getattribute(getwebelement2(xml.getlocator("//locators/SearchSite/BuildingId")),"value");
		System.out.println(BuildingId);
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Get Building ID  : "+ BuildingId );
		
		return BuildingId;
		
	}
	
	public void EditSite() throws InterruptedException, DocumentException
	{
		Clickon(getwebelement(xml.getlocator("//locators/SearchSite/SearchResultId")));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Click on Site ID " );
		
		waitForpageload();
		waitforPagetobeenable();
		
		WaitforElementtobeclickable(xml.getlocator("//locators/EditSite/EditLink"));
		Clickon(getwebelement(xml.getlocator("//locators/EditSite/EditLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS," Step: Click Edit Site Link " );
		
		waitForpageload();
		
	}
	
}