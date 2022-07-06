package dev.megashopper.common.entities;

import dev.megashopper.common.datasource.ResourceMetadata;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "items")
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
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ItemCategory category;
    @Embedded
    private ResourceMetadata metadata;

    public Item() {
        super();
    }

    public Item(String title, String description, BigDecimal price, int categoryId) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = new ItemCategory(categoryId);
    }

    public Item(String id, String title, String description, BigDecimal price, int categoryId) {
        this(title, description, price, categoryId);
        this.itemId = id;
    }

     public ResourceMetadata getMetadata() {
        return metadata;
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
    public Item updateWith(Item item) {
        return new Item(this.itemId, item.title, item.description, item.price, item.categoryId);
    }

    public void setMetadata(ResourceMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", metadata=" + metadata +
                '}';
    }
}
