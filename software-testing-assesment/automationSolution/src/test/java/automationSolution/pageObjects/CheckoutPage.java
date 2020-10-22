package automationSolution.pageObjects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertEquals;

public class CheckoutPage extends BasePage {

    public void fillCheckoutData(String firstName, String LastName, String zipCode) {
        $("#first-name").setValue(firstName);
        $("#last-name").setValue(LastName);
        $("#postal-code").setValue(zipCode);
    }

    public void fillCheckoutData() {
        this.fillCheckoutData("defaultFirstName", "defaultLastName", "11111");
    }

    public void clickContinueButton() {
        $("input.btn_primary.cart_button").click();
    }

    public void verifyTotalItemPrice(Integer price) {
        Integer totalitiesPrice = Integer.parseInt($(".summary_subtotal_label").getText().replaceAll("\\D", ""));
        assertEquals(totalitiesPrice, price);
    }

    public void clickFinishButton() {
        $("a.btn_action.cart_button").click();
    }

    public void verifyThankYouMessageDisplayed() {
        $("#checkout_complete_container > h2").shouldHave(text("THANK YOU FOR YOUR ORDER"));
    }

}