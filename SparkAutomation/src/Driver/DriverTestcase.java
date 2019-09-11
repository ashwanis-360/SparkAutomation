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
//import ScriptHelper.AbandonedOrderOfAllThreeProducts;
//import ScriptHelper.InFlightForIPAccess;
import ScriptHelper.LoginHelper;
//import ScriptHelper.ModifyComOrdersOfAllProductsHelper;

import ScriptHelper.NewOrderOnnetHelper;
//import Testscript.InflightOrderCompletion;

public class DriverTestcase {

	public static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new InheritableThreadLocal<>();
	// public static final ThreadLocal<RemoteWebDriver> WEB_DRIVER_THREAD_LOCAL =
	// new InheritableThreadLocal<>();

	public static final ThreadLocal<LoginHelper> Login = new InheritableThreadLocal<>();
	public static final ThreadLocal<NewOrderOnnetHelper> newOrderOnnnet = new InheritableThreadLocal<>();
public static final ThreadLocal<CancelHelper> Cancel = new InheritableThreadLocal<>();
public static final ThreadLocal<CeasHelper> Cease = new InheritableThreadLocal<>();
//	public static final ThreadLocal<InFlightForIPAccess>inFlight = new InheritableThreadLocal<>();
//	public static ThreadLocal<String> QuoteID = new InheritableThreadLocal<>();
	public static Listners.TestListener Testlistener;
	// public static CarNorOrderHelper CarNorOrderhelper;
	public ThreadLocal<String> TestName = new ThreadLocal();
	public static SessionId session_id;
	public static ChromeDriver driver;
	public static int itr;

	@BeforeMethod
	public void BeforeMethod(Method method, ITestContext ctx, Object[] data) throws IOException, Exception {
		setup();
		Object[] st = null;

		try

		{
			st = (Object[]) data[0];
		} catch (Exception e) {
			st = new Object[][] { { "" } };
		}

if (method.getName().equals("EndtoEndOrderOnnet")) {
//	   		DataReader dt=new DataReader();
//	   		Object[][] data=dt.ipreader();
//		    Object[] st= (Object[]) data[itr][0];
			Log.info(st[st.length - 2].toString());
			ctx.setAttribute("testName", st[st.length - 2].toString());
		}

		else if (method.getName().equals("Cancel")) {
//	   		DataReader dt=new DataReader();
//	   		Object[][] data=dt.ipreader();
//		    Object[] st= (Object[]) data[itr][0];
			Log.info(st[st.length - 2].toString());
			ctx.setAttribute("testName", st[st.length - 2].toString());
		} else if (method.getName().equals("Cease")) {
//	   		DataReader dt=new DataReader();
//	   		Object[][] data=dt.ipreader();
//		    Object[] st= (Object[]) data[itr][0];
			Log.info(st[st.length - 2].toString());
			ctx.setAttribute("testName", st[st.length - 2].toString());
		} else
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
		LoginHelper LN = new LoginHelper(getwebdriver());
		NewOrderOnnetHelper NEWO = new NewOrderOnnetHelper(getwebdriver());
		CeasHelper CL = new CeasHelper(getwebdriver());
		CancelHelper CN = new CancelHelper(getwebdriver());
		NewOrderOnnetHelper noo = new NewOrderOnnetHelper(getwebdriver());
//		ModifyComOrdersOfAllProductsHelper mooc = new ModifyComOrdersOfAllProductsHelper(getwebdriver());
//		AbandonedOrderOfAllThreeProducts aoop = new AbandonedOrderOfAllThreeProducts(getwebdriver());
//		InFlightForIPAccess ioc = new InFlightForIPAccess(getwebdriver());

		Login.set(LN);
		newOrderOnnnet.set(NEWO);
		Cancel.set(CN);
		Cease.set(CL);
//		modifyOrdersCom.set(mooc);
//		abandonedOrder.set(aoop);
//		inFlight.set(ioc);
	}

	@org.testng.annotations.BeforeSuite
	public void BeforeSuite() {
		itr = 0;
		DOMConfigurator.configure("log4j.xml");
	}

	//@AfterTest
	public void Teardown() {

//		dr.close();
	}
	@AfterMethod
	public void Teardown2() {
		getwebdriver().close();;
//		dr.close();
	}

	public WebDriver getwebdriver() {
		WebDriver dr = WEB_DRIVER_THREAD_LOCAL.get();
		return dr;
	}
}
