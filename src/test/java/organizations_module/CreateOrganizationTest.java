package organizations_module;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.IPathConstant;
import pomRepo.CreateNewOrganizationPage;
import pomRepo.HomePage;
import pomRepo.OrganizationInformationPage;
import pomRepo.OrganizationsPage;

public class CreateOrganizationTest extends BaseClass {
	@Test
	public void createOrganizationAndVerifyInformationTest()
			throws EncryptedDocumentException, IOException, InterruptedException {
		hp = new HomePage(driver);
		hp.clickOnOrganizationsModule();
		System.out.println("the user has clicked on Organizations module");

		org = new OrganizationsPage(driver);
		org.clickOnPlusButton();
		System.out.println("the user has clicked on plus button to create organization");

		String organizationName = eUtils.fetchStringDataFromExcelFile(IPathConstant.ORGANIZATIONS_SHEET_NAME, 1, 0);

		createOrg = new CreateNewOrganizationPage(driver);
		createOrg.enterOrganizationName(organizationName);
		createOrg.clickOnSaveButton();

		orgInfo = new OrganizationInformationPage(driver);
		String actualOrganizationInfoText = orgInfo.verifyOrganizationInformationText(organizationName);

		Assert.assertTrue(actualOrganizationInfoText.contains(organizationName), "Test Failed");
		System.out.println("Test Passed");
		Thread.sleep(3000);

		orgInfo.clickOnHomePageIcon();
		System.out.println("the user has navigated to home page");
	}
}
