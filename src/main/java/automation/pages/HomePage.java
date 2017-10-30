package automation.pages;

import org.openqa.selenium.WebDriver;

import com.test.amazon.NavigationMenu;

public class HomePage {

	private WebDriver driver;
	private final NavigationMenu navigationMenu;

	private static final String AMAZON_HOME_PAGE_URL = "http://www.amazon.com";

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.navigationMenu = new NavigationMenu(driver);
	}

	public HomePage open() {
		driver.get(AMAZON_HOME_PAGE_URL);
		return this;
	}

	public NavigationMenu navigationMenu() {

		return navigationMenu;

	}

}