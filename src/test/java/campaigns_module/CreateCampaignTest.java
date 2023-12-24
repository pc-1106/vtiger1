package campaigns_module;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.IPathConstant;
import pomRepo.CampaignInformationPage;
import pomRepo.CampaignsPage;
import pomRepo.CreateNewCampaignPage;
import pomRepo.HomePage;

public class CreateCampaignTest extends BaseClass {
	@Test
	public void createNewCampaignAndVerifyTest() throws EncryptedDocumentException, IOException, InterruptedException {
		hp = new HomePage(driver);
		hp.clickOnCampaignsModule();
		System.out.println("the user has navigated to Campaigns page");

		campaign = new CampaignsPage(driver);
		campaign.clickOnPlusButton();
		System.out.println("the user has clicked on create campaign plus icon");

		String campaignName = eUtils.fetchStringDataFromExcelFile(IPathConstant.CAMPAIGNS_SHEET_NAME, 1, 0);
		String radioButtonName = eUtils.fetchStringDataFromExcelFile(IPathConstant.CAMPAIGNS_SHEET_NAME, 3, 0);
		String dropDownName = eUtils.fetchStringDataFromExcelFile(IPathConstant.CAMPAIGNS_SHEET_NAME, 3, 1);

		createCampaign = new CreateNewCampaignPage(driver);
		createCampaign.enterCampaignName(campaignName);
		createCampaign.fillAssignedToField(radioButtonName, dropDownName);
		createCampaign.clickOnSaveButton();
		System.out.println("the user has entered campaign details and clicked on save button");

		campaignInfo = new CampaignInformationPage(driver);
		String actualCampaignInfoText = campaignInfo.verifyCampaignInformationText(campaignName);
		System.out.println("Campaign Information Text: " + actualCampaignInfoText);

		Assert.assertTrue(actualCampaignInfoText.contains(campaignName), "Test Failed");
		System.out.println("Test Passed");

		Thread.sleep(3000);

		campaignInfo.clickOnHomeIcon();
		System.out.println("the user has navigated back to home page");
	}
}
