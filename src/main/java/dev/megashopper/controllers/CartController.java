package dev.megashopper.controllers;

import dev.megashopper.common.dtos.CartResponse;
import dev.megashopper.common.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(produces = "application/json")
    public List<CartResponse> getAllItems() {
        return cartService.fetchAllItems();
    }

}
