package dev.megashopper.controllers;

import dev.megashopper.common.dtos.*;
import dev.megashopper.common.entities.Cart;
import dev.megashopper.common.entities.Item;
import dev.megashopper.common.entities.User;
import dev.megashopper.common.repository.ItemRepository;
import dev.megashopper.common.repository.UserRepository;
import dev.megashopper.common.service.CartService;
import dev.megashopper.common.service.ItemService;
import dev.megashopper.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserService userService;

    @GetMapping(produces = "application/json", value = "/cart/items")
    public List<CartResponse> getAllItems() {
        return cartService.fetchAllItems();
    }

    @PostMapping("/cart/add/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable String itemId, @RequestHeader String token) {
        ItemResponsePayload i = itemService.findById(itemId);
        UserResponsePayload u = userService.findUserById(String.valueOf(tokenService.extractTokenDetails(token).getAuthCustomerId()));

        cartService.addItem(i.getItemId(), u.getCustomerId());
    }
    @PutMapping("/cart/remove/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeItem(@PathVariable String itemId, @RequestHeader String token) {

    }
}
