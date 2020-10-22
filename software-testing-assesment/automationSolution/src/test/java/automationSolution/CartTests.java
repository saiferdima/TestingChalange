package automationSolution;

import automationSolution.dto.Item;
import automationSolution.pageObjects.CartPage;
import automationSolution.pageObjects.CheckoutPage;
import automationSolution.pageObjects.InventoryPage;
import automationSolution.pageObjects.LoginPage;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;


public class CartTests {
    LoginPage loginPage = new LoginPage();
    InventoryPage inventoryPage = new InventoryPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    String standard_user = "standard_user";
    String secret_sauce = "secret_sauce";
    String baseUrl = "https://www.saucedemo.com/index.html";

    @Test
    public void userShouldBeAbleToCreateOrder() {
        open(baseUrl);
        loginPage.login(standard_user, secret_sauce);
        inventoryPage.validateItemCount(6);
        Item item1 = inventoryPage.addItemToCartByIndex(1);
        Item item2 = inventoryPage.addItemToCartByIndex(2);
        Integer totalPrice = item1.getPrice() + item2.getPrice();
        inventoryPage.goToCart();
        cartPage.validateTotalItemsCount(2);
        cartPage.validateItemNames(item1.getName(), item2.getName());
        cartPage.clickCheckoutButton();
        checkoutPage.fillCheckoutData();
        checkoutPage.clickContinueButton();
        checkoutPage.verifyTotalItemPrice(totalPrice);
        checkoutPage.clickFinishButton();
        checkoutPage.verifyThankYouMessageDisplayed();
    }
}