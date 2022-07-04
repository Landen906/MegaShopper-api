package dev.megashopper.common.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(
    name = "cart",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"item_id", "customer_id"})})
public class Cart implements Serializable {
    @Id
    @ManyToOne
    @Column(name = "item_id", nullable = false)
    private int itemId;

    @Id
    @Column(name = "customer_id", nullable = false)
    private String customerId;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
