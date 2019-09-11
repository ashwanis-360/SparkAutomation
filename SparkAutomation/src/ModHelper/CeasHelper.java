package ModHelper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import Driver.DriverHelper;
import Driver.XMLReader;

import Reporter.ExtentTestManager;



public class CeasHelper extends DriverHelper{
	
	
	
	WebElement el;
	XMLReader xml=new XMLReader("src\\Locators\\Login.xml");
	
	public CeasHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}

	public void Docusign(String url) throws Exception
	{


		Geturl("http://yopmail.com");
		
		SendKeys(getwebelement("//input[@id='login']"),"testingdata");
		Clickon(getwebelement("//input[@value='Check Inbox']"));
		Thread.sleep(4000);
		switchtofram(getwebelement("name=ifinbox"));
		System.out.println("switched to iframe");
		Clickon(getwebelement("//span[contains(text(),'Colt Proposal QT-20190516-031202-01')]/parent::*"));
		switchtodefault();
		System.out.println("Witched to default content");
		Thread.sleep(4000);
		switchtofram(getwebelement("id=ifmail"));
		System.out.println("switched to iframe");
		Clickon(getwebelement("//span[contains(text(),'REVIEW DOCUMENT')]"));
		switchtodefault();
		Switchtotabandsignthequote();
		System.out.println("Witched to default content");
		
	}
//---------------------------------
	public void Login(String Application) throws Exception
	{
		openurl(Application);
		
		Thread.sleep(3000);
		SendKeys(getwebelement(xml.getlocator("//locators/"+Application+"/Username")),Getkeyvalue(Application+"_Username"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter User Name");
		
		SendKeys(getwebelement(xml.getlocator("//locators/"+Application+"/Password")),Getkeyvalue(Application+"_Password"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Password");
		
		Clickon(getwebelement(xml.getlocator("//locators/"+Application+"/Loginbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Login Button");
		
	}
	
	public void VerifySuccessLogin(String application) throws Exception
	{	
		Assert.assertEquals(Getkeyvalue(application+"_LoggedinUser").contains(Gettext(getwebelement(xml.getlocator("//locators/"+application+"/Userinfo")))),true);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Verify Correct user has been logged in");
		System.out.println("Done2");
	}
	
//---------------------------------
//Code for Login	
	public void SiebelLogin(String Application) throws Exception
	{
		openurl(Application);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to "+Application+" Login Page");
		Thread.sleep(10000);
		SendKeys(getwebelement(xml.getlocator("//locators/"+Application+"/SiebelUsername")),Getkeyvalue(Application+"_Username"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter User Name");
		Thread.sleep(2000);
		SendKeys(getwebelement(xml.getlocator("//locators/"+Application+"/SiebelPassword")),Getkeyvalue(Application+"_Password"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Password");
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/"+Application+"/SiebelLoginbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Login Button");
		
	}
	//Code for Login	
		public void CPQLogin(String Application) throws Exception
		{
			openurl(Application);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to "+Application+" Login Page");
			Thread.sleep(10000);
			SendKeys(getwebelement(xml.getlocator("//locators/"+Application+"/SiebelUsername")),Getkeyvalue(Application+"_Username"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter User Name");
			Thread.sleep(2000);
			SendKeys(getwebelement(xml.getlocator("//locators/"+Application+"/SiebelPassword")),Getkeyvalue(Application+"_Password"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Password");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/"+Application+"/SiebelLoginbutton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Login Button");
			
		}


}
