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
	private String  HouseNoGeneration ()
	{
		String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char block = abc.charAt(rnd.nextInt(abc.length()));
		int HNo=rnd.nextInt(1000); 
		String temp=  String.valueOf(block)+"-"+String.valueOf(HNo);
		System.out.println("Flat Number Genrated : "+ temp);
		return temp;
	}
	private String  BuildingGeneration ()
	{
		int flatNo=rnd.nextInt(1000); 
		temp=  "TestBuilding-"+String.valueOf(flatNo);
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
	
	public void AddSiteAndBuilding(Object[] InputData) throws InterruptedException, DocumentException, IOException {
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
				
				//Floor 
				int floor =rnd.nextInt((20 - 1) + 1) + 1;
				System.out.println(String.valueOf(floor));
				WaitforElementtobeclickable(xml.getlocator("//locators/Siebel/Floor"));		
				ClearSendKeys(getwebelement(xml.getlocator("//locators/Siebel/Floor")), String.valueOf(floor));
				ExtentTestManager.getTest().log(LogStatus.PASS," Step: Select Floor >> "+String.valueOf(floor));
				waitforPagetobeenable();
				
				WaitforElementtobeclickable(xml.getlocator("//locators/Siebel/SaveAddress"));
				Clickon(getwebelement(xml.getlocator("//locators/Siebel/SaveAddress")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Save New Building & Site");
				waitforPagetobeenable();
				
	}
	
	public String SiteidReference() throws IOException, InterruptedException, DocumentException 
	{
		String SiteId=Getattribute(getwebelement(xml.getlocator("//locators/Siebel/SiteID")),"innerHTML");
		String[] parts=SiteId.split("<");
		//String SiteId=Gettext(getwebelement(xml.getlocator("//locators/Siebel/SiteID")));
		System.out.println("Site Id : "+ parts[0]);
		return SiteId;
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
	}
	
	public void SearchSiteAndVerified(String SiteID) throws Exception
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
