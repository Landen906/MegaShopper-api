package dev.megashopper.common.entities;

import dev.megashopper.common.datasource.ResourceMetadata;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "items")

@Data
@AllArgsConstructor
public class Item {
    @Id
    @Column(name = "item_id", nullable = false, unique = true)
    private String itemId;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Column(name = "category_id", nullable = false)
    private int categoryId;
    private ResourceMetadata metadata;

    public Item(String title, String description, BigDecimal price, int categoryId) {
        this.itemId = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
    }

    public Item() {
        super();
        this.itemId = UUID.randomUUID().toString();
        this.metadata = new ResourceMetadata();
    }

    public void setItemId() {
        this.itemId = UUID.randomUUID().toString();
    }



}
