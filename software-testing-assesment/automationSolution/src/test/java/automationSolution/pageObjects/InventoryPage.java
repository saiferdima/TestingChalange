package automationSolution.pageObjects;

import static com.codeborne.selenide.Selenide.*;


public class InventoryPage extends BasePage {
    public void validateItemNumber(Integer itemNumber) {
        $$(".inventory_item").shouldHaveSize(itemNumber);
    }

    public void addItemToCartByNumber(Integer itemNumber) {
        $$("#inventory_container .inventory_item button").get(itemNumber).click();
    }

    public String getItemNameByNumber(Integer itemNumber) {
        return $$("#inventory_container .inventory_item_name").get(itemNumber).getText();
    }

    public Integer getItemPriceByNumber(Integer itemNumber) {
        return Integer.parseInt(($$("#inventory_container .pricebar").get(itemNumber).getText()).replaceAll("\\D", ""));
    }


}