package dev.megashopper.common.entities;

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
    @Column(name = "category_id", nullable = false)
    private int categoryId;

    public Item() {
    }

    public Item(String title, String description, BigDecimal price, int categoryId) {
        this.itemId = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId.toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", categoryId=" + categoryId +
                '}';
    }
}
