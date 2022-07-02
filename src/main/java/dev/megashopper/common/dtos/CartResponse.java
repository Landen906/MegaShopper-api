package dev.megashopper.common.dtos;

import dev.megashopper.common.entities.Cart;
import dev.megashopper.common.entities.Item;
import dev.megashopper.common.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartResponse {

    private String itemId;
    private String customerId;

    public CartResponse(Item item, User user) {
        this.itemId = item.getItemId();
        this.customerId = user.getCustomerId();
    }

    public CartResponse(Cart cart) {

    }

    public void createCart(Cart NewCart) {
        Item item = new Item();
        this.itemId = item.getItemId();
        User user = new User();
        this.customerId = user.getCustomerId();
    }
}