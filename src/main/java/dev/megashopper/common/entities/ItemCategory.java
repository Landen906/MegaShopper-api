package dev.megashopper.common.entities;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")

@Data
@NoArgsConstructor
public class ItemCategory {
    @Id
    @Column(name = "category_id", nullable = false, unique = true)
    private int categoryId;
    @Column(name = "category_id", nullable = false, unique = true)
    private String categoryName;
}
