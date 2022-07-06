package dev.megashopper.common.repository;

import dev.megashopper.common.entities.Item;
import dev.megashopper.common.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

    @Query("select (count(i) > 0) from Item i where i.itemId = :itemId")
    boolean existsByItemId(int itemId);
    @Query("select (count(i) > 0) from Item i where i.title = :title")
    boolean existsByTitle(String title);
   // boolean existByCategoryId(int categoryId);





}
