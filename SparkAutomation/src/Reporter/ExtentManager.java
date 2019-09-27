package Reporter;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	public static String timeStmp = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
	 private static ExtentReports extent;

	  public synchronized static ExtentReports getReporter(){
	      if(extent == null){
	          //Set HTML reporting file location
	          String workingDir = System.getProperty("user.dir");
	          extent = new ExtentReports(workingDir+"\\ExtentReports\\ExtentReportResults"+timeStmp+".html", true);
	      }
	      return extent;
	  }
	
	

}
