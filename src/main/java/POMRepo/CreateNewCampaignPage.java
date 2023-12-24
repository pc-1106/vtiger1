package pomRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import genericUtility.IPathConstant;

public class CreateNewCampaignPage {
	public CreateNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	private WebDriver driver;

	@FindBy(name = "campaignname")
	private WebElement campaignNameTextField;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;

	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void enterCampaignName(String campaignName) {
		campaignNameTextField.sendKeys(campaignName);
	}

	public void fillAssignedToField(String radioButtonName, String dropDownName) {
		if (radioButtonName.equals(IPathConstant.USER_KEY))
			driver.findElement(By.xpath("//input[@value='U']")).click();
		else if (radioButtonName.equals(IPathConstant.GROUP_KEY))
			driver.findElement(By.xpath("//input[@value='T']")).click();
		Select dropDown = new Select(driver.findElement(By.name("assigned_group_id")));
		dropDown.selectByVisibleText(dropDownName);
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}
}
