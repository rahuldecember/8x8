package automation.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class CartPage {

	private static final By LIST_ITEM = By.xpath(".//*[@class='a-unordered-list a-nostyle a-vertical a-spacing-mini']/li/span[@class='a-list-item']");
	private WebDriver driver;
	
	
	public CartPage(WebDriver driver) {

		this.driver = driver;

	}

	public String getFirstItemText() {

		return driver.findElement(LIST_ITEM)

				.getText();

	}

}
