package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElectronicTest extends TestBase {

    ElectronicsPage electronicsPage = new ElectronicsPage();
    ElectronicsPage logIn = new ElectronicsPage();
    CellPhonesPage cellPhonesPage = new CellPhonesPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    RegisterPage registerPage = new RegisterPage();
    CheckOutPage checkOutPage = new CheckOutPage();

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //1.1 Mouse Hover on “Electronics” Tab.

        electronicsPage.hoverOnElectronics();
        //1.2 MouseHover and click on “Cell phones”.
        electronicsPage.hoverOnCellPhoneAndClick();

        //1.3 Verify the “Cell phones” text
        String actualText = cellPhonesPage.getCellPhoneText();
        Assert.assertEquals(actualText, "Cell phones", "Text not Displayed");

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

        //2.1 MouseHover on “Electronics” Tab
        electronicsPage.hoverOnElectronics();

        //2.2 MouseHover and click on “Cell phones”
        electronicsPage.hoverOnCellPhoneAndClick();

        //2.3 Verify the “Cell phones” text
        String actualText = cellPhonesPage.getCellPhoneText();
        Assert.assertEquals(actualText, "Cell phones", "Text not Displayed");

        //2.4 Click on List View Tab
        cellPhonesPage.clickOnListViewTab();

        //2.5 Click on product name “Nokia Lumia 1020”
        cellPhonesPage.clickOnNokiaLumia1020();
        Thread.sleep(1000);

        //2.6 Verify text “Nokia Lumia 1020” displayed
        String actualNokiaLumiaText = cellPhonesPage.getNokiaLumiaText();
        Assert.assertEquals(actualNokiaLumiaText, "Nokia Lumia 1020", "Text not Displayed");

        //2.7 Verify price amount “$349.00”
        String actualNokiaPriceText = cellPhonesPage.getNokiaPriceText();
        Assert.assertEquals(actualNokiaPriceText, "$349.00", "Text not Displayed");

        //2.8 Change quantity to 2
        cellPhonesPage.changeQuantity();

        //2.9 Click on “ADD TO CART” Tab
        cellPhonesPage.clickOnAddToCartButton();

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green bar After that close the bar clicking on the cross button.
        String actualTextShoppingCart = cellPhonesPage.getTextFromProductAddedToCart();
        Assert.assertEquals(actualTextShoppingCart, "The product has been added to your shopping cart", "Text not Displayed");
        cellPhonesPage.closeTheBarByClickingOnTheCrossButton();

        //2.11 MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        cellPhonesPage.mouseHoverOnShoppingCart();
        cellPhonesPage.clickOnShoppingCart();

        //2.12 Verify message "Shopping cart" displayed
        String actualShoppingCartMessage = shoppingCartPage.getShoppingCartText();
        Assert.assertEquals(actualShoppingCartMessage, "Shopping cart", "error");
        Thread.sleep(2000);

        //2.13 Verify quantity is 2
        String actualQuantity = shoppingCartPage.getVerifyQuantity();
        Assert.assertEquals(actualQuantity, "(2)", "Error");

        //2.14 Verify Total amount $698.00
        String actualTotal = shoppingCartPage.getVerifyTotal();
        Assert.assertEquals(actualTotal, "$698.00", "Error");

        //2.15 click on “I agree with the terms of service” Checkbox
        shoppingCartPage.clickOnTermsOfServiceCheckBox();

        //2.16 Click on “CHECKOUT” Tab
        shoppingCartPage.clickOnCheckOutButton();

        //2.17 Verify the “Welcome, Please Sign In!” text
        String actualWelcomeText = electronicsPage.getWelcomePageSignInText();
        Assert.assertEquals(actualWelcomeText, "Welcome, Please Sign In!", "Error");

        //2.18 Click on “REGISTER” Tab
        registerPage.clickOnRegisterButton1();

        //2.19 Verify the “Register” text
        String actualRegisterText = registerPage.getRegisterText();
        Assert.assertEquals(actualRegisterText, "Register", "Error");

        //2.20 Fill the mandatory fields
        registerPage.inputFirstname("Jayendrabhai");
        registerPage.inputLastname("Patel");
        registerPage.inputEmail("PrimeTesting0011@gmail.com");
        registerPage.inputPassword("PrimeTest123");
        registerPage.inputConfirmPassword("PrimeTest1234");

        //2.21 Click on “REGISTER” Button
        registerPage.clickOnRegisterButton();

        //2.22 Verify the message “Your registration completed”
        String actualRegisterSuccessMessage = registerPage.getRegisterSuccessText();
        Assert.assertEquals(actualRegisterSuccessMessage, "Your registration completed", "error");

        //2.23 Click on “CONTINUE” tab
        registerPage.clickOnContinueButton();

        sendTextToElement(By.xpath("//input[@id='Email']"), "PrimeTesting0011@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"), "PrimeTest123");
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

        //2.24 Verify the text “Shopping card”
        String expectedText1 = "Shopping cart";
        String actualText1 = shoppingCartPage.getShoppingCartText();
        Assert.assertEquals(actualText1, expectedText1);

        //2.25 click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnTermsOfServiceCheckBox();

        //2.26 Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckOutButton();

        //2.27 Fill the Mandatory fields
        checkOutPage.inputFirstname("Jayendrabhai");
        checkOutPage.inputLastname("Patel");
        checkOutPage.inputEmail("PrimeTesting0011@gmail.com");
        checkOutPage.selectCountry("United Kingdom");
        checkOutPage.inputCity("London");
        checkOutPage.inputAddress1("BUCKINGHAM PALACE");
        checkOutPage.inputPostCode("SW1A 1AA");
        checkOutPage.inputPhoneNumber("07999999999");

        //2.28 Click on “CONTINUE”
        Thread.sleep(5000);
        checkOutPage.clickOnContinueButton();

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        checkOutPage.clickOnRadioButton2ndDayAir();

        // 2.30 Click on “CONTINUE”
        checkOutPage.clickOnContinueButton1();

        // 2.31 Select Radio Button “Credit Card”
        checkOutPage.clickOnCreditCard();
        checkOutPage.clickOnPaymentContinueButton();

        // 2.32 Select “Visa” From Select credit card dropdown
        checkOutPage.selectCreditCard("MasterCard");

        //2.33 Fill all the details
        checkOutPage.inputCardHolderName("Mr Jayendrabhai Patel");
        checkOutPage.inputCardNumber("3550 5330 3005 0055 33");
        checkOutPage.selectExpireMonth("12");
        checkOutPage.selectExpireYear("2026");
        checkOutPage.inputCardCode("098");

        //2.34 Click on CONTINUE CHECKOUT
        checkOutPage.clickOnContinueButton2();

        // 2.35 Verify “Payment Method” is “Credit Card”
        String actualCreditCardMessage = checkOutPage.getCreditCardText();
        Assert.assertEquals(actualCreditCardMessage, "Credit Card", "error");

        // 2.36 Verify “Shipping Method” is “2nd Day Air”
        String actual02DayMessage = checkOutPage.get02ndDayText();
        Assert.assertEquals(actual02DayMessage, "2nd Day Air", "error");

        // 2.37 Verify Total is “$698.00”
        String actualTotalAmountNokiaMessage = checkOutPage.getTotalAmountNokiaText();
        Assert.assertEquals(actualTotalAmountNokiaMessage, "$698.00", "error");

        // 2.38 Click on “CONFIRM”
        checkOutPage.clickOnConfirmButton();

        //2.39 Verify the Text “Thank You”
        String actualThankYouMessage = checkOutPage.getThankYouText();
        Assert.assertEquals(actualThankYouMessage, "Thank you", "error");

        //2.40 Verify the message “Your order has been successfully processed!”
        String actualOrderSuccessProcessedMessage = checkOutPage.getOrderSuccessProcessText();
        Assert.assertEquals(actualOrderSuccessProcessedMessage, "Your order has been successfully processed!", "error");

        // 2.41 Click on “CONTINUE”
        checkOutPage.clickOnContinueButton3();

        // 2.42 Verify the text “Welcome to our store”
        String actualWelcomeOurStoreMessage = electronicsPage.getWelcomeOurStoreText();
        Assert.assertEquals(actualWelcomeOurStoreMessage, "Welcome to our store", "error");

        // 2.43 Click on “Logout” link
        electronicsPage.clickOnLogOutButton();

        // 2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://demo.nopcommerce.com/", "error");
    }

}
