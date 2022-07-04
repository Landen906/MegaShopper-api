package dev.megashopper.common.repository;

import dev.megashopper.common.entities.Cart;

import dev.megashopper.common.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository  extends JpaRepository<Cart,String> {

    boolean existsByItemId(String itemId);
    boolean existsByCustomerId(String customerId);

    @Query("SELECT * FROM Items WHERE customerId = :?")
    List<Cart> findItemsByCustomerId(String customerId);

}
