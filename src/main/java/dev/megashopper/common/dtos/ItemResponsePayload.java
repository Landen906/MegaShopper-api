package dev.megashopper.common.dtos;

import dev.megashopper.common.entities.Item;
import dev.megashopper.common.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemResponsePayload {

    private String itemId;
    private String customerId;

    public ItemResponsePayload(Item item, User user) {
        this.itemId = item.getItemId();
        this.customerId = user.getCustomerId();
    }

    public ItemResponsePayload(Item item) {
    }
}