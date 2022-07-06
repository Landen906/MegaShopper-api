package dev.megashopper.common.repository;

import dev.megashopper.common.entities.Cart;
import dev.megashopper.common.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository  extends JpaRepository<Cart,String> {
    @Query("select (count(c) > 0) from Cart c where c.itemId = ?1")
    boolean existsByItemId(String itemId);

    @Query("select (count(c) > 0) from Cart c where c.customerId = ?1")
    boolean existsByCustomerId(String customerId);

    @Query("SELECT * FROM Items WHERE customerId = :?")
    List<Item> findItemsByCustomerId(String customerId);
}