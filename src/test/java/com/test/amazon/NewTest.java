package com.test.amazon;

import org.testng.annotations.Test;

import automation.pages.CartConfirmPage;
import automation.pages.CartPage;
import automation.pages.HomePage;
import automation.pages.ProductDisplayPage;
import automation.pages.SearchOutputPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;;

public class NewTest {
	private WebDriver driver;
	private HomePage homePage;
	private SearchOutputPage searchOutputPage;
	private ProductDisplayPage productDisplayPage;
	private CartConfirmPage cartConfirmPage;
	private CartPage cartPage;

	@Test

	public void testAddingItemToCard() {

		searchOutputPage = homePage.navigationMenu().search("Books", "cooking");

		String itemTitle = searchOutputPage.getFirstResultTitle();

		productDisplayPage = searchOutputPage.clickFirstResultTitle();

		assert (productDisplayPage.getProductTitle().equals(itemTitle));

		cartConfirmPage = productDisplayPage.addToCart();

		assert (cartConfirmPage.getConfirmationText().equals("Added to Cart"));

		cartPage = cartConfirmPage.navigationMenu().navigateToCartPage();

		assert (cartPage.getFirstItemText().contains(itemTitle));

	}

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void openHomePage() {
		homePage = new HomePage(driver).open();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
