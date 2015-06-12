package bg.mdg.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import bg.mdg.commons.TestBaseSetup;
import bg.mdg.pageobjects.HomePage;
import bg.mdg.pageobjects.LoginPage;

public class LoginPageTest extends TestBaseSetup {
	private WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;

	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}

	@Parameters({ "username", "password" })
	@Test
	public void verifySuccessfulLogin(String username, String password) {
		System.out.println("Sign In functionality details...");
		homePage = new HomePage(driver);
		loginPage = homePage.clickLoginBtn();
		
		Assert.assertTrue(loginPage.verifySuccessfulLogin(username, password),
				"Unable to login");
	}
	
	@Parameters({ "wrongUsername", "wrongPassword" })
	@Test
	public void verifyUnsuccessfulLogin(String wrongUsername,
			String wrongPassword) {
		System.out.println("Sign In functionality details...");
		homePage = new HomePage(driver);
		loginPage = homePage.clickLoginBtn();

		Assert.assertTrue(
				loginPage.verifyUnsuccessfulLogin(wrongUsername, wrongPassword),
				"Unable to login");
	}
}