package automationSolution.pageObjects;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class CartPage extends BasePage {

    public void validateItemsCount(Integer itemNumber) {
        $$(".cart_item").shouldHaveSize(itemNumber);
    }

    public void validateItemNames(String... listOfNames) {
        $$(".cart_item .inventory_item_name").shouldHave(texts(listOfNames));

    }

    public void clickCheckoutButton(String... listOfNames) {
        $("a.btn_action.checkout_button").click();

    }




}