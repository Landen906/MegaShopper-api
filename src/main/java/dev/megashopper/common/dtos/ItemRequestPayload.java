package dev.megashopper.common.dtos;

import dev.megashopper.common.entities.Item;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ItemRequestPayload {
    @NotNull
    private String itemId;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private BigDecimal price;
    @NotNull
    private int categoryId;

    public Item extractResource() {
        if (itemId == null)
            return new Item(title, description, price, categoryId);
        return new Item(itemId, title, description, price, categoryId);
    }
}
