package dev.megashopper.common.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")

public class Cart {
    @Id
    @Column(name = "item_id", nullable = false, unique = true)
    private int itemId;

    @Id
    @Column(name = "customer_id", nullable = false, unique = true)
    private int customerId;

}
