package Testscript;



import org.testng.annotations.Test;
import Driver.DataReader;
import Driver.DriverTestcase;
import ScriptHelper.LoginHelper;

 

public class NewOrders extends DriverTestcase {
	
	
	@Test(dataProviderClass=DataReader.class,dataProvider="NewOrderOnnet")
	public void EndtoEndOrderOnnet(Object[] Data) throws Exception
	{
	
		Login.get().Login("Sieble");
		//Login.get().VerifySuccessLogin("Sieble");
		newOrderOnnnet.get().accountTabDetails(Data);
		newOrderOnnnet.get().createCustomerOrder(Data);
		newOrderOnnnet.get().productSelectionHelper(Data);
		newOrderOnnnet.get().openServiceOrderNumber();

		newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);
		//add specifically for Wave and Ethernet Line and won't run for other products
		newOrderOnnnet.get().addSiteADetails(Data);//added new
		newOrderOnnnet.get().addSiteBDetails(Data);//added new
		newOrderOnnnet.get().ASiteCustomize(Data);//added new
		newOrderOnnnet.get().BSiteCustomize(Data);//added new
		//End of methods spesific for Wave and Ethernet Line ------>		
		newOrderOnnnet.get().enterMandatoryDetailsInMiddleApplet(Data);
		newOrderOnnnet.get().VoiceConfigTab(Data);
		newOrderOnnnet.get().VoiceFeatureTab(Data);
		newOrderOnnnet.get().NumberManagementTab(Data);
		newOrderOnnnet.get().EnterDateInFooter(Data);
		newOrderOnnnet.get().EnterBillingDateInFooter(Data);
		newOrderOnnnet.get().EnterServiceChargeInFooter(Data,"2");
		
		newOrderOnnnet.get().SelectAttachmentTab(Data);
		newOrderOnnnet.get().UploadDocument(Data);
		newOrderOnnnet.get().SelectServiceGroupTab(Data);
		newOrderOnnnet.get().OperationAttribute(Data);
		newOrderOnnnet.get().EnterInstallationChargeInFooter(Data);
		newOrderOnnnet.get().MandatoryFields(Data);
		newOrderOnnnet.get().CommercialValidation(Data);
		newOrderOnnnet.get().TechnicalValidation(Data);
		newOrderOnnnet.get().clickOnManualValidationB();
		newOrderOnnnet.get().DeliveryValidation(Data);
		newOrderOnnnet.get().clickOnManualValidationA();
		newOrderOnnnet.get().getReferenceNo(Data);//added new
	    newOrderOnnnet.get().CompletedValidation(Data);
		
	}
	
	@Test(dataProviderClass=DataReader.class,dataProvider="Cease")
	public void Cease(Object[] Data) throws Exception
	{
	
		Login.get().Login("Sieble");
		//Login.get().VerifySuccessLogin("Sieble");
		newOrderOnnnet.get().accountTabDetails(Data);
		newOrderOnnnet.get().createCustomerOrder(Data);
		newOrderOnnnet.get().productSelectionHelper(Data);
		newOrderOnnnet.get().openServiceOrderNumber();

		newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);
		newOrderOnnnet.get().enterMandatoryDetailsInMiddleApplet(Data);
		newOrderOnnnet.get().VoiceConfigTab(Data);
		newOrderOnnnet.get().VoiceFeatureTab(Data);
		newOrderOnnnet.get().NumberManagementTab(Data);
		newOrderOnnnet.get().EnterDateInFooter(Data);
		newOrderOnnnet.get().EnterBillingDateInFooter(Data);
		newOrderOnnnet.get().EnterServiceChargeInFooter(Data,"2");
		
		newOrderOnnnet.get().SelectAttachmentTab(Data);
		newOrderOnnnet.get().UploadDocument(Data);
		newOrderOnnnet.get().SelectServiceGroupTab(Data);
		newOrderOnnnet.get().OperationAttribute(Data);
		newOrderOnnnet.get().EnterInstallationChargeInFooter(Data);
		newOrderOnnnet.get().MandatoryFields(Data);
		newOrderOnnnet.get().CommercialValidation(Data);
		newOrderOnnnet.get().TechnicalValidation(Data);
		newOrderOnnnet.get().clickOnManualValidationB();
		newOrderOnnnet.get().DeliveryValidation(Data);
		newOrderOnnnet.get().clickOnManualValidationA();
	    newOrderOnnnet.get().CompletedValidation(Data);
		// Code for Cease
		   Cease.get().Cease(Data);
	}
	@Test(dataProviderClass=DataReader.class,dataProvider="Cancel")
	public void Cancel(Object[] Data) throws Exception
	{
	
		Login.get().Login("Sieble");
		//Login.get().VerifySuccessLogin("Sieble");
		newOrderOnnnet.get().accountTabDetails(Data);
		newOrderOnnnet.get().createCustomerOrder(Data);
		newOrderOnnnet.get().productSelectionHelper(Data);
		newOrderOnnnet.get().openServiceOrderNumber();

		newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);
		newOrderOnnnet.get().enterMandatoryDetailsInMiddleApplet(Data);
		newOrderOnnnet.get().VoiceConfigTab(Data);
		newOrderOnnnet.get().VoiceFeatureTab(Data);
		newOrderOnnnet.get().NumberManagementTab(Data);
		newOrderOnnnet.get().EnterDateInFooter(Data);
		newOrderOnnnet.get().EnterBillingDateInFooter(Data);
		newOrderOnnnet.get().EnterServiceChargeInFooter(Data,"2");
		
		newOrderOnnnet.get().SelectAttachmentTab(Data);
		newOrderOnnnet.get().UploadDocument(Data);
		newOrderOnnnet.get().SelectServiceGroupTab(Data);
		newOrderOnnnet.get().OperationAttribute(Data);
		newOrderOnnnet.get().EnterInstallationChargeInFooter(Data);
		newOrderOnnnet.get().MandatoryFields(Data);
		newOrderOnnnet.get().CommercialValidation(Data);
		newOrderOnnnet.get().TechnicalValidation(Data);
		newOrderOnnnet.get().clickOnManualValidationB();
		newOrderOnnnet.get().DeliveryValidation(Data);
		newOrderOnnnet.get().clickOnManualValidationA();
	    newOrderOnnnet.get().CompletedValidation(Data);
		// Code for Cancel
	   Cancel.get().statusReason(Data);
	   Cancel.get().AbandonedOrder(Data);
	   Cancel.get().verifyOrderAbandoned();
	}
	@Test(dataProviderClass=DataReader.class,dataProvider="Mod")
	public void Mod(Object[] Data) throws Exception
	{
	
		Login.get().Login("Sieble");
		//Login.get().VerifySuccessLogin("Sieble");
		newOrderOnnnet.get().accountTabDetails(Data);
		newOrderOnnnet.get().createCustomerOrder(Data);
		newOrderOnnnet.get().productSelectionHelper(Data);
		newOrderOnnnet.get().openServiceOrderNumber();

		newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);
		newOrderOnnnet.get().enterMandatoryDetailsInMiddleApplet(Data);
		newOrderOnnnet.get().VoiceConfigTab(Data);
		newOrderOnnnet.get().VoiceFeatureTab(Data);
		newOrderOnnnet.get().NumberManagementTab(Data);
		newOrderOnnnet.get().EnterDateInFooter(Data);
		newOrderOnnnet.get().EnterBillingDateInFooter(Data);
		newOrderOnnnet.get().EnterServiceChargeInFooter(Data,"2");
		
		newOrderOnnnet.get().SelectAttachmentTab(Data);
		newOrderOnnnet.get().UploadDocument(Data);
		newOrderOnnnet.get().SelectServiceGroupTab(Data);
		newOrderOnnnet.get().OperationAttribute(Data);
		newOrderOnnnet.get().EnterInstallationChargeInFooter(Data);
		newOrderOnnnet.get().MandatoryFields(Data);
		newOrderOnnnet.get().CommercialValidation(Data);
		newOrderOnnnet.get().TechnicalValidation(Data);
		newOrderOnnnet.get().clickOnManualValidationB();
		newOrderOnnnet.get().DeliveryValidation(Data);
		newOrderOnnnet.get().clickOnManualValidationA();
	    newOrderOnnnet.get().CompletedValidation(Data);
		if(Data[Data.length-1].toString().contains("Com"))
		{
			newOrderOnnnet.get().ServiceTab(Data);
			newOrderOnnnet.get().EnterDateInFooter(Data);
			newOrderOnnnet.get().EnterBillingDateInFooter(Data);
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data,"4");
			newOrderOnnnet.get().CommercialValidation(Data);
			newOrderOnnnet.get().TechnicalValidation(Data);
			newOrderOnnnet.get().clickOnManualValidationB();
			newOrderOnnnet.get().DeliveryValidation(Data);
			newOrderOnnnet.get().clickOnManualValidationA();
			newOrderOnnnet.get().EnterInstallationChargeInFooter(Data);
			newOrderOnnnet.get().CompletedValidation(Data);
		}
		else if(Data[Data.length-1].toString().contains("Tech"))
		{
			newOrderOnnnet.get().ServiceTab(Data);
			modHelper.get().ModTech(Data);
			newOrderOnnnet.get().EnterDateInFooter(Data);
			newOrderOnnnet.get().EnterBillingDateInFooter(Data);
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data,"4");
			newOrderOnnnet.get().SelectAttachmentTab(Data);
			newOrderOnnnet.get().UploadDocument(Data);
			newOrderOnnnet.get().CommercialValidation(Data);
			newOrderOnnnet.get().TechnicalValidation(Data);
			newOrderOnnnet.get().clickOnManualValidationB();
			newOrderOnnnet.get().DeliveryValidation(Data);
			newOrderOnnnet.get().clickOnManualValidationA();
			newOrderOnnnet.get().EnterInstallationChargeInFooter(Data);
			newOrderOnnnet.get().CompletedValidation(Data);
			
		}
	}
	@Test(dataProviderClass=DataReader.class,dataProvider="OmpDatereader")
	public void OMPGenric (Object[] Data) throws Exception
	{
	
		Login.get().Login("Sieble");
		//Login.get().VerifySuccessLogin("Sieble");
		newOrderOnnnet.get().accountTabDetails(Data);
		newOrderOnnnet.get().createCustomerOrder(Data);
		newOrderOnnnet.get().productSelectionHelper(Data);
		newOrderOnnnet.get().openServiceOrderNumber();

		newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);
		//add specifically for Wave and Ethernet Line and won't run for other products
		newOrderOnnnet.get().addSiteADetails(Data);//added new
		newOrderOnnnet.get().addSiteBDetails(Data);//added new
		newOrderOnnnet.get().ASiteCustomize(Data);//added new
		newOrderOnnnet.get().BSiteCustomize(Data);//added new
		//End of methods spesific for Wave and Ethernet Line ------>		
		newOrderOnnnet.get().enterMandatoryDetailsInMiddleApplet(Data);
		newOrderOnnnet.get().VoiceConfigTab(Data);
		newOrderOnnnet.get().VoiceFeatureTab(Data);
		newOrderOnnnet.get().NumberManagementTab(Data);
		newOrderOnnnet.get().EnterDateInFooter(Data);
		newOrderOnnnet.get().EnterBillingDateInFooter(Data);
		newOrderOnnnet.get().EnterServiceChargeInFooter(Data,"2");
		
		newOrderOnnnet.get().SelectAttachmentTab(Data);
		newOrderOnnnet.get().UploadDocument(Data);
		newOrderOnnnet.get().SelectServiceGroupTab(Data);
		newOrderOnnnet.get().OperationAttribute(Data);
		newOrderOnnnet.get().EnterInstallationChargeInFooter(Data);
		newOrderOnnnet.get().MandatoryFields(Data);
		newOrderOnnnet.get().CommercialValidation(Data);
		newOrderOnnnet.get().TechnicalValidation(Data);
		newOrderOnnnet.get().clickOnManualValidationB();
		newOrderOnnnet.get().DeliveryValidation(Data);
		newOrderOnnnet.get().clickOnManualValidationA();
		newOrderOnnnet.get().getReferenceNo(Data);//added new
	    newOrderOnnnet.get().CompletedValidation(Data);
	    OmpOrder.get().verficationOfProduct(Data);
		
	}
	
	@Test(dataProviderClass=DataReader.class,dataProvider="InFlightOrder")
	public void InflightMod(Object[] Data) throws Exception
	{
	
		Login.get().Login("Sieble");
		//Login.get().VerifySuccessLogin("Sieble");
		newOrderOnnnet.get().accountTabDetails(Data);
		newOrderOnnnet.get().createCustomerOrder(Data);
		newOrderOnnnet.get().productSelectionHelper(Data);
		newOrderOnnnet.get().openServiceOrderNumber();

		newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);
		newOrderOnnnet.get().enterMandatoryDetailsInMiddleApplet(Data);
		newOrderOnnnet.get().VoiceConfigTab(Data);
		newOrderOnnnet.get().VoiceFeatureTab(Data);
		newOrderOnnnet.get().NumberManagementTab(Data);
		newOrderOnnnet.get().EnterDateInFooter(Data);
		newOrderOnnnet.get().EnterBillingDateInFooter(Data);
		newOrderOnnnet.get().EnterServiceChargeInFooter(Data,"2");
		
		newOrderOnnnet.get().SelectAttachmentTab(Data);
		newOrderOnnnet.get().UploadDocument(Data);
		newOrderOnnnet.get().SelectServiceGroupTab(Data);
		newOrderOnnnet.get().OperationAttribute(Data);
		newOrderOnnnet.get().EnterInstallationChargeInFooter(Data);
		newOrderOnnnet.get().MandatoryFields(Data);
		newOrderOnnnet.get().CommercialValidation(Data);
		newOrderOnnnet.get().TechnicalValidation(Data);
		newOrderOnnnet.get().clickOnManualValidationB();
		newOrderOnnnet.get().DeliveryValidation(Data);
		//newOrderOnnnet.get().clickOnManualValidationA();
		inFlightGeneric.get().ServiceTabInFlight(Data);
		// Code for InflightMod
	}
}