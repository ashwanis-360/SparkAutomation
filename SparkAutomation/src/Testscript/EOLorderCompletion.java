package Testscript;


import org.testng.annotations.Test;
import Driver.DataReader;

import Driver.DriverTestcase;
import ScriptHelper.EOLorderCompletionHelper;
import ScriptHelper.LoginHelper;


public class EOLorderCompletion extends DriverTestcase {
	
	@Test(dataProviderClass=DataReader.class,dataProvider="EOLorderCompletion")
	public void createNewEOLOrder(Object[] Data) throws Exception
	{
		
		Login.get().LoginEOL("EOL");
		//try
		//{
		EOLorderCompletionHelper.get().switchToSalesuserType();
		EOLorderCompletionHelper.get().createNewEOLOrder(Data);
		//EOLorderCompletionHelper.get().modComOrder(Data);
		//EOLorderCompletionHelper.get().modTechOrder(Data);	
		//}
		//catch (Exception e)
		//{System.out.println(e.getMessage());
			//}
	}
	
		
}