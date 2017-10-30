package stepDefinition;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import automation.pages.CartConfirmPage;
import automation.pages.CartPage;
import automation.pages.HomePage;
import automation.pages.ProductDisplayPage;
import automation.pages.SearchOutputPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps {
	private WebDriver driver;
	private HomePage homePage;

	private SearchOutputPage searchOutputPage;
	private ProductDisplayPage productDisplayPage;
	private CartConfirmPage cartConfirmPage;
	private CartPage cartPage;

	String itemTitle;

	@Before
	public void setup() {
		// System.setProperty("webdriver.chrome.driver",
		// "/Users/raggarwal/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage = new HomePage(driver).open();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Given("^a web browser is on the Amazon Home page$")
	public void a_Web_Browser_Is_On_The_Amazon_Home_Page() throws Throwable {
		System.out.println("User is on Home Screen");
	}



	@When("^User searches for books in Category \"(.*)\" having  \"(.*)\" Text.$")
	public void setSearchParameters(String bookCategory, String bookName) throws ClientProtocolException, IOException {
		searchOutputPage = homePage.navigationMenu().search(bookCategory, bookName);
	}

	@When("^the user clicks the first result link$")
	public void click_First_Search_Result() throws Throwable {

		itemTitle = searchOutputPage.getFirstResultTitle();

		productDisplayPage = searchOutputPage.clickFirstResultTitle();

	}

	@When("^Verify Product Title$")
	public void verify_Product_Title() throws Throwable {

		assert (productDisplayPage.getProductTitle().equals(itemTitle));

	}

	@Then("^Product Added To Cart$")
	public void product_Added_To_Cart() throws Throwable {

		assert (cartConfirmPage.getConfirmationText().equals("Added to Cart"));

		cartPage = cartConfirmPage.navigationMenu().navigateToCartPage();

	}

	@Then("^Titles verified Successfully$")
	public void message_Titles_verified_Successfully() throws Throwable {
		assert (cartPage.getFirstItemText().contains(itemTitle));
		System.out.println("Result Displayed Successfully");

	}



	@When("^Add Product To Cart$")
	public void add_Product_To_Cart() throws Throwable {

		cartConfirmPage = productDisplayPage.addToCart();

	}



}
