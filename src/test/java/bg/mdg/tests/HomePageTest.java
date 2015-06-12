package bg.mdg.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bg.mdg.commons.TestBaseSetup;
import bg.mdg.pageobjects.HomePage;

public class HomePageTest extends TestBaseSetup {

	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}

	@Test
	public void verifyHomePage() {
		System.out.println("Home page test...");
		HomePage basePage = new HomePage(driver);
		Assert.assertTrue(basePage.verifyBasePageTitle(),
				"Home page title doesn't match");
	}
}