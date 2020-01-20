package Testscript;

import java.util.HashMap;

import org.testng.annotations.Test;
import Driver.DataReader;
import Driver.DriverTestcase;
import ScriptHelper.LoginHelper;

public class NewOrders extends DriverTestcase {

	@Test(dataProviderClass = DataReader.class, dataProvider = "NewOrderOnnet")
	public void EndtoEndOrderOnnet(Object[] Data) throws Exception {

		Login.get().Login("Sieble");
		// newOrderOnnnet.get().Check(Data);
		newOrderOnnnet.get().accountTabDetails(Data);
		newOrderOnnnet.get().createCustomerOrder(Data);
		newOrderOnnnet.get().productSelectionHelper(Data);
		newOrderOnnnet.get().openServiceOrderNumber();
		if (Data[8].toString().equalsIgnoreCase("Ethernet Hub")) {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);// Updated
			newOrderOnnnet.get().hubSiteCustomize(Data); // MethodAdded
			newOrderOnnnet.get().EnterDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterBillingDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");
			newOrderOnnnet.get().CommercialValidation(Data); // No Change
			newOrderOnnnet.get().TechnicalValidation(Data); // Updated
			newOrderOnnnet.get().CircuitReferenceGeneration(Data); 
			newOrderOnnnet.get().DeliveryValidation(Data); // No Change
			newOrderOnnnet.get().OrderCompleteEthernetHubSpoke(Data); // MethodAdded
		} else if (Data[8].toString().equalsIgnoreCase("Ethernet Spoke")) {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);// Updated for spoke also
			newOrderOnnnet.get().spokeSiteCustomize(Data);// MethodAdded
			newOrderOnnnet.get().EnterDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterBillingDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");

			newOrderOnnnet.get().CommercialValidation(Data); // No Change
			newOrderOnnnet.get().TechnicalValidation(Data); // Updated for spoke also
			newOrderOnnnet.get().CircuitReferenceGeneration(Data); 
			newOrderOnnnet.get().DeliveryValidation(Data); // No Change
			newOrderOnnnet.get().OrderCompleteEthernetHubSpoke(Data);// updated same as hub
		} else {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);
			newOrderOnnnet.get().enterMandatoryDetailsInMiddleApplet(Data);
			newOrderOnnnet.get().VoiceConfigTab(Data);
			newOrderOnnnet.get().VoiceFeatureTab(Data);
			newOrderOnnnet.get().NumberManagementTab(Data);
			newOrderOnnnet.get().EnterDateInFooter(Data);
			newOrderOnnnet.get().EnterBillingDateInFooter(Data);
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");
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
			if (Data[74].toString().equals("Offnet")) {
				newOrderOnnnet.get().CEOS_Offnet();
				newOrderOnnnet.get().LaunchingCEOSApplication(Data);
			}
			newOrderOnnnet.get().getReferenceNo(Data);// added new
			newOrderOnnnet.get().CompletedValidation(Data);
			newOrderOnnnet.get().WriteServiceOrderNumber(Data);
		}
	}

	@Test(dataProviderClass = DataReader.class, dataProvider = "Cease")
	public void Cease(Object[] Data) throws Exception {

		Login.get().Login("Sieble");
		newOrderOnnnet.get().accountTabDetails(Data);
		newOrderOnnnet.get().createCustomerOrder(Data);
		newOrderOnnnet.get().productSelectionHelper(Data);
		newOrderOnnnet.get().openServiceOrderNumber();
		if (Data[8].toString().equalsIgnoreCase("Ethernet Hub")) {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);// Updated
			newOrderOnnnet.get().hubSiteCustomize(Data); // MethodAdded
			newOrderOnnnet.get().EnterDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterBillingDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2"); // Method added
			newOrderOnnnet.get().CommercialValidation(Data); // No Change
			newOrderOnnnet.get().TechnicalValidation(Data); // Updated
			newOrderOnnnet.get().CircuitReferenceGeneration(Data); 
			newOrderOnnnet.get().DeliveryValidation(Data); // No Change
			newOrderOnnnet.get().OrderCompleteEthernetHubSpoke(Data); // MethodAdded
		} else if (Data[8].toString().equalsIgnoreCase("Ethernet Spoke")) {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);// Updated for spoke also
			newOrderOnnnet.get().spokeSiteCustomize(Data);// MethodAdded
			newOrderOnnnet.get().EnterDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterBillingDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2"); // Method added same as hub and updated if
																		// condition for
			// spoke

			newOrderOnnnet.get().CommercialValidation(Data); // No Change
			newOrderOnnnet.get().TechnicalValidation(Data); // Updated for spoke also
			newOrderOnnnet.get().CircuitReferenceGeneration(Data); 
			newOrderOnnnet.get().DeliveryValidation(Data); // No Change
			newOrderOnnnet.get().OrderCompleteEthernetHubSpoke(Data);// updated same as hub
		} else {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);
			newOrderOnnnet.get().enterMandatoryDetailsInMiddleApplet(Data);
			newOrderOnnnet.get().VoiceConfigTab(Data);
			newOrderOnnnet.get().VoiceFeatureTab(Data);
			newOrderOnnnet.get().NumberManagementTab(Data);
			newOrderOnnnet.get().EnterDateInFooter(Data);
			newOrderOnnnet.get().EnterBillingDateInFooter(Data);
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");
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
		}
		newOrderOnnnet.get().WriteServiceOrderNumber(Data);
		Cease.get().CeaseMainMethod(Data);
		newOrderOnnnet.get().SelectAttachmentTab(Data);
		newOrderOnnnet.get().UploadDocument(Data);
		Cease.get().CeaseCommercialValidation(Data); // Addedd by Devesh
		// newOrderOnnnet.get().clickOnManualValidationB(); // Updated By Devesh
		Cease.get().DeliveryValidation(Data); // Addedd by Devesh
		// newOrderOnnnet.get().clickOnManualValidationA(); // Updated By Devesh
		Cease.get().CeaseCompletedValidation(Data); // added By Devesh
	}

	@Test(dataProviderClass = DataReader.class, dataProvider = "Abandoned")
	public void Abandoned(Object[] Data) throws Exception {

		Login.get().Login("Sieble");
		// Login.get().VerifySuccessLogin("Sieble");
		newOrderOnnnet.get().accountTabDetails(Data);
		newOrderOnnnet.get().createCustomerOrder(Data);
		newOrderOnnnet.get().productSelectionHelper(Data);
		newOrderOnnnet.get().openServiceOrderNumber();
		if (Data[8].toString().equalsIgnoreCase("Ethernet Hub")) {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);// Updated
			newOrderOnnnet.get().hubSiteCustomize(Data); // MethodAdded
			// newOrderOnnnet.get().EnterDateInFooter(Data); // No change
			// newOrderOnnnet.get().EnterBillingDateInFooter(Data); // No change
			// newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2"); // Method added
			// newOrderOnnnet.get().CommercialValidation(Data); // No Change
			// newOrderOnnnet.get().TechnicalValidation(Data); // Updated
			// newOrderOnnnet.get().DeliveryValidation(Data); // No Change
			// newOrderOnnnet.get().OrderCompleteEthernetHubSpoke(Data); // MethodAdded
			Abandoned.get().statusReason(Data);
			Abandoned.get().AbandonedOrder(Data);
			Abandoned.get().verifyOrderAbandoned();
		} else if (Data[8].toString().equalsIgnoreCase("Ethernet Spoke")) {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);// Updated for spoke also
			newOrderOnnnet.get().spokeSiteCustomize(Data);// MethodAdded
			
			// newOrderOnnnet.get().EnterDateInFooter(Data); // No change
			// newOrderOnnnet.get().EnterBillingDateInFooter(Data); // No change
			// newOrderOnnnet.get().installationCharges(Data); // Method added same as hub
			// and updated if condition for
			// spoke

			newOrderOnnnet.get().CommercialValidation(Data); // No Change
			// newOrderOnnnet.get().TechnicalValidation(Data); // Updated for spoke also
			// newOrderOnnnet.get().DeliveryValidation(Data); // No Change
			// newOrderOnnnet.get().OrderCompleteEthernetHubSpoke(Data);// updated same as
			// hub
			Abandoned.get().statusReason(Data);
			Abandoned.get().AbandonedOrder(Data);
			Abandoned.get().verifyOrderAbandoned();
		} else if (Data[8].toString().equalsIgnoreCase("IP VPN Service")) {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);
			newOrderOnnnet.get().enterMandatoryDetailsInMiddleApplet(Data);
			newOrderOnnnet.get().EnterDateInFooter(Data);
			newOrderOnnnet.get().EnterBillingDateInFooter(Data);
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");
			newOrderOnnnet.get().EnterInstallationChargeInFooter(Data);
			newOrderOnnnet.get().CommercialValidation(Data);
			newOrderOnnnet.get().TechnicalValidation(Data);
			newOrderOnnnet.get().clickOnManualValidationB();
			newOrderOnnnet.get().DeliveryValidation(Data);
			newOrderOnnnet.get().clickOnManualValidationA();
			newOrderOnnnet.get().AbandonedforIPVPN(Data); // No Change
			newOrderOnnnet.get().CommercialValidation(Data);
			Abandoned.get().statusReason(Data);
			Abandoned.get().AbandonedOrder(Data);
			Abandoned.get().verifyOrderAbandonedforIPVPN();
		} else {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);
			// newOrderOnnnet.get().enterMandatoryDetailsInMiddleApplet(Data);
			// newOrderOnnnet.get().VoiceConfigTab(Data);
			// newOrderOnnnet.get().VoiceFeatureTab(Data);
			// newOrderOnnnet.get().NumberManagementTab(Data);
			// newOrderOnnnet.get().EnterDateInFooter(Data);
			// newOrderOnnnet.get().EnterBillingDateInFooter(Data);
			// newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");

			// newOrderOnnnet.get().SelectAttachmentTab(Data);
			// newOrderOnnnet.get().UploadDocument(Data);
			// newOrderOnnnet.get().SelectServiceGroupTab(Data);
			// newOrderOnnnet.get().OperationAttribute(Data);
			// newOrderOnnnet.get().EnterInstallationChargeInFooter(Data);
			newOrderOnnnet.get().MandatoryFields(Data);
			newOrderOnnnet.get().CommercialValidation(Data);
			Abandoned.get().statusReason(Data);
			Abandoned.get().AbandonedOrder(Data);
			Abandoned.get().verifyOrderAbandoned();
			/*
			 * newOrderOnnnet.get().TechnicalValidation(Data);
			 * newOrderOnnnet.get().clickOnManualValidationB();
			 * newOrderOnnnet.get().DeliveryValidation(Data);
			 * newOrderOnnnet.get().clickOnManualValidationA();
			 * newOrderOnnnet.get().CompletedValidation(Data);
			 */
		}
		// Code for Cancel

	}

	@Test(dataProviderClass = DataReader.class, dataProvider = "Mode")
	public void Mod(Object[] Data) throws Throwable {
		Login.get().Login("Sieble");
		// newOrderOnnnet.get().Check(Data);
		newOrderOnnnet.get().accountTabDetails(Data);
		newOrderOnnnet.get().createCustomerOrder(Data);
		newOrderOnnnet.get().productSelectionHelper(Data);
		newOrderOnnnet.get().openServiceOrderNumber();
		if (Data[8].toString().equalsIgnoreCase("Ethernet Hub")) {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);// Updated
			newOrderOnnnet.get().hubSiteCustomize(Data); // MethodAdded
			newOrderOnnnet.get().EnterDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterBillingDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");
			newOrderOnnnet.get().CommercialValidation(Data); // No Change
			newOrderOnnnet.get().TechnicalValidation(Data); // Updated
			newOrderOnnnet.get().CircuitReferenceGeneration(Data); 
			newOrderOnnnet.get().DeliveryValidation(Data); // No Change
			newOrderOnnnet.get().OrderCompleteEthernetHubSpoke(Data); // MethodAdded
		} else if (Data[8].toString().equalsIgnoreCase("Ethernet Spoke")) {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);// Updated for spoke also
			newOrderOnnnet.get().spokeSiteCustomize(Data);// MethodAdded
			newOrderOnnnet.get().EnterDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterBillingDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");

			newOrderOnnnet.get().CommercialValidation(Data); // No Change
			newOrderOnnnet.get().TechnicalValidation(Data); // Updated for spoke also
			newOrderOnnnet.get().CircuitReferenceGeneration(Data); 
			newOrderOnnnet.get().DeliveryValidation(Data); // No Change
			newOrderOnnnet.get().OrderCompleteEthernetHubSpoke(Data);// updated same as hub
		} else {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);
			newOrderOnnnet.get().enterMandatoryDetailsInMiddleApplet(Data);
			newOrderOnnnet.get().VoiceConfigTab(Data);
			newOrderOnnnet.get().VoiceFeatureTab(Data);
			newOrderOnnnet.get().NumberManagementTab(Data);
			newOrderOnnnet.get().EnterDateInFooter(Data);
			newOrderOnnnet.get().EnterBillingDateInFooter(Data);
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");
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
			newOrderOnnnet.get().getReferenceNo(Data);// added new
			newOrderOnnnet.get().CompletedValidation(Data);
			newOrderOnnnet.get().WriteServiceOrderNumber(Data);
		}
		if (Data[Data.length - 1].toString().contains("Carnor")) {
			newOrderOnnnet.get().ServiceTab(Data);
			newOrderOnnnet.get().installationTimeUpdate(Data); // added by shivananda for carnor scenario
			newOrderOnnnet.get().EnterDateInFooter(Data);
			newOrderOnnnet.get().EnterBillingDateInFooter(Data);
			if (Data[8].toString().equalsIgnoreCase("IP VPN Service")) 
			{
				newOrderOnnnet.get().ServiceChargeforIPVPNSite(Data, "4");
			}
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "4");
			newOrderOnnnet.get().CommercialValidation(Data);
			newOrderOnnnet.get().Carnor(Data);
			newOrderOnnnet.get().EnterInstallationChargeInFooter(Data);
			newOrderOnnnet.get().Carnor_SelectServiceGroupTab(Data);
			newOrderOnnnet.get().SelectAttachmentTab(Data);
			newOrderOnnnet.get().UploadDocument(Data);
			newOrderOnnnet.get().TechnicalValidation(Data);
			if (Data[8].toString().equalsIgnoreCase("Ethernet Hub")||Data[8].toString().equalsIgnoreCase("Ethernet Spoke")) 
			{
			newOrderOnnnet.get().CircuitReferenceGeneration(Data); 
			}
			newOrderOnnnet.get().clickOnManualValidationB();
			newOrderOnnnet.get().DeliveryValidation(Data);
			newOrderOnnnet.get().clickOnManualValidationA();
			newOrderOnnnet.get().getReferenceNo(Data);// added new
			newOrderOnnnet.get().Carnor_getReferenceNo(Data);
			newOrderOnnnet.get().OperationAttribute_Carnor(Data);
			newOrderOnnnet.get().CarnorCompletedValidation(Data);
			// newOrderOnnnet.get().CompletedValidation(Data);
		}
		if (Data[Data.length - 1].toString().contains("Com")) 
		{
			newOrderOnnnet.get().ServiceTab(Data);
			newOrderOnnnet.get().installationTimeUpdate(Data);
			newOrderOnnnet.get().EnterDateInFooter(Data);
			if (Data[8].toString().equalsIgnoreCase("Ethernet Spoke")) {
				newOrderOnnnet.get().ColtPromissDate(Data);
			}
			newOrderOnnnet.get().EnterBillingDateInFooter(Data);
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "4");
			newOrderOnnnet.get().CommercialValidation(Data);
			// newOrderOnnnet.get().getReferenceNo(Data);// added new
			newOrderOnnnet.get().CompletedValidation(Data);// updated
		} 
		else if (Data[Data.length - 1].toString().contains("Tech")) 
		{
			// newOrderOnnnet.get().Check(Data);
			newOrderOnnnet.get().ServiceTab(Data);
			modHelper.get().ModTech(Data);
			newOrderOnnnet.get().ModTechModCommWaveAndLine(Data);
			newOrderOnnnet.get().EnterDateInFooter(Data);
			newOrderOnnnet.get().EnterBillingDateInFooter(Data);
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "4");
			newOrderOnnnet.get().SelectAttachmentTab(Data);
			newOrderOnnnet.get().UploadDocument(Data);
			newOrderOnnnet.get().CommercialValidation(Data);
			newOrderOnnnet.get().EnterInstallationChargeInFooter(Data);
			newOrderOnnnet.get().TechnicalValidation(Data); // updated
			modHelper.get().LeadCapacity(Data);
			newOrderOnnnet.get().clickOnManualValidationB();
			newOrderOnnnet.get().DeliveryValidation(Data);
			newOrderOnnnet.get().clickOnManualValidationA();
			/* below changes as per Aman */
			//newOrderOnnnet.get().EnterInstallationChargeInFooter(Data);
			modHelper.get().ProductSpecificCompleted(Data);
			if (!(Data[11].toString().equalsIgnoreCase("IP VPN Access"))&&
					!(Data[11].toString().equalsIgnoreCase("IP VPN Plus")) &&
					!(Data[11].toString().equalsIgnoreCase("IP VPN Wholesale"))&&
					!(Data[11].toString().equalsIgnoreCase("PrizmNet")))
			{
				newOrderOnnnet.get().CompletedValidation(Data);// updated
			}
		}
	}

	@Test(dataProviderClass = DataReader.class, dataProvider = "OmpDatereader")
	public void OMPGenric(Object[] Data) throws Exception {

		Login.get().Login("Sieble");
		// newOrderOnnnet.get().Check(Data);
		newOrderOnnnet.get().accountTabDetails(Data);
		newOrderOnnnet.get().createCustomerOrder(Data);
		newOrderOnnnet.get().productSelectionHelper(Data);
		newOrderOnnnet.get().openServiceOrderNumber();
		if (Data[8].toString().equalsIgnoreCase("Ethernet Hub")) {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);// Updated
			newOrderOnnnet.get().hubSiteCustomize(Data); // MethodAdded		
			// newOrderOnnnet.get().EnterDateInFooter(Data); // No change
			// newOrderOnnnet.get().EnterBillingDateInFooter(Data); // No change
			// newOrderOnnnet.get().installationCharges(Data); // Method added
			newOrderOnnnet.get().CommercialValidation(Data); // No Change
			Login.get().Login("OMP");
			OmpOrder.get().verficationOfProduct(Data);
			// newOrderOnnnet.get().TechnicalValidation(Data); // Updated
			// newOrderOnnnet.get().DeliveryValidation(Data); // No Change
			// newOrderOnnnet.get().OrderCompleteEthernetHubSpoke(Data); // MethodAdded
		} 
		else if (Data[8].toString().equalsIgnoreCase("Ethernet Spoke")) 
		{
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);// Updated for spoke also
			newOrderOnnnet.get().spokeSiteCustomize(Data);// MethodAdded
			
			// newOrderOnnnet.get().EnterDateInFooter(Data); // No change
			// newOrderOnnnet.get().EnterBillingDateInFooter(Data); // No change
			// newOrderOnnnet.get().installationCharges(Data); // Method added same as hub
			// and updated if condition for
			// spoke
			newOrderOnnnet.get().CommercialValidation(Data); // No Change
			Login.get().Login("OMP");
			OmpOrder.get().verficationOfProduct(Data);
			// newOrderOnnnet.get().TechnicalValidation(Data); // Updated for spoke also
			// newOrderOnnnet.get().DeliveryValidation(Data); // No Change
			// newOrderOnnnet.get().OrderCompleteEthernetHubSpoke(Data);// updated same as
			// hub
		} 
		else 
		{
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);
			// add specifically for Wave and Ethernet Line and won't run for other products
			// newOrderOnnnet.get().addSiteADetails(Data);// added new
			// newOrderOnnnet.get().addSiteBDetails(Data);// added new
			// newOrderOnnnet.get().ASiteCustomize(Data);// added new
			// newOrderOnnnet.get().BSiteCustomize(Data);// added new
			// // End of methods spesific for Wave and Ethernet Line ------>
			// newOrderOnnnet.get().enterMandatoryDetailsInMiddleApplet(Data);
			// newOrderOnnnet.get().VoiceConfigTab(Data);
			// newOrderOnnnet.get().VoiceFeatureTab(Data);
			// newOrderOnnnet.get().NumberManagementTab(Data);
			// newOrderOnnnet.get().EnterDateInFooter(Data);
			// newOrderOnnnet.get().EnterBillingDateInFooter(Data);
			// newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");
			//
			// newOrderOnnnet.get().SelectAttachmentTab(Data);
			// newOrderOnnnet.get().UploadDocument(Data);
			// newOrderOnnnet.get().SelectServiceGroupTab(Data);
			// newOrderOnnnet.get().OperationAttribute(Data);
			// newOrderOnnnet.get().EnterInstallationChargeInFooter(Data);
			// newOrderOnnnet.get().MandatoryFields(Data);
			newOrderOnnnet.get().CommercialValidation(Data);
			// newOrderOnnnet.get().TechnicalValidation(Data);
			// newOrderOnnnet.get().clickOnManualValidationB();
			// newOrderOnnnet.get().DeliveryValidation(Data);
			// newOrderOnnnet.get().clickOnManualValidationA();
			// newOrderOnnnet.get().getReferenceNo(Data);// added new
			// newOrderOnnnet.get().CompletedValidation(Data);
			Login.get().Login("OMP");
			OmpOrder.get().verficationOfProduct(Data);
		}
	}
	
	@Test(dataProviderClass = DataReader.class, dataProvider = "OmpDatereaderMod")
	public void OMPMod(Object[] Data) throws Exception {
		// Login.get().Login("Sieble");
		// Login.get().VerifySuccessLogin("Sieble");
//		newOrderOnnnet.get().accountTabDetails(Data);
//		newOrderOnnnet.get().createCustomerOrder(Data);
//		newOrderOnnnet.get().productSelectionHelper(Data);
//		newOrderOnnnet.get().openServiceOrderNumber();
//
//		newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);
		// add specifically for Wave and Ethernet Line and won't run for other products
//		newOrderOnnnet.get().addSiteADetails(Data);// added new - updated
//		newOrderOnnnet.get().addSiteBDetails(Data);// added new
//		newOrderOnnnet.get().ASiteCustomize(Data);// added new
//		newOrderOnnnet.get().BSiteCustomize(Data);// added new
//		// End of methods spesific for Wave and Ethernet Line ------>
//		newOrderOnnnet.get().enterMandatoryDetailsInMiddleApplet(Data);
//		newOrderOnnnet.get().VoiceConfigTab(Data);
//		newOrderOnnnet.get().VoiceFeatureTab(Data);
//		newOrderOnnnet.get().NumberManagementTab(Data);
//		newOrderOnnnet.get().EnterDateInFooter(Data);
//		newOrderOnnnet.get().EnterBillingDateInFooter(Data);
//		newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");
//
//		newOrderOnnnet.get().SelectAttachmentTab(Data);
//		newOrderOnnnet.get().UploadDocument(Data);
//		newOrderOnnnet.get().SelectServiceGroupTab(Data);
//		newOrderOnnnet.get().OperationAttribute(Data);
//		newOrderOnnnet.get().EnterInstallationChargeInFooter(Data);
//		newOrderOnnnet.get().MandatoryFields(Data);
//		newOrderOnnnet.get().CommercialValidation(Data);
//		newOrderOnnnet.get().TechnicalValidation(Data);
//		newOrderOnnnet.get().clickOnManualValidationB();
//		newOrderOnnnet.get().DeliveryValidation(Data);
//		newOrderOnnnet.get().clickOnManualValidationA();
//		newOrderOnnnet.get().getReferenceNo(Data);// added new
//		newOrderOnnnet.get().CompletedValidation(Data);
//
//		if (Data[Data.length - 1].toString().contains("Carnor")) {
//			newOrderOnnnet.get().ServiceTab(Data);
//			newOrderOnnnet.get().installationTimeUpdate(Data); // added by shivananda for carnor scenario
//			newOrderOnnnet.get().EnterDateInFooter(Data);
//			newOrderOnnnet.get().EnterBillingDateInFooter(Data);
//			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "4");
//			newOrderOnnnet.get().CommercialValidation(Data);
//
//			newOrderOnnnet.get().Carnor(Data);
//			newOrderOnnnet.get().EnterInstallationChargeInFooter(Data);
//			newOrderOnnnet.get().TechnicalValidation(Data);
//			newOrderOnnnet.get().clickOnManualValidationB();
//			newOrderOnnnet.get().DeliveryValidation(Data);
//			newOrderOnnnet.get().clickOnManualValidationA();
//			newOrderOnnnet.get().getReferenceNo(Data);// added new
//			newOrderOnnnet.get().Carnor_getReferenceNo(Data);
//			newOrderOnnnet.get().CompletedValidation(Data);
//		}
//		if (Data[Data.length - 1].toString().contains("Com")) {
//			newOrderOnnnet.get().ServiceTab(Data);
//			newOrderOnnnet.get().EnterDateInFooter(Data);
//			newOrderOnnnet.get().EnterBillingDateInFooter(Data);
//			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "4");
//			newOrderOnnnet.get().CommercialValidation(Data);
//			newOrderOnnnet.get().getReferenceNo(Data);// added new
//			newOrderOnnnet.get().CompletedValidation(Data);// updated
//		} else if (Data[Data.length - 1].toString().contains("Tech")) {
//			// newOrderOnnnet.get().Check(Data);
//			newOrderOnnnet.get().ServiceTab(Data);
//			modHelper.get().ModTech(Data);
//			newOrderOnnnet.get().EnterDateInFooter(Data);
//			newOrderOnnnet.get().EnterBillingDateInFooter(Data);
//			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "4");
//			newOrderOnnnet.get().SelectAttachmentTab(Data);
//			newOrderOnnnet.get().UploadDocument(Data);
//			newOrderOnnnet.get().CommercialValidation(Data);
//			newOrderOnnnet.get().TechnicalValidation(Data); // updated
//			modHelper.get().LeadCapacity(Data);
//			newOrderOnnnet.get().clickOnManualValidationB();
//			newOrderOnnnet.get().DeliveryValidation(Data);
//			newOrderOnnnet.get().clickOnManualValidationA();
//			newOrderOnnnet.get().EnterInstallationChargeInFooter(Data);
//			newOrderOnnnet.get().CompletedValidation(Data);// updated
//
//		}
		Login.get().Login("OMP");
		OmpMOdOrder.get().verficationOfProduct(Data);
	}

	@Test(dataProviderClass = DataReader.class, dataProvider = "PreMaster")
	public void PremiseMaster(Object[] Data) throws Exception {
		HashMap<String, String> SiteDetails = new HashMap<String, String>();
		String SiteId = null;
		String BuildingID = null;
		String NewSiteId = null;
		String UpdateSiteID = null;
		String ProductName = Data[8].toString();
		Login.get().Login("Sieble");
		String CurrentUrl = Login.get().GetCurrentUrl();
		// newOrderOnnnet.get().OpenServiceOrder(Data);
		newOrderOnnnet.get().accountTabDetails(Data);
		newOrderOnnnet.get().createCustomerOrder(Data);
		newOrderOnnnet.get().productSelectionHelper(Data);
		newOrderOnnnet.get().openServiceOrderNumber();
		System.out.println("New Code");
		premiseHelper.get().ClickSitesSearch(Data);
		SiteDetails = premiseHelper.get().AddSiteAndBuilding(Data);
		newOrderOnnnet.get().savePage();
		SiteId = premiseHelper.get().SiteidReference(Data);
		newOrderOnnnet.get().ClickHereSave();
		premiseHelper.get().PremiseMasterAppOpen();
		Login.get().Login("PremiseMaster");
		premiseHelper.get().ClickIcon();
		BuildingID = premiseHelper.get().SearchSiteAndVerified(SiteId);
		SiteDetails.put("BuildingID", BuildingID);
		premiseHelper.get().SearchBuildingAndEdit(BuildingID, Data);
		premiseHelper.get().SearchSiteAndEdit(SiteId, Data);
		UpdateSiteID = premiseHelper.get().GetUpdateSiteId(BuildingID);
		SiteDetails.put("UpdateSiteID", UpdateSiteID);
		premiseHelper.get().PremiseMasterAppClosed();
		Login.get().NavigateUrl(CurrentUrl);
		newOrderOnnnet.get().savePage();
		premiseHelper.get().ClickSitesSearch(Data);
		premiseHelper.get().BuildingVerificationInSiebel(SiteDetails, Data);
		premiseHelper.get().SiteVerifcationInSibel(Data, UpdateSiteID);
		newOrderOnnnet.get().savePage();
		NewSiteId = premiseHelper.get().SiteidReference(Data);
		premiseHelper.get().SiteUpdateVerification(UpdateSiteID, NewSiteId);
	}

	@Test(dataProviderClass = DataReader.class, dataProvider = "InFlightOrder")
	public void InflightMod(Object[] Data) throws Exception {

		Login.get().Login("Sieble");
		// Login.get().VerifySuccessLogin("Sieble");
		// newOrderOnnnet.get().Check(Data);
		newOrderOnnnet.get().accountTabDetails(Data);
		newOrderOnnnet.get().createCustomerOrder(Data);
		newOrderOnnnet.get().productSelectionHelper(Data);
		newOrderOnnnet.get().openServiceOrderNumber();
		if (Data[8].toString().equalsIgnoreCase("Ethernet Hub")) 
		{
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);// Updated
			newOrderOnnnet.get().hubSiteCustomize(Data); // MethodAdded	
			newOrderOnnnet.get().EnterDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterBillingDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2"); // Method added
			newOrderOnnnet.get().CommercialValidation(Data); // No Change
			newOrderOnnnet.get().TechnicalValidation(Data); // Updated
			newOrderOnnnet.get().DeliveryValidation(Data); // No Change
			inFlightGeneric.get().ServiceTabInFlight(Data);
		} 
		else if (Data[8].toString().equalsIgnoreCase("Ethernet Spoke")) 
		{
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);// Updated for spoke also
			newOrderOnnnet.get().spokeSiteCustomize(Data);// MethodAdded
			newOrderOnnnet.get().EnterDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterBillingDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2"); // Method added same as hub and updated if
																		// condition for
			// spoke

			newOrderOnnnet.get().CommercialValidation(Data); // No Change
			newOrderOnnnet.get().TechnicalValidation(Data); // Updated for spoke also
			newOrderOnnnet.get().DeliveryValidation(Data); // No Change
			inFlightGeneric.get().ServiceTabInFlight(Data);
		} else {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);
			newOrderOnnnet.get().enterMandatoryDetailsInMiddleApplet(Data);
			newOrderOnnnet.get().VoiceConfigTab(Data);
			newOrderOnnnet.get().VoiceFeatureTab(Data);
			newOrderOnnnet.get().NumberManagementTab(Data);
			newOrderOnnnet.get().EnterDateInFooter(Data);
			newOrderOnnnet.get().EnterBillingDateInFooter(Data);
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");
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
			// newOrderOnnnet.get().clickOnManualValidationA();
			inFlightGeneric.get().ServiceTabInFlight(Data);
			// Code for InflightMod
		}
	}

	@Test(dataProviderClass = DataReader.class, dataProvider = "PartialDelivery")
	public void PartialDelivery(Object[] Data) throws Exception {

		Login.get().Login("Sieble");
		// newOrderOnnnet.get().Check(Data);
		newOrderOnnnet.get().accountTabDetails(Data);
		newOrderOnnnet.get().createCustomerOrder(Data);
		newOrderOnnnet.get().productSelectionHelper(Data);
		newOrderOnnnet.get().openServiceOrderNumber();
		newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);
		// add specifically for Wave and Ethernet Line and won't run for other products
		newOrderOnnnet.get().addSiteADetails(Data);// added new
		newOrderOnnnet.get().addSiteBDetails(Data);// added new
		newOrderOnnnet.get().ASiteCustomize(Data);// added new
		newOrderOnnnet.get().BSiteCustomize(Data);// added new
		// End of methods spesific for Wave and Ethernet Line ------>
		newOrderOnnnet.get().enterMandatoryDetailsInMiddleApplet(Data);
		newOrderOnnnet.get().VoiceConfigTab(Data);
		newOrderOnnnet.get().VoiceFeatureTab(Data);
		newOrderOnnnet.get().NumberManagementTab(Data);
		newOrderOnnnet.get().EnterDateInFooter(Data);
		newOrderOnnnet.get().EnterBillingDateInFooter(Data);
		newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");
		newOrderOnnnet.get().SelectAttachmentTab(Data);
		newOrderOnnnet.get().UploadDocument(Data);
		newOrderOnnnet.get().SelectServiceGroupTab(Data);
		newOrderOnnnet.get().OperationAttribute(Data);
		if (!Data[8].toString().equalsIgnoreCase("IP Access")) 
		{
			newOrderOnnnet.get().EnterInstallationChargeInFooter(Data);
			newOrderOnnnet.get().CommercialValidation(Data);
			newOrderOnnnet.get().TechnicalValidation(Data);
			newOrderOnnnet.get().clickOnManualValidationB();
			newOrderOnnnet.get().DeliveryValidation(Data);
			newOrderOnnnet.get().clickOnManualValidationA();
		}
		newOrderOnnnet.get().getReferenceNo(Data);// added new
		newOrderOnnnet.get().PartialCompletedValidation(Data);
	}

	@Test(dataProviderClass = DataReader.class, dataProvider = "NewOrderOffnet")
	public void EndtoEndOrderOffnet(Object[] Data) throws Exception 
	{
		Login.get().Login("Sieble");
		// newOrderOnnnet.get().Check(Data);
		newOrderOnnnet.get().accountTabDetails(Data);
		newOrderOnnnet.get().createCustomerOrder(Data);
		newOrderOnnnet.get().productSelectionHelper(Data);
		newOrderOnnnet.get().openServiceOrderNumber();
		if (Data[8].toString().equalsIgnoreCase("Ethernet Hub")) {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);// Updated
			newOrderOnnnet.get().hubSiteCustomize(Data); // MethodAdded
			newOrderOnnnet.get().EnterDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterBillingDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");
			newOrderOnnnet.get().CommercialValidation(Data); // No Change
			newOrderOnnnet.get().TechnicalValidation(Data); // Updated
			newOrderOnnnet.get().CircuitReferenceGeneration(Data); 
			newOrderOnnnet.get().DeliveryValidation(Data); // No Change
			newOrderOnnnet.get().OrderCompleteEthernetHubSpoke(Data); // MethodAdded
			newOrderOnnnet.get().validateSlaMatrix(Data);
		} else if (Data[8].toString().equalsIgnoreCase("Ethernet Spoke")) {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);// Updated for spoke also
			newOrderOnnnet.get().spokeSiteCustomize(Data);// MethodAdded
			newOrderOnnnet.get().EnterDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterBillingDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");

			newOrderOnnnet.get().CommercialValidation(Data); // No Change
			newOrderOnnnet.get().TechnicalValidation(Data); // Updated for spoke also
			newOrderOnnnet.get().CircuitReferenceGeneration(Data); 
			newOrderOnnnet.get().DeliveryValidation(Data); // No Change
			if (Data[74].toString().equals("Offnet")) {
				newOrderOnnnet.get().CEOS_Offnet();
				newOrderOnnnet.get().LaunchingCEOSApplication(Data);
			}
			newOrderOnnnet.get().OrderCompleteEthernetHubSpoke(Data);// updated same as hub
			newOrderOnnnet.get().validateSlaMatrix(Data);
		} else {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);
			// add specifically for Wave and Ethernet Line and won't run for other products
			newOrderOnnnet.get().addSiteADetails(Data);// added new
			newOrderOnnnet.get().addSiteBDetails(Data);// added new
			newOrderOnnnet.get().ASiteCustomize(Data);// added new
			newOrderOnnnet.get().BSiteCustomize(Data);// added new
			// End of methods spesific for Wave and Ethernet Line ------>
			newOrderOnnnet.get().enterMandatoryDetailsInMiddleApplet(Data);
			newOrderOnnnet.get().VoiceConfigTab(Data);
			newOrderOnnnet.get().VoiceFeatureTab(Data);
			newOrderOnnnet.get().NumberManagementTab(Data);
			newOrderOnnnet.get().EnterDateInFooter(Data);
			newOrderOnnnet.get().EnterBillingDateInFooter(Data);
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");

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
			if (!Data[8].toString().equalsIgnoreCase("IP VPN Service")) {
				if (Data[74].toString().equals("Offnet")) {

					newOrderOnnnet.get().CEOS_Offnet();
					newOrderOnnnet.get().LaunchingCEOSApplication(Data);
					newOrderOnnnet.get().getReferenceNo(Data);// added new
					newOrderOnnnet.get().CompletedValidation(Data);
				}
			} else {
				newOrderOnnnet.get().CompletedValidation_offnet(Data);
			}

			newOrderOnnnet.get().getReferenceNo(Data);// added new
			newOrderOnnnet.get().CompletedValidation(Data);
			newOrderOnnnet.get().validateSlaMatrix(Data);
		}
	}

	// As Add By Ayush
	@Test(dataProviderClass = DataReader.class, dataProvider = "NewOrderOnnet")
	public void XNGGeneric(Object[] Data) throws Exception {

		Login.get().Login("Sieble");
		// newOrderOnnnet.get().Check(Data);
		// newOrderOnnnet.get().GetReference();
		// newOrderOnnnet.get().getreferencer1();//for line,hub,spoke,wave
		newOrderOnnnet.get().accountTabDetails(Data);
		newOrderOnnnet.get().createCustomerOrder(Data);
		newOrderOnnnet.get().productSelectionHelper(Data);
		newOrderOnnnet.get().openServiceOrderNumber();
		if (Data[8].toString().equalsIgnoreCase("Ethernet Hub")) {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);// Updated
			newOrderOnnnet.get().hubSiteCustomize(Data); // MethodAdded
			newOrderOnnnet.get().EnterDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterBillingDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");
			newOrderOnnnet.get().CommercialValidation(Data); // No Change
			newOrderOnnnet.get().TechnicalValidation(Data); // Updated
			newOrderOnnnet.get().DeliveryValidation(Data); // No Change
			newOrderOnnnet.get().OrderCompleteEthernetHubSpoke(Data); // MethodAdded
			newOrderOnnnet.get().LaunchingXNGApplication(Data);//for xng code
		} else if (Data[8].toString().equalsIgnoreCase("Ethernet Spoke")) {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);// Updated for spoke also
			newOrderOnnnet.get().spokeSiteCustomize(Data);// MethodAdded
			newOrderOnnnet.get().EnterDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterBillingDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");

			newOrderOnnnet.get().CommercialValidation(Data); // No Change
			newOrderOnnnet.get().TechnicalValidation(Data); // Updated for spoke also
			newOrderOnnnet.get().DeliveryValidation(Data); // No Change
			newOrderOnnnet.get().OrderCompleteEthernetHubSpoke(Data);// updated same as hub
			newOrderOnnnet.get().LaunchingXNGApplication(Data);
		} else {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);
			newOrderOnnnet.get().enterMandatoryDetailsInMiddleApplet(Data);
			newOrderOnnnet.get().VoiceConfigTab(Data);
			newOrderOnnnet.get().VoiceFeatureTab(Data);
			newOrderOnnnet.get().NumberManagementTab(Data);
			newOrderOnnnet.get().EnterDateInFooter(Data);
			newOrderOnnnet.get().EnterBillingDateInFooter(Data);
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");
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
			// xng Code
			newOrderOnnnet.get().LaunchingXNGApplication(Data);

		}

	}

	@Test(dataProviderClass = DataReader.class, dataProvider = "Cancelled")
	public void Cancelled(Object[] Data) throws Exception {

		Login.get().Login("Sieble");
		// Login.get().VerifySuccessLogin("Sieble");
		// newOrderOnnnet.get().Check(Data);
		newOrderOnnnet.get().accountTabDetails(Data);
		newOrderOnnnet.get().createCustomerOrder(Data);
		newOrderOnnnet.get().productSelectionHelper(Data);
		newOrderOnnnet.get().openServiceOrderNumber();
		if (Data[8].toString().equalsIgnoreCase("Ethernet Hub")) {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);// Updated
			newOrderOnnnet.get().hubSiteCustomize(Data); // MethodAdded
			newOrderOnnnet.get().EnterDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterBillingDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");
			newOrderOnnnet.get().CommercialValidation(Data); // No Change
			newOrderOnnnet.get().TechnicalValidation(Data); // Updated
			newOrderOnnnet.get().DeliveryValidation(Data); // No Change
			newOrderOnnnet.get().OrderCompleteEthernetHubSpoke(Data); // MethodAdded
		} else if (Data[8].toString().equalsIgnoreCase("Ethernet Spoke")) {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);// Updated for spoke also
			newOrderOnnnet.get().spokeSiteCustomize(Data);// MethodAdded
			newOrderOnnnet.get().EnterDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterBillingDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2"); // Method added same as hub and updated if
																		// condition for
			// spoke

			newOrderOnnnet.get().CommercialValidation(Data); // No Change
			newOrderOnnnet.get().TechnicalValidation(Data); // Updated for spoke also
			newOrderOnnnet.get().DeliveryValidation(Data); // No Change
			newOrderOnnnet.get().OrderCompleteEthernetHubSpoke(Data);// updated same as hub
		} else {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);
			newOrderOnnnet.get().enterMandatoryDetailsInMiddleApplet(Data);
			newOrderOnnnet.get().VoiceConfigTab(Data);
			newOrderOnnnet.get().VoiceFeatureTab(Data);
			newOrderOnnnet.get().NumberManagementTab(Data);
			newOrderOnnnet.get().EnterDateInFooter(Data);
			newOrderOnnnet.get().EnterBillingDateInFooter(Data);
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");

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
			newOrderOnnnet.get().getReferenceNo(Data);// added new
			if (!Data[8].toString().equalsIgnoreCase("IP VPN Service")) {
				Cancelled.get().statusReason(Data);
				Cancelled.get().CancelOrder(Data);
				Cancelled.get().verifyOrderCancelled();
			} else {
				newOrderOnnnet.get().CompletedValidationforCancel(Data);
				Cancelled.get().statusReason(Data);
				Cancelled.get().CancelOrder(Data);
				Cancelled.get().verifyOrderCancelled();
			}
		}
	}

	/*
	 * Added below method for SiebelToXtrac flow
	 */
	@Test(dataProviderClass = DataReader.class, dataProvider = "Xtrac")
	public void SiebleToXtrac(Object[] Data) throws Exception {

		Login.get().Login("Sieble");
		// newOrderOnnnet.get().Check(Data);
		newOrderOnnnet.get().accountTabDetails(Data);
		newOrderOnnnet.get().createCustomerOrder(Data);
		newOrderOnnnet.get().productSelectionHelper(Data);
		newOrderOnnnet.get().openServiceOrderNumber();
		if (Data[8].toString().equalsIgnoreCase("Ethernet Hub")) {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);// Updated
			newOrderOnnnet.get().hubSiteCustomize(Data); // MethodAdded
			newOrderOnnnet.get().EnterDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterBillingDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");
			newOrderOnnnet.get().CommercialValidation(Data); // No Change
			newOrderOnnnet.get().validateXtrac();
			newOrderOnnnet.get().TechnicalValidation(Data); // Updated
			newOrderOnnnet.get().CircuitReferenceGeneration(Data); 
			newOrderOnnnet.get().DeliveryValidation(Data); // No Change
			newOrderOnnnet.get().openServiceOrder(Data);
			newOrderOnnnet.get().validateXtrac();
			newOrderOnnnet.get().OrderCompleteEthernetHubSpoke(Data); // MethodAdded
			newOrderOnnnet.get().openServiceOrder(Data);
			newOrderOnnnet.get().validateXtracComplete();
		} else if (Data[8].toString().equalsIgnoreCase("Ethernet Spoke")) {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);// Updated for spoke also
			newOrderOnnnet.get().spokeSiteCustomize(Data);// MethodAdded
			newOrderOnnnet.get().EnterDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterBillingDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");

			newOrderOnnnet.get().CommercialValidation(Data); // No Change
			newOrderOnnnet.get().validateXtrac();
			newOrderOnnnet.get().TechnicalValidation(Data); // Updated for spoke also
			newOrderOnnnet.get().CircuitReferenceGeneration(Data); 
			newOrderOnnnet.get().DeliveryValidation(Data); // No Change
			newOrderOnnnet.get().validateXtrac();
			newOrderOnnnet.get().OrderCompleteEthernetHubSpoke(Data);// updated same as hub
			newOrderOnnnet.get().openServiceOrder(Data);
			newOrderOnnnet.get().validateXtracComplete();
		} else {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);
			newOrderOnnnet.get().enterMandatoryDetailsInMiddleApplet(Data);
			newOrderOnnnet.get().VoiceConfigTab(Data);
			newOrderOnnnet.get().VoiceFeatureTab(Data);
			newOrderOnnnet.get().NumberManagementTab(Data);
			newOrderOnnnet.get().EnterDateInFooter(Data);
			newOrderOnnnet.get().EnterBillingDateInFooter(Data);
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");

			newOrderOnnnet.get().SelectAttachmentTab(Data);
			newOrderOnnnet.get().UploadDocument(Data);
			newOrderOnnnet.get().SelectServiceGroupTab(Data);
			newOrderOnnnet.get().OperationAttribute(Data);
			newOrderOnnnet.get().EnterInstallationChargeInFooter(Data);
			newOrderOnnnet.get().MandatoryFields(Data);
			newOrderOnnnet.get().CommercialValidation(Data);
			newOrderOnnnet.get().validateXtrac();
			newOrderOnnnet.get().TechnicalValidation(Data);
			newOrderOnnnet.get().clickOnManualValidationB();
			newOrderOnnnet.get().DeliveryValidation(Data);
			newOrderOnnnet.get().openServiceOrder(Data);
			newOrderOnnnet.get().validateXtrac();
			newOrderOnnnet.get().clickOnManualValidationA();
			newOrderOnnnet.get().getReferenceNo(Data);// added new
			newOrderOnnnet.get().CompletedValidation(Data);
			newOrderOnnnet.get().openServiceOrder(Data);
			newOrderOnnnet.get().validateXtracComplete();

		}
	}

	@Test(dataProviderClass = DataReader.class, dataProvider = "SiebelSAPData")
	public void SiebelToSap(Object[] Data) throws Exception {

		Login.get().Login("Sieble");
		//newOrderOnnnet.get().OpenServiceOrder(Data);
	    newOrderOnnnet.get().accountTabDetails(Data); 
		newOrderOnnnet.get().createCustomerOrder(Data);
		newOrderOnnnet.get().productSelectionHelper(Data);
		newOrderOnnnet.get().openServiceOrderNumber();
		if (Data[8].toString().equalsIgnoreCase("Ethernet Hub")) {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);// Updated
			newOrderOnnnet.get().hubSiteCustomize(Data); // MethodAdded
			newOrderOnnnet.get().EnterDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterBillingDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");
			newOrderOnnnet.get().CommercialValidation(Data); // No Change
			newOrderOnnnet.get().TechnicalValidation(Data); // Updated
			newOrderOnnnet.get().DeliveryValidation(Data); // No Change
			newOrderOnnnet.get().OrderCompleteEthernetHubSpoke(Data); // MethodAdded
		} else if (Data[8].toString().equalsIgnoreCase("Ethernet Spoke")) {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);// Updated for spoke also
			newOrderOnnnet.get().spokeSiteCustomize(Data);// MethodAdded
			newOrderOnnnet.get().EnterDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterBillingDateInFooter(Data); // No change
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");

			newOrderOnnnet.get().CommercialValidation(Data); // No Change
			newOrderOnnnet.get().TechnicalValidation(Data); // Updated for spoke also
			newOrderOnnnet.get().DeliveryValidation(Data); // No Change
			newOrderOnnnet.get().OrderCompleteEthernetHubSpoke(Data);// updated same as hub
		} else {
			newOrderOnnnet.get().enterMandatoryFieldsInHeader(Data);
			newOrderOnnnet.get().enterMandatoryDetailsInMiddleApplet(Data);
			newOrderOnnnet.get().VoiceConfigTab(Data);
			newOrderOnnnet.get().VoiceFeatureTab(Data);
			newOrderOnnnet.get().NumberManagementTab(Data);
			newOrderOnnnet.get().EnterDateInFooter(Data);
			newOrderOnnnet.get().EnterBillingDateInFooter(Data);
			newOrderOnnnet.get().EnterServiceChargeInFooter(Data, "2");

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
			if (Data[74].toString().equals("Offnet")) {
				newOrderOnnnet.get().CEOS_Offnet();
				newOrderOnnnet.get().LaunchingCEOSApplication(Data);
			}
			newOrderOnnnet.get().getReferenceNo(Data);
			newOrderOnnnet.get().CompletedValidation(Data);
			HashMap<Integer, HashMap<String, String>> Detail=newOrderOnnnet.get().EROData();
			newOrderOnnnet.get().WriteServiceOrderNumber(Data);
		}
	}

}