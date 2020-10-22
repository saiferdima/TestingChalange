package automationSolution;

import automationSolution.pageObjects.CartPage;
import automationSolution.pageObjects.CheckoutPage;
import automationSolution.pageObjects.InventoryPage;
import automationSolution.pageObjects.LoginPage;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.CollectionCondition.texts;

public class FirstTest {
    
    @Test
    public void userShouldBeAbleToCreateOrder() {
        open("https://www.saucedemo.com/index.html");
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.validateItemNumber(6);
        inventoryPage.addItemToCartByNumber(0);
        inventoryPage.addItemToCartByNumber(1);
        String firstItemName = inventoryPage.getItemNameByNumber(0);
        String secondItemName = inventoryPage.getItemNameByNumber(1);
        Integer firstItemPrice = inventoryPage.getItemPriceByNumber(0);
        Integer secondItemPrice = inventoryPage.getItemPriceByNumber(1);
        Integer totalPrice = firstItemPrice + secondItemPrice;
        inventoryPage.goToCart();
        CartPage cartPage = new CartPage();
        cartPage.validateItemsCount(2);
        cartPage.validateItemNames(firstItemName, secondItemName);
        cartPage.clickCheckoutButton();
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.fillCheckoutData();
        checkoutPage.clickContinueButton();
        checkoutPage.verifyTotalItemPrice(totalPrice);
        checkoutPage.clickFinishButton();
        checkoutPage.verifyThankYouMessageDisplayed();
    }
}