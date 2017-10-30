package automation.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import com.test.amazon.NavigationMenu;

public class CartConfirmPage {

	private static final By CONFIRM_TEXT_FIELD = By.id("huc-v2-order-row-confirm-text");

	private final NavigationMenu navigationMenu;
	private WebDriver driver;
	


	public CartConfirmPage(WebDriver driver) {

		this.driver = driver;

		this.navigationMenu = new NavigationMenu(driver);

	}

	public String getConfirmationText() {

		return driver.findElement(CONFIRM_TEXT_FIELD)

				.getText();


	}

	public NavigationMenu navigationMenu() {

		return navigationMenu;

	}

}
