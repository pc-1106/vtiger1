package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewLeadPage {
	WebDriver driver;

	public CreateNewLeadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "salutationtype")
	private WebElement salutationDropDown;

	@FindBy(name = "firstname")
	private WebElement firstNameTextField;

	@FindBy(name = "lastname")
	private WebElement lastNameTextField;

	@FindBy(name = "company")
	private WebElement companyTextField;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;

	public WebElement getSalutationDropDown() {
		return salutationDropDown;
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getCompanyTextField() {
		return companyTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void selectSalutation(String salutation) {
		Select sel = new Select(salutationDropDown);
		sel.selectByVisibleText(salutation);
	}

	public void enterFirstName(String firstName) {
		firstNameTextField.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		lastNameTextField.sendKeys(lastName);
	}

	public void enterCompany(String company) {
		companyTextField.sendKeys(company);
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}
}
