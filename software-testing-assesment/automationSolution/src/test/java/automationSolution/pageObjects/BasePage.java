package automationSolution.pageObjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class BasePage {
    public void goToCart() {
        $(".shopping_cart_container").click();
    }
}