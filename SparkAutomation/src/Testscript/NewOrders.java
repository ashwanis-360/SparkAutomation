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
		// Code for Mod
	}
	@Test(dataProviderClass=DataReader.class,dataProvider="InflightMod")
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
		newOrderOnnnet.get().clickOnManualValidationA();
	    
		// Code for InflightMod
	}
}