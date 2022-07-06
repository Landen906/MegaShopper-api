package dev.megashopper.common.service;

import dev.megashopper.common.dtos.CartResponse;
import dev.megashopper.common.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
     
}
