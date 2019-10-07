package Driver;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import ScriptHelper.CancelHelper;
import ScriptHelper.CeasHelper;
import ScriptHelper.InFlightOrderHelper;
//import ScriptHelper.AbandonedOrderOfAllThreeProducts;
//import ScriptHelper.InFlightForIPAccess;
import ScriptHelper.LoginHelper;
//import ScriptHelper.ModifyComOrdersOfAllProductsHelper;
import ScriptHelper.ModHelper;
import ScriptHelper.NewOrderOnnetHelper;
import ScriptHelper.OMPScriptHelper;
import ScriptHelper.EOLorderCompletionHelper;

public class DriverTestcase {

	public static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new InheritableThreadLocal<>();
// public static final ThreadLocal<RemoteWebDriver> WEB_DRIVER_THREAD_LOCAL =
// new InheritableThreadLocal<>();

	public static final ThreadLocal<LoginHelper> Login = new InheritableThreadLocal<>();
	public static final ThreadLocal<NewOrderOnnetHelper> newOrderOnnnet = new InheritableThreadLocal<>();
	public static final ThreadLocal<CancelHelper> Cancel = new InheritableThreadLocal<>();
	public static final ThreadLocal<CeasHelper> Cease = new InheritableThreadLocal<>();
	public static final ThreadLocal<OMPScriptHelper> OmpOrder = new InheritableThreadLocal<>();
	public static final ThreadLocal<InFlightOrderHelper> inFlightGeneric = new InheritableThreadLocal<>();
	public static final ThreadLocal<ModHelper> modHelper = new InheritableThreadLocal<>();
	public static final ThreadLocal<EOLorderCompletionHelper> EOLorderCompletionHelper= new InheritableThreadLocal<>();	//added by gauri
// public static final ThreadLocal<InFlightForIPAccess>inFlight = new InheritableThreadLocal<>();
// public static ThreadLocal<String> QuoteID = new InheritableThreadLocal<>();
	public static Listners.TestListener Testlistener;
// public static CarNorOrderHelper CarNorOrderhelper;
	public ThreadLocal<String> TestName = new ThreadLocal();
	public static SessionId session_id;
	public static ChromeDriver driver;
	public static int itr;

	

	@BeforeMethod
	public void BeforeMethod(Method method, ITestContext ctx, Object[] data) throws IOException, Exception {
		setup();
		Object[] st1 = null;
		System.out.println(data.length);
		try

		{
			st1 = (Object[]) data[0];
			System.out.println("Lenghth of Complete Data provided by DP" + st1.length);
			System.out.println("First Coulum in Data provider for :" + st1[(st1.length) - 2]);
		} catch (Exception e) {
			st1 = new Object[] { "" };
			System.out.println("Exception Thrown:" + e.getMessage());
		}
		Object[] st = null;
		try

		{
			st = (Object[]) st1;
			System.out.println("Length of First Data provided by DP" + st.length);
			System.out.println("First Coulum in Data provider for :" + st[(st.length) - 2]);
		} catch (Exception e) {
			st = new Object[] { "" };
			System.out.println(e.getMessage());
		}
		TestName.set(st[st.length - 2].toString());
		System.out.println(
				"Name for current Thread" + Thread.currentThread().getId() + "is " + TestName.get().toString());
		if (method.getName().equals("EndtoEndOrderOnnet")) {
//   DataReader dt=new DataReader();
//   Object[][] data=dt.ipreader();
//    Object[] st= (Object[]) data[itr][0];
			Log.info(st[st.length - 2].toString());
			System.out.println(st[st.length - 2].toString());
// ctx.getCurrentXmlTest()ctx.getCurrentXmlTest().set

			ctx.setAttribute("testName", TestName.get().toString());
		} else if (method.getName().equals("Mod")) {
//   DataReader dt=new DataReader();
//   Object[][] data=dt.ipreader();
//    Object[] st= (Object[]) data[itr][0];
			Log.info(st[st.length - 2].toString());
			System.out.println(st[st.length - 2].toString());
// ctx.getCurrentXmlTest()ctx.getCurrentXmlTest().set

			ctx.setAttribute("testName", TestName.get().toString());
		} else if (method.getName().equals("Cancel")) {
//   DataReader dt=new DataReader();
//   Object[][] data=dt.ipreader();
//    Object[] st= (Object[]) data[itr][0];
			Log.info(st[st.length - 2].toString());
			System.out.println(st[st.length - 2].toString());
// ctx.getCurrentXmlTest()ctx.getCurrentXmlTest().set

			ctx.setAttribute("testName", TestName.get().toString());
		} else if (method.getName().equals("Cease")) {
//   DataReader dt=new DataReader();
//   Object[][] data=dt.ipreader();
//    Object[] st= (Object[]) data[itr][0];
			Log.info(st[st.length - 2].toString());
			System.out.println(st[st.length - 2].toString());
// ctx.getCurrentXmlTest()ctx.getCurrentXmlTest().set

			ctx.setAttribute("testName", TestName.get().toString());
		} else if (method.getName().equals("inFlightGeneric")) {
//   DataReader dt=new DataReader();
//   Object[][] data=dt.ipreader();
//    Object[] st= (Object[]) data[itr][0];
			Log.info(st[st.length - 2].toString());
			System.out.println(st[st.length - 2].toString());
// ctx.getCurrentXmlTest()ctx.getCurrentXmlTest().set

			ctx.setAttribute("testName", TestName.get().toString());
		} else if (method.getName().equals("OMPGenric")) {
//   DataReader dt=new DataReader();
//   Object[][] data=dt.ipreader();
//    Object[] st= (Object[]) data[itr][0];
			Log.info(st[st.length - 2].toString());
			System.out.println(st[st.length - 2].toString());
// ctx.getCurrentXmlTest()ctx.getCurrentXmlTest().set

			ctx.setAttribute("testName", TestName.get().toString());
		}
		else if (method.getName().equals("createNewEOLOrder")) {
//			DataReader dt=new DataReader();
//			Object[][] data=dt.ipreader();
//		    Object[] st= (Object[]) data[itr][0];
			Log.info(st[st.length - 2].toString());
			ctx.setAttribute("testName", st[st.length - 2].toString());
		}else
			ctx.setAttribute("testName", method.getName());
		Log.info(ctx.getAttribute("testName").toString());
	}

//@BeforeTest
	public void setup() throws IOException, InterruptedException {
// Open Browser
		WebDriver dr = null;
		PropertyReader pr = new PropertyReader();
		String targatedbrowser = pr.readproperty("browser");
		String url = pr.readproperty("URL");
		Log.info("URL");
		if (targatedbrowser.equals("chrome")) {
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			Map<String, Object> prefs = new HashMap<String, Object>();
// Set the notification setting it will override the default setting
			prefs.put("profile.default_content_setting_values.notifications", 2);

// Create object of ChromeOption class
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "none");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
			dr = new ChromeDriver(capabilities);
		} else if (targatedbrowser.equals("ie")) {
			Log.info("For IE inprogress");
		}

		else {
			Log.info("For FF inprogress");
		}

		dr.manage().window().maximize();
		WEB_DRIVER_THREAD_LOCAL.set(dr);
		Thread.sleep(3000);
		EOLorderCompletionHelper EOLC = new EOLorderCompletionHelper(getwebdriver());
		LoginHelper LN = new LoginHelper(getwebdriver());
		NewOrderOnnetHelper NEWO = new NewOrderOnnetHelper(getwebdriver());
		OMPScriptHelper OMP = new OMPScriptHelper(getwebdriver());
		InFlightOrderHelper InFlightOrder = new InFlightOrderHelper(getwebdriver());
		CeasHelper CL = new CeasHelper(getwebdriver());
		CancelHelper CN = new CancelHelper(getwebdriver());
		ModHelper MD = new ModHelper(getwebdriver());
		NewOrderOnnetHelper noo = new NewOrderOnnetHelper(getwebdriver());
// ModifyComOrdersOfAllProductsHelper mooc = new ModifyComOrdersOfAllProductsHelper(getwebdriver());
// AbandonedOrderOfAllThreeProducts aoop = new AbandonedOrderOfAllThreeProducts(getwebdriver());
// InFlightForIPAccess ioc = new InFlightForIPAccess(getwebdriver());
		EOLorderCompletionHelper.set(EOLC);
		Login.set(LN);
		newOrderOnnnet.set(NEWO);
		Cancel.set(CN);
		Cease.set(CL);
		inFlightGeneric.set(InFlightOrder);
		OmpOrder.set(OMP);
		modHelper.set(MD);

// modifyOrdersCom.set(mooc);
// abandonedOrder.set(aoop);
// inFlight.set(ioc);
	}

	@org.testng.annotations.BeforeSuite
	public void BeforeSuite() {
		itr = 0;
		DOMConfigurator.configure("log4j.xml");
	}

//@AfterTest
	public void Teardown() {

		//dr.close();
	}

	@AfterMethod
	public void Teardown2() {
		getwebdriver().close();
		// dr.close();
	}

	public WebDriver getwebdriver() {
		WebDriver dr = WEB_DRIVER_THREAD_LOCAL.get();
		return dr;
	}
}
