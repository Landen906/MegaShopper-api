package dev.megashopper.common.entities;

import dev.megashopper.common.repository.CartRepository;
import dev.megashopper.common.repository.ItemRepository;
import dev.megashopper.common.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(
        name = "cart",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"item_id", "customer_id"})})
public class Cart implements Serializable {
    @Autowired
    public Cart(CartRepository cartRepository) {
        super();
        this.items = new ArrayList<>();
    }

    @ManyToOne
    @JoinTable(name = "items")
    private List<Item> items;

    @Id
    @Column(name = "customer_id", nullable = false)
    private String customerId;

//    public int getItemId() {
//        return itemId;
//    }
//
//    public void setItemId(int itemId) {
//        this.itemId = itemId;
//    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItems(Item... items) {
        if (this.items == null)
            this.items = new ArrayList<>();
        this.items.addAll(Arrays.asList(items));
    }

    public void removeItem(Item... items) {
        this.items.removeAll(Arrays.asList(items));
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
