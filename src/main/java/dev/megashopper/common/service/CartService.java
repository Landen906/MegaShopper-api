package dev.megashopper.common.service;

import dev.megashopper.common.dtos.*;
import dev.megashopper.common.entities.Cart;
import dev.megashopper.common.entities.Item;
import dev.megashopper.common.entities.User;
import dev.megashopper.common.repository.CartRepository;
import dev.megashopper.common.utils.exceptions.ItemNotFoundException;
import dev.megashopper.common.utils.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CartService {

    @Autowired
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    public List<CartResponse> fetchAllItems() {
        return cartRepository.findAll()
                .stream()
                .map(CartResponse::new)
                .collect(Collectors.toList());
    }
    public ResourceCreationResponse addItem(ItemRequestPayload itemRequest, UserRequestPayload userRequest) {
        Item item = itemRequest.extractResource();
        User user = userRequest.extractResource();
        Cart cart = cartRepository.findById(user.getCustomerId()).get();
        cart.addItems(item);

        cartRepository.save(cart);
        return new ResourceCreationResponse(cart.getCustomerId());
    }
    public void removeItem(ItemRequestPayload itemRequestPayload, UserRequestPayload userRequestPayload) {
        Item item = itemRequestPayload.extractResource();
        User user = userRequestPayload.extractResource();

        Cart cart = cartRepository.findById(user.getCustomerId()).get();
        if (!cartRepository.existsByItemId(item.getItemId()))
            throw new ItemNotFoundException("Cart does not contain this item");
        cart.removeItem(item);
        cartRepository.save(cart);
    }
}
