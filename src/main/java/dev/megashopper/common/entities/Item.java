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
    @Embedded
    private ResourceMetadata metadata;

    public Item(String title, String description, BigDecimal price, int categoryId) {
        this.itemId = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
    }

    public Item(String itemId, String title, String description, BigDecimal price, int categoryId) {
        this.itemId = itemId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
        this.metadata = metadata;
    }

    public Item() {
        super();
        this.itemId = UUID.randomUUID().toString();
        this.metadata = new ResourceMetadata();
    }

    public void setItemId() {
        this.itemId = UUID.randomUUID().toString();
    }

    @Id
    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Id
    public int getCategoryId() {
        return categoryId;
    }
/*
TODO: Please read note!!
The updateWith method is a simple static factory you can use to update an item’s properties, preserving its id.
It favors immutability, making the code safer and contemporary.
RESEARCH MATERIAL: https://auth0.com/blog/spring-boot-java-tutorial-build-a-crud-api/
 */
    public Item updateWith(Item item) {
        return new Item(this.itemId, item.title, item.description, item.price, item.categoryId);
    }


}
