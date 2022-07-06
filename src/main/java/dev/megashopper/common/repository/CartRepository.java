package dev.megashopper.common.repository;

import dev.megashopper.common.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository  extends JpaRepository<Cart, String> {

    @Query("select (count(c) > 0) from Cart c where c.itemId = ?1")
    boolean existsByitemId(String itemId);
    @Query("select (count(c) > 0) from Cart c where c.customerId = ?1")
    boolean existsBycustomerId(String customerId);
}
