package bg.mdg.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bg.mdg.commons.PropertiesCache;

public class LoginPage extends BasePageObject {
	private final String expectedTitle = "My.dir.bg";
	private final String errorMessage = "Грешно потребителско име или парола!";

	private final By emailTextBox = By.id(PropertiesCache.getInstance().getProperty("emailInputBoxId"));
	private final By passwordTextBox = By.id(PropertiesCache.getInstance().getProperty("passwordInputTextBoxId"));
	private final By loginBtn = By.id(PropertiesCache.getInstance().getProperty("loginPageLoginBtnId"));
	private final By errorMsgTxt = By.cssSelector(PropertiesCache.getInstance().getProperty("errorMsgTxtAreaCss"));
	private final By loggedUserArea = By.id(PropertiesCache.getInstance().getProperty("loggedUserAreaId"));

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
		WebElement element = driver.findElement(loggedUserArea);

		if (element.isDisplayed() && element.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

	private void enterUserName(String username) {
		WebElement emailTxtBox = driver.findElement(emailTextBox);
		if (emailTxtBox.isDisplayed() && emailTxtBox.isEnabled()) {
			emailTxtBox.sendKeys(username);
		}
	}

	private void enterPassword(String password) {
		WebElement passwordTxtBox = driver.findElement(passwordTextBox);
		if (passwordTxtBox.isDisplayed() && passwordTxtBox.isEnabled()) {
			passwordTxtBox.sendKeys(password);
		}
	}

	private void clickOnLogin() {
		WebElement loginButton = driver.findElement(loginBtn);
		if (loginButton.isDisplayed() && loginButton.isEnabled()) {
			loginButton.click();
		}
	}

	private String getErrorMessage() {
		String strErrorMsg = null;
		WebElement errorMsg = driver.findElement(errorMsgTxt);
		if (errorMsg.isDisplayed() && errorMsg.isEnabled()) {
			strErrorMsg = errorMsg.getText();
		}
		return strErrorMsg;
	}
}