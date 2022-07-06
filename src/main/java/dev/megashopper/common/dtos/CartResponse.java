package dev.megashopper.common.dtos;

import dev.megashopper.common.entities.Cart;
import dev.megashopper.common.entities.Item;
import dev.megashopper.common.entities.User;
import dev.megashopper.common.service.UserService;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CartResponse {

    private List<Item> items;
    private String customerId;
    private UserService userService;


    public CartResponse(Cart cart) {
        this.customerId = cart.getCustomerId();
    }

//    public void createCart(User user) {
//        Item item = new Item();
//        this.itemId = item.getItemId();
//        UserResponsePayload user = userService.findUserById(NewCart.getCustomerId());
//        this.customerId = user.getCustomerId();
//    }
    public void createCart(Cart cart) {
        this.items = cart.getItems();
        this.customerId = cart.getCustomerId();
    }
}