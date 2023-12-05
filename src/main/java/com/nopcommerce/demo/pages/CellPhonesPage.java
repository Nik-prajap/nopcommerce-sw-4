package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class CellPhonesPage extends Utility {

    By cellPhoneText = By.xpath("//h1[contains(text(),'Cell phones')]");
    By listViewTab = By.xpath("//a[contains(text(),'List')]");
    By nokiaLumia1020 = By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]");
    By nokiaLumiaText = By.xpath("//h1");
    By nokiaPriceText = By.id("price-value-20");
    By cartQuantity = By.id("product_enteredQuantity_20");
    By addToCartButton = By.id("add-to-cart-button-20");
    By productAddedToCartText = By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]");
    By closeTheBarMsg = By.xpath("//span[@title='Close']");
    By shoppingCartElement = By.xpath("//span[contains(text(),'Shopping cart')]");
    By goToCartElement = By.xpath("//button[contains(text(),'Go to cart')]");

    public String getCellPhoneText() {
        return getTextFromElement(cellPhoneText);
    }

    public void clickOnListViewTab() {
        clickOnElement(listViewTab);
    }

    public void clickOnNokiaLumia1020() {
        clickOnElement(nokiaLumia1020);
    }

    public String getNokiaLumiaText() {
        return getTextFromElement(nokiaLumiaText);
    }

    public String getNokiaPriceText() {
        return getTextFromElement(nokiaPriceText);
    }

    public void changeQuantity() {
        sendTextToElement(cartQuantity, Keys.BACK_SPACE + "2");
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCartButton);
    }

    public String getTextFromProductAddedToCart() {
        return getTextFromElement(productAddedToCartText);
    }

    public void closeTheBarByClickingOnTheCrossButton() {
        clickOnElement(closeTheBarMsg);
    }

    public void mouseHoverOnShoppingCart() {
        mouseHoverToElement(shoppingCartElement);
    }

    public void clickOnShoppingCart() {
        clickOnElement(goToCartElement);
    }

}
