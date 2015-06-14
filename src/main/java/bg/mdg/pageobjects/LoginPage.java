package bg.mdg.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bg.mdg.commons.PropertiesCache;

public class LoginPage extends BasePageObject {
	private final String expectedTitle = "My.dir.bg";
	private final String errorMessage = "Грешно потребителско име или парола!";

	private final By emailTextBox = By.id(PropertiesCache.getInstance()
			.getProperty("emailInputBoxId"));
	private final By passwordTextBox = By.id(PropertiesCache.getInstance()
			.getProperty("passwordInputTextBoxId"));
	private final By loginBtn = By.id(PropertiesCache.getInstance()
			.getProperty("loginPageLoginBtnId"));
	private final By errorMsgTxt = By.cssSelector(PropertiesCache.getInstance()
			.getProperty("errorMsgTxtAreaCss"));
	private final By loggedUserArea = By.id(PropertiesCache.getInstance()
			.getProperty("loggedUserAreaId"));

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public boolean verifySignInPageTitle() {
		return getPageTitle().contains(expectedTitle);
	}

	public boolean verifyUnsuccessfulLogin(String wrongUsername,
			String wrongPassword) {
		enterUserName(wrongUsername);
		enterPassword(wrongPassword);
		clickOnLogin();
		return getErrorMessage().contains(errorMessage);
	}

	public boolean verifySuccessfulLogin(String username, String password) {
		enterUserName(username);
		enterPassword(password);
		clickOnLogin();

		waitForElementToBeDisplayed(loggedUserArea);
		WebElement element = getDriver().findElement(loggedUserArea);

		if (element.isDisplayed() && element.isEnabled()) {
			return true;
		}

		return false;
	}

	private void enterUserName(String username) {
		waitForElementToBeDisplayed(emailTextBox);
		WebElement emailTxtBox = getDriver().findElement(emailTextBox);

		emailTxtBox.sendKeys(username);
	}

	private void enterPassword(String password) {
		waitForElementToBeDisplayed(passwordTextBox);
		WebElement passwordTxtBox = getDriver().findElement(passwordTextBox);

		passwordTxtBox.sendKeys(password);
	}

	private void clickOnLogin() {
		waitForElementToBeDisplayed(loginBtn);
		WebElement loginButton = getDriver().findElement(loginBtn);

		loginButton.click();

	}

	private String getErrorMessage() {
		waitForElementToBeDisplayed(errorMsgTxt);
		WebElement errorMsg = getDriver().findElement(errorMsgTxt);

		return errorMsg.getText();
	}
}