package pomRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class CreateNewOpportunityPage {
	public CreateNewOpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		act = new Actions(driver);
	}

	private WebDriver driver;

	private Actions act;

	@FindBy(name = "potentialname")
	private WebElement opportunityNameTextField;

	@FindBy(xpath = "//select[@id='related_to_type']/../..//img")
	private WebElement relatedToOrganizationLookUpButton;

	@FindBy(id = "search_txt")
	private WebElement organizationPopupSearchTextField;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;

	@FindBy(xpath = "//img[@id='jscal_trigger_closingdate']")
	private WebElement expectedCloseDateIcon;

	@FindBy(name = "closingdate")
	private WebElement expectedCloseDateTextField;

	public WebElement getExpectedCloseDateTextField() {
		return expectedCloseDateTextField;
	}

	public WebElement getExpectedCloseDateIcon() {
		return expectedCloseDateIcon;
	}

	public WebElement getOpportunityNameTextField() {
		return opportunityNameTextField;
	}

	public WebElement getRelatedToOrganizationLookUpButton() {
		return relatedToOrganizationLookUpButton;
	}

	public WebElement getOrganizationPopupSearchTextField() {
		return organizationPopupSearchTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void enterOpportunityName(String opportunityName) {
		opportunityNameTextField.sendKeys(opportunityName);
	}

	public void enterOrganizationDetails(String organizationName, String organizationPopupWindowTitle)
			throws InterruptedException {
		String parentPageTitle = driver.getTitle();
		relatedToOrganizationLookUpButton.click();

		WebDriverUtility wUtils = new WebDriverUtility();
		wUtils.switchToWindow(driver, organizationPopupWindowTitle);

		organizationPopupSearchTextField.sendKeys(organizationName);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText(organizationName)).click();

		wUtils.switchToWindow(driver, parentPageTitle);
	}

	public void enterExpectedCloseDate(int year, String month, int date) {
		expectedCloseDateIcon.click();
		while (true) {
			String text = driver.findElement(By.xpath("//td[@class='title']")).getText();
			String[] arr = text.split(",");
			String monthDisplayed = arr[0];
			int yearDisplayed = Integer.parseInt(arr[1].substring(1));
			if (monthDisplayed.equals(month) && yearDisplayed == year)
				break;
			else
				driver.findElement(By.xpath("//td[text()='‹']")).click();
		}
		driver.findElement(By.xpath("//td[text()='" + date + "']")).click();
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}
}
