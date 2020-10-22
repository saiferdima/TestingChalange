package automationSolution.dto;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Item {
    public Item(SelenideElement itemBlock) {
        addToCartButton = itemBlock.$(".inventory_item button");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SelenideElement getAddToCartButton() {
        return addToCartButton;
    }


    private String name;
    private Integer price;
    private String description;
    private final SelenideElement addToCartButton;


}
