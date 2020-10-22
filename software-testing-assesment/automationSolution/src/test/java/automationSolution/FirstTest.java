package automationSolution;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FirstTest {
    @Test
    public void firstTry(){
        open("https://www.saucedemo.com/index.html");
        $(By.id("user-name")).setValue("standard_user");
        $(By.id("password")).setValue("secret_sauce").pressEnter();
        $$(".inventory_item").shouldHaveSize(6);
        $$("#inventory_container .inventory_item button").get(0).click();
        $$("#inventory_container .inventory_item button").get(1).click();
        var firstItemName = $$("#inventory_container .inventory_item_name").get(0).getText();
        var firstItemPrice = Integer.parseInt( ($$("#inventory_container .pricebar").get(0).getText()).replaceAll("\\D", ""));
        var secondItemName = $$("#inventory_container .inventory_item_name").get(1).getText();
        var secondItemPrice = Integer.parseInt( ($$("#inventory_container .pricebar").get(1).getText()).replaceAll("\\D", ""));
        $(".shopping_cart_container").click();
        $$(".cart_item").shouldHaveSize(2);
        var firstValueInBasket = $$(".cart_item .inventory_item_name").get(0).getText();
        var secondValueInBasket = $$(".cart_item .inventory_item_name").get(1).getText();
        assertEquals(firstItemName,firstValueInBasket);
        assertEquals(secondItemName,secondValueInBasket);
        //click checkut
        //fill data
        //assert price
        //click finish
        //verify thank you page
    }
}