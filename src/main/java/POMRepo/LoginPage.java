package POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	@FindBy(name = "user_name")
	WebElement username_text_field;

	@FindBy(name = "user_password")
	WebElement password_text_field;

	@FindBy(id = "submitButton")
	WebElement login_button;

	LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginAction(String username, String password) {
		username_text_field.sendKeys(username);
		password_text_field.sendKeys(password);
		login_button.click();
	}
}
