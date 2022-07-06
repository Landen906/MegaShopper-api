package dev.megashopper.common.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(
    name = "cart",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"item_id", "customer_id"})})
public class Cart implements Serializable {
    @Id
    @Column(name = "cart_id", nullable = false)
    private int cartId;


    @Column(name = "item_id", nullable = false)
    private int itemId;


    @Column(name = "customer_id", nullable = false)
    private int customerId;

    public Cart() {
    }

    public Cart(int cartId) {
        this.cartId = cartId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
