package automationSolution.pageObjects;

import automationSolution.dto.Item;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;


public class InventoryPage extends BasePage {
    public void validateItemCount(Integer itemNumber) {
        $$(".inventory_item").shouldHaveSize(itemNumber);
    }

    public Item addItemToCartByIndex(Integer itemNumber) {
        Item item = getItem(itemNumber);
        item.getAddToCartButton().click();
        return item;
    }

    public String getItemNameByIndex(Integer itemNumber) {
        return $$("#inventory_container .inventory_item_name").get(itemNumber).getText();
    }

    public Integer getItemPriceByIndex(Integer itemNumber) {
        return Integer.parseInt(($$("#inventory_container .pricebar").get(itemNumber).getText()).replaceAll("\\D", ""));
    }


    public Item getItem(Integer itemNumber) {
        SelenideElement itemBlock = $$("#inventory_container div.inventory_item").get(itemNumber);
        Item item = new Item(itemBlock);
        item.setName(itemBlock.$(".inventory_item_name").getText());
        item.setDescription(itemBlock.$(".inventory_item_desc").getText());
        item.setPrice(Integer.parseInt(itemBlock.$(".inventory_item_price").getText().replaceAll("\\D", "")));
        return item;
    }

}