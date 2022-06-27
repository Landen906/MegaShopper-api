package dev.megashopper.common.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "items")

@Data
@NoArgsConstructor
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
}
