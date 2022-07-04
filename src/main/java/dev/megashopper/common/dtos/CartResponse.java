package dev.megashopper.common.dtos;

import dev.megashopper.common.entities.Cart;
import dev.megashopper.common.entities.Item;
import dev.megashopper.common.entities.User;
import dev.megashopper.common.service.UserService;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartResponse {

    private String itemId;
    private String customerId;
    private UserService userService;

    public CartResponse(Item item, User user, UserService userService) {
        this.itemId = item.getItemId();
        this.customerId = user.getCustomerId();
        this.userService = userService;
    }

    public CartResponse(Cart cart) {

    }

    public void createCart(Cart NewCart) {
        Item item = new Item();
        this.itemId = item.getItemId();
        UserResponsePayload user = userService.findUserById(NewCart.getCustomerId());
        this.customerId = user.getCustomerId();
    }
}