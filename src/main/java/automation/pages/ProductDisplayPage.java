package automation.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class ProductDisplayPage {

   private static final By PRODUCT_TITLE_FIELD = By.id("productTitle");

   private static final By ADD_TO_CART_BUTTON = By.id("add-to-cart-button");

   private WebDriver driver;


   public ProductDisplayPage(WebDriver driver) {

      this.driver = driver;

   }

 

   public String getProductTitle() {

      return driver.findElement(PRODUCT_TITLE_FIELD)

            .getText();

   }

 

   public CartConfirmPage addToCart() {

      driver.findElement(ADD_TO_CART_BUTTON)

            .click();

      return new CartConfirmPage(driver);

   }

}

