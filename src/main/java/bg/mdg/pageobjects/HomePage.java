package bg.mdg.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePageObject {
	private final String expectedPageTitle = "Dir.bg - Българският Интернет портал!";

	private final By loginBtn = By.cssSelector("#lenta-login a");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public LoginPage clickLoginBtn() {
		System.out.println("Clicking on login button");
		waitForElementToBeDisplayed(loginBtn, 15);
		WebElement loginBtnBtnElement = driver.findElement(loginBtn);

		if (loginBtnBtnElement.isDisplayed()) {
			loginBtnBtnElement.click();
		} else {
			System.out.println("Element not found");
		}

		return PageFactory.initElements(driver, LoginPage.class);
	}

	public boolean verifyBasePageTitle() {
		return getPageTitle().contains(expectedPageTitle);
	}
}