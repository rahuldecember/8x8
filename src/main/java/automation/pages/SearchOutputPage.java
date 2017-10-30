package automation.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchOutputPage {

	private static final By SEARCH_RESULT_ITEM_TITLE = By.className("s-access-title");

	private WebDriver driver;

	
	
	public SearchOutputPage(WebDriver driver) {

		this.driver = driver;

	}

	public String getFirstResultTitle() {

		return driver.findElement(SEARCH_RESULT_ITEM_TITLE)

				.getText();
		
	}

	public ProductDisplayPage clickFirstResultTitle() {

		driver.findElement(SEARCH_RESULT_ITEM_TITLE)

				.click();
		return new ProductDisplayPage(driver);

	}
	
	   public List<String> getResultTitles() {
	        return driver.findElements(SEARCH_RESULT_ITEM_TITLE).stream()
	                .map(element -> element.getText())
	                .collect(Collectors.toList());
	    }

}
