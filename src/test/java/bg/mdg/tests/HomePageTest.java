package bg.mdg.tests;

import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bg.mdg.commons.TestBaseSetup;
import bg.mdg.pageobjects.HomePage;

public class HomePageTest extends TestBaseSetup {
	private WebDriver driver;
	private HomePage homePage;

	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}

	@Test
	public void verifyHomePage() {
		homePage = new HomePage(driver);
		assertTrue(homePage.verifyBasePageTitle());
	}
}