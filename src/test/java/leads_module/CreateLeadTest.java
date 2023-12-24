package leads_module;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.IPathConstant;
import pomRepo.CreateNewLeadPage;
import pomRepo.HomePage;
import pomRepo.LeadInformationPage;
import pomRepo.LeadPage;

public class CreateLeadTest extends BaseClass {
	@Test
	public void createLeadAndVerifyInformationTest() throws EncryptedDocumentException, IOException {
		hp = new HomePage(driver);
		hp.clickOnLeadsModule();
		System.out.println("the user has navigated to Leads module");
		createLead = new CreateNewLeadPage(driver);

		lead = new LeadPage(driver);
		lead.clickOnPlusButton();

		String salutation = eUtils.fetchStringDataFromExcelFile(IPathConstant.LEADS_SHEET_NAME, 1, 0);
		String firstName = eUtils.fetchStringDataFromExcelFile(IPathConstant.LEADS_SHEET_NAME, 1, 1);
		String lastName = eUtils.fetchStringDataFromExcelFile(IPathConstant.LEADS_SHEET_NAME, 1, 2);
		String company = eUtils.fetchStringDataFromExcelFile(IPathConstant.LEADS_SHEET_NAME, 1, 3);

		createLead.selectSalutation(salutation);
		createLead.enterFirstName(firstName);
		createLead.enterLastName(lastName);
		createLead.enterCompany(company);
		createLead.clickOnSaveButton();

		leadInfo = new LeadInformationPage(driver);

		String actualLeadInformationText = leadInfo.verifyLeadInformationText(lastName);
		System.out.println("Lead Information Text: " + actualLeadInformationText);

		Assert.assertTrue(actualLeadInformationText.contains(lastName), "Test Failed");
		System.out.println("Test Passed");

		leadInfo.clickOnHomePageIcon();
		System.out.println("the user has navigated to home screen");
	}
}
