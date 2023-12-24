package opportunities_module;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.IPathConstant;
import pomRepo.CreateNewOpportunityPage;
import pomRepo.HomePage;
import pomRepo.OpportunitiesPage;
import pomRepo.OpportunityInformationPage;

public class CreateOpportunityTest extends BaseClass {
	@Test
	public void createOpportunityAndVerifyTest() throws EncryptedDocumentException, IOException, InterruptedException {
		hp = new HomePage(driver);
		hp.clickOnOpportunitiesModule();
		System.out.println("the user has navigated Opportunities module");

		oppPage = new OpportunitiesPage(driver);
		oppPage.clickOnPlusButton();
		System.out.println("the user has clicked on create opportunity 'plus' button");

		String opportunityName = eUtils.fetchStringDataFromExcelFile(IPathConstant.OPPORTUNITIES_SHEET_NAME, 1, 0);
		String organizationName = eUtils.fetchStringDataFromExcelFile(IPathConstant.OPPORTUNITIES_SHEET_NAME, 3, 0);
		String organizationPopupTitlePartial = eUtils
				.fetchStringDataFromExcelFile(IPathConstant.OPPORTUNITIES_SHEET_NAME, 3, 1);
		int year = eUtils.fetchNumericDataFromExcelFile(IPathConstant.OPPORTUNITIES_SHEET_NAME, 5, 1);
		String month = eUtils.fetchStringDataFromExcelFile(IPathConstant.OPPORTUNITIES_SHEET_NAME, 5, 2);
		int date = eUtils.fetchNumericDataFromExcelFile(IPathConstant.OPPORTUNITIES_SHEET_NAME, 5, 3);

		createOpportunity = new CreateNewOpportunityPage(driver);
		createOpportunity.enterOpportunityName(opportunityName);
		createOpportunity.enterOrganizationDetails(organizationName, organizationPopupTitlePartial);
		createOpportunity.enterExpectedCloseDate(year, month, date);
		System.out.println(createOpportunity.getExpectedCloseDateTextField().getAttribute("value"));
		createOpportunity.clickOnSaveButton();
		System.out.println("the user has saved opportunity details");

		opportunityInfo = new OpportunityInformationPage(driver);
		String actualText = opportunityInfo.verifyOpportunityInformationText(opportunityName);
		System.out.println("actual opportunity information text: " + actualText);

		Assert.assertTrue(actualText.contains(opportunityName), "Test Failed");
		System.out.println("Test Passed");
		Thread.sleep(3000);

		opportunityInfo.clickOnHomeIcon();
		System.out.println("the user has navigated to home screen");
	}
}
