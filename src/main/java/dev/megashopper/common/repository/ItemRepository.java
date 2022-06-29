package dev.megashopper.common.repository;

import dev.megashopper.common.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

    boolean existsByItemId(String itemId);
    boolean existsByTitle(String title);
    boolean existByCategoryId(String categoryId);
}
